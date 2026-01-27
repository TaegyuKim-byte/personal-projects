import discord
from discord.ext import commands
import yt_dlp
import asyncio
import os
from collections import deque # [자료구조] 큐를 구현하기 위함
from dotenv import load_dotenv

# .env 파일 로드
load_dotenv('token.env')

token = os.getenv("DISCORD_TOKEN")

# [시스템 설정]
intents = discord.Intents.default()
intents.message_content = True
bot = commands.Bot(command_prefix='=', intents=intents)

# [멀티미디어 설정 (yt-dlp & FFmpeg)]
# yt-dlp: 유튜브 URL에서 실제 오디오 스트림 주소를 추출하는 도구
yt_dl_opts = {
    'format': 'bestaudio/best',
    'noplaylist': True,
    'quiet': True, # 터미널 로그를 더럽히지 않게
    'nocheckcertificate': True,
    'no_warnings': True, # 자잘한 경고 그만 보기
    # 봇을 안드로이드 폰인 척 위장
    'extractor_args': {
        'youtube': {
            'player_client': ['android', 'ios']
        }
    }
}
ytdl = yt_dlp.YoutubeDL(yt_dl_opts)

# FFmpeg: 다운받은 오디오를 PCM 데이터로 변환해 파이프로 전송하는 도구
# -reconnect 1: TCP 연결이 끊겨도 재접속 시도 (네트워크 안정성)
ffmpeg_options = {
    'options': '-vn',
    'before_options': '-reconnect 1 -reconnect_streamed 1 -reconnect_delay_max 5'
}

# [시스템 변수: 대기열]
# url과 title을 튜플이나 딕셔너리로 저장할 큐입니다.
music_queue = deque()

# [이벤트 리스너]
@bot.event
async def on_ready():
    print(f'--------------------------------')
    print(f'System Online: {bot.user.name}')
    print(f'Bot ID: {bot.user.id}')
    print(f'Latency: {round(bot.latency * 1000)}ms')
    print(f'--------------------------------')

# [명령어: =안녕]
@bot.command()
async def 안녕(ctx):
    await ctx.send(f'반갑습니다! 시스템 정상 가동 중입니다. 🤖')

# [명령어 =도움]
@bot.command()
async def 도움(ctx):
    # 임베드 객체 생성 (타이틀, 설명, 색상 설정)
    embed = discord.Embed(
        title = "봇 도움말",
        description = "이 봇은 음악 재생과 다양한 기능을 제공합니다.\n접두사: `=`",
        color = discord.Color.blue()
    )

    # 필드 추가 (add_field)
    # inline = True -> 가로로 나열, False -> 줄바꿈
    embed.add_field(name = "🎵 음악 명령어", value = "`=재생 [검색어]`, `=스킵`, `=목록`, `=나가`", inline = False)
    embed.add_field(name = "⚙️ 시스템 명령어", value = "`=도움`, `=안녕`", inline = False)

    # 푸터(바닥글) 및 썸네일 설정
    embed.set_footer(text=f"요청자: {ctx.author.name}", icon_url=ctx.author.display_avatar.url)
    embed.set_thumbnail(url=bot.user.avatar.url) # 봇 프사 오른쪽 위에 표시

    # 전송 (embed 파라미터 사용)
    await ctx.send(embed=embed)

# [함수: 다음 곡 재생]
# 이 함수는 노래가 끝난 직후(after 콜백) 호출됩니다.
def play_next(ctx):
    if music_queue: # 큐에 노래가 남아있다면
        # 큐의 가장 앞쪽 데이터(왼쪽)를 꺼냅니다 (FIFO)
        next_song = music_queue.popleft() 
        url = next_song['url']
        title = next_song['title']

        voice_client = ctx.voice_client

        # FFmpeg 프로세스 생성
        player = discord.FFmpegPCMAudio(
            url, 
            executable='C:/ffmpeg/bin/ffmpeg.exe', # 경로 주의
            **ffmpeg_options
        )

        # 재생하면서, 이 노래가 끝나면 다시 play_next를 호출하도록 재귀적으로 설정
        voice_client.play(player, after=lambda e: play_next(ctx))
        
        # [심화] 콜백 함수 내부는 동기(Sync) 환경이라 await ctx.send를 바로 못 씁니다.
        # 따라서 이벤트 루프에 스레드 세이프하게 코루틴을 던져줍니다.
        fut = asyncio.run_coroutine_threadsafe(ctx.send(f"🎵 **다음 곡 재생:** {title}"), bot.loop)
        try:
            fut.result()
        except:
            pass # 에러 무시
    else:
        # 큐가 비었으면 아무것도 안 함 (대기 상태)
        asyncio.run_coroutine_threadsafe(ctx.send("대기열이 비었습니다. 재생을 종료합니다."), bot.loop)

# =============================================

# [명령어: =재생 (핵심 기능)]
@bot.command()
async def 재생(ctx, *, query):
    # (1) 유저 상태 확인: 유저가 음성 채널에 있어야 봇도 따라 들어갑니다.
    if ctx.author.voice is None:
        await ctx.send("❌ 먼저 음성 채널에 들어가주세요!")
        return
    
    # (1-1) 봇이 이미 다른 음성 채널에 연결되어 있는지 확인
    if ctx.voice_client is not None and ctx.voice_client.channel != ctx.author.voice.channel:
        await ctx.send(f"❌ 봇이 이미 다른 채널 (#{ctx.voice_client.channel.name}) 에서 음악을 재생 중입니다!")
        return

    # (2) 음성 채널 접속 (Handshake)
    channel = ctx.author.voice.channel
    if ctx.voice_client is None:
        voice_client = await channel.connect()
    else:
        voice_client = ctx.voice_client

    await ctx.send(f"🔍  **검색 및 대기열 추가 중...**")

    # (3) [CS 심화] 동기 코드를 비동기로 실행하기 (ThreadPoolExecutor)
    # ytdl.extract_info는 네트워크 I/O를 수행하는 'Blocking 함수'입니다.
    # 이걸 그냥 실행하면 추출하는 1~2초 동안 봇 전체가 멈춥니다(Heartbeat 실패 가능성).
    # 따라서 별도의 스레드로 던져서 실행하고, 결과만 await로 받습니다.
    loop = asyncio.get_event_loop()
    try:
        data = await loop.run_in_executor(None, lambda: ytdl.extract_info(f"ytsearch:{query}", download=False))

        if 'entries' not in data or not data['entries']:
            await ctx.send("검색 결과가 없어. 다른 검색어로 다시 ㄱㄱ")
            return
        
        data = data['entries'][0]

    except Exception as e:
        await ctx.send(f"❌ 에러 발생: {e}")
        return

    song_url = data['url']
    title = data['title']

    # 노래 정보를 딕셔너리로 만듦
    song_info = {'url': song_url, 'title': title}

    # (4) 로직 분기 (이미 재생 중 / 재생 중 아님)
    if voice_client.is_playing():
        music_queue.append(song_info)
        await ctx.send(f"✅ **대기열에 추가됨:** {title} (대기 순서: {len(music_queue)}번째)")

    else:
        # 여기서 ffmpeg.exe 자식 프로세스가 생성되고, 
        # Python은 파이프(Pipe)를 통해 PCM 데이터를 실시간으로 받아 UDP로 쏘아줍니다.
        player = discord.FFmpegPCMAudio(
            song_url, 
            executable='C:/ffmpeg/bin/ffmpeg.exe', 
            **ffmpeg_options
        )
        # 이 노래 끝나면 play_next 실행해라!
        voice_client.play(player, after=lambda e: play_next(ctx))
        await ctx.send(f"🎵 **재생 시작:** {title}")

# [명령어: =스킵]
@bot.command()
async def 스킵(ctx):
    if ctx.voice_client and ctx.voice_client.is_playing():
        ctx.voice_client.stop() # stop()을 하면 자동으로 after 콜백(play_next)이 실행되어 다음 곡으로 넘어감
        await ctx.send("⏭️ **현재 곡 스킵!**")
    else:
        await ctx.send("재생 중인 곡이 없어요.")

# [명령어: =목록]
@bot.command()
async def 목록(ctx):
    if not music_queue:
        await ctx.send("비어있음.")
    else:
        msg = "📜 **현재 대기열:**\n\n"
        for i, song in enumerate(music_queue):
            msg += f"{i+1}. {song['title']}\n"
        await ctx.send(msg)

# =============================================

# [명령어: =나가]
@bot.command()
async def 나가(ctx):
    if ctx.voice_client:
        await ctx.voice_client.disconnect()
        await ctx.send("시스템 연결 해제. 👋")
    else:
        await ctx.send("저는 음성 채널에 없는데요?")

# [실행]
# 토큰은 꼭 새로 발급받아서 넣으세요!
bot.run(token)

# 봇 프로세스 종료 -> ctrl C (시스템프로그래밍에서 배움)
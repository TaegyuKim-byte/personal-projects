export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-center bg-gray-100">
      <h1 className="text-5xl font-bold text-blue-600">
        Tailwind 세팅 완료 🎉
      </h1>
      <p className="mt-4 text-lg text-gray-700">
        이 문장이 파란색 제목 아래에 잘 보이면 Tailwind CSS가 제대로 연결된 상태입니다.
      </p>
      <button className="mt-8 rounded-xl bg-blue-600 px-6 py-3 text-white hover:bg-blue-700 transition">
        테스트 버튼
      </button>
    </main>
  );
}


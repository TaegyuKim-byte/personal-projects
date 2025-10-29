export default function Home() {
  const productSets = [
    {
      name: "올데이 싱크 블랙 사각볼 세트",
      headline: "모던 주방에 어울리는 블랙 포인트",
      summary: "설치비 포함 혜택가 450,000원",
      highlights: [
        "블랙 스테인리스 싱크볼",
        "메탈 드레인 키트",
        "180도 회전 수전",
        "블랙 전용 커버",
        "설치비 포함"
      ],
      note: "*싱크대 미사용 시 싱크대 커버로 공간 정리 가능",
      cta: "세트 상담 신청",
    },
    {
      name: "올데이 싱크 리폼볼 세트",
      headline: "따뜻한 질감의 베이지 프리미엄 싱크볼",
      summary:
        "UV 보호 복합석 마감으로 새 주방처럼 완성됩니다. 설치비 포함, 맞춤 상담 후 확정가 안내.",
      highlights: [
        "베이지 복합석 싱크볼",
        "곡선형 베이지 수전",
        "스테인리스 배수 키트",
        "전문 시공팀 방문 설치",
        "설치비 포함"
      ],
      note: "*현장 상황에 따라 추가 비용 발생",
      cta: "세트 상담 신청",
    },
  ];

  const comparisonPoints = [
    {
      label: "소재",
      signature: "304 프리미엄 스테인리스",
      luxe: "항균 복합석 + UV 코팅",
    },
    {
      label: "추천 주방",
      signature: "활동량 많은 패밀리 주방",
      luxe: "럭셔리 홈 / 리노베이션",
    },
    {
      label: "옵션",
      signature: "빌트인 소음 차단 패드, 드레인 보드",
      luxe: "컬러 맞춤, 곡선형 엣지 마감",
    },
    {
      label: "상담 혜택",
      signature: "무료 실측 + 기본 설치",
      luxe: "전담 디자이너 상담 + 설치",
    },
  ];

  const faqs = [
    {
      question: "설치까지 얼마나 걸리나요?",
      answer:
        "사전 상담 후 평균 5일 내로 방문 설치를 진행하며, 긴급 시공은 스케줄에 따라 조율 가능합니다.",
    },
    {
      question: "커스텀 제작도 가능한가요?",
      answer:
        "상담 시 주방 도면을 공유해 주시면 맞춤 사이즈로 제작 가능 여부와 비용을 안내드립니다.",
    },
    {
      question: "A/S는 어떻게 지원되나요?",
      answer:
        "Signature는 5년, Luxe는 7년까지 무상 A/S를 지원하며, 설치 후 30일 이내 점검을 제공합니다.",
    },
  ];

  return (
    <div className="bg-neutral-50 text-neutral-900">
      <header className="mx-auto flex max-w-6xl flex-col gap-8 px-6 pb-24 pt-20 sm:px-8 lg:flex-row lg:items-center lg:justify-between">
        <div className="max-w-xl space-y-6">
          <span className="inline-flex items-center gap-2 rounded-full bg-emerald-100 px-4 py-1 text-sm font-semibold text-emerald-700">
            AllDay Sink · 프리미엄 싱크대 전문
          </span>
          <h1 className="text-4xl font-semibold leading-tight tracking-tight sm:text-5xl">
            공간을 빛내는 프리미엄 싱크대. 하루의 시작과 끝, 올데이 싱크에서 완성됩니다.
          </h1>
          <p className="text-lg leading-relaxed text-neutral-600">
            당신의 주방이 가장 아름다운 순간, 올데이 싱크가 함께합니다. 매일 사용하는 공간이기에 
            올데이는 하루 종일, 매일의 편안함을 생각합니다.
          </p>
          <div className="flex flex-col gap-3 sm:flex-row">
            <a
              href="#contact"
              className="inline-flex items-center justify-center rounded-full bg-emerald-600 px-8 py-3 text-base font-semibold text-white transition hover:bg-emerald-500"
            >
              30초 상담 예약
            </a>
            <a
              href="#products"
              className="inline-flex items-center justify-center rounded-full border border-neutral-300 px-8 py-3 text-base font-semibold text-neutral-800 transition hover:bg-white"
            >
              세트 상세 보기
            </a>
          </div>
        </div>
        <div className="hidden h-72 w-full max-w-md rounded-3xl bg-neutral-200 lg:block" />
      </header>

      <main className="space-y-24 pb-24">
        <section
          id="products"
          className="mx-auto max-w-6xl px-6 sm:px-8"
          aria-labelledby="products-title"
        >
          <div className="mb-12 space-y-3">
            <h2
              id="products-title"
              className="text-3xl font-semibold tracking-tight"
            >
              대표 세트 한눈에 살펴보기
            </h2>
            <p className="text-neutral-600">
              실제로 가장 많이 선택받는 두 가지 라인업입니다. 상담 시 세부 옵션을
              맞춤으로 안내해 드립니다.
            </p>
          </div>
          <div className="grid gap-10 lg:grid-cols-2">
            {productSets.map((product) => (
              <article
                key={product.name}
                className="flex h-full flex-col gap-6 rounded-3xl bg-white p-8 shadow-sm shadow-neutral-100"
              >
                <div className="h-48 w-full rounded-2xl bg-neutral-200" />
                <div className="space-y-4">
                  <h3 className="text-2xl font-semibold text-neutral-900">
                    {product.name}
                  </h3>
                  <p className="text-lg font-medium text-neutral-700">
                    {product.headline}
                  </p>
                  <p className="text-neutral-600">{product.summary}</p>
                </div>
                <ul className="space-y-2 text-sm font-medium text-neutral-700">
                  {product.highlights.map((highlight) => (
                    <li
                      key={highlight}
                      className="flex items-center gap-3 rounded-full bg-neutral-100 px-4 py-2"
                    >
                      <span className="inline-block h-2 w-2 rounded-full bg-emerald-500" />
                      {highlight}
                    </li>
                  ))}
                </ul>
                {product.note && (
                  <p className=/*"rounded-2xl bg-neutral-100 px-4 py-3 text-xs font-medium text-neutral-500"*/"mt-2 text-sm text-neutral-500">
                    {product.note}
                  </p>
                )}
                <a
                  href="#contact"
                  className="mt-auto inline-flex w-full items-center justify-center rounded-full bg-neutral-900 px-6 py-3 text-sm font-semibold text-white transition hover:bg-neutral-800"
                >
                  {product.cta}
                </a>
              </article>
            ))}
          </div>
        </section>

        <section className="bg-white py-20">
          <div className="mx-auto max-w-6xl px-6 sm:px-8">
            <div className="mb-10 space-y-3">
              <h2 className="text-3xl font-semibold tracking-tight">
                어떤 세트가 내 주방에 어울릴까?
              </h2>
              <p className="text-neutral-600">
                핵심 포인트만 추려 비교했습니다. 상담 시 상세한 코디네이션을
                안내해 드립니다.
              </p>
            </div>
            <div className="overflow-hidden rounded-2xl border border-neutral-200 bg-neutral-50">
              <table className="w-full table-fixed border-collapse text-left text-sm text-neutral-700">
                <thead className="bg-neutral-100 text-xs uppercase tracking-wide text-neutral-600">
                  <tr>
                    <th className="px-6 py-4 font-semibold">구분</th>
                    <th className="px-6 py-4 font-semibold text-neutral-900">
                      Signature Stainless
                    </th>
                    <th className="px-6 py-4 font-semibold text-neutral-900">
                      Luxe Stone
                    </th>
                  </tr>
                </thead>
                <tbody>
                  {comparisonPoints.map((point) => (
                    <tr key={point.label} className="border-t border-neutral-200">
                      <th className="px-6 py-5 text-sm font-semibold text-neutral-900">
                        {point.label}
                      </th>
                      <td className="px-6 py-5 text-sm text-neutral-700">
                        {point.signature}
                      </td>
                      <td className="px-6 py-5 text-sm text-neutral-700">
                        {point.luxe}
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        </section>

        <section className="mx-auto max-w-6xl px-6 sm:px-8">
          <div className="grid gap-10 lg:grid-cols-[1.2fr_1fr]">
            <div className="space-y-6">
              <h2 className="text-3xl font-semibold tracking-tight">
                설치 사례와 고객 후기
              </h2>
              <p className="text-neutral-600">
                실제 시공 사진과 고객 만족도를 곧 추가할 예정입니다. Placeholder
                카드로 레이아웃을 먼저 구성했습니다.
              </p>
              <div className="grid gap-4 sm:grid-cols-2">
                {[1, 2, 3, 4].map((item) => (
                  <div
                    key={item}
                    className="flex h-48 flex-col justify-between rounded-2xl bg-neutral-200 p-4 text-sm text-neutral-600"
                  >
                    <span className="font-semibold text-neutral-500">
                      후기 카드 {item}
                    </span>
                    <span className="text-xs text-neutral-500">
                      실제 이미지 & 코멘트 예정
                    </span>
                  </div>
                ))}
              </div>
            </div>
            <aside className="flex h-full flex-col gap-6 rounded-3xl bg-neutral-900 p-8 text-white">
              <h3 className="text-2xl font-semibold">브랜드 약속</h3>
              <ul className="space-y-4 text-sm">
                <li>
                  <span className="font-semibold text-emerald-300">
                    1:1 전담 상담
                  </span>{" "}
                  · 상담부터 설치까지 전담 매니저가 함께합니다.
                </li>
                <li>
                  <span className="font-semibold text-emerald-300">
                    전 지역 설치 네트워크
                  </span>{" "}
                  · 수도권·광역시 전 지역에 방문 설치 지원.
                </li>
                <li>
                  <span className="font-semibold text-emerald-300">
                    사후 관리
                  </span>{" "}
                  · 설치 후 30일 무상 점검 및 주기적 유지보수 안내.
                </li>
              </ul>
              <div className="mt-auto rounded-2xl bg-neutral-800 p-6 text-sm leading-relaxed text-neutral-200">
                <p className="font-semibold text-white">
                  “AllDay Sinks는 오랜 시공 경험을 바탕으로, 고객 주방에 꼭 맞는
                  솔루션만을 제안합니다.”
                </p>
              </div>
            </aside>
          </div>
        </section>

        <section className="mx-auto max-w-6xl px-6 sm:px-8">
          <div className="space-y-8">
            <h2 className="text-3xl font-semibold tracking-tight">FAQ</h2>
            <div className="space-y-4">
              {faqs.map((faq) => (
                <article
                  key={faq.question}
                  className="rounded-2xl border border-neutral-200 bg-white px-6 py-5"
                >
                  <h3 className="text-lg font-semibold text-neutral-900">
                    {faq.question}
                  </h3>
                  <p className="mt-3 text-sm leading-relaxed text-neutral-600">
                    {faq.answer}
                  </p>
                </article>
              ))}
            </div>
          </div>
        </section>

        <section
          id="contact"
          className="bg-neutral-900 py-20 text-neutral-50"
        >
          <div className="mx-auto flex max-w-5xl flex-col gap-12 px-6 sm:px-8 lg:flex-row lg:items-start">
            <div className="flex-1 space-y-6">
              <span className="inline-flex items-center rounded-full bg-emerald-500/10 px-4 py-1 text-xs font-semibold uppercase tracking-wide text-emerald-300">
                상담 신청
              </span>
              <h2 className="text-3xl font-semibold leading-tight">
                무료 실측 & 맞춤 상담을 예약하세요.
              </h2>
              <p className="text-sm leading-relaxed text-neutral-300">
                연락처를 남겨 주시면 24시간 이내 전담 매니저가 상담 전화를 드립니다.
                상담 시 도면이나 참고 이미지를 공유해 주시면 더 정확한 견적 안내가
                가능합니다.
              </p>
              <ul className="space-y-3 text-sm text-neutral-300">
                <li>· 상담 가능 시간: 오전 9시 ~ 오후 7시</li>
                <li>· 설치 가능 지역: 수도권 및 주요 광역시</li>
                <li>· 사전 준비물: 주방 도면(선택), 설치 희망 일정</li>
              </ul>
            </div>
            <form className="flex-1 space-y-4 rounded-3xl bg-white p-8 text-neutral-900 shadow-lg shadow-neutral-800/10">
              <div className="space-y-1">
                <label className="text-sm font-semibold text-neutral-700">
                  이름
                </label>
                <input
                  type="text"
                  placeholder="홍길동"
                  className="w-full rounded-xl border border-neutral-200 px-4 py-3 text-sm text-neutral-900 outline-none transition focus:border-emerald-400 focus:ring-2 focus:ring-emerald-100"
                />
              </div>
              <div className="space-y-1">
                <label className="text-sm font-semibold text-neutral-700">
                  연락처
                </label>
                <input
                  type="tel"
                  placeholder="010-0000-0000"
                  className="w-full rounded-xl border border-neutral-200 px-4 py-3 text-sm text-neutral-900 outline-none transition focus:border-emerald-400 focus:ring-2 focus:ring-emerald-100"
                />
              </div>
              <div className="space-y-1">
                <label className="text-sm font-semibold text-neutral-700">
                  상담 희망 시간대
                </label>
                <select className="w-full rounded-xl border border-neutral-200 px-4 py-3 text-sm text-neutral-900 outline-none transition focus:border-emerald-400 focus:ring-2 focus:ring-emerald-100">
                  <option>오전 (09:00 - 12:00)</option>
                  <option>오후 (12:00 - 17:00)</option>
                  <option>저녁 (17:00 - 19:00)</option>
                </select>
              </div>
              <div className="space-y-1">
                <label className="text-sm font-semibold text-neutral-700">
                  메모 (선택)
                </label>
                <textarea
                  rows={4}
                  placeholder="설치 예정 공간 또는 요청 사항을 알려주세요."
                  className="w-full rounded-xl border border-neutral-200 px-4 py-3 text-sm text-neutral-900 outline-none transition focus:border-emerald-400 focus:ring-2 focus:ring-emerald-100"
                />
              </div>
              <button
                type="submit"
                className="w-full rounded-full bg-emerald-600 px-6 py-3 text-sm font-semibold text-white transition hover:bg-emerald-500"
              >
                상담 요청 보내기
              </button>
              <p className="text-xs text-neutral-500">
                상담 요청 시 개인정보 처리 방침에 동의한 것으로 간주됩니다.
              </p>
            </form>
          </div>
        </section>
      </main>
    </div>
  );
}

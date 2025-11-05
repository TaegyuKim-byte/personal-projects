import Link from "next/link";

export default function Home() {
  const productSets = [
    {
      name: "(세트 1)",
      headline: "(세트 특징)",
      summary: "(가격 및 디테일)",
      highlights: [
        "(구성품 1)",
        "(구성품 2)",
        "(구성품 3)",
        "(구성품 4)",
      ],
      note: "*유의 사항",
      cta: "주문하기",
    },
    {
      name: "(세트 2)",
      headline: "(세트 특징)",
      summary: "(가격 및 디테일)",
      highlights: [
        "(구성품 1)",
        "(구성품 2)",
        "(구성품 3)",
        "(구성품 4)",
      ],
      note: "*유의 사항",
      cta: "주문하기",
    },
    //세트 추가 시 여기에 객체 추가하기
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
      question: "Q. 설치까지 얼마나 걸리나요?",
      answer:
        "A. 사전 상담 후 평균 5일 내로 방문 설치를 진행하며, 긴급 시공은 스케줄에 따라 조율 가능합니다.",
    },
    {
      question: "Q. 커스텀 제작도 가능한가요?",
      answer:
        "A. 상담 시 주방 도면을 공유해 주시면 맞춤 사이즈로 제작 가능 여부와 비용을 안내드립니다.",
    },
    {
      question: "Q. A/S는 어떻게 지원되나요?",
      answer:
        "A. Signature는 5년, Luxe는 7년까지 무상 A/S를 지원하며, 설치 후 30일 이내 점검을 제공합니다.",
    },
  ];

  const orderSteps = [
    {
      title: "1. 상품 선택",
      description: "라인업과 옵션을 비교하고 원하는 구성을 선택합니다.",
    },
    {
      title: "2. 주문 정보 입력",
      description: "설치 주소와 연락처를 입력하고 일정 희망일을 선택합니다.",
    },
    {
      title: "3. 결제 완료",
      description: "안전한 결제 수단으로 즉시 결제를 진행합니다.",
    },
    {
      title: "4. 설치 및 사후 관리",
      description: "전문 설치 기사님이 방문해 시공하고, 이후 A/S까지 케어합니다.",
    },
  ];

  return (
    <div className="bg-neutral-50 text-neutral-900">
      <header className="mx-auto flex max-w-6xl flex-col gap-8 px-6 pb-24 pt-20 sm:px-8 lg:flex-row lg:items-center lg:justify-between">
        <div className="max-w-xl space-y-6">
          <span className="inline-flex items-center gap-2 rounded-full bg-emerald-100 px-4 py-1 text-sm font-semibold text-emerald-700">
            AllDay Sink 온라인 스토어 오픈
          </span>
          <h1 className="text-4xl font-semibold leading-tight tracking-tight sm:text-5xl">
            집에서도 간편하게 주문하는 프리미엄 싱크, AllDay Sink
          </h1>
          <p className="text-lg leading-relaxed text-neutral-600">
            원하는 재질과 옵션을 선택하고 온라인으로 바로 결제하세요. 설치 일정까지 한 번에
            예약되는 스마트한 주문 경험을 제공합니다.
          </p>
          <div className="flex flex-col gap-3 sm:flex-row">
            <Link
              href="/products"
              className="inline-flex items-center justify-center rounded-full bg-emerald-600 px-8 py-3 text-base font-semibold text-white transition hover:bg-emerald-500"
            >
              상품 둘러보기
            </Link>
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
                <Link
                  href="/checkout"
                  className="mt-auto inline-flex w-full items-center justify-center rounded-full bg-neutral-900 px-6 py-3 text-sm font-semibold text-white transition hover:bg-neutral-800"
                >
                  {product.cta}
                </Link>
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
                주문 진행 안내
              </h2>
              <p className="text-neutral-600">
                온라인에서 주문부터 설치까지 이어지는 과정을 한눈에 확인하세요.
              </p>
              <div className="grid gap-4 sm:grid-cols-2">
                {orderSteps.map((step) => (
                  <div
                    key={step.title}
                    className="flex h-48 flex-col justify-between rounded-2xl bg-neutral-200 p-4 text-sm text-neutral-700"
                  >
                    <span className="font-semibold text-neutral-600">
                      {step.title}
                    </span>
                    <span className="text-xs text-neutral-500">
                      {step.description}
                    </span>
                  </div>
                ))}
              </div>
            </div>
            <aside className="flex h-full flex-col gap-6 rounded-3xl bg-neutral-900 p-8 text-white">
              <h3 className="text-2xl font-semibold">AllDay 서비스</h3>
              <ul className="space-y-4 text-sm">
                <li>
                  <span className="font-semibold text-emerald-300">
                    실시간 주문 상태
                  </span>
                  마이페이지에서 결제·배송 상황을 즉시 확인하세요.
                </li>
                <li>
                  <span className="font-semibold text-emerald-300">
                    설치 일정 예약
                  </span>
                  주문 시 희망 일자를 선택하면 설치 기사님이 일정 확정 연락을 드립니다.
                </li>
                <li>
                  <span className="font-semibold text-emerald-300">
                    사후 관리 보증
                  </span>
                  정품 부품으로 1년 무상 A/S, 연장 케어 옵션도 선택 가능합니다.
                </li>
              </ul>
              <div className="mt-auto rounded-2xl bg-neutral-800 p-6 text-sm leading-relaxed text-neutral-200">
                <p className="font-semibold text-white">
                  AllDay Sink는 온라인 주문부터 전문 설치까지 한 번에 책임집니다.
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

        <section className="bg-neutral-900 py-20 text-neutral-50">
          <div className="mx-auto flex max-w-5xl flex-col gap-12 px-6 sm:px-8 lg:flex-row lg:items-start">
            <div className="flex-1 space-y-6">
              <span className="inline-flex items-center rounded-full bg-emerald-500/10 px-4 py-1 text-xs font-semibold uppercase tracking-wide text-emerald-300">
                온라인 주문 지원
              </span>
              <h2 className="text-3xl font-semibold leading-tight">
                AllDay Sink 주문을 지금 시작하세요.
              </h2>
              <p className="text-sm leading-relaxed text-neutral-300">
                상품 선택과 옵션 지정, 결제까지 사이트에서 간편하게 처리할 수 있습니다. 설치 일정은 결제 후 바로 확정 도와드립니다.
              </p>
              <ul className="space-y-3 text-sm text-neutral-300">
                <li>· 운영 시간: 평일 9시 - 19시</li>
                <li>· 설치 가능 지역: 전국(도서산간 추가비용 별도)</li>
                <li>· 지원 서비스: 실시간 주문 상담, 설치 일정 알림</li>
              </ul>
            </div>
            <div className="flex-1 space-y-5 rounded-3xl bg-white p-8 text-neutral-900 shadow-lg shadow-neutral-800/10">
              <h3 className="text-2xl font-semibold text-neutral-900">바로가기</h3>
              <p className="text-sm text-neutral-600">
                아래 메뉴를 통해 원하는 단계로 이동해 주문을 완성하세요.
              </p>
              <div className="space-y-3">
                <Link href="/products" className="flex items-center justify-between rounded-xl border border-neutral-200 px-5 py-3 text-sm font-semibold transition hover:border-emerald-400 hover:text-emerald-500">
                  상품 전체 보기
                  <span aria-hidden="true">→</span>
                </Link>
                <Link href="/cart" className="flex items-center justify-between rounded-xl border border-neutral-200 px-5 py-3 text-sm font-semibold transition hover:border-emerald-400 hover:text-emerald-500">
                  장바구니 확인
                  <span aria-hidden="true">→</span>
                </Link>
                <Link href="/checkout" className="flex items-center justify-between rounded-xl border border-neutral-200 px-5 py-3 text-sm font-semibold transition hover:border-emerald-400 hover:text-emerald-500">
                  주문 결제 진행
                  <span aria-hidden="true">→</span>
                </Link>
              </div>
              <p className="text-xs text-neutral-500">
                결제 완료 후 설치 일정은 담당 매니저가 24시간 이내에 안내드립니다.
              </p>
            </div>
          </div>
        </section>
      </main>
    </div>
  );
}

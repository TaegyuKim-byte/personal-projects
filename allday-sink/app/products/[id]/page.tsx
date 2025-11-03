interface ProductDetailPageProps {
  params: { id: string };
}

export default function ProductDetailPage({ params }: ProductDetailPageProps) {
  return (
    <main className="mx-auto max-w-5xl px-6 py-24">
      <h1 className="text-3xl font-semibold">상품 상세: {params.id}</h1>
      <p className="mt-4 text-neutral-600">TODO: 상품 정보를 불러와 옵션과 설명을 제공합니다.</p>
    </main>
  );
}
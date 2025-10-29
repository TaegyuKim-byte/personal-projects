/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./app/**/*.{js,ts,jsx,tsx}",       // Next.js 13 이상: app router
    "./pages/**/*.{js,ts,jsx,tsx}",     // (구버전 라우팅도 대비)
    "./components/**/*.{js,ts,jsx,tsx}" // 컴포넌트 폴더
  ],
  theme: {
    extend: {},  // 색상, 폰트 등 나중에 커스터마이징 가능
  },
  plugins: [],    // 필요 시 확장 기능 추가 (지금은 비워둬도 됨)
};

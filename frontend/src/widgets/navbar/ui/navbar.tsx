
export const Navbar = () => {
  return (
    <div className="fixed top-0 left-0 w-full flex items-center justify-around gap-3 z-50 p-6 bg-black/70 opacity-80">
      <div className="">
        <h1  className="cursor-pointer p-6 text-sm md:text-lg font-semibold">Andy<span className="text-pink-700 font-bold">Stack</span></h1>
      </div>
      <div className="">
        <img src="me.png" alt="me" className="w-10 h-10 rounded-full object-cover border-2 cursor-pointer border-pink-700" />
      </div>
    </div>
  )
}

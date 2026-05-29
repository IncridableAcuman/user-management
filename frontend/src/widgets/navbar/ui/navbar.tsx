import { Button } from "@/shared/ui/button"
import { Bell, Code } from "lucide-react"


export const Navbar = () => {
  return (
    <div className="fixed top-0 left-0 w-full flex items-center justify-between py-4 px-4 sm:px-6 md:px-8 lg:px-10 z-50  bg-gray-900  rounded-md shadow-lg border border-gray-700">
      <div className="flex items-center gap-2">
        <Button size={'icon'} className="rounded-full shadow">
        <Code/>
      </Button>
      <h1>Stack</h1>
      </div>
      <div className="flex items-center gap-4">
        <Bell size={18} />
        <img src="me.png" alt="me" className="w-10 h-10 rounded-full border-2 border-gray-700 shadow cursor-pointer" />
      </div>
    </div>
  )
}

import { UseTheme } from "@/app/providers/ThemeProvider"
import { Button } from "@/shared/ui/button"
import { Code, Moon, Settings, Sun } from "lucide-react"


export const Navbar = () => {
  const { theme,toggleTheme } = UseTheme();
  return (
    <div className={`fixed top-0 left-0 w-full flex items-center justify-between 
      py-4 px-4 sm:px-6 md:px-8 lg:px-10 z-50 rounded-md shadow  ${theme === "light" ? "bg-white text-black" : "bg-gray-950  border border-fuchsia-950"} transition duration-300`}>
      <div className="flex items-center gap-2">
        <Button size={'icon'} className="rounded-full shadow">
        <Code/>
      </Button>
      <h1>Stack</h1>
      </div>
      <div className="flex items-center gap-4">
        <div className="flex items-center gap-3">
          <button onClick={toggleTheme}>
            {
              theme === "light" ? <Moon size={18} /> : <Sun size={18} />
            }
          </button>
          <Settings size={18} />
        </div>
        <img src="me.png" alt="me" className="w-10 h-10 rounded-full border-2 border-gray-700 shadow cursor-pointer" />
      </div>
    </div>
  )
}

import { UseTheme } from "@/app/providers/ThemeProvider";
import { Navbar } from "@/widgets/navbar";

import DashboardCarusel from "../components/dashboard-carusel";
import DashboardActivity from "../components/dashboard-activity";
import { DashboardCard } from "../components/dashboard-card";
import DashboardStatistic from "../components/dashboard-statistic";


export const DashboardPage = () => {
  const { theme } = UseTheme();

  return (
    <div
      className={`${theme === "light" ? "bg-white text-black" : "bg-gray-950 text-white"} w-full min-h-screen`}
    >
      <Navbar />
    
      <div className="pt-24 px-4 sm:px-6 md:px-8 lg:px-10">
        <DashboardCard/>
        <div className="grid grid-cols-1 md:grid-cols-2 gap-3 py-4 items-stretch">
          <DashboardCarusel/>
          <DashboardActivity/>
        </div>
        <DashboardStatistic/>
      </div>
    </div>
  );
};

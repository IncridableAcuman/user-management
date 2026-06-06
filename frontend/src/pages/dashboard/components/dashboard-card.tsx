import { UseTheme } from "@/app/providers/ThemeProvider";
import { Card, CardContent, CardHeader, CardTitle } from "@/shared/ui/card";
import { ShieldAlert, UserCheck, UserPlus, Users } from "lucide-react";

const fourCard = [
  {
    icon: <Users className="text-amber-200" />,
    title: "Total Users",
    color: "text-amber-200",
  },
  { icon: <UserCheck className="text-green-500" />, title: "Active Users" },
  { icon: <UserPlus className="text-green-800" />, title: "New Registrations" },
  {
    icon: <ShieldAlert className="text-red-800" />,
    title: "Failed Login Attempts",
  },
];

export const DashboardCard = () => {
    const { theme } = UseTheme();
  
  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
      {/* card */}
      {fourCard.map((card, index) => (
        <Card
          key={index}
          className={`${theme === "dark" ? "border border-fuchsia-950 bg-gray-950 hover:border-gray-900 transition duration-300" : ""}`}
        >
          <CardHeader className="flex items-center gap-3">
            <button
              className={`p-3 rounded-full ${theme === "light" ? "border" : "border border-fuchsia-950"}`}
            >
              {card.icon}
            </button>
            <CardTitle>{card.title}</CardTitle>
          </CardHeader>
          <CardContent className="py-4">
            <h4 className="text-3xl md:text-5xl font-extrabold">100</h4>
          </CardContent>
        </Card>
      ))}
      {/* card */}
    </div>
  );
};

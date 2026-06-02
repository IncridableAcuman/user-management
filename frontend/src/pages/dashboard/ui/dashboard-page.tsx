import { UseTheme } from "@/app/providers/ThemeProvider";
import { Button } from "@/shared/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/shared/ui/card";
import { Navbar } from "@/widgets/navbar";
import {
  ArrowRight,
  ShieldAlert,
  UserCheck,
  UserPlus,
  Users,
} from "lucide-react";
import { CartesianGrid, Legend, Line, LineChart, ResponsiveContainer, Tooltip, XAxis, YAxis } from "recharts";

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

const users = [
  { image: "me.png", fullName: "Thomas Garcia", email: "adamk@yahoo.com" },
  { image: "me.png", fullName: "Thomas Garcia", email: "adamk@yahoo.com" },
  { image: "me.png", fullName: "Thomas Garcia", email: "adamk@yahoo.com" },
  { image: "me.png", fullName: "Thomas Garcia", email: "adamk@yahoo.com" },
];

const loginActivity = [
  { day: "Mon", success: 120, failed: 8 },
  { day: "Tue", success: 150, failed: 12 },
  { day: "Wed", success: 180, failed: 5 },
  { day: "Thu", success: 210, failed: 15 },
  { day: "Fri", success: 250, failed: 10 },
  { day: "Sat", success: 190, failed: 7 },
  { day: "Sun", success: 170, failed: 4 },
];

export const DashboardPage = () => {
  const { theme } = UseTheme();

  return (
    <div
      className={`${theme === "light" ? "bg-white text-black" : "bg-gray-950 text-white"} w-full min-h-screen`}
    >
      <Navbar />

      <div className="pt-24 px-4 sm:px-6 md:px-8 lg:px-10">
        <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
          {/* card */}
          {fourCard.map((card, index) => (
            <Card
              key={index}
              className={`${theme === "dark" ? "border border-fuchsia-950 hover:bg-neutral-950 hover:border-gray-900 transition duration-300" : ""}`}
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
        <div className="grid grid-cols-1 md:grid-cols-2 gap-3 py-4">
          <Card
            className={`${theme === "dark" ? "border border-fuchsia-950 transition duration-300" : ""}`}
          >
            <CardHeader className="flex items-center gap-3">
              <CardTitle>User Registration Analytics</CardTitle>
            </CardHeader>
            <CardContent className="py-4">
              <ResponsiveContainer width="100%" height={350}>
                <LineChart data={loginActivity}>
                  <CartesianGrid strokeDasharray="3 3" />

                  <XAxis dataKey="day" />

                  <YAxis />

                  <Tooltip />

                  <Legend />

                  <Line
                    type="monotone"
                    dataKey="success"
                    name="Successful Login"
                    stroke="#22c55e"
                    strokeWidth={3}
                  />

                  <Line
                    type="monotone"
                    dataKey="failed"
                    name="Failed Login"
                    stroke="#ef4444"
                    strokeWidth={3}
                  />
                </LineChart>
              </ResponsiveContainer>
            </CardContent>
          </Card>
          <Card
            className={`${theme === "dark" ? "border border-fuchsia-950 transition duration-300" : ""}`}
          >
            <CardHeader className="flex items-center justify-between gap-3">
              <CardTitle className="text-lg md:text-xl font-semibold">
                Recent Authentication Activity
              </CardTitle>
              <Button variant={"destructive"}>All</Button>
            </CardHeader>
            <CardContent className="py-4">
              {users.map((user, index) => (
                <div
                  className="flex items-center justify-between gap-3 space-y-4 border-b border-b-gray-600"
                  key={index}
                >
                  <div className="flex items-center gap-4">
                    <img
                      src={user.image}
                      alt={user.fullName}
                      className="w-10 h-10 rounded-full border border-gray-600"
                    />
                    <div className="space-y-0.5">
                      <p className="text-sm text-gray-600">{user.email}</p>
                      <h2 className="text-balance md:text-lg lg:text-xl font-semibold">
                        {user.fullName}
                      </h2>
                    </div>
                  </div>
                  <div className="">
                    <div className="">
                      <button className=" p-2 rounded-full cursor-pointer  transition duration-300">
                        <ArrowRight size={18} />
                      </button>
                    </div>
                  </div>
                </div>
              ))}
            </CardContent>
          </Card>
        </div>
        {/* 3 */}
        <Card
          className={`w-full p-4 ${theme === "dark" ? "border border-fuchsia-950" : ""}`}
        >
          <CardHeader>
            <CardTitle className="text-balance md:text-lg lg:text-xl font-semibold">
              Under Section
            </CardTitle>
          </CardHeader>
          <CardContent>
                          <ResponsiveContainer width="100%" height={350}>
                <LineChart data={loginActivity}>
                  <CartesianGrid strokeDasharray="3 3" />

                  <XAxis dataKey="day" />

                  <YAxis />

                  <Tooltip />

                  <Legend />

                  <Line
                    type="monotone"
                    dataKey="success"
                    name="Successful Login"
                    stroke="#22c55e"
                    strokeWidth={3}
                  />

                  <Line
                    type="monotone"
                    dataKey="failed"
                    name="Failed Login"
                    stroke="#ef4444"
                    strokeWidth={3}
                  />
                </LineChart>
              </ResponsiveContainer>
          </CardContent>
        </Card>
      </div>
    </div>
  );
};

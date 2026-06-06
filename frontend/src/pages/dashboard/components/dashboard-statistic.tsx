import { UseTheme } from "@/app/providers/ThemeProvider";
import { Card, CardContent, CardHeader, CardTitle } from "@/shared/ui/card";
import { CartesianGrid, Legend, Line, LineChart, ResponsiveContainer, Tooltip, XAxis, YAxis } from "recharts";

const loginActivity = [
  { day: "Mon", success: 120, failed: 8 },
  { day: "Tue", success: 150, failed: 12 },
  { day: "Wed", success: 180, failed: 5 },
  { day: "Thu", success: 210, failed: 15 },
  { day: "Fri", success: 250, failed: 10 },
  { day: "Sat", success: 190, failed: 7 },
  { day: "Sun", success: 170, failed: 4 },
];

const DashboardStatistic = () => {
    const { theme } = UseTheme();
  return (
    <Card
      className={`w-full p-4 ${theme === "dark" ? "border border-fuchsia-950 bg-gray-950 hover:border-gray-900 transition duration-300" : ""}`}
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
  );
};

export default DashboardStatistic;

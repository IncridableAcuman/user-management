import { UseTheme } from "@/app/providers/ThemeProvider";
import { Avatar, AvatarFallback, AvatarImage } from "@/shared/ui/avatar";
import { Button } from "@/shared/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/shared/ui/card";
import { ArrowRight } from "lucide-react";

const users = [
  { image: "me.png", fullName: "Thomas Garcia", email: "adamk@yahoo.com" },
  { image: "me.png", fullName: "Thomas Garcia", email: "adamk@yahoo.com" },
  { image: "me.png", fullName: "Thomas Garcia", email: "adamk@yahoo.com" },
  { image: "me.png", fullName: "Thomas Garcia", email: "adamk@yahoo.com" },
  { image: "me.png", fullName: "Thomas Garcia", email: "adamk@yahoo.com" },
  { image: "me.png", fullName: "Thomas Garcia", email: "adamk@yahoo.com" },
  { image: "me.png", fullName: "Thomas Garcia", email: "adamk@yahoo.com" },
];

const DashboardActivity = () => {
  const { theme } = UseTheme();
  return (
    <Card
      className={`${theme === "dark" ? "border border-fuchsia-950 bg-gray-950 hover:border-gray-900  transition duration-300" : ""} h-full`}
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
              <Avatar>
                <AvatarImage src="https://github.com/shadcn.png" />
                <AvatarFallback>CN</AvatarFallback>
              </Avatar>
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
  );
};

export default DashboardActivity;

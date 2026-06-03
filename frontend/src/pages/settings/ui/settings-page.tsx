import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/shared/ui/tabs";
import { Navbar } from "@/widgets/navbar";
import { Bell, PaintBucket, Shield, UserRound } from "lucide-react";
import { useState } from "react";

export const SettingsPage = () => {
  const [active, setActive] = useState("profile");
  return (
    <div className="w-full min-h-screen pt-28">
      <Navbar />
      <div className="flex items-center justify-around">
        <div className="space-y-2">
          <h1 className="text-lg md:text-xl lg:text-3xl font-semibold">Settings</h1>
          <p className="text-sm text-gray-600 font-black">Manage your account settings and set e-mail preferences</p>
        </div>
        <div className=""></div>
      </div>
      <div className="flex flex-col items-center justify-center mx-auto gap-4 w-full max-w-7xl">
        <Tabs
          value={active}
          onValueChange={setActive}
          defaultValue="profile"
          className="w-full flex flex-col items-center md:flex-row gap-4 p-4"
        >
          <TabsList className="flex flex-col items-center gap-4 w-full md:w-64">
            <TabsTrigger
              value="profile"
              className={`flex items-center gap-2 font-semibold p-3 ${active === "profile" ? "bg-gray-950 text-white w-full p-3" : ""}`}
            >
              <UserRound />
              Profile
            </TabsTrigger>
            <TabsTrigger
              value="account"
              className={`flex items-center gap-2 font-semibold ${active === "account" ? "bg-gray-950 text-white w-full p-3" : ""}`}
            >
              <Shield />
              Account
            </TabsTrigger>
            <TabsTrigger
              value="notification"
              className={`flex items-center gap-2 font-semibold ${active === "notification" ? "bg-gray-950 text-white w-full p-3" : ""}`}
            >
              <Bell/>
              Notifications
            </TabsTrigger>
            <TabsTrigger
              value="display"
              className={`flex items-center gap-2 font-semibold ${active === "display" ? "bg-gray-950 text-white w-full p-3" : ""}`}
            >
              <PaintBucket/>
              Display
            </TabsTrigger>
          </TabsList>
          <TabsContent value="profile" className="w-full border p-4 sm:gap-6 md:p-8 lg:p-10">
            A
          </TabsContent>
          <TabsContent value="account" className="w-full border p-4 sm:gap-6 md:p-8 lg:p-10">
            b
          </TabsContent>
          <TabsContent value="notification" className="w-full border p-4 sm:gap-6 md:p-8 lg:p-10">
            C
          </TabsContent>
          <TabsContent value="display" className="w-full border p-4 sm:gap-6 md:p-8 lg:p-10">
            d
          </TabsContent>
        </Tabs>
      </div>
    </div>
  );
};

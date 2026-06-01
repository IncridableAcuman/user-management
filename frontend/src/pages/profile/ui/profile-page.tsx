import { Button } from "@/shared/ui/button";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/shared/ui/tabs";
import { Navbar } from "@/widgets/navbar";
import { Settings } from "lucide-react";
import { useState } from "react";


export const ProfilePage = () => {
  const [active,setActive]=useState("overview")
  return (
    <div className={`w-full min-h-screen`}>
      <Navbar />
      <div className="pt-24 px-4 sm:px-6 md:px-8 lg:px-10">
        <div className="flex items-center justify-between gap-3">
          <h1 className="text-lg font-semibold md:text-xl">Profile Page</h1>
          <Button>
            <Settings />
            Settings
          </Button>
        </div>
        <div className="py-4">
          <Tabs 
          value={active}
          onValueChange={setActive}
          className="flex flex-col">
            <TabsList defaultValue={"overview"} className="p-2">
              <TabsTrigger value="overview" className={active === "overview" ? "bg-black text-white border" : ""}>Overview</TabsTrigger>
              <TabsTrigger value="projects" className={active === "projects" ? "bg-black text-white border" : ""}>Projects</TabsTrigger>
              <TabsTrigger value="activities" className={active === "activities" ? "bg-black text-white border" : ""}>Activities</TabsTrigger>
              <TabsTrigger value="members" className={active === "members" ? "bg-black text-white border" : ""}>Members</TabsTrigger>
            </TabsList>
            <TabsContent value="overview">A</TabsContent>
            <TabsContent value="projects">B</TabsContent>
            <TabsContent value="activities">C</TabsContent>
            <TabsContent value="members">C</TabsContent>
          </Tabs>
        </div>
      </div>
    </div>
  );
};

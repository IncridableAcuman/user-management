import { LoginForm } from "@/features/auth/auth-login";
import { RegisterForm } from "@/features/auth/auth-register";
import { Button } from "@/shared/ui/button";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/shared/ui/tabs";
import { Code } from "lucide-react";
import { useState } from "react";

export const AuthPage = () => {
  const [active, setActive] = useState("login");
  return (
    <div className="w-full min-h-screen flex font-semibold">
      <div className="hidden sm:block w-1/2 min-h-screen bg-gray-950 text-white">
        <div className="flex items-center gap-2 p-4">
          <Button size={"icon"} className="rounded-full shadow">
            <Code />
          </Button>
          <h1>UFQ</h1>
        </div>
      </div>
      <div className="w-full md:w-1/2 bg-black text-white min-h-screen flex flex-col items-center justify-center p-6">
        <img src="favicon.svg" alt="icons" className="py-6" />
        <Tabs
          value={active}
          onValueChange={setActive}
          defaultValue="login"
          className="w-full max-w-lg flex flex-col gap-4"
        >
          <TabsList className="grid w-full grid-cols-2 p-1 md:p-2">
            <TabsTrigger
              value="login"
              className={active === "login" ? "bg-gray-950 text-white" : ""}
            >
              Login
            </TabsTrigger>
            <TabsTrigger
              value="register"
              className={active === "register" ? "bg-gray-950 text-white" : ""}
            >
              Register
            </TabsTrigger>
          </TabsList>
          <TabsContent value="login">
            <LoginForm />
          </TabsContent>
          <TabsContent value="register">
            <RegisterForm />
          </TabsContent>
        </Tabs>
      </div>
    </div>
  );
};

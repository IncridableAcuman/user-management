import { LoginForm } from "@/features/auth/auth-login";
import { RegisterForm } from "@/features/auth/auth-register";
import { Tabs, TabsContent, TabsList, TabsTrigger } from "@/shared/ui/tabs";
import { useState } from "react";

export const AuthPage = () => {
  const [active, setActive] = useState("login");
  return (
    <div className="w-full min-h-screen flex font-semibold">
      <div className="hidden sm:block w-1/2 min-h-screen bg-gray-950 text-white">
        <h2 className="cursor-pointer p-6 text-lg font-semibold">
          Andy<span className="text-blue-700 font-bold">Stack</span>
        </h2>
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
              className={active === "login" ? "bg-blue-900 text-white" : ""}
            >
              Login
            </TabsTrigger>
            <TabsTrigger
              value="register"
              className={active === "register" ? "bg-blue-900 text-white" : ""}
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

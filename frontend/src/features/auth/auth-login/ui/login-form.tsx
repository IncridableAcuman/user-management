import { Button } from "@/shared/ui/button";
import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from "@/shared/ui/card";
import { Input } from "@/shared/ui/input";
import { Label } from "@/shared/ui/label";
import { Link, useNavigate } from "react-router-dom";

export const LoginForm = () => {
  const navigate = useNavigate();
  return (
    <div className="w-full min-h-screen flex items-center justify-between font-semibold">
      <div className="hidden sm:block w-full min-h-screen bg-gray-950 text-white">
        <h2 className="cursor-pointer p-6 text-lg font-semibold">
          Andy<span className="text-pink-700 font-bold">Stack</span>
        </h2>
      </div>
      <div className="w-full bg-black text-white min-h-screen">
        <div className="flex items-center justify-end p-6">
          <Button
            variant={"destructive"}
            onClick={() => navigate("/register")}
            className="cursor-pointer"
          >
            Register
          </Button>
        </div>

        <div className="flex flex-col items-center justify-center pt-30">
          <Card className="w-full max-w-xl mx-auto bg-transparent text-white">
            <CardHeader className="text-center">
              <CardTitle className="text-2xl font-semibold">
                Login to your account
              </CardTitle>
              <CardDescription>
                Enter your email below to login your account
              </CardDescription>
            </CardHeader>
            <CardContent className="w-full">
              <form>
                <div className="flex flex-col gap-6 font-semibold">
                  <div className="grid gap-3">
                    <Label htmlFor="email">Email</Label>
                    <Input
                      type="email"
                      id="email"
                      placeholder="example@gmail.com"
                      className="p-5"
                      required
                    />
                  </div>
                  <div className="grid gap-3">
                    <Label htmlFor="password">Password</Label>
                    <Input
                      type="password"
                      id="password"
                      placeholder="********"
                      className="p-5"
                      required
                    />
                  </div>
                  <div className="grid gap-3">
                    <Button
                      variant={"outline"}
                      className="text-black p-5 cursor-pointer"
                    >
                      Login
                    </Button>
                  </div>
                </div>
                <Link to={"/forgot-password"} className="text-xs flex items-center justify-center pt-10 underline">
                  Forgot Password
                </Link>
              </form>
            </CardContent>
          </Card>
        </div>
      </div>
    </div>
  );
};

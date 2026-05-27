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

export const RegisterForm = () => {
  return (
          <Card className="w-full max-w-xl mx-auto bg-transparent text-white">
            <CardHeader className="text-center">
              <CardTitle className="text-2xl font-semibold">
                Create an account
              </CardTitle>
              <CardDescription>
                Enter your email below to create your account
              </CardDescription>
            </CardHeader>
            <CardContent className="w-full">
              <form>
                <div className="flex flex-col gap-6 font-semibold">
                  <div className="grid gap-3">
                    <Label htmlFor="username">Username</Label>
                    <Input
                      type="text"
                      id="username"
                      placeholder="Acuman"
                      className="p-5"
                      required
                    />
                  </div>
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
                    <Button variant={"outline"} className="text-black p-5 cursor-pointer">
                      Create an account
                    </Button>
                  </div>
                </div>
              </form>
            </CardContent>
          </Card>
  );
};

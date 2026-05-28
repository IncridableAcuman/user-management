import { Button } from "@/shared/ui/button";
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/shared/ui/card";
import { Input } from "@/shared/ui/input";
import { Label } from "@/shared/ui/label";

export const ResetPasswordForm = () => {
  return (
    <div className="w-full min-h-screen flex items-center justify-between font-semibold">
      <div className="hidden sm:block w-full min-h-screen bg-gray-950 text-white">
        <h2 className="cursor-pointer p-6 text-lg font-semibold">
          Andy<span className="text-blue-500 font-bold">Stack</span>
        </h2>
      </div>
      <div className="w-full bg-black text-white min-h-screen">

        <div className="flex flex-col items-center justify-center pt-30">
          <Card className="w-full max-w-xl mx-auto bg-transparent text-white">
            <CardHeader className="text-center">
              <CardTitle className="text-2xl font-semibold text-blue-500">
                Reset Password
              </CardTitle>
              <CardDescription>
                Enter your email below to login your account
              </CardDescription>
            </CardHeader>
            <CardContent className="w-full">
              <form>
                <div className="flex flex-col gap-6 font-semibold">
                  <div className="grid gap-3">
                    <Label htmlFor="email">Password</Label>
                    <Input
                      type="password"
                      id="password"
                      placeholder="********"
                      className="p-5 border border-blue-500"
                      required
                    />
                  </div>
                  <div className="grid gap-3">
                    <Label htmlFor="password">Confirm password</Label>
                    <Input
                      type="password"
                      id="confirmPassword"
                      placeholder="********"
                      className="p-5 border border-blue-500"
                      required
                    />
                  </div>
                  <div className="grid gap-3">
                    <Button
                      variant={"outline"}
                      className="text-black p-5 cursor-pointer border border-blue-500"
                    >
                      Reset Password
                    </Button>
                  </div>
                </div>
              </form>
            </CardContent>
          </Card>
        </div>
      </div>
    </div>
  );
}

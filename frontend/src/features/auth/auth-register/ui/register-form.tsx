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
import { RadioGroup, RadioGroupItem } from "@/shared/ui/radio-group";
import { Code } from "lucide-react";

export const RegisterForm = () => {
  return (
    <div className="w-full min-h-screen pt-24">
      <div className="w-full flex flex-col items-center justify-center gap-3">
        <div className="">
          <Button><Code size={45}  /></Button>
        </div>
        <div className="w-full max-w-xl">
          <Card>
            <CardHeader>
              <CardTitle className="text-xl font-semibold">Register</CardTitle>
              <CardDescription>
                To register, please complete the following:
              </CardDescription>
            </CardHeader>
            <CardContent className="w-full">
              <form>
                <div className="flex flex-col gap-6">
                  {/* for firstname and lastname */}
                  <div className="grid grid-cols-1 sm:grid-cols-2 gap-3">
                    <div className="grid gap-2">
                      <Label htmlFor="firstName">Firstname</Label>
                      <Input
                        type="text"
                        id="firstName"
                        placeholder="Firstname"
                        required
                      />
                    </div>
                    <div className="grid gap-2">
                      <Label htmlFor="lastName">Lastname</Label>
                      <Input
                        type="text"
                        id="lastName"
                        placeholder="Lastname"
                        required
                      />
                    </div>
                  </div>
                  {/* for username */}
                  <div className="grid gap-2">
                    <Label htmlFor="username">Username</Label>
                    <Input
                      type="text"
                      id="username"
                      placeholder="Username"
                      required
                    />
                  </div>
                  {/* for email */}
                  <div className="grid gap-2">
                    <Label htmlFor="email">Email</Label>
                    <Input
                      type="email"
                      id="email"
                      placeholder="Enter your email"
                      required
                    />
                  </div>
                  {/* for password */}
                  <div className="grid gap-2">
                    <Label htmlFor="password">Password</Label>
                    <Input
                      type="password"
                      id="password"
                      placeholder="Enter your password"
                      required
                    />
                  </div>
                  <div className="grid gap-2">
                    <Button>Register Now</Button>
                  </div>
                </div>
              </form>
            </CardContent>
          </Card>
        </div>
      </div>
    </div>
  );
};

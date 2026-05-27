import { Button } from "@/shared/ui/button"
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from "@/shared/ui/card"
import { Field, FieldLabel } from "@/shared/ui/field"
import { InputOTP, InputOTPGroup, InputOTPSlot } from "@/shared/ui/input-otp"
import { RefreshCcwIcon } from "lucide-react"

export const VerifyOTPForm = () => {
  return (
    <div className="w-full min-h-screen flex flex-col items-center justify-center bg-gray-900 text-white">
      <Card className="w-full max-w-96 bg-black text-white">
        <CardHeader>
          <CardTitle>Verify your login</CardTitle>
          <CardDescription>Enter the verification code we sent to your email address: m@example.com.</CardDescription>
        </CardHeader>
        <CardContent>
          <Field>
            <div className="flex items-center justify-between">
              <FieldLabel htmlFor="otp-verification">Verification code</FieldLabel>
              <Button variant={"outline"} size={"xs"} className="text-black">
                <RefreshCcwIcon/>
                Resend code
              </Button>
            </div>
            <InputOTP maxLength={6} id="otp-verification" required>
            <InputOTPGroup className="*:data-[slot=input-otp-slot]:h-14 *:data-[slot=input-otp-slot]:w-12 *:data-[slot=input-otp-slot]:text-xl mx-auto">
            <InputOTPSlot index={0} />
            <InputOTPSlot index={1} />
            <InputOTPSlot index={2} />
            <InputOTPSlot index={3} />
            <InputOTPSlot index={4} />
            <InputOTPSlot index={5} />
            </InputOTPGroup>
            </InputOTP>
          </Field>
        </CardContent>
        <CardFooter className="bg-black text-white">
          <Button type="submit" variant={'secondary'} className="w-full p-5 shadow-lg cursor-pointer">Verify</Button>
        </CardFooter>
      </Card>
    </div>
  )
}

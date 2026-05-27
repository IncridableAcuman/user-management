import {Routes,Route} from "react-router-dom";
import {DashboardPage} from "@/pages/dashboard/ui/dashboard-page.tsx";
import {ResetPasswordPage} from "@/pages/reset-password/ui/reset-password-page";
import {ForgotPasswordPage} from "@/pages/forgot-password/ui/forgot-password-page";
import { VerifyOTPPage } from "@/pages/verify-otp";
import { AuthPage } from "@/pages/auth";

const App = () => {
    return (
        <>
           <Routes>
               <Route path={"/"} element={<DashboardPage/>} />
               <Route path="/reset-password" element={<ResetPasswordPage/>} />
               <Route path="/forgot-password" element={<ForgotPasswordPage/>} />
               <Route path="/verify-otp" element={<VerifyOTPPage/>} />
               <Route path="/auth" element={<AuthPage/>} />
           </Routes>
        </>
    )
}
export default App;
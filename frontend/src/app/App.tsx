import {Routes,Route} from "react-router-dom";
import DashboardPage from "@/pages/dashboard/ui/dashboard-page.tsx";
import LoginPage from "@/pages/login/ui/login-page";
import RegisterPage from "@/pages/register/ui/register-page";
import ResetPasswordPage from "@/pages/reset-password/ui/reset-password-page";
import ForgotPasswordPage from "@/pages/forgot-password/ui/forgot-password-page";

const App = () => {
    return (
        <>
           <Routes>
               <Route path={"/"} element={<DashboardPage/>} />
               <Route path="/login" element={<LoginPage/>} />
               <Route path="/register" element={<RegisterPage/>} />
               <Route path="/reset-password" element={<ResetPasswordPage/>} />
               <Route path="/forgot-password" element={<ForgotPasswordPage/>} />
           </Routes>
        </>
    )
}
export default App;
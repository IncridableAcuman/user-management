import { Routes, Route } from "react-router-dom";
import { ResetPasswordPage } from "@/pages/reset-password/ui/reset-password-page";
import { ForgotPasswordPage } from "@/pages/forgot-password/ui/forgot-password-page";
import { VerifyOTPPage } from "@/pages/verify-otp";
import { AuthPage } from "@/pages/auth";
import { DashboardPage } from "@/pages/dashboard";
import { ProfilePage } from "@/pages/profile";
import { SettingsPage } from "@/pages/settings";

const App = () => {
  return (
    <>
      <Routes>
        <Route path="/reset-password" element={<ResetPasswordPage />} />
        <Route path="/forgot-password" element={<ForgotPasswordPage />} />
        <Route path="/verify-otp" element={<VerifyOTPPage />} />
        <Route path="/auth" element={<AuthPage />} />
        <Route path="/" element={<DashboardPage />} />
        <Route path="/profile" element={<ProfilePage/>} />
        <Route path="/settings" element={<SettingsPage/>} />
      </Routes>
    </>
  );
};
export default App;

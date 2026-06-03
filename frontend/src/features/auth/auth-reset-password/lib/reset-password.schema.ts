import z from "zod";

export const loginSchema = z.object({
    token: z
        .string()
        .trim(),
    password: z
        .string()
        .trim()
        .min(8, "Password must be greater than 8 characters")
        .max(50, "Password must be less than 50 character"),
    confirmPassword: z
        .string()
        .trim()
        .min(8, "Confirm password must be greater than 8 characters")
        .max(50, "Confirm password must be less than 50 character")
})
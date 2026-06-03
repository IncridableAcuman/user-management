import z from "zod";

export const loginSchema = z.object({
    email: z
        .string()
        .trim()
        .toLowerCase()
        .email("Invalid email format"),
    password: z
        .string()
        .trim()
        .min(8, "Password must be greater than 8 characters")
        .max(50, "Password must be less than 50 characters")
})
import z from "zod";

export const registerSchema = z.object({
    username: z
        .string()
        .trim()
        .toLowerCase()
        .min(3, "Username length must be greater than 3 character")
        .max(50, "Username length must be less than 50 character"),
    email: z
        .string()
        .trim()
        .toLowerCase()
        .email("Invalid email format"),
    password: z
        .string()
        .trim()
        .min(8, "Password length must be greater than 8 characters")
        .max(50, "Password must be less than 50 characters")
})
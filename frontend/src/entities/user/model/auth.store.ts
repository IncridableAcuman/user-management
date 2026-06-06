import type { IUser } from "../types/user.types";
import { create } from 'zustand'

type AuthStoreType = {
    loading:boolean;
    user:IUser;
    setUser:(user:IUser)=>void;
    setLoading: (loading:boolean)=> void;
}
export const authStore = create<AuthStoreType>(set=>({
    loading:false,
    user: {} as IUser,
    setLoading: bool=> set({loading:bool}),
    setUser: user=> set({user})
}))
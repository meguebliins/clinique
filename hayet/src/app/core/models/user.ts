import { Roles } from "./roles";
export interface User {
    _id?: string;
    img?: string;
    username ?: string;
    firstName?: string;
    lastName?: string;
    role?: Roles;
    token?: string;
    user_email ?: string ,
    user_password ?: string, 
    user_role ?:string,
}

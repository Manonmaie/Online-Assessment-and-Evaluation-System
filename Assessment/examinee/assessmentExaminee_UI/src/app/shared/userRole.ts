import { User } from "./user";
import { RoleMaster } from "./roleMaster";

export class UserRoleId{
    userId: number;
    roleId: number;
}

export class UserRole{
    userRoleKey: UserRoleId;
    user: User;
    role: RoleMaster;
}
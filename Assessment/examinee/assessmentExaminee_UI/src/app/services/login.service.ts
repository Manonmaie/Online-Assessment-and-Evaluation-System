import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable, of } from "rxjs";
import { UserRole, UserRoleId } from "../shared/userRole";
import { baseURL } from "../shared/baseurl";
import { User } from '../shared/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  userRole: UserRole;

  constructor(private http: HttpClient) { }

  getUserRoleFromUsernameAndPassword(userName: string, password: string): Observable<UserRole>{
    return this.http.get<UserRole>(baseURL + 'username/' + userName + '/password/' + password + '/userRole');
  }

  setUserRole(userRole: UserRole): void{
    this.userRole = userRole;
  }

  getUserRole(): UserRole{
    return this.userRole;
  }
}

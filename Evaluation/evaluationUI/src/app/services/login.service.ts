import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable, of } from "rxjs";
import { UserRole, UserRoleId } from "../shared/userRole";
import { baseURL } from "../shared/baseurl";
import { User } from '../shared/user';
import { Evaluator } from '../shared/evaluator';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  userRole: UserRole;
  evaluator: Evaluator;

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

  getEvaluatorFromRegistrationNoAndPassword(evaluatorCode: string, password: string): Observable<Evaluator>{
    return this.http.get<Evaluator>(baseURL + 'registrationNo/' + evaluatorCode + '/password/' + password + '/evaluator');
  }
  
  setEvaluator(Evaluator: Evaluator): void{
    this.evaluator = Evaluator;
  }

  getEvaluator(): Evaluator{
    return this.evaluator;
  }
}

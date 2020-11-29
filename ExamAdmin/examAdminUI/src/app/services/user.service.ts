import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { baseURL } from '../shared/baseurl';
import { User } from '../shared/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getUser(userName: string): Observable<User>{
    return this.http.get<User>(baseURL + 'user/' + userName);
  }
}

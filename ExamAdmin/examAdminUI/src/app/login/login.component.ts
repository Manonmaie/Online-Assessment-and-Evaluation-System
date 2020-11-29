import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import {Observable, of} from 'rxjs';
import { User } from '../shared/user';
import { resetError, setError } from '../shared/error';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  userName: string;
  password: string;
  user: User;
  displayErrorMessage: boolean = false;
  errorMessage: String;

  constructor(private userService: UserService, public route: Router) { }

  ngOnInit(): void {
  }

  getUser(userName: string): void{
    this.userService.getUser(userName).subscribe((user) => this.user = user);
  }

  onSubmit(){
    if(this.userName==null || this.userName==""){
      setError("userName","Username is Required");
    }
    else{
      resetError("userName");
      if(this.password==null || this.password==""){
        setError("password","Password is Required");
      }
      else {
        resetError("password");
        this.getUser(this.userName);
        setTimeout(()=>{
          if(this.user == null){
            setError("userName", "No user exists, Check Again!!");
          }
          else{
            resetError("userName");
            if(this.password!=this.user.password){
              setError("password","Wrong Password!! Please Check the Password Again");
            }   
            else{
              resetError("password");
              if(this.user.status!="ACTIVE"){
                setError("userName", "You are not a ACTIVE user, activate your account before loggin in!");
              }
              else{
                resetError("password");
                this.route.navigate(['/examdrives']);
              }
            }
          }
        },500); 
      }
    }
  }
}

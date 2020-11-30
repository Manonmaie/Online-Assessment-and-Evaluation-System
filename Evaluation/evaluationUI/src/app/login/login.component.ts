import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from "../services/login.service";
import { Evaluator } from '../shared/evaluator';
import { UserRole } from '../shared/userRole';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  userName: string;
  password: string;
  userRole: UserRole;
  evaluator: Evaluator;
  displayErrorMessage: boolean = false;
  errorMessage: String;

  constructor(private loginService: LoginService, private activeRoute: ActivatedRoute, public route: Router) { }

  ngOnInit(): void {
  }

  loginButtonClick(){
    if (document.forms["signIn"]["username"].value === "") {
      this.displayErrorMessage = true;
      this.errorMessage = "Please enter Username. It is a mandatory field";
    }
    else if(document.forms["signIn"]["password"].value === ""){
      this.displayErrorMessage = true;
      this.errorMessage = "Please enter Password. It is a mandatory field";
    }
    else{
      this.loginService.getUserRoleFromUsernameAndPassword(this.userName, this.password).subscribe((userRole) =>{
        this.loginService.setUserRole(userRole);
        if(userRole == null){
          this.displayErrorMessage = true;
          this.errorMessage = "Invalid Username/Registration No or Password!";
        }
        else if(userRole.user.status == "INACTIVE"){
          this.displayErrorMessage = true;
          this.errorMessage = "Can't log you in! You are an INACTIVE User.";
        }
        else{
          if(userRole.role.roleName == "Evaluator"){
            this.loginService.getEvaluatorFromRegistrationNoAndPassword(this.userName, this.password).subscribe((evaluator) => {
              this.loginService.setEvaluator(evaluator);
              this.route.navigate(['/examdrives/']);
            });
          }
          else{
            this.displayErrorMessage = true;
            this.errorMessage = "You are not an authorized user";
          }
        }
      });
    }
    if(this.displayErrorMessage == true){
      setTimeout(function() {
        this.displayErrorMessage = false;
        console.log("display = " + this.displayErrorMessage);
      }.bind(this), 3000);
    }
  }

}

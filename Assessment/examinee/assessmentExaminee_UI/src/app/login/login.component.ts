import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from "../services/login.service";
import { UserRole } from '../shared/userRole';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  emailId: string;
  password: string;
  userRole: UserRole;

  constructor(private loginService: LoginService, private activeRoute: ActivatedRoute, public route: Router) { }

  ngOnInit(): void {
  }

  loginButtonClick(){
    if (document.forms["signIn"]["username"].value === "") {
      alert("Please enter Username. It is a mandatory field");
    }
    else if(document.forms["signIn"]["password"].value === ""){
      alert("Please enter Password. It is a mandatory field");
    }
    else{
      this.loginService.getUserRoleFromUsernameAndPassword(this.emailId, this.password).subscribe((userRole) =>{
        this.loginService.setUserRole(userRole);
        if(userRole.role.roleName == "Student"){
          this.route.navigate(['/questionPaper/' + userRole.user.userId]);
        }
        else if(userRole.role.roleName == "Center Admin"){
          this.route.navigate(['/centerAdmin/packageManagement']);
        }
        else if(userRole.role.roleName == "Invizilator"){
          alert("No screen for invizilator to display yet");
        }
        else{
          alert("You are not an authorized user");
        }
      });
    }
  }

}

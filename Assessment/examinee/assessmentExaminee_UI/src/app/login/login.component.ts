import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from "../services/login.service";
import { Examinee } from '../shared/examinee';
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
  examinee: Examinee;

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
      this.loginService.getUserRoleFromUsernameAndPassword(this.userName, this.password).subscribe((userRole) =>{
        this.loginService.setUserRole(userRole);
        if(userRole.role.roleName == "Examinee"){
          // let examinee: Examinee = ;id
          this.loginService.getExamineeFromRegistrationNoAndPassword(this.userName, this.password).subscribe((examinee) => {
            this.loginService.setExaminee(examinee);
            this.route.navigate(['/questionPaper/' + examinee.examineeId]);
          });
          // this.route.navigate(['/questionPaper/' + userRole.user.userId]);
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

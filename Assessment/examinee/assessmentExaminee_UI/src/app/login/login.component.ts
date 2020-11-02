import { Component, OnInit } from '@angular/core';
import { Params, ActivatedRoute, Router } from '@angular/router';
import { LoginService } from "../services/login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService, private activeRoute: ActivatedRoute, public route: Router) { }

  ngOnInit(): void {
  }

  loginButtonClick(uname: string, password: string){
    if(uname=="Student"){
      this.route.navigate(['/questionPaper/1']);
    }
    else if(uname=="Center Admin"){
      this.route.navigate(['/centerAdmin/packageManagement']);
    }
    else if(uname=="Invizilator"){
      // this.route.navigate(['/questionPaper/' + examineeId + '/examination/' + questionPaper.qpId + '/batch/' + questionPaper.asBatch.batchId]);
    }
    else{
      alert("You are not an authorized user");
    }
  }

}

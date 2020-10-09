import { Component, OnInit } from '@angular/core';
import { Examinee } from '../shared/examinee';
import { ExamineeService } from '../services/examinee.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import {resetError, setError} from '../shared/error';

@Component({
  selector: 'app-examinee-add',
  templateUrl: './examinee-add.component.html',
  styleUrls: ['./examinee-add.component.scss']
})
export class ExamineeAddComponent implements OnInit {
  examinee = {examineeCode: null, examineeName: null, examineePassword: null, examineeBranch: null, examineeEmail: null, examineeCollege: null}
  constructor(private examineeService: ExamineeService, public route: Router) { }
  ngOnInit(): void {
  }

  addExaminee(examinee: Examinee): void{
    this.examineeService.addExaminee(examinee).subscribe((examinee) => this.examinee = examinee);
  }

  onSubmit(){
    if(this.examinee.examineeName==null){
      setError("examineeName","Student Name is Required");
    }
    else{
      resetError("examineeName");
      if(this.examinee.examineeCode==null){
        setError("examineeCode","Student Code is Required");
      }
      else{
        resetError("examineeCode");
        if(this.examinee.examineePassword==null){
          setError("examineePassword","Student Password is Required");
        }
        else{
          this.addExaminee(this.examinee);
          setTimeout(() => {
            this.route.navigate(['/examinees']);
          },500);
        }
      }
    }
  }
}

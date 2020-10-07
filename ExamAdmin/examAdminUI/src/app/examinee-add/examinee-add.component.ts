import { Component, OnInit } from '@angular/core';
import { Examinee } from '../shared/examinee';
import { ExamineeService } from '../services/examinee.service';
import { Params, ActivatedRoute, Router } from '@angular/router';

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
    this.addExaminee(this.examinee);
    this.route.navigate(['/examinees']);
  }
}

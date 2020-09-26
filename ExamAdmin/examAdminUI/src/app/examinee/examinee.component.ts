import { Component, OnInit } from '@angular/core';
import {Examinee} from '../shared/examinee';
import {ExamineeService} from '../services/examinee.service';
import {Observable, of} from 'rxjs';

@Component({
  selector: 'app-examinee',
  templateUrl: './examinee.component.html',
  styleUrls: ['./examinee.component.scss']
})
export class ExamineeComponent implements OnInit {
  examinees: Examinee[];
  constructor(private examineeService:ExamineeService) { }

  ngOnInit(): void {
    this.getExaminees();
  }

  getExaminees():void {
    this.examineeService.getExaminees().subscribe((examinees) => this.examinees = examinees);
  }

  deleteExaminee(examinee: Examinee): void{
    if(confirm("Are you sure to delete the "+examinee.examineeName+" student")){
      this.examineeService.deleteExaminee(examinee.examineeId).subscribe( response => {
        // alert(response.message);
        this.getExaminees();
      });
    }
  }
}

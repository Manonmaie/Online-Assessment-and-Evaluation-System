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
  searchText: any;
  pageNo: number = 1;
  itemsPage: number = 25;
  constructor(private examineeService:ExamineeService) { }

  ngOnInit(): void {
    this.getExaminees();
  }

  getExaminees():void {
    this.examineeService.getExaminees().subscribe((examinees) => {
      examinees = examinees.sort((obj1, obj2) => {
        if (obj1.examineeCode > obj2.examineeCode) {
            return 1;
        }
        if (obj1.examineeCode < obj2.examineeCode) {
            return -1;
        }
        return 0;
      });
      setTimeout(()=>{
        this.examinees = examinees;
      },500);
    });
  }

  deleteExaminee(examinee: Examinee): void{
    if(confirm("Are you sure to delete the "+examinee.examineeName+" student")){
      this.examineeService.deleteExaminee(examinee.examineeId).subscribe( response => {
        // alert(response.message);
        this.getExaminees();
      });
    }
  }

  updatePasswords(): void{
    if(confirm("Are you sure to update passwords of all Students")){
      this.examineeService.updatePasswords().subscribe( (examinees) => this.examinees=examinees);
      window.location.reload();
    }
  }
}

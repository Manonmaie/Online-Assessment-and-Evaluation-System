import { Component, OnInit } from '@angular/core';
import {Examdrive} from '../shared/examdrive';
import {ExamdriveService} from '../services/examdrive.service';
import {Observable, of} from 'rxjs';

@Component({
  selector: 'app-examdrive',
  templateUrl: './examdrive.component.html',
  styleUrls: ['./examdrive.component.scss']
})
export class ExamdriveComponent implements OnInit {
  examdrives: Examdrive[];
  searchText: any;
  pageNo: number = 1;
  itemsPage: number = 25;
  constructor(private examdriveService:ExamdriveService) { }

  ngOnInit(): void {
    this.getExamdrives();
  }

  getExamdrives(): void{
    this.examdriveService.getExamdrives().subscribe((examdrives) => {
      examdrives = examdrives.reverse()
      this.examdrives = examdrives
    });
  }

  deleteExamdrive(examdrive: Examdrive): void{
    if(confirm("Are you sure to delete the "+examdrive.examdriveName+" drive")){
      this.examdriveService.deleteExamdrive(examdrive.examdriveId).subscribe( response => {
        // alert(response.message);
        this.getExamdrives();
      });
    }
  }
}

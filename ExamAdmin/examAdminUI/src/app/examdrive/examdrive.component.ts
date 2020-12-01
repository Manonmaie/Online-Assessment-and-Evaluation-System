import { Component, OnInit } from '@angular/core';
import {Examdrive} from '../shared/examdrive';
import {ExamdriveService} from '../services/examdrive.service';
import {PackageManagementService} from '../services/package-management.service';
import {Observable, of} from 'rxjs';
import {resetError, setError} from '../shared/error';

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
  MKey: string;
  QPKey: string;
  constructor(private examdriveService:ExamdriveService, private packageManagementService: PackageManagementService) { }

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

  importMarks(): void{
    if(this.MKey==null || this.MKey==""){
      setError("MarksKey", "Key is Required");
    }
    else{
      //TODO-Admin - Import Marks
    }
  }

  importQuestionPapers(): void{
    if(this.QPKey==null || this.QPKey==""){
      setError("QuestionPaperKey", "Key is Required");
    }
    else{
      this.packageManagementService.importQPack(this.QPKey).subscribe();
    }
  }
}

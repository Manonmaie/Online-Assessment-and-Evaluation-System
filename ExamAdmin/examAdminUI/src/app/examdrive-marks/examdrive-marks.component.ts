import { Component, OnInit } from '@angular/core';
import {ExamdriveService } from '../services/examdrive.service';
import { Params, ActivatedRoute } from '@angular/router';
import { Examdrive } from '../shared/examdrive';
import {Observable, of} from 'rxjs';
import {ExamineeBatchService } from '../services/examinee-batch.service';
import { ExamineeBatch } from '../shared/examinee-batch';

@Component({
  selector: 'app-examdrive-marks',
  templateUrl: './examdrive-marks.component.html',
  styleUrls: ['./examdrive-marks.component.scss']
})
export class ExamdriveMarksComponent implements OnInit {
  examdrive: Examdrive;
  examineeBatchList: ExamineeBatch[];
  searchText: any;
  pageNo: number = 1;
  itemsPage: number = 25;
  constructor(private examdriveService: ExamdriveService, private examineeBatchService: ExamineeBatchService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const examdriveId = this.route.snapshot.params['id'];
    this.getExamdrive(examdriveId);
    this.getExamineeBatchByExamdriveId(examdriveId);
  }

  getExamdrive(id: number): void{
    this.examdriveService.getExamdrive(id).subscribe((examdrive) => this.examdrive=examdrive);
  }

  getExamineeBatchByExamdriveId(id: number): void{
    this.examineeBatchService.getExamineeBatchByExamdriveId(id).subscribe((examineeBatchList) => this.examineeBatchList=examineeBatchList);
  }
}

import { Component, OnInit } from '@angular/core';
import {ExamdriveService } from '../services/examdrive.service';
import { Params, ActivatedRoute } from '@angular/router';
import { Examdrive } from '../shared/examdrive';
import {Observable, of} from 'rxjs';
import {ExamineeBatchService } from '../services/examinee-batch.service';
import { ExamineeBatch } from '../shared/examinee-batch';
import {ExcelServicesService} from '../services/excel-services.service';

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
  constructor(private examdriveService: ExamdriveService, private examineeBatchService: ExamineeBatchService, private excelService: ExcelServicesService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const examdriveId = this.route.snapshot.params['id'];
    this.getExamdrive(examdriveId);
    this.getExamineeBatchByExamdriveId(examdriveId);
  }

  getExamdrive(id: number): void{
    this.examdriveService.getExamdrive(id).subscribe((examdrive) => this.examdrive=examdrive);
  }

  getExamineeBatchByExamdriveId(id: number): void{
    this.examineeBatchService.getExamineeBatchByExamdriveId(id).subscribe((examineeBatchList) => {
      examineeBatchList = examineeBatchList.sort((obj1, obj2) => {
        if (obj1.examinee.examineeCode > obj2.examinee.examineeCode) {
            return 1;
        }
        if (obj1.examinee.examineeCode < obj2.examinee.examineeCode) {
            return -1;
        }
        return 0;
      });
      setTimeout(()=>{
        this.examineeBatchList = examineeBatchList;
      },500);
    });
  }

  fileName: string;

  exportAsExcel(): void{
    // this.fileName = "Marks Reports of ".concat(this.examdrive.examdriveCode.toString());
    // this.fileName = this.fileName.concat(" in ");
    // this.fileName = this.fileName.concat(this.examdrive.course.courseCode.toString());
    this.fileName = this.examdrive.examdriveCode.toString();
    this.excelService.tableToExcel("drive-marks-list",this.fileName);
  }
}

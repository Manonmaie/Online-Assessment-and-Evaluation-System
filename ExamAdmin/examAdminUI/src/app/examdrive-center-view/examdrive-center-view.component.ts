import { Component, OnInit } from '@angular/core';
import {ExamdriveService } from '../services/examdrive.service';
import { Params, ActivatedRoute } from '@angular/router';
import { Examdrive } from '../shared/examdrive';
import { Batch } from '../shared/batch';
import {Observable, of} from 'rxjs';
import { CenterService } from '../services/center.service';
import { Center } from '../shared/center';
import { BatchService } from '../services/batch.service';

@Component({
  selector: 'app-examdrive-center-view',
  templateUrl: './examdrive-center-view.component.html',
  styleUrls: ['./examdrive-center-view.component.scss']
})
export class ExamdriveCenterViewComponent implements OnInit {
  examdrive: Examdrive;
  batches: Batch[] = new Array();
  center: Center;
  constructor(private examdriveService:ExamdriveService, private batchService:BatchService, private centerService: CenterService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const examdriveId = this.route.snapshot.params['eid'];
    const centerId = this.route.snapshot.params['cid'];
    this.getExamdrive(examdriveId);
    this.getCenter(centerId);
    setTimeout(() => {
      this.getBatches(centerId);
    },500);
  }

  getExamdrive(id: number): void{
    this.examdriveService.getExamdrive(id).subscribe((examdrive) => this.examdrive=examdrive);
    this.setBatches(id);
  }

  getCenter(id: number): void{
    this.centerService.getCenter(id).subscribe((center) => this.center=center);
  }

  getBatches(id: number): void{
    this.batches = this.examdrive.batchList;
    this.batches = this.batches.filter(b => b.center.centerId==id);
  }

  setBatches(id: number): void{
    this.batchService.getBatchesByExamdrive(id).subscribe((batches) => this.examdrive.batchList=batches);
  }
}

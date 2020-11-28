import { Component, OnInit } from '@angular/core';
import { Batch } from '../shared/batch';
import { ExamineeBatch } from '../shared/examinee-batch';
import { BatchService } from '../services/batch.service';
import { ExamineeBatchService } from '../services/examinee-batch.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-examdrive-batch-view',
  templateUrl: './examdrive-batch-view.component.html',
  styleUrls: ['./examdrive-batch-view.component.scss']
})
export class ExamdriveBatchViewComponent implements OnInit {
  batch: Batch;
  examineeBatches: ExamineeBatch[];
  searchText: any;
  pageNo: number = 1;
  itemsPage: number = 25;
  constructor(private batchService: BatchService, private examineeBatchService: ExamineeBatchService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const batchId = this.route.snapshot.params['id'];
    this.getBatch(batchId);
    this.getExamineesOfBatch(batchId);
  }

  getExamineesOfBatch(batchId: number): void{
    this.examineeBatchService.getExamineesOfBatch(batchId).subscribe(examineeBatches => {
      examineeBatches = examineeBatches.sort((obj1, obj2) => {
        if (obj1.examinee.examineeCode > obj2.examinee.examineeCode) {
            return 1;
        }
        if (obj1.examinee.examineeCode < obj2.examinee.examineeCode) {
            return -1;
        }
        return 0;
      });
      setTimeout(()=>{
        this.examineeBatches = examineeBatches;
      },500);
    });
  }

  getBatch(batchId: number): void{
    this.batchService.getBatch(batchId).subscribe(batch => this.batch = batch);
  }
}

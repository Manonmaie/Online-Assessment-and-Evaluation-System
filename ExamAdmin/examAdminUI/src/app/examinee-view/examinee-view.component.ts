import { Component, OnInit } from '@angular/core';
import { ExamineeService } from '../services/examinee.service';
import { ExamineeBatchService } from '../services/examinee-batch.service';
import { Params, ActivatedRoute } from '@angular/router';
import {Observable, of} from 'rxjs';
import { Examinee } from '../shared/examinee';
import { ExamineeBatch } from '../shared/examinee-batch';

@Component({
  selector: 'app-examinee-view',
  templateUrl: './examinee-view.component.html',
  styleUrls: ['./examinee-view.component.scss']
})
export class ExamineeViewComponent implements OnInit {
  examinee: Examinee;
  searchText: any;
  examineeBatchList: ExamineeBatch[];
  pageNo: number = 1;
  itemsPage: number = 25;
  constructor(private examineeService: ExamineeService, private examineeBatchService: ExamineeBatchService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const examineeId = this.route.snapshot.params['id'];
    this.getExaminee(examineeId);
    this.setExamineeBatchList(examineeId);
  }

  getExaminee(id: number): void{
    this.examineeService.getExaminee(id).subscribe((examinee)=> this.examinee=examinee);
  }

  setExamineeBatchList(id: number): void{
    this.examineeBatchService.getExamineeBatchByExamineeId(id).subscribe((examineeBatchList)=> this.examineeBatchList=examineeBatchList);
  }
}

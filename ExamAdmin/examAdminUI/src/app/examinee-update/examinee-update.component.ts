import { Component, OnInit } from '@angular/core';
import { Examinee } from '../shared/examinee';
import { ExamineeBatch } from '../shared/examinee-batch';
import { ExamineeService } from '../services/examinee.service';
import { ExamineeBatchService } from '../services/examinee-batch.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import {resetError, setError} from '../shared/error';

@Component({
  selector: 'app-examinee-update',
  templateUrl: './examinee-update.component.html',
  styleUrls: ['./examinee-update.component.scss']
})
export class ExamineeUpdateComponent implements OnInit {
  examinee: Examinee;
  examineeBatch: ExamineeBatch;
  examineeId: number;
  examineeBatchList: ExamineeBatch[];
  searchText: any;
  pageNo: number = 1;
  itemsPage: number = 25;
  constructor(private examineeService: ExamineeService, private examineeBatchService: ExamineeBatchService, private route: ActivatedRoute, public router: Router) { }

  ngOnInit(): void {
    this.examineeId = this.route.snapshot.params['id'];
    this.getExaminee(this.examineeId);
    this.setExamineeBatchList(this.examineeId);
  }

  getExaminee(id: number): void{
    this.examineeService.getExaminee(id).subscribe((examinee)=> this.examinee=examinee);
  }

  updateExaminee(id: number, examinee: Examinee): void{
    this.examineeService.updateExaminee(id,examinee).subscribe((examinee)=>this.examinee=examinee);
  }

  onSubmit(){
    if(this.examinee.examineeName==null||this.examinee.examineeName==""){
      setError("examineeName","Student Name is Required");
    }
    else{
      resetError("examineeName");
      if(this.examinee.examineeCode==null||this.examinee.examineeCode==""){
        setError("examineeCode","Student Code is Required");
      }
      else{
        resetError("examineeCode");
        // if(this.examinee.examineePassword==null||this.examinee.examineePassword==""){
        //   setError("examineePassword","Student Password is Required");
        // }
        // else{
          this.updateExaminee(this.examineeId, this.examinee);
          setTimeout(() => {
            this.router.navigate(['/examinees']);
          },500);
        // }
      }
    }
  }

  updateExamineeBatch(examineeBatch: ExamineeBatch): void{
    this.examineeBatchService.updateExamineeBatch(examineeBatch.examineeBatchId.examineeId, examineeBatch.examineeBatchId.batchId, examineeBatch)
        .subscribe((examineeBatch)=>this.examineeBatch=examineeBatch);
  }

  setExamineeBatchList(id: number): void{
    this.examineeBatchService.getExamineeBatchByExamineeId(id).subscribe((examineeBatchList)=> {
      examineeBatchList = examineeBatchList.reverse();
      this.examineeBatchList=examineeBatchList
    });
  }
}

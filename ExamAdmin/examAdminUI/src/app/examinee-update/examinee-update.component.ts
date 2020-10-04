import { Component, OnInit } from '@angular/core';
import { Examinee } from '../shared/examinee';
import { ExamineeBatch } from '../shared/examinee-batch';
import { ExamineeService } from '../services/examinee.service';
import { ExamineeBatchService } from '../services/examinee-batch.service';
import { Params, ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-examinee-update',
  templateUrl: './examinee-update.component.html',
  styleUrls: ['./examinee-update.component.scss']
})
export class ExamineeUpdateComponent implements OnInit {
  examinee: Examinee;
  examineeBatch: ExamineeBatch;
  examineeId: number;
  constructor(private examineeService: ExamineeService, private examineeBatchService: ExamineeBatchService, private route: ActivatedRoute, public router: Router) { }

  ngOnInit(): void {
    this.examineeId = this.route.snapshot.params['id'];
    this.getExaminee(this.examineeId);
  }

  getExaminee(id: number): void{
    this.examineeService.getExaminee(id).subscribe((examinee)=> this.examinee=examinee);
  }

  updateExaminee(id: number, examinee: Examinee): void{
    this.examineeService.updateExaminee(id,examinee).subscribe((examinee)=>this.examinee=examinee);
  }

  onSubmit(){
    this.updateExaminee(this.examineeId, this.examinee);
    this.router.navigate(['/examineeupdate',this.examineeId]);
  }

  updateExamineeBatch(examineeBatch: ExamineeBatch): void{
    this.examineeBatchService.updateExamineeBatch(examineeBatch.examineeBatchId.examineeId, examineeBatch.examineeBatchId.batchId, examineeBatch)
        .subscribe((examineeBatch)=>this.examineeBatch=examineeBatch);
  }
}

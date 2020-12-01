import { Component, OnInit } from '@angular/core';
import { QuestionPaper } from "../shared/questionPaper";
import { QuestionPaperService } from "../services/question-paper.service";
import { ExamineeBatch, ExamineeBatchId } from "../shared/examineeBatch";
import { Params, ActivatedRoute, Router } from '@angular/router';
import { Attempt } from '../shared/attempt';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-question-paper',
  templateUrl: './question-paper.component.html',
  styleUrls: ['./question-paper.component.scss']
})
export class QuestionPaperComponent implements OnInit {

  examineeId: number;
  questionPapers: QuestionPaper[];
  showStartExamModalPopup: boolean = false;
  questionPaperPrevious: QuestionPaper;
  lastAttemptPrmoise: Promise<Attempt>;
  lastAttempt: Attempt;

  attempt: Attempt = {attemptId: 0, attemptNumber: 1, attemptStartTime: '', attemptEndTime: null, attemptStatus: 'IN_PROGRESS', asExamineeBatch: null};
  examineeBatch: ExamineeBatch = {examineeBatchIdPK: 1, examineeBatchId: null, examineeBatchStartTime: '', examineeBatchEndTime: null, examineeBatchStatus: 'IN_PROGRESS', examinee: null, batch: null};

  constructor(private questionPaperService: QuestionPaperService, private activeRoute: ActivatedRoute, public route: Router, public datepipe: DatePipe) { 
    
  }

  ngOnInit(): void {
    // const examineeId = 1;
    // const examineeId = this.activeRoute.snapshot.params['examineeId'];
    this.examineeId = this.activeRoute.snapshot.params['examineeId'];
    this.questionPaperService.getQuestionPapers(this.examineeId).subscribe((questionPapers) => this.questionPapers = questionPapers);
  }

  onSelect(questionPaper: QuestionPaper) {
    let examineeId: number = this.examineeId;
    let examineeBatchId: ExamineeBatchId = new ExamineeBatchId();
    examineeBatchId.examineeId = examineeId;
    examineeBatchId.batchId = questionPaper.asBatch.batchId;
    let asExamineeBatch: ExamineeBatch = new ExamineeBatch();
    asExamineeBatch.examineeBatchId = examineeBatchId;
    asExamineeBatch.examinee = null;
    asExamineeBatch.batch = null;
    this.attempt.asExamineeBatch = asExamineeBatch;
    
    let currDateTime: Date = new Date();
    let currDateTimeFormatted: string = this.datepipe.transform(currDateTime, 'yyyy-MM-ddTHH:mm:ss');
    this.attempt.attemptStartTime = currDateTimeFormatted;

    // this.attempt.attemptCode = 'Attempt' + examineeId + questionPaper.asBatch.batchId;

    this.examineeBatch.examineeBatchId = examineeBatchId;
    this.examineeBatch.examineeBatchStartTime = currDateTimeFormatted;

    if(currDateTime >= new Date(questionPaper.asBatch.batchStartTime) && currDateTime <= new Date(questionPaper.asBatch.batchEndTime)){
      this.questionPaperService.getExamineeBatchFromExamineeAndBatchIds(examineeId,questionPaper.asBatch.batchId).subscribe((examineeBatch) => {
        if(examineeBatch.examineeBatchStatus == 'COMPLETED'){
          this.questionPaperPrevious = questionPaper;
          this.showStartExamModalPopup = true;
        }
        else{
          this.showStartExamModalPopup = false;
          this.lastAttemptPrmoise = this.addAttempt(examineeId, questionPaper.asBatch.batchId, this.attempt);
          this.lastAttemptPrmoise.then((res) => {
            // console.log(res);
            this.questionPaperService.setLastAttemptVariable(res);
          });
          examineeBatch.examineeBatchStartTime = currDateTimeFormatted;
          examineeBatch.examineeBatchStatus = "IN_PROGRESS";
          console.log("examineeBatch");
          console.log(examineeBatch);
          this.updateExamineeBatch(examineeId, questionPaper.asBatch.batchId, examineeBatch);
          this.questionPaperService.setSelectedQuestionPaper(questionPaper);
          this.route.navigate(['/questionPaper/' + examineeId + '/examination/' + questionPaper.qpId + '/batch/' + questionPaper.asBatch.batchId]);
          // alert(this.showStartExamModalPopup);
        }
      });
    }
    else{
      this.questionPaperPrevious = questionPaper;
      this.showStartExamModalPopup = true;
    }
  }

  async addAttempt(examineeId: number, batchId: number, attempt: Attempt): Promise<Attempt>{
    // this.questionPaperService.postAttemptForExamineeAndBatch(examineeId, batchId, attempt).subscribe((attempt) => this.lastAttempt = attempt);
    try {
        this.lastAttempt = await this.questionPaperService.postAttemptForExamineeAndBatch(examineeId, batchId, attempt);
        return this.lastAttempt;
      } catch(e) {
          console.log(e);
      }
  }

  updateExamineeBatch(examineeId: number, batchId: number, examineeBatch: ExamineeBatch): void{
    this.questionPaperService.updateExamineeBatchStartTimeAndStatus(examineeId,batchId,examineeBatch).subscribe((examineeBatch) => this.examineeBatch = examineeBatch);
  }

}
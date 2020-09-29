import { Component, OnInit } from '@angular/core';
import { QuestionPaper } from "../shared/questionPaper";
import { QuestionPaperService } from "../services/question-paper.service";
import { ExamineeBatch, ExamineeBatchId } from "../shared/examineeBatch";
import { Params, ActivatedRoute, Router } from '@angular/router';
import { Attempt } from '../shared/attempt';
import { DatePipe } from '@angular/common'

@Component({
  selector: 'app-question-paper',
  templateUrl: './question-paper.component.html',
  styleUrls: ['./question-paper.component.scss']
})
export class QuestionPaperComponent implements OnInit {

  questionPapers: QuestionPaper[];
  showStartExamModalPopup: boolean = false;
  questionPaperPrevious: QuestionPaper;

  attempt: Attempt = {attemptId: 0, attemptCode: '', attemptNumber: 1, attemptStartTime: '', attemptEndTime: null, attemptStatus: 'IN_PROGRESS', asExamineeBatch: null};
  constructor(private questionPaperService: QuestionPaperService, private activeRoute: ActivatedRoute, public route: Router, public datepipe: DatePipe) { }

  ngOnInit(): void {
    const examineeId = 1;
    this.questionPaperService.getQuestionPapers(examineeId).subscribe((questionPapers) => this.questionPapers = questionPapers);
    // this.questionPapers = this.questionPaperService.getQuestionPapers()
  }

  onSelect(questionPaper: QuestionPaper) {
    let examineeId: number = 1;
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

    this.attempt.attemptCode = 'Attempt' + examineeId + questionPaper.asBatch.batchId;

    if(currDateTime >= new Date(questionPaper.asBatch.batchStartTime) && currDateTime <= new Date(questionPaper.asBatch.batchEndTime)){
      this.showStartExamModalPopup = false;
      this.addAttempt(examineeId, questionPaper.asBatch.batchId, this.attempt);
      this.route.navigate(['/examination/' + questionPaper.qpId]);
      // (<HTMLInputElement> document.getElementById("StartButton_"+questionPaper.qpId.toString())).disabled = false;
    }
    else{
      this.questionPaperPrevious = questionPaper;
      this.showStartExamModalPopup = true;
      // (<HTMLInputElement> document.getElementById("StartButton_"+questionPaper.qpId.toString())).disabled = true;
    }
  }

  addAttempt(examineeId: number, batchId: number, attempt: Attempt): void{
    this.questionPaperService.postAttemptForExamineeAndBatch(examineeId, batchId, attempt).subscribe((attempt) => this.attempt = attempt);
  }

}

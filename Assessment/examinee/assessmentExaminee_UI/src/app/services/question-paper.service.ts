import { Injectable } from '@angular/core';
import { QuestionPaper } from "../shared/questionPaper";
import { Attempt } from "../shared/attempt";
// import { QUESTIONPAPERS } from "../shared/questionPapers";
import { HttpClient } from "@angular/common/http";
import { baseURL } from "../shared/baseurl";
import { Observable, of } from "rxjs";
import { ExamineeBatch } from '../shared/examineeBatch';

@Injectable({
  providedIn: 'root'
})
export class QuestionPaperService {

  lastAttempt: Attempt;
  selectedQuestionPaper: QuestionPaper;

  constructor(private http: HttpClient) { }

  setLastAttemptVariable(attempt: Attempt): void {
    this.lastAttempt = attempt;
    console.log("In qp service");
    console.log(this.lastAttempt);
  }

  getLastAttemptVariable(): Attempt {
    return this.lastAttempt;
  }

  setSelectedQuestionPaper(qp: QuestionPaper): void {
    this.selectedQuestionPaper = qp;
  }

  getSelectedQuestionPaper(): QuestionPaper {
    return this.selectedQuestionPaper;
  }

  getQuestionPapers(examineeId: number): Observable<QuestionPaper[]>{
    return this.http.get<QuestionPaper[]>(baseURL + 'examinee/' + examineeId + '/questionPapers');
  }

  async postAttemptForExamineeAndBatch(examineeId: number, batchId: number, attempt: Attempt){
    return await this.http.post<Attempt>(baseURL +  'examinee/' + examineeId + '/batch/' + batchId + '/attempt', attempt).toPromise();
  }

  updateExamineeBatchStartTimeAndStatus(examineeId: number, batchId: number, examineeBatch: ExamineeBatch): Observable<ExamineeBatch>{
    return this.http.put<ExamineeBatch>(baseURL + 'examinee/' + examineeId + '/batch/' + batchId + '/examineeBatch', examineeBatch);
  }

  getExamineeBatchFromExamineeAndBatchIds(examineeId: number, batchId: number): Observable<ExamineeBatch>{
    return this.http.get<ExamineeBatch>(baseURL + 'examinee/' + examineeId + '/batch/' + batchId + '/examineeBatch');
  }
  
  // getQuestionPapers(): QuestionPaper[]{
  //   return QUESTIONPAPERS;
  // }
}

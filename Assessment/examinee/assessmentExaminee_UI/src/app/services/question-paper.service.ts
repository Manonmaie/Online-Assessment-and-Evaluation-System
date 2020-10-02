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

  constructor(private http: HttpClient) { }

  getQuestionPapers(examineeId: number): Observable<QuestionPaper[]>{
    return this.http.get<QuestionPaper[]>(baseURL + 'examinee/' + examineeId + '/questionPapers');
  }

  postAttemptForExamineeAndBatch(examineeId: number, batchId: number, attempt: Attempt): Observable<Attempt>{
    return this.http.post<Attempt>(baseURL +  'examinee/' + examineeId + '/batch/' + batchId + '/attempt', attempt);
  }

  updateExamineeBatchStartTimeAndStatus(examineeId: number, batchId: number, examineeBatch: ExamineeBatch): Observable<ExamineeBatch>{
    return this.http.put<ExamineeBatch>(baseURL + 'examinee/' + examineeId + '/batch/' + batchId + '/examineeBatch', examineeBatch);
  }

  // getQuestionPapers(): QuestionPaper[]{
  //   return QUESTIONPAPERS;
  // }
}

import { Injectable } from '@angular/core';
import { Examination } from '../shared/examination';
import { ItemMcqOption } from "../shared/itemMcqOption";
import { HttpClient } from "@angular/common/http";
import { baseURL } from "../shared/baseurl";
import { Observable, of } from "rxjs";
import { ResponseTable } from "../shared/responseTable";
import { Attempt } from '../shared/attempt';
import { ExamineeBatch } from '../shared/examineeBatch';

@Injectable({
  providedIn: 'root'
})
export class ExaminationService {

  constructor(private http: HttpClient) { }

  getQpItemsOfQuestionPaper(qpId: number): Observable<Examination[]>{
    return this.http.get<Examination[]>(baseURL + 'questionPaper/' + qpId + '/qpItems');
  }

  getLastPostedAttemptForBathAndExamineeIds(examineeId: number, batchId: number): Observable<Attempt>{
    return this.http.get<Attempt>(baseURL + 'examinee/' + examineeId + '/batch/' + batchId + '/attempt');
  }

  getResponseForBathAndExamineeIdsForRadioButton(qpItemId: number, examineeId: number, batchId: number): Observable<ResponseTable>{
    return this.http.get<ResponseTable>(baseURL + 'response/qpItem/' + qpItemId + '/examinee/' + examineeId + '/batch/' + batchId);
  }

  getAllResponsesForBatchAndExamineeIds(examineeId: number, batchId: number): Observable<ResponseTable[]>{
    return this.http.get<ResponseTable[]>(baseURL + 'examinee/' + examineeId + '/batch/' + batchId + '/allResponses');
  }

  updateResponse(responseId: number, response: ResponseTable): Observable<ResponseTable>{
    return this.http.put<ResponseTable>(baseURL + 'response/' + responseId, response);
  }

  postResponse(response: ResponseTable): Observable<ResponseTable>{
    return this.http.post<ResponseTable>(baseURL +  '/response/setResponse', response);
  }

  deleteResponseForQpIdAndAttemptId(qpItemId: number, examineeId: number, batchId: number, responseText: string): Observable<any>{
    console.log(responseText);
    return this.http.delete<any>(baseURL + 'responseUnchecked/examinee/' + examineeId + '/batch/' + batchId + '/qpItem/' + qpItemId + '/responseText/' + responseText);
  }

  deleteResponseById(responseId: number): Observable<any>{
    return this.http.delete<any>(baseURL + 'response/' + responseId);
  }

  updateAttemptWhenExamIsFinished(examineeId: number, batchId: number, attempt: Attempt): Observable<Attempt>{
    return this.http.put<Attempt>(baseURL + 'examinee/' + examineeId + '/batch/' + batchId + '/attempt', attempt);
  }

  getExamineeBatchFromExamineeBatchIds(examineeId: number, batchId: number): Observable<ExamineeBatch>{
    return this.http.get<ExamineeBatch>(baseURL + 'examinee/' + examineeId + '/batch/' + batchId + '/examineeBatch');
  }

  updateExamineeBatchEndTimeAndStatus(examineeId: number, batchId: number, examineeBatch: ExamineeBatch): Observable<ExamineeBatch>{
    return this.http.put<ExamineeBatch>(baseURL + 'examinee/' + examineeId + '/batch/' + batchId + '/examineeBatch', examineeBatch);
  }

  // getLastPostedResponse(): Observable<ResponseTable>{
  //   return this.http.get<ResponseTable>(baseURL + 'response/lastRow');
  // }

  // postResponseMcq(responseId: number, responseMcq: ResponseMcq): Observable<ResponseMcq>{
  //   return this.http.post<ResponseMcq>(baseURL +  'response/' + responseId + '/responseMcq', responseMcq);
  // }
  
  // getMcqOptionsOfQpItem(qpItemId: number): Observable<ItemMcqOption[]>{
  //   return this.http.get<ItemMcqOption[]>(baseURL + 'qpItem/' + qpItemId + '/mcqOptions');
  // }
}

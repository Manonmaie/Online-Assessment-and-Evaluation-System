import { Injectable } from '@angular/core';
import { ExamineeBatch } from '../shared/examinee-batch';
import { ExamineeBatchKey } from '../shared/examinee-batch-key';
import { HttpClient } from '@angular/common/http';
import {baseURL} from '../shared/baseurl';
import {Observable, of} from 'rxjs';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ExamineeBatchService {

  constructor(private http: HttpClient) { }

  updateExamineeBatch(examineeId: number, batchId: number, examineeBatch: ExamineeBatch): Observable<ExamineeBatch>{
    return this.http.put<ExamineeBatch>(baseURL + "examineeBatch/examinee/"+examineeId+"/batch/"+batchId, examineeBatch);
  }

  getExamineeBatchByExamdriveId(examdriveId: number): Observable<ExamineeBatch[]>{
    return this.http.get<ExamineeBatch[]>(baseURL + "examineeBatchByExamdrive/" + examdriveId);
  }

  getExamineeBatchByExamineeId(examineeId: number): Observable<ExamineeBatch[]>{
    return this.http.get<ExamineeBatch[]>(baseURL + "examineeBatchByExaminee/" + examineeId);
  }

  addExamineeBatches(examineeBatches: ExamineeBatch[]): Observable<ExamineeBatch[]>{
    return this.http.post<ExamineeBatch[]>(baseURL + 'examineeBatchBulk', examineeBatches);
  } 
}

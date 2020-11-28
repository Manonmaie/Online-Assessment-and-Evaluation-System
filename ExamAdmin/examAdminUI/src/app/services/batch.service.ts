import { Injectable } from '@angular/core';
import { Batch } from '../shared/batch';
import { HttpClient } from '@angular/common/http';
import {baseURL} from '../shared/baseurl';
import {Observable, of} from 'rxjs';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BatchService {

  constructor(private http: HttpClient) { }

  getBatchesByExamdrive(id: number): Observable<Batch[]>{
    return this.http.get<Batch[]>(baseURL + 'batchByExamdrive/'+id);
  }

  deleteBatches(batches: Batch[]): Observable<any>{
    return this.http.request('delete', baseURL+ 'batches/', {body: batches});
  }

  deleteBatch(id: number): Observable<any>{
    return this.http.delete<any>(baseURL + 'batches/'+id);
  }

  updateBatch(id: number, batch: Batch): Observable<Batch>{
    return this.http.put<Batch>(baseURL + 'batches/'+id, batch);
  }

  updateBatches(batches: Batch[]): Observable<Batch[]>{
    return this.http.put<Batch[]>(baseURL + 'batchesBulk/', batches);
  }

  addBatch(batch: Batch): Observable<Batch>{
    return this.http.post<Batch>(baseURL + 'batches/', batch);
  }

  addBatches(batches: Batch[]): Observable<Batch[]>{
    return this.http.post<Batch[]>(baseURL + 'batchesBulk', batches);
  }

  getBatch(id: number): Observable<Batch>{
    return this.http.get<Batch>(baseURL + "batches/" + id);
  }

  getCodes(): Observable<string[]>{
    return this.http.get<string[]>(baseURL + 'batchCodes/');
  }
}

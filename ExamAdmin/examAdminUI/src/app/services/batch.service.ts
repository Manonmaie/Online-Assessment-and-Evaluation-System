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
}

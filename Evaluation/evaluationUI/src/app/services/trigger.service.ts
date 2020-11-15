import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {baseURL} from '../shared/baseurl';
import {Observable, of} from 'rxjs';
import {ExamineeItemMarks} from '../shared/ExamineeItemMarks';

@Injectable({
  providedIn: 'root'
})
export class TriggerService {

  constructor(private http: HttpClient) { }

  startTrigger(id: number): Observable<any>{
    return this.http.post<any>(baseURL + 'trigger/examineeBatch/' + id,id);
  }
  
  evaluateMarks(id: number): Observable<any>{
    return this.http.put<any>(baseURL + 'response/examineeBatch/' + id,id);
  }

}

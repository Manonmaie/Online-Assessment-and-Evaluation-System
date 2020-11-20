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

  startTrigger(id: number): Observable<ExamineeItemMarks>{
    return this.http.post<ExamineeItemMarks>(baseURL + 'trigger/examineeBatch/' + id,id);
  }
  
  evaluateMarks(id: number): Observable<ExamineeItemMarks>{
    return this.http.put<ExamineeItemMarks>(baseURL + 'response/examineeBatch/' + id,id);
  }

}

import { Injectable } from '@angular/core';
import {Examinee} from '../shared/examinee';
import { HttpClient } from '@angular/common/http';
import {baseURL} from '../shared/baseurl';
import {Observable, of} from 'rxjs';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ExamineeService {

  constructor(private http: HttpClient) { }

  getExaminees(): Observable<Examinee[]>{
    return this.http.get<Examinee[]>(baseURL + 'examinees');
  }

  deleteExaminee(id: number): Observable<any>{
    return this.http.delete<any>(baseURL+'examinees/'+id);
  }
  
  getExaminee(id: number): Observable<Examinee>{
    return this.http.get<Examinee>(baseURL+'examinees/'+id);
  }
}

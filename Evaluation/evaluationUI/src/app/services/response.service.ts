import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { baseURL } from '../shared/baseurl';
import { Response } from '../shared/Response';

@Injectable({
  providedIn: 'root'
})
export class ResponseService {

  constructor(private http: HttpClient) { }

  getAllResponsesForExamDrive(id: number): Observable<Response[]>{
    return this.http.get<Response[]>(baseURL+'examdrive/'+id+'/responses');
  }
}

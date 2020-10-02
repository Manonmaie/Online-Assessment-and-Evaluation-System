import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { baseURL } from '../shared/baseurl';
import { QpItem } from '../shared/QpItem';

@Injectable({
  providedIn: 'root'
})
export class QpItemService {

  constructor(private http: HttpClient) { }

  getAllQpItemsForQuestionPaper(id: number): Observable<QpItem[]>{
    return this.http.get<QpItem[]>(baseURL+'questionPaper/'+id+'/qpItems');
  }

}

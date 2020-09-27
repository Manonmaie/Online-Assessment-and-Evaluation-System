import { Injectable } from '@angular/core';
import { Examination } from '../shared/examination';
import { ItemMcqOption } from "../shared/itemMcqOption";
import { HttpClient } from "@angular/common/http";
import { baseURL } from "../shared/baseurl";
import { Observable, of } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ExaminationService {

  constructor(private http: HttpClient) { }

  getQpItemsOfQuestionPaper(qpId: number): Observable<Examination[]>{
    return this.http.get<Examination[]>(baseURL + 'questionPaper/' + qpId + '/qpItems');
  }

  // getMcqOptionsOfQpItem(qpItemId: number): Observable<ItemMcqOption[]>{
  //   return this.http.get<ItemMcqOption[]>(baseURL + 'qpItem/' + qpItemId + '/mcqOptions');
  // }
}

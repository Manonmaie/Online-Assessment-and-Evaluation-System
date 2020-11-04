import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {baseURL} from '../shared/baseURL';
import {Observable, of} from 'rxjs';
import { delay } from 'rxjs/operators'
import { QP } from '../shared/QP'

@Injectable({
  providedIn: 'root'
})

export class QPServiceService {
  constructor(private http: HttpClient) { }
  // qp:QP;
  setQP(subject :string,TotalMarks: Number,TestDuration: Number,Instructions: string,itemIds: number[]) : Observable<any>{
    console.log("hello");
    console.log(subject);
    var qp = new QP();
    qp.subject=subject;
    qp.Instructions=Instructions;
    qp.TestDuration=TestDuration;
    qp.TotalMarks=TotalMarks;
    qp.itemIds=itemIds;
    console.log(JSON.stringify(qp));
    return this.http.post(baseURL + '/urest/v1/setQP',qp);
  }
}

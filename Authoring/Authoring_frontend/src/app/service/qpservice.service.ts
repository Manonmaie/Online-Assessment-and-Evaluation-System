import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import {baseURL} from '../shared/baseURL';
import {Observable, of} from 'rxjs';
import { delay } from 'rxjs/operators'
import { QP } from '../shared/QP'
import { Item } from '../shared/item';
import { course } from '../shared/course';

@Injectable({
  providedIn: 'root'
})

export class QPServiceService {
  constructor(private http: HttpClient) { }
  setQP(subject :course,TotalMarks: Number,TestDuration: Number,items: Item[],batchCode:string,myInstrucions:string[]) : Observable<any>{
    var qp = new QP();
    qp.course=subject;
    qp.timeDuration=TestDuration;
    qp.totalMarks=TotalMarks;
    qp.items=items;
    qp.batchCode=batchCode;
    qp.inst=myInstrucions;
    console.log("sending qp");
    return this.http.post(baseURL + '/urest/v1/setQP', qp);
  }

  getitemByIds(params): Observable<any>{
    return this.http.get<Item[]>(baseURL + '/urest/v1/getitem_ids/',{params});
  }
}

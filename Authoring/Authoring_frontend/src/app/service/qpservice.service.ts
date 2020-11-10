import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {baseURL} from '../shared/baseURL';
import {Observable, of} from 'rxjs';
import { delay } from 'rxjs/operators'
import { QP } from '../shared/QP'
import { Item } from '../shared/item';

@Injectable({
  providedIn: 'root'
})

export class QPServiceService {
  constructor(private http: HttpClient) { }
  myQPSet: Set<number> = new Set<number>();
  setQP(subject :string,TotalMarks: Number,TestDuration: Number,Instructions: string,itemIds: number[]) : Observable<any>{
    console.log("hello");
    console.log(subject);
    var qp = new QP();
    qp.course=subject;
    qp.instructions=Instructions;
    qp.timeDuration=TestDuration;
    qp.totalMarks=TotalMarks;
    qp.asitemIds=itemIds;
    console.log(qp);
    this.http.get(baseURL + '/urest/v1/getitem_byAuthor/'+ "test");
    return this.http.post(baseURL + '/urest/v1/setQP', qp);
  }


  setQpSelected(myQPSet: Set<number>){
    console.log(myQPSet);
    this.myQPSet=myQPSet;
  }
  getQpSelected():Set<number>{
    return this.myQPSet;
  }


  getitemByIds(params): Observable<any>{
    return this.http.get<Item[]>(baseURL + '/urest/v1/getitem_ids/',{params});
  }
}

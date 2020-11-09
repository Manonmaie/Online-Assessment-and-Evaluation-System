import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {baseURL} from '../shared/baseURL';
import {Observable, of} from 'rxjs';
import { delay } from 'rxjs/operators'
import { Item } from '../shared/item';



@Injectable({
  providedIn: 'root'
})
export class ItemFilterServiceService {
  constructor(private http: HttpClient) { };

  getitemFilter(params): Observable<any>{
    return this.http.get<Item[]>(baseURL + '/urest/v1/getitem_byFilter/',{params});
  }
  
}
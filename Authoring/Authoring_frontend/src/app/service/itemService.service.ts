import { Injectable } from '@angular/core';
import {Item} from '../shared/item';
import { HttpClient } from '@angular/common/http';
import {baseURL} from '../shared/baseURL';
import {Observable, of} from 'rxjs';
import { delay } from 'rxjs/operators'



@Injectable({
  providedIn: 'root'
})
export class ItemServiceService {
  constructor(private http: HttpClient) { };

  getitem(author_id: Number): Observable<Item[]>{
    return this.http.get<Item[]>(baseURL + '/urest/v1/getitem_byAuthor/'+author_id);
  }
}

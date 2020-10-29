import { Injectable } from '@angular/core';
import {Item_TF} from '../shared/item_TF';
import { HttpClient } from '@angular/common/http';
import {baseURL} from '../shared/baseURL';
import {Observable, of} from 'rxjs';
import { delay } from 'rxjs/operators'



@Injectable({
  providedIn: 'root'
})
export class ItemTFServiceService {
  constructor(private http: HttpClient) { };

  getitem_TF(author_id: number): Observable<Item_TF[]>{
    return this.http.get<Item_TF[]>(baseURL + '/urest/v1/getitemTF_byAuthor/'+author_id);
  }
}

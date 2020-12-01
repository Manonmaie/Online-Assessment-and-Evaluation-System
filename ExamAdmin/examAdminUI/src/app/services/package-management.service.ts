import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { baseURL } from '../shared/baseurl';

@Injectable({
  providedIn: 'root'
})
export class PackageManagementService {

  constructor(private http: HttpClient) { }

  importQPack(key: string): Observable<any>{
    return this.http.get<any>(baseURL+'importFromQpack/'+key);
  }

  importMPack(key: string): Observable<any>{
    return this.http.get<any>(baseURL+'importFromMpack/'+key);
  }
}

import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { baseURL } from '../shared/baseurl';
import { Status } from '../shared/status';

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

  exportEPack(centerId: number): Observable<Status>{
    return this.http.get<Status>(baseURL+'createEpack/'+centerId);
  }
}

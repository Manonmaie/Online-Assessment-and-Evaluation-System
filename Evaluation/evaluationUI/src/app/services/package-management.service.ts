import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { baseURL } from "../shared/baseurl";
import { Observable, of } from "rxjs";
import { OutMpackHeader } from "../shared/outMpackHeader";
import { InApackHeader } from "../shared/inApackHeader";

@Injectable({
  providedIn: 'root'
})
export class PackageManagementService {

  constructor(private http: HttpClient) { }

  createAndSendAllBatchesMpacks(): Observable<OutMpackHeader[]>{
    return this.http.get<OutMpackHeader[]>(baseURL + 'createMpack');
  }

  importAllApacks(ApackKey: string): Observable<InApackHeader[]>{
    return this.http.get<InApackHeader[]>(baseURL + 'importFromApack/' + ApackKey);
  }

  
}

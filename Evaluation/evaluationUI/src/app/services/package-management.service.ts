import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { baseURL } from "../shared/baseurl";
import { Observable, of } from "rxjs";
import { OutMpackHeader } from "../shared/outMpackHeader";
import { InApackHeader } from "../shared/inApackHeader";
import { PackStatus } from "../shared/packStatus";

@Injectable({
  providedIn: 'root'
})
export class PackageManagementService {

  constructor(private http: HttpClient) { }

  createAndSendAllBatchesMpacks(): Observable<any>{
    return this.http.get<PackStatus>(baseURL + 'createMpack');
  }

  importAllApacks(ApackKey: string): Observable<InApackHeader[]>{
    return this.http.get<InApackHeader[]>(baseURL + 'importFromApack/' + ApackKey);
  }

  
}

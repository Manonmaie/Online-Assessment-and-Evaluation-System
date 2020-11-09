import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { baseURL } from "../shared/baseurl";
import { Observable, of } from "rxjs";
import { Batch } from "../shared/batch";

@Injectable({
  providedIn: 'root'
})
export class PackageManagementService {

  constructor(private http: HttpClient) { }

  getAllCompletedBatchesToExport(): Observable<Batch[]>{
    return this.http.get<Batch[]>(baseURL + 'completedBatchesResponses');
  }
}

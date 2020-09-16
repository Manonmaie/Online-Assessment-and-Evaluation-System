import { Injectable } from '@angular/core';
import { DriveCenterExaminee } from "../shared/DriveCenterExaminee";
import { HttpClient } from "@angular/common/http";
import { baseURL } from "../shared/baseurl";
import { Observable, of } from "rxjs";
import { delay } from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class DriveCenterService {

  constructor(private http: HttpClient) { }

  getExamDrives(): Observable<DriveCenterExaminee[]>{
    // return of(QUESTIONPAPERS).pipe(delay(2000));
    return this.http.get<DriveCenterExaminee[]>(baseURL + 'examdrives');
  }
}
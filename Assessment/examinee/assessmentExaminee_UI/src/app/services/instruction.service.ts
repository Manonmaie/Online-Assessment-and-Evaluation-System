import { Injectable } from '@angular/core';
import { Instruction } from "../shared/instruction";
import { HttpClient } from "@angular/common/http";
import { baseURL } from "../shared/baseurl";
import { Observable, of } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class InstructionService {

  constructor(private http: HttpClient) { }

  getInstructionOfQuestionPaper(qpId: number): Observable<Instruction[]>{
    return this.http.get<Instruction[]>(baseURL + 'questionPaper/' + qpId + '/instructions');
  }
}

import { Injectable } from '@angular/core';
import { QuestionPaper } from "../shared/questionPaper";
// import { QUESTIONPAPERS } from "../shared/questionPapers";
import { HttpClient } from "@angular/common/http";
import { baseURL } from "../shared/baseurl";
import { Observable, of } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class QuestionPaperService {

  constructor(private http: HttpClient) { }

  getQuestionPapers(): Observable<QuestionPaper[]>{
    return this.http.get<QuestionPaper[]>(baseURL + 'questionPapers');
  }

  // getQuestionPapers(): QuestionPaper[]{
  //   return QUESTIONPAPERS;
  // }
}

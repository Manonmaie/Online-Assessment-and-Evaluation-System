import { Component, OnInit } from '@angular/core';
import { QuestionPaper } from "../shared/questionPaper";
import { QuestionPaperService } from "../services/question-paper.service";
import { Observable, of } from "rxjs";

@Component({
  selector: 'app-question-paper',
  templateUrl: './question-paper.component.html',
  styleUrls: ['./question-paper.component.scss']
})
export class QuestionPaperComponent implements OnInit {

  questionPapers: QuestionPaper[];  

  constructor(private questionPaperService: QuestionPaperService) { }

  ngOnInit(): void {
    this.questionPaperService.getQuestionPapers().subscribe((questionPapers) => this.questionPapers = questionPapers);
  }

}

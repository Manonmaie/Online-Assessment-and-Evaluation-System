import { Component, OnInit } from '@angular/core';
import { QuestionPaper } from "../shared/questionPaper";
import { QuestionPaperService } from "../services/question-paper.service";
import { Params, ActivatedRoute } from '@angular/router'; 

@Component({
  selector: 'app-question-paper',
  templateUrl: './question-paper.component.html',
  styleUrls: ['./question-paper.component.scss']
})
export class QuestionPaperComponent implements OnInit {

  questionPapers: QuestionPaper[];  

  constructor(private questionPaperService: QuestionPaperService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const examineeId = 1;
    this.questionPaperService.getQuestionPapers(examineeId).subscribe((questionPapers) => this.questionPapers = questionPapers);
    // this.questionPapers = this.questionPaperService.getQuestionPapers()
  }

}

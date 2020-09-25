import { Component, OnInit } from '@angular/core';
import { QuestionPaper } from "../shared/questionPaper";
import { QuestionPaperService } from "../services/question-paper.service";
import { Params, ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-question-paper',
  templateUrl: './question-paper.component.html',
  styleUrls: ['./question-paper.component.scss']
})
export class QuestionPaperComponent implements OnInit {

  questionPapers: QuestionPaper[];
  showStartExamModalPopup: boolean = false;

  constructor(private questionPaperService: QuestionPaperService, private activeRoute: ActivatedRoute, public route: Router) { }

  ngOnInit(): void {
    const examineeId = 1;
    this.questionPaperService.getQuestionPapers(examineeId).subscribe((questionPapers) => this.questionPapers = questionPapers);
    // this.questionPapers = this.questionPaperService.getQuestionPapers()
  }

  onSelect(questionPaper: QuestionPaper) {
    let currDateTime: Date = new Date();
    
    if(currDateTime >= new Date(questionPaper.batchStartTime) && currDateTime <= new Date(questionPaper.batchEndTime)){
      this.showStartExamModalPopup = false;
      this.route.navigate(['/examination/questionPaper.qpId']);
      // (<HTMLInputElement> document.getElementById("StartButton_"+questionPaper.qpId.toString())).disabled = false;
    }
    else{
      this.showStartExamModalPopup = true;
      // (<HTMLInputElement> document.getElementById("StartButton_"+questionPaper.qpId.toString())).disabled = true;
    }
    
  }

}

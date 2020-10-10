import { Component, OnInit } from '@angular/core';
import { Examination } from "../shared/examination";
import { ItemMcqOption } from "../shared/itemMcqOption";
import { ExaminationService } from "../services/examination.service";
import { Params, ActivatedRoute } from '@angular/router';
import { ResponseTable } from '../shared/responseTable';
import { ResponseMcq } from "../shared/responseMcq";
import { Attempt } from '../shared/attempt';
import { QuestionPaperService } from "../services/question-paper.service";

declare var $:any;

@Component({
  selector: 'app-examination',
  templateUrl: './examination.component.html',
  styleUrls: ['./examination.component.scss']
})
export class ExaminationComponent implements OnInit {

  qpItems: Examination[];
  qpId: number;
  batchId: number;
  examineeId: number;

  response: ResponseTable = {responseId: 0, asQpItem: null, asAttempt: null, responseText: ''};
  attempt: Attempt;

  constructor(private qpService: QuestionPaperService, private examinationService: ExaminationService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.qpId = this.route.snapshot.params['qpId'];
    this.batchId = this.route.snapshot.params['batchId'];
    this.examineeId = this.route.snapshot.params['examineeId'];
    this.examinationService.getQpItemsOfQuestionPaper(this.qpId).subscribe((qpItems) => this.qpItems = qpItems);
    // this.examinationService.getLastPostedAttemptForBathAndExamineeIds(this.examineeId, this.batchId).subscribe((attempt) => this.attempt = attempt);
    // this.attempt = this.qpService.getLastAttemptVariable();
    // console.log("In examination component");
    // console.log(this.attempt);
  }

  showReset(qpItemType: string){
    if(qpItemType == 'McqSingleCorrect' || qpItemType == 'True/False'){
      return true;
    }
    return false;
  }

  updateResponseTableWhenOptionSelected(event: boolean, itemOptionText: string, qpItem: Examination, qpItemType: string){
    if(qpItemType == 'Reset'){
      this.examinationService.getResponseForBathAndExamineeIdsForRadioButton(qpItem.qpItemId, this.examineeId, this.batchId).subscribe((response) => {
        if(response!=null){
          console.log('Reset' + response.responseId);
          this.deleteResponseById(response.responseId);
        }
      });
      let qpItemCode: string = qpItem.itemCode;
      console.log(qpItemCode);
      $('input[name="' + qpItemCode + '"]').prop('checked', false);
    }
    if(qpItemType == 'McqMultiCorrect' && event == false){
      this.deleteResponseForQpItemAttempExamineeBatch(qpItem.qpItemId, this.examineeId, this.batchId, itemOptionText);
    }
    else if(event == true){
      let responseLocal: ResponseTable = {responseId: 0, asQpItem: null, asAttempt: null, responseText: ''};
      this.response = responseLocal;
      this.attempt = this.qpService.getLastAttemptVariable();
      let asQpItem: Examination = new Examination();
      asQpItem.qpItemId = qpItem.qpItemId;
      this.response.asQpItem = asQpItem;
      console.log("In examination component");
      console.log(this.attempt);
      let asAttempt: Attempt = new Attempt();
      if(this.attempt == null){
        asAttempt.attemptId = 1;
      }
      else{
        asAttempt.attemptId = this.attempt.attemptId + 1;
      }
      this.response.asAttempt = asAttempt;
      this.response.responseText = itemOptionText;
      console.log(this.response);
      console.log(itemOptionText);
      console.log(this.response.responseText);
      if(qpItemType == 'McqMultiCorrect' && event == true){
        this.addResponse(this.response);
      }
      else if(qpItemType == 'McqSingleCorrect' || qpItemType == 'True/False'){
        this.examinationService.getResponseForBathAndExamineeIdsForRadioButton(qpItem.qpItemId, this.examineeId, this.batchId).subscribe((response) => {
          if(response==null){
            this.addResponse(this.response);
          }
          else{
            console.log(response.responseId);
            this.response.responseId = response.responseId;
            this.updateResponse(response.responseId, this.response);
          }
        });
      }
    }
  }

  addResponse(response: ResponseTable): void{
    this.examinationService.postResponse(response).subscribe((response) => this.response = response);
  }

  deleteResponseForQpItemAttempExamineeBatch(qpItemId: number, examineeId: number, batchId: number, responseText: string): void{
    this.examinationService.deleteResponseForQpIdAndAttemptId(qpItemId,examineeId,batchId,responseText).subscribe((response) => console.log("Deleted"));
  }

  updateResponse(responseId: number, response: ResponseTable): void{
    this.examinationService.updateResponse(responseId, response).subscribe((response) => this.response = response);
  }

  deleteResponseById(responseId: number): void{
    this.examinationService.deleteResponseById(responseId).subscribe((response) => console.log("Deleted"));
  }

  // updateResponse2(){
  //   alert("reset");
  //   console.log($('input[name=optRadio]'));
  //   // $('input[name=optRadio]').attr('checked',false);
  //   $('input[name="optRadio"]').prop('checked', false);
  // }
  // updateResponseCheckbox(event: boolean, itemMcqOptionText: string, qpItem: Examination){
  //   let responseLocal: ResponseTable = {responseId: 0, asQpItem: null, asAttempt: null, responseText: ''};
  //   this.response = responseLocal;
  //   this.attempt = this.qpService.getLastAttemptVariable();
  //   if(event == true){
  //     let asQpItem: Examination = new Examination();
  //     asQpItem.qpItemId = qpItem.qpItemId;
  //     this.response.asQpItem = asQpItem;
  //     console.log("In examination component");
  //     console.log(this.attempt);
  //     let asAttempt: Attempt = new Attempt();
  //     if(this.attempt == null){
  //       asAttempt.attemptId = 1;
  //     }
  //     else{
  //       asAttempt.attemptId = this.attempt.attemptId + 1;
  //     }
  //     this.response.asAttempt = asAttempt;
  //     this.response.responseText = itemMcqOptionText;
  //     console.log(this.response);
  //     this.addResponse(this.response);
  //     // this.examinationService.getLastPostedResponse().subscribe((lastResponse) => this.lastResponse = lastResponse);
  //     // this.responseMcq.responseText = itemMcqOption.mcqOptionText;
  //     // this.responseMcq.asResponse = this.lastResponse;
  //     // this.postResponseMcq(this.lastResponse.responseId, this.responseMcq);
  //   }
  //   else{
  //     this.deleteResponseForQpItemAttempExamineeBatch(qpItem.qpItemId, this.examineeId, this.batchId, itemMcqOptionText);
  //   }
  // }

  // updateResponseRadio(event: boolean, itemMcqOptionText: string, qpItem: Examination){
  //   let responseLocal: ResponseTable = {responseId: 0, asQpItem: null, asAttempt: null, responseText: ''};
  //   this.response = responseLocal;
  //   this.attempt = this.qpService.getLastAttemptVariable();
  //   let asQpItem: Examination = new Examination();
  //   asQpItem.qpItemId = qpItem.qpItemId;
  //   this.response.asQpItem = asQpItem;
  //   console.log("In examination component");
  //   console.log(this.attempt);
  //   let asAttempt: Attempt = new Attempt();
  //   if(this.attempt == null){
  //     asAttempt.attemptId = 1;
  //   }
  //   else{
  //     asAttempt.attemptId = this.attempt.attemptId + 1;
  //   }
  //   this.response.asAttempt = asAttempt;
  //   this.response.responseText = itemMcqOptionText;
  //   console.log(this.response);
  //   this.examinationService.getResponseForBathAndExamineeIdsForRadioButton(qpItem.qpItemId, this.examineeId, this.batchId).subscribe((response) => {
  //     if(response==null){
  //       this.addResponse(this.response);
  //     }
  //     else{
  //       console.log(response.responseId);
  //       this.response.responseId = response.responseId;
  //       this.updateResponse(response.responseId, this.response);
  //     }
  //   });
  //   // console.log(responseForQpItem);
  // }
}

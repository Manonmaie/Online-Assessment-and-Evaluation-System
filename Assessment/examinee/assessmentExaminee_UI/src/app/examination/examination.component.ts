import { Component, OnInit } from '@angular/core';
import { Examination } from "../shared/examination";
import { ItemMcqOption } from "../shared/itemMcqOption";
import { ExaminationService } from "../services/examination.service";
import { Params, ActivatedRoute, Router } from '@angular/router';
import { ResponseTable } from '../shared/responseTable';
import { ResponseMcq } from "../shared/responseMcq";
import { Attempt } from '../shared/attempt';
import { QuestionPaperService } from "../services/question-paper.service";
import { ExamineeBatch } from '../shared/examineeBatch';
import { ExamineeBatchId } from '../shared/examineeBatch';
import { DatePipe } from '@angular/common';
import { ResponseListForOpItem } from "../shared/responseListForQpItem";

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
  responseListForQpItems: ResponseListForOpItem[];
  maxQpItemId: number;
  // checkedOrNot: boolean;

  response: ResponseTable = {responseId: 0, asQpItem: null, asAttempt: null, responseText: ''};
  attempt: Attempt;
  examineeBatch: ExamineeBatch;

  timerTime: number;
  display: string;
  interval;
  qpDuration: number;

  flaggedItems: boolean[];
  attemptedItems: boolean[];
  noOfOptionsCheckedForItem: number[]; 
  // flagName: string[];

  constructor(private qpService: QuestionPaperService, private examinationService: ExaminationService, 
    public datepipe: DatePipe, private activeRoute: ActivatedRoute, public route: Router) { }

  ngOnInit(): void {
    this.qpId = this.activeRoute.snapshot.params['qpId'];
    this.batchId = this.activeRoute.snapshot.params['batchId'];
    this.examineeId = this.activeRoute.snapshot.params['examineeId'];
    this.examinationService.getQpItemsOfQuestionPaper(this.qpId).subscribe((qpItems) => {
      this.qpItems = qpItems;
      this.maxQpItemId = Math.max.apply(Math, qpItems.map(function(qpItem) { return qpItem.qpItemId; }));

      for (let i = 0; i < qpItems.length; i++) {
        this.shuffle(qpItems[i].asItemMcqOptionsList);
      }
      this.shuffle(qpItems);
      
      this.flaggedItems = [];
      for (let i = 0; i < qpItems.length; i++) {
        this.flaggedItems.push(false);
      }

      this.attemptedItems = [];
      for (let i = 0; i < qpItems.length; i++) {
        this.attemptedItems.push(false);
      }

      this.noOfOptionsCheckedForItem = [];
      for (let i = 0; i < qpItems.length; i++) {
        this.noOfOptionsCheckedForItem.push(0);
      }

      this.responseListForQpItems = [];
      for(let i=0; i <= this.maxQpItemId; i++){
        let qpItemResponse: ResponseListForOpItem = new ResponseListForOpItem();
        qpItemResponse.qpItemId = -1;
        qpItemResponse.responseList = [];
        this.responseListForQpItems[i] = qpItemResponse;
      }
      this.examinationService.getAllResponsesForBatchAndExamineeIds(this.examineeId, this.batchId).subscribe((allResponses) => {
        for(let i=0; i < allResponses.length; i++){
          let qpItemId: number = allResponses[i].asQpItem.qpItemId;
          this.responseListForQpItems[qpItemId].qpItemId = qpItemId;
          this.responseListForQpItems[qpItemId].responseList.push(allResponses[i].responseText);
        }
        console.log("All responses = ");
        console.log(allResponses);
        console.log("Responses List = ");
        console.log(this.responseListForQpItems);
        
        // console.log("Checked or not:");
        // const input1 = $('input[name=1]')[0] as HTMLInputElement;
        // console.log(input1);
        // console.log(input1.checked);
        // const input2 = $('input[name=1]')[1] as HTMLInputElement;
        // console.log(input2);
        // console.log(input2.checked);
        // const input3 = $('input[name=1]')[2] as HTMLInputElement;
        // console.log(input3);
        // console.log(input3.checked);
        // const input4 = $('input[name=1]')[3] as HTMLInputElement;
        // console.log(input4);
        // console.log(input4.checked);
        // console.log($('input[name=1]'));
        // console.log(this.checkedOrNot);
        // console.log($('input[id=1_1]').checked);
        // console.log($('input[id=1_1]:checked'));
        // console.log($('input[id=1_2]:checked'));
        // console.log($('input[id=1_1]').checked);
        // console.log($('input[name=1]:checked'));
        // for (let j = 0; j < qpItems.length; j++) {
          // var checked_gender = document.querySelector('input[name = 1]:checked');
          // let qpItemId = 1;
          // console.log($('input[name="' + qpItemId + '"]').get("checked"));
          // console.log($$('input[name=1]:checked').length == 1);
          // console.log(checked_gender);
          // if(checked_gender != null){  //Test if something was checked
          //   alert(checked_gender); //Alert the value of the checked.
          // } 
          // var checked = false, radios = document.getElementsByName(qpItems[j].qpItemId.toString());
          // console.log(qpItems[j].itemText)
          // for (var i = 0, radio; radio = radios[i]; i++) {
          //     if (radio.checked) {
          //         checked = true;
          //         break;
          //     }
          // }
          // console.log(radios);
          // console.log(checked);
        // }
        // console.log($('input[name=1]').length);

        // console.log($('input[name=1]:checked').val());
        // console.log($('input[name=1]')[0]);
        // console.log($('input[name=1]')[1]);
        // console.log($('input[name=1]')[2]);
        // console.log($('input[name=1]')[3]);
        // console.log($('input[name=1]')[0].checked);
        // console.log($('input[name=1]')[1].checked);
        // console.log($('input[name=1]')[2].checked);
        // console.log($('input[name=1]')[3].checked);

        // console.log($('input[name=1]').is(':checked'));
        // console.log("Checked or not:");
        // let i: string = "1_1", j: string = "1_2", ni = "1", nj = "2";
        // const ele1 = document.getElementById(i) as HTMLInputElement;
        // const ele2 = document.getElementById(j) as HTMLInputElement;
        // console.log(ele1);
        // console.log(ele1.checked);
        // console.log(ele2);
        // console.log(ele2.checked);
        // console.log($('input[name="' + ni + '"]:checked'));
        // console.log($('input[name="' + nj + '"]:checked'));
        // // var eles: HTMLInputElement = <HTMLInputElement[]> document.getElementsByName(ni);
        // var script = <HTMLScriptElement>document.getElementsByName(ni)[0];
        // console.log(script[0].checked);
        // console.log(script[1].checked);
        // var script1 = <HTMLScriptElement>document.getElementsByName(nj)[0];
        // console.log(script1[0].checked);
        // console.log(script1[1].checked);
        // var script = <HTMLScriptElement>document.getElementsByName(ni)[0];
        // console.log(script[0].checked)
        // for (let i = 0; i < qpItems.length; i++) {
        //   for(let j = 0; j < qpItems[i].asItemMcqOptionsList.length; j++){
        //     console.log("Checked or not: " + qpItems[i].qpItemId + qpItems[i].asItemMcqOptionsList[j].itemMcqId);
        //     const ele = document.getElementById(qpItems[i].asItemMcqOptionsList[j].itemMcqId.toString()) as HTMLInputElement;
        //     // const number = document.getElementsByName(qpItems[i].qpItemId.toString()) as HTMLInputElement;
        //     console.log(ele);
        //     console.log(ele.size);
        //     console.log(ele.checked);
        //   }
        //   console.log($('input[name="' + qpItems[i].qpItemId + '"]'));
        //   console.log($('input[name="' + qpItems[i].qpItemId + '"]:checked').length);
        // }
        // $('input[name="' + qpItemId + '"]').prop('checked', false);
        // if(allResponses.length > 0){
        //   for (let i = 0; i < qpItems.length; i++) {
        //     let qpItemId: number = qpItems[i].qpItemId;
        //     if(this.responseListForQpItems[qpItemId].responseList.length > 0){
        //       if(qpItems[i].itemType == 'McqSingleCorrect'){
        //         // $('input[name="' + qpItems[i].qpItemId + '"]').prop('checked', true);
        //       }
        //       else if(qpItems[i].itemType == 'True/False'){
        //         console.log("True/false = ");
        //         console.log($('input[name="' + qpItems[i].qpItemId + '"]'));
        //         if(this.responseListForQpItems[qpItemId].responseList[0] == "True"){
        //           $('input[name="' + qpItems[i].qpItemId + '"]').prop('checked', true);
        //         }
        //         else{
        //           $('input[name="' + qpItems[i].qpItemId + '"]').prop('checked', true);
        //         }
        //       }
        //       else if(qpItems[i].itemType == 'McqMultiCorrect'){
        //         for(let j=0; j < this.responseListForQpItems[qpItemId].responseList.length; j++){
        //           // $('input[name="' + qpItems[i].qpItemId + '"]').prop('checked', true);
        //         }
        //       }
        //     }
        //   }
        // }
      });

      // this.flagName = [];
      // for (let i = 0; i < qpItems.length; i++) {
      //   this.flagName.push("Flag");
      // }
    });

    // this.examinationService.getLastPostedAttemptForBathAndExamineeIds(this.examineeId, this.batchId).subscribe((attempt) => this.attempt = attempt);
    // this.attempt = this.qpService.getLastAttemptVariable();
    // console.log("In examination component");
    // console.log(this.attempt);
    this.qpDuration = this.qpService.getSelectedQuestionPaper().duration;
    this.startTimer();
  }

  startTimer() {
    // console.log(this.qpDuration);
    this.timerTime = this.qpDuration * 60;
    // console.log(this.timerTime);
    this.interval = setInterval(() => {
      if (this.timerTime === 0) {
        this.finishExam();
      } else {
        this.timerTime--;
      }
      this.display = this.transform(this.timerTime)
    }, 1000);
  }

  transform(value: number): string {
    var sec_num = value; 
    var hours   = Math.floor(sec_num / 3600);
    var minutes = Math.floor((sec_num - (hours * 3600)) / 60);
    var seconds = sec_num - (hours * 3600) - (minutes * 60);
    // console.log(hours + " " + minutes + " " + seconds);
    return hours+':'+minutes+':'+seconds;
  }

  showReset(qpItemType: string){
    if(qpItemType == 'McqSingleCorrect' || qpItemType == 'True/False'){
      return true;
    }
    return false;
  }

  shuffle(array) { // shuffle according to examineeId
    var length = array.length, index=0, randomIndex, temp;
    while(index < length){
      randomIndex = (index * this.examineeId) % length;
      temp = array[index];
      array[index] = array[randomIndex];
      array[randomIndex] = temp;
      index += 1;
    }
    return array;
  }

  // shuffle(array) { // random shuffle
  //   var currentIndex = array.length, temporaryValue, randomIndex;
  //   while (0 !== currentIndex) {
  //     randomIndex = Math.floor(Math.random() * currentIndex);
  //     // randomIndex = Math.floor(Math.floor(Math.random() * currentIndex)/this.examineeId);
  //     currentIndex -= 1;
  //     temporaryValue = array[currentIndex];
  //     array[currentIndex] = array[randomIndex];
  //     array[randomIndex] = temporaryValue;
  //   }
  //   return array;
  // }

  flagRespectiveItem(event: boolean, index: number){
    this.flaggedItems[index] = !this.flaggedItems[index];
    console.log(this.flaggedItems);
    console.log(this.attemptedItems);
    // if(this.flaggedItems[index] == true){
    //   this.flagName[index] = "Flagged";
    // }
    // else{
    //   this.flagName[index] = "Flag";
    // }
  }

  navigateToSection(section: string) {
    // alert(section);
    window.location.hash = '';
    window.location.hash = section;
}

  updateResponseTableWhenOptionSelected(event: boolean, itemOptionText: string, qpItem: Examination, qpItemType: string, index: number){
    if(qpItemType == 'Reset'){
      this.noOfOptionsCheckedForItem[index] = 0;
      this.attemptedItems[index] = false;
      if(this.flaggedItems[index] == true){
        this.flaggedItems[index] = false;
        // this.flagName[index] = "Flag";
      }
      this.examinationService.getResponseForBathAndExamineeIdsForRadioButton(qpItem.qpItemId, this.examineeId, this.batchId).subscribe((response) => {
        if(response!=null){
          console.log('Reset' + response.responseId);
          this.deleteResponseById(response.responseId);
        }
      });
      let qpItemId: number = qpItem.qpItemId;
      $('input[name="' + qpItemId + '"]').prop('checked', false);
    }
    else{
      if(qpItemType == 'McqMultiCorrect' && event == false){
        // var element = <HTMLInputElement> document.getElementById(qpItem.qpItemId);
        // var isChecked = element.checked;
        // if(isChecked == false){
        //   this.attemptedItems[index] = false;
        // }
        // alert(isChecked);
        this.noOfOptionsCheckedForItem[index]--;
        if(this.noOfOptionsCheckedForItem[index]<=0){
          this.attemptedItems[index] = false;
        }
        this.deleteResponseForQpItemAttempExamineeBatch(qpItem.qpItemId, this.examineeId, this.batchId, itemOptionText);
      }
      else if(event == true){
        this.noOfOptionsCheckedForItem[index]++;
        if(this.attemptedItems[index]==false){
          this.attemptedItems[index] = true;
        }
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

  finishExam(){
    let attemptLocal: Attempt = {attemptId: 0, attemptNumber: 0, attemptStartTime: null, attemptEndTime: null, attemptStatus: 'COMPLETED', asExamineeBatch: null};
    this.attempt = attemptLocal;
    let currDateTime: Date = new Date();
    let currDateTimeFormatted: string = this.datepipe.transform(currDateTime, 'yyyy-MM-ddTHH:mm:ss');
    this.attempt.attemptEndTime = currDateTimeFormatted;
    this.updateAttemptWhenExamIsFinished(this.examineeId, this.batchId, this.attempt);
    this.examinationService.getExamineeBatchFromExamineeBatchIds(this.examineeId, this.batchId).subscribe((examineeBatch) => {
      examineeBatch.examineeBatchEndTime = currDateTimeFormatted;
      examineeBatch.examineeBatchStatus = 'COMPLETED';
      this.updateExamineeBatchEndTimeAndStatus(this.examineeId, this.batchId, examineeBatch);
    });
    this.route.navigate(['/questionPaper/' + this.examineeId]);
  }

  updateAttemptWhenExamIsFinished(examineeId: number, batchId: number, attempt: Attempt): void{
    this.examinationService.updateAttemptWhenExamIsFinished(examineeId, batchId, attempt).subscribe((attempt) => this.attempt = attempt);
  }
  updateExamineeBatchEndTimeAndStatus(examineeId: number, batchId: number, examineeBatch: ExamineeBatch): void{
    this.examinationService.updateExamineeBatchEndTimeAndStatus(examineeId, batchId, examineeBatch).subscribe((examineeBatch) => this.examineeBatch = examineeBatch);
  }
}

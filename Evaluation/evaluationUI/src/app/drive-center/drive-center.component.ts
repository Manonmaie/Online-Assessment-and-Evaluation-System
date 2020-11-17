import { Component, OnInit } from '@angular/core';
import { DriveCenterExaminee } from "../shared/DriveCenterExaminee";
import { DriveCenterService } from "../services/drive-center.service";
import { TriggerService } from "../services/trigger.service";
import {ExamineeItemMarks} from '../shared/ExamineeItemMarks';
import { Observable, of } from "rxjs";

@Component({
  selector: 'app-drive-center',
  templateUrl: './drive-center.component.html',
  styleUrls: ['./drive-center.component.scss']
})
export class DriveCenterComponent implements OnInit {

  driveCenterExaminee : DriveCenterExaminee[]; 
  examineeItemMarks = {examineeItemMarksId : null, examineeItemMarks : null, qpItem : null, examineeBatch : null};
  searchText: any;
  constructor(private driveCenterService: DriveCenterService, private triggerService : TriggerService) { }

  ngOnInit(): void {
    this.driveCenterService.getExamDrives().subscribe((driveCenterExaminee) => this.driveCenterExaminee = driveCenterExaminee);
  }

  Trigger(id: number) : void{
    this.triggerService.startTrigger(id).subscribe((examineeItemMarks) => this.examineeItemMarks = examineeItemMarks);
    setTimeout(() => {
      this.Evaluate(id);
    },500);
  }

  Evaluate(id: number) : void{
    this.triggerService.evaluateMarks(id).subscribe((examineeItemMarks) => this.examineeItemMarks = examineeItemMarks);
  }

}

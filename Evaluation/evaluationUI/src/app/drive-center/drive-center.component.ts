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
  searchText: any;
  constructor(private driveCenterService: DriveCenterService, private triggerService : TriggerService) { }

  ngOnInit(): void {
    this.driveCenterService.getExamDrives().subscribe((driveCenterExaminee) => this.driveCenterExaminee = driveCenterExaminee);
  }

  Trigger(id: number) : void{
    this.triggerService.startTrigger(id);
  }

  Evaluate(id: number) : void{
    this.triggerService.evaluateMarks(id);
  }

}

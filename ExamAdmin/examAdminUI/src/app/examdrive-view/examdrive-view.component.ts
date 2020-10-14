import { Component, OnInit } from '@angular/core';
import {ExamdriveService } from '../services/examdrive.service';
import { Params, ActivatedRoute } from '@angular/router';
import { Examdrive } from '../shared/examdrive';
import { Center } from '../shared/center';
import {Observable, of} from 'rxjs';

@Component({
  selector: 'app-examdrive-view',
  templateUrl: './examdrive-view.component.html',
  styleUrls: ['./examdrive-view.component.scss']
})
export class ExamdriveViewComponent implements OnInit {
  examdrive: Examdrive;
  centers: Center[] = new Array();
  constructor(private examdriveService:ExamdriveService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const examdriveId = this.route.snapshot.params['id'];
    this.getExamdrive(examdriveId);
    setTimeout(() => {
      this.getCenters();
    },500);
  }

  getExamdrive(id: number): void{
    this.examdriveService.getExamdrive(id).subscribe((examdrive) => this.examdrive=examdrive);
  }

  getCenters(): void{
    for( var batch of this.examdrive.batchList){
      this.centers.push(batch.center);
    }
    this.centers = this.centers.filter(
      (thing, i, arr) => arr.findIndex(t => t.centerId === thing.centerId) === i
    );
  }

  parseObject(obj)
  {
    for(var key in obj)
    {
        console.log("key: " + key + ", value: " + obj[key])
        if(obj[key] instanceof Object)
        {
          this.parseObject(obj[key]);
        }
    }
  }
}
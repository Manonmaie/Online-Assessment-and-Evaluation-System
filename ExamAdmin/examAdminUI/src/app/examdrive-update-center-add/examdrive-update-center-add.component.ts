import { Component, OnInit } from '@angular/core';
import {Examdrive} from '../shared/examdrive';
import {Center} from '../shared/center';
import {Batch} from '../shared/batch';
import {CenterService} from '../services/center.service';
import {BatchService} from '../services/batch.service';
import {ExamdriveService} from '../services/examdrive.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import {resetError, setError} from '../shared/error';

@Component({
  selector: 'app-examdrive-update-center-add',
  templateUrl: './examdrive-update-center-add.component.html',
  styleUrls: ['./examdrive-update-center-add.component.scss']
})
export class ExamdriveUpdateCenterAddComponent implements OnInit {
  examdrive: Examdrive;
  center: Center;
  centers: Center[];
  batches: Batch[];
  oldCenters: number[] = new Array();
  newBatch: Batch = {batchCode: null, batchEndTime: null, batchStartTime: null, qpStatus: 'PENDING', center: null, examdrive: null};
  examdriveId: number = this.route.snapshot.params['id'];
  selectedCenter: number;

  constructor(private examdriveService: ExamdriveService, private centerService: CenterService, private batchService: BatchService, public route: ActivatedRoute, public router: Router) { }

  ngOnInit(): void {
    this.getExamdrive(this.examdriveId);
    setTimeout(() => {
      this.newBatch.examdrive = this.examdrive;
      this.getOldCenters();
      setTimeout(() =>{
        this.filterCenters();
      },500)
    },300);
  }

  getCenters(): void{
    this.centerService.getCenters().subscribe((centers)=> this.centers = centers);
  }

  getOldCenters(): void{
    for( var batch of this.examdrive.batchList){
      this.oldCenters.push(batch.center.centerId);
    }
    this.oldCenters = this.oldCenters.filter(
      (thing, i, arr) => arr.findIndex(t => t === thing) === i
    );
  }

  filterCenters(): void{
    this.getCenters();
    setTimeout(()=>{
      this.centers = this.centers.filter(item => !this.oldCenters.includes(item.centerId));
    },200);
  }

  getExamdrive(id: number): void{
    this.examdriveService.getExamdrive(id).subscribe((examdrive) => this.examdrive=examdrive);
    this.setBatches(id);
  }
  
  setBatches(id: number): void{
    this.batchService.getBatchesByExamdrive(id).subscribe((batches) => this.examdrive.batchList=batches);
  }

  selectCenter(): void{
    if(this.selectedCenter==null){
      setError("examdriveCenter","Center is Required");
    }
    else{
      resetError("examdriveCenter");
      this.centerService.getCenter(this.selectedCenter).subscribe((center) => this.center=center);
    }
  }

  editCenter(): void{
    this.center = null;
  }
}

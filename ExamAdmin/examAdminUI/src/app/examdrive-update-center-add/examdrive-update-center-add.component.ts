import { Component, OnInit } from '@angular/core';
import {Examdrive} from '../shared/examdrive';
import {Center} from '../shared/center';
import {Batch} from '../shared/batch';
import {CenterService} from '../services/center.service';
import {BatchService} from '../services/batch.service';
import {ExamdriveService} from '../services/examdrive.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import {resetError, setError} from '../shared/error';
import { FormGroup, FormControl, FormArray, FormBuilder } from '@angular/forms'

@Component({
  selector: 'app-examdrive-update-center-add',
  templateUrl: './examdrive-update-center-add.component.html',
  styleUrls: ['./examdrive-update-center-add.component.scss']
})
export class ExamdriveUpdateCenterAddComponent implements OnInit {
  examdrive: Examdrive;
  center: Center;
  centers: Center[];
  oldCenters: number[] = new Array();
  examdriveId: number = this.route.snapshot.params['id'];
  selectedCenter: number;
  batchList: Batch[];

  productForm: FormGroup;

  constructor(private examdriveService: ExamdriveService, private centerService: CenterService, private batchService: BatchService, public route: ActivatedRoute, public router: Router, private fb:FormBuilder) {
    this.productForm = this.fb.group({
      name: '',
      batches: this.fb.array([]) ,
    });
  }

  ngOnInit(): void {
    this.getExamdrive(this.examdriveId);
    setTimeout(() => {
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
    for( var batch of this.batchList){
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
      this.centers = this.centers.sort((obj1, obj2) => {
        if (obj1.centerCode > obj2.centerCode) {
            return 1;
        }
        if (obj1.centerCode < obj2.centerCode) {
            return -1;
        }
        return 0;
      });
    },200);
  }

  getExamdrive(id: number): void{
    this.examdriveService.getExamdrive(id).subscribe((examdrive) => this.examdrive=examdrive);
    this.setBatches(id);
  }
  
  setBatches(id: number): void{
    this.batchService.getBatchesByExamdrive(id).subscribe((batches) => this.batchList=batches);
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
    if(confirm(" Are you sure to change the center. All the entered batches information will be lost")){
      this.center = null;
      this.productForm.value.batches = null; //NOT WORKING
    }
  }

  batches() : FormArray {
    return this.productForm.get("batches") as FormArray
  }

  newBatch(): FormGroup {
    return this.fb.group({batchCode: null, batchStartTime: null, qpStatus:'PENDING', batchEndTime: null, center: this.center, examdrive: this.examdrive});
  }

  addBatch() {
    this.batches().push(this.newBatch());
  }

  removeBatch(i:number) {
    this.batches().removeAt(i);
  }

  addCenter() {
    this.batchService.addBatches(this.productForm.value.batches).subscribe((batches) => this.productForm.value.batches=batches);
    setTimeout(()=>{
      this.router.navigate(['/examdriveupdate',this.examdriveId]);
    },500);
  }
}

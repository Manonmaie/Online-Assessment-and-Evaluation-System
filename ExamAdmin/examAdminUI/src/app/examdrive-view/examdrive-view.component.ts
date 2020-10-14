import { Component, OnInit } from '@angular/core';
import {ExamdriveService } from '../services/examdrive.service';
import { Params, ActivatedRoute } from '@angular/router';
import { Examdrive } from '../shared/examdrive';
import {Observable, of} from 'rxjs';

@Component({
  selector: 'app-examdrive-view',
  templateUrl: './examdrive-view.component.html',
  styleUrls: ['./examdrive-view.component.scss']
})
export class ExamdriveViewComponent implements OnInit {
  examdrive: Examdrive;
  constructor(private examdriveService:ExamdriveService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const examdriveId = this.route.snapshot.params['id'];
    this.getExamdrive(examdriveId);
  }

  getExamdrive(id: number): void{
    this.examdriveService.getExamdrive(id).subscribe((examdrive) => this.examdrive=examdrive);
  }
}

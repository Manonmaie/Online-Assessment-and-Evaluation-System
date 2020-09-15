import { Component, OnInit } from '@angular/core';
import {Examdrive} from '../shared/examdrive';
import {ExamdriveService} from '../services/examdrive.service';
import {Observable, of} from 'rxjs';

@Component({
  selector: 'app-examdrive',
  templateUrl: './examdrive.component.html',
  styleUrls: ['./examdrive.component.scss']
})
export class ExamdriveComponent implements OnInit {
  examdrives: Examdrive[];
  constructor(private examdriveService:ExamdriveService) { }

  ngOnInit(): void {
    this.examdriveService.getExamdrives().subscribe((examdrives) => this.examdrives = examdrives);
  }
}

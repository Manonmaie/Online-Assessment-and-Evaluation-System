import { Component, OnInit } from '@angular/core';
import {Examinee} from '../shared/examinee';
import {ExamineeService} from '../services/examinee.service';
import {Observable, of} from 'rxjs';

@Component({
  selector: 'app-examinee',
  templateUrl: './examinee.component.html',
  styleUrls: ['./examinee.component.scss']
})
export class ExamineeComponent implements OnInit {
  examinees: Examinee[];
  constructor(private examdriveService:ExamineeService) { }

  ngOnInit(): void {
    this.examdriveService.getExaminees().subscribe((examinees) => this.examinees = examinees);
  }
}

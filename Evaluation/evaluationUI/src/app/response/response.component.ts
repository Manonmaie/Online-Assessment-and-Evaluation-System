import { Component, OnInit } from '@angular/core';
import { Response } from '../shared/Response';
import {ResponseService} from '../services/response.service';
import { Params, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-response',
  templateUrl: './response.component.html',
  styleUrls: ['./response.component.scss']
})
export class ResponseComponent implements OnInit {

  responses: Response[];
  constructor(private ResponseService: ResponseService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    const ExamineeBatchId = this.route.snapshot.params['id'];
    this.getResponses(ExamineeBatchId);
  }

  getResponses(id:number): void{
    this.ResponseService.getAllResponsesForExamDrive(id).subscribe((responses) => this.responses = responses);
  }

}

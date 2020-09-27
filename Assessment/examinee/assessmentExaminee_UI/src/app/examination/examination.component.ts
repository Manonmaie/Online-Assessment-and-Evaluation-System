import { Component, OnInit } from '@angular/core';
import { Examination } from "../shared/examination";
import { ItemMcqOption } from "../shared/itemMcqOption";
import { ExaminationService } from "../services/examination.service";
import { Params, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-examination',
  templateUrl: './examination.component.html',
  styleUrls: ['./examination.component.scss']
})
export class ExaminationComponent implements OnInit {

  qpItems: Examination[];

  constructor(private examinationService: ExaminationService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const qpId = this.route.snapshot.params['id'];
    this.examinationService.getQpItemsOfQuestionPaper(qpId).subscribe((qpItems) => this.qpItems = qpItems);
  }

}

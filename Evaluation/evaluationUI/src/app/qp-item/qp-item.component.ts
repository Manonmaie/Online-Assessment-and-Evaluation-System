import { Component, OnInit } from '@angular/core';
import { QpItem } from '../shared/QpItem';
import {QpItemService} from '../services/qp-item.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-qp-item',
  templateUrl: './qp-item.component.html',
  styleUrls: ['./qp-item.component.scss']
})
export class QpItemComponent implements OnInit {

  qpitems: QpItem[];
  constructor(private QpItemService: QpItemService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    const courseId = this.route.snapshot.params['id'];
    this.getCourses(courseId);
  }

  getCourses(id:number): void{
    this.QpItemService.getAllQpItemsForQuestionPaper(id).subscribe((qpitems) => this.qpitems = qpitems);
  }

}

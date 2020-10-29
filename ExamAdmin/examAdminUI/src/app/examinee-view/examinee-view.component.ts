import { Component, OnInit } from '@angular/core';
import { ExamineeService } from '../services/examinee.service';
import { Params, ActivatedRoute } from '@angular/router';
import {Observable, of} from 'rxjs';
import { Examinee } from '../shared/examinee';

@Component({
  selector: 'app-examinee-view',
  templateUrl: './examinee-view.component.html',
  styleUrls: ['./examinee-view.component.scss']
})
export class ExamineeViewComponent implements OnInit {
  examinee: Examinee;
  searchText: any;
  pageNo: number = 1;
  itemsPage: number = 25;
  constructor(private examineeService: ExamineeService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const examineeId = this.route.snapshot.params['id'];
    this.getExaminee(examineeId);
  }

  getExaminee(id: number): void{
    this.examineeService.getExaminee(id).subscribe((examinee)=> this.examinee=examinee);
  }
}

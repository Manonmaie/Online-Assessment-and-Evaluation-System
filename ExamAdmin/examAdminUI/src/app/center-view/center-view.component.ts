import { Component, OnInit } from '@angular/core';
import {Center} from '../shared/center';
import {CenterService} from '../services/center.service';
import {Observable, of} from 'rxjs';
import { Params, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-center-view',
  templateUrl: './center-view.component.html',
  styleUrls: ['./center-view.component.scss']
})
export class CenterViewComponent implements OnInit {
  center: Center;
  constructor(private centerService:CenterService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    const centerId = this.route.snapshot.params['id'];
    this.getCenter(centerId);
  }

  getCenter(id: number): void{
    this.centerService.getCenter(id).subscribe((center) => this.center = center);
  }
}

import { Component, OnInit } from '@angular/core';
import { Center } from '../shared/center';
import {CenterService} from '../services/center.service';
import { Params, ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-center-add',
  templateUrl: './center-add.component.html',
  styleUrls: ['./center-add.component.scss']
})
export class CenterAddComponent implements OnInit {
  center = {centerName: null, centerCode: null, centerCapacity: 0}
  constructor(private centerService: CenterService, public route: Router) { }

  ngOnInit(): void {
  }

  addCenter(center: Center): void{
    this.centerService.addCenter(center).subscribe((center) => this.center=center);
  }

  onSubmit(){
    this.addCenter(this.center);
    this.route.navigate(['/centers']);
  }

}

import { Component, OnInit } from '@angular/core';
import { Center } from '../shared/center';
import {CenterService} from '../services/center.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import {setError} from '../shared/error';

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
    if(this.center.centerName==null){
      setError("centerName","Center Name is Required");
    }
    if(this.center.centerCode==null){
      setError("centerCode","Center Code is Required");
    }
    else{
      this.addCenter(this.center);
      this.route.navigate(['/centers']);
    }
  }
}

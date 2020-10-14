import { Component, OnInit } from '@angular/core';
import { Center } from '../shared/center';
import {CenterService} from '../services/center.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import {resetError, setError} from '../shared/error';

@Component({
  selector: 'app-center-add',
  templateUrl: './center-add.component.html',
  styleUrls: ['./center-add.component.scss']
})
export class CenterAddComponent implements OnInit {
  center = {centerName: null, centerCode: null, centerCapacity: 0}
  constructor(private centerService: CenterService, public router: Router) { }

  ngOnInit(): void {
  }

  addCenter(center: Center): void{
    this.centerService.addCenter(center).subscribe((center) => this.center=center);
  }

  onSubmit(){
    if(this.center.centerName==null || this.center.centerName==""){
      setError("centerName","Center Name is Required");
    }
    else{
      resetError("centerName");
      if(this.center.centerCode==null || this.center.centerCode==""){
        setError("centerCode","Center Code is Required");
      }
      else{
        this.addCenter(this.center);
        setTimeout(() => {
          this.router.navigate(['/centers']);
        },500);
      }
    }
  }
}

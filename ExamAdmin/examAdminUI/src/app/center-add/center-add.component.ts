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
  codes: string[];
  constructor(private centerService: CenterService, public router: Router) { }

  ngOnInit(): void {
    this.getCodes();
  }

  addCenter(center: Center): void{
    this.centerService.addCenter(center).subscribe((center) => this.center=center);
  }

  getCodes(): void{
    this.centerService.getCodes().subscribe((codes) => this.codes=codes);
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
        if(this.codes.includes(this.center.centerCode)){ 
          setError("centerCode","This Center Code is already taken");
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
}

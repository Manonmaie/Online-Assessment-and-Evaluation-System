import { Component, OnInit } from '@angular/core';
import { Center } from '../shared/center';
import {CenterService} from '../services/center.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import {resetError, setError} from '../shared/error';

@Component({
  selector: 'app-center-update',
  templateUrl: './center-update.component.html',
  styleUrls: ['./center-update.component.scss']
})
export class CenterUpdateComponent implements OnInit {
  center: Center;
  centerId: number;
  codes: string[];
  constructor(private centerService: CenterService, private route: ActivatedRoute, public router: Router) { }

  ngOnInit(): void {
    this.centerId = this.route.snapshot.params['id'];
    this.getCenter(this.centerId);
    this.getCodes();
  }

  getCenter(id: number): void{
    this.centerService.getCenter(id).subscribe((center) => this.center = center);
  }

  updateCenter(id:number, center: Center): void{
    this.centerService.updateCenter(id,center).subscribe((center) => this.center = center);
  }

  getCodes(): void{
    this.centerService.getCodes().subscribe((codes) => this.codes=codes);
    setTimeout(() => {
      this.codes = this.codes.filter(obj => obj !== this.center.centerCode);
    },1000);
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
          this.updateCenter(this.centerId,this.center);
          setTimeout(() => {
            this.router.navigate(['/centers']);
          },500);
        }
      }
    }
  }  
}

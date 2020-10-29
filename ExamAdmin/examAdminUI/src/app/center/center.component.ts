import { Component, OnInit } from '@angular/core';
import {Center} from '../shared/center';
import {CenterService} from '../services/center.service';
import {Observable, of} from 'rxjs';

@Component({
  selector: 'app-center',
  templateUrl: './center.component.html',
  styleUrls: ['./center.component.scss']
})
export class CenterComponent implements OnInit {
  centers: Center[];
  searchText: any;
  pageNo: number = 1;
  itemsPage: number = 25;
  constructor(private centerService:CenterService) { }

  ngOnInit(): void {
    this.getCenters();
  }

  getCenters(): void{
    this.centerService.getCenters().subscribe((centers) => this.centers = centers);
  }

  deleteCenter(center: Center): void{
    if(confirm("Are you sure to delete the "+center.centerName+" center")){
      this.centerService.deleteCenter(center.centerId).subscribe( response => {
        // alert(response.message);
        this.getCenters();
      });
    }
  }
}

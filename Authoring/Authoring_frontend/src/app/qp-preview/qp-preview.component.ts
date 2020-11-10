import { Component, OnInit } from '@angular/core';
import {QPServiceService} from '../service/qpservice.service'
import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-qp-preview',
  templateUrl: './qp-preview.component.html',
  styleUrls: ['./qp-preview.component.css']
})
export class QpPreviewComponent implements OnInit {
  
  constructor(private QPService :QPServiceService) { }
  myQPSet: Set<number>;
  qpItems=[];
  ngOnInit(): void {
    this.myQPSet=this.QPService.getQpSelected();
    this.getItemids();
  }
  
  printS(){
    console.log("geezz"); 
    console.log(this.myQPSet);
  }

  getItemids(){
    var params = new HttpParams();
    params = params.set('itemId',Array.from(this.myQPSet).join(','));
    this.QPService.getitemByIds(params).subscribe((items)=> this.qpItems=items);

  }

}



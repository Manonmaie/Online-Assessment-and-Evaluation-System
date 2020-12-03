import { Component, OnInit } from '@angular/core';
import {QPServiceService} from '../service/qpservice.service'

@Component({
  selector: 'app-exports',
  templateUrl: './exports.component.html',
  styleUrls: ['./exports.component.css']
})
export class ExportsComponent implements OnInit {

  constructor(private QPService :QPServiceService) { }

  ngOnInit(): void {
  }

  key:any="";

  exportQP(){
    this.QPService.exportQPs().subscribe((j)=>this.key=j.key);
  }
  exportAnswers(){
    this.QPService.exportAnswers().subscribe((j)=>this.key=j.key);
  }
// {"success":true,"key":"6V9ieYXFOKBX","link":"https://file.io/6V9ieYXFOKBX","expiry":"14 days"}
// this.ItemService.getitem(author_id).subscribe((items)=> this.items=items);

}

import { Component, OnInit } from '@angular/core';
import { Examinee } from '../shared/examinee';
import { ExamineeService } from '../services/examinee.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import * as XLSX from 'xlsx';

@Component({
  selector: 'app-examinee-add-bulk',
  templateUrl: './examinee-add-bulk.component.html',
  styleUrls: ['./examinee-add-bulk.component.scss']
})
export class ExamineeAddBulkComponent implements OnInit {
  examineeList:Examinee[] = [];
  constructor(private examineeService: ExamineeService, public route: Router) { }
  ngOnInit(): void {
  }

  onFileChange(ev){
    let workBook = null;
    let jsonData = null;
    const reader = new FileReader();
    const file = ev.target.files[0];
    reader.onload = (event) => {
      const data = reader.result;
      workBook = XLSX.read(data, { type: 'binary' });
      jsonData = workBook.SheetNames.reduce((initial, name) => {
        const sheet = workBook.Sheets[name];
        initial["1"] = XLSX.utils.sheet_to_json(sheet);
        return initial["1"];
      }, {});
      this.examineeList = jsonData;
    }
    reader.readAsBinaryString(file);
  }

  addExamineeBulk(examineeList: Examinee[]): void{
    this.examineeService.addExamineeBulk(examineeList).subscribe((examineeList) => this.examineeList=examineeList);
  }

  onSubmit(){
    this.addExamineeBulk(this.examineeList);
    this.route.navigate(['/examinees']);
  }
}

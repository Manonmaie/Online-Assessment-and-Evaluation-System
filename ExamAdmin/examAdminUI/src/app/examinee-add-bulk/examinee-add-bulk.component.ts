import { Component, OnInit } from '@angular/core';
import { Examinee } from '../shared/examinee';
import { ExamineeService } from '../services/examinee.service';
import { Params, ActivatedRoute, Router } from '@angular/router';
import * as XLSX from 'xlsx';
import { ExcelServicesService } from '../services/excel-services.service';  

@Component({
  selector: 'app-examinee-add-bulk',
  templateUrl: './examinee-add-bulk.component.html',
  styleUrls: ['./examinee-add-bulk.component.scss']
})
export class ExamineeAddBulkComponent implements OnInit {
  examineeList:Examinee[] = [];
  examineeTemplateList:any = [
    {
      'examineeName': null, 
      'examineeCode':null,
      // 'examineePassword': null,
      'examineeBranch':null,
      'examineeEmail':null,
      'examineeCollege':null
    }
  ];
  fileName = 'StudentDetails'
  constructor(private examineeService: ExamineeService, private excelService:ExcelServicesService, public router: Router) { }
  ngOnInit(): void {
  }

  exportexcel(): void{
    this.excelService.exportAsExcelFile(this.examineeTemplateList,this.fileName);
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
    setTimeout(() => {
      this.router.navigate(['/examinees']);
    },2000);
  }
}

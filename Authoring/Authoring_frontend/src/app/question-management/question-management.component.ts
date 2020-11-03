import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Item} from '../shared/item';
import { ItemServiceService } from '../service/itemService.service';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import {Router} from '@angular/router'




interface Country {
  id?: number;
  subject: string;
  question: string;
  isReviewed: boolean;
}

@Component({
  selector: 'question-management-table',
  templateUrl: './question-management.component.html',
  styleUrls: ['./question-management.component.css']
})



export class QuestionManagementComponent {

  page = 1;
  pageSize = 10;
  collectionSize=3;
  author_id: Number=1;
  items=[];
  public Editor = ClassicEditor;
  public model = {
    editorData: '<p></p>'
  };

  countries: Country[];

  constructor(private ItemService: ItemServiceService,private router:Router) {
    this.getitem(this.author_id);
    this.refreshItems();
  }

  ngOnChanges() {
    console.log(this.items);
  }

  stringToHTML(id, str) {
    var parser = new DOMParser();
    var doc = parser.parseFromString(str, 'text/html');
    console.log(str);
    document.getElementById(id).innerHTML = str;
  };

  refreshItems() {
    this.items
    .map((item, i) => ({id: i + 1, ...item}))
      .slice((this.page - 1) * this.pageSize, (this.page - 1) * this.pageSize + this.pageSize);
  }


  editItem(){
    this.router.navigate(['/itemadd']);
  }

  getitem(author_id: Number): void{
    this.ItemService.getitem(author_id).subscribe((items)=> this.items=items);
    console.log(this.items);
    // this.collectionSize = this.items.length;
  }


}


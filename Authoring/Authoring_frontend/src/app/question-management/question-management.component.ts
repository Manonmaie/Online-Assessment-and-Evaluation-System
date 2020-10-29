import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Item_TF} from '../shared/item_TF';
import { ItemTFServiceService } from '../service/item-tfservice.service';



interface Country {
  id?: number;
  subject: string;
  question: string;
  isReviewed: boolean;
}

const COUNTRIES: Country[] = [
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'What are the keys present?',
    isReviewed: true,
  },
  {
    subject: 'Data Modelling',
    question: 'Which is the best databse?',
    isReviewed: false,
  },
  {
    subject: 'Data Modelling',
    question: 'Question 3',
    isReviewed: true,
  },
  {
    subject: 'Data Modelling',
    question: 'Which is the best databse?',
    isReviewed: false,
  },
  {
    subject: 'DBMS',
    question: 'Question 8',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
  {
    subject: 'DBMS',
    question: 'Which is the best databse?',
    isReviewed: true,
  },
];

@Component({
  selector: 'question-management-table',
  templateUrl: './question-management.component.html'
})
export class QuestionManagementComponent {
  page = 1;
  pageSize = 10;
  collectionSize = COUNTRIES.length;

  items: Item_TF[];

  countries: Country[];

  constructor(private ItemTFService: ItemTFServiceService) {
    this.refreshCountries();
  }

  refreshCountries() {
    this.countries = COUNTRIES
      .map((country, i) => ({id: i + 1, ...country}))
      .slice((this.page - 1) * this.pageSize, (this.page - 1) * this.pageSize + this.pageSize);
  }
  author_id: Number=1;

  getitem_TF(author_id: number): void{
    this.ItemTFService.getitem_TF(author_id).subscribe((items)=> this.items=items);
  }

}
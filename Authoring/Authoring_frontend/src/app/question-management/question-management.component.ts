import { Component } from '@angular/core';

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
  countries: Country[];

  constructor() {
    this.refreshCountries();
  }

  refreshCountries() {
    this.countries = COUNTRIES
      .map((country, i) => ({id: i + 1, ...country}))
      .slice((this.page - 1) * this.pageSize, (this.page - 1) * this.pageSize + this.pageSize);
  }
}
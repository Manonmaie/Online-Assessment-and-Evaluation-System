import { Component } from '@angular/core';
import { FormGroup, FormControl, FormArray, FormBuilder } from '@angular/forms'
  
@Component({
  selector: 'my-app',
  templateUrl: './question-paper.component.html',
  styleUrls: [ './question-paper.component.css' ]
})
export class itemForm  {
  name = 'Angular';
  
  productForm: FormGroup;
   
  constructor(private fb:FormBuilder) {
   
    this.productForm = this.fb.group({
      name: '',
      quantities: this.fb.array([]) ,
    });
  }
  
  quantities() : FormArray {
    return this.productForm.get("quantities") as FormArray
  }
   
  newQuantity(): FormGroup {
    return this.fb.group({
      option: '',
      marks: '',
    })
  }
   
  addQuantity() {
    this.quantities().push(this.newQuantity());
  }
   
  removeQuantity(i:number) {
    this.quantities().removeAt(i);
  }
   
  onSubmit() {
    console.log(this.productForm.value);
  }
}
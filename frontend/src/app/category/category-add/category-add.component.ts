import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';
import { CategoryService } from './../../service/category.service';

@Component({
  selector: 'app-category-add',
  templateUrl: './category-add.component.html',
  styleUrls: ['./category-add.component.scss']
})
export class CategoryAddComponent implements OnInit {
  addForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder, private router: Router, private categoryService: CategoryService) { }

  ngOnInit() {

    this.addForm = this.formBuilder.group({
      code: ['', Validators.required],
      status: [true]
    });

  }

  onSubmit() {
    this.submitted = true;
    if (this.addForm.invalid) {
      return;
    }
    this.categoryService.createCategory(this.addForm.value)
      .subscribe( data => {
        this.router.navigate(['category-list']);
      });
  }

  onCancel (event) {
    this.router.navigate(['category-list']);
  }
}

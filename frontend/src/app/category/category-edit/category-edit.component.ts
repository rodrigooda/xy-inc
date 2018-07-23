import { Category } from './../../model/category';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';
import { CategoryService } from './../../service/category.service';
@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.scss']
})
export class CategoryEditComponent implements OnInit {
  addForm: FormGroup;
  submitted = false;

  constructor(private formBuilder: FormBuilder, private router: Router,
     private categoryService: CategoryService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.categoryService.getCategoryById(params['id']).subscribe( data => {
        const category: Category = data;
        this.addForm = this.formBuilder.group({
          'id': [category.id],
          'code': [category.code, Validators.required],
          'status': [category.status]
        });
      });
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

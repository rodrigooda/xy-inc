import { Category } from './../../model/category';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { CategoryService } from './../../service/category.service';
@Component({
  selector: 'app-category-detail',
  templateUrl: './category-detail.component.html',
  styleUrls: ['./category-detail.component.scss']
})
export class CategoryDetailComponent implements OnInit {
  private category: Category;

  constructor(private router: Router,
     private categoryService: CategoryService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.categoryService.getCategoryById(params['id']).subscribe( data => {
        this.category = data;
      });
    });



  }

  onCancel (event) {
    this.router.navigate(['category-list']);
  }

}

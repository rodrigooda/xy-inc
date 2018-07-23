import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategoryService } from '../../service/category.service';
import { Category } from '../../model/category';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.scss']
})
export class CategoryListComponent implements OnInit {

  categories: Category[];

  constructor(private router: Router, private categoryService: CategoryService) { }

  ngOnInit() {
    this.categoryService.getCategories()
      .subscribe( data => {
        this.categories = data;
      });
  }

  deleteCategory(category: Category): void {
    this.categoryService.deleteCategory(category.id)
      .subscribe( data => {
        this.categories = this.categories.filter(u => u !== category);
      });
  }

  editCategory(category: Category): void {
    this.router.navigate(['category-edit', category.id]);
  }

  addCategory(): void {
    this.router.navigate(['category-add']);
  }

  detailCategory(category: Category): void {
    this.router.navigate(['category-detail', category.id]);
  }
}

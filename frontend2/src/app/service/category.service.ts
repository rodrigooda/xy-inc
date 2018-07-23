import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Category } from './../model/category';

@Injectable()
export class CategoryService {
  constructor(private http: HttpClient) { }
  baseUrl = 'http://localhost:8080/category';

  getCategories() {
    return this.http.get<Category[]>(this.baseUrl);
  }

  getCategoryById(id: number) {
    return this.http.get<Category>(this.baseUrl + '/' + id);
  }

  createCategory(category: Category) {
    return this.http.post(this.baseUrl, category);
  }

  updateCategory(category: Category) {
    return this.http.put(this.baseUrl, category);
  }

  deleteCategory(id: number) {
    return this.http.delete(this.baseUrl + '/' + id);
  }
}

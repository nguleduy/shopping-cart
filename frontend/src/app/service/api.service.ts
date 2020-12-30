import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  BASE_URL = 'http://localhost:3333/';

  constructor(private http: HttpClient) {
  }

  public getAllCategories(): Observable<string[]> {
    return this.http.get<string[]>(this.BASE_URL + 'product-service/categories/all');
  }

  public getByCategory(category: string): Observable<Product[]> {
    return this.http.get<Product[]>(this.BASE_URL + 'product-service/products/category/' + category);
  }
}

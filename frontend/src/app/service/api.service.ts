import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from '../model/product';
import {CartItem} from '../model/CartItem';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  BASE_URL = 'http://localhost:3333/';
  private headers = {headers: new HttpHeaders({'Content-Type': 'application/json'})};

  constructor(private http: HttpClient) {
  }

  public getAllCategories(): Observable<string[]> {
    return this.http.get<string[]>(this.BASE_URL + 'product-service/categories/all');
  }

  public getByCategory(category: string): Observable<Product[]> {
    return this.http.get<Product[]>(this.BASE_URL + 'product-service/products/category/' + category);
  }

  public addToCart(cartItem: CartItem): Observable<any> {
    return this.http.post<Product[]>(this.BASE_URL + 'cart-service/cart/add/', cartItem, this.headers);
  }
}

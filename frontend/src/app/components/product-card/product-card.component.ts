import {Component, Input, OnInit} from '@angular/core';
import {Product} from '../../model/Product';
import {ApiService} from '../../service/api.service';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.css']
})
export class ProductCardComponent implements OnInit {

  @Input() product: Product;

  constructor(private apiService: ApiService) {
  }

  ngOnInit(): void {
  }

  addToCart(amount: string): void {
    const cartItem = {
      productId: this.product.id,
      amount
    };
    this.apiService.addToCart(cartItem).subscribe();
  }

}

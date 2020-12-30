import {Component, OnInit} from '@angular/core';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  public products: Product[];

  constructor() {
  }

  ngOnInit(): void {
  }

}

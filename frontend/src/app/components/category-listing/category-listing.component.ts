import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ApiService} from '../../service/api.service';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-category-listing',
  templateUrl: './category-listing.component.html',
  styleUrls: ['./category-listing.component.css']
})
export class CategoryListingComponent implements OnInit {

  products: Product[];

  constructor(private route: ActivatedRoute, private apiService: ApiService) {
  }

  ngOnInit(): void {
    const selectedCategory = this.route.snapshot.paramMap.get('category');
    this.getProductsByCategory(selectedCategory);
  }

  private getProductsByCategory(selectedCategory: string): void {
    this.apiService.getByCategory(selectedCategory).subscribe(categoryProducts => this.products = categoryProducts);
  }

}

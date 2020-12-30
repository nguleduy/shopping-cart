import {Component, OnInit} from '@angular/core';
import {ApiService} from '../../service/api.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  public categories: string[];

  constructor(private apiService: ApiService) {
  }

  ngOnInit(): void {
    this.apiService.getAllCategories().subscribe(categoriesFromBackend => this.categories = categoriesFromBackend);
  }

}

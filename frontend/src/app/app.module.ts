import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {CategoryListingComponent} from './components/category-listing/category-listing.component';
import {ProductCardComponent} from './components/product-card/product-card.component';
import {CartComponent} from './components/cart/cart.component';

@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    DashboardComponent,
    CategoryListingComponent,
    ProductCardComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

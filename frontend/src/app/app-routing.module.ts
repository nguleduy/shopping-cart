import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from './components/dashboard/dashboard.component';
import {CategoryListingComponent} from './components/category-listing/category-listing.component';

const routes: Routes = [
  {path: 'dashboard', component: DashboardComponent},
  // default route
  {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
  {path: ':category', component: CategoryListingComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

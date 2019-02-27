import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { ProductsComponent } from './products/products.component';
import { OrderComponent } from './order/order.component';
import { ContactComponent } from './contact/contact.component';
import {HttpClientModule} from "@angular/common/http";

const appRoutes: Routes = [
  { path: 'products', component: ProductsComponent },
  { path: 'products/order', component: OrderComponent },
  { path: 'contact', component: ContactComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    OrderComponent,
    ContactComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

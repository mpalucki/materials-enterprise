import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Product} from "../models/product";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<Product>(
      "api/products", { observe: 'response' })
      .subscribe(response => {
        console.log(response);
      })
  }

}

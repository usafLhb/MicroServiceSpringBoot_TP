import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService { 

  constructor(private http : HttpClient) { }

  public addProduct(prdct:product):Observable<product>{
    return this.http.post<product>(`http://localhost:8888/INVENTORY-SERVICE/post`,prdct);
  }
}

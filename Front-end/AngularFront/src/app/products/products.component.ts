import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  products:any;
  errorMessage: any;
  name:string | undefined;
  price:number | undefined;
  constructor(private http:HttpClient) { 

  }

  ngOnInit(): void {
    this.http.get("http://localhost:8888/INVENTORY-SERVICE/products").subscribe({
      next:(data)=>{
        console.log(data);
       this.products=data;
      },
      error:(err)=>{

      }
    })
  }
  getOrderDetail(o:any){
  //   this.http.put<any>('https://jsonplaceholder.typicode.com/invalid-url')
  // .subscribe({
  //     next: data => {
  //       console.log(data);
  //     },
  //     error: error => {
  //         this.errorMessage = error.message;
  //         alert('There was an error!');
  //     }
  // });
  }
 

}

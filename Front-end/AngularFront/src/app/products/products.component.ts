import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { throwError } from 'rxjs';
import { product } from './product';
import { ProductService } from './product.service'; 

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  createPostForm!: FormGroup;  
  productPayload!: product; 
  products:any;
  errorMessage: any;
  name:string | undefined;
  price:number | undefined;
  constructor(private http:HttpClient,private productService:ProductService, private router:Router ) { 
    this.productPayload={
      name:'',
      price:0,  
    }
    

    this.createPostForm = new FormGroup({
      name: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
    }); 

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

  createPost() { 
    
    
    this.productPayload.name = this.createPostForm.get('name')?.value;
    this.productPayload.price = this.createPostForm.get('price')?.value; 

      this.productService.addProduct(this.productPayload).subscribe
    ((data) => { 
      alert("data");
      // this.router.navigateByUrl("/products")
      this.router.navigate(["/products"]);
      console.log(data);
    }, (error: any) => {
      throwError(error);
      // alert(error)
    })
  }


  // public onAddEmployee(addForm : NgForm):void{ 
  //   this.productService.addProduct(addForm.value).subscribe(
  //     (response:Employee)=>{
  //       console.log(response);
  //       addForm.reset();
  //       this.getEmloyees();
  //     },
  //     (error:HttpErrorResponse)=>{
  //       alert(error.message);
  //     }
  //   );
  //  }
  
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

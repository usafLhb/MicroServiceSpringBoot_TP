import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  order:any;
  customerId:number | undefined;
  constructor(private http:HttpClient, private router:Router,private route:ActivatedRoute) { 
    this.customerId=route.snapshot.params['customerId'];
  }

  ngOnInit(): void { 
    this.http.get("http://localhost:8888/BILLING-SERVICE/order/"+this.customerId).subscribe({
      next:(data)=>{
        console.log(data);
       this.order=data;
      },
      error:(err)=>{

      }
    })

  
    }
    getOrderDetail(o:any){
      this.router.navigateByUrl("/order-details/"+o.id)
    }

}

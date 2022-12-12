import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  detailOrder:any;
  orderId:number | undefined;
  constructor(private http:HttpClient, private router:Router,private route:ActivatedRoute) { 
    this.orderId=route.snapshot.params['orderId'];
  }

  ngOnInit(): void { 
    this.http.get("http://localhost:8888/BILLING-SERVICE/fullBill/"+this.orderId).subscribe({
      next:(data)=>{
        console.log(data);
       this.detailOrder=data;
      } 
    })

  
    }

}

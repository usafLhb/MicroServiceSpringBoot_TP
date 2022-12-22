import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomersComponent } from './customers/customers.component';
import { AuthGuard } from './guard/security.guard';
import { HomeComponent } from './home/home.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { OrdersComponent } from './orders/orders.component';
import { ProductsComponent } from './products/products.component';

const routes: Routes = [
  {path:"products",component:ProductsComponent, 
  canActivate:[AuthGuard],data:{roles:['ADMIN']}},
{path:"customer",component:CustomersComponent, 
canActivate:[AuthGuard],data:{roles:['USER']}},
{path:"order/:customerId",component:OrdersComponent, 
canActivate:[AuthGuard],data:{roles:['USER']}},
{path:"order-details/:orderId",component:OrderDetailsComponent, 
canActivate:[AuthGuard],data:{roles:['USER']}},
{path:"",component:HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

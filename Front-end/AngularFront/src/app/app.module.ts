import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component'; 
import { HttpClientModule } from '@angular/common/http'; 
import {ReactiveFormsModule} from "@angular/forms";
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular'; 
import { NavbarComponent } from './navbar/navbar.component';
import { CustomersComponent } from './customers/customers.component';
import { ProductsComponent } from './products/products.component';
import { OrdersComponent } from './orders/orders.component';
import { OrderDetailsComponent } from './order-details/order-details.component';



export function kcFactory(kcSecService : KeycloakService){
  return ()=>{  
  kcSecService.init({
  config : {
  url : "http://localhost:8080",
  realm : "wallet-realm",
  clientId : "wallet-client"
  },
  loadUserProfileAtStartUp : true,
  initOptions : {
  onLoad : 'check-sso',
  checkLoginIframe : true
  }
  });
  }
  }
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CustomersComponent,
    ProductsComponent,
   
    OrdersComponent,
    OrderDetailsComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    KeycloakAngularModule,
    HttpClientModule, 
  ],
  providers: [{provide : APP_INITIALIZER, deps : [KeycloakService], useFactory : kcFactory, multi : true}],
  bootstrap: [AppComponent]
})
export class AppModule { }

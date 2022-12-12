import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductsComponent } from './products/products.component';
import { HttpClientModule } from '@angular/common/http';
import { CustomersComponent } from './customers/customers.component';
import { OrdersComponent } from './orders/orders.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
// import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { ReactiveFormsModule } from '@angular/forms'; 
import { NavbaruComponent } from './navbaru/navbaru.component';
import { KeycloakService } from 'keycloak-angular';

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
        ProductsComponent,
        CustomersComponent,
        OrdersComponent,
        OrderDetailsComponent,
        NavbaruComponent
    ],
       
    providers: [{ provide: APP_INITIALIZER, deps: [KeycloakService], useFactory: kcFactory, multi: true }],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule, 
        // KeycloakAngularModule
    ]
})
export class AppModule { }

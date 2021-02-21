import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ManageOrderComponent } from './manage-order/manage-order.component';
import { MenuComponent } from './menu/menu.component';
import { PaymentComponent } from './payment/payment.component';
import { ViewCustomerComponent } from './view-customer/view-customer.component';

const routes: Routes = [
  {
    path:'',
    component:HomeComponent
  },
  {path:'register',
  component:AddCustomerComponent
  },
  {
    path:'update/:id',
    component:AddCustomerComponent
  },
  {path:'search',
  component:ViewCustomerComponent
  },
  {
    path:'menu',
    component:MenuComponent
  },
  {
    path:'order',
    component:ManageOrderComponent
  },
  {
    path:'payment',
    component:PaymentComponent
  },
  {
    path:'login',
    component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

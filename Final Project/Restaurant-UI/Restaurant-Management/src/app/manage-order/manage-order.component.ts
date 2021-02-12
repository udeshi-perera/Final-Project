import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { ManageOrderService } from '../manage-order.service';

@Component({
  selector: 'app-manage-order',
  templateUrl: './manage-order.component.html',
  styleUrls: ['./manage-order.component.css']
})
export class ManageOrderComponent implements OnInit {

  order: Order=new Order(0,"");
  message: any;

  constructor(private service:ManageOrderService) { }

  ngOnInit(): void {
    this.viewOrderDetails();
  }

  public createOrder(){
    this.service.createOrder().subscribe();
  }

  public viewOrderDetails(){
    console.log("im on view");
    console.log(this.order);
    this.service.viewOrderDetails().subscribe();
  }

  public addGetOrder(){
    this.createOrder();
    console.log("created order");
    // this.viewOrderDetails();
  }

}

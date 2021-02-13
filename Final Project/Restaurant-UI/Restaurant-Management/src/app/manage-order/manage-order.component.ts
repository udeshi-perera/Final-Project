import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { ManageOrderService } from '../manage-order.service';
import { ManageMenuService } from '../manage-menu.service';
import { OrderDetail } from '../orderDetail';
import { Router} from '@angular/router'

@Component({
  selector: 'app-manage-order',
  templateUrl: './manage-order.component.html',
  styleUrls: ['./manage-order.component.css']
})
export class ManageOrderComponent implements OnInit {

  order: Order=new Order(0,"");
  orderDetail: OrderDetail=new OrderDetail("",0,0,0,0);
  message: any;
  menus:any;
  menuPrice:any;

  constructor(private service:ManageOrderService,private menuService:ManageMenuService,private router:Router) { }

  ngOnInit(): void {
    this.getMenuList();
  }

  public addOrderDetails(){
    this.orderDetail.status="ACTIVE";
    this.service.addOrderDetail(this.orderDetail).subscribe((data)=>this.message=data);
  }

  public createOrder(){
    console.log("hiiiiiiiiii");
    this.service.createOrder().subscribe();
  }


  public getMenuList(){
    this.menuService.getAllMenu().subscribe((data)=>this.menus=data);
  }

  public getMenuDetail(){
    this.service.getMenuDetail(this.orderDetail.menu).subscribe((data)=>this.menuPrice=data);
  }

  public savePayment(){
    console.log("hiiii")
    this.service.savePayment().subscribe();
  }

  goToPage(payment):void{
    console.log("hi");
    this.router.navigate([payment]);

  }
}

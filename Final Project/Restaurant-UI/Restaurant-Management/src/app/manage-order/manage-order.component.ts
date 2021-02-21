import { Component, OnInit } from '@angular/core';
import { Order } from '../order';
import { ManageOrderService } from '../manage-order.service';
import { ManageMenuService } from '../manage-menu.service';
import { OrderDetail } from '../orderDetail';
import { Router} from '@angular/router'
import { Observable } from 'rxjs';

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
  orderDetailList:any;
  orderDetails:any;
  total:any

  constructor(private service:ManageOrderService,private menuService:ManageMenuService,private router:Router) { }

  ngOnInit(): void {
    this.getMenuList();
    this.getTotal(this.orderDetails);
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

  // loadTable(){
  //   let resp=this.service.loadTable(this.orderDetailList).subscribe((data)=>this.orderDetailList=data);
  //    console.log(this.orderDetailList);
  // }

  public addDetail(){
    this.service.refreshNeeded$.subscribe(()=>{
      this.service.getAllOrderDetail().subscribe((data)=>this.orderDetails=data);
      this.getTotal(this.orderDetails);
    })
    // console.log(this.menus);
    this.service.getAllOrderDetail().subscribe((data)=>this.orderDetails=data);
    this.getTotal(this.orderDetails);

console.log(this.orderDetails);
    
  }

  getTotal(orderDetails) {
    let total = 0;
  
    orderDetails.map((item) => {
      total += Number(item.price);
    });
    console.log(total);
    this.total=total
  
    return this.total;
  }
}

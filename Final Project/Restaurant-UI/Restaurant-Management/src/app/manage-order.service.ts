import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ManageOrderService {

  constructor(private http:HttpClient) { }


  public createOrder():Observable<any>{
    return this.http.post("http://localhost:8085/services/order","");
  }

  public viewOrderDetails(){
    return this.http.get("http://localhost:8085/order");
  }

  public addOrderDetail(orderDetail):Observable<any>{
    return this.http.post("http://localhost:8082/services/orderDetail",orderDetail);
  }

  public getMenuDetail(id){
    return this.http.get("http://localhost:8085/menu/"+id);
  }

  public savePayment(){
    return this.http.post("http://localhost:8085/payment","");
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ManageOrderService {

  
  private _refreshNeeded$ = new Subject<void>();

  get refreshNeeded$() {
    return this._refreshNeeded$;
  }

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

  // public loadTable(orderId):Observable<any>{
  //   return this.http.get("http://localhost:8085/services/orderDetail/"+orderId);
  // }

  public getAllOrderDetail(){
    return this.http.get("http://localhost:8085/services/orderDetail").pipe(tap(()=>{
      this._refreshNeeded$.next();
    }));
  }

  public deleteOrderDetail(id){
    return this.http.delete("http://localhost:8082/services/orderDetail?id="+id).pipe(tap(()=>{
      this._refreshNeeded$.next();
    }));
  }
}

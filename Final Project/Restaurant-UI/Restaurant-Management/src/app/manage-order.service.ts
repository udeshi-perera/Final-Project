import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ManageOrderService {

  constructor(private http:HttpClient) { }


  public createOrder():Observable<any>{
    return this.http.post("http://localhost:8082/order","");
  }

  public viewOrderDetails(){
    return this.http.get("http://localhost:8082/order");
  }
}

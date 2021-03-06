import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class ManageCustomerService {

  constructor(private http:HttpClient) { }

  public registerCustomer(customer):Observable<any>{
    console.log("this service call");
    return this.http.post("http://localhost:8081/customer",customer,{responseType:'text' as 'json'});
  }

  public viewCustomerByNumber(number){
    return this.http.get("http://localhost:8081/customer/get/"+number);
  }

  public getAllCustomer(){
    return this.http.get("http://localhost:8081/customer/");
  }

  public getCustomerData(id): Observable<Customer>{
    return this.http.get<Customer>("http://localhost:8081/customer/"+id);
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ManageMenuService {

  constructor(private http:HttpClient) { }

  public addMenu(menu):Observable<any>{
    console.log(menu);
    return this.http.post("http://localhost:8080/menu",menu);
  }

  public getAllMenu(){
    return this.http.get("http://localhost:8080/menu-list");
  }

  public viewMenuByCode(code){
    return this.http.get("http://localhost:8080/menu?code="+code);
  }
}

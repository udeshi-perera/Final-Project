import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { tap} from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class ManageMenuService {

  constructor(private http:HttpClient) { }

  private _refreshNeeded$ = new Subject<void>();

  get refreshNeeded$() {
    return this._refreshNeeded$;
  }

  public addMenu(menu):Observable<any>{
    console.log(menu);
    return this.http.post("http://localhost:8080/menu",menu).pipe(tap(()=>{
      this._refreshNeeded$.next();
    }));
  }

  public getAllMenu(){
    return this.http.get("http://localhost:8080/menu/menu-list");
  }

  public viewMenuByCode(code){
    return this.http.get("http://localhost:8085/menu?code="+code);
  }
}

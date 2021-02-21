import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  // headersForApi: any;
  // uname:any;
  // pwd:any;
  // data:any;
  // baseUrl:any;
  //url=" localhost:9191/oauth/token"

  // private baseUrl = 'http://localhost:9191/oauth/token';
  accessToken = '';
  headersForApi = null;
  data = null;
  usrnme = 'mobile';
  pwd = 'pin';

  constructor(private http:HttpClient) { }

  public getToken(userName: string, password: string): Observable<any>{
    this.headersForApi = new HttpHeaders({
   'content-type': 'application/x-www-form-urlencoded',
      'Authorization': 'Basic ' + btoa(this.usrnme + ':' + this.pwd)
     }); 
    this.data = 'grant_type=password&username=' + userName + '&password=' + password;
    console.log(this.data);
   return this.http.post('http://localhost:4200/oauth/token', this.data , { headers: this.headersForApi });
 }

  // public getToken(username: string,password:string){

  //   this.headersForApi = new HttpHeaders({
  //     'content-type':'application/x-www-form-urlencoded',
  //     'Authorization':'Basic'+btoa(this.uname+':'+this.pwd)
  //   });
  //   this.data='grant_type=password&username='+username+'&password='+password;
  //   return this.http.post(this.baseUrl,this.data,{headers: this.headersForApi});
  // }

  // doLogin(credentials:any){
  //   return this.http.post("http://localhost:9191/oauth/token",credentials);
  // }

  // public loginUser(token){
  //   localStorage.setItem("token",token);
  //   return true;
  // }

  // isLoggedIn(){
  //   let token=localStorage.getItem("token");
  //   if(token==undefined || token=='' || token==null){
  //     return false;
  //   }
  //   else{
  //     return true;
  //   }
  // }

  // loggedOut(){
  //   localStorage.removeItem('token');
  //   return true;
  // }

  // getToken(){
  //   return localStorage.getItem("token");
  // }

}

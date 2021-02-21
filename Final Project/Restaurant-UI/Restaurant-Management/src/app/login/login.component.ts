import { Component, OnInit } from '@angular/core';
import { TokenService } from '../token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
    username: string;
    password:string;



  constructor(private service:TokenService) { }

  ngOnInit(): void {
  }

  logIn(){
    this.service.getToken(this.username,this.password).subscribe(data=>{
      console.log(data);
    })

  }
  // onSubmit(){
  //   console.log("submitted");
  //   if((this.credentials.username!='' && this.credentials.password!='')&&(this.credentials.password!=null && this.credentials.username!=null)){

  //   }
  //   else{
  //     console.log("Fileds are empty");
  //   }
  // }

}

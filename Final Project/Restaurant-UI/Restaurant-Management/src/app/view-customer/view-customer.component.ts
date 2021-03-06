import { Component, OnInit } from '@angular/core';
import { ManageCustomerService } from '../manage-customer.service';
import { Router } from '@angular/router'
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
  customers:any;
  mobileNumber:string;
  message:any;
  id:any;
  currentUser: any;

  constructor(private service:ManageCustomerService,private route:Router,private token: TokenStorageService) { }

  ngOnInit(): void {
    this.service.getAllCustomer().subscribe((data)=>this.customers=data);
    this.currentUser = this.token.getUser();
  }

  public findCustomerByNumber(){
    this.service.viewCustomerByNumber(this.mobileNumber).subscribe((data)=>this.customers=data);
    //  let resp=this.service.viewCustomerByNumber(this.mobileNumber);
    //  console.log(this.customers);
    //  resp.subscribe((data)=>this.customers=data),
    //  catchError(error => { return throwError('Its a Trap!')})

  }

  // public viewCustomerById(){
  //   this.service.getCustomerData(this.route.snapshot.params.id).subscribe((result)=>{
  //     console.log(result);
  //   })
  // }


  public editCustomer(customerId: number){
    this.route.navigate(['/update',customerId]);
  }

}

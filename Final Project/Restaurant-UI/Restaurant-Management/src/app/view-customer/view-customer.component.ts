import { Component, OnInit } from '@angular/core';
import { ManageCustomerService } from '../manage-customer.service';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
  customers:any;
  mobileNumber:any;
  constructor(private service:ManageCustomerService) { }

  ngOnInit(): void {
    this.service.getAllCustomer().subscribe((data)=>this.customers=data);
  }

  public findCustomerByNumber(){
    this.service.viewCustomerByNumber(this.mobileNumber).subscribe((data)=>this.customers=data);
  }

}

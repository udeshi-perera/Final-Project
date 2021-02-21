import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Customer } from '../customer';
import { ManageCustomerService } from '../manage-customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  // [x: string]: any;

  customer: Customer = new Customer("", "", "");
  customerName: string;
  mobileNumber: string;
  email: string;
  message: any;
  customerForm: FormGroup;

  constructor(private service: ManageCustomerService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.customerForm = new FormGroup({
      customerName: new FormControl(),
      mobileNumber: new FormControl(),
      email: new FormControl()
    })
    // this.service.getCustomerData(this.route.snapshot.params.id).subscribe((result)=>{
    //   this.editCustomer= new FormGroup({
    //     customerName: new FormControl(result['customerName']),
    //     mobileNumber:new FormControl(result['mobileNumber']),
    //     email: new FormControl(result['email'])
    //   })
    //   console.log(result['mobileNumber']);
    // })

    this.route.paramMap.subscribe(params => {
      const empId = +params.get('id');
      if (empId) {
        this.getEmployee(empId);
      }
    })
  }

  public getEmployee(id: number) {
    this.service.getCustomerData(id).subscribe(
      (customer: Customer) => this.editCus(customer)
    );
  }

  public editCus(customer: Customer) {
    console.log(customer.email);
    this.customerForm.controls.customerName.setValue(customer.customerName);
    this.customerForm.patchValue({
      customerName: customer.customerName,
      mobileNumber: customer.mobileNumber,
      email: customer.email
    });
  }

  public registerCustomer() {
    //console.log(this.customer);
    this.service.registerCustomer(this.customer).subscribe((data: any) => this.message = data);
  }
}

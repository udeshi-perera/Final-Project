export class Customer{

    public customerName:string;
    public email:string;
    public mobileNumber:string;


    constructor( customerName :string , email:string , mobileNumber: string ){
        this.email = email;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
    }
}
export class Payment{

    public id:number;
    public orderId:number;
    public fullPayment:number;

    constructor(id:number, orderId :number,fullPayment:number){
        this.id=id;
        this.orderId = orderId;
        this.fullPayment=fullPayment;
    }
}
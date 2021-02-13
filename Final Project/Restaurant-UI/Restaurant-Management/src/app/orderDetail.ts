export class OrderDetail{

    public status:string;
    public menu:number;
    public orderId:number;
    public quantity:number;
    public price:number;

    constructor( status :string,menu:number,orderId:number,quantity:number,price:number){
        this.status = status;
        this.menu=menu;
        this.orderId=orderId;
        this.quantity=quantity;
        this.price=price;
    }
}
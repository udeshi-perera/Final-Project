export class Order{

    public id:number;
    public orderDateTime:string;

    constructor(id:number, orderDateTime :string){
        this.id=id;
        this.orderDateTime = orderDateTime;
    }
}
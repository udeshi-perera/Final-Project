export class Menu{

    public code:string;
    public itemName:string;
    public foodCategory:string;
    public pricePerItem:number


    constructor( code :string , itemName:string , foodCategory: string, pricePerItem:number ){
        this.code = code;
        this.itemName = itemName;
        this.foodCategory = foodCategory;
        this.pricePerItem=pricePerItem;
    }
}
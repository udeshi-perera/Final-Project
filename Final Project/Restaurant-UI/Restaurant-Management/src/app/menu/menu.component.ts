import { Component, OnInit } from '@angular/core';
import { ManageMenuService } from '../manage-menu.service';
import { Menu } from '../menu';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  menu: Menu=new Menu("","","",0);
  message: any;
  menus:any;
  code:any;
  itemName:string;
  foodCategory:string;
  pricePerItem:number;
  currentUser: any;

  constructor(private service:ManageMenuService,private token: TokenStorageService) { }

  ngOnInit(): void {
    this.service.refreshNeeded$.subscribe(()=>{
      this.service.getAllMenu().subscribe((data)=>this.menus=data);
    })
    this.service.getAllMenu().subscribe((data)=>this.menus=data);
    this.currentUser = this.token.getUser();
  }

  public addMenu(){
    console.log(this.menus);
    this.service.addMenu(this.menu).subscribe((data)=>this.message=data);
  }

  public findMenuByCOde(){
    this.service.viewMenuByCode(this.code).subscribe((data)=>this.menus=data);
  }

  public clearFields(){
    console.log(this.menu);
    this.menu=new Menu("","","",0);
    console.log(this.menu);
  }

}

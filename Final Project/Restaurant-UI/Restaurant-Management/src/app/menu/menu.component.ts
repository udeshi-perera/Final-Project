import { Component, OnInit } from '@angular/core';
import { ManageMenuService } from '../manage-menu.service';
import { Menu } from '../menu';

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

  constructor(private service:ManageMenuService) { }

  ngOnInit(): void {
    this.service.refreshNeeded$.subscribe(()=>{
      this.service.getAllMenu().subscribe((data)=>this.menus=data);
    })
    this.service.getAllMenu().subscribe((data)=>this.menus=data);
  }

  public addMenu(){
    console.log(this.menus);
    this.service.addMenu(this.menu).subscribe((data)=>this.message=data);
  }

  public findMenuByCOde(){
    this.service.viewMenuByCode(this.code).subscribe((data)=>this.menus=data);
  }

}

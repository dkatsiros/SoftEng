import { Component, OnInit } from '@angular/core';
import { HomeComponent } from '../home/home.component';

@Component({
  selector: 'app-nav',
  providers:[HomeComponent],
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(public homeComp: HomeComponent) { }

  ngOnInit() {
  }

  appTitle:string = "eCoffee";
  title1:string =  "Home";
  title2:string =  "Search";
  title3:string =  "About";
  title4:string =  "Login";
  title5:string = "Register";
  title6:string = "Insert";
  title7:string= "Map";

 

}

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  isRegistered: boolean = false;

  setIsRegistered(rg: boolean): void {
    this.isRegistered = rg;
  }

  getIsRegistered(): boolean {
    return this.isRegistered;
  }

  ngOnInit() {
  }

}

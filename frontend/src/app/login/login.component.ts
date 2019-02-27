import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userLogin
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.userLogin = this.formBuilder.group({
      username:['',[Validators.required]],
      password:['',[Validators.required]]

    })
  }

  get f() { return this.userLogin.controls; }
  
  onSubmit(){
    if (this.userLogin.valid){
      console.log(this.f.name);

      alert('User form Valid');
    }
    else{
      console.log(this.f.name);
      alert('User form Invalid');
    }
    
    console.log("Submited");
  }

}

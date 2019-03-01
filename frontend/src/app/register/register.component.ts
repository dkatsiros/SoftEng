import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { JwtService } from '../jwt.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userRegister
  constructor(private formBuilder: FormBuilder, private reg: JwtService) { }

  ngOnInit() {
    this.userRegister = this.formBuilder.group({
      username:['',[Validators.required]],
      name:['',[Validators.required]],
      email:['',[Validators.required]],
      password:['',[Validators.required]]

    })
  }
   // convenience getter for easy access to form fields
  get f() { return this.userRegister.controls; }

  onSubmit(){

    if (this.userRegister.valid){
      console.log(this.f.name);
      this.reg.register(this.f.username,this.f.name,this.f.email,this.f.password);
      alert('User form Validsasas');
    }
    else{
      console.log(this.f.name);
      alert('User form Invalid');
    }

    console.log("Submited");
  }

}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userRegister
  constructor(private formBuilder: FormBuilder) { }

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

      alert('User form Valid');
    }
    else{
      console.log(this.f.name);
      alert('User form Invalid');
    }
    
    console.log("Submited");
  }

}

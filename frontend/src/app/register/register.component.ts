import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userForm
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.userForm = this.formBuilder.group({
      username:['',[Validators.required]],
      name:['',[Validators.required]],
      lastName:['',[Validators.required]],
      email:['',[Validators.required]],
      password:['',[Validators.required]]

    })
  }
    
  // convenience getter for easy access to form fields
  get f() { return this.userForm.controls; }
  
  onSubmit(){
    if (this.userForm.valid){
      
      alert('User form valid');
    }
    else{
      alert('User form invalid');
    }

    console.log("Submited");
  }

}

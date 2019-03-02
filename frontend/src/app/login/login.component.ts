import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute,Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { AlertService, AuthenticationService } from '../services';





@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userLogin: FormGroup;
  loading=false ;
  submitted= false;
  returnUrl:string;

  constructor(private formBuilder: FormBuilder,private root: ActivatedRoute, private rooter: Router, 
  private authenticationService: AuthenticationService, private alertService : AlertService) { }

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

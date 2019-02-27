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
  constructor(private formBuilder: FormBuilder,private http: HttpClient) { }

  ngOnInit() {
    this.userForm = this.formBuilder.group({
      firstName:['',[Validators.required]],
      lastName:['',[Validators.required]],
      email:['',[Validators.required]],
      password:['',[Validators.required]]

    })
  }
  onSubmit(){
    if (this.userForm.valid){
      this.http.post('/api/sign-up',this.userForm.value).subscribe((response)=>{
        console.log('response',response);
      })
      alert('User form valid');
    }
    else{
      alert('User form invalid');
    }

    console.log("Submited");
  }

}

import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from "@angular/router";
import {
  FormControl,
  FormGroup,
  Validators,
} from "@angular/forms";
//import { AuthService } from "src/app/core/service/auth.service";
import { User } from "src/app/core/models/user";
import { Roles } from "src/app/core/models/roles";
//import Swal from "sweetalert2";
import { switchMap } from "rxjs";
import { getAuth, sendEmailVerification } from "firebase/auth";
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  authForm!: FormGroup;
  successMsg = "";

  user: User = {
    username:"",
    user_email: "",
    user_password: "",
    user_role: "",
  };

  users !: User[];
  submitted = false;
  Roles !: Roles;
  hide = true;
  chide = true;
  constructor(
    
    private route: ActivatedRoute,
    //private authService: AuthService,
   
  ) {}
  ngOnInit() {
    this.authForm =new FormGroup({
      username: new FormControl(this.user.username,[Validators.required]) ,
      email: new FormControl(this.user.user_email,[Validators.required, Validators.email, Validators.minLength(5)]),
      role: new FormControl(this.user.role,[Validators.required]),
      password:new FormControl(this.user.user_password,[Validators.required]),
      cpassword: new FormControl(this.user.user_password,[Validators.required]),
    });
    
    
  }
  get f() {
    return this.authForm.controls;
  }
  onSubmit() {
    console.log("submit",this.authForm.value.password);
    
    this.user.username = this.authForm.value.username
    this.user.user_password = this.authForm.value.password;
    this.user.user_email = this.authForm.value.email;
    this.user.user_role = this.authForm.value.role;
  }
}

import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Roles } from 'src/app/core/models/roles';
import { CommonService } from 'src/app/core/service/service.index';
import { User } from "src/app/core/models/user";
//import { AuthService } from 'src/app/core/service/auth.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  
})
export class RegisterComponent implements OnInit {
  name = '';
  mobile = '';
  password = '';
  isPatient: boolean = true;
  doctors: any = [];
  patients: any = [];
  reg_type = 'Patient Register';
  doc_patient = 'Are you a Doctor?';
  value: any;
  authForm!: FormGroup;
  successMsg = "";

  user:User={
    username:"",
    user_email :"",
    user_role:"",
    user_password:""
  }
  users !:User[];
  submitted = false;
  Roles = Roles;
  hide = true;
  chide = true;
  constructor(
    private toastr: ToastrService,
    public commonService: CommonService,
    public router: Router,
    private route: ActivatedRoute,
   //private authService:AuthService,
   
  ) {}

  ngOnInit(): void {
    // this.getpatients();
    // this.getDoctors();
    // if($('.floating').length > 0 ){
    //   $('.floating').on('focus blur',  (e: { type: string; }) => {
    //   $(this).parents('.form-focus').toggleClass('focused', (e.type === 'focus' || this.value.length > 0));
    //   }).trigger('blur');
    // }
    this.authForm =new FormGroup({
      username: new FormControl(this.user.username,[Validators.required]) ,
      email: new FormControl(this.user.user_email,[Validators.required, Validators.email, Validators.minLength(5)]),
      role: new FormControl(this.user.user_role,[Validators.required]),
      password:new FormControl(this.user.user_password,[Validators.required]),
      cpassword: new FormControl(this.user.user_password,[Validators.required]),
    });


  }

  changeRegType() {
    if (this.reg_type === 'Doctor Register') {
      this.reg_type = 'Patient Register';
      this.doc_patient = 'Are you a Doctor?';
      this.isPatient = true;
    } else {
      this.reg_type = 'Doctor Register';
      this.doc_patient = 'Not a Doctor?';
      this.isPatient = false;
    }
  }

  onSubmit() {
   
    
    this.user.username = this.authForm.value.username
    this.user.user_password = this.authForm.value.password;
    this.user.user_email = this.authForm.value.email;
    this.user.user_role = this.authForm.value.role;
    console.log("user submittttt",this.user);
    
    // this.authService.register(this.user).subscribe(data=>{console.log("submit data :",data);
    // })
  }

  // signup() {
  //   if (this.name === '' || this.mobile === '' || this.password === '') {
  //     this.toastr.error('', 'Please enter mandatory field!');
  //   } else {
  //     if (!this.isPatient) {
  //       let params = {
  //         id: this.doctors.length + 1,
  //         doctor_name: this.name,
  //         password: this.password,
  //       };
  //       this.commonService.createDoctor(params).subscribe((res) => {
  //         this.toastr.success('', 'Register successfully!');
  //         this.router.navigate(['/doctor-register-step1']);
  //       });
  //     } else {
  //       let params = {
  //         id: this.patients.length + 1,
  //         name: this.name,
  //         password: this.password,
  //       };
  //       this.commonService.createPatient(params).subscribe((res) => {
  //         this.toastr.success('', 'Register successfully!');
  //         this.router.navigate(['/patient-register-step1']);
  //       });
  //     }
  //   }
  // }

  getDoctors() {
    this.commonService.getDoctors().subscribe((res) => {
      this.doctors = res;
    });
  }

  getpatients() {
    this.commonService.getpatients().subscribe((res) => {
      this.patients = res;
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { CommonService } from 'src/app/core/service/service.index';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  isPatient: boolean = false;
  doctors: any = [];
  patients: any = [];
  username = '';
  password = '';
  value: any;
  constructor(
    public router: Router,
    public commonService: CommonService,
    private toastr: ToastrService
  ) {
    this.username = '';
    this.password = '';
    this.doctors = [];
    this.patients = [];
  }

  ngOnInit(): void {
    this.getpatients();
    this.getDoctors();
    	// Floating Label
	if($('.floating').length > 0 ){
		$('.floating').on('focus blur',  (e:any) => {
		$(this).parents('.form-focus').toggleClass('focused', (e.type === 'focus' || this.value.length > 0));
		}).trigger('blur');
	}
  }

  checkType(event:any) {
    this.isPatient = event.target.checked ? true : false;
  }

  login(name:any, password:any) {
    localStorage.setItem('auth', 'true');
    localStorage.setItem('patient', this.isPatient.toString());
    if (this.isPatient) {
      let filter = this.patients.filter(
        (a:any) => a.name == this.username && a.password === this.password
      );
      if (filter.length != 0) {
        localStorage.setItem('id', filter[0]['id']);
        this.toastr.success('', 'Login success!');
        this.commonService.nextmessage('patientLogin');
        this.router.navigate(['/patients/dashboard']);
      } else {
        this.toastr.error('', 'Login failed!');
      }
    } else {
      let filter = this.doctors.filter(
        (a:any) => a.doctor_name === this.username && a.password === this.password
      );
      if (filter.length != 0) {
        this.toastr.success('', 'Login success!');
        this.commonService.nextmessage('doctorLogin');
        localStorage.setItem('id', filter[0]['id']);
        this.router.navigate(['/doctors/dashboard']);
      } else {
        this.toastr.error('', 'Login failed!');
      }
    }
  }

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

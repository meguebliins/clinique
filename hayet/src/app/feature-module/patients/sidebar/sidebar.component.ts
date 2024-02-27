import { Component, OnInit } from '@angular/core';
import { CommonService } from 'src/app/core/service/service.index';
import { Router } from '@angular/router';
import { Patient } from 'src/app/core/models/patient';
import { PatientService } from 'src/app/core/service/patient.service';
@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  patients!:Patient[]
  patient:Patient={
    name: '',
    id_patient: '',
    key: '',
    age: 0,
    address: '',
    phone: 0,
    email: '',
    lastvisit: new Date,
    paid: '',
    bloodgroup: '',
    type: '',
    img: ''
  }
 id:any
  name: any;
  constructor(
    private router: Router,
    public commonService: CommonService,private patientService:PatientService
  ) {}
  ngOnInit(): void {
    this.getPatient()
  }
  logout() {
    localStorage.clear();
    this.commonService.nextmessage('logout');
    this.router.navigate(['/']);
  }
  navigate(name: any) {
    this.name = name;
    this.commonService.nextmessage(name);
  }
  getPatientBYID(){
    this.id='1'
    this.patientService.getPatientBYID(this.id).subscribe(data=>{this.patient=data;console.log(data);
    })
  }
  getPatient(){
    this.patientService.getPatient().subscribe(data=>{this.patients=data;this.patient=data[0];console.log(this.patient);
    })
  }
}
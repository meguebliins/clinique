import { Component, OnInit } from '@angular/core';
import { CommonService } from 'src/app/core/service/service.index';
import { ActivatedRoute, Router } from '@angular/router';
import { DoctorService } from 'src/app/core/service/doctor.service';
import { Doctor } from 'src/app/core/models/doctor';
import { SpecialitiesService } from 'src/app/core/service/specialities.service';
import { Speciality } from 'src/app/core/models/speciality';
@Component({
  selector: 'app-search-doctor',
  templateUrl: './search-doctor.component.html',
  styleUrls: ['./search-doctor.component.css']
})
export class SearchDoctorComponent implements OnInit {
  spList!:Speciality[]
  doctor!:any
  doctors: any = [];
  specialityList: any = [];
  type: string ='';
  specialist = "";
  Location:string=''
  speciality: string='' ;
  selDate: any;
  items:any;
  spec!:any;
  constructor(public commonService: CommonService, public router: Router, private doctorService:DoctorService,private specialityService:SpecialitiesService, private route:ActivatedRoute) { }
  images = [
    {
      path: 'assets/img/features/feature-01.jpg',
    },
    {
      path: 'assets/img/features/feature-02.jpg',
    },
    {
      path: 'assets/img/features/feature-03.jpg',
    },
    {
      path: 'assets/img/features/feature-04.jpg',
    },
  ];
  ngOnInit(): void {
    
    // this.getDoctors();
    // this.getspeciality();

    this.Location=localStorage.getItem("Location")+"",
    this.type= localStorage.getItem("type")+"",
    this.speciality=localStorage.getItem("speciality")+""
    this.spec=this.route.snapshot.params['params'];

     //this.search()
     this.getDoctorApi()
   // this.getSpecialityApi()
    // this.getDoc()
    
   
    
  }
 
  checkType(event:any) {
    if (event.target.checked) {
      this.type = event.target.value;
    } else {
      this.type = "";
    }
  }
  search() {

    // if (this.type && this.speciality ) {
    //   this.doctors = this.doctors.filter((a: { type: string | undefined; speciality: string | undefined; }) => a.type === this.type && a.speciality === this.speciality)
    // } else {
    //   this.getDoctors();
    // }
 if(this.Location === "undefined"){

  this.Location=''
  
 } if ( this.type === "undefined" ){
  
  this.type=''
  
 } if ( this.speciality === "undefined"){
  this.speciality=''

  
 }

 if(this.spec!=="undefined"){
  this.Location="",
  this.type="",
  this.speciality=this.spec
  
 }
   
console.log('new valeurs ',this.speciality,this.type,this.Location);

   this.doctorService.searchDoctor(this.Location,this.type,this.speciality).subscribe(data=>{this.doctor=data;console.log('init',data);
   })
  }
  checkSpeciality(event:any) {
    if (event.target.checked) {
      this.speciality = event.target.value;
    } else {
      this.speciality = "";
    }
    var filter = this.specialityList.filter((a: { speciality: any; }) => a.speciality === event.target.value);
    if (filter.length != 0) {
      filter[0]['checked'] = true;
    }
    this.specialityList.forEach((index: { [x: string]: boolean; speciality: any; }) => {
      if (index.speciality != event.target.value) {
        index['checked'] = false;
      }
    })
  }
  bookAppointment(id: string) {
    // if((localStorage.getItem('auth') === 'true') && (localStorage.getItem('patient') === 'true')) {
    this.router.navigateByUrl('/patients/booking?id=' + id);
    // } else {
    //   this.router.navigate(['/']);
    // }
  }
sort(){
  // sort by male or female
  // this.doctors.sort((a:any, b:any) => (a.type > b.type ? -1 : 1));
  // console.log( "date filter",this.doctors.filter((x:any)=>x.location.match(this.Location)));
  this.getInput()
  // console.log(this.doctors);
// sort by price
//this.doctors.sort((a:any, b:any) => (a.Price < b.Price ? -1 : 1));
}
getDoctorApi(){
  this.doctorService.getDoctor().subscribe(data=>{this.doctor=data;console.log("dataaaa",data);
  })
}
getSpecialityApi(){
 // this.specialityService.getSpeciality().subscribe(data=>{this.spList=data;console.log(data);
 // })
}
getInput(){
  console.log(this.Location);
  console.log(this.speciality);
  console.log(this.type);
}
setId(id:any){
    localStorage.setItem('id', id)
  }
}
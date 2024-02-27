import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { removeData } from 'jquery';
import { Appointement } from 'src/app/core/models/appointement';
import { Booking } from 'src/app/core/models/booking';
import { AppointementService } from 'src/app/core/service/appointement.service';
import { BookingService } from 'src/app/core/service/booking.service';
import { DoctorService } from 'src/app/core/service/doctor.service';
import { CommonService } from 'src/app/core/service/service.index';
declare var moment: any;
declare const $: any;
@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
  doctorId:any;
  doctorDetails:any;
  userDetails:any;
  data:any={}
  public daterange: any = {};
  slots!:Booking;
  times:number=0;
  allTime:any[]=[];
  pause:any[]=[];
 all:any[]=[];
 status:string[]=[]
 selected:string="timing selected";
 NotSelect:string="timing";
 app:Appointement[]=[];
 stat=["encours","nonvalide"]
 Rdv:Appointement={doctorIdDoctor: '',doctorName: '',speciality: '',amount: 0,appointment_date: "",appointment_time: "",
  status:this.stat[0]}
 test=true
 
 color="#EED393"
  // see original project for full list of options
  // can also be setup using the config service to apply to multiple pickers
  public options: any = {
    locale: { format: 'YYYY-MM-DD' },
    alwaysShowCalendars: false,
  };

  public selectedDate(value: any, datepicker?: any) {
    // any object can be passed to the selected event and it will be passed back here
    datepicker.start = value.start;
    datepicker.end = value.end;
    
    
    // use passed valuable to update state
    this.daterange.start = value.start;
    this.daterange.end = value.end;
    this.daterange.label = value.label;
  }
 now:any;
 noww:string="02 Jan 2023"
 d1:string[]=[];
 days=[{dd:"",day:""}]
alldata={date:this.d1,time:this.all}

  constructor(
    private route: ActivatedRoute,
    public commonService: CommonService,
    private booking:BookingService,
    private doctorService:DoctorService,
    private appointment:AppointementService
  ) {}
  
  

  ngOnInit(): void {

    this.getSlot()
       if($('.bookingrange').length > 0) {
    var start = moment().subtract(6, 'days');
    var end = moment();

    function booking_range(start:any, end:any) {
      $('.bookingrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));

      let debut=new Date(start)
      let fin=new Date(end)
      //console.log(fin);
      

    }

    $('.bookingrange').daterangepicker({
      startDate: start,
      endDate: end,
      ranges:
       {
        'Today':[moment(), moment()],
        'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')] ,
        'Last 7 Days': [moment().subtract(6, 'days'), moment()],
        '30 Days': [moment(), moment().add(30,'days')],
        'This Month': [moment().startOf('month'), moment().endOf('month')],
        'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
      }
      
      
    },
    booking_range);
    
    booking_range(start, end);
    //console.log($('.bookingrange span').data("daterangepicker"));

   for (let l=1;l<8;l++){
    this.days.push({dd:moment().weekday(l).format('DD MMM YYYY'),day: moment().weekday(l).format('ddd')})
    this.d1.push(moment().weekday(l).format('DD MMM YYYY'))
   }
   this.now={dd:moment().format('DD MMM YYYY'),d:moment().format('ddd')}
   }
    if (this.route.snapshot.queryParams['id']) {
      this.doctorId = this.route.snapshot.queryParams['id'];
    } else {
      this.doctorId = 1;
    }
     this.getDoctorsDetails();
    // this.patientDetails();
    
   
  }

  getDoctorsDetails() {
    this.doctorService.getDoctorByID(this.doctorId).subscribe((res) => {
      this.doctorDetails = res;
    // console.log("doctor",this.doctorDetails);
      
    });
  }
  
  // patientDetails() {
  //   let userId;
  //   userId = localStorage.getItem('id');
  //   if (!userId) {
  //     userId = 1;
  //   }
  //   this.commonService.getPatientDetails(Number(userId)).subscribe((res) => {
  //     this.userDetails = res;
  //   });
  //}
  getSlot(){
    //console.log("idddddd",this.doctorId);
    
    this.booking.getSlotById(this.route.snapshot.queryParams['id']).subscribe(data=>{this.slots=data;
 
    
    
      this.times=((moment.utc(this.slots.timefin,"HH:mm").diff(moment(this.slots.timeDebut,"HH:mm"),'hours'))-1)  
     
      let all1=moment(this.times)._i/moment(this.slots.duree,'HH:mm')    
      let j=0
      let l 
      let time2
      this.allTime.push(this.slots.timeDebut)

      for (let i=0;i<this.times;i++){
        let d= moment.duration(this.slots.duree).asMinutes()
        let result = Number(Math.trunc(d/60))
        if(result>=1 && d%60>1 ){
          let time2 = moment.utc(this.slots.timeDebut,"HH:mm").add(moment(result,'h').format('H'),'h').format("HH:mm");   
          time2 = moment.utc(this.slots.timeDebut,"HH:mm").add(moment(result,'h').format('H'),'h').add(d%60, "minutes").format("HH:mm")
           this.allTime.push(time2)
           this.slots.timeDebut =time2
        }
        else if(result === 0 && d%60>1){
          time2 = moment.utc(this.slots.timeDebut,"HH:mm").add(d%60, "minutes").format("HH:mm");
          this.allTime.push(time2)
          this.slots.timeDebut =time2
        }
        if(result>=1 && d%60 === 0 ) {
          let time2 = moment.utc(this.slots.timeDebut,"HH:mm").add(moment(result,'h').format('H'),'h').format("HH:mm");   
           this.allTime.push(time2)
           this.slots.timeDebut =time2
        }
      }
     //console.log("alllllll time",this.allTime);
    // this.alldata={date:this.d1,time:this.all}
    
      let debut =moment.utc(this.slots.timePauseDebut,"HH:mm");
      let fin = moment.utc(this.slots.timePauseFin,"HH:mm")
      // var durationH = moment(fin.diff(debut,'HH:mm')).format("HH:mm");
      var durationH = moment.duration(moment(fin, 'HH:mm').diff(moment(debut, 'HH:mm'))).asMinutes()
      this.pause.push(debut.format("HH:mm"))
      if(debut !== fin){
        let elem=moment.utc(debut,"HH:mm").add(moment.duration(this.slots.duree).asMinutes(), "minutes").format("HH:mm")
        //console.log('el pause',elem);
        this.pause.push(elem)
      }
      //console.log("pause",this.pause);
      
     // console.log("duration",durationH);
    
      
      let i=0;    
      //console.log(moment(moment(fin, 'HH:mm').diff(moment(debut, 'HH:mm'))));
      let el = this.allTime.filter(x=>!this.pause.includes(x))
    //console.log('elll',el);
       this.all=el
    console.log("allll",this.all); 
     
      this.alldata={date:this.d1,time:this.all}
  });
 
  }



   i=0;
   d="";
   t="";
   ;
  createRdv(date:any,time:any){
    
    console.log("time eli tektab ",moment(time,'HH:mm').format("HH:mm"));
    console.log("time now ",moment().format("HH:mm")); 
    this.i++
   let  testnow = (moment(date).format("DD/MM/YYYY"))===moment().format("DD/MM/YYYY")
    let test=(moment(date).format("DD/MM/YYYY"))>=moment().format("DD/MM/YYYY");
    let time1=(moment(time,'HH:mm').format("HH:mm"))>=moment().format("HH:mm")
    console.log("date",test);
    console.log("time",time1);
     if(this.i===1 && test === true && time1 === true){
     this.d=date;
     this.t=time
      console.log('create RDV');
      this.Rdv={doctorIdDoctor: this.doctorId ,doctorName:this.doctorDetails.doctor_name,speciality: '',amount: 0,appointment_date: this.d,appointment_time: this.t,
      status:this.stat[1]}
      console.log("les donne de rdv",this.Rdv);
       //this.color="encours";
     }else if ( date === this.d && time === this.t && test === true && time1 === true  ){
       console.log("delete RDV");
       this.i=0
       this.Rdv={doctorIdDoctor: '',doctorName: '',speciality: '',amount: 0,appointment_date: "",appointment_time: "",
      status: this.stat[0]}
      console.log("les donne de rdv",this.Rdv);
      //this.color="#EFF2F4";
      //this.test=false
     }
     
     else if (  time1 === false && test === false){
      //console.log('vouz avez deja cree un  RDV');
      console.log('date ou heure deja passe');
      this.color="#EFF2F4"
      this.test=false  
     }
     
     else if( test === true && time1 === true){
        console.log('date ou heure deja passe');
        this.color="#EFF2F4";
        this.test=false
        this.i=0
     }
     else if (test === false) {
      console.log('date deja passe ');
      this.Rdv={doctorIdDoctor: '',doctorName: '',speciality: '',amount: 0,appointment_date: "",appointment_time: "",
      status: this.stat[0]}
      this.i=0
     }
     else if (test === true  ) {
      console.log('heure deja passe ');
      this.Rdv={doctorIdDoctor: '',doctorName: '',speciality: '',amount: 0,appointment_date: "",appointment_time: "",
      status: this.stat[0]}
      this.i=0
     }
     else if (  this.i===2 && time1 === false && test === true){
      console.log('vouz avez deja cree un  RDV');
     // console.log('date ou heure deja passe');
      this.color="#EFF2F4"
      this.test=false
       
     }
     else if (test === true){
      console.log("RDV created");

     }
 
    
  }
  verif(){
    // this.appointment.getAppointement(this.doctorId).subscribe(data=>{this.app=data,console.log("appoi",this.app);
    // })
    this.appointment.createAppointment(this.Rdv).subscribe(data=>{console.log("create",data);
    })

  }
  

}

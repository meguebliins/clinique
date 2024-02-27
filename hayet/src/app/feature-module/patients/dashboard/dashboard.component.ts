import { Component, OnInit } from '@angular/core';
import {
  ChartComponent,
  ApexAxisChartSeries,
  ApexChart,
  ApexXAxis,
  ApexDataLabels,
  ApexStroke,
  ApexMarkers,
  ApexYAxis,
  ApexGrid,
  ApexTitleSubtitle,
  ApexLegend,
  ApexFill,
  ApexTooltip,
  ApexTheme,
  ApexPlotOptions
} from "ng-apexcharts";
import * as ApexCharts from 'apexcharts';
import { PatientService } from 'src/app/core/service/patient.service';
import { Patient } from 'src/app/core/models/patient';
import { Measure } from 'src/app/core/models/measure';
import { AppointementService } from 'src/app/core/service/appointement.service';
import { Appointement } from 'src/app/core/models/appointement';
export type ChartOptions = {
  series: ApexAxisChartSeries | any;
  chart: ApexChart | any;
  xaxis: ApexXAxis | any;
  stroke: ApexStroke | any;
  dataLabels: ApexDataLabels | any;
  colors: string[] | any;
  grid: ApexGrid | any;
  title: ApexTitleSubtitle | any;
};
export type chartOptionsheartrate = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  xaxis: ApexXAxis;
  stroke: ApexStroke;
  markers: ApexMarkers;
  yaxis: ApexYAxis;
  fill: ApexFill;
  title: ApexTitleSubtitle;
}
export type chartOptionsfbc = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  dataLabels: ApexDataLabels;
  plotOptions: ApexPlotOptions;
  yaxis: ApexYAxis;
  xaxis: ApexXAxis;
  title: ApexTitleSubtitle;
}
export type chartOptionsweight = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  dataLabels: ApexDataLabels;
  markers: ApexMarkers;
  stroke: ApexStroke;
  title: ApexTitleSubtitle;
}
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  mesure:Measure={
    id_mesures: '',
    Heart_Rate: 0,
    Body_Temperature: 0,
    Glucose_Level: 0,
    Blood_Pressure: 0,
    date: 0,
    patientIdPatient: ''
  }
  patients!:Patient[]
  patient:Patient={
   id_patient: '',
   key: '',
   name: '',
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
 appointement!:Appointement[]
idApp:any
  public bmichartOptions: ChartOptions = {
    series: [
      {
        name: "Desktops",
        data: [10, 41, 35, 51, 49, 62, 69, 91, 148]
      }
    ],
    chart: {
      height: 350,
      type: "line",
      zoom: {
        enabled: false
      }
    },
    dataLabels: {
      enabled: false
    },
    stroke: {
      curve: "straight"
    },
    title: {
      text: "Product Trends by Month",
      align: "left"
    },
    grid: {
      row: {
        colors: ["#f3f3f3", "transparent"],
        opacity: 0.5
      }
    },
    xaxis: {
      categories: [
        "Jan",
        "Feb",
        "Mar",
        "Apr",
        "May",
        "Jun",
        "Jul",
        "Aug",
        "Sep"
      ]
    },
    colors: ['#03a4fb']
  };
  public chartOptionsheartrate: chartOptionsheartrate = {
    series: [{
      name: 'HeartRate',
      data: [4, 3, 10, 9, 29, 19, 22, 9, 12, 7, 19, 5, 13, 9, 17, 2, 7, 5]
    }],
    chart: {
      height: 350,
      type: 'line',
    },
    stroke: {
      width: 7,
      curve: 'smooth'
    },
    xaxis: {
      type: 'datetime',
      categories: ['1/11/2000', '2/11/2000', '3/11/2000', '4/11/2000', '5/11/2000', '6/11/2000', '7/11/2000', '8/11/2000', '9/11/2000', '10/11/2000', '11/11/2000', '12/11/2000', '1/11/2001', '2/11/2001', '3/11/2001', '4/11/2001', '5/11/2001', '6/11/2001'],
      tickAmount: 10,
    },
    title: {
      align: 'left',
    },
    fill: {
      type: 'gradient',
      gradient: {
        shade: 'dark',
        gradientToColors: ['#0de0fe'],
        shadeIntensity: 1,
        type: 'horizontal',
        opacityFrom: 1,
        opacityTo: 1,
        stops: [0, 100, 100, 100]
      },
    },
    markers: {
      size: 4,
      colors: ["#15558d"],
      strokeColors: "#fff",
      strokeWidth: 2,
      hover: {
        size: 7,
      }
    },
    yaxis: {
      min: -10,
      max: 40,
      title: {},
    },

  };
  public chartOptionsfbc: chartOptionsfbc = {
    series: [{
      name: 'FBC',
      data: [2.3, 3.1, 4.0, 10.1, 4.0, 3.6, 3.2, 2.3, 1.4, 0.8, 0.5, 0.2]
    }],
    chart: {
      height: 350,
      type: 'bar',
    },
    plotOptions: {
      bar: {
        borderRadius: 10,
        dataLabels: {
          position: 'top', // top, center, bottom
        },
      }
    },
    dataLabels: {
      enabled: true,
      formatter: function (val) {
        return val + "%";
      },
      offsetY: -20,
      style: {
        fontSize: '12px',
        colors: ["#304758"]
      }
    },

    xaxis: {
      categories: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
      position: 'top',
      axisBorder: {
        show: false
      },
      axisTicks: {
        show: false
      },
      crosshairs: {
        fill: {
          type: 'gradient',
          gradient: {
            colorFrom: '#0de0fe',
            colorTo: '#0de0fe',
            stops: [0, 100],
            opacityFrom: 0.4,
            opacityTo: 0.5,
          }
        }
      },
      tooltip: {
        enabled: true,
      }
    },
    yaxis: {
      axisBorder: {
        show: false
      },
      axisTicks: {
        show: false,
      },
      labels: {
        show: false,
        formatter: function (val) {
          return val + "%";
        }
      }
    },
    title: {
      floating: true,
      offsetY: 330,
      align: 'center',
      style: {
        color: '#444'
      }
    },
  };
  public chartOptionsweight: chartOptionsweight = {
    series: [{
      name: 'Weight',
      data: [34, 44, 54, 21, 12, 43, 33, 23, 66, 66, 58]
    }],
    chart: {
      type: 'line',
      height: 350
    },
    stroke: {
      curve: 'stepline',
    },
    dataLabels: {
      enabled: false
    },
    title: {
      align: 'left'
    },
    markers: {
      hover: {
        sizeOffset: 4
      }
    }
  };
  id: any;
  constructor(private patientService:PatientService,private appointementService:AppointementService) { }

  ngOnInit(): void {
    this.getMesure()
    this.getAppointement()
    var chart = new ApexCharts(document.querySelector('#bmi-status'),
      this.bmichartOptions
      );
    chart.render();
    var heartratechart = new ApexCharts(document.querySelector('#heartrate-status'),
      this.chartOptionsheartrate
    );
    heartratechart.render();
    var fbcchart = new ApexCharts(document.querySelector('#fbc-status'),
      this.chartOptionsfbc
    );
    fbcchart.render();
    var weightchart = new ApexCharts(document.querySelector('#weight-status'),
      this.chartOptionsweight
    );
    weightchart.render();
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
getMesure(){
  this.patientService.getMesure().subscribe(data=>{
    this.mesure=data[0];console.log('mesure',this.mesure);
    
  })
}
getAppointement(){
  this.idApp='1'
  this.appointementService.getAppointement(this.idApp).subscribe(data=>{this.appointement=data;console.log(data);
  })
}
}
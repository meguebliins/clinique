import { HttpClient,HttpParams, } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Doctor } from '../models/doctor';
import {InMemoryDbService, RequestInfo} from 'angular-in-memory-web-api'
@Injectable({
  providedIn: 'root'
})
export class DoctorService {
private API_URL= environment.apiNode;
  constructor(private http:HttpClient) { }
  createDb(reqInfo?: RequestInfo | undefined): {} | Observable<{}> | Promise<{}> {
    throw new Error('Method not implemented.');
  }
  getDoctor():Observable<any>{
    return this.http.get<any>(`${this.API_URL}/doctor/all`);
  }
  getDoctorByID(id:string):Observable<Doctor>{
    console.log(id);
    return this.http.get<Doctor>(`${this.API_URL}/doctor/${id}`)
  }
  searchDoctor(location:string,gendre:string,specialite:any):Observable<Doctor[]>{
    console.log(gendre);
     return this.http.get<Doctor[]>(`${this.API_URL}/doctor?location=${location}&&gendre=${gendre}&&specialite=${specialite}`)
   }
}
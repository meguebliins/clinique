import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Appointement } from '../models/appointement';
@Injectable({
  providedIn: 'root'
})
export class AppointementService {
 API_URL= environment.apiNode;
  constructor(private http:HttpClient) { }
  getAppointement(id:string):Observable<Appointement[]>{
     return this.http.get<Appointement[]>(`${this.API_URL}/appointment/stat/${id}`)
  }
  getAppointementByIdDoctor(id:string):Observable<Appointement[]>{
      return this.http.get<Appointement[]>(`${this.API_URL}/appointment/doctor/${id}`)
  }
  createAppointment(data:Appointement):Observable<String>{
     return this.http.post<string>(`${this.API_URL}/appointment/add`,data)
   }
  UpdateAppointment(id :string,state:string){
    return this.http.patch<string>(`${this.API_URL}/appointment/${id}`,state)
   }
}
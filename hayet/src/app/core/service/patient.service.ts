import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Measure } from '../models/measure';
import { Patient } from '../models/patient';
@Injectable({
  providedIn: 'root'
})
export class PatientService {
 API_URL= environment.apiNode;
  constructor(private http:HttpClient) { }
  getPatient():Observable<Patient[]>{
return this.http.get<Patient[]>(`${this.API_URL}/patient`)
  }
  getPatientBYID(id:string):Observable<Patient>{
    return this.http.get<Patient>(`${this.API_URL}/patient/${id}`)
  }
  getMesure():Observable<Measure[]>{
   return this.http.get<Measure[]>(`${this.API_URL}/mesure`)
  }
}
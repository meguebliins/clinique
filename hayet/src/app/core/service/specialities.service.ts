import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Speciality } from '../models/speciality';

@Injectable({
  providedIn: 'root'
})
export class SpecialitiesService {
  private API_URL= environment.apiNode;
  constructor(private httpClient: HttpClient) {}
  getSpeciality():Observable<Speciality[]>{
    return this.httpClient.get<Speciality[]>(this.API_URL+'/speciality')
  }
}
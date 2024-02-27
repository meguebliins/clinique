import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Booking } from '../models/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
  private API_URL= environment.apiNode;
  constructor(private httpClinet:HttpClient) { }
 getSlot():Observable<Booking[]>{
 return this.httpClinet.get<Booking[]>(`${this.API_URL}/slot`)
 }
 getSlotById(id:string):Observable<Booking>{
  console.log("id",id);
  
  return this.httpClinet.get<Booking>(`${this.API_URL}/slot/doctor/${id}`)
  }

}

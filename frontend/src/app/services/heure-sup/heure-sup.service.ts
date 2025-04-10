import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HeureSup } from '../../models/HeureSup';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HeureSupService {

  constructor(private http:HttpClient) { }

  apiUrl:string="http://localhost:8082/heure-sup";

  saveHeureSup(hs:HeureSup):Observable<HeureSup>{
    return this.http.post<HeureSup>(this.apiUrl+"/add-heure-sup",hs);
  }

  getAllHeureSup():Observable<HeureSup[]>{
    return this.http.get<HeureSup[]>(this.apiUrl+"/get-all-heure-sup");
  }

  updateHeureSup(id:number,hs:HeureSup):Observable<HeureSup>{
    return this.http.put<HeureSup>(this.apiUrl+"/update-heure-sup/"+id,hs);
  }

  deleteHeureSup(id:number):Observable<HeureSup>{
    return this.http.delete<HeureSup>(this.apiUrl+"/update-heure-sup/"+id);
  }

  getHeureSup(id:number):Observable<HeureSup>{
    return this.http.get<HeureSup>(this.apiUrl+"/get-heure-sup/"+id)
  }
}

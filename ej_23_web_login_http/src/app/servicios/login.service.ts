import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ValidacionService {

 
  constructor(private _httpClient : HttpClient) {

   }

//Valida el usuario mediante la peticion GET, hace peticion al localhost
   public login(usuario:String,password:String):Observable<any>{
    return this._httpClient.get<any>(`http://localhost:8080/usuarios/usuarios/login?nombre=${usuario}&password=${password}`) 
  }

}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../usuario';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class MainLoginComponent {
  
  //Informacion del usuario
  users : Array<Usuario> = []
  mapUserPswd : Map<string,string> = new Map<string,string>()
  mail : string = ""
  password :  string = ""
 

  //Mensaje de error
  errorMessage: string = '';
  
  constructor(private router:Router, private _httpClient : HttpClient) { //Conjunto de usuarios
    let u1 = new Usuario("a","a")
    let u2 = new Usuario("felix","depablo")
    let u3 = new Usuario("andres","contrasenia")
    this.users.push(u1)
    this.mapUserPswd.set(u1.getMail(),u1.getPassword())
    this.users.push(u2)
    this.mapUserPswd.set(u2.getMail(),u2.getPassword())
    this.users.push(u3)
    this.mapUserPswd.set(u3.getMail(),u3.getPassword())
  }


//Establece conexion con localhost y compara los strings
  async login(){ //Las peticiones deben ser asincronas
    await fetch(`http://localhost:8080/usuarios/usuarios/login?nombre=${this.mail}&password=${this.password}`,{mode: 'cors'}) .then(v => v.json()).then(v => { //peticionHTTP
      if(JSON.parse(v.validado)){ 
        let usuario;
        for(let u in this.users){
            if(this.users[u].getMail() === this.mail && this.users[u].getPassword() === this.password ) usuario = this.users[u]
            this.router.navigate(["/index",usuario?.getMail()])
          }
        this.errorMessage="El usuario no existe o la contraseña es incorrecta";
      }
    });
  
  }

}

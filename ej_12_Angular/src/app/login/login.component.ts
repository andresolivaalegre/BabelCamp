import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../usuario';

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
  
  constructor(private router:Router) { //Bateria de usuarios
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
  
  
  public login(){
        
        if(!this.mapUserPswd.has(this.mail)){
            this.errorMessage="El usuario no existe"
        }
        else{
          if(this.mapUserPswd.get(this.mail)!=this.password){
            this.errorMessage="Contraseña incorrecta"
          }

          else{
            let user = null;
            for(let x in this.users){
                if(this.users[x].getMail() == this.mail && this.users[x].getPassword() == this.password ) user =  this.users[x]
            }
            this.router.navigate(["/index",user?.getMail()])
          }

        }
  }
  

}

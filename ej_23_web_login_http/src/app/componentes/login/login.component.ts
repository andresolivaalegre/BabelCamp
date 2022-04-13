import { Component} from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../../entidades/usuario';
import { ValidacionService } from '../../servicios/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {
  
  //Informacion del usuario
  users : Array<Usuario> = []
  mapUserPswd : Map<string,string> = new Map<string,string>()
  mail : string = ""
  password :  string = ""
  errorMessage: string = '';
  
  constructor(private router:Router, private servicioLogin: ValidacionService) { //Conjunto de usuarios

  }


//Establece conexion con localhost y compara los strings
public login() {
  this.servicioLogin.login(this.mail, this.password).subscribe((respuesta) => { //Se envia la respuesta en JSON
      if (respuesta.validado) {
        let user = null;
        for (let x in this.users) {
          if (this.users[x].getMail() === this.mail && this.users[x].getPassword() === this.password)
            user = this.users[x]; //Si coinciden nombre y contrasenia entra
        }
        this.router.navigate(['/index',user?.getMail()]);
      }
      else if (!this.mapUserPswd.has(this.mail)) { //Si no existe nombre, no entra y da mensaje
        this.errorMessage =
          'El usuario introducido no existe';
      }
      else {
        if (this.mapUserPswd.get(this.mail) != this.password) { //Si contrasenia incorrecta tampoco entra
          this.errorMessage = 'La contraseña no es correcta';
        }
      }
    });
}

}

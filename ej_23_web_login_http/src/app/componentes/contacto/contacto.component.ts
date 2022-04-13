import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-detalles',
  templateUrl: './contacto.component.html',
  styleUrls: ['./contacto.component.css'],
})

export class ContactoComponent {
  
  

  //En estas variables guardaremos los datos recibidos(del juego y usuario)
  userEmail: string =""
  

  constructor(route:ActivatedRoute, private router:Router) { //Declaramos para recoger y enviar datos
    //Recogemos los datos de usuario
    this.userEmail = route.snapshot.params["mail"]

  }
  public inicio(){
    this.router.navigate(["/index",this.userEmail])
  }


  public sobreNosotros(){
    this.router.navigate(["/nosotros",this.userEmail])
  }

}

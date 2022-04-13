import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-detalles',
  templateUrl: './detalles.component.html',
  styleUrls: ['./detalles.component.css'],
})

export class DetallesComponent {
  
  

  //En estas variables guardaremos los datos recibidos(del juego y usuario)
  id = ""
  titulo = ""
  compania = ""
  vMedia = ""
  urlImgGame = ""
  userEmail: string =""
  

  constructor(route:ActivatedRoute, private router:Router) { //Declaramos para recoger y enviar datos
    //Recogemos los datos de usuario
    this.userEmail = route.snapshot.params["mail"]

    //Recogemos datos del juego
    this.id = route.snapshot.params["id"]
    this.titulo=route.snapshot.params["titulo"]
    this.vMedia=route.snapshot.params["vMedia"]
    this.compania = route.snapshot.params["compania"]
    this.urlImgGame = route.snapshot.params["urlImgGame"]
  }
  public inicio(){
    this.router.navigate(["/index",this.userEmail])
  }

  public sobreNosotros(){
    this.router.navigate(["/nosotros", this.userEmail])
  }

  public contacto(){
    this.router.navigate(["/index",this.userEmail])
  }

}

import { Component, OnInit } from '@angular/core';
import { Game } from 'src/app/game';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent {
  
  public games: Array<Game> = []; //Aqui meteremos los juegos

  //Atributos de los juegos
  id: string = '';
  titulo: string = '';
  compania: string = '';
  vMedia: string = '';
  urlImgGame: string=""

  mail: string =""

  

  constructor(route:ActivatedRoute, private router:Router) { //Declaramos para recoger y enviar datos
    //Bateria de juegos
    let game = new Game("FIFA 22","EA Sports", 9.8,1,"../../assets/img/fifa.PNG")
    let game2 = new Game("NBA2K22","EA Sports", 7.5, 2,"../../assets/img/nba.PNG")
    let game3 = new Game("Brawl Stars","Supercell", 9.2, 3,"../../assets/img/brawl.PNG")
    let game4 = new Game("Clash Royale","Supercell", 8, 4,"../../assets/img/clash.PNG")
    this.games.push(game,game2,game3,game4)

    //Recogemos los datos de usuario
    this.mail = route.snapshot.params["mail"]
  }

  public getGames(): Array<Game> {  //Conseguimos los juegos  creados
    return this.games;
  }

  public select(game: Game) { //Enviamos el juego para mostrar los detalles
    this.router.navigate(["/detalles",game.getId(),game.getTitulo(),game.getCompania(),game.getValoracionMedia(),game.getUrlImg(),this.mail])
  }
  
}

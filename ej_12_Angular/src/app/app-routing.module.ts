import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainLoginComponent } from './login/login.component';
import { MainComponent } from './main/main.component';
import { DetallesComponent } from './detalles/detalles.component';
import { NosotrosComponent } from './nosotros/nosotros.component';
import { ContactoComponent } from './contacto/contacto.component';

const routes: Routes = [
  {
    path : '', //Componente base
    component : MainLoginComponent
  },
  {
    path : 'index/:mail', //ira a la pagina general de juegos
    component : MainComponent
  },
  {
    path : 'nosotros/:mail', //ira a la pagina sobre nosotros
    component : NosotrosComponent
  },

  {
    path : 'contacto/:mail', //ira a la pagina sobre nosotros
    component : ContactoComponent
  },
  
  {
    path : 'detalles/:id/:titulo/:compania/:vMedia/:urlImgGame/:mail', //enviara los datos del juego y usuario
    component : DetallesComponent
  },


 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

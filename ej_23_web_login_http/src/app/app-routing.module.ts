import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './componentes/login/login.component';
import { MainComponent } from './componentes/main/main.component';
import { DetallesComponent } from './componentes/detalles/detalles.component';
import { NosotrosComponent } from './componentes/nosotros/nosotros.component';
import { ContactoComponent } from './componentes/contacto/contacto.component';

const routes: Routes = [
  {
    path : '', //Componente base
    component : LoginComponent
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
    path : 'detalles/:id/:titulo/:compania/:vMedia/:urlImgGame/:mail', //enviara los datos del juego y  al componente detalles
    component : DetallesComponent
  },


 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

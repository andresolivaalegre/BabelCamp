package entidad;

import entidad.armas.Espada;
import entidad.armas.Hechizo;
import entidad.personajes.Curandero;
import entidad.personajes.Guerrero;
import entidad.personajes.Mago;
import entidad.personajes.Personaje;

public class Combate {

	Personaje p1 = new Guerrero("Cid");
	Personaje p2 = new Mago("Pop");
	Hechizo h = new Hechizo();
	Espada e = new Espada();
	
	public void combatir() {
		p1.cogerArma(e);
		p2.cogerArma(h);
		
    
	 System.out.println("DAMAAAAAAAS Y CABALLEROOOOOS, COMIENZA EL COMBATE DEL SIGLO");
	 System.out.println("Hoy se enfrentaran " + p1.getNombre()+ " y "+ p2.getNombre());
	 System.out.println("_________________________________________________________________");
	 
	 while(!p1.estaMuerto() && !p2.estaMuerto()) {
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("Informe de la situacion:");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println(p1.getNombre() + " va a atacar a " + p2.getNombre());
		ataque(p1, p2);
		if(!p2.estaMuerto()) {
		System.out.println(p2.getNombre() + " va a atacar a " + p1.getNombre());
		ataque(p2, p1);
		}
	 }
	 
	 if(p1.estaMuerto()) {
		 System.out.println(p1.getNombre() + " esta muerto");
	 	 System.out.println(p2.getNombre() + "(exhausto): No me ganas crack");
	 }
	 else {System.out.println(p2.getNombre() + " esta muerto");
	 	   System.out.println(p1.getNombre() + "(sangrando): Ni me has tocado");}
	 
	    System.out.println("_________________________________________________________________");
	    System.out.println("Ha sido un combate muy disputado entre " + p1.getNombre()+ " y "+ p2.getNombre());
	    System.out.println("FIN DE LA RETRANSMISION");
	    
		 
		
	}
	
	
	
	public void ataque(Personaje p1, Personaje p2) {
		p2.recibirDanio(p1.atacar());
	}
	
	
	
}

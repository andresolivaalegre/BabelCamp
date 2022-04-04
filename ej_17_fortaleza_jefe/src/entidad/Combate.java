package entidad;

import entidad.armas.Arco;
import entidad.armas.Arma;
import entidad.armas.Espada;
import entidad.armas.Hechizo;
import entidad.armas.PaloCelestial;
import entidad.armas.Puños;
import entidad.armas.Rezos;
import entidad.personajes.Curandero;
import entidad.personajes.Guerrero;
import entidad.personajes.Jefe;
import entidad.personajes.Mago;
import entidad.personajes.Personaje;

public class Combate {
	
	public Combate(Personaje j) {
		this.p1=j;
	}

	Personaje p1;
	Personaje p2;
	PaloCelestial p = new PaloCelestial();
	Arma a;
	
	
	
	public boolean combatir() {
		int n= (int) (Math.random() * (3 - 1) + 1);
		if(n==1)
			p2= new Guerrero("Aspirante Guerrero");
		else if (n==2)
			p2= new Mago("Aspirante Mago");
		else 
			p2= new Curandero("Aspirante Curandero");

		n= (int) (Math.random() * (5 - 1) + 1);
		if(n==1)
			a = new Espada();
		else if (n==2)
			a= new Hechizo();
		else if (n==3)
			a= new Arco();
		else if (n==4)
			a= new Rezos();
		else 
			a= new Puños();

		p1.cogerArma(p);
		p2.cogerArma(a);
		
    
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
	 
	    System.out.println("_________________________________________________________________________________________________________________");
	    System.out.println("Ha sido un combate muy disputado entre " + p1.getNombre()+ " y "+ p2.getNombre());
	    System.out.println("FIN DE LA RETRANSMISION");
	    if(p1.estaMuerto())
	    	return true;
	    else
	    	return false;
	    
		 
		
	}
	
	
	
	public void ataque(Personaje p1, Personaje p2) {
		p2.recibirDanio(p1.atacar());
	}
	
	
	
}

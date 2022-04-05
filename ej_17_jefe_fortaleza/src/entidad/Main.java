package entidad;

import entidad.personajes.Jefe;
import entidad.personajes.Personaje;

public class Main {

	public static void main(String[] args) throws InterruptedException{
		
		Fortaleza f1 = new Fortaleza();	
		boolean estaMuerto = false;
		Thread t1 = new Thread(f1);
		Thread t2 = new Thread(f1);
		Thread t3 = new Thread(f1);
		Thread t4 = new Thread(f1);
		Thread t5 = new Thread(f1);
		Thread t6 = new Thread(f1);
		
		
		t1.start();
		if(estaMuerto || f1.jefeMuerto())
			estaMuerto=true;
		else
			t2.start();
		if(estaMuerto || f1.jefeMuerto())
			estaMuerto=true;
		else
			t3.start();
		if(estaMuerto || f1.jefeMuerto())
			estaMuerto=true;
		else
			t4.start();
		if(estaMuerto || f1.jefeMuerto())
			estaMuerto=true;
		else
			t5.start();
		if(estaMuerto || f1.jefeMuerto())
			estaMuerto=true;
		else
			t6.start();
		Thread.sleep(200);
		if(estaMuerto || f1.jefeMuerto())
			System.out.println("Tenemos un heroe, por fin alguien derrota al jefe final");
		else
			System.out.println("Nadie ha conseguido derrotar al jefe!");
	}
}



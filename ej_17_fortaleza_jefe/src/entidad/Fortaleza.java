package entidad;

import entidad.personajes.Jefe;
import entidad.personajes.Personaje;

public class Fortaleza extends Thread{
	
	Personaje jefe = new Jefe("Superboss");
	
    public Fortaleza() {	
   
	}
	
	
	public boolean jefeMuerto() {
		if(this.jefe.getVida()<=0)
			return true;
		return false;	
	}
	
	
	public void entrar(Personaje jefe) {
		this.jefe.setVida(3500);
		Combate c = new Combate(jefe);
		c.combatir();
	}
	
	public synchronized void run() {
		entrar(jefe);
	}
	
	
	

}

package entidad.personajes;
import entidad.armas.*;

public class Curandero extends Personaje {
	
	private String nombre;
	private Arma arma;
	private int vida;
	private int sabiduria;

	public Curandero(String nombre) {
		this.nombre=nombre;
		this.arma= new Puños();
		this.vida=1000;
		this.sabiduria=150;
	}
	
	@Override
	public String toString() {
		return "Curandero [nombre=" + nombre + ", arma=" + arma.getNombre() + ", vida=" + vida + ", sabiduria=" + sabiduria + "]";
	}

	public boolean estaMuerto() {
		if(this.vida<=0) {
			return true;
		}
		return false;
	}
	
	public void recibirDanio(int danio){
		this.vida-=danio;
		estaMuerto();
	}
	
	public int calcularDanio() {
		if(estaMuerto())
			return 0;
		if(this.arma instanceof Rezos)
			return arma.getDanio()+sabiduria;
		return arma.getDanio();
	}
	
	public int atacar() {
		if(!estaMuerto()) {
		System.out.println("Miuau!!!");
		System.out.println("Soy " + this.nombre + " y no te voy a curar precisamente con mi " + arma.getNombre());
		arma.usar();
		}
		return calcularDanio();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Arma getArma() {
		return arma;
	}

	public void cogerArma(Arma arma) {
		this.arma = arma;
	}
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getSabiduria() {
		return sabiduria;
	}

	public void setSabiduria(int sabiduria) {
		this.sabiduria = sabiduria;
	}

	

}
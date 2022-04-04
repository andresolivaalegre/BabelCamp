package entidad.personajes;
import entidad.armas.Arma;

public abstract class Personaje {

	public abstract boolean estaMuerto();
	public abstract String getNombre();
	public abstract void recibirDanio(int danio);
	public abstract int atacar();
	public abstract void cogerArma(Arma arma);
	public abstract String toString();
	
}

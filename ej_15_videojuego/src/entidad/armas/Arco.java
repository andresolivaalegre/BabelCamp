package entidad.armas;

public class Arco extends Arma{
	
	private int danio=30;
    private String nombre = "arco";
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void usar() {
		System.out.println("Fiuuuuuuuuuu!");
	}
	
	@Override
	public int getDanio() {
		return this.danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
	}
	
}

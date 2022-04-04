package entidad.armas;

public class Rezos extends Arma {
	
	private int danio=65;
    private String nombre = "rezos";
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void usar() {
		System.out.println("Padre nuestro que estas en los cielos");
		
	}
	
	public void setDanio(int danio) {
		this.danio = danio;
	}

	@Override
	public int getDanio() {
		return this.danio;
	}
	
	
}

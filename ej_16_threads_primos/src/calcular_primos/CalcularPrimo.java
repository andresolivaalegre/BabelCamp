package calcular_primos;

public class CalcularPrimo extends Thread{
	
	int n;
	String nombre;
	
	public CalcularPrimo(String nombre, int n) {
		this.nombre=nombre;
		this.n=n;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getN() {
		return n;
	}
	
	public void setN(int n) {
		this.n = n;
	}

	public void run() {
		if(esPrimo(n))
			System.out .println("Hilo: " + this.nombre + "-> " + "El numero " + n + " es primo");
		else
			System.out .println("Hilo: " + this.nombre + "-> " + "El numero " + n + " no es primo");
	}

	public boolean esPrimo (int numero) {
		  if (numero == 0 || numero == 1 || numero == 4) {
		    return false;
		  }
		  for (int x = 2; x < numero / 2; x++) {
		    if (numero % x == 0)
		      return false;
		  }
		  return true;
		}
}


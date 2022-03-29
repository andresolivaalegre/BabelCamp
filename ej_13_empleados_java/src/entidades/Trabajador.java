package entidades;

public class Trabajador extends Empleado {
	
	protected int valoracion;
	
	public int getValoracion() {
		return this.valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	@Override
	public double calcularSueldo() {
		if (valoracion<4)
			return sueldoBase;
		else if (valoracion<6)
			return sueldoBase+50;
		else if (valoracion<8)
			return sueldoBase+100;
		else 
			return sueldoBase+200;
		
	}

	@Override
	public String toString() {
		return "Trabajador [Nombre=" + nombre + ", Sueldo Base=" + sueldoBase + ", Valoracion=" + valoracion + ", Sueldo Final=" + this.calcularSueldo() + "]";
	}
	

}

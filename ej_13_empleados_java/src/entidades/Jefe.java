package entidades;

public class Jefe extends Empleado {
	
	protected double incentivos;


	public double getIncentivos() {
		return this.incentivos;
	}

	public void setIncentivos(double incentivos) {
		this.incentivos = incentivos;
	}
	
	@Override
	public double calcularSueldo() {
		return sueldoBase + incentivos;
	}
	
	@Override
	public String toString() {
		return "Jefe [Nombre=" + nombre + ", Sueldo Base=" + sueldoBase + ", Incentivos=" + incentivos + ", Sueldo Final=" + this.calcularSueldo() + "]";
	}
}
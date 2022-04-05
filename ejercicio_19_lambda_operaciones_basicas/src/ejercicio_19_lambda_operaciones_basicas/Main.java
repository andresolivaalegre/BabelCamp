package ejercicio_19_lambda_operaciones_basicas;

import java.util.Scanner;

interface InterfazDosParametros{
	public Integer operacion(int n1, int n2);
}

interface InterfazUnParametro{
	public Integer operacion(int n);
}

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		InterfazDosParametros o1    = ( n1, n2 ) -> n1 + n2;
		InterfazDosParametros o2    = ( n1, n2 ) -> n1 - n2;
		InterfazDosParametros o3    = ( n1, n2 ) -> n1 * n2;
		InterfazDosParametros o4    = ( n1, n2 ) -> n1 / n2;
		InterfazUnParametro o5    = ( n1) -> n1*n1;
		
		
		
		System.out.println("Introduzca dos numeros para realizar las operaciones basicas:");
		System.out.println("Primer numero:");
		int n1 = scan.nextInt();
		System.out.println("Segundo numero:");
		int n2 = scan.nextInt();
		
		System.out.println("- - - - Suma - - - - ");
		System.out.println(n1 + " + " + n2 + " = " + o1.operacion(n1, n2));
		System.out.println("- - - - Resta - - - - ");
		System.out.println(n1 + " - " + n2 + " = " + o2.operacion(n1, n2));
		System.out.println("- - - - Multiplicacion - - - - ");
		System.out.println(n1 + " x " + n2 + " = " + o3.operacion(n1, n2));
		System.out.println("- - - - Division - - - - ");
		System.out.println(n1 + " / " + n2 + " = " + o4.operacion(n1, n2));
		System.out.println("- - - - Potencia - - - - ");
		System.out.println(n1 + " ^ 2 = " + o5.operacion(n1));
		System.out.println(n1 + " ^ 2 = " + o5.operacion(n2));
		
	}
}

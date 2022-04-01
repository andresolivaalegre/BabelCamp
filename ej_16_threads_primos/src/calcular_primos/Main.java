package calcular_primos;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		System.out.println("Primer numero:");
		int n1 = scan.nextInt();
		System.out.println("Segundo numero:");
		int n2 = scan.nextInt();
		System.out.println("Tercer numero:");
		int n3 = scan.nextInt();

		CalcularPrimo hilo1 = new CalcularPrimo("Valor 1", n1);
		CalcularPrimo hilo2 = new CalcularPrimo("Valor 2", n2);
		CalcularPrimo hilo3 = new CalcularPrimo("Valor 3", n3);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
			
		
	}//

}

package ejercicio_18_primos_lambda;

import java.util.Scanner;

interface esPrimo{
	public Runnable comprobar(int n);
}


public class Main {
	
	
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		System.out.println("Primer numero:");
		int n1 = scan.nextInt();
		System.out.println("Segundo numero:");
		int n2 = scan.nextInt();
		System.out.println("Tercer numero:");
		int n3 = scan.nextInt();
		
		esPrimo n = numero ->{ 
			boolean primo = false;
			if (numero == 0 || numero == 1 || numero == 4) {
				primo=true;
		    } else
		    	for (int x = 2; x < numero / 2; x++) {
		    		if (numero % x == 0)
		    			primo=true;
		    	}
			if(!primo)
				System.out.println("El numero " + numero + " es primo");
			else 
				System.out.println("El numero " + numero + " no es primo");
		    return null;
		};
		
		Thread t1=new Thread(n.comprobar(n1));
		Thread t2=new Thread(n.comprobar(n2));
		Thread t3=new Thread(n.comprobar(n3));
		
		t1.start();
		t2.start();
		t3.start();
	}		

}
	
	

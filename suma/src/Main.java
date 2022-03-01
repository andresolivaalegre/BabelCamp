
public class Main {

    public static void main(String[] args) {

        //Suma de dos números
        sumas ejemplo = new sumas();
        System.out.println(ejemplo.suma(1,2));

        //Suma acumulada
        System.out.println(ejemplo.sumaAcumulada(1));
        System.out.println(ejemplo.sumaAcumulada(3));
        System.out.println(ejemplo.sumaAcumulada(5));
        System.out.println(ejemplo.sumaAcumulada(2));

    }
}

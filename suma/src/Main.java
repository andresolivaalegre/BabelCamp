
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

        //resta de dos números
        restas ejemplo = new restas();
        System.out.println(ejemplo.resta(1,2));

        //resta acumulada
        System.out.println(ejemplo.restaAcumulada(1));
        System.out.println(ejemplo.restaAcumulada(3));
        System.out.println(ejemplo.restaAcumulada(5));
        System.out.println(ejemplo.restaAcumulada(2));

    }
}

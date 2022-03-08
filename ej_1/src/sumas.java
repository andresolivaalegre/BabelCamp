public class sumas {

    private int sumatotal=0;

    public  int suma(int n1, int n2){
        return n1+n2;
    }

    public int sumaAcumulada(int n){
        sumatotal+=n;
        return sumatotal;
    }

}

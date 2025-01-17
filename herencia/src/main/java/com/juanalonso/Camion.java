package com.juanalonso;

public class Camion extends Vehiculo{
    private int cargaMaxima;
    private int nEjes;
    public Camion(int nRuedas, int velocidad, int potencia,String marca, String modelo, int cargaMaxima, int nEjes) {
        super(nRuedas, velocidad, potencia, marca, modelo); //con esto llamamos al constructor de su superclase
        setCargaMaxima(cargaMaxima);
        setnEjes(nEjes);
    }
    public Camion() {
        super();
        pedirDatos();
    }
    public int getCargaMaxima() {
        return cargaMaxima;
    }
    public void setCargaMaxima(int cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }
    public int getnEjes() {
        return nEjes;
    }
    public void setnEjes(int nEjes) {
        this.nEjes = nEjes;
    }
    public String toString() {
        String info=super.toString();
        info+="Carga maxima: "+getCargaMaxima()+"\n";
        info+="Numero de ejes: "+getnEjes()+"\n";
        return info;
    }
    public void pedirDatos() {
        super.pedirDatos();
        System.out.println("Introduce la carga maxima");
        setCargaMaxima(sc.nextInt());
        System.out.println("Introduce el numero de ejes");
        setnEjes(sc.nextInt());
    }
    
}

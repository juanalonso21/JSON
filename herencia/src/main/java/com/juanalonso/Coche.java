package com.juanalonso;

public class Coche extends Vehiculo {
    private int nPuertas;
    Coche(int nRuedas, int velocidad, int potencia,String marca, String modelo, int nPuertas) {
        super(nRuedas, velocidad, potencia, marca, modelo); //con esto llamamos al constructor de su superclase
        setnPuertas(nPuertas);
    }
    Coche() {
        super();
        pedirDatos();
    }
    public int getnPuertas() {
        return nPuertas;
    }
    public void setnPuertas(int nPuertas) {
        this.nPuertas = nPuertas;
    }
    public String toString() {
        String info=super.toString();
        info+="Numero de puertas: "+getnPuertas()+"\n";
        return info;
    }
    public void pedirDatos() {
        super.pedirDatos();
        System.out.println("Introduce el numero de puertas");
        setnPuertas(sc.nextInt());
    }
}

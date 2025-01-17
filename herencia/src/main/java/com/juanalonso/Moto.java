package com.juanalonso;

public class Moto extends Vehiculo {
    private String cilindrada;
    Moto(int nRuedas, int velocidad, int potencia,String marca, String modelo, String cilindrada) {
        super(nRuedas, velocidad, potencia, marca, modelo); //con esto llamamos al constructor de su superclase
        setCilindrada(cilindrada);
    }
    Moto() {
        super();
        pedirDatos();
    }
    public String getCilindrada() {
        return cilindrada;
    }
    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }
    public String toString() {
        String info=super.toString();
        info+="Cilindrada de la moto: "+getCilindrada()+"\n";
        return info;
    }
    @Override
    public void pedirDatos() {
        super.pedirDatos();
        System.out.println("Introduce la cilindrada de la moto");
        setCilindrada(sc.nextLine());
    }
}

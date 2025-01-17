package com.juanalonso;
import java.util.Scanner;
public abstract class Vehiculo { //Las clases abstractas no se pueden instanciar solas
    Scanner sc = new Scanner(System.in);
    protected int nRuedas;
    protected int velocidad;
    protected int potencia;
    protected String marca;
    protected String modelo;
    public Vehiculo(int nRuedas, int velocidad, int potencia, String marca, String modelo) {
        setnRuedas(nRuedas);
        setVelocidad(velocidad);
        setPotencia(potencia);
        setMarca(marca);
        setModelo(modelo);
    }
    public Vehiculo() {
        
    }
    public int getnRuedas() {
        return nRuedas;
    }
    public void setnRuedas(int nRuedas) {
        this.nRuedas = nRuedas;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String toString() {
        String info="";
        info+="Numero de ruedas: "+getnRuedas()+"\n";
        info+="Velocidad: "+getVelocidad()+"\n";
        info+="Potencia: "+getPotencia()+"\n";
        info+="Marca: "+getMarca()+"\n";
        info+="Modelo: "+getModelo()+"\n";
        return info;
    }   

    public void pedirDatos() {
        System.out.println("Introduce el numero de ruedas");
        setnRuedas(sc.nextInt());
        System.out.println("Introduce la velocidad");
        setVelocidad(sc.nextInt());
        System.out.println("Introduce la potencia");
        setPotencia(sc.nextInt());
        System.out.println("Introduce la marca");
        setMarca(sc.next());
        System.out.println("Introduce el modelo");
        setModelo(sc.next());
        sc.nextLine();
    }
}

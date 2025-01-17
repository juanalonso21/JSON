package com.juanalonso;

public class Vehiculo {
    String matricula;
    String marca;
    String tipo;
    int km;
    public Vehiculo(String matricula, String marca, String tipo, int km) {
        setKm(km);
        setMarca(marca);
        setMatricula(matricula);
        setTipo(tipo);
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setKm(int km) {
        this.km = km;
    }
    public void info() {
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Marca: " + this.marca);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Kilometros: " + this.km);
    }
}

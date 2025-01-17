package com.juanalonso;
import java.util.Scanner;
public class Director extends Empleado{
    private static Scanner sc = new Scanner(System.in);
    private int numeroDespacho;
    private double plusSalario = 400;
    public Director(String DNI, String nombre, int horasExtras, int numeroDespacho) {
        super(DNI, nombre, horasExtras);
        setNumeroDespacho(numeroDespacho);
        setPrecioHoraExtra(20);
        setSalarioBase(getSalarioBase()+plusSalario);
    }
    public Director() {
        super();
        pedirDatosDirector();
        setPrecioHoraExtra(20);
        setSalarioBase(getSalarioBase()+plusSalario);
        setTipo("Director");
    }
    
    //PRINCIPIO DE METODOS SETTERS Y GETTERS
    public void setNumeroDespacho(int numeroDespacho) {
        this.numeroDespacho = numeroDespacho;
    }
    public int getNumeroDespacho() {
        return numeroDespacho;
    }
    public double getPlusSalario() {
        return plusSalario;
    }
    public void setPlusSalario(double plusSalario) {
        this.plusSalario = plusSalario;
    }
    //FINAL DE METODOS SETTERS Y GETTERS
    
    public void pedirDatosDirector() {
        System.out.println("Introduce el numero de despacho");
        setNumeroDespacho(sc.nextInt());
    }
}

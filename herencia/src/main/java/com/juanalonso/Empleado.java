package com.juanalonso;
import java.util.Scanner;
public class Empleado {
    private static Scanner sc = new Scanner(System.in);
    private String DNI;
    private String nombre;
    private String email;
    private double salarioBase = 1000;
    private int horasExtras;
    private double precioHoraExtra = 10;
    public Empleado() {
        pedirDatos();
    }
    public Empleado(String DNI, String nombre, int horasExtras) { //Aqui hago otro constructor para poder añadir las horas extras desde el constructor
        setDNI(DNI);
        setNombre(nombre);
        setEmail("example@example.com");
        setHorasExtras(horasExtras);
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    public int getHorasExtras() {
        return horasExtras;
    }
    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }
    public double getPrecioHoraExtra() {
        return precioHoraExtra;
    }
    public void setPrecioHoraExtra(double precioHoraExtra) {
        this.precioHoraExtra = precioHoraExtra;
    }
    public double calcularSueldo() {
        return getSalarioBase()+(getHorasExtras()*getPrecioHoraExtra());
    }
    public void getSueldoTotal(){
        calcularSueldo();
    }
    public void pedirDatos() {
        System.out.println("Introduce el DNI");
        setDNI(sc.nextLine());
        System.out.println("Introduce el nombre");
        setNombre(sc.nextLine());
        System.out.println("Introduce las horas extras");
        setHorasExtras(sc.nextInt());
        sc.nextLine();
    }
    public String toString() {
        String info="";
        info+="Nombre: "+getNombre();
        info+="("+getDNI()+")"+"\n";
        info+="Categoria: "+this.getClass().getSimpleName()+"\n";
        info+="Sueldo total: "+calcularSueldo()+"\n";
        return info;
    }

}

package com.juanalonso;

public class Persona {
    private String nombre;
    private int edad;
    private String ciudad;
    private String trabajo;

    // Constructor
    public Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }
    public Persona(String trabajo) {
        this.trabajo = trabajo;
    }
    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }
    public void pInfo() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Edad: " + this.edad);
        System.out.println("Ciudad: " + this.ciudad);
        System.out.println("Trabajo:" + this.trabajo);
    }

    // Getters y setters (opcional para Gson)
}


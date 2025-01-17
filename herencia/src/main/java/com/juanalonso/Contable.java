package com.juanalonso;

public class Contable extends Empleado {
    private double plusSalario = 200;
    public Contable(String DNI, String nombre,  int horasExtras) {
        super(DNI, nombre, horasExtras);
        setPlusSalario(plusSalario);
        setPrecioHoraExtra(10);
        setSalarioBase(getSalarioBase()+plusSalario);
    }
    public Contable() {
        super();
        setPrecioHoraExtra(10);
        setSalarioBase(getSalarioBase()+plusSalario);
        setTipo("Contable");
    }

    public double getPlusSalario() {
        return plusSalario;
    }
    public void setPlusSalario(double plusSalario) {
        this.plusSalario = plusSalario;
    }
    
}

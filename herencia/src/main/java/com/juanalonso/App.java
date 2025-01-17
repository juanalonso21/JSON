package com.juanalonso;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.*; //pruena typetoken
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
public class App { //esta clase administra EMPLEADO CONTABLE Y DIRECTOR
    //Voy a utiliza instanceof para saber cual es la clase , por ejemplo busco un empleado y se si es un contable o un director 
    private static ArrayList<Empleado> LEmpleados = new ArrayList<Empleado>();
    private static ArrayList<Contable> LContables = new ArrayList<Contable>();
    private static ArrayList<Director> LDirectores = new ArrayList<Director>();
    private static Scanner sc = new Scanner(System.in);
        public static void main(String[] args) {
            // administrarEmpleado();
            while (true) {
                menu();
            }
            }
            public static void menu(){
                System.out.println("1. Nuevo empleado");
                System.out.println("2. Nuevo contable");
                System.out.println("3. Nuevo director");
                System.out.println("4. Añadir horas extras a empleado");
                System.out.println("5. Imprimir empleado");
                System.out.println("6. Imprimir todos los empleados");
                System.out.println("7. Guardar empleados");
                int opcion = sc.nextInt();
                sc.nextLine(); 
                switch (opcion) {
                    case 1:
                        nuevoEmpleado();
                        break;
                    case 2:
                        nuevoContable();
                        break;
                    case 3:
                        nuevoDirector();
                        break;
                    case 4:
                        añadirHoras();
                        break;
                    case 5:
                        imprimirEmpleado();
                        break;
                    case 6:
                        imprimirTodosLosEmpleados();
                        break;
                    case 7:
                        guardarEmpleados();
                        break;
                    case 8:
                        cargarEmpleados();
                        imprimirTodosLosEmpleados();
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }
            public static void nuevoEmpleado() {
                Empleado empleado = new Empleado();
                LEmpleados.add(empleado);
                System.out.println("Empleado añadido");
            }
        
            public static void nuevoContable() {
                Contable contable = new Contable();
                LContables.add(contable);
                LEmpleados.add(contable);
                System.out.println("Contable añadido");
            }
        
            public static void nuevoDirector() {
                Director director = new Director();
                LDirectores.add(director);
                LEmpleados.add(director);
                System.out.println("Director añadido");
            }
        
            public static void añadirHoras() {
                System.out.println("Introduce el DNI del empleado");
                String dni = sc.nextLine();
                for (Empleado e : LEmpleados) {
                    if (e.getDNI().equals(dni)) {
                        System.out.println("Introduce las horas extras a añadir");
                        int horasExtras = sc.nextInt();
                        sc.nextLine(); 
                        e.setHorasExtras(e.getHorasExtras() + horasExtras);
                        System.out.println("Horas extras añadidas.");
                        return;
                    }
                }
                System.out.println("Empleado no encontrado");
            }
            public static void imprimirEmpleado() {
                System.out.println("Introduce el DNI del empleado");
                String dni = sc.nextLine();
                for (Empleado e : LEmpleados) {
                    if (e.getDNI().equals(dni)) {
                        System.out.println(e.toString());
                        return;
                    }
                }
                System.out.println("Empleado no encontrado");
            }
        
            public static void imprimirTodosLosEmpleados() {
                for (Empleado e : LEmpleados) {
                    System.out.println(e.toString());
                }
            }
            public static void guardarEmpleados() {
                //
                try (FileWriter writer = new FileWriter("empleados.json")){
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    gson.toJson(LEmpleados, writer);
                }
                catch (IOException e) {
                    System.out.println("No se ha podido escribir el archivo");
                }
            }
            public static void cargarEmpleados() {
                Type type = new TypeToken<ArrayList<Empleado>>(){}.getType();
                try (FileReader reader = new FileReader("empleados.json")) {
                    Gson gson = new Gson();
                    ArrayList<Empleado> empleadosCargados = gson.fromJson(reader, type);
                    for (Empleado e : empleadosCargados) {
                        if (e instanceof Contable) {
                            LContables.add((Contable) e);
                        } else if (e instanceof Director) {
                            LDirectores.add((Director) e);
                        }
                        LEmpleados.add(e);
                    }
                } catch (IOException e) {
                    System.out.println("No se ha podido leer el archivo");
                }
            }
            
            // public static void administrarEmpleado() {
            //     System.out.println("Introduce el DNI del empleado");
            //     String dni = sc.nextLine();
            //     for (Empleado e : LEmpleados) {
            //         if (e.getDNI().equals(dni)) {
            //             System.out.println("Empleado encontrado: " + e.toString());
            //             if (e instanceof Contable) {
            //                 System.out.println("Es un contable.");
            //             } else if (e instanceof Director) {
            //                 System.out.println("Es un director.");
            //             }
            //             return;
            //         }
            //     }
            //     System.out.println("Empleado no encontrado");
            // }
}

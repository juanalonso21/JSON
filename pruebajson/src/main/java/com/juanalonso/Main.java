package com.juanalonso;
import com.google.gson.Gson; //Transformacion a JSON
import com.google.gson.GsonBuilder;
import java.io.FileWriter; //Escritura de archivos en java
import java.io.FileReader; //Lectura de archivos en java
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {
    public static ArrayList<Vehiculo> LVehiculos = new ArrayList<Vehiculo>();
    public static void main(String[] args) {
        //pruebaJSON();
        cargarVehiculosExistentes(); //Ahora con cargarVehiculosExistentes nos quitamos el problema de que solo sobrescriba los JSON
        crearVehiculo();
        guardarVehiculo();
        imprimirVehiculos();
    }
    public static void crearVehiculo() {
        //en este metodo creo dos vehiculos dentro del ArrayList para en el metodo guardarVehiculo guardarlos en el json
        LVehiculos.add(new Vehiculo("43ds", "Mercedes", "Sedan", 50000));
        LVehiculos.add(new Vehiculo("1234AFC", "Audi", "A4", 100000));
        LVehiculos.add(new Vehiculo("54d", "Seat", "Cordoba", 543534));
    }
    public static void guardarVehiculo() {
        //en este caso el JSON ya existe entoces este writer lo que hace es sobrescribir el archivo ya existente
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("vehiculos.json")) {
            gson.toJson(LVehiculos, writer);
            System.out.println("JSON guardado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearJSON() {
                // Crear un objeto
                Persona persona = new Persona("Juan", 30, "Madrid");

                // Crear una instancia de Gson
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
                // Convertir el objeto a JSON y guardarlo en un archivo
                //Aqui usamos try por el caso de errores en la escritura del disco
                try (FileWriter writer = new FileWriter("persona.json")) {
                    gson.toJson(persona, writer);
                    System.out.println("JSON guardado con éxito.");
                } catch (IOException e) { //aqui estan las excepciones en caso de no tener permiso o ser iterrumpida la ejecucion
                    e.printStackTrace();
                }
    }
    public static void leerJSON() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("persona.json")) { //en esta linea hago el reader de que archivo lo quiero 
            Persona persona = gson.fromJson(reader, Persona.class); //Aqui como tiene que interpretar los datos del JSON
            persona.pInfo(); //Aqui que imprima los datos de la UNICA persona que hay en el JSON
        } catch (IOException e) {
            e.printStackTrace(); //Excepcion
        }
    }
    public static void modificarJSON() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("persona.json")) {
            Persona persona = gson.fromJson(reader, Persona.class);
            persona.pInfo();
            persona.setTrabajo("Desarrollador");
            persona.pInfo();
            try (FileWriter writer = new FileWriter("persona.json")) {
                gson.toJson(persona, writer);
                System.out.println("Los cambios se han guardado correctamente en persona.json.");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cargarVehiculosExistentes() {
        //este metodo lo que nos hace es cargar los archivos existetes en el ArrayList para luego a la hora de escribir no lo sobre escriba si no que escriba debajo cada vez que añadimos un objeto
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("vehiculos.json")) {
            Vehiculo[] vehiculosArray = gson.fromJson(reader, Vehiculo[].class);
            if (vehiculosArray != null) {
                LVehiculos.addAll(Arrays.asList(vehiculosArray)); //esto usando la importacion de Arrays lo que podemos hacer es transformar un Array normal en un ArrayList
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo JSON.");
        }
    }
    public static void imprimirVehiculos() {
        for (Vehiculo vehiculo : LVehiculos) {
            vehiculo.info();
        }
    }
}
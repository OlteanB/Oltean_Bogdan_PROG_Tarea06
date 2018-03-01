/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.vista.utilidades;

import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.DireccionPostal;
import mvc.modelo.vehiculo.Vehiculo;
import mvc.modelo.dominio.Alquiler;
import mvc.vista.Opcion;
import utilidades.Entrada;

/**
 *
 * @author bogdan
 */
public class Consola {

    public static void mostrarMenu() {
        mostrarCabecera("Alquiler Vehiculos");
        for(Opcion opcion: Opcion.values()){
            System.out.println(opcion);
        }
    }

    public static void mostrarCabecera(String mensaje) {
        System.out.printf("%n%s%n", mensaje);
        System.out.println(String.format("%0" + mensaje.length() + "d%n", 0).replace("0", "-"));
    }

    public static int elegirOpcion() {
        int ordinalOpcion;
        do {
            System.out.print("\nElige una opción: ");
            ordinalOpcion = Entrada.entero();
        } while (ordinalOpcion < 0 || ordinalOpcion > 11);
        return ordinalOpcion;
    }

    public static String leerDni() {
        System.out.print("Introduce el DNI del cliente: ");
        String dniBorrar = Entrada.cadena();
        return dniBorrar;
    }

    public static String leerMatricula() {
        System.out.print("Introduce la matrícula del vehículo: ");
        String matriculaBorrar = Entrada.cadena();
        return matriculaBorrar;
    }

    public static Cliente leerCliente() {
        Cliente cliente = null;
        System.out.print("Nombre: ");
        String nombre = Entrada.cadena();
        System.out.print("DNI: ");
        String dni = Entrada.cadena();
        System.out.print("Dirección: ");
        String direccion = Entrada.cadena();
        System.out.print("Localidad: ");
        String localidad = Entrada.cadena();
        System.out.print("Código postal: ");
        String codigoPostal = Entrada.cadena();
        cliente = new Cliente(nombre, dni, new DireccionPostal(codigoPostal, direccion, localidad));
        return cliente;
    }

    public static Vehiculo leerTurismo() {
        Vehiculo nuevoTurismo = null;
        System.out.print("Matrícula: ");
        String matricula = Entrada.cadena();
        System.out.print("Marca: ");
        String marca = Entrada.cadena();
        System.out.print("Modelo: ");
        String modelo = Entrada.cadena();
        System.out.print("Cilindrada: ");
        int cilindrada = Entrada.entero();
        nuevoTurismo = new Vehiculo(matricula, marca, modelo, cilindrada);
        return nuevoTurismo;
    }

}

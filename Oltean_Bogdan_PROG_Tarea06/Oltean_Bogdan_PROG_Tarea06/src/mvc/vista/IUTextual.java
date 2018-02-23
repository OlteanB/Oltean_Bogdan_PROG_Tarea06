/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.vista;

import mvc.modelo.dao.Alquileres;
import mvc.modelo.dao.Clientes;
import mvc.modelo.dao.Turismos;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.DireccionPostal;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.Turismo;
import mvc.vista.utilidades.Consola;
import utilidades.Entrada;

/**
 *
 * @author bogdan
 */
public class IUTextual {
    public static void main(String[] args) {
        int menu;
        Alquileres alquileres = new Alquileres();
        Clientes clientes = new Clientes();
        Turismos turismos = new Turismos();
        Consola consola = new Consola();
        //los siguientes clientes y turismos han sido creados para hacer pruebas
        
        Cliente cliente1 = new Cliente("a", "11111111A", new DireccionPostal("04005", "Calle1", "Almeria"));
        Cliente cliente2 = new Cliente("b", "22222222B", new DireccionPostal("04002", "Calle2", "ALmeria"));
        clientes.anadir(cliente1);
        clientes.anadir(cliente2);
        Turismo turismo1 = new Turismo("1111BBB", "Seat", "Ibiza", 6);
        Turismo turismo2 = new Turismo("2222BBB", "Opel", "Opel", 8);
        turismos.anadir(turismo1);
        turismos.anadir(turismo2);

        consola.mostrarMenu();

        menu = Entrada.entero();
        while (menu != 0) {
            switch (menu) {
                case 1:
                    Cliente anadir = null;
                    do {
                        System.out.println("---Añadir cliente---");
                        try {
                            anadir = consola.leerCliente();
                            //clientes.anadir(anadir);
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.println("ERROR al introducir los datos, intentalo de nuevo");
                            anadir = null;
                        }
                    } while (anadir == null);
                    try {
                        clientes.anadir(anadir);
                    } catch (ExcepcionAlquilerVehiculos a) {
                        System.out.println("Error añadir cliente");
                    }

                    break;
                case 2:
                    System.out.println("---Borrar cliente---");
                    System.out.println("introduce DNI del cliente a borrar: ");
                    String borrarDni = Entrada.cadena();
                    try {
                        clientes.borrar(borrarDni);
                        System.out.println("Cliente borrado correctamente.");
                    } catch (ExcepcionAlquilerVehiculos b) {
                        System.out.println("Error al borrar el cliente.");
                    }
                    break;
                case 3:
                    System.out.println("---Listado de clientes----");
                    for (Cliente cliente : clientes.getClientes()) {
                        if (cliente != null) {
                            System.out.println(cliente);
                        }
                    }
                    System.out.println("");
                    break;
                case 4:
                    Turismo anadirTurismo = null;
                    do {
                        System.out.println("---Añadir turismo---");
                        try {
                            anadirTurismo = consola.leerTurismo();
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.println("ERROR al introducir los datos del turismo, intentalo de nuevo");
                            anadirTurismo = null;
                        }
                    } while (anadirTurismo == null);
                    try {
                        turismos.anadir(anadirTurismo);
                    } catch (ExcepcionAlquilerVehiculos a) {
                        System.out.println("Error añadir turismo");
                    }
                    break;
                case 5:
                    System.out.println("---Borrar turismo---");
                    System.out.println("Introduce la matrícula del vehículo que quieres borrar: ");
                    String borrarMatricula = Entrada.cadena();
                    try {
                        turismos.borrar(borrarMatricula);
                        System.out.println("Turismo borrado correctamente.");
                    } catch (ExcepcionAlquilerVehiculos c) {
                        System.out.println("ERROR al borrar el turismo.");
                    }
                    break;
                case 6:
                    System.out.println("---Listar turismo---");
                    for (Turismo turismo : turismos.getTurismos()) {
                        if (turismo != null) {
                            System.out.println(turismo);
                        }
                    }
                    System.out.println("");
                    break;
                case 7:
                    System.out.println("---Abrir un alquiler---");
                    System.out.println("Introduce la matrícula del vehiculo: ");
                    String buscarMatricula = Entrada.cadena();
                    Turismo turismoBuscado = turismos.buscarTurismo(buscarMatricula);
                    System.out.println("Introduce DNI del cliente: ");
                    String buscarDNI = Entrada.cadena();
                    Cliente clienteBuscado = clientes.buscar(buscarDNI);
                    if (turismoBuscado == null && clienteBuscado == null) {
                        System.out.println("Error, los datos introducidos no existen");
                    } else {
                        try {
                            alquileres.openAlquiler(clienteBuscado, turismoBuscado);
                            System.out.println("Alquiler abierto correctamente.");
                        } catch (ExcepcionAlquilerVehiculos g) {
                            System.out.println("Error, alquiler no abierto");
                        }
                    }
                    break;
                case 8:
                    System.out.println("---Cerrar un alquiler---");
                    System.out.println("Introduce la matrícula del vehículo: ");
                    buscarMatricula = Entrada.cadena();
                    turismoBuscado = turismos.buscarTurismo(buscarMatricula);
                    System.out.println("Introduce DNI del cliente: ");
                    buscarDNI = Entrada.cadena();
                    clienteBuscado = clientes.buscar(buscarDNI);
                    if (turismoBuscado == null && clienteBuscado == null) {
                        System.out.println("ERROR, los datos introducidos no existen");
                    } else {
                        try {
                            alquileres.closeAlquiler(clienteBuscado, turismoBuscado);
                            System.out.println("Alquiler cerrado correctamente.");
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.printf("Error, alquiler no cerrado");
                        }
                    }
                    break;
                case 9:
                    System.out.println("---Listado de alquileres---");
                    for (Alquiler alquiler : alquileres.getAlquiler()) {
                        if (alquiler != null) {
                            System.out.println(alquiler);
                        }
                    }
                    System.out.println("");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción erronea.");
                    break;

            }
            consola.mostrarMenu();
            menu = Entrada.entero();
        }
        System.out.println("FIN");
    }
}

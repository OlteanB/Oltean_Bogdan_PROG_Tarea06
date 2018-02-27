/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.vista;

import mvc.controlador.IControladorAlquilerVehiculos;
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
public class IUTextual implements IVistaAlquilerVehiculos {

    IControladorAlquilerVehiculos controlador;

    public IUTextual() {
        Opcion.setVista(this);
    }

    @Override
    public void setControlador(IControladorAlquilerVehiculos controlador) {
        this.controlador = controlador;
    }

    @Override
    public void comenzar() {
        int ordinalOpcion;
        do {
            Consola.mostrarMenu();
            ordinalOpcion = Consola.elegirOpcion();
            Opcion opcion = Opcion.getOpcionSegunOridnal(ordinalOpcion);
            opcion.ejecutar();
        } while (ordinalOpcion != Opcion.SALIR.ordinal());
    }

    public void salir() {
        System.out.println("FIN");
    }

    public void anadirCliente() {
        Consola.mostrarCabecera("Añadir cliente");
        try {
            Cliente cliente = Consola.leerCliente();
            controlador.anadirCliente(cliente);
            System.out.println("Cliente añadido satisfactoriamente\n");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("ERROR: %s%n%n", e.getMessage());
        }
    }

    public void borrarCliente() {
        Consola.mostrarCabecera("Borrar cliente");
        String dni = Consola.leerDni();
        try {
            controlador.borrarCliente(dni);
            System.out.println("Cliente borrado satisfactoriamente\n");
        } catch (Exception e) {
            System.out.printf("ERROR: %s%n%n", e.getMessage());
        }
    }

    public void buscarCliente() {
        Consola.mostrarCabecera("Buscar cliente");
        String dni = Consola.leerDni();
        Cliente cliente = controlador.buscarCliente(dni);
        String mensaje = (cliente != null) ? cliente.toString() : "El cliente no existe";
        System.out.printf("%s%n%n", mensaje);
    }

    public void listarClientes() {
        Consola.mostrarCabecera("Listar clientes");
        for (Cliente cliente : controlador.obtenerClientes()) {
            if (cliente != null) {
                System.out.println(cliente);
            }
        }
        System.out.println("");
    }

    public void anadirTurismo() {
        Consola.mostrarCabecera("Añadir turismo");
        try {
            Turismo turismo = Consola.leerTurismo();
            controlador.anadirTurismo(turismo);
            System.out.println("Turismo añadido satisfactoriamente\n");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("ERROR: %s%n%n", e.getMessage());
        }
    }

    public void borrarTurismo() {
        Consola.mostrarCabecera("Borrar turismo");
        String matricula = Consola.leerMatricula();
        try {
            controlador.borrarTurismo(matricula);
            System.out.println("Turismo borrado satisfactoriamente\n");
        } catch (ExcepcionAlquilerVehiculos e) {
            System.out.printf("ERROR: %s%n%n", e.getMessage());
        }
    }

    public void buscarTurismo() {
        Consola.mostrarCabecera("Buscar turismo");
        String matricula = Consola.leerMatricula();
        Turismo turismoBuscado = controlador.buscarTurismo(matricula);
        String mensaje = (turismoBuscado != null) ? turismoBuscado.toString() : "El turismo no existe";
        System.out.printf("%s%n%n", mensaje);
    }

    public void listarTurismo() {
        Consola.mostrarCabecera("Listar turismos");
        for (Turismo turismo : controlador.obtenerTurismos()) {
            if (turismo != null) {
                System.out.println(turismo);
            }
        }
        System.out.println("");
    }

    public void abrirAlquiler() {
        Consola.mostrarCabecera("Abrir alquiler");
        String matricula = Consola.leerMatricula();
        String dni = Consola.leerDni();
        Turismo turismo = controlador.buscarTurismo(matricula);
        Cliente cliente = controlador.buscarCliente(dni);
        if (turismo == null || cliente == null) {
            System.out.println("Matricula o DNI erroneo\n");
        } else {
            try {
                controlador.abrirAlquiler(cliente, turismo);
                System.out.println("Alquiler abierto satisfactoriamente\n");
            } catch (ExcepcionAlquilerVehiculos e) {
                System.out.printf("ERROR: %s%n%n", e.getMessage());
            }
        }
    }

    public void cerrarAlquiler() {
        Consola.mostrarCabecera("Cerrar trabajo");
        String matricula = Consola.leerMatricula();
        String dni = Consola.leerDni();
        Cliente cliente = controlador.buscarCliente(dni);
        Turismo turismo = controlador.buscarTurismo(matricula);
        if (turismo == null || cliente ==null) {
            System.out.println("Matricula o DNI erroneo\n");
        } else {
            try {
                controlador.cerrarAlquiler(cliente, turismo);
                System.out.println("Alquiler cerrado satisfactoriamente\n");
            } catch (ExcepcionAlquilerVehiculos e) {
                System.out.printf("ERROR: %s%n%n", e.getMessage());
            }
        }
    }

    public void listarAlquileres() {
        Consola.mostrarCabecera("Listar trabajos");
        for (Alquiler alquiler : controlador.obtenerAlquiler()) {
            if (alquiler != null) {
                System.out.println(alquiler);
            }
        }
        System.out.println("");
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.vista.utilidades;

import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.DireccionPostal;
import mvc.modelo.dominio.Turismo;

/**
 *
 * @author bogdan
 */
public class Consola {

    public static void mostrarMenu() {
        mostrarCabecera("Alquiler Vehiculos");
        System.out.println("******MENÚ******"
                + "\n1. Añadir cliente"
                + "\n2. Borrar Cliente"
                + "\n3. Listar clientes"
                + "\n4. Añadir turismo"
                + "\n5. Borrar turismo"
                + "\n6. Listar turismo"
                + "\n7. Abrir un alquiler"
                + "\n8. Cerrar un alquiler"
                + "\n9. Listar alquileres"
                + "\n0. Salir.");
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
        } while (ordinalOpcion < 0 || ordinalOpcion > 9);
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
        System.out.print("Teléfono: ");
        String telefono = Entrada.cadena();
        System.out.print("Dirección: ");
        String direccion = Entrada.cadena();
        System.out.print("Localidad: ");
        String localidad = Entrada.cadena();
        System.out.print("Código postal: ");
        String codigoPostal = Entrada.cadena();
        cliente = new Cliente(nombre, dni, new DireccionPostal(direccion, localidad, codigoPostal));
        return cliente;
    }

    public static Turismo leerTurismo(Cliente propietario) {
        Turismo nuevoVehiculo = null;
        System.out.print("Matrícula: ");
        String matricula = Entrada.cadena();
        System.out.print("Marca: ");
        String marca = Entrada.cadena();
        System.out.print("Modelo: ");
        String modelo = Entrada.cadena();
        System.out.print("Color: ");
        String color = Entrada.cadena();
        System.out.print("Cilindrada: ");
        int cilindrada = Entrada.entero();
        nuevoVehiculo = new Turismo(matricula, marca, modelo, cilindrada);
        return nuevoVehiculo;
    }
/*
    public static int leerHorasAnadir() {
        System.out.print("Introduce el número de horas a añadir: ");
        int horas = Entrada.entero();
        return horas;
    }

    public static double leerPrecioMaterial() {
        System.out.print("Introduce el precio del material a añadir: ");
        double precioMaterial = Entrada.realDoble();
        return precioMaterial;
    }

    public static int elegirTipoAlquiler() {
        int ordinalTipoTrabajo;
        do {
            System.out.printf("Elige el tipo de trabajo: ( %s)", obtenerTiposTrabajo());
            ordinalTipoTrabajo = Entrada.entero();
        } while (!TipoTrabajo.esOrdinalValido(ordinalTipoTrabajo));
        return ordinalTipoTrabajo;
    }

    private static String obtenerTiposAlquiler() {
        StringBuilder tiposTrabajos = new StringBuilder("");
        for (TipoTrabajo tipoTrabajo : TipoTrabajo.values()) {
            tiposTrabajos.append(tipoTrabajo.ordinal()).append(".- ").append(tipoTrabajo).append(" ");
        }
        return tiposTrabajos.toString();
    }
*/
}

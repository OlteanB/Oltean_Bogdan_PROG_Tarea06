/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controlador;

import mvc.modelo.dominio.Cliente;
import mvc.modelo.vehiculo.Vehiculo;
import mvc.modelo.dominio.Alquiler;

/**
 *
 * @author bogdan
 */
public interface IControladorAlquilerVehiculos {

    void abrirAlquiler(Cliente cliente, Vehiculo turismo);

    void anadirCliente(Cliente cliente);

    void anadirDatosPrueba();

    void anadirTurismo(Vehiculo turismo);

    void borrarCliente(String dni);

    void borrarTurismo(String matricula);

    Cliente buscarCliente(String dni);

    Vehiculo buscarTurismo(String matricula);

    void cerrarAlquiler(Cliente cliente, Vehiculo turismo);

    void comenzar();

    Alquiler[] obtenerAlquiler();

    Cliente[] obtenerClientes();

    Vehiculo[] obtenerTurismos();

}

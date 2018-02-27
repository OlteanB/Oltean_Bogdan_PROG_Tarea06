/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controlador;

import mvc.modelo.IModeloAlquilerVehiculo;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.Turismo;
import mvc.modelo.dominio.Alquiler;
import mvc.vista.IVistaAlquilerVehiculos;

/**
 *
 * @author bogdan
 */
public class ControladorAlquilerVehiculos implements IControladorAlquilerVehiculos {

    private IModeloAlquilerVehiculo modelo;
    private IVistaAlquilerVehiculos vista;

    public ControladorAlquilerVehiculos(IVistaAlquilerVehiculos vista, IModeloAlquilerVehiculo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.setControlador(this);
    }

    @Override
    public void comenzar() {
        modelo.anadirDatosPrueba();
        vista.comenzar();
    }

    @Override
    public void anadirCliente(Cliente cliente) {
        modelo.anadirCliente(cliente);
    }

    @Override
    public void borrarCliente(String dni) {
        modelo.borrarCliente(dni);
    }

    @Override
    public Cliente buscarCliente(String dni) {
        return modelo.buscarCliente(dni);
    }

    @Override
    public Cliente[] obtenerClientes() {
        return modelo.obtenerClientes();
    }

    @Override
    public void anadirTurismo(Turismo turismo) {
        modelo.anadirTurismo(turismo);
    }

    @Override
    public void borrarTurismo(String matricula) {
        modelo.borrarTurismo(matricula);
    }

    @Override
    public Turismo buscarTurismo(String matricula) {
        return modelo.buscarTurismo(matricula);
    }

    @Override
    public Turismo[] obtenerTurismos() {
        return modelo.obtenerTurismo();
    }

    @Override
    public void abrirAlquiler(Cliente cliente, Turismo turismo) {
        modelo.abrirAlquiler(cliente, turismo);
    }

    @Override
    public void cerrarAlquiler(Cliente cliente, Turismo turismo) {
        modelo.cerrarAlquiler(cliente, turismo);
    }
    
    @Override
    public Alquiler[] obtenerAlquiler() {
        return modelo.obtenerAlquiler();
    }

    @Override
    public void anadirDatosPrueba() {
        modelo.anadirDatosPrueba();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo;

import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.vehiculo.Vehiculo;

/**
 *
 * @author bogdan
 */
public interface IModeloAlquilerVehiculo {
    	void anadirCliente(Cliente cliente);

	void borrarCliente(String dni);

	Cliente buscarCliente(String dni);

	Cliente[] obtenerClientes();

	void anadirTurismo(Vehiculo turismo);

	void borrarTurismo(String matricula);

	Vehiculo buscarTurismo(String matricula);

	Vehiculo[] obtenerTurismo();

	void abrirAlquiler(Cliente cliente, Vehiculo turismo);

	void cerrarAlquiler(Cliente cliente, Vehiculo turismo);
        
        Alquiler[] obtenerAlquiler();

	void anadirDatosPrueba();
}

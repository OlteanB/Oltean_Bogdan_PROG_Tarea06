/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo;

import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.Turismo;

/**
 *
 * @author bogdan
 */
public interface IModeloAlquilerVehiculo {
    	void anadirCliente(Cliente cliente);

	void borrarCliente(String dni);

	Cliente buscarCliente(String dni);

	Cliente[] obtenerClientes();

	void anadirTurismo(Turismo turismo);

	void borrarTurismo(String matricula);

	Turismo buscarTurismo(String matricula);

	Turismo[] obtenerTurismo();

	void abrirAlquiler(Cliente cliente, Turismo turismo);

	void cerrarAlquiler(Cliente cliente, Turismo turismo);
        
        Alquiler[] obtenerAlquiler();

	void anadirDatosPrueba();
}

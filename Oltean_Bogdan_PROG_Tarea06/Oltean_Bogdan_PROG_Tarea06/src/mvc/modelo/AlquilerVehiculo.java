/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo;
import mvc.modelo.dao.Clientes;
import mvc.modelo.dao.Turismos;
import mvc.modelo.dao.Alquileres;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.DireccionPostal;
import mvc.modelo.dominio.Turismo;

/**
 *
 * @author bogdan
 */
public class AlquilerVehiculo implements IModeloAlquilerVehiculo {
    private Clientes clientes;
	private Turismos turismos;
	private Alquileres alquileres;
	
	public AlquilerVehiculo() {
		clientes = new Clientes();
		turismos = new Turismos();
		alquileres = new Alquileres();
	}
	
    @Override
	public void anadirCliente(Cliente cliente) {
		clientes.anadir(cliente);
	}
	
    @Override
	public void borrarCliente(String dni) {
		clientes.borrar(dni);
	}
	
    @Override
	public Cliente buscarCliente(String dni) {
		return clientes.buscar(dni);
	}
	
    @Override
	public Cliente[] obtenerClientes() {
		return clientes.getClientes();
	}
	
    @Override
	public void anadirTurismo(Turismo turismo) {
		turismos.anadir(turismo);
	}

	
    @Override
	public void borrarTurismo(String matricula) {
		turismos.borrar(matricula);
	}
	
    @Override
	public Turismo buscarTurismo(String matricula) {
		return turismos.buscar(matricula);
	}
	
    @Override
	public Turismo[] obtenerTurismo() {
		return turismos.getTurismos();
	}
	
    @Override
	public void abrirAlquiler(Cliente cliente, Turismo turismo) {
		alquileres.openAlquiler(cliente, turismo);
	}
	
    @Override
	public void cerrarAlquiler(Cliente cliente, Turismo turismo) {
		alquileres.closeAlquiler(cliente, turismo);
	}
	
    @Override
	public Alquiler[] obtenerAlquiler() {
		return alquileres.getAlquiler();
	}

    @Override
	public void anadirDatosPrueba() {
		Cliente cliente1 = new Cliente("aa", "11111111A", new DireccionPostal("04001", "Calle1", "Almeria"));
		Cliente cliente2 = new Cliente("bb", "22222222B", new DireccionPostal("04002", "Calle2", "Almeria"));
		anadirCliente(cliente1);
		anadirCliente(cliente2);
		Turismo turismo1 = new Turismo("1111BBB", "Seat", "Ibiza", 6);
		Turismo turismo2 = new Turismo("2222BBB", "Opel", "Opel", 8);
		anadirTurismo(turismo1);
		anadirTurismo(turismo2);
}
}

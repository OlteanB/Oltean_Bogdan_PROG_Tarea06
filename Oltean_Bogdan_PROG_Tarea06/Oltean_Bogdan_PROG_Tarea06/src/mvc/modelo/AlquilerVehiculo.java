/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo;
import mvc.modelo.dao.Clientes;
import mvc.modelo.dao.Vechiculos;
import mvc.modelo.dao.Alquileres;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.DireccionPostal;
import mvc.modelo.dominio.vehiculo.DatosTecnicosVehiculo;
import mvc.modelo.dominio.vehiculo.TipoVehiculo;
import mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 *
 * @author bogdan
 */
public class AlquilerVehiculo implements IModeloAlquilerVehiculo {
    private Clientes clientes;
	private Vechiculos vehiculos;
	private Alquileres alquileres;
	
	public AlquilerVehiculo() {
		clientes = new Clientes();
		vehiculos = new Vechiculos();
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
	public void anadirVehiculo(Vehiculo vehiculo, TipoVehiculo tipoVehiculo) {
		vehiculos.anadir(vehiculo, tipoVehiculo);
	}

	
    @Override
	public void borrarTurismo(String matricula) {
		vehiculos.borrar(matricula);
	}
	
    @Override
	public Vehiculo buscarTurismo(String matricula) {
		return vehiculos.buscar(matricula);
	}
	
    @Override
	public Vehiculo[] obtenerTurismo() {
		return vehiculos.getTurismos();
	}
	
    @Override
	public void abrirAlquiler(Cliente cliente, Vehiculo turismo) {
		alquileres.openAlquiler(cliente, turismo);
	}
	
    @Override
	public void cerrarAlquiler(Cliente cliente, Vehiculo turismo) {
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
                Vehiculo vehiculo1 = TipoVehiculo.TURISMO.getInstancia("1111BBB", "Seat", "Ibiza", new DatosTecnicosVehiculo (1000, 5, 100));
                Vehiculo vehiculo2 = TipoVehiculo.TURISMO.getInstancia("2222CCC", "Opel", "Astra", new DatosTecnicosVehiculo (1100, 5, 200));
                Vehiculo vehiculo3 = TipoVehiculo.TURISMO.getInstancia("3333DDD", "Marca", "Modelo", new DatosTecnicosVehiculo (1200, 5, 300));
                anadirVehiculo(vehiculo1, TipoVehiculo.TURISMO);
                anadirVehiculo(vehiculo2, TipoVehiculo.DE_CARGA);
                anadirVehiculo(vehiculo3, TipoVehiculo.AUTOBUS);
}
}

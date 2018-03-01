/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo.dominio.vehiculo;

/**
 *
 * @author bogdan
 */
public class Autobus extends Vehiculo {

    public Autobus(Vehiculo vehiculo) {
        super(vehiculo);
    }

    @Override
    public TipoVehiculo getTipoVehiculo() {
        return TipoVehiculo.AUTOBUS;
    }

    @Override
    public double getPrecioEspecifico() {
        return getPrecioEspecifico() + FACTOR_CILINDRADA / 50 + 1 * FACTOR_NUMERO_PLAZAS;
    }
}

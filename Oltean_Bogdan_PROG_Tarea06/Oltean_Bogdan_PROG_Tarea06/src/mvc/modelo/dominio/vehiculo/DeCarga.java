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
public class DeCarga extends Vehiculo {

    public DeCarga(Vehiculo vehiculo) {
        super(vehiculo);
    }

    @Override
    public TipoVehiculo getTipoVehiculo() {
        return TipoVehiculo.DE_CARGA;
    }

    @Override
    public double getPrecioEspecifico() {
        return getPrecioEspecifico() + FACTOR_PMA / 20 + 1 * FACTOR_NUMERO_PLAZAS;
    }

}

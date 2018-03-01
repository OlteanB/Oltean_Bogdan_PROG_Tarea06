/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo.dominio.vehiculo;

import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 *
 * @author bogdan
 */
public enum TipoVehiculo {

    TURISMO("Vehiculo turismo") {
        public Vehiculo getInstancia(Vehiculo vehiculo) {
            return new Vehiculo(vehiculo);
        }
    },
    DE_CARGA("Vehiculo de carga") {
        public Vehiculo getInstancia(Vehiculo vehiculo) {
            return new Vehiculo(vehiculo);
        }
    },
    AUTOBUS("Vehiculo autobus") {
        public Vehiculo getInstancia(Vehiculo vehiculo) {
            return new Vehiculo(vehiculo);
        }
    };

    private String tipo;

    private TipoVehiculo(String tipo) {
        this.tipo = tipo;
    }

    public abstract Vehiculo getInstancia(Vehiculo vehiculo);

    public String toString() {
        return tipo;
    }

    public static TipoVehiculo getTipoVehiculoSegunOrdinal(int ordinal) {
        if (esOrdinalValido(ordinal)) {
            return values()[ordinal];
        } else {
            throw new ExcepcionAlquilerVehiculos("Ordinal no valido.");
        }
    }

    public static boolean esOrdinalValido(int ordinal) {
        return (ordinal >= 0 && ordinal <= values().length - 1);
    }
}

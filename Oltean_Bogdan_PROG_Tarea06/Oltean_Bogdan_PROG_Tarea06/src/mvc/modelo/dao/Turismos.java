/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo.dao;

import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.vehiculo.Vehiculo;

/**
 *
 * @author bogdan
 */
public class Turismos {

    private Vehiculo[] turismos;

    private final int MAX_TURISMOS = 20;

    public Turismos() {
        turismos = new Vehiculo[MAX_TURISMOS];
    }

    public void anadir(Vehiculo turismo) {
        int posicion=buscarPrimerIndiceLibreComprobandoExistencia(turismo);
        if (indiceNoSuperaTamano(posicion)) {
            turismos[posicion] = new Vehiculo(turismo);
        } else {
            throw new ExcepcionAlquilerVehiculos("El array de vehículos está lleno.");
        }
    }

    public Vehiculo[] getTurismos() {
        return turismos;
    }
    
    private int buscarPrimerIndiceLibreComprobandoExistencia(Vehiculo turismo){
        int posicion = 0;
        boolean posicionEncontrada = false;
        while (posicion < turismos.length && !posicionEncontrada) {
            if (turismos[posicion] == null) {
                posicionEncontrada = true;
            } else if (turismos[posicion].getMatricula().equals(turismo.getMatricula())) {
                throw new ExcepcionAlquilerVehiculos("Ya existe un vehículo con esa matrícula");
            } else {
                posicion++;
            }
        }
        return posicion;
    }

    private boolean indiceNoSuperaTamano(int posicion){
        return posicion<turismos.length;
    }
    
    public void borrar(String matricula) {
        int posicion=buscarIndiceVehiculo(matricula);
        if (indiceNoSuperaTamano(posicion)) {
            desplazarUnaPosicionHaciaIzquierda(posicion);
        } else {
            throw new ExcepcionAlquilerVehiculos("El vehículo a borrar no existe");
        }
    }
    
    private int buscarIndiceVehiculo(String matricula){
        int posicion = 0;
        boolean encontrado = false;
        while (posicion < turismos.length && !encontrado) {
            if (turismos[posicion] != null && turismos[posicion].getMatricula().equals(matricula)) {
                encontrado = true;
            } else {
                posicion++;
            }
        }
        if(encontrado){
            return posicion;
        }else{
            return turismos.length;
        }
    }
    
    private void desplazarUnaPosicionHaciaIzquierda(int posicion){
        for (int i = posicion; i < turismos.length - 1; i++) {
                turismos[i] = turismos[i + 1];
            }
            turismos[turismos.length - 1] = null;
    }
    
    public Vehiculo buscar(String matricula){
        int posicion = buscarIndiceVehiculo(matricula);
        if(indiceNoSuperaTamano(posicion))
            return new Vehiculo(turismos[posicion]);
        else
            return null;
    }
}

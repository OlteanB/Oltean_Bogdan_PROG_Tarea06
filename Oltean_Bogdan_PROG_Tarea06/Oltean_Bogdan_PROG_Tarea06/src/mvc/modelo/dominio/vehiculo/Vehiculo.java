/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo.dominio.vehiculo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 *
 * @author bogdan
 */
public class Vehiculo {

    private String matricula, marca, modelo;
    private boolean disponible;
    
    public final double FACTOR_CILINDRADA=0;
    public final double FACTOR_NUMERO_PLAZAS=0;
    public final double FACTOR_PMA=0;
    
    private DatosTecnicosVehiculo datosTecnicosVehiculo;

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Vehiculo(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicosVehiculo) {
        if (compruebaMatricula(matricula)) {
            this.matricula = matricula;
        } else {
            throw new ExcepcionAlquilerVehiculos("Error matricula.");
        }
        this.marca = marca;
        this.modelo = modelo;
        this.datosTecnicosVehiculo=datosTecnicosVehiculo;
    }

    public Vehiculo(Vehiculo vehiculo) {
        this.matricula = vehiculo.matricula;
        this.marca = vehiculo.marca;
        this.modelo = vehiculo.modelo;
        this.datosTecnicosVehiculo=vehiculo.datosTecnicosVehiculo;
    }

    private boolean compruebaMatricula(String matricula) {
        Pattern comprueba = Pattern.compile("^\\d{4}[A-Z]{3}");
        Matcher matcher = comprueba.matcher(matricula);
        return matcher.matches();
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public DatosTecnicosVehiculo getDatosTecnicos() {
        return datosTecnicosVehiculo;
    }

    

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", disponible=" + disponible + ", datosTecnicosVehiculo=" + datosTecnicosVehiculo + '}';
    }

    

}
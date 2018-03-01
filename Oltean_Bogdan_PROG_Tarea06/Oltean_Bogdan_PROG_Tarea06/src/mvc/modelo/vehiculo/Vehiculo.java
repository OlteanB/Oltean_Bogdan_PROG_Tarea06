/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo.vehiculo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 *
 * @author bogdan
 */
public class Vehiculo {

    private String matricula, marca, modelo;
    private int cilindrada;
    private boolean disponible;

    public Vehiculo(String matricula, String marca, String modelo, int cilindrada) {
        if (compruebaMatricula(matricula)) {
            this.matricula = matricula;
        } else {
            throw new ExcepcionAlquilerVehiculos("Error matricula.");
        }
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
    }

    public Vehiculo(Vehiculo vehiculo) {
        this.matricula = vehiculo.matricula;
        this.marca = vehiculo.marca;
        this.modelo = vehiculo.modelo;
        this.cilindrada = vehiculo.cilindrada;
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

    public int getCilindrada() {
        return cilindrada;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", cilindrada=" + cilindrada + ", disponible=" + disponible + '}';
    }

}

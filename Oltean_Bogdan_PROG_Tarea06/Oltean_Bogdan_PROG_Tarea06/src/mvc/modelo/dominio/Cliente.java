/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author bogdan
 */
public class Cliente {

    private String nombre, dni;
    private int identificador, numClientes;
    private DireccionPostal direccionPostal;

    public Cliente(String nombre, String DNI, DireccionPostal direccionPostal) {
        this.nombre = nombre;
        //DNI
        if (compruebaDni(DNI)) {
            this.dni = DNI;
        } else {
            throw new ExcepcionAlquilerVehiculos("Error DNI.");
        }
        //direccion postal
        setDireccionPostal(direccionPostal);

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    
    public void setDireccionPostal(DireccionPostal direccionPostal) {
        this.direccionPostal = direccionPostal;
    }

    public Cliente(Cliente cliente) {
        this.nombre = cliente.nombre;
        this.dni = cliente.dni;
        this.direccionPostal = cliente.direccionPostal;
    }

    private boolean compruebaDni(String DNI) {
        Pattern comprueba = Pattern.compile("\\d{8}[A-HJ-NP-TV-Z]");
        Matcher matcher = comprueba.matcher(DNI);
        return matcher.matches();
    }

    public DireccionPostal getDireccionPostal() {
        return direccionPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDNI() {
        return dni;
    }

    public int getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", dni=" + dni + ", identificador=" + identificador + ", direccionPostal=" + direccionPostal + '}';
    }


}

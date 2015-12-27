/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

/**
 *
 * @author matiascanodesarrollos
 */
public class Barrio {
    private int id;
    private String nombre;
    private int idCiudad;
    private int idObservacion;

    public Barrio(int id, String nombre, int idCiudad) {
        this.id = id;
        this.nombre = nombre;
        this.idCiudad = idCiudad;
    }
    
    
}

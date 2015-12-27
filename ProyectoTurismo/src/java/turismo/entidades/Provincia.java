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
public class Provincia {
    private int id;
    private String nombre;
    private int idPais;
    private String descripcion;

    public Provincia(int id, String nombre, int idPais) {
        this.id = id;
        this.nombre = nombre;
        this.idPais = idPais;
    }
    
    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"nombre\":\""+nombre+"\",\"idPais\":\""+idPais+"\",\"descripcion\":\""+descripcion+"\"}";    
    }
}

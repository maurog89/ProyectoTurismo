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
public class RegimenAlimentario {
    private int id;
    private String nombre;
    private String descripcion;

    public RegimenAlimentario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"nombre\":\""+nombre+"\",\"descripcion\":\""+descripcion+"\"}";    
    }
    
}

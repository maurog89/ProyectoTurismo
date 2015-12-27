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
public class Pais {
    private int id;
    private String Nombre;
    private String Descripcion;

    public Pais(int id, String Nombre) {
        this.id = id;
        this.Nombre = Nombre;
    }
    
    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"nombre\":\""+Nombre+"\",\"descripcion\":\""+Descripcion+"\"}";    
    }
}

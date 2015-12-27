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
public class Cliente {
    private int id;
    private String razonSocial;
    private String idObservacion;

    public Cliente(int id, String razonSocial) {
        this.id = id;
        this.razonSocial = razonSocial;
    }
    
    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"razonSocial\":\""+razonSocial+"\",\"idObservacion\":\""+idObservacion+"\"}";    
    }
    
}

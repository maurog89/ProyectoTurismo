/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.util.ArrayList;

/**
 *
 * @author matiascanodesarrollos
 */
public class Lugar extends ObjetoPuntuable{
    public String fechaAlta;
    public Cliente cliente;
    public ArrayList<Contacto> contactos;
    public Domicilio domicilio;
    public Estado estado;
    public ArrayList<Imagen> imagenes;
    
    //Constructor
    public Lugar(String fechaAlta, int cliente, int contacto, int domicilio, int estado, int imagen, int prioridad) {
        super(prioridad);
        this.fechaAlta = fechaAlta;
    }
    
    //Get y set

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    
    
    
}

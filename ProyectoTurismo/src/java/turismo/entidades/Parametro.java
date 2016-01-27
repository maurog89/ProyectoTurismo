/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author matiascanodesarrollos
 */
public abstract class Parametro {
    public int index;
    public String nombre;
    public String valorTextual = "abbasrdasfiohasfiafhsaisf";    
    public int valorNumerico;
    
    public Parametro(int index, String nombre) {
        this.index = index;
        this.nombre = nombre;
    }
    
    public abstract void asignarValor(HttpServletRequest request);
}

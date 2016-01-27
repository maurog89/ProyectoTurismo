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
public class ParametroTextual extends Parametro{
        
    public ParametroTextual(int index, String nombre) {
        super(index, nombre);
    }

    @Override
    public void asignarValor(HttpServletRequest request) {
        valorTextual = request.getParameter(nombre);
    }
    
}

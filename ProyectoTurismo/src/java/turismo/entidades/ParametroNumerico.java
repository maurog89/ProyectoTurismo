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
public class ParametroNumerico extends Parametro{

    public ParametroNumerico(int index, String nombre) {
        super(index, nombre);
    }

    @Override
    public void asignarValor(HttpServletRequest request) {
        valorNumerico = Integer.parseInt(request.getParameter(nombre));
    }
    
    
}

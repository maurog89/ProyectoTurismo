/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author matiascanodesarrollos
 */
public class ValidadorDeSession {
    public static boolean validarSession(HttpServletRequest request){
        HttpSession sesion = request.getSession();
        Boolean aut = (Boolean)sesion.getAttribute("autentificado");
        if(aut != null){
            return aut;
        }
        sesion.invalidate();
        return false;        
    }
}

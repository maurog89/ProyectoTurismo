/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author matiascanodesarrollos
 */
public class Fechas  implements InterfazDeBusqueda {
    
    public static String fechaActual(){
        Date fechaActual = new Date(); 
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
        return formato.format(fechaActual);
}

    
    @Override
    public void borrarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSON() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

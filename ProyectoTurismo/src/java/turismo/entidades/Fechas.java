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
public class Fechas {
    
    public static String fechaActual(){
        Date fechaActual = new Date(); 
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
        return formato.format(fechaActual);
}
}

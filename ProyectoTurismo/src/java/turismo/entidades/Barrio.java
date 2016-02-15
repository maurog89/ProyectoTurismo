/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import turismo.conexion.Conexion;

/**
 *
 * @author matiascanodesarrollos
 */
public class Barrio implements InterfazDeBusqueda{
    private int id;
    private final String nombre;
    private Ciudad idCiudad;
    private Observacion idObservacion;

    public Barrio(int id, String nombre, int idCiudad) {
        this.id = id;
        this.nombre = nombre;
    }
    
    

    public Barrio(String nombre, int idCiudad,int idObservacion) throws SQLException {        
        this.nombre = nombre;
        Conexion con = new Conexion();
        ResultSet rss = con.getSql().executeQuery("CALL Turismo.cargaBarrio('" + nombre + "',"+ idCiudad + ","+idObservacion+")");
        rss.next();
        this.id = rss.getInt("LAST_INSERT_ID()");
        con.cerrarConexion();
    }
    
    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"nombre\":\""+nombre+"\",\"idCiudad\":\""+idCiudad+"\",\"idObservacion\":\""+idObservacion+"\"}";    
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

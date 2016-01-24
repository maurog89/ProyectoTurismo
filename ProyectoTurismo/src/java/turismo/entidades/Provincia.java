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
public class Provincia {
    private int id;
    private final String nombre;
    private final int idPais;
    private String descripcion;

    public Provincia(int id, String nombre, int idPais) {
        this.id = id;
        this.nombre = nombre;
        this.idPais = idPais;
    }
    
    public Provincia(String nombre, int idPais, String descripcion) throws SQLException {        
        this.nombre = nombre;
        this.idPais = idPais;
        this.descripcion = descripcion;
        Conexion con = new Conexion();
        ResultSet rss = con.getSql().executeQuery("CALL Turismo.cargaProvinciaConDescripcion('" + nombre + "'," + idPais + ",'" + descripcion + "')");
        rss.next();
        this.id = rss.getInt("LAST_INSERT_ID()");
        con.cerrarConexion();
      
    }
    
    public Provincia(String nombre, int idPais) throws SQLException {        
        this.nombre = nombre;
        this.idPais = idPais;
        Conexion con = new Conexion();
        ResultSet rss = con.getSql().executeQuery("CALL Turismo.cargaProvinciaSinDescripcion('" + nombre + "'," + idPais +")" );
        rss.next();
        this.id = rss.getInt("LAST_INSERT_ID()");
        con.cerrarConexion();
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"nombre\":\""+nombre+"\",\"idPais\":\""+idPais+"\",\"descripcion\":\""+descripcion+"\"}";    
    }
}

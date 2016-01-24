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
public class TipoDocumento {
    private int id;
    private String Nombre;

    public TipoDocumento(int id, String Nombre) {
        this.id = id;
        this.Nombre = Nombre;
    }

    public TipoDocumento(String Nombre) throws SQLException {
        this.Nombre = Nombre;
        Conexion con = new Conexion();
        ResultSet rss = con.getSql().executeQuery("CALL Turismo.cargaTipoDocumento('" + Nombre + "')");
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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"nombre\":\""+Nombre+"\"}";    
    }
}

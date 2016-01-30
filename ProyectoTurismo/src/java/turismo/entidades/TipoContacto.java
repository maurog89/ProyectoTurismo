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
public class TipoContacto {
    private int id;
    private String Nombre;
    private int idObservacion;

    public TipoContacto(int id, String Nombre) {
        this.id = id;
        this.Nombre = Nombre;
    }

    public TipoContacto(String Nombre, int idObservacion) throws SQLException {
        this.Nombre = Nombre;
        this.idObservacion = idObservacion;
        Conexion con = new Conexion();
        con.getSql().execute("INSERT INTO Turismo.TipoContacto (Nombre,IdObservacion) values ('" + Nombre + "'," + idObservacion + ")");
        con.cerrarConexion();
    }
    
    
    
    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"nombre\":\""+Nombre+"\",\"idObservacion\":\""+idObservacion+"\"}";    
    }
}

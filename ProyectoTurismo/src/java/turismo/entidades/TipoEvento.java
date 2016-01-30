/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.sql.SQLException;
import turismo.conexion.Conexion;

/**
 *
 * @author matiascanodesarrollos
 */
public class TipoEvento {
    private int id;
    private String nombre,descripcion;

    public TipoEvento(String nombre, String descripcion) throws SQLException {
        this.nombre = nombre;
        this.descripcion = descripcion;
        Conexion con = new Conexion();
        con.getSql().execute("INSERT INTO Turismo.TipoEvento (nombre,descripcion) values('" + nombre + "','" + descripcion + "')");
        con.cerrarConexion();
    }
    
    
}

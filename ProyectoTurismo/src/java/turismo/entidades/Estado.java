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
public class Estado {
    private int id;
    private String nombre;
    private String descripcion;
    
    //Constructor

    public Estado(String nombre, String descripcion, String opcionales) throws SQLException {
        this.nombre = nombre;
        this.descripcion = descripcion;
        Conexion con = new Conexion();
        if(opcionales.equals("Completa"))
            con.getSql().executeUpdate("INSERT INTO Turismo.Estado (nombre,descripcion) values ('" + nombre + "','" + descripcion + "')");
        if(opcionales.equals("Minimo"))
            con.getSql().executeUpdate("INSERT INTO Turismo.Estado (nombre) values ('" + nombre + "')");
        con.cerrarConexion();
    }
    
}

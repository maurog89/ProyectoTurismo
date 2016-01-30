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
public class Temporada {
    private int id;
    private String nombre;
    private String descripcion;
    
    //Constructor

    public Temporada(String nombre, String descripcion, String opcionales) throws SQLException {
        this.nombre = nombre;
        this.descripcion = descripcion;        
        Conexion con = new Conexion();
        if(opcionales.equals("Completa"))
            con.getSql().executeUpdate("INSERT INTO Turismo.Temporada (nombre,descripcion) values ('" + nombre + "','" + descripcion + "')");
        if(opcionales.equals("Minimo"))
            con.getSql().executeUpdate("INSERT INTO Turismo.Temporada (nombre) values ('" + nombre + "')");
        con.cerrarConexion();
    }

    public Temporada(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Temporada(String nombre, String descripcion) throws SQLException {
        this.nombre = nombre;
        this.descripcion = descripcion;
        Conexion con = new Conexion();
        con.getSql().execute("INSERT INTO Turismo.Temporada (nombre,descripcion) values('" + nombre + "','" + descripcion + "')");
        con.cerrarConexion();
    }
    
    
    
    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"nombre\":\""+nombre+"\",\"descripcion\":\""+descripcion+"\"}";    
    }
}

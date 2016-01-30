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
public class CategoriaRestaurante {
    private int id, cantidadDeTenedores;
    private String nombre,descripcion;

    public CategoriaRestaurante(int cantidadDeTenedores, String descripcion, String nombre) throws SQLException {
        this.cantidadDeTenedores = cantidadDeTenedores;
        this.descripcion = descripcion;
        this.nombre = nombre;
        Conexion con = new Conexion();
        con.getSql().execute("INSERT INTO Turismo.CategoriaRestaurante (nombre,cantidadDeTenedores,descripcion) values('" + nombre + "'," + cantidadDeTenedores + ",'" + descripcion + "')");
        con.cerrarConexion();
    }
    
    
}

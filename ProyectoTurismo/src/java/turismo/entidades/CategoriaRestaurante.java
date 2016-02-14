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
public class CategoriaRestaurante implements InterfazDeBusqueda{
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

    public CategoriaRestaurante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"nombre\":\""+nombre+"\"}";    
    }

    @Override
    public void modifarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSON() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

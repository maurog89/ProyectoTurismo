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
public class Estado  implements InterfazDeBusqueda{
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

    public Estado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"nombre\":\""+nombre+"\",\"descripcion\":\""+descripcion+"\"}";    
    }

    @Override
    public void modifarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     
    
}

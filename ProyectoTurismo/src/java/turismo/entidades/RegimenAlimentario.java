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
public class RegimenAlimentario  implements InterfazDeBusqueda {
    private int id;
    private String nombre;
    private String descripcion;

    public RegimenAlimentario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public RegimenAlimentario(String nombre, String descripcion) throws SQLException {
        this.nombre = nombre;
        this.descripcion = descripcion;
        Conexion con = new Conexion();
        con.getSql().execute("INSERT INTO Turismo.RegimenAlimentario (nombre,descripcion) values('" + nombre + "','" + descripcion + "')");
        con.cerrarConexion();
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

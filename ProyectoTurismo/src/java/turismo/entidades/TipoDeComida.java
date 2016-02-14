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
public class TipoDeComida  implements InterfazDeBusqueda{
    private int id;
    private String nombre;

    public TipoDeComida(String nombre) throws SQLException {
        this.nombre = nombre;
        Conexion con = new Conexion();
        con.getSql().execute("INSERT INTO Turismo.TipoDeComida (nombre) values('" + nombre + "')");
        con.cerrarConexion();
    }

    public TipoDeComida(int id, String nombre) {
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
}

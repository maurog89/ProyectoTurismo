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
public class TipoFactura {
    private int id;
    private final String nombre;

    public TipoFactura(String nombre) throws SQLException {
        this.nombre = nombre;
        Conexion con = new Conexion();
        con.getSql().execute("INSERT INTO Turismo.TipoFactura (tipoObjeto) values('" + nombre + "')");
        con.cerrarConexion();
    }
    
    
}

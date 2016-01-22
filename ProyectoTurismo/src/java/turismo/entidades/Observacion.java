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
public class Observacion {
    private int id;
    private String observacion;

    public Observacion(String observacion) throws SQLException {
        this.observacion = observacion;
        Conexion con = new Conexion();
        ResultSet rss = con.getSql().executeQuery("CALL Turismo.cargaObservacion('" + observacion + "')");
        rss.next();
        this.id = rss.getInt("LAST_INSERT_ID()");
        con.cerrarConexion();
    }
    
    

    public int getId() {
        return id;
    }
}

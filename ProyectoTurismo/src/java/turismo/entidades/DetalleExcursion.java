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
public class DetalleExcursion {
    private int id,lugarDeInteres,Excursion;
    private String fecha,duracion;

    public DetalleExcursion(int lugarDeInteres, int Excursion, String fecha, String duracion) throws SQLException {
        this.lugarDeInteres = lugarDeInteres;
        this.Excursion = Excursion;
        this.fecha = fecha;
        this.duracion = duracion;
        Conexion con = new Conexion();
        con.getSql().execute("INSERT INTO Turismo.DetalleExcursion (idLugarDeInteres,Fecha,duracion,idExcursion) values(" + lugarDeInteres + ",'" + fecha + "','" + duracion + "'," + Excursion + ")");
        con.cerrarConexion();
    }
    
    
}
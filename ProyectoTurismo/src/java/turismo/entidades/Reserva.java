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
public class Reserva {
    private int id;
    private int usuario;
    private String fecha;
    private int objeto;
    
    //Constructor

    public Reserva(int usuario, String fecha, int objeto) throws SQLException {
        this.usuario = usuario;
        this.fecha = fecha;
        this.objeto = objeto;
        Conexion con = new Conexion();
        con.getSql().executeUpdate("INSERT INTO Turismo.Reserva (idUsuario,fechaReserva,idObjetoPuntuable) values ('" + usuario + "','" + fecha + "','" + objeto + "')");
        con.cerrarConexion();
    }
    
}
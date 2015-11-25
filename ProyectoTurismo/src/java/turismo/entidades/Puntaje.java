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
public class Puntaje {
    private int id;
    private int putaje;
    private int usuario;
    private int objeto;
    private String comentario;

    public Puntaje(int putaje, int usuario, int objeto, String comentario,String opcionales) throws SQLException {
        this.putaje = putaje;
        this.usuario = usuario;
        this.objeto = objeto;
        this.comentario = comentario;
        Conexion con = new Conexion();
        if(opcionales.equals("Completa"))
            con.getSql().executeUpdate("INSERT INTO Turismo.Puntaje (putaje,idUsuario,idObjetoPuntuable,comentario) values ('" + putaje +"','" + usuario + "','" + objeto + "','" + comentario + "')");
        if(opcionales.equals("SinComentario"))
            con.getSql().executeUpdate("INSERT INTO Turismo.Puntaje (putaje,idUsuario,idObjetoPuntuable) values ('" + putaje +"','" + usuario + "','" + objeto + "')");        
        con.getSql().executeUpdate("UPDATE Turismo.ObjetoPuntuable SET puntajeTotal = puntajeTotal + " + putaje + ", cantidadVeces = cantidadVeces + 1 WHERE idObjetoPuntuable = " + objeto);
        con.cerrarConexion();
    }
    
    
}

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
public class Puntaje  implements InterfazDeBusqueda {
    private int id;
    private int putaje;
    private Usuario usuario;
    private ObjetoPuntuable objeto;
    private String comentario;

    public Puntaje(int putaje, int usuario, int objeto, String comentario,String opcionales) throws SQLException {
        Conexion con = new Conexion();
        con.getSql().executeUpdate("INSERT INTO Turismo.Puntaje (putaje,idUsuario,idObjetoPuntuable,comentario) values ('" + putaje +"','" + usuario + "','" + objeto + "','" + comentario + "')");
        con.getSql().executeUpdate("UPDATE Turismo.ObjetoPuntuable SET puntajeTotal = puntajeTotal + " + putaje + ", cantidadVeces = cantidadVeces + 1 WHERE idObjetoPuntuable = " + objeto);
        con.cerrarConexion();
    }

    @Override
    public void modificarRegistroBD() {
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

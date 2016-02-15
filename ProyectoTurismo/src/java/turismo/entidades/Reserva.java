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
public class Reserva  implements InterfazDeBusqueda{
    private int id;
    private Usuario usuario;
    private String fecha;
    private ObjetoPuntuable objeto;
    
    //Constructor

    public Reserva(int usuario, String fecha, int objeto) throws SQLException {
        Conexion con = new Conexion();
        con.getSql().executeUpdate("INSERT INTO Turismo.Reserva (idUsuario,fechaReserva,idObjetoPuntuable) values ('" + usuario + "','" + fecha + "','" + objeto + "')");
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

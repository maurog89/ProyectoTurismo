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
public class Contacto implements InterfazDeBusqueda {

    private int id;
    private Estado estado;
    private String Detalle;
    private TipoContacto tipo;
    private int contactoAnterior;

    public Contacto(String Detalle, int tipo) throws SQLException {
        this.Detalle = Detalle;
        Conexion con = new Conexion();
        ResultSet rs = con.getSql().executeQuery("CALL Turismo.cargaContactoMinimo(" + tipo + ",'" + Detalle + "')");
        rs.next();
        this.id = rs.getInt("LAST_INSERT_ID()");
        con.cerrarConexion();
    }

    public Contacto(int estado, String Detalle, int tipo) throws SQLException {
        this.Detalle = Detalle;
        Conexion con = new Conexion();
        ResultSet rs = con.getSql().executeQuery("CALL Turismo.cargaContacto(" + tipo + ",'" + Detalle + "'," + tipo + ")");
        rs.next();
        this.id = rs.getInt("LAST_INSERT_ID()");
        con.cerrarConexion();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContactoAnterior() {
        return contactoAnterior;
    }

    public void setContactoAnterior(int contactoAnterior) {
        this.contactoAnterior = contactoAnterior;
    }
    
    

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    @Override
    public void borrarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSON() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

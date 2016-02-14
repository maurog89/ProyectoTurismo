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
public class Contacto implements InterfazDeBusqueda{
    private int id;
    private int estado;
    private String Detalle;
    private int tipo;
    private int contactoAnterior;

    public Contacto(String Detalle, int tipo) throws SQLException {
        this.Detalle = Detalle;
        this.tipo = tipo;
        Conexion con = new Conexion();
        ResultSet rs = con.getSql().executeQuery("CALL Turismo.cargaContactoMinimo(" + tipo + ",'" + Detalle + "')");
        rs.next();
        this.id = rs.getInt("LAST_INSERT_ID()");
        con.cerrarConexion();
    }

    public Contacto(int estado, String Detalle, int tipo) throws SQLException {
        this.estado = estado;
        this.Detalle = Detalle;
        this.tipo = tipo;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getContactoAnterior() {
        return contactoAnterior;
    }

    public void setContactoAnterior(int contactoAnterior) throws SQLException {
        this.contactoAnterior = contactoAnterior;
        Conexion con = new Conexion();
        con.getSql().execute("UPDATE Turismo.Contacto SET idContactoAnterior = " + contactoAnterior + " WHERE idContacto = " + id);
    }

    @Override
    public void modifarRegistroBD() {
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

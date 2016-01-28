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
public class Cliente extends Persona{
    private int id;
    private String razonSocial;
    private int idObservacion;

    public Cliente(int id, String razonSocial) {
        this.id = id;
        this.razonSocial = razonSocial;
    }

    public Cliente(String razonSocial, String nombre, String segundoNombre, String apellido, String fechaNacimiento, String nroDocumento, int idTipoDocumento, int idContacto, int idEstado, int idObservacion, int idDomicilio, String fechaCreacion) throws SQLException {
        super(nombre, segundoNombre, apellido, fechaCreacion, fechaNacimiento, nroDocumento, idTipoDocumento, idContacto, idDomicilio, idEstado);
        Conexion con = new Conexion();
        ResultSet rs = con.getSql().executeQuery("CALL Turismo.cargaPersona('" + nombre + "','" + segundoNombre+ "','" + apellido + "','" + fechaCreacion + "','" + fechaNacimiento + "'," + idTipoDocumento + ",'" + nroDocumento + "'," + idContacto + "," + idDomicilio + "," + idEstado + ")");
        rs.next(); 
        this.idPersona = rs.getInt("LAST_INSERT_ID()");
        this.razonSocial = razonSocial;
        this.idObservacion = idObservacion;        
        ResultSet rss = con.getSql().executeQuery("CALL Turismo.cargaCliente('" + razonSocial + "',"+ this.idPersona + ","+idObservacion+")");
        rss.next();
        this.id = rss.getInt("LAST_INSERT_ID()");
        con.cerrarConexion();
    }

    
    
    
    
    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"razonSocial\":\""+razonSocial+"\",\"idObservacion\":\""+idObservacion+"\"}";    
    }
    
}

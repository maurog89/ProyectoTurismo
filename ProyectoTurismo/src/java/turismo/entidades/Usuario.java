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
public class Usuario extends Persona implements InterfazDeBusqueda{
    private int id,observacion;
    private String nombreUsuario,password,link,preguntaSecreta,respuesta;

    public Usuario(int id, String nombreUsuario) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
    }

    public Usuario(int observacion, int idTipoDocumento, int idContacto, int idDomicilio, int idEstado, String nombreUsuario, String password, String link, String preguntaSecreta, String respuesta, String nombre, String segundoNombre, String apellido, String fechaNacimiento, String nroDocumento, String fechaCreacion) throws SQLException {
        super(nombre, segundoNombre, apellido, fechaCreacion, fechaNacimiento, nroDocumento, idTipoDocumento, idContacto, idDomicilio, idEstado);
        Conexion con = new Conexion();
        ResultSet rs = con.getSql().executeQuery("CALL Turismo.cargaPersona('" + nombre + "','" + segundoNombre+ "','" + apellido + "','" + fechaCreacion + "','" + fechaNacimiento + "'," + idTipoDocumento + ",'" + nroDocumento + "'," + idContacto + "," + idDomicilio + "," + idEstado + ")");
        rs.next(); 
        this.idPersona = rs.getInt("LAST_INSERT_ID()");
        this.observacion = observacion;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.link = link;
        this.preguntaSecreta = preguntaSecreta;
        this.respuesta = respuesta;
        con.getSql().execute("INSERT INTO Turismo.Usuario (nombre,pasword,link,idObservacion,idPersona,preguntaSecreta,respuesta) values('" + nombreUsuario + "','" + password + "','" + link + "'," + observacion + "," + this.idPersona + ",'" + preguntaSecreta + "','" + respuesta + "')");
        con.cerrarConexion();
    }
    
    
    
    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"nombre\":\""+nombreUsuario+"\"}";    
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

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
public class Permiso  implements InterfazDeBusqueda{
    private int id;
    private TipoPermiso tipoPermiso;
    private Usuario usuario;
    private String descripcion;

    public Permiso(int idTipoPermiso, int idUsuario, String descripcion) throws SQLException {
        Conexion con = new Conexion();
        con.getSql().execute("INSERT INTO Turismo.Permisos (idTipoPermiso,descripcion,idUsuario) values (" + idTipoPermiso + ",'" + descripcion + "'," + idUsuario + ")");
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

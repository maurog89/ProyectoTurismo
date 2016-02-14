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
public class EmpresaTransporte  implements InterfazDeBusqueda{
    private int id,contacto,imagen;
    private String razonSocial;

    public EmpresaTransporte(int contacto, int imagen, String razonSocial) throws SQLException {
        this.contacto = contacto;
        this.imagen = imagen;
        this.razonSocial = razonSocial;
        Conexion con = new Conexion();
        con.getSql().execute("INSERT INTO Turismo.EmpresaTransporte (RazonSocial,IdContacto,IdImagen) values('" + razonSocial + "'," + contacto + "," + imagen + ")");
        con.cerrarConexion();
    }

    public EmpresaTransporte(int id, String razonSocial) {
        this.id = id;
        this.razonSocial = razonSocial;
    }
    
    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"nombre\":\""+razonSocial+"\"}";    
    }

    @Override
    public void modifarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

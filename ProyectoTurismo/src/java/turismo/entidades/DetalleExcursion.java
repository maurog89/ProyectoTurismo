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
public class DetalleExcursion  implements InterfazDeBusqueda{
    private int id;
    private LugarDeInteres lugarDeInteres;
    private Excursion excursion;
    private String fecha,duracion;

    public DetalleExcursion(int lugarDeInteres, int Excursion, String fecha, String duracion) throws SQLException {
        Conexion con = new Conexion();
        con.getSql().execute("INSERT INTO Turismo.DetalleExcursion (idLugarDeInteres,Fecha,duracion,idExcursion) values(" + lugarDeInteres + ",'" + fecha + "','" + duracion + "'," + Excursion + ")");
        con.cerrarConexion();
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

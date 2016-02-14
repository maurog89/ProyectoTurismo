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
public class Mapa  implements InterfazDeBusqueda{
    private int id,observacion;
    private float longitud,latitud;

    public Mapa(int observacion, float longitud, float latitud) throws SQLException {
        this.observacion = observacion;
        this.longitud = longitud;
        this.latitud = latitud;
        Conexion con = new Conexion();
        con.getSql().execute("INSERT INTO Turismo.Mapa (longitud,latitud,idObservacion) values(" + longitud + "," + latitud + "," + observacion + ")");
        con.cerrarConexion();
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

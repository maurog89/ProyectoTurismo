/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.sql.SQLException;

/**
 *
 * @author matiascanodesarrollos
 */
public class Visita extends ObjetoPuntuable  implements InterfazDeBusqueda{
    private int id;
    private String fecha;
    private String hora;
    private String fechaCarga;
    private int viaje;
    private int estado;
    
    //Constructor

    public Visita(String fecha, String hora, String fechaCarga, int viaje, int estado) throws SQLException {
        this.fecha = fecha;
        this.hora = hora;
        this.fechaCarga = fechaCarga;
        this.viaje = viaje;
        this.estado = estado;
        generarObjetoParaBD();
        getCon().getSql().executeUpdate("INSERT INTO Turismo.Visita (fecha,hora,fechaCarga,IdViaje,IdEstado,idObjetoPuntuable) values ('" + fecha +"','" + hora + "','" + fechaCarga + "','" + viaje + "','" + estado + getIdObjeto()+"')");
        cerrarConexion();
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

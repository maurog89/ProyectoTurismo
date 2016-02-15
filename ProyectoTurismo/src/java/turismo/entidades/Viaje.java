/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author matiascanodesarrollos
 */
public class Viaje extends ObjetoPuntuable implements InterfazDeBusqueda{
    private int id;
    private float PrecioFinalAprox;
    private String Comentarios;
    private String FechaAlta;
    private String FechaDesde;
    private String FechaHasta;
    private ArrayList<Alojamiento> alojamientos;
    private ArrayList<Ciudad> ciudades;
    private Estado estado;
    private Usuario usuario;
    
    // Constructor para cargar viaje con todos los datos 
    public Viaje(String PrecioFinalAprox, String Comentarios, String FechaAlta, String FechaDesde, String FechaHasta, int alojamiento, int ciudad, int estado, int usuario,String opcionales) throws SQLException {
        generarObjetoParaBD();
        if(opcionales.equals("Completo"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Viaje (PrecioFinalAprox,Comentarios,FechaAlta,FechaDesde,FechaHasta,IdAlojamiento,IdCuidad,IdEstado,IdUsuario,idObjetoPuntuable) values ('" + PrecioFinalAprox +"','" + Comentarios + "','" + FechaAlta +"','" + FechaDesde + "','" + FechaHasta + "','" + alojamiento + "','" + ciudad + "','" + estado + "','" + usuario + "','" + getIdObjeto()+"')");
        if(opcionales.equals("SinComentarios"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Viaje (PrecioFinalAprox,FechaAlta,FechaDesde,FechaHasta,IdAlojamiento,IdCuidad,IdEstado,IdUsuario,idObjetoPuntuable) values ('" + PrecioFinalAprox + "','" + FechaAlta +"','" + FechaDesde + "','" + FechaHasta + "','" + alojamiento + "','" + ciudad + "','" + estado + "','" + usuario + "','" + getIdObjeto()+"')");
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

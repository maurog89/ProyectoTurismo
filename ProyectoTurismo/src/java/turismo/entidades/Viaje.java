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
public class Viaje extends ObjetoPuntuable{
    private int id;
    private float PrecioFinalAprox;
    private String Comentarios;
    private String FechaAlta;
    private String FechaDesde;
    private String FechaHasta;
    private int alojamiento;
    private int ciudad;
    private int estado;
    private int usuario;
    
    // Constructor para cargar viaje con todos los datos 
    public Viaje(String PrecioFinalAprox, String Comentarios, String FechaAlta, String FechaDesde, String FechaHasta, int alojamiento, int ciudad, int estado, int usuario,String opcionales) throws SQLException {
        this.PrecioFinalAprox = Float.parseFloat(PrecioFinalAprox);
        this.Comentarios = Comentarios;
        this.FechaAlta = FechaAlta;
        this.FechaDesde = FechaDesde;
        this.FechaHasta = FechaHasta;
        this.alojamiento = alojamiento;
        this.ciudad = ciudad;
        this.estado = estado;
        this.usuario = usuario;
        generarObjetoParaBD();
        if(opcionales.equals("Completo"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Viaje (PrecioFinalAprox,Comentarios,FechaAlta,FechaDesde,FechaHasta,IdAlojamiento,IdCuidad,IdEstado,IdUsuario,idObjetoPuntuable) values ('" + PrecioFinalAprox +"','" + Comentarios + "','" + FechaAlta +"','" + FechaDesde + "','" + FechaHasta + "','" + alojamiento + "','" + ciudad + "','" + estado + "','" + usuario + "','" + getIdObjeto()+"')");
        if(opcionales.equals("SinComentarios"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Viaje (PrecioFinalAprox,FechaAlta,FechaDesde,FechaHasta,IdAlojamiento,IdCuidad,IdEstado,IdUsuario,idObjetoPuntuable) values ('" + PrecioFinalAprox + "','" + FechaAlta +"','" + FechaDesde + "','" + FechaHasta + "','" + alojamiento + "','" + ciudad + "','" + estado + "','" + usuario + "','" + getIdObjeto()+"')");
        cerrarConexion();
    }
    
    
}

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
public class Habitacion extends ObjetoPuntuable  implements InterfazDeBusqueda{
    private int id;
    private String descripcion;
    private String precio;
    private ArrayList<Imagen> imagen;
    private TipoHabitacion tipoHabitacion;
    private Alojamiento alojamiento;
    private Estado estado;
    private String fechaAlta;

        
    //Constructor con descripcion

    public Habitacion(String descripcion, String precio, int imagen, int tipoHabitacion, int alojamiento, int estado, int prioridad, String fechaAlta) throws SQLException {
        super(prioridad);
        generarObjetoParaBD();
        getCon().getSql().executeUpdate("INSERT INTO Turismo.Habitacion (descripcion,precio,idImagen,IdTipoHabitacion,idAlojamiento,idEstado,fechaAlta,idObjetoPuntuable) values ('" + descripcion + "','" + precio +"','" + imagen + "','" + tipoHabitacion +"','" + alojamiento + "','" + estado + "','" + fechaAlta + "','" + getIdObjeto()+"')");
        cerrarConexion();
    }
    
    // Gets y Sets

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }


    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
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

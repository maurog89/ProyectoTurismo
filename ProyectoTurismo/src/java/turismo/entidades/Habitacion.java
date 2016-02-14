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
public class Habitacion extends ObjetoPuntuable  implements InterfazDeBusqueda{
    private int id;
    private String descripcion;
    private String precio;
    private int imagen;
    private int tipoHabitacion;
    private int alojamiento;
    private int estado;
    private String fechaAlta;

        
    //Constructor con descripcion

    public Habitacion(String descripcion, String precio, int imagen, int tipoHabitacion, int alojamiento, int estado, int prioridad, String fechaAlta) throws SQLException {
        super(prioridad);
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.tipoHabitacion = tipoHabitacion;
        this.alojamiento = alojamiento;
        this.estado = estado;
        this.fechaAlta = fechaAlta;
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

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(int tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(int alojamiento) {
        this.alojamiento = alojamiento;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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

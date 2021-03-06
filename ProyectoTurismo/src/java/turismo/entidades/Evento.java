/*
 * Clase para manejar eventos
 */
package turismo.entidades;

import java.sql.SQLException;

/**
 *
 * @author matiascanodesarrollos
 */
public class Evento extends Lugar  implements InterfazDeBusqueda{
    public int id;
    public String titulo;
    public String descripcion;
    public String precio;
    public String fechaInicio;
    public String fechaFin;
    public TipoEvento tipoEvento;
    
    
    
    //Constructor con descripcion
    
    public Evento(int cliente, int contacto, int domicilio, int estado, int imagen, int tipoEvento, int prioridad,String titulo, String descripcion , String precio, String fechaInicio, String fechaFin, String fechaAlta) throws SQLException {
        super(fechaAlta,cliente,contacto,domicilio,estado,imagen,prioridad);
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        generarObjetoParaBD();
        getCon().getSql().executeUpdate("INSERT INTO Turismo.Evento (titulo,descripcion,precio,fechaAlta,fechaInicio,fechaFin,IdCliente,IdContacto,IdDomicilio,IdEstado,IdImagen,IdTipoEvento,idObjetoPuntuable) values ('" + titulo +"','" + descripcion + "','" + precio + "','" + fechaAlta +"','" + fechaInicio + "','" + fechaFin + "','" + cliente + "','" + contacto + "','" + domicilio +"','" + estado +  "','" + imagen + "','" + tipoEvento + "','" + getIdObjeto()+"')");
        cerrarConexion();
    }
    
    //Get y set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
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

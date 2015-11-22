/*
 * Clase para manejar eventos
 */
package turismo.entidades;

import java.sql.SQLException;

/**
 *
 * @author matiascanodesarrollos
 */
public class Evento extends Lugar {
    public int id;
    public String titulo;
    public String descripcion;
    public String precio;
    public String fechaInicio;
    public String fechaFin;
    public int tipoEvento;
    
    //Constructor minimo
    
    public Evento(String titulo, String precio, String fechaAlta, String fechaInicio, String fechaFin, int cliente, int contacto, int domicilio, int estado, int imagen, int tipoEvento, int prioridad) throws SQLException {
        super(fechaAlta,cliente,contacto,domicilio,estado,imagen,prioridad);
        this.titulo = titulo;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoEvento = tipoEvento;
        generarObjetoParaBD();
        getCon().getSql().executeUpdate("INSERT INTO Turismo.Evento (titulo,precio,fechaAlta,fechaInicio,fechaFin,IdCliente,IdContacto,IdDomicilio,IdEstado,IdImagen,IdTipoEvento,idObjetoPuntuable) values ('" + titulo +"','" + precio + "','" + fechaAlta +"','" + fechaInicio + "','" + fechaFin + "','" + cliente + "','" + contacto + "','" + domicilio +"','" + estado +  "','" + imagen + "','" + tipoEvento + "','" + getIdObjeto()+"')");
        cerrarConexion();
    }
    
    //Constructor con descripcion
    
    public Evento(String titulo, String descripcion , String precio, String fechaAlta, String fechaInicio, String fechaFin, int cliente, int contacto, int domicilio, int estado, int imagen, int tipoEvento, int prioridad) throws SQLException {
        super(fechaAlta,cliente,contacto,domicilio,estado,imagen,prioridad);
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoEvento = tipoEvento;
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

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public int getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(int domicilio) {
        this.domicilio = domicilio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(int tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
    
    
}

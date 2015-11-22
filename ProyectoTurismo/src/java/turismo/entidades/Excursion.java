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
public class Excursion extends Lugar{
    public int id;
    public String nombre;    
    public String detalle;    
    public String precio;
    public String fechaInicio;
    public String fechaFin;
    public String ano;
    public String personas;
    public int temporada;
    
    // Costructor
    public Excursion(String nombre, String detalle, String precio, String fechaInicio, String fechaFin, String ano, String personas, int temporada, String fechaAlta, int cliente, int contacto, int domicilio, int estado, int imagen, int prioridad) throws SQLException {
        super(fechaAlta, cliente, contacto, domicilio, estado, imagen, prioridad);
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ano = ano;
        this.personas = personas;
        this.temporada = temporada;
        generarObjetoParaBD();
        getCon().getSql().executeUpdate("INSERT INTO Turismo.Excursion (nombre,detalle,precio,inicioPeriodo,finPeriodo,año,cantidadVisitantes,idDomicilio,idEstado,idImagen,idTemporada,idContacto,fechaAlta,idObjetoPuntuable) values ('" + nombre +"','" + detalle + "','" + precio +"','" + fechaInicio + "','" + fechaFin + "','" + ano + "','" + personas + "','" + domicilio +"','" + estado +  "','" + imagen + "','" + temporada + "','" + contacto + "','" + fechaAlta + "','" + getIdObjeto()+"')");
        cerrarConexion();
    }
    
    // Get y Set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
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

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPersonas() {
        return personas;
    }

    public void setPersonas(String personas) {
        this.personas = personas;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }
    
    
    
}

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
public class Excursion extends Lugar  implements InterfazDeBusqueda{
    public int id;
    public String nombre,detalle,fechaInicio,fechaFin,ano,personas,precio;    
    public Temporada temporada;
    
    // Costructor
    public Excursion(String nombre, String detalle, String precio, String fechaInicio, String fechaFin, String ano, String personas, int temporada, int cliente, int contacto, int estado, int imagen, int prioridad, int domicilio, String fechaAlta) throws SQLException {
        super(fechaAlta, cliente, contacto, domicilio, estado, imagen, prioridad);
        generarObjetoParaBD();
        getCon().getSql().execute("INSERT INTO Turismo.Excursion (nombre,detalle,inicioPeriodo,finPeriodo,año,cantidadVisitantes,precio,idDomicilio,idEstado,idImagen,idTemporada,fechaAlta,idContacto,idObjetoPuntuable,idCliente) values ('" + nombre +"','" + detalle + "','" + fechaInicio + "','" + fechaFin + "','" + ano + "','" + personas + "','" + precio + "'," + domicilio +"," + estado +  "," + imagen + "," + temporada + ",'" + fechaAlta + "'," + contacto + "," + getIdObjeto() + "," + cliente +")");
        cerrarConexion();
    }

    public Excursion(int id, String nombre) {
        super("", 0, 0, 0, 0, 0, 0);
        this.id = id;
        this.nombre = nombre;
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

    
    @Override
    public String toString(){
        throw new UnsupportedOperationException("Not supported yet.");
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

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
public class SitioParaComer extends Lugar{
    private int id;
    private String nombre;
    private String precio;
    private int categoriaRestaurante;
    private int observacion;
    private int tipoDeComida;
    
    // Constructor completo

    public SitioParaComer(String nombre, String precio, int categoriaRestaurante, int observacion, int tipoDeComida, String fechaAlta, int cliente, int contacto, int domicilio, int estado, int imagen, int prioridad,String opcionales) throws SQLException {
        super(fechaAlta, cliente, contacto, domicilio, estado, imagen, prioridad);
        this.nombre = nombre;
        this.precio = precio;
        this.categoriaRestaurante = categoriaRestaurante;
        this.observacion = observacion;
        this.tipoDeComida = tipoDeComida;
        generarObjetoParaBD();
        if(opcionales.equals("Completo"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.SitioParaComer (idCliente,nombre,precio,idCategoriaRestaurante,IdContacto,idDomicilio,idEstado,IdImagen,IdObservacion,IdTipoDeComida,fechaAlta,idObjetoPuntuable) values ('" + cliente +"','" + nombre + "','" + precio +"','" + categoriaRestaurante +"','" + contacto +  "','" + domicilio + "','" + estado + "','" + imagen + "','" + observacion + "','" + tipoDeComida + "','" + fechaAlta + "','" + getIdObjeto()+"')");
        if(opcionales.equals("Precio"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.SitioParaComer (idCliente,nombre,idCategoriaRestaurante,IdContacto,idDomicilio,idEstado,IdImagen,IdObservacion,IdTipoDeComida,fechaAlta,idObjetoPuntuable) values ('" + cliente +"','" + nombre + "','" + categoriaRestaurante +"','" + contacto +  "','" + domicilio + "','" + estado + "','" + imagen + "','" + observacion + "','" + tipoDeComida + "','" + fechaAlta + "','" + getIdObjeto()+"')");
        if(opcionales.equals("Cliente"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.SitioParaComer (nombre,precio,idCategoriaRestaurante,IdContacto,idDomicilio,idEstado,IdImagen,IdObservacion,IdTipoDeComida,fechaAlta,idObjetoPuntuable) values ('" + nombre + "','" + precio +"','" + categoriaRestaurante +"','" + contacto +  "','" + domicilio + "','" + estado + "','" + imagen + "','" + observacion + "','" + tipoDeComida + "','" + fechaAlta + "','" + getIdObjeto()+"')");
        if(opcionales.equals("Minimo"))
           getCon().getSql().executeUpdate("INSERT INTO Turismo.SitioParaComer (nombre,idCategoriaRestaurante,IdContacto,idDomicilio,idEstado,IdImagen,IdObservacion,IdTipoDeComida,fechaAlta,idObjetoPuntuable) values ('" + nombre + "','" + categoriaRestaurante +"','" + contacto +  "','" + domicilio + "','" + estado + "','" + imagen + "','" + observacion + "','" + tipoDeComida + "','" + fechaAlta + "','" + getIdObjeto()+"')");
        cerrarConexion();
    }

    
    
    
}

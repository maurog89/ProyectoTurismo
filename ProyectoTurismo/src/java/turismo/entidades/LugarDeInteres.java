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
public class LugarDeInteres extends Lugar{
    private int id;
    private String descripcion;
    private String nombre;
    private String precio;
    
    // Constructor completo

    public LugarDeInteres(String descripcion, String nombre, String precio, String fechaAlta, int cliente, int contacto, int domicilio, int estado, int imagen, int prioridad) throws SQLException {
        super(fechaAlta, cliente, contacto, domicilio, estado, imagen, prioridad);
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
        generarObjetoParaBD();
        getCon().getSql().executeUpdate("INSERT INTO Turismo.LugarDeInteres (descripcion,nombre,precio,idDomicilio,idEstado,idCliente,idImagen,fechaAlta,idObjetoPuntuable) values ('" + descripcion +"','" + nombre + "','" + precio +"','" + domicilio + "','" + estado + "','" + cliente + "','" + imagen + "','" + fechaAlta + "','" + getIdObjeto()+"')");
        cerrarConexion();
    }
    
    // Constructor minimo (sin imagen y cliente)

    public LugarDeInteres(String descripcion, String nombre, String precio, String fechaAlta, int contacto, int domicilio, int estado, int prioridad) throws SQLException {
        super(fechaAlta, 0, contacto, domicilio, estado, 0, prioridad);
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
        generarObjetoParaBD();
        getCon().getSql().executeUpdate("INSERT INTO Turismo.LugarDeInteres (descripcion,nombre,precio,idDomicilio,idEstado,fechaAlta,idObjetoPuntuable) values ('" + descripcion +"','" + nombre + "','" + precio +"','" + domicilio + "','" + estado + "','" + fechaAlta + "','" + getIdObjeto()+"')");
        cerrarConexion();
    }
    
    // Constructor sin cliente o sin imagen

    public LugarDeInteres(String descripcion, String nombre, String precio, String fechaAlta, int cliente, int contacto, int domicilio, int estado, int imagen, int prioridad,String opcionales) throws SQLException {
        super(fechaAlta, cliente, contacto, domicilio, estado, imagen, prioridad);
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
        generarObjetoParaBD();
        if(opcionales.equals("Cliente"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.LugarDeInteres (descripcion,nombre,precio,idDomicilio,idEstado,idImagen,fechaAlta,idObjetoPuntuable) values ('" + descripcion +"','" + nombre + "','" + precio +"','" + domicilio + "','" + estado + "','" + imagen + "','" + fechaAlta + "','" + getIdObjeto()+"')");
        if(opcionales.equals("Imagen"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.LugarDeInteres (descripcion,nombre,precio,idDomicilio,idEstado,idCliente,fechaAlta,idObjetoPuntuable) values ('" + descripcion +"','" + nombre + "','" + precio +"','" + domicilio + "','" + estado + "','" + cliente + "','" + fechaAlta + "','" + getIdObjeto()+"')");
        cerrarConexion();
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.sql.SQLException;
import turismo.conexion.Conexion;

/**
 *
 * @author matiascanodesarrollos
 */
public class SitioParaComer extends Lugar implements InterfazDeBusqueda{
    private int id;
    private String nombre;
    private String precio;
    private int categoriaRestaurante;
    private int observacion;
    private int tipoDeComida;
    
    // Constructor completo

    public SitioParaComer(int categoriaRestaurante, int observacion, int tipoDeComida, int cliente, int contacto, int domicilio, int estado, int imagen, int prioridad, String nombre, String precio, String fechaAlta) throws SQLException {
        super(fechaAlta, cliente, contacto, domicilio, estado, imagen, prioridad);
        generarObjetoParaBD();
        this.nombre = nombre;
        this.precio = precio;
        this.categoriaRestaurante = categoriaRestaurante;
        this.observacion = observacion;
        this.tipoDeComida = tipoDeComida;
        Conexion con = new Conexion();
        con.getSql().execute("INSERT INTO Turismo.SitioParaComer (idCliente,nombre,precio,idCategoriaRestaurante,IdContacto,idDomicilio,idEstado,IdImagen,IdObservacion,IdTipoDeComida,fechaAlta,idObjetoPuntuable) values ('" + cliente +"','" + nombre + "','" + precio +"','" + categoriaRestaurante +"','" + contacto +  "','" + domicilio + "','" + estado + "','" + imagen + "','" + observacion + "','" + tipoDeComida + "','" + fechaAlta + "','" + getIdObjeto()+"')");
        con.cerrarConexion();
    }

    @Override
    public void modifarRegistroBD() {
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

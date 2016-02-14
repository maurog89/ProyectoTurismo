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
public class LugarDeInteres extends Lugar  implements InterfazDeBusqueda{
    private int id;
    private String descripcion;
    private String nombre;
    private String precio;
    
    // Constructor completo

    public LugarDeInteres(String descripcion, String nombre, String precio, int cliente, int contacto, int domicilio, int estado, int imagen, int prioridad, String fechaAlta) throws SQLException {
        super(fechaAlta, cliente, contacto, domicilio, estado, imagen, prioridad);
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
        generarObjetoParaBD();
        getCon().getSql().executeUpdate("INSERT INTO Turismo.LugarDeInteres (descripcion,nombre,precio,idDomicilio,idEstado,idCliente,idImagen,fechaAlta,idObjetoPuntuable) values ('" + descripcion +"','" + nombre + "','" + precio +"','" + domicilio + "','" + estado + "','" + cliente + "','" + imagen + "','" + fechaAlta + "','" + getIdObjeto()+"')");
        cerrarConexion();
    }    
   
    public LugarDeInteres(int id, String nombre) {
        super("", 0, 0, 0, 0, 0, 0);
        this.id = id;
        this.nombre = nombre;
    }
    
    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"nombre\":\""+nombre+"\",\"descripcion\":\""+descripcion+"\",\"precio\":\""+precio+"\",\"fechaAlta\":\""+fechaAlta+"\",\"cliente\":\""+cliente+"\",\"contacto\":\""+contacto+"\",\"domicilio\":\""+domicilio+"\",\"estado\":\""+estado+"\",\"imagen\":\""+imagen+"\",\"prioridad\":\""+getPrioridad()+"\"}";    
    }

    @Override
    public void modifarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

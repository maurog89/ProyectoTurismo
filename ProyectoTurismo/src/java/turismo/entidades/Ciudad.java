/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author matiascanodesarrollos
 */
public class Ciudad extends ObjetoPuntuable implements InterfazDeBusqueda{
    private int id;
    private String nombre;
    private String historia;
    private String emergencia;
    private boolean esCapital;
    private int observacion;
    private int provincia;
    private String fechaAlta;
    private int cliente;
    private int imagen;

    
    /*
    * Constructor para nuevas ciudades completas
    */  
    public Ciudad(String nombre, String historia, String emergencia, boolean esCapital, int observacion, int provincia, int cliente, int imagen, int prioridad, String fechaAlta) throws SQLException {
        super(prioridad);
        this.nombre = nombre;
        this.historia = historia;
        this.emergencia = emergencia;
        this.esCapital = esCapital;
        this.observacion = observacion;
        this.provincia = provincia;
        this.fechaAlta = fechaAlta;
        this.cliente = cliente;
        this.imagen = imagen;
        generarObjetoParaBD();
        ResultSet rss = getCon().getSql().executeQuery("CALL Turismo.cargaCiudadCompleta('" + nombre + "','" + historia + "','" + emergencia + "'," + esCapital +",'" + observacion  + "','" + provincia + "','" + fechaAlta + "','" + cliente + "','" + imagen + "','" + getIdObjeto()+"')");
        rss.next();
        this.id = rss.getInt("LAST_INSERT_ID()");
        cerrarConexion();
    }
    

    public Ciudad(int id, String nombre, int provincia) {
        this.id = id;
        this.nombre = nombre;
        this.provincia = provincia;
    }
   
    @Override
    public String toString(){
        return "{\"id\":\""+id+"\",\"nombre\":\""+nombre+"\",\"historia\":\""+historia+"\",\"emergencia\":\""+emergencia+"\",\"esCapital\":\""+esCapital+"\",\"observacion\":\""+observacion+"\",\"provincia\":\""+provincia+"\",\"fechaAlta\":\""+fechaAlta+"\",\"cliente\":\""+cliente+"\",\"imagen\":\""+imagen+"\",\"prioridad\":\""+getPrioridad()+"\",\"cantidadDeVeces\":\""+getCantidadDeVeces()+"\",\"puntajeTotal\":\""+getPuntajeTotal()+"\"}";    
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

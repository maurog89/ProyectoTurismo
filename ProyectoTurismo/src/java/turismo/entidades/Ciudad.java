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
public class Ciudad extends ObjetoPuntuable {
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
    * Constructor para nuevas ciudades, sin historia, emergencias, observaciones, cliente, o imagen   
    */   
    public Ciudad(String nombre, boolean esCapital, int provincia, String fechaAlta, int prioridad) throws SQLException {
        super(prioridad);
        this.nombre = nombre;
        this.esCapital = esCapital;
        this.provincia = provincia;
        this.fechaAlta = fechaAlta;
        generarObjetoParaBD();
        ResultSet rss = getCon().getSql().executeQuery("CALL Turismo.cargaCuidadMinima('" + nombre + "'," + esCapital + ",'" + provincia + "','" + fechaAlta + "','"+ getIdObjeto()+"')");
        rss.next();
        this.id = rss.getInt("LAST_INSERT_ID()");
        cerrarConexion();
    }
    /*
    * Constructor para nuevas ciudades completas
    */  
    public Ciudad(String nombre, String historia, String emergencia, boolean esCapital, int observacion, int provincia, String fechaAlta, int cliente, int imagen, int prioridad) throws SQLException {
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
    
    /*
    * Constructor para nuevas ciudades sin campos opcionales
    */  
    public Ciudad(String nombre, String historia, String emergencia, boolean esCapital, int observacion, int provincia, String fechaAlta, int cliente, int imagen, int prioridad,String opcionales) throws SQLException {
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
        
        // Ciudades sin 4 paramentros adicionales
        if(opcionales.equals("HistoriaEmergenciasClienteObservaciones"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,esCapital,idProvincia,fechaAlta,idImagen,idObjetoPuntuable) values ('" + nombre + "'," + esCapital +",'" + provincia + "','" + fechaAlta + "','" + imagen + "','" + getIdObjeto()+"')");                
        if(opcionales.equals("HistoriaEmergenciasObservacionesImagenes"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,esCapital,idProvincia,fechaAlta,idCliente,idObjetoPuntuable) values ('" + nombre + "'," + esCapital +",'" + provincia + "','" + fechaAlta + "','" + cliente + "','" + getIdObjeto()+"')");
        if(opcionales.equals("HistoriaClienteObservacionesImagen"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,emergencia,esCapital,idProvincia,fechaAlta,idObjetoPuntuable) values ('" + nombre +"','" + emergencia + "'," + esCapital +",'" + provincia + "','" + fechaAlta + "','" + getIdObjeto()+"')");
        if(opcionales.equals("EmergenciasClienteObservacionesImagenes"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,historia,esCapital,idProvincia,fechaAlta,idObjetoPuntuable) values ('" + nombre +"','" + historia + "'," + esCapital +",'" + provincia + "','" + fechaAlta + "','" + getIdObjeto()+"')");
        
        
        
        // Ciudades sin 3 paramentros adicionales
        if(opcionales.equals("HistoriaEmergenciasCliente"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,esCapital,idObservacion,idProvincia,fechaAlta,idImagen,idObjetoPuntuable) values ('" + nombre + "'," + esCapital +",'" + observacion + "','" + provincia + "','" + fechaAlta + "','"  + imagen + "','" + getIdObjeto()+"')");
        if(opcionales.equals("HistoriaEmergenciasObservaciones"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,esCapital,idProvincia,fechaAlta,idCliente,idImagen,idObjetoPuntuable) values ('" + nombre + "'," + esCapital +",'" + provincia + "','" + fechaAlta + "','" + cliente + "','" + imagen + "','" + getIdObjeto()+"')");
        if(opcionales.equals("HistoriaEmergenciasImagenes"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,esCapital,idObservacion,idProvincia,fechaAlta,idCliente,idObjetoPuntuable) values ('" + nombre + "'," + esCapital + ",'" + observacion +"','" + provincia + "','" + fechaAlta + "','" + cliente + "','" + getIdObjeto()+"')");
        if(opcionales.equals("HistoriaClienteObservaciones"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,emergencia,esCapital,idProvincia,fechaAlta,idImagen,idObjetoPuntuable) values ('" + nombre + "','" + emergencia + "'," + esCapital + ",'" + provincia + "','" + fechaAlta + "','" + imagen   + "','" + getIdObjeto()+"')");
        if(opcionales.equals("HistoriaClienteImagen"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,emergencia,esCapital,idObservacion,idProvincia,fechaAlta,idObjetoPuntuable) values ('" + nombre + "','" + emergencia + "'," + esCapital + ",'" + observacion + ",'" + provincia + "','" + fechaAlta  + "','" + getIdObjeto()+"')");
        if(opcionales.equals("HistoriaObservacionesImagen"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,emergencia,esCapital,idProvincia,fechaAlta,idCliente,idObjetoPuntuable) values ('" + nombre + "','" + emergencia + "'," + esCapital + ",'" + provincia + "','" + fechaAlta + "','" + cliente + "','" + getIdObjeto()+"')");
        if(opcionales.equals("EmergenciasClienteObservaciones"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,historia,esCapital,idProvincia,fechaAlta,idImagen,idObjetoPuntuable) values ('" + nombre + "','" + historia + "'," + esCapital + ",'" + provincia + "','" + fechaAlta + "','" + imagen   + "','" + getIdObjeto()+"')");
        if(opcionales.equals("EmergenciasClienteImagenes"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,historia,esCapital,idObservacion,idProvincia,fechaAlta,idObjetoPuntuable) values ('" + nombre + "','" + historia + "'," + esCapital + ",'" + observacion + "','" + provincia + "','" + fechaAlta  + "','" + getIdObjeto()+"')");
        if(opcionales.equals("EmergenciasObservacionesImagenes"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,historia,esCapital,idProvincia,fechaAlta,idCliente,idObjetoPuntuable) values ('" + nombre + "','" + historia + "'," + esCapital + ",'" + provincia + "','" + fechaAlta + "','" + cliente + "','" + getIdObjeto()+"')");
        if(opcionales.equals("EmergenciasObservacionesImagenes"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,historia,esCapital,idProvincia,fechaAlta,idCliente,idObjetoPuntuable) values ('" + nombre + "','" + historia + "'," + esCapital + ",'" + provincia + "','" + fechaAlta + "','" + cliente + "','" + getIdObjeto()+"')");
        if(opcionales.equals("ClienteObservacionesImagenes"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,historia,esCapital,idProvincia,fechaAlta,emergencia,idObjetoPuntuable) values ('" + nombre + "','" + historia + "'," + esCapital + ",'" + provincia + "','" + fechaAlta + "','" + emergencia + "','" + getIdObjeto()+"')");
        
        
        
        // Ciudades sin 2 paramentros adicionales
        if(opcionales.equals("HistoriaEmergencias"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,esCapital,idObservacion,idProvincia,fechaAlta,idCliente,idImagen,idObjetoPuntuable) values ('" + nombre + "'," + esCapital + ",'" + provincia +"','" + provincia + "','" + fechaAlta + "','" + cliente+ "','" + imagen + "','" + getIdObjeto()+"')");
        if(opcionales.equals("HistoriaCliente"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,emergencia,esCapital,idObservacion,idProvincia,fechaAlta,idImagen,idObjetoPuntuable) values ('" + nombre + "','" + emergencia + "'," + esCapital + ",'" + observacion + "','" + provincia + "','" + fechaAlta + "','" + imagen + "','" + getIdObjeto()+"')");
        if(opcionales.equals("HistoriaImagen"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,emergencia,esCapital,idObservacion,idProvincia,fechaAlta,idCliente,idObjetoPuntuable) values ('" + nombre + "','" + emergencia + "'," + esCapital + ",'" + observacion + "','" + provincia + "','" + fechaAlta + "','" + cliente + "','" + getIdObjeto()+"')");
        if(opcionales.equals("EmergenciasCliente"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,historia,esCapital,idObservacion,idProvincia,fechaAlta,idImagen,idObjetoPuntuable) values ('" + nombre + "','" + historia + "'," + esCapital + ",'" + observacion + "','" + provincia + "','" + fechaAlta + "','" + imagen + "','" + getIdObjeto()+"')");
        if(opcionales.equals("EmergenciasObservaciones"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,historia,esCapital,idImagen,idProvincia,fechaAlta,idCliente,idObjetoPuntuable) values ('" + nombre + "','" + historia + "'," + esCapital + ",'" + imagen + "','" + provincia + "','" + fechaAlta + "','" + cliente + "','" + getIdObjeto()+"')");
        if(opcionales.equals("EmergenciasImagen"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,historia,esCapital,idObservacion,idProvincia,fechaAlta,idCliente,idObjetoPuntuable) values ('" + nombre + "','" + historia + "'," + esCapital + ",'" + observacion + "','" + provincia + "','" + fechaAlta + "','" + cliente + "','" + getIdObjeto()+"')");
        if(opcionales.equals("ClienteObservaciones"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,historia,esCapital,idImagen,idProvincia,fechaAlta,emergencia,idObjetoPuntuable) values ('" + nombre + "','" + historia + "'," + esCapital + ",'" + imagen + "','" + provincia + "','" + fechaAlta + "','" + emergencia + "','" + getIdObjeto()+"')");
        if(opcionales.equals("ObservacionesImagenes"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,historia,esCapital,idCliente,idProvincia,fechaAlta,emergencia,idObjetoPuntuable) values ('" + nombre + "','" + historia + "'," + esCapital + ",'" + cliente + "','" + provincia + "','" + fechaAlta + "','" + emergencia + "','" + getIdObjeto()+"')");
        
        
        
        // Ciudades sin 1 paramentros adicionales
        if(opcionales.equals("Historia"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,emergencia,esCapital,idObservacion,idProvincia,fechaAlta,idCliente,idImagen,idObjetoPuntuable) values ('" + nombre + "','" + emergencia + "'," + esCapital + ",'" + observacion + "','" + provincia + "','" + fechaAlta + "','" + cliente + "','" + imagen + "','" + getIdObjeto()+"')");
        if(opcionales.equals("Emergencias"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,historia,esCapital,idObservacion,idProvincia,fechaAlta,idCliente,idImagen,idObjetoPuntuable) values ('" + nombre + "','" + historia + "'," + esCapital + ",'" + observacion + "','" + provincia + "','" + fechaAlta + "','" + cliente + "','" + imagen + "','" + getIdObjeto()+"')");
        if(opcionales.equals("Cliente"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,historia,esCapital,idObservacion,idProvincia,fechaAlta,emergencia,idImagen,idObjetoPuntuable) values ('" + nombre + "','" + historia + "'," + esCapital + ",'" + observacion + "','" + provincia + "','" + fechaAlta + "','" + emergencia + "','" + imagen + "','" + getIdObjeto()+"')");
        if(opcionales.equals("Observaciones"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,historia,esCapital,idCliente,idProvincia,fechaAlta,emergencia,idImagen,idObjetoPuntuable) values ('" + nombre + "','" + historia + "'," + esCapital + ",'" + cliente + "','" + provincia + "','" + fechaAlta + "','" + emergencia + "','" + imagen + "','" + getIdObjeto()+"')");
        if(opcionales.equals("Imagenes"))
            getCon().getSql().executeUpdate("INSERT INTO Turismo.Ciudad (nombre,historia,esCapital,idCliente,idProvincia,fechaAlta,emergencia,idObservacion,idObjetoPuntuable) values ('" + nombre + "','" + historia + "'," + esCapital + ",'" + cliente + "','" + provincia + "','" + fechaAlta + "','" + emergencia + "','" + observacion + "','" + getIdObjeto()+"')");
        
        
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
}

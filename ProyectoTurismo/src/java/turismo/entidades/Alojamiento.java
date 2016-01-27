/*
 * Clase utilizada para manejar los alojamientos
 */
package turismo.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author matiascanodesarrollos
 */
public class Alojamiento extends Lugar {
    private final int id;
    private final String nombre;
    private final String descripcion;
    private final int regimenAlimentario;
    private final int temporada;

    /*
    * Constructor para nuevos alojamientos    
    */
    public Alojamiento(String nombre, String descripcion, int prioridad, int estado, int cliente, int imagen, int regimenAlimentario, int temporada, int domicilio, int contacto, String fechaAlta) throws SQLException {
        super(fechaAlta,cliente,contacto,domicilio,estado,imagen,prioridad);
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.regimenAlimentario = regimenAlimentario;
        this.temporada = temporada;
        generarObjetoParaBD();      
        ResultSet rss = getCon().getSql().executeQuery("CALL Turismo.cargaAlojamiento('" + nombre + "','" + descripcion + "','" + cliente + "','" + contacto + "','" + domicilio + "','" + estado + "','" + imagen + "','" + regimenAlimentario + "','" + temporada + "','" + fechaAlta + "','" + getIdObjeto()+"')");
        rss.next();
        this.id = rss.getInt("LAST_INSERT_ID()");        
        cerrarConexion();
    }

    
}

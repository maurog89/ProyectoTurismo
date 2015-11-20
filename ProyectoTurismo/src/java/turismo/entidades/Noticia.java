/*
 * Clase Utilizada para las Noticias
 */
package turismo.entidades;

import java.sql.Date;
import java.sql.ResultSet;
import turismo.conexion.Conexion;
/**
 *
 * @author matiascanodesarrollos
 */
public class Noticia extends ObjetoPuntuable implements IEntidades {
    private static int id;
    private static String titulo;
    private static String resumen;
    private static String cuerpo;
    private static String link;
    private final Date fechaAlta;
    private static Date fechaInicio;
    private static Date fechaFin;
    private static Estado estado;
    private static Imagen imagen;
    private static Observacion observacion;
    private Conexion con;
    
    /*
    * Constructor para nuevas noticas
    */
    public Noticia(String titulo, String resumen, String cuerpo, String link, Date fechaAlta, Date fechaInicio, Date fechaFin, Estado estado, Imagen imagen, Observacion observacion, int prioridad) throws Exception{
        super(prioridad);
        this.titulo = titulo;
        this.resumen = resumen;
        this.cuerpo = cuerpo;
        this.link = link;
        this.fechaAlta = fechaAlta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.imagen = imagen;
        this.observacion = observacion;
        con = new Conexion();        
        ResultSet rs = con.getSql().executeQuery("CALL Turismo.cargaObjetoPuntuable("+prioridad+")");
        setIdObjeto(rs.getInt(1));
        ResultSet rss = con.getSql().executeQuery("CALL Turismo.cargaNoticia("+titulo+","+resumen+","+cuerpo+","+link+","+fechaAlta+","+fechaInicio+","+fechaFin+","+estado.getId()+","+imagen.getId()+","+observacion.getId()+","+prioridad+")");
        this.id = rss.getInt(1);
        con.cerrarConexion();
    }
    
    /*
    * Get y sets
    */

    public static String getTitulo() {
        return titulo;
    }

    public static void setTitulo(String titulo) {
        Noticia.titulo = titulo;
    }

    public static String getResumen() {
        return resumen;
    }

    public static void setResumen(String resumen) {
        Noticia.resumen = resumen;
    }

    public static String getCuerpo() {
        return cuerpo;
    }

    public static void setCuerpo(String cuerpo) {
        Noticia.cuerpo = cuerpo;
    }

    public static String getLink() {
        return link;
    }

    public static void setLink(String link) {
        Noticia.link = link;
    }

    public static Date getFechaInicio() {
        return fechaInicio;
    }

    public static void setFechaInicio(Date fechaInicio) {
        Noticia.fechaInicio = fechaInicio;
    }

    public static Date getFechaFin() {
        return fechaFin;
    }

    public static void setFechaFin(Date fechaFin) {
        Noticia.fechaFin = fechaFin;
    }

    public static Estado getEstado() {
        return estado;
    }

    public static void setEstado(Estado estado) {
        Noticia.estado = estado;
    }

    public static Imagen getImagen() {
        return imagen;
    }

    public static void setImagen(Imagen imagen) {
        Noticia.imagen = imagen;
    }

    public static Observacion getObservacion() {
        return observacion;
    }

    public static void setObservacion(Observacion observacion) {
        Noticia.observacion = observacion;
    }    

    @Override
    public boolean guardarEnBD() throws Exception {        
        
        return true;    
    }

    

    
    
}

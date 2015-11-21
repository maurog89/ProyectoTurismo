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
    private final String fechaAlta;
    private static String fechaInicio;
    private static String fechaFin;
    private static int estado;
    private static int imagen;
    private static int observacion;
    private final Conexion con;

    /*
    * Constructor para nuevas noticas
     */
    public Noticia(String titulo, String resumen, String cuerpo, String link, String fechaAlta, String fechaInicio, String fechaFin, int estado, int imagen, int observacion, int prioridad) throws Exception {
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
        ResultSet rs = con.getSql().executeQuery("CALL Turismo.cargaObjetoPuntuable(" + prioridad + ")");
        rs.next();
        setIdObjeto(rs.getInt("LAST_INSERT_ID()"));        
        ResultSet rss = con.getSql().executeQuery("CALL Turismo.cargaNoticia('" + titulo + "','" + resumen + "','" + cuerpo + "','" + link + "','" + fechaAlta + "','" + fechaInicio + "','" + fechaFin + "','" + estado + "','" + imagen + "','" + observacion + "','"+ getIdObjeto()+"')");
        rss.next();
        this.id = rss.getInt("LAST_INSERT_ID()");
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

    public static String getFechaInicio() {
        return fechaInicio;
    }

    public static void setFechaInicio(String fechaInicio) {
        Noticia.fechaInicio = fechaInicio;
    }

    public static String getFechaFin() {
        return fechaFin;
    }

    public static void setFechaFin(String fechaFin) {
        Noticia.fechaFin = fechaFin;
    }

    public static int getEstado() {
        return estado;
    }

    public static void setEstado(int estado) {
        Noticia.estado = estado;
    }

    public static int getImagen() {
        return imagen;
    }

    public static void setImagen(int imagen) {
        Noticia.imagen = imagen;
    }

    public static int getObservacion() {
        return observacion;
    }

    public static void setObservacion(int observacion) {
        Noticia.observacion = observacion;
    }

    @Override
    public boolean guardarEnBD() throws Exception {

        return true;
    }

}

/*
 * Clase Utilizada para las Noticias
 */
package turismo.entidades;

import java.sql.ResultSet;

/**
 *
 * @author matiascanodesarrollos
 */
public class Noticia extends ObjetoPuntuable implements IEntidades {

    private final int id;
    private String titulo;
    private String resumen;
    private String cuerpo;
    private String link;
    private String fechaAlta;
    private String fechaInicio;
    private String fechaFin;
    private int estado;
    private int imagen;
    private int observacion;

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
        generarObjetoParaBD();        
        ResultSet rss = getCon().getSql().executeQuery("CALL Turismo.cargaNoticia('" + titulo + "','" + resumen + "','" + cuerpo + "','" + link + "','" + fechaAlta + "','" + fechaInicio + "','" + fechaFin + "','" + estado + "','" + imagen + "','" + observacion + "','"+ getIdObjeto()+"')");
        rss.next();
        this.id = rss.getInt("LAST_INSERT_ID()");
        cerrarConexion();
    }

    /*
    * Get y sets
     */

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getObservacion() {
        return observacion;
    }

    public void setObservacion(int observacion) {
        this.observacion = observacion;
    }
    
    
    @Override
    public boolean guardarEnBD() throws Exception {

        return true;
    }

}

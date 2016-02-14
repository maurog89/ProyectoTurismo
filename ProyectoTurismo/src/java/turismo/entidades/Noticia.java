/*
 * Clase Utilizada para las Noticias
 */
package turismo.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author matiascanodesarrollos
 */
public class Noticia extends ObjetoPuntuable implements IEntidades, InterfazDeBusqueda {

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
    public Noticia(int estado, int imagen, int observacion, int prioridad,String titulo, String resumen, String cuerpo, String link, String fechaInicio, String fechaFin, String fechaAlta) throws SQLException {
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

    @Override
    public void modifarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void borrarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

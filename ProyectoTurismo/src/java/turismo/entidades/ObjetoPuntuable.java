/*
 * Clase padre de todos los objetos que pueden ser puntuados
 * La utilizo para guardar y calular los puntajes de un objeto.
 */
package turismo.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import turismo.conexion.Conexion;

/**
 * @author matiascanodesarrollos
 */
public class ObjetoPuntuable {
    private int idObjeto;
    private int cantidadDeVeces;
    private int prioridad;
    private int puntajeTotal;
    private Conexion con;
    
    /**
    * Constructor usado para crear objetos ya presentes en la BD
     */
     
    
    /**
    * Constructor usado para inicializar por primera vez el objeto
     */
    public ObjetoPuntuable(int prioridad) {      
        this.prioridad = prioridad;
    }
    
    /**
    * Metodo utilizado para calcular el promedio de puntaje.
     * @return float
     */
    public float calcularPromedio(){
        return puntajeTotal / cantidadDeVeces;        
    }
    
    public void generarObjetoParaBD() throws SQLException{
        setCon();
        ResultSet rs = con.getSql().executeQuery("CALL Turismo.cargaObjetoPuntuable(" + prioridad + ")");
        rs.next();
        setIdObjeto(rs.getInt("LAST_INSERT_ID()"));
    }
    
    public void cerrarConexion() throws SQLException{
       con.cerrarConexion();
    }
    
    /**
    * Get y set de todos los atributos salvo id que nunca cambia.
     */
    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int id) {
        this.idObjeto = id;
    }

    public Conexion getCon() {
        return con;
    }

    public void setCon() {
        this.con = new Conexion();
    }
    
    
    
    public int getCantidadDeVeces() {
        return cantidadDeVeces;
    }

    public void setCantidadDeVeces(int cantidadDeVeces) {
        this.cantidadDeVeces = cantidadDeVeces;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }
    
    
}

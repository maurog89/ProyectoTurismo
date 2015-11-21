/*
 * Clase padre de todos los objetos que pueden ser puntuados
 * La utilizo para guardar y calular los puntajes de un objeto.
 */
package turismo.entidades;

/**
 * @author matiascanodesarrollos
 */
public class ObjetoPuntuable {
    private int id;
    private static int cantidadDeVeces;
    private static int prioridad;
    private static int puntajeTotal;
    
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
    
    /**
    * Get y set de todos los atributos salvo id que nunca cambia.
     */
    public int getIdObjeto() {
        return id;
    }

    public void setIdObjeto(int id) {
        this.id = id;
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

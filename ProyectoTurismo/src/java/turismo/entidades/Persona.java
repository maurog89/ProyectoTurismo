/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

/**
 *
 * @author matiascanodesarrollos
 */
public abstract class Persona {    
    protected String nombre,segundoNombre,apellido,fechaCreacion,fechaNacimiento,nroDocumento;
    protected int idPersona,idTipoDocumento,idContacto,idDomicilio,idEstado;
    
    public Persona(){
        
    }

    public Persona(String nombre, String segundoNombre, String apellido, String fechaCreacion, String fechaNacimiento, String nroDocumento, int idTipoDocumento, int idContacto, int idDomicilio, int idEstado) {
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.apellido = apellido;
        this.fechaCreacion = fechaCreacion;
        this.fechaNacimiento = fechaNacimiento;
        this.nroDocumento = nroDocumento;
        this.idTipoDocumento = idTipoDocumento;
        this.idContacto = idContacto;
        this.idDomicilio = idDomicilio;
        this.idEstado = idEstado;
    }

    
    
    
}

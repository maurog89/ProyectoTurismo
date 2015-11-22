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
public class Lugar extends ObjetoPuntuable{
    public String fechaAlta;
    public int cliente;
    public int contacto;
    public int domicilio;
    public int estado;
    public int imagen;
    
    //Constructor
    public Lugar(String fechaAlta, int cliente, int contacto, int domicilio, int estado, int imagen, int prioridad) {
        super(prioridad);
        this.fechaAlta = fechaAlta;
        this.cliente = cliente;
        this.contacto = contacto;
        this.domicilio = domicilio;
        this.estado = estado;
        this.imagen = imagen;
    }
    
    //Get y set

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    public int getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(int domicilio) {
        this.domicilio = domicilio;
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
    
    
}

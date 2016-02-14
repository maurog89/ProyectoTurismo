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
public interface InterfazDeBusqueda {
    public void borrarRegistroBD();
    public void modificarRegistroBD();
    public String toJSON();
}

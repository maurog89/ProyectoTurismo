/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.conexion;

import turismo.entidades.IEntidades;

/**
 *
 * @author matiascanodesarrollos
 */
public interface IConexiones {
    public boolean insertar(IEntidades e) throws Exception; 
}

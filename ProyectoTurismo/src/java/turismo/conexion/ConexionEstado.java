/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.conexion;

import turismo.entidades.Estado;
import turismo.entidades.IEntidades;

/**
 *
 * @author matiascanodesarrollos
 */
public class ConexionEstado extends Conexion implements IConexiones{

    public ConexionEstado() {
        super();
    }
   
    
    @Override
    public boolean insertar(IEntidades e) throws Exception {
        try {
            Estado es = (Estado) e;
            String sentencia = "INSERT INTO Turismo.Estado (nombre,descripcion) values ('" + es.getNombre()+"','"+es.getDescripcion()+"')";
            getSql().executeUpdate(sentencia); 
            return true;
        }
        catch (Exception ex){
            return false;
        }        
    }
    
    
    
}

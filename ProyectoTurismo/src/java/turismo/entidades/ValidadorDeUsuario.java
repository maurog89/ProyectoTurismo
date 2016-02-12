/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import turismo.conexion.Conexion;

/**
 *
 * @author matiascanodesarrollos
 */
public class ValidadorDeUsuario {
    private String usuario,password,mensaje;
    private boolean validado;
    
    public ValidadorDeUsuario(HttpServletRequest request) throws SQLException {
        usuario = request.getParameter("user");
        password = request.getParameter("pass");
        Conexion con = new Conexion();
        ResultSet rss = con.getSql().executeQuery("SELECT us.nombre AS nombre, us.pasword AS pass FROM Turismo.Usuario AS us WHERE us.nombre = '" + usuario + "'");
        if(rss.next()){
            if(rss.getString("pass").equals(password)){  
                mensaje = "Usuario validado.";
                validado = true;
            }else{           
                mensaje = "Password Incorrecta.";
                validado = false;
            }                
        }else{
            mensaje = "El usuario ingresado no existe.";
            validado = false;
        }            
        con.cerrarConexion();
    }

    public void ValidarPermisos(String permisosRequeridos) throws SQLException{
        Conexion con = new Conexion();
        ResultSet rss = con.getSql().executeQuery("SELECT us.nombre AS nombre, us.pasword AS pass , tipo.nombre AS permisos FROM Turismo.Usuario AS us INNER JOIN Turismo.Permisos AS perm ON us.idUsuario = perm.idUsuario INNER JOIN Turismo.TipoPermiso AS tipo ON perm.idTipoPermiso = tipo.idTipoPermiso WHERE us.nombre = '" + usuario + "'");
        while(rss.next()){
            if(rss.getString("permisos").equals(permisosRequeridos)){  
                mensaje = "Usuario validado.";
                validado = true;
                break;
            }else{           
                mensaje = "No tiene los permisos suficientes.";
                validado = false;
            }                
        }     
        con.cerrarConexion();
    }
            
    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean isValidado() {
        return validado;
    }
    
    
    
}

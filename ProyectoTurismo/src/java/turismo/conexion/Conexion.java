/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author matiascanodesarrollos
 */
public class Conexion {
    protected Connection conex;
    protected Statement sql;
    protected ResultSet rs;
    protected String resultado = "";
    
    public Conexion(){                  
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/Turismo?zeroDateTimeBehavior=convertToNull","root","B1d2 Sh3kyamuni");
            sql = conex.createStatement();
        } catch (Exception ex) {
                // handle any errors
            resultado += ex.toString();
        }   
    }
    
    public void cerrarConexion () throws SQLException {
        conex.close();
    }
}
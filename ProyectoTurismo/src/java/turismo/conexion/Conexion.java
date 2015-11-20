/*
 * Clase que utilizan las entidades para conectarse a las BD
 */
package turismo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author matiascanodesarrollos
 */
public class Conexion {
    private Connection conex;
    private Statement sql;
    private String resultado = "";
    
    /*
    * Creo la conexion y genero un objeto Statement
    */
    
    public Conexion(){                  
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/Turismo?zeroDateTimeBehavior=convertToNull","root","B1d2 Sh3kyamuni");
            sql = conex.createStatement();
        } catch (ClassNotFoundException ex) {
                // handle any errors
            resultado += ex.toString();
        } catch (InstantiationException ex) {
            // handle any errors
            resultado += ex.toString();
        } catch (IllegalAccessException ex) {
            // handle any errors
            resultado += ex.toString();
        } catch (SQLException ex) {
            // handle any errors
            resultado += ex.toString();
        }   
    }
    
    public void cerrarConexion () throws SQLException {
        conex.close();
    }
    
    /*
    * Gets y Sets
    */

    public Connection getConex() {
        return conex;
    }

    public Statement getSql() {
        return sql;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
}
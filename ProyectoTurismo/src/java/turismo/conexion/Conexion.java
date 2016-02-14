/*
 * Clase que utilizan las entidades para conectarse a las BD
 */
package turismo.conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import turismo.entidades.*;

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
            conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/Turismo?zeroDateTimeBehavior=convertToNull","root","");
            sql = conex.createStatement();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
                // handle any errors
            resultado += ex.toString();
        }
        // handle any errors
        // handle any errors
        // handle any errors
   
    }
    
    public void cerrarConexion () throws SQLException {
        sql.close();
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
    
    
    
    //Metodo utlizado para traer todos los elementos de una tabla
    public ArrayList traerTodos(String bus,int id) throws SQLException{
        ResultSet rs;
        ArrayList result = new ArrayList();
        switch (bus){
            case "Estados":                
                rs = sql.executeQuery("SELECT idEstado,nombre FROM Turismo.Estado");
                while(rs.next()){
                    result.add(new Estado(rs.getInt("idEstado"),rs.getString("nombre")));
                }
                cerrarConexion();
                return result;
            case "Clientes":
                rs =  sql.executeQuery("SELECT idCliente,razonSocial FROM Turismo.Cliente");
                while(rs.next()){
                    result.add(new Cliente(rs.getInt("idCliente"),rs.getString("razonSocial")));
                }
                cerrarConexion();
                return result;
            case "RegimenAlimentario":
                rs =  sql.executeQuery("SELECT idRegimenAlimentario,nombre FROM Turismo.RegimenAlimentario");
                while(rs.next()){
                    result.add(new RegimenAlimentario(rs.getInt("idRegimenAlimentario"),rs.getString("nombre")));
                }
                cerrarConexion();
                return result;
            case "Temporadas":
                rs =  sql.executeQuery("SELECT idTemporada,nombre FROM Turismo.Temporada");
                while(rs.next()){
                    result.add(new Temporada(rs.getInt("idTemporada"),rs.getString("nombre")));
                }
                cerrarConexion();
                return result;
            case "Pais":
                rs =  sql.executeQuery("SELECT idPais,Nombre FROM Turismo.Pais");
                while(rs.next()){
                    result.add(new Pais(rs.getInt("idPais"),rs.getString("Nombre")));
                }
                cerrarConexion();
                return result;
            case "Provincia":
                rs =  sql.executeQuery("SELECT idProvincia,nombre FROM Turismo.Provincia where IdPais = "+id);
                while(rs.next()){
                    result.add(new Provincia(rs.getInt("idProvincia"),rs.getString("nombre"),id));
                }
                cerrarConexion();
                return result;
            case "Ciudad":
                rs =  sql.executeQuery("SELECT idCiudad,nombre FROM Turismo.Ciudad where idProvincia = "+id); 
                while(rs.next()){
                    result.add(new Ciudad(rs.getInt("idCiudad"),rs.getString("nombre"),id));
                }
                cerrarConexion();
                return result;
            case "Barrio":
                rs =  sql.executeQuery("SELECT idBarrio,nombre FROM Turismo.Barrio where idCiudad = "+id); 
                while(rs.next()){
                    result.add(new Barrio(rs.getInt("idBarrio"),rs.getString("nombre"),id));
                }
                cerrarConexion();
                return result;
            case "TipoContacto":
                rs =  sql.executeQuery("SELECT idTipoContacto,Nombre FROM Turismo.TipoContacto"); 
                while(rs.next()){
                    result.add(new TipoContacto(rs.getInt("idTipoContacto"),rs.getString("Nombre")));
                }
                cerrarConexion();
                return result;
            case "TipoDocumento":
                rs =  sql.executeQuery("SELECT idTipoDocumento,Nombre FROM Turismo.TipoDocumento"); 
                while(rs.next()){
                    result.add(new TipoDocumento(rs.getInt("idTipoDocumento"),rs.getString("Nombre")));
                }
                cerrarConexion();
                return result;    
            case "Excursion":
                rs =  sql.executeQuery("SELECT idExcursion,nombre FROM Turismo.Excursion"); 
                while(rs.next()){
                    result.add(new Excursion(rs.getInt("idExcursion"),rs.getString("nombre")));
                }
                cerrarConexion();
                return result;
            case "LugarDeInteres":
                rs =  sql.executeQuery("SELECT idLugarDeInteres,nombre FROM Turismo.LugarDeInteres"); 
                while(rs.next()){
                    result.add(new LugarDeInteres(rs.getInt("idLugarDeInteres"),rs.getString("nombre")));
                }
                cerrarConexion();
                return result;
            case "TipoEvento":
                rs =  sql.executeQuery("SELECT idTipoEvento,nombre FROM Turismo.TipoEvento");
                while(rs.next()){
                    result.add(new TipoEvento(rs.getInt("idTipoEvento"),rs.getString("nombre")));
                }
                cerrarConexion();
                return result;
            case "TipoFactura":
                rs =  sql.executeQuery("SELECT idTipoFactura,tipoObjeto FROM Turismo.TipoFactura");
                while(rs.next()){
                    result.add(new TipoFactura(rs.getInt("idTipoFactura"),rs.getString("tipoObjeto")));
                }
                cerrarConexion();
                return result;
            case "TipoVencimiento":
                rs =  sql.executeQuery("SELECT idTipoVencimiento,tipo FROM Turismo.TipoVencimiento");
                while(rs.next()){
                    result.add(new TipoVencimiento(rs.getInt("idTipoVencimiento"),rs.getString("tipo")));
                }
                cerrarConexion();
                return result;
            case "TipoHabitacion":
                rs =  sql.executeQuery("SELECT idTipoHabitacion,nombre FROM Turismo.TipoHabitacion");
                while(rs.next()){
                    result.add(new TipoHabitacion(rs.getInt("idTipoHabitacion"),rs.getString("nombre")));
                }
                return result;
            case "Alojamientos":
                rs =  sql.executeQuery("SELECT idAlojamiento,nombre FROM Turismo.Alojamiento");
                while(rs.next()){
                    result.add(new TipoHabitacion(rs.getInt("idAlojamiento"),rs.getString("nombre")));
                }
                cerrarConexion();
                return result;
            case "EmpresaTransporte":
                rs =  sql.executeQuery("SELECT idEmpresaTransporte,RazonSocial FROM Turismo.EmpresaTransporte");
                while(rs.next()){
                    result.add(new EmpresaTransporte(rs.getInt("idEmpresaTransporte"),rs.getString("RazonSocial")));
                }
                cerrarConexion();
                return result;
            case "TipoPermiso":
                rs =  sql.executeQuery("SELECT idTipoPermiso,nombre FROM Turismo.TipoPermiso");
                while(rs.next()){
                    result.add(new TipoPermiso(rs.getInt("idTipoPermiso"),rs.getString("nombre")));
                }
                cerrarConexion();
                return result;
            case "Usuarios":
                rs =  sql.executeQuery("SELECT idUsuario,nombre FROM Turismo.Usuario");
                while(rs.next()){
                    result.add(new Usuario(rs.getInt("idUsuario"),rs.getString("nombre")));
                }
                cerrarConexion();
                return result;
            case "TipoComida":
                rs =  sql.executeQuery("SELECT idTipoDeComida,nombre FROM Turismo.TipoDeComida");
                while(rs.next()){
                    result.add(new TipoDeComida(rs.getInt("idTipoDeComida"),rs.getString("nombre")));
                }
                cerrarConexion();
                return result;
            case "CategoriaRestaurante":
                rs =  sql.executeQuery("SELECT idCategoriaRestaurante,nombre FROM Turismo.CategoriaRestaurante");
                while(rs.next()){
                    result.add(new CategoriaRestaurante(rs.getInt("idCategoriaRestaurante"),rs.getString("nombre")));
                }
                cerrarConexion();
                return result;
            default:
                cerrarConexion();
                return null;
        }
    }           
                    
    public ArrayList buscarSimilares(String tabla,String nombre,String[] parametros,String valor) throws SQLException{
        ResultSet rs;
        ArrayList result = new ArrayList();
        String consulta = "SELECT " + nombre + " AS nombre FROM Turismo." + tabla + " WHERE ";
        int contador = 1;        
        for(String p:parametros){
            if(contador != parametros.length)
                consulta = consulta + p + " LIKE '%" + valor + "%' OR ";
            else
                consulta = consulta + p + " LIKE '%" + valor +"%' LIMIT 4";
            contador++;
        }
        ResultSet rss = sql.executeQuery(consulta);
        while(rss.next()){
            result.add(new Similares(rss.getString("nombre")));
        }        
        cerrarConexion();
        return result;
    }
    
    public InterfazDeBusqueda buscarPorNombre(String tabla,String nombre) throws SQLException{
        ResultSet rs;
        InterfazDeBusqueda resultado = null;
        switch(tabla){
            case "Alojamiento":
                rs = sql.executeQuery("SELECT * FROM Turismo.Alojamiento INNER JOIN Turismo.ObjetoPuntuable ON Turismo.Alojamiento.idObjetoPuntuable = Turismo.ObjetoPuntuable.idObjetoPuntuable WHERE nombre = " + nombre);
                if(rs.next()){
                    resultado = new Alojamiento(rs.getInt("idAlojamiento"),rs.getString("nombre"),rs.getString("descripcion"),rs.getInt("IdRegimenAlimentario"),rs.getInt("IdTemporada"),rs.getString("fechaAlta"),rs.getInt("idCliente"),rs.getInt("idContacto"),rs.getInt("idDomiciio"),rs.getInt("IdEstado"),rs.getInt("idImagen"),rs.getInt("prioridad"));
                }
                break;
        }
        return resultado;
    }
    
}
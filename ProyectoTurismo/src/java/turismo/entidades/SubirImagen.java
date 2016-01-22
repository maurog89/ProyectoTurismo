/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import turismo.conexion.Conexion;

/**
 *
 * @author matiascanodesarrollos
 */
public class SubirImagen {
       
    public static int SubirImagen(byte[] archivo,String tipo,int imagenAnterior) throws FileNotFoundException, IOException, SQLException {
        Conexion con = new Conexion();
        ResultSet rs = con.getSql().executeQuery("CALL cargarImagen ("+imagenAnterior+")");
        rs.next();
        int idImagen = rs.getInt("LAST_INSERT_ID()");
        File arch = new File("/home/matiascanodesarrollos/imagenesTurismo/imagen"+idImagen+"."+tipo);
        rs.close();
        con.cerrarConexion();
        arch.createNewFile();
        arch.setWritable(true); 
        if(arch.canWrite()){
            FileOutputStream file = new FileOutputStream(arch);
            file.write(archivo);
            file.close();
        }
        Conexion c = new Conexion();
        c.getSql().execute("UPDATE Turismo.Imagen SET idOtraImagen = " + imagenAnterior + "  WHERE idImagen = "+idImagen);
        c.getSql().execute("UPDATE Turismo.Imagen SET link = '/home/matiascanodesarrollos/imagenesTurismo/imagen" + idImagen +"."+tipo + "'  WHERE idImagen = "+idImagen);
        c.cerrarConexion();
        return idImagen;
    }
    
    
    
}

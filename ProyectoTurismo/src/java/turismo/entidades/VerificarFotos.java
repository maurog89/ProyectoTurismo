/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.io.DataInputStream;
import java.io.IOException;
import javax.servlet.http.Part;

/**
 *
 * @author matiascanodesarrollos
 */
public class VerificarFotos {
    public static String verificarFoto(Part img) throws IOException{
        
        String tipoDeArchivo = img.getContentType();
        if(tipoDeArchivo.equals("image/png"))
            return "png";
        if(tipoDeArchivo.equals("image/jpeg"))
            return "jpg";
        if(tipoDeArchivo.equals("image/gif"))
            return "gif";
        return "formatoInvalido";    
        
            
    }
    
    public static byte[] crearStreamFoto(Part img) throws IOException{
        int fotoSize = (int) img.getSize();
        byte[] foto = null;            
        if(fotoSize > 0){
            foto = new byte[fotoSize];
            try(DataInputStream dis = new DataInputStream(img.getInputStream())){
                dis.readFully(foto);
            }
        }
        return foto;
    }
}

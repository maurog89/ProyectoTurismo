/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.io.PrintWriter;

/**
 *
 * @author matiascanodesarrollos
 */
public class ImprimirHTML {
    public static void imprimirEtiquetasIniciales(PrintWriter out,String titulo){
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>"+titulo+"</title>");
        out.println("</head>");
        out.println("<body>");
    }
    
    public static void imprimirEtiquetasFinal(PrintWriter out){
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
    public static void imprimirErrorDeMetodo(PrintWriter out){
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Error de Metodo</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Estimado usuario, para su seguridad utilice la interfaz brindada.</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}

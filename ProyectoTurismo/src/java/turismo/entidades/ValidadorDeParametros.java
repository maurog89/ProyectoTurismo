/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author matiascanodesarrollos
 */
public class ValidadorDeParametros {

    public static boolean[] validarVacio(String[] par, HttpServletRequest request) {
        boolean[] resultado = new boolean[par.length];
        int contador = 0;
        for (String p : par) {
            String valor = request.getParameter(p);
            if(!valor.equals("x0"))
                resultado[contador] = !valor.isEmpty();
            else
                resultado[contador] = false;
            contador++;
        }
        return resultado;
    }

    public static boolean[] validarNumerico(String[] num, HttpServletRequest request) {
        boolean[] resultado = new boolean[num.length];
        int contador = 0;
        for (String p : num) {
            String valor = request.getParameter(p);
            try {
                Integer.parseInt(valor);
                resultado[contador] = true;
            } catch (NumberFormatException ex) {
                resultado[contador] = false;
            }
            contador++;
        }
        return resultado;
    }

    public static boolean validar(boolean[] par, boolean[] num) {
        for (boolean p : par) {
            if (!p) {
                return false;
            }
        }
        for (boolean p : num) {
            if (!p) {
                return false;
            }
        }
        return true;
    }

    public static boolean insertar(String tabla, String[] param, int[] num, String[] tablasSecundarias, int[] secundarios, HttpServletRequest request, PrintWriter out) throws IOException, ServletException, FileNotFoundException, SQLException {
        Verificador ver = new Verificador();
        ver.verificarCantidades(param, request); 
        Domicilio dom = null;
        String fecha = Fechas.fechaActual();
        
        int contador = 0;
        ArrayList<Parametro> parametros = new ArrayList();
        for (String p : param) {
            for (int n : num) {
                if (contador == n) {
                    Parametro par = new ParametroNumerico(contador, p);
                    par.asignarValor(request);
                    parametros.add(par);
                    break;
                }
            }
            if (parametros.size() == contador) {
                Parametro par = new ParametroTextual(contador, p);
                par.asignarValor(request);
                parametros.add(par);
            }
            contador++;
           
        }
        int contador2 = 0;
        for(String s:tablasSecundarias){
            switch (s) {
                case "Domicilio":
                    String[] datosDomicilio = obtenerDatosDomicilio(param,request);
                    dom = ingresarDomicilio(datosDomicilio[0],datosDomicilio[1],datosDomicilio[2],datosDomicilio[3],datosDomicilio[4],datosDomicilio[5],datosDomicilio[6],datosDomicilio[7],Integer.parseInt(datosDomicilio[8]));
                    parametros.get(secundarios[contador2]).valorNumerico = dom.getId();
                    break;
                case "Imagen":
                    ingresarImagenes(ver,request,out);
                    parametros.get(secundarios[contador2]).valorNumerico = ver.getIdUltimaImagen();
                    break;
                case "Contacto":
                    ingresarContactos(ver,request,out);
                    parametros.get(secundarios[contador2]).valorNumerico = ver.getIdContacto();
                    break;
                case "Observacion":
                    parametros.get(secundarios[contador2]).valorNumerico = ingresarObservacion(request);
                    break;              
            }            
            contador2++;
        }
        
        ingresarTabla(tabla, parametros, fecha, param, request);       
        
        return true;
    }
    
    private static void ingresarImagenes(Verificador ver, HttpServletRequest request, PrintWriter out) throws IOException, ServletException, FileNotFoundException, SQLException{
        if (ver.getCantidadImagenes() > 0) {
            Part img = request.getPart("imagen1");
            String tipoImagen = VerificarFotos.verificarFoto(img);
            if (tipoImagen.equals("formatoInvalido")) {
                out.println("<p>Solo pueden cargarse fotos en jpg,pgn y gif.</p>");
            } else {
                int idUltimaImagen = SubirImagen.SubirImagen(VerificarFotos.crearStreamFoto(img), tipoImagen, 1);
                
                if (ver.getCantidadImagenes() > 1) {
                    for (int i = 2; i <= ver.getCantidadImagenes(); i++) {
                        img = request.getPart("imagen" + i);
                        tipoImagen = VerificarFotos.verificarFoto(img);
                        if (tipoImagen.equals("formatoInvalido")) {
                            out.println("<p>Solo pueden cargarse fotos en jpg,pgn y gif. Verifique la imagen numero: " + i + ".</p>");
                        } else {
                            idUltimaImagen = SubirImagen.SubirImagen(VerificarFotos.crearStreamFoto(img), tipoImagen, idUltimaImagen);
                        }
                    }
                }
                ver.setIdUltimaImagen(idUltimaImagen);
                
            }
        }else
            ver.setIdUltimaImagen(1);
    }
    
    private static void ingresarContactos(Verificador ver, HttpServletRequest request, PrintWriter out) throws IOException, ServletException, FileNotFoundException, SQLException{
        if (ver.getCantidadContactos() > 0) {
            Contacto con = new Contacto(request.getParameter("detalleContactos1"), Integer.parseInt(request.getParameter("tipoContacto1")));
            int idContacto = con.getId();
            if (ver.getCantidadContactos() > 1) {
                for (int i = 2; i <= ver.getCantidadContactos(); i++) {
                    int tipo = Integer.parseInt(request.getParameter("tipoContacto" + i));
                    String detalle = request.getParameter("detalleContactos" + i);
                    Contacto cont = new Contacto(detalle, tipo);
                    cont.setContactoAnterior(con.getId());
                    if (i == ver.getCantidadContactos()) {
                        idContacto = cont.getId();
                    }
                }
            }
            ver.setIdContacto(idContacto);
        }
    }
    
    private static Domicilio ingresarDomicilio(String calle, String numeroCalle, String nroPiso, String dpto, String nroTorre, String nroManzana, String nroLote, String codPostal, int barrio) throws SQLException{
        return new Domicilio(calle,numeroCalle,nroPiso,dpto,nroTorre,nroManzana,nroLote,codPostal,barrio);
    }
    
    private static String[] obtenerDatosDomicilio(String[] param, HttpServletRequest request){
        String[] resultado = new String[9];
        for(String p:param){
            if(p.equals("calleDomicilio"))
                resultado[0] = request.getParameter(p);
            if(p.equals("nroDomicilio"))
                resultado[1] = request.getParameter(p);
            if(p.equals("nroPiso"))
                resultado[2] = request.getParameter(p);
            if(p.equals("departamentoDomicilio"))
                resultado[3] = request.getParameter(p);
            if(p.equals("torreDomicilio"))
                resultado[4] = request.getParameter(p);
            if(p.equals("manzanaDomicilio"))
                resultado[5] = request.getParameter(p);
            if(p.equals("loteDomicilio"))
                resultado[6] = request.getParameter(p);
            if(p.equals("codigoPostalDomicilio"))
                resultado[7] = request.getParameter(p);
            if(p.equals("Barrio"))
                resultado[8] = request.getParameter(p);  
        }
        return resultado;
    }
    
    public static void imprimirDatosFaltantes(PrintWriter out,boolean[] validadorVacio,boolean[] validadorNumerico,String[] obligatorios,String[] numericos){
        int contador = 0;
            
            out.println("<h3>Los siguientes campos deben estar completos: </h3>");
            out.println("<ul>");
            for(boolean v:validadorVacio){
                if(!v){
                    out.println("<li>"+obligatorios[contador]+"</li>");
                }
                contador++;
            }
            out.println("</ul>");
            
            contador = 0;
            
            out.println("<h3>Los siguientes campos debe ser numericos: </h3>");
            out.println("<ul>");
            for(boolean v:validadorNumerico){
                if(!v){
                    out.println("<li>"+numericos[contador]+"</li>");
                }
                contador++;
            }
            out.println("</ul>");
    }
    
    private static int ingresarObservacion(HttpServletRequest request) throws SQLException{
        String observacion = request.getParameter("Observaciones");
        Observacion resultado;
        if(!observacion.isEmpty())
            resultado= new Observacion(observacion);
        else
            return 1;
        return resultado.getId();
    }
    
    private static void ingresarTabla(String tabla, ArrayList<Parametro> parametros,String fecha,String[] param,HttpServletRequest request) throws SQLException{
        switch(tabla){
            case "Alojamiento":
                new Alojamiento(parametros.get(0).valorTextual,parametros.get(1).valorTextual,parametros.get(2).valorNumerico,parametros.get(3).valorNumerico,parametros.get(4).valorNumerico,parametros.get(5).valorNumerico,parametros.get(6).valorNumerico,parametros.get(7).valorNumerico,parametros.get(8).valorNumerico,parametros.get(9).valorNumerico,fecha);              
                break;
            case "Ciudad":
                new Ciudad(parametros.get(0).valorTextual,parametros.get(1).valorTextual,parametros.get(2).valorTextual,(parametros.get(3).valorNumerico == 1)?true:false,parametros.get(4).valorNumerico,parametros.get(5).valorNumerico,parametros.get(6).valorNumerico,parametros.get(7).valorNumerico,parametros.get(8).valorNumerico,fecha);  
                break;
            case "Barrio":
                new Barrio(parametros.get(0).valorTextual,parametros.get(1).valorNumerico,parametros.get(2).valorNumerico);
                break;
            case "Pais":
                new Pais(parametros.get(0).valorTextual,parametros.get(1).valorTextual);
               break;
            case "Provincia":
                new Provincia(parametros.get(0).valorTextual,parametros.get(1).valorNumerico,parametros.get(2).valorTextual);
                break;
            case "Domicilio":
                String[] datosDomicilio = obtenerDatosDomicilio(param,request);
                ingresarDomicilio(datosDomicilio[0],datosDomicilio[1],datosDomicilio[2],datosDomicilio[3],datosDomicilio[4],datosDomicilio[5],datosDomicilio[6],datosDomicilio[7],Integer.parseInt(datosDomicilio[8]));
                break;
            case "Estado":
                new Estado(parametros.get(0).valorTextual,parametros.get(1).valorTextual,(parametros.get(1).valorTextual.isEmpty())?"Minimo":"Completa");
                break;
            case "Observacion":
                new Observacion(parametros.get(0).valorTextual);
                break;
            case "Cliente":
                new Cliente(parametros.get(0).valorTextual,parametros.get(1).valorTextual,parametros.get(2).valorTextual,parametros.get(3).valorTextual,parametros.get(4).valorTextual,parametros.get(5).valorTextual,parametros.get(6).valorNumerico,parametros.get(7).valorNumerico,parametros.get(8).valorNumerico,parametros.get(9).valorNumerico,parametros.get(10).valorNumerico,fecha);
                break;
        }
    }
    
}

class Verificador {

    private int cantidadImagenes, cantidadContactos, idUltimaImagen,idContacto, posicionImagen,posicionContacto;

    public void verificarCantidades(String[] param, HttpServletRequest request) {
        int contador = 0;
        for (String t : param) {            
            if (t.equals("cantidadImagenes")) 
                cantidadImagenes = Integer.parseInt(request.getParameter("cantidadImagenes"));
            if (t.equals("cantidadContactos")) 
                cantidadContactos = Integer.parseInt(request.getParameter("cantidadContactos"));
            contador++;
        }
    }

    public int getCantidadImagenes() {
        return cantidadImagenes;
    }

    public void setCantidadImagenes(int cantidadImagenes) {
        this.cantidadImagenes = cantidadImagenes;
    }

    public int getCantidadContactos() {
        return cantidadContactos;
    }

    public void setCantidadContactos(int cantidadContactos) {
        this.cantidadContactos = cantidadContactos;
    }

    public int getIdUltimaImagen() {
        return idUltimaImagen;
    }

    public void setIdUltimaImagen(int idUltimaImagen) {
        this.idUltimaImagen = idUltimaImagen;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getPosicionImagen() {
        return posicionImagen;
    }

    public void setPosicionImagen(int posicionImagen) {
        this.posicionImagen = posicionImagen;
    }

    public int getPosicionContacto() {
        return posicionContacto;
    }

    public void setPosicionContacto(int posicionContacto) {
        this.posicionContacto = posicionContacto;
    }
    
    

}

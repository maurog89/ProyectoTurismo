/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.controlador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import turismo.entidades.Ciudad;
import turismo.entidades.Fechas;
import turismo.entidades.Observacion;
import turismo.entidades.SubirImagen;
import turismo.entidades.VerificarFotos;

/**
 *
 * @author matiascanodesarrollos
 */
@MultipartConfig
public class AltaCiudad extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * 
     * 
     */
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        
        try {
            // Primero valido los campos obligatorios
            
            int cantidadImagenes = 0;
            String nombre = "";
            int campoCapital = -1;
            boolean capital = false;
            int prioridad = -1;
            int provincia = 0;
            String historia = "";
            String emergencia = "";        
            int cliente = 1;
            int observaciones = 1;
            String obs = "";
        
            if(!request.getParameter("cantidadImagenes").isEmpty())
                cantidadImagenes = Integer.parseInt(request.getParameter("cantidadImagenes"));
            
        
            if(!request.getParameter("capital").isEmpty()){
                capital = request.getParameter("capital").equals("1");
                campoCapital = 1;
            }
                
        
            if(!request.getParameter("nombreCuidad").isEmpty())
                nombre = request.getParameter("nombreCuidad");
        
            if(!request.getParameter("pririodadCuidad").isEmpty())
                prioridad = Integer.parseInt(request.getParameter("pririodadCuidad"));
        
            if(!request.getParameter("Provincia").isEmpty())
                provincia = Integer.parseInt(request.getParameter("Provincia"));
        
            if(!request.getParameter("historiaPais").isEmpty())
                historia = request.getParameter("historiaPais");
        
            if(!request.getParameter("emergenciaPais").isEmpty())
                emergencia = request.getParameter("emergenciaPais");
        
            if(!request.getParameter("idClienteCiudad").isEmpty())
                cliente = Integer.parseInt(request.getParameter("idClienteCiudad"));
        
            if(!request.getParameter("ciudadObservaciones").isEmpty())
                obs = request.getParameter("ciudadObservaciones");
            
                
            
            if(nombre.isEmpty())
                out.println("El campo nombre es obligatorio");
            else{
                if(campoCapital == -1)
                    out.println("El campo capital es obligatorio");
                else{
                    if(prioridad == -1)
                        out.println("El campo prioridad es obligatorio");
                    else{                        
                        if(provincia == 0)
                            out.println("El campo provincia es obligatorio");
                        else{
                            
                            if(!obs.isEmpty()){
                                observaciones = new Observacion(obs).getId();
                            }
                            int idUltimaImagen = 1;
                            Part img = request.getPart("imagenCiudad1");
                            String tipoImagen = VerificarFotos.verificarFoto(img);
                            if(tipoImagen.equals("formatoInvalido")){
                                out.println("Solo pueden cargarse fotos en jpg,pgn y gif.");
                            }else{
                                idUltimaImagen = SubirImagen.SubirImagen(VerificarFotos.crearStreamFoto(img),tipoImagen,1);
                                if(cantidadImagenes > 1){
                                    img = request.getPart("imagenCiudad1");
                                    tipoImagen = VerificarFotos.verificarFoto(img);
                                    if(tipoImagen.equals("formatoInvalido")){
                                        out.println("Solo pueden cargarse fotos en jpg,pgn y gif.");
                                    }else{
                                        idUltimaImagen = SubirImagen.SubirImagen(VerificarFotos.crearStreamFoto(img),tipoImagen,1);
                                        if(cantidadImagenes > 1){
                                            for(int i = 2; i <= cantidadImagenes;i++){
                                                img = request.getPart("imagenCiudad"+i);
                                                tipoImagen = VerificarFotos.verificarFoto(img);
                                                if(tipoImagen.equals("formatoInvalido")){
                                                    out.println("Solo pueden cargarse fotos en jpg,pgn y gif. Verifique la imagen numero: "+i+".");
                                                }else{
                                                    idUltimaImagen = SubirImagen.SubirImagen(VerificarFotos.crearStreamFoto(img),tipoImagen,idUltimaImagen);
                                                }                                                        
                                            }
                                        }  
                                    }
                                }
                            }
                            
                            new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,idUltimaImagen,prioridad);
                            out.println("Ciudad cargada.");
                        }            
                               
                        }
                    }
                }
        } catch (Exception ex){
            out.println(ex.getMessage());
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

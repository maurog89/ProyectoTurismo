/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.controlador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import turismo.entidades.Evento;
import turismo.entidades.Fechas;

/**
 *
 * @author matiascanodesarrollos
 */
public class AltaEvento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        //Guardo los parametros en variables
        
        String titulo = request.getParameter("tituloEvento");
        String precio = request.getParameter("precioEvento");        
        String descripcion = request.getParameter("descripcionEvento");        
        int prioridad = -1;
        if(!request.getParameter("pririodadEvento").isEmpty())
            prioridad = Integer.parseInt(request.getParameter("pririodadEvento"));        
        String fechaInicio = request.getParameter("fechaInicioEvento");
        String fechaFin = request.getParameter("fechaFinalEvento");        
        int estado = -1;
        if(!request.getParameter("estadoSitioParaComer").isEmpty())
            estado = Integer.parseInt(request.getParameter("estadoSitioParaComer"));
        int cliente = -1;
        if(!request.getParameter("clienteSitioParaComer").isEmpty())
            cliente = Integer.parseInt(request.getParameter("clienteSitioParaComer"));
        int imagen = 1;
        int tipoEvento = -1;        
        if(!request.getParameter("tipoEvento").isEmpty())
            tipoEvento = Integer.parseInt(request.getParameter("tipoEvento"));        
        int domicilio = 3;
        int contacto = 2;
        
        
        
        try {
           //Validaciones
            if(titulo.isEmpty()){
                out.println("El campo título es obligatorio");
                if(precio.isEmpty()){
                    out.println("El campo precio es obligatorio");
                    if(prioridad == -1){
                        out.println("El campo prioridad es obligatorio");
                        if(fechaInicio.isEmpty()){
                            out.println("El campo fecha de inicio es obligatorio");
                            if(fechaFin.isEmpty()){
                                out.println("El campo fecha de fin es obligatorio");
                                if(estado == -1){
                                    out.println("El campo estado es obligatorio");
                                    if(tipoEvento == -1){
                                        out.println("El campo tipo de evento es obligatorio");
                                    }                                      
                                    
                                }
                            }
                        }  
                    }
                }               
            }else{
                if(descripcion.isEmpty()){
                    new Evento(titulo,precio,Fechas.fechaActual(),fechaInicio,fechaFin,cliente,contacto,domicilio,estado,imagen,tipoEvento,prioridad);
                    out.println("Evento sin descripcion cargado");
                }else{
                    new Evento(titulo,descripcion,precio,Fechas.fechaActual(),fechaInicio,fechaFin,cliente,contacto,domicilio,estado,imagen,tipoEvento,prioridad);
                    out.println("Evento cargado");
                }
                
            }  
               
           
        } catch (Exception ex) {
            out.println(ex.toString());
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
            throws ServletException, IOException {
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

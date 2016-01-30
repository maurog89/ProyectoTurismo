/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.controlador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import turismo.entidades.Excursion;
import turismo.entidades.Fechas;

/**
 *
 * @author matiascanodesarrollos
 */
public class AltaExcursion extends HttpServlet {

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
        String nombre = request.getParameter("nombreExcursion");
        String detalle = request.getParameter("detalleExcursion");
        String fechaInicio = request.getParameter("inicioExcursion");
        String fechaFin = request.getParameter("finExcursion");
        String ano = request.getParameter("anoExcursion");
        String personas = request.getParameter("visitantesExcursion");
        String precio = request.getParameter("precioExcursion");
        int prioridad = -1;
        if(!request.getParameter("pririodadExcursion").isEmpty())
           prioridad = Integer.parseInt(request.getParameter("pririodadExcursion"));
        int estado = -1;
        if(!request.getParameter("estadoExcursion").isEmpty())
            estado = Integer.parseInt(request.getParameter("estadoExcursion"));
        int temporada = -1;
        if(!request.getParameter("temporadaExcursion").isEmpty())
            temporada = Integer.parseInt(request.getParameter("temporadaExcursion"));
        int imagen = 1;
        int contacto = 2;
        int cliente = 2;
        int domicilio = 3;
        try {    
            if(!nombre.isEmpty() && !detalle.isEmpty() && !fechaInicio.isEmpty() && !fechaFin.isEmpty() && !ano.isEmpty() && !personas.isEmpty() && !precio.isEmpty() && prioridad != -1 && estado != -1 && temporada != -1 && imagen != -1 && contacto != -1 && cliente != -1 && domicilio != -1){
                new Excursion(nombre,detalle,precio,fechaInicio,fechaFin,ano,personas,temporada,Fechas.fechaActual(),cliente,contacto,domicilio,estado,imagen,prioridad);
                out.println("Excursion cargada");
            }else{
                out.println("Todos los campos son obligatorios");
            }
            
        } catch (SQLException ex) {
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

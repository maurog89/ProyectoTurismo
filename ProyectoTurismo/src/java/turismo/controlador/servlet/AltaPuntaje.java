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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import turismo.entidades.Puntaje;

/**
 *
 * @author matiascanodesarrollos
 */
public class AltaPuntaje extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        int puntaje = -1;
        if(!request.getParameter("puntaje").isEmpty())
            puntaje = Integer.parseInt(request.getParameter("puntaje"));
        int usuario = -1;
        if(!request.getParameter("usuarioPuntaje").isEmpty())
            usuario = Integer.parseInt(request.getParameter("usuarioPuntaje"));
        int objeto = -1;
        if(!request.getParameter("objetoPuntaje").isEmpty())
            objeto = Integer.parseInt(request.getParameter("objetoPuntaje"));
        String comentario = request.getParameter("comentario");        
        try {
            /* TODO output your page here. You may use following sample code. */
            if(puntaje != -1 && usuario != -1 && objeto != -1){
                if(comentario.isEmpty()){
                    new Puntaje(puntaje,usuario,objeto,comentario,"SinComentario");
                    out.println("Puntaje sin comentario cargado.");
                }else{
                    new Puntaje(puntaje,usuario,objeto,comentario,"Completa");
                    out.println("Puntaje cargado.");
                }
            }else{
                out.println("Los campos puntaje, usuario y objeto son obigatorios.");
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

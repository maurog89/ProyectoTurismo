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
import turismo.entidades.Fechas;
import turismo.entidades.Viaje;

/**
 *
 * @author matiascanodesarrollos
 */
public class AltaViaje extends HttpServlet {

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
        String precio = request.getParameter("PrecioFinalAprox");
        String fechaDesde = request.getParameter("fechaDesdeViaje");
        String fechaHasta = request.getParameter("fechaHastaViaje");
        int alojamiento = -1;
        if(!request.getParameter("alojamientoViaje").isEmpty())
            alojamiento = Integer.parseInt(request.getParameter("alojamientoViaje"));
        int ciudad = -1;
        if(!request.getParameter("ciudadViaje").isEmpty())
            ciudad = Integer.parseInt(request.getParameter("ciudadViaje"));
        int estado = -1;
        if(!request.getParameter("estadoViaje").isEmpty())
            estado = Integer.parseInt(request.getParameter("estadoViaje"));
        int usuario = -1;
        if(!request.getParameter("usuarioViaje").isEmpty())
            usuario = Integer.parseInt(request.getParameter("usuarioViaje"));
        String comentarios = request.getParameter("comentariosViaje");
        try {
            /* TODO output your page here. You may use following sample code. */
            if(!precio.isEmpty() && !fechaDesde.isEmpty() && !fechaHasta.isEmpty() && alojamiento != -1 && ciudad != -1 && estado != -1 && usuario != -1){
                if(comentarios.isEmpty()){
                    new Viaje(precio,comentarios,Fechas.fechaActual(),fechaDesde,fechaHasta,alojamiento,ciudad,estado,usuario,"SinComentarios");
                    out.println("Viaje sin comentarios cargado.");
                }else{
                    new Viaje(precio,comentarios,Fechas.fechaActual(),fechaDesde,fechaHasta,alojamiento,ciudad,estado,usuario,"Completo");
                    out.println("Viaje cargado.");
                }
            }else{
                out.println("Los campos precio, fecha desde y hasta, alojamiento, ciudad, estado y usuario.");
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

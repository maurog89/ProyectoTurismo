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
import turismo.entidades.Fechas;
import turismo.entidades.Habitacion;

/**
 *
 * @author matiascanodesarrollos
 */
public class AltaHabitacion extends HttpServlet {

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
        int tipoHabitacion = -1;
        if(!request.getParameter("tipoHabitacion").isEmpty())
            tipoHabitacion = Integer.parseInt(request.getParameter("tipoHabitacion"));
        String precio = request.getParameter("precioHabitacion");
        String descripcion = request.getParameter("detalleHabitacion");
        int prioridad = -1;
        if(!request.getParameter("prioridadHabitacion").isEmpty())
            prioridad = Integer.parseInt(request.getParameter("prioridadHabitacion"));
        int estado = -1;
        if(!request.getParameter("estadoHabitacion").isEmpty())
            estado = Integer.parseInt(request.getParameter("estadoHabitacion"));
        int alojamiento = -1;
        if(!request.getParameter("alojamientoHabitacion").isEmpty())
            alojamiento = Integer.parseInt(request.getParameter("alojamientoHabitacion"));
        int imagen = 1;
        
       
        try {
            /* TODO output your page here. You may use following sample code.     */        
            if(tipoHabitacion != -1 && !precio.isEmpty() && prioridad != -1 && estado != -1 && alojamiento != -1 && imagen != -1){
                if(descripcion.isEmpty()){
                    new Habitacion(precio,imagen,tipoHabitacion,alojamiento,estado,Fechas.fechaActual(),prioridad);
                    out.println("Habitacion cargada correctamente.");
                }else{
                    new Habitacion(descripcion,precio,imagen,tipoHabitacion,alojamiento,estado,Fechas.fechaActual(),prioridad);
                    out.println("Habitacion cargada correctamente.");
                }       
            }else{
                out.println("Los campos tipo habitacion, precio, prioridad, estado, alojamiento e imagen son obligatorios.");
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

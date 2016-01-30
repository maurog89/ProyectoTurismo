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
import turismo.entidades.SitioParaComer;

/**
 *
 * @author matiascanodesarrollos
 */
public class AltaSitioParaComer extends HttpServlet {

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
        String nombre = request.getParameter("nombreSitioParaComer");
        String precio = request.getParameter("precioSitioParaComer");
        int observacion = 1;
        int prioridad = -1;
        if(!request.getParameter("pririodadSitioParaComer").isEmpty())
            prioridad = Integer.parseInt(request.getParameter("pririodadSitioParaComer"));
        int estado = -1;
        if(!request.getParameter("estadoSitioParaComer").isEmpty())
            estado = Integer.parseInt(request.getParameter("estadoSitioParaComer"));
        int cliente = -1;
        if(!request.getParameter("clienteSitioParaComer").isEmpty())
            cliente = Integer.parseInt(request.getParameter("clienteSitioParaComer"));
        int imagen = 1;
        int tipoDeComida = -1;
        if(!request.getParameter("tipoComidaSitioParaComer").isEmpty())
            tipoDeComida = Integer.parseInt(request.getParameter("tipoComidaSitioParaComer"));
        int categoriaRestaurante = -1;
        if(!request.getParameter("categoriaRestauranteSitioParaComer").isEmpty())
            categoriaRestaurante = Integer.parseInt(request.getParameter("categoriaRestauranteSitioParaComer"));
        int domicilio = 1;
        int contacto = 1;
        try {
            /* TODO output your page here. You may use following sample code. */
            if(observacion != -1 && !nombre.isEmpty() && prioridad != -1 && estado != -1 && imagen != -1 && tipoDeComida != -1 && categoriaRestaurante != -1 && domicilio != -1 && contacto != -1){
                if(cliente != -1){
                    if(!precio.isEmpty()){
                        new SitioParaComer(nombre,precio,categoriaRestaurante,observacion,tipoDeComida,Fechas.fechaActual(),cliente,contacto,domicilio,estado,imagen,prioridad,"Completo");
                        out.println("Sitio para comer completo cargado.");
                    }else{
                        new SitioParaComer(nombre,precio,categoriaRestaurante,observacion,tipoDeComida,Fechas.fechaActual(),cliente,contacto,domicilio,estado,imagen,prioridad,"Precio");
                        out.println("Sitio para comer sin precio.");
                    }
                }else{
                    if(!precio.isEmpty()){
                        new SitioParaComer(nombre,precio,categoriaRestaurante,observacion,tipoDeComida,Fechas.fechaActual(),cliente,contacto,domicilio,estado,imagen,prioridad,"Cliente");
                        out.println("Sitio para comer sin cliente.");
                    }else{
                        new SitioParaComer(nombre,precio,categoriaRestaurante,observacion,tipoDeComida,Fechas.fechaActual(),cliente,contacto,domicilio,estado,imagen,prioridad,"Minimo");
                        out.println("Sitio para comer sin cliente y precio.");
                    }
                }
            }else{
                out.println("Los campos nombre, prioridad, estado, imagen, tipo de comida, categoria de restaurante, domicilio y contacto son obligatorios.");
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

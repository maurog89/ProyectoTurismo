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
import turismo.entidades.LugarDeInteres;

/**
 *
 * @author matiascanodesarrollos
 */
public class AltaLugarDeInteres extends HttpServlet {

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
        String nombre = request.getParameter("nombreLugarInteres");
        String precio = request.getParameter("precioLugarInteres");
        String descripcion = request.getParameter("descripcionLugarInteres");
        int prioridad = -1;
        if(!request.getParameter("pririodadLugarInteres").isEmpty())
            prioridad = Integer.parseInt(request.getParameter("pririodadLugarInteres"));
        int estado = -1;
        if(!request.getParameter("estadoLugarInteres").isEmpty())
            estado = Integer.parseInt(request.getParameter("estadoLugarInteres"));
        int cliente = -1;
        if(!request.getParameter("clienteLugarInteres").isEmpty())
            cliente = Integer.parseInt(request.getParameter("clienteLugarInteres"));
        int imagen = 1;
        int domicilio = 2;
        try {
            /* TODO output your page here. You may use following sample code. */
            if(!nombre.isEmpty() && !precio.isEmpty() && !descripcion.isEmpty() && prioridad != -1 && estado != -1 && domicilio != -1){
                if(imagen != -1){
                    if(cliente != -1){
                        new LugarDeInteres(descripcion,nombre,precio,Fechas.fechaActual(),cliente,0,domicilio,estado,imagen,prioridad);
                        out.println("Lugar completo cargado");
                    }else{
                        new LugarDeInteres(descripcion,nombre,precio,Fechas.fechaActual(),0,0,domicilio,estado,imagen,prioridad,"Cliente");
                        out.println("Lugar sin cliete cargado");
                    }
                }else{
                    if(cliente != -1){
                        new LugarDeInteres(descripcion,nombre,precio,Fechas.fechaActual(),cliente,0,domicilio,estado,0,prioridad,"Imagen");
                        out.println("Lugar sin imagen cargado");
                    }else{
                        new LugarDeInteres(descripcion,nombre,precio,Fechas.fechaActual(),0,domicilio,estado,prioridad);
                        out.println("Lugar minimo cargado");
                    }
                }
            }else
                out.println("Los campos nombre, precio,descripcion,prioridad,estado y domicilio son obligatorios.");
            
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

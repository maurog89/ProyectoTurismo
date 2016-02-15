/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.controlador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import turismo.conexion.Conexion;
import turismo.entidades.*;

/**
 *
 * @author matiascanodesarrollos
 */
public class busquedaPorNombre extends HttpServlet {

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
        String valor = request.getParameter("valor");
        
        if (ValidadorDeSession.validarSession(request)) {
            try {
                HttpSession sesion = request.getSession();
                String tabla = (String)sesion.getAttribute("tablaBusquedaParcial");
                Conexion con = new Conexion();
                InterfazDeBusqueda ls = con.buscarPorNombre(tabla, valor);             
                switch(tabla){
                    case "Alojamiento":
                        Alojamiento alo = (Alojamiento)ls;
                        sesion.setAttribute("Objeto", alo);
                        ResultSet rs = con.getSql().executeQuery("SELECT t1.idBarrio AS barrio, t2.idCiudad AS ciudad, t3.idProvincia AS provincia, t4.idPais AS pais FROM Turismo.Domicilio AS dom INNER JOIN Turismo.Barrio AS t1 ON dom.idBarrio=t1.idBarrio INNER JOIN Turismo.Ciudad AS t2 ON t1.idCiudad=t2.idCiudad INNER JOIN Turismo.Provincia AS t3 ON t2.idProvincia=t3.idProvincia INNER JOIN Turismo.Pais AS t4 ON t3.idPais=t4.idPais WHERE dom.idDomicilio="+alo.getDomicilio().getId());
                        if(rs.next())
                            ImprimirHTML.modificarAlojamiento(out, alo, rs.getInt("barrio"), rs.getInt("ciudad"), rs.getInt("provincia"), rs.getInt("pais"));
                        else
                            out.println("<h4>El domicilio de " + alo.getNombre() + " se encuentra cargado incorrectamente.</h4>");
                        break;
                }
                con.cerrarConexion();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        } else {
            ImprimirHTML.InterfaceDeGestionError(out, "Debe estar logeado para ingresar a esta página.");
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
        processRequest(request, response);
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

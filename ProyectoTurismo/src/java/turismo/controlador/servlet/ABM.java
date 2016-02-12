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
import javax.servlet.http.HttpSession;
import turismo.entidades.ImprimirHTML;
import turismo.entidades.ValidadorDeSession;
import turismo.entidades.ValidadorDeUsuario;

/**
 *
 * @author matiascanodesarrollos
 */
public class ABM extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        if(ValidadorDeSession.validarSession(request)){
            switch(request.getParameter("boton")){
                case "Alta":
                    cargarAltas(request,out);
                    break;
                case "Modificación":
                    
                    break;    
                case "Baja":
                        
                    break;
            }
        }else{
            ImprimirHTML.InterfaceDeGestionError(out,"Debe estar logeado para ingresar a esta página.");                
        }
        
        if(ValidadorDeSession.validarSession(request)){
            
        }else{
            ImprimirHTML.InterfaceDeGestionError(out,"Debe estar logeado para ingresar a esta página.");                
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
        ImprimirHTML.imprimirErrorDeMetodo(out);
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
    
    private void cargarAltas(HttpServletRequest request,PrintWriter out){
        switch(request.getParameter("valor")){
            case "Alojamiento":
                ImprimirHTML.cargaAlojamiento(out);
                break;
            case "Barrio":
                ImprimirHTML.cargaBarrio(out);
                break;
            case "Ciudad":
                ImprimirHTML.cargaCiudad(out);
                break;
        }
    }
}

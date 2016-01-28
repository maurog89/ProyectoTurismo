/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.controlador.servlet;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import turismo.entidades.ImprimirHTML;
import turismo.entidades.Pais;
import turismo.entidades.ValidadorDeParametros;

/**
 *
 * @author matiascanodesarrollos
 */
public class AltaPais extends HttpServlet {

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
        try {
             response.setContentType("text/html;charset=UTF-8");
        
        
            ImprimirHTML.imprimirEtiquetasIniciales(out,"Alta de País");
            String[] parametros = new String[]{"nombrePais","descripcionPais"};
            String[] obligatorios =  new String[]{"nombrePais"};
            String[] numericos = new String[]{};
        
            boolean[] validadorVacio = ValidadorDeParametros.validarVacio(obligatorios, request);
            boolean[] validadorNumerico = ValidadorDeParametros.validarNumerico(numericos, request);
        
            if(ValidadorDeParametros.validar(validadorVacio,validadorNumerico)){
                int[] posicionNumericos = new int[]{};
                String[] tablasSecundarias = new String[]{};
                int[] secundarios = new int[]{};
                ValidadorDeParametros.insertar("Pais", parametros , posicionNumericos, tablasSecundarias, secundarios, request, out);
            }else{
                ValidadorDeParametros.imprimirDatosFaltantes(out, validadorVacio, validadorNumerico, obligatorios, numericos);
            }
            
            ImprimirHTML.imprimirEtiquetasFinal(out);
            
        } catch(MySQLIntegrityConstraintViolationException e){
            out.println("El país \"<b>"+ request.getParameter("nombrePais").toUpperCase()+"</b>\" ya se encuentra cargado.");
        }catch (SQLException ex){
            out.println(ex.toString());
        }finally {
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

}

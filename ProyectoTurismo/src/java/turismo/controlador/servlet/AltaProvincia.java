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
import turismo.entidades.Provincia;
import turismo.entidades.ValidadorDeParametros;

/**
 *
 * @author matiascanodesarrollos
 */
public class AltaProvincia extends HttpServlet {

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
        
        
            ImprimirHTML.imprimirEtiquetasIniciales(out,"Alta de Provincia");
            String[] parametros = new String[]{"nombreProvincia","Pais","descripcionProvincia"};
            String[] obligatorios =  new String[]{"nombreProvincia","Pais"};
            String[] numericos = new String[]{"Pais"};
        
            boolean[] validadorVacio = ValidadorDeParametros.validarVacio(obligatorios, request);
            boolean[] validadorNumerico = ValidadorDeParametros.validarNumerico(numericos, request);
        
            if(ValidadorDeParametros.validar(validadorVacio,validadorNumerico)){
                int[] posicionNumericos = new int[]{1};
                String[] tablasSecundarias = new String[]{"Pais"};
                int[] secundarios = new int[]{1};
                ValidadorDeParametros.insertar("Provincia", parametros , posicionNumericos, tablasSecundarias, secundarios, request, out);
            }else{
                ValidadorDeParametros.imprimirDatosFaltantes(out, validadorVacio, validadorNumerico, obligatorios, numericos);
            }
            
            ImprimirHTML.imprimirEtiquetasFinal(out);
            
        } catch(MySQLIntegrityConstraintViolationException e){
            out.println("La provincia \"<b>"+ request.getParameter("nombreProvincia").toUpperCase()+"</b>\" ya se encuentra cargada.");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.controlador.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import turismo.entidades.ImprimirHTML;
import turismo.entidades.ValidadorDeParametros;

/**
 *
 * @author matiascanodesarrollos
 */
@MultipartConfig
public class AltaAlojamiento extends HttpServlet {

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
        ImprimirHTML.imprimirEtiquetasIniciales(out,"Alta de Alojamientos"); 
        
        String[] parametros = new String[]{"nombreAlojamiento","descripcionAlojamiento","pririodadAlojamiento","estadoAlojamiento","clienteAlojamientor","cantidadImagenes","regimenAlimentarioAlojamiento","temporadaAlojamiento","Barrio","cantidadContactos","Pais","Provincia","Ciudad","calleDomicilio","nroDomicilio","nroPiso","departamentoDomicilio","torreDomicilio","manzanaDomicilio","loteDomicilio","codigoPostalDomicilio","tipoContacto1","detalleContactos1"};
        String[] obligatorios =  new String[]{"nombreAlojamiento","pririodadAlojamiento","estadoAlojamiento","clienteAlojamientor","cantidadImagenes","regimenAlimentarioAlojamiento","temporadaAlojamiento","Pais","Provincia","Ciudad","Barrio","calleDomicilio","nroDomicilio","codigoPostalDomicilio","cantidadContactos","tipoContacto1","detalleContactos1"};
        String[] numericos = new String[]{"pririodadAlojamiento","estadoAlojamiento","clienteAlojamientor","cantidadImagenes","regimenAlimentarioAlojamiento","temporadaAlojamiento","Pais","Provincia","Ciudad","Barrio","cantidadContactos","tipoContacto1"};
        
        boolean[] validadorVacio = ValidadorDeParametros.validarVacio(obligatorios, request);
        boolean[] validadorNumerico = ValidadorDeParametros.validarNumerico(numericos, request);
        if(ValidadorDeParametros.validar(validadorVacio,validadorNumerico)){
            try {
                int[] posicionNumericos = new int[]{2,3,4,5,6,7,8,9};
                String[] tablasSecundarias = new String[]{"Domicilio","Imagen","Contacto"};
                int[] secundarios = new int[]{8,5,9};
                ValidadorDeParametros.insertar("Alojamiento", parametros , posicionNumericos, tablasSecundarias, secundarios, request, out);
                
            } catch (FileNotFoundException ex) {
                out.println(ex.toString());
            } catch (SQLException ex) {
                out.println(ex.toString());
            }finally{
                out.close();
            }
        }else{
            ValidadorDeParametros.imprimirDatosFaltantes(out, validadorVacio, validadorNumerico, obligatorios, numericos);
        }
        
        ImprimirHTML.imprimirEtiquetasFinal(out);     
             
        
        
        
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
            throws ServletException, IOException, FileNotFoundException {
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

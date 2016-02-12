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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import turismo.entidades.ImprimirHTML;
import turismo.entidades.ValidadorDeParametros;
import turismo.entidades.ValidadorDeSession;

/**
 *
 * @author matiascanodesarrollos
 */
@MultipartConfig
public class AltaNoticia extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        if (ValidadorDeSession.validarSession(request)) {
            try {
                /* TODO output your page here. You may use following sample code. */
                ImprimirHTML.imprimirEtiquetasIniciales(out, "Alta de Noticias");
                String[] parametros = new String[]{"estadoSitioParaComer", "cantidadImagenes", "Observaciones", "pririodadNoticia", "tituloNoticia", "resumenNoticia", "cuerpoNoticia", "linkNoticia", "fechaInicioNoticia", "fechaFinalNoticia"};
                String[] obligatorios = new String[]{"estadoSitioParaComer", "cantidadImagenes", "Observaciones", "pririodadNoticia", "tituloNoticia", "resumenNoticia", "cuerpoNoticia", "linkNoticia", "fechaInicioNoticia", "fechaFinalNoticia"};
                String[] numericos = new String[]{"estadoSitioParaComer", "cantidadImagenes", "pririodadNoticia"};

                boolean[] validadorVacio = ValidadorDeParametros.validarVacio(obligatorios, request);
                boolean[] validadorNumerico = ValidadorDeParametros.validarNumerico(numericos, request);

                if (ValidadorDeParametros.validar(validadorVacio, validadorNumerico)) {
                    int[] posicionNumericos = new int[]{0, 3};
                    String[] tablasSecundarias = new String[]{"Imagen", "Observacion"};
                    int[] secundarios = new int[]{1, 2};
                    ValidadorDeParametros.insertar("Noticia", parametros, posicionNumericos, tablasSecundarias, secundarios, request, out);
                } else {
                    ValidadorDeParametros.imprimirDatosFaltantes(out, validadorVacio, validadorNumerico, obligatorios, numericos);
                }

                ImprimirHTML.imprimirEtiquetasFinal(out);
            } catch (FileNotFoundException ex) {
                out.println(ex.toString());
            } catch (SQLException ex) {
                out.println(ex.toString());
            } finally {
                out.close();
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AltaNoticia.class.getName()).log(Level.SEVERE, null, ex);
        }
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

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
import turismo.entidades.ValidadorDeSession;

/**
 *
 * @author matiascanodesarrollos
 */
@MultipartConfig
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

        if (ValidadorDeSession.validarSession(request)) {
            try {
                /* TODO output your page here. You may use following sample code. */
                ImprimirHTML.imprimirEtiquetasIniciales(out, "Alta de Lugares de Interes");
                String[] parametros = new String[]{"descripcionLugarInteres", "nombreLugarInteres", "precioLugarInteres", "clienteLugarInteres", "cantidadContactos", "Barrio", "estadoLugarInteres", "cantidadImagenes", "pririodadLugarInteres", "Pais", "Provincia", "Ciudad", "calleDomicilio", "nroDomicilio", "nroPiso", "departamentoDomicilio", "torreDomicilio", "manzanaDomicilio", "loteDomicilio", "codigoPostalDomicilio", "tipoContacto1", "detalleContactos1"};
                String[] obligatorios = new String[]{"descripcionLugarInteres", "nombreLugarInteres", "precioLugarInteres", "cantidadContactos", "Barrio", "estadoLugarInteres", "pririodadLugarInteres", "Pais", "Provincia", "Ciudad", "tipoContacto1", "detalleContactos1"};
                String[] numericos = new String[]{"clienteLugarInteres", "cantidadContactos", "Barrio", "estadoLugarInteres", "cantidadImagenes", "pririodadLugarInteres", "Pais", "Provincia", "Ciudad", "tipoContacto1"};

                boolean[] validadorVacio = ValidadorDeParametros.validarVacio(obligatorios, request);
                boolean[] validadorNumerico = ValidadorDeParametros.validarNumerico(numericos, request);

                if (ValidadorDeParametros.validar(validadorVacio, validadorNumerico)) {
                    int[] posicionNumericos = new int[]{3, 4, 5, 6, 7, 8};
                    String[] tablasSecundarias = new String[]{"Domicilio", "Imagen", "Contacto"};
                    int[] secundarios = new int[]{5, 7, 4};
                    ValidadorDeParametros.insertar("LugarDeInteres", parametros, posicionNumericos, tablasSecundarias, secundarios, request, out);
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

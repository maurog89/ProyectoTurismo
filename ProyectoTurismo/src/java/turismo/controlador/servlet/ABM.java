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
import javax.servlet.http.HttpSession;
import turismo.entidades.ImprimirHTML;
import turismo.entidades.ValidadorDeSession;

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
        if (ValidadorDeSession.validarSession(request)) {
            switch (request.getParameter("boton")) {
                case "Alta":
                    cargarAltas(request, out);
                    break;
                case "Modificación":
                    cargarModificacion(request, out);
                    break;
                case "Baja":

                    break;
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

    private void cargarAltas(HttpServletRequest request, PrintWriter out) {
        switch (request.getParameter("valor")) {
            case "Alojamiento":
                ImprimirHTML.cargaAlojamiento(out);
                break;
            case "Barrio":
                ImprimirHTML.cargaBarrio(out);
                break;
            case "Ciudad":
                ImprimirHTML.cargaCiudad(out);
                break;
            case "Categoria Restaurante":
                ImprimirHTML.cargaCategoriaRestaurante(out);
                break;
            case "Clientes":
                ImprimirHTML.cargaClientes(out);
                break;
            case "Contactos":
                ImprimirHTML.cargaContactos(out);
                break;
            case "Detalle Excursión":
                ImprimirHTML.cargaDetalleExcursion(out);
                break;
            case "Domicilio":
                ImprimirHTML.cargaDomicilio(out);
                break;
            case "Empresa De Transporte":
                ImprimirHTML.cargaEmpresaDeTransporte(out);
                break;
            case "Estado":
                ImprimirHTML.cargaEstado(out);
                break;
            case "Eventos":
                ImprimirHTML.cargaEventos(out);
                break;
            case "Excursiones":
                ImprimirHTML.cargaExcursiones(out);
                break;
            case "Facturas":
                ImprimirHTML.cargaFacturas(out);
                break;
            case "Habitación":
                ImprimirHTML.cargaHabitacion(out);
                break;
            case "Lugares de Interes":
                ImprimirHTML.cargaLugaresdeInteres(out);
                break;
            case "Mapa":
                ImprimirHTML.cargaMapa(out);
                break;
            case "Medio de Transporte":
                ImprimirHTML.cargaMediodeTransporte(out);
                break;
            case "Noticias":
                ImprimirHTML.cargaNoticias(out);
                break;
            case "Observaciones":
                ImprimirHTML.cargaObservaciones(out);
                break;
            case "Paises":
                ImprimirHTML.cargaPaises(out);
                break;
            case "Permisos":
                ImprimirHTML.cargaPermisos(out);
                break;
            case "Provincias":
                ImprimirHTML.cargaProvincias(out);
                break;
            case "Regimenes Alimentarios":
                ImprimirHTML.cargaRegimenesAlimentarios(out);
                break;
            case "Sitios para comer":
                ImprimirHTML.cargaSitiosparacomer(out);
                break;
            case "Temporadas":
                ImprimirHTML.cargaTemporadas(out);
                break;
            case "Tipos de Comida":
                ImprimirHTML.cargaTiposdeComida(out);
                break;
            case "Tipos de Contacto":
                ImprimirHTML.cargaTiposdeContacto(out);
                break;
            case "Tipos de Eventos":
                ImprimirHTML.cargaTiposdeEventos(out);
                break;
            case "Tipos de Documento":
                ImprimirHTML.cargaTiposdeDocumento(out);
                break;
            case "Tipos de Factura":
                ImprimirHTML.cargaTiposdeFactura(out);
                break;
            case "Tipos de Habitación":
                ImprimirHTML.cargaTiposdeHabitacion(out);
                break;
            case "Tipos de Permiso":
                ImprimirHTML.cargaTiposdePermiso(out);
                break;
            case "Tipos de Vencimiento":
                ImprimirHTML.cargaTiposdeVencimiento(out);
                break;
            case "Usuarios":
                ImprimirHTML.cargaUsuarios(out);
                break;
        }
    }

    private void cargarModificacion(HttpServletRequest request, PrintWriter out) {
        HttpSession sesion = request.getSession();
        switch (request.getParameter("valor")) {
            case "Alojamiento":
                sesion.setAttribute("tablaBusquedaParcial", "Alojamiento");
                sesion.setAttribute("nombreBusquedaParcial", "nombre");
                sesion.setAttribute("parametrosBusquedaParcial", new String[]{"nombre","descripcion","fechaAlta"});
                ImprimirHTML.modificacionAlojamiento(out);
                break;
            case "Barrio":
                ImprimirHTML.cargaBarrio(out);
                break;
            case "Ciudad":
                ImprimirHTML.cargaCiudad(out);
                break;
            case "Categoria Restaurante":
                ImprimirHTML.cargaCategoriaRestaurante(out);
                break;
            case "Clientes":
                ImprimirHTML.cargaClientes(out);
                break;
            case "Contactos":
                ImprimirHTML.cargaContactos(out);
                break;
            case "Detalle Excursión":
                ImprimirHTML.cargaDetalleExcursion(out);
                break;
            case "Domicilio":
                ImprimirHTML.cargaDomicilio(out);
                break;
            case "Empresa De Transporte":
                ImprimirHTML.cargaEmpresaDeTransporte(out);
                break;
            case "Estado":
                ImprimirHTML.cargaEstado(out);
                break;
            case "Eventos":
                ImprimirHTML.cargaEventos(out);
                break;
            case "Excursiones":
                ImprimirHTML.cargaExcursiones(out);
                break;
            case "Facturas":
                ImprimirHTML.cargaFacturas(out);
                break;
            case "Habitación":
                ImprimirHTML.cargaHabitacion(out);
                break;
            case "Lugares de Interes":
                ImprimirHTML.cargaLugaresdeInteres(out);
                break;
            case "Mapa":
                ImprimirHTML.cargaMapa(out);
                break;
            case "Medio de Transporte":
                ImprimirHTML.cargaMediodeTransporte(out);
                break;
            case "Noticias":
                ImprimirHTML.cargaNoticias(out);
                break;
            case "Observaciones":
                ImprimirHTML.cargaObservaciones(out);
                break;
            case "Paises":
                ImprimirHTML.cargaPaises(out);
                break;
            case "Permisos":
                ImprimirHTML.cargaPermisos(out);
                break;
            case "Provincias":
                ImprimirHTML.cargaProvincias(out);
                break;
            case "Regimenes Alimentarios":
                ImprimirHTML.cargaRegimenesAlimentarios(out);
                break;
            case "Sitios para comer":
                ImprimirHTML.cargaSitiosparacomer(out);
                break;
            case "Temporadas":
                ImprimirHTML.cargaTemporadas(out);
                break;
            case "Tipos de Comida":
                ImprimirHTML.cargaTiposdeComida(out);
                break;
            case "Tipos de Contacto":
                ImprimirHTML.cargaTiposdeContacto(out);
                break;
            case "Tipos de Eventos":
                ImprimirHTML.cargaTiposdeEventos(out);
                break;
            case "Tipos de Documento":
                ImprimirHTML.cargaTiposdeDocumento(out);
                break;
            case "Tipos de Factura":
                ImprimirHTML.cargaTiposdeFactura(out);
                break;
            case "Tipos de Habitación":
                ImprimirHTML.cargaTiposdeHabitacion(out);
                break;
            case "Tipos de Permiso":
                ImprimirHTML.cargaTiposdePermiso(out);
                break;
            case "Tipos de Vencimiento":
                ImprimirHTML.cargaTiposdeVencimiento(out);
                break;
            case "Usuarios":
                ImprimirHTML.cargaUsuarios(out);
                break;
        }
    }
}

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
import turismo.entidades.Alojamiento;
import turismo.entidades.Fechas;

/**
 *
 * @author matiascanodesarrollos
 */
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
        PrintWriter out = response.getWriter();
        try {
            String nombre = request.getParameter("nombreAlojamiento");
            String descripcion = request.getParameter("descripcionAlojamiento");
            int prioridad = -1;
            if(!request.getParameter("pririodadAlojamiento").isEmpty())
                prioridad = Integer.parseInt(request.getParameter("pririodadAlojamiento"));
            int estado = Integer.parseInt(request.getParameter("estadoAlojamiento"));
            int cliente = Integer.parseInt(request.getParameter("clienteAlojamientor"));
            int cantidadImagenes = Integer.parseInt(request.getParameter("cantidadImagenes"));
            int regimenAlimentario = Integer.parseInt(request.getParameter("regimenAlimentarioAlojamiento"));
            int temporada = Integer.parseInt(request.getParameter("temporadaAlojamiento"));
            int pais = Integer.parseInt(request.getParameter("Pais"));
            int provincia = Integer.parseInt(request.getParameter("Provincia"));
            int ciudad = Integer.parseInt(request.getParameter("Ciudad"));
            int barrio = Integer.parseInt(request.getParameter("Barrio"));
            String calleDomicilio = request.getParameter("calleDomicilio");
            String nroDomicilio = request.getParameter("nroDomicilio");
            String departamentoDomicilio = request.getParameter("departamentoDomicilio");
            String torreDomicilio = request.getParameter("torreDomicilio");
            String manzanaDomicilio = request.getParameter("manzanaDomicilio");
            String loteDomicilio = request.getParameter("loteDomicilio");
            String codigoPostalDomicilio = request.getParameter("codigoPostalDomicilio");
            int cantidadContactos = Integer.parseInt(request.getParameter("masContacto"));
            if(nombre.isEmpty())
                out.println("El campo nombre es obligatorio.");
            else{
                if(descripcion.isEmpty()){
                    out.println("El campo descripción es obligatorio.");
                }else{
                    if(prioridad >= 0){
                        out.println("El campo priridad debe ser mayor a 0.");
                    }else{
                        if(estado == 0){
                            out.println("El campo estado es obligatorio.");
                        }else{
                            if(cliente == 0){
                                out.println("El campo cliente es obligatorio.");
                            }else{
                                if(cantidadImagenes < 1){
                                    out.println("El campo imagen es obligatorio.");
                                }else{
                                    if(regimenAlimentario == 0){
                                        out.println("El campo regimenAlimentario es obligatorio.");
                                    }else{
                                        if(temporada == 0){
                                            out.println("El campo temporada es obligatorio.");
                                        }else{
                                            if(pais == 0){
                                                out.println("El campo pais es obligatorio.");
                                            }else{
                                                if(provincia == 0){
                                                    out.println("El campo provincia es obligatorio.");
                                                }else{
                                                    if(ciudad == 0){
                                                        out.println("El campo ciudad es obligatorio.");
                                                    }else{
                                                        if(barrio == 0){
                                                            out.println("El campo barrio es obligatorio.");
                                                        }else{
                                                            if(calleDomicilio.isEmpty()){
                                                                out.println("El campo calle es obligatorio.");
                                                            }else{
                                                                if(nroDomicilio.isEmpty()){
                                                                    out.println("El campo número es obligatorio.");
                                                                }else{
                                                                    if(codigoPostalDomicilio.isEmpty()){
                                                                        out.println("El campo código postal es obligatorio.");
                                                                    }else{
                                                                        if(cantidadContactos < 1){
                                                                            out.println("Se debe cargar al menos un contacto.");
                                                                        }else{
                                                                            //Si estan completos todos los campos obligatorios
                                                                            new Alojamiento(request.getParameter("nombreAlojamiento"), request.getParameter("descripcionAlojamient"),2,2,3,1,1,1,1,Fechas.fechaActual(),Integer.parseInt(request.getParameter("pririodadAlojamiento")));
                                                                            out.println("OK");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }                                           
                                    }
                                }
                            }
                        }
                    }
                }
            }            
        }catch (NumberFormatException ex){
            out.println(ex.toString());        
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

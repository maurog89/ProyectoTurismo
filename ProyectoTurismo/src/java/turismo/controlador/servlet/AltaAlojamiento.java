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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import turismo.entidades.Alojamiento;
import turismo.entidades.Contacto;
import turismo.entidades.Domicilio;
import turismo.entidades.Fechas;
import turismo.entidades.SubirImagen;
import turismo.entidades.VerificarFotos;

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
        PrintWriter out = response.getWriter();
        try {
            
            String nombre = request.getParameter("nombreAlojamiento");
            String descripcion = request.getParameter("descripcionAlojamiento");            
            int prioridad = -1;            
            if(!request.getParameter("pririodadAlojamiento").isEmpty())
                prioridad = Integer.parseInt(request.getParameter("pririodadAlojamiento"));
            int estado = -1;
            if(!request.getParameter("estadoAlojamiento").isEmpty())
                estado = Integer.parseInt(request.getParameter("estadoAlojamiento"));
            int cliente = -1;
            if(!request.getParameter("clienteAlojamientor").isEmpty())
                cliente = Integer.parseInt(request.getParameter("clienteAlojamientor"));
            int cantidadImagenes = -1;
            if(!request.getParameter("cantidadImagenes").isEmpty())
                cantidadImagenes = Integer.parseInt(request.getParameter("cantidadImagenes"));
            int regimenAlimentario = - 1;
            if(!request.getParameter("regimenAlimentarioAlojamiento").isEmpty())
                regimenAlimentario = Integer.parseInt(request.getParameter("regimenAlimentarioAlojamiento"));
            int temporada = -1;
            if(!request.getParameter("temporadaAlojamiento").isEmpty())
                temporada = Integer.parseInt(request.getParameter("temporadaAlojamiento"));
            int pais = -1;
            if(!request.getParameter("Pais").isEmpty())
                pais = Integer.parseInt(request.getParameter("Pais"));
            int provincia = -1;
            if(!request.getParameter("Provincia").isEmpty())
                provincia = Integer.parseInt(request.getParameter("Provincia"));
            int ciudad = -1;
            if(!request.getParameter("Ciudad").isEmpty())
                ciudad = Integer.parseInt(request.getParameter("Ciudad"));
            int barrio = -1;
            if(!request.getParameter("Barrio").isEmpty())
                barrio = Integer.parseInt(request.getParameter("Barrio"));
            String calleDomicilio = request.getParameter("calleDomicilio");
            String nroDomicilio = request.getParameter("nroDomicilio");
            String nroPiso = request.getParameter("nroPiso");
            String departamentoDomicilio = request.getParameter("departamentoDomicilio");
            String torreDomicilio = request.getParameter("torreDomicilio");
            String manzanaDomicilio = request.getParameter("manzanaDomicilio");
            String loteDomicilio = request.getParameter("loteDomicilio");
            String codigoPostalDomicilio = request.getParameter("codigoPostalDomicilio");
            int cantidadContactos = -1;
            if(!request.getParameter("cantidadContactosss").isEmpty())
                cantidadContactos = Integer.parseInt(request.getParameter("cantidadContactosss"));
            int tipoContacto = -1;
            if(!request.getParameter("tipoContacto").isEmpty())
                tipoContacto = Integer.parseInt(request.getParameter("tipoContacto"));
            String detalleContactos = request.getParameter("detalleContactos");
            
            
            
            
            
            
            if(nombre.isEmpty())
                out.println("El campo nombre es obligatorio.");
            else{
                if(descripcion.isEmpty()){
                    out.println("El campo descripción es obligatorio.");
                }else{
                    if(prioridad <= 0){
                        out.println("El campo priridad debe ser mayor o igual a 0.");
                    }else{
                        if(estado <= 0){
                            out.println("El campo estado es obligatorio.");
                        }else{
                            if(cliente <= 0){
                                out.println("El campo cliente es obligatorio.");
                            }else{
                                if(cantidadImagenes < 1){
                                    out.println("El campo imagen es obligatorio.");
                                }else{
                                    if(regimenAlimentario <= 0){
                                        out.println("El campo regimenAlimentario es obligatorio.");
                                    }else{
                                        if(temporada <= 0){
                                            out.println("El campo temporada es obligatorio.");
                                        }else{
                                            if(pais <= 0){
                                                out.println("El campo pais es obligatorio.");
                                            }else{
                                                if(provincia <= 0){
                                                    out.println("El campo provincia es obligatorio.");
                                                }else{
                                                    if(ciudad <= 0){
                                                        out.println("El campo ciudad es obligatorio.");
                                                    }else{
                                                        if(barrio <= 0){
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
                                                                            
                                                                            Part img = request.getPart("imagenAlojamiento1");
                                                                            String tipoImagen = VerificarFotos.verificarFoto(img);
                                                                            if(tipoImagen.equals("formatoInvalido")){
                                                                                out.println("Solo pueden cargarse fotos en jpg,pgn y gif.");
                                                                            }else{
                                                                                //Si estan completos todos los campos obligatorios
                                                                                int idUltimaImagen = SubirImagen.SubirImagen(VerificarFotos.crearStreamFoto(img),tipoImagen,1);
                                                                                Domicilio dom = new Domicilio(calleDomicilio,nroDomicilio,nroPiso,departamentoDomicilio,torreDomicilio,manzanaDomicilio,loteDomicilio,codigoPostalDomicilio,barrio);
                                                                                Contacto con = new Contacto(detalleContactos,tipoContacto);
                                                                                int idContacto = con.getId();
                                                                                if(cantidadContactos > 1){
                                                                                    for(int i = 2; i <= cantidadContactos;i++){
                                                                                        int tipo = Integer.parseInt(request.getParameter("tipoContacto"+i));
                                                                                        String detalle = request.getParameter("detalleContactos"+i);
                                                                                        Contacto cont = new Contacto(detalle,tipo);
                                                                                        cont.setContactoAnterior(con.getId());
                                                                                        if(i == cantidadContactos)
                                                                                            idContacto = cont.getId();
                                                                                    }
                                                                                }
                                                                                if(cantidadImagenes > 1){
                                                                                    for(int i = 2; i <= cantidadImagenes;i++){
                                                                                        img = request.getPart("imagenAlojamiento"+i);
                                                                                        tipoImagen = VerificarFotos.verificarFoto(img);
                                                                                        if(tipoImagen.equals("formatoInvalido")){
                                                                                            out.println("Solo pueden cargarse fotos en jpg,pgn y gif. Verifique la imagen numero: "+i+".");
                                                                                        }else{
                                                                                            idUltimaImagen = SubirImagen.SubirImagen(VerificarFotos.crearStreamFoto(img),tipoImagen,idUltimaImagen);
                                                                                        }
                                                                                            
                                                                                    }
                                                                                }
                                                                                new Alojamiento(nombre, descripcion,cliente,idContacto,dom.getId(),estado,idUltimaImagen,regimenAlimentario,temporada,Fechas.fechaActual(),prioridad);
                                                                                out.println("Alojamiento cargado.");
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
            }
            
           
                        
        }catch (NumberFormatException ex){
            out.println(ex.toString());        
        } catch (SQLException ex) {
            out.println(ex.toString());
        } catch (Exception ex) {
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

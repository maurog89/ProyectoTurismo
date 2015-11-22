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
import turismo.entidades.Ciudad;
import turismo.entidades.Fechas;

/**
 *
 * @author matiascanodesarrollos
 */
public class AltaCiudad extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * 
     * 
     */
        
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        int imagen = -1;
        String nombre = "";
        boolean capital = false;
        int prioridad = -1;
        int provincia = -1;
        String historia = "";
        String emergencia = "";        
        int cliente = -1;
        int observaciones = -1;
        
        if(request.getParameter("imagenCiudad") != null)
            imagen = 1;
        
        if(!request.getParameter("capital").isEmpty())
            capital = request.getParameter("capital").equals("1");
        
        if(!request.getParameter("nombreCuidad").isEmpty())
            nombre = request.getParameter("nombreCuidad");
        
        if(!request.getParameter("pririodadCuidad").isEmpty())
            prioridad = Integer.parseInt(request.getParameter("pririodadCuidad"));
        
        if(!request.getParameter("Provincia").isEmpty())
            provincia = Integer.parseInt(request.getParameter("Provincia"));
        
        if(!request.getParameter("historiaPais").isEmpty())
            historia = request.getParameter("historiaPais");
        
        if(!request.getParameter("emergenciaPais").isEmpty())
            emergencia = request.getParameter("emergenciaPais");
        
        if(!request.getParameter("idClienteCiudad").isEmpty())
            cliente = Integer.parseInt(request.getParameter("idClienteCiudad"));
        
        if(!request.getParameter("ciudadObservaciones").isEmpty())
            observaciones = 1;
        
        try {
            // Primero valido los campos obligatorios
        
            if(nombre.isEmpty())
                out.println("El campo nombre es obligatorio");
            else{
                if(request.getParameter("capital").isEmpty())
                    out.println("El campo capital es obligatorio");
                else{
                    if(prioridad == -1)
                        out.println("El campo prioridad es obligatorio");
                    else{                        
                        if(request.getParameter("Provincia").isEmpty())
                            out.println("El campo provincia es obligatorio");
                        else{                        
                            if(historia.isEmpty()){
                                if(emergencia.isEmpty()){
                                    if(cliente == -1){
                                        if(observaciones == -1){
                                            if(imagen == -1){
                                                new Ciudad(nombre,capital,provincia,Fechas.fechaActual(),prioridad);
                                                out.println("Ciudad cargada");
                                            }else{
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"HistoriaEmergenciasClienteObservaciones");
                                                out.println("Constructor sin historia,emergencias,cliente y observaciones");
                                                out.println("Ciudad cargada");
                                            }
                                        }else{
                                            new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"HistoriaEmergenciasCliente");
                                            out.println("Constructor sin historia,emergencias y cliente");
                                            out.println("Ciudad cargada");
                                        }
                                    }else{
                                        if(observaciones == -1){
                                            if(imagen == -1){
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"HistoriaEmergenciasObservacionesImagenes");
                                                out.println("Constructor sin historia,emergencias, observaciones y imagenes");
                                                out.println("Ciudad cargada");
                                            }else{
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"HistoriaEmergenciasObservaciones");
                                                out.println("Constructor sin historia,emergencias y observaciones");
                                                out.println("Ciudad cargada");
                                            }
                                        }else{
                                            if(imagen == -1){
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"HistoriaEmergenciasImagenes");
                                                out.println("Constructor sin historia,emergencias y imagenes");
                                                out.println("Ciudad cargada");
                                            }else{
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"HistoriaEmergencias");
                                                out.println("Constructor sin historia y emergencias");
                                                out.println("Ciudad cargada");
                                            }
                                        }
                                    }
                                }else{
                                    if(cliente == -1){
                                        if(observaciones == -1){
                                            if(imagen == -1){
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"HistoriaClienteObservacionesImagen");
                                                out.println("Constructor sin historia, cliente, observaciones e imagen");
                                                out.println("Ciudad cargada");
                                            }else{
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"HistoriaClienteObservaciones");
                                                out.println("Constructor sin historia, cliente y observaciones");
                                                out.println("Ciudad cargada");
                                            }
                                        }else{
                                            if(imagen == -1){
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"HistoriaClienteImagen");
                                                out.println("Constructor sin historia, cliente y imagen");
                                                out.println("Ciudad cargada");
                                            }else{
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"HistoriaCliente");
                                                out.println("Constructor sin historia, cliente");
                                            }
                                        }
                                    }else{
                                        if(observaciones == -1){
                                            if(imagen == -1){
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"HistoriaObservacionesImagen");
                                                out.println("Constructor sin historia, observaciones e imagen");
                                                out.println("Ciudad cargada");
                                            }else{
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"HistoriaImagen");
                                                out.println("Constructor sin historia e imagen");
                                                out.println("Ciudad cargada");
                                            }
                                        }else{
                                            if(imagen == -1){
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"HistoriaImagen");
                                                out.println("Constructor sin historia e imagen");
                                                out.println("Ciudad cargada");
                                            }else{
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"Historia");
                                                out.println("Constructor sin historia");
                                            }
                                        }
                                    }
                                }
                            }else{
                                if(emergencia.isEmpty()){
                                    if(cliente == -1){
                                        if(observaciones == -1){
                                            if(imagen == -1){
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"EmergenciasClienteObservacionesImagenes");
                                                out.println("Constructor sin emergencias,cliente, observaciones e imagenes");
                                                out.println("Ciudad cargada");
                                            }else{
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"EmergenciasClienteObservaciones");
                                                out.println("Constructor sin emergencias,cliente y observaciones");
                                                out.println("Ciudad cargada");
                                            }
                                        }else{
                                            if(imagen == -1){
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"EmergenciasClienteImagenes");
                                                out.println("Constructor sin emergencias,cliente e imagenes");
                                                out.println("Ciudad cargada");
                                            }else{
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"EmergenciasCliente");
                                                out.println("Constructor sin emergencias,cliente");
                                                out.println("Ciudad cargada");
                                            }
                                        }
                                    }else{
                                        if(observaciones == -1){
                                            if(imagen == -1){
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"EmergenciasObservacionesImagenes");
                                                out.println("Constructor sin emergencias, observaciones e imagenes");
                                                out.println("Ciudad cargada");
                                            }else{
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"EmergenciasObservaciones");
                                                out.println("Constructor sin emergencias y observaciones");
                                                out.println("Ciudad cargada");
                                            }
                                        }else{
                                            if(imagen == -1){
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"EmergenciasImagen");
                                                out.println("Constructor sin emergencias e imagenes");
                                                out.println("Ciudad cargada");
                                            }else{
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"Emergencias");
                                                out.println("Constructor sin emergencias");
                                                out.println("Ciudad cargada");
                                            }
                                        }
                                    }
                                }else{
                                    if(cliente == -1){
                                        if(observaciones == -1){
                                            if(imagen == -1){
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"ClienteObservacionesImagenes");
                                                out.println("Constructor sin cliente, observaciones e imagenes");
                                                out.println("Ciudad cargada");
                                            }else{
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"ClienteObservaciones");
                                                out.println("Constructor sin cliente y observaciones");
                                                out.println("Ciudad cargada");
                                            }
                                        }else{
                                            if(imagen == -1){
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"ClienteImagenes");
                                                out.println("Constructor sin cliente e imagenes");
                                                out.println("Ciudad cargada");
                                            }else{
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"Cliente");
                                                out.println("Constructor sin cliente");
                                                out.println("Ciudad cargada");
                                            }
                                        }
                                    }else{
                                        if(observaciones == -1){
                                            if(imagen == -1){
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"ObservacionesImagenes");
                                                out.println("Constructor sin observaciones e imagenes");
                                                out.println("Ciudad cargada");
                                            }else{
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"Observaciones");
                                                out.println("Constructor sin observaciones");
                                                out.println("Ciudad cargada");
                                            }
                                        }else{
                                            if(imagen == -1){
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad,"Imagenes");
                                                out.println("Constructor sin imagenes");
                                                out.println("Ciudad cargada");
                                            }else{
                                                new Ciudad(nombre,historia,emergencia,capital,observaciones,provincia,Fechas.fechaActual(),cliente,imagen,prioridad);
                                                out.println("Constructor completo");
                                                out.println("Ciudad cargada");
                                            }
                                        }
                                    }
                                    
                                }
                                
                            }                   
                        }            
                               
                        }
                    }
                }
        } catch (Exception ex){
            out.println(ex.getMessage());
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
            throws ServletException, IOException{
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

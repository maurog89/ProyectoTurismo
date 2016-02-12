/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.io.PrintWriter;

/**
 *
 * @author matiascanodesarrollos
 */
public class ImprimirHTML {
    public static void imprimirEtiquetasIniciales(PrintWriter out,String titulo){
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>"+titulo+"</title>");
        out.println("</head>");
        out.println("<body>");
    }
    
    public static void imprimirEtiquetasFinal(PrintWriter out){
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
    public static void imprimirErrorDeMetodo(PrintWriter out){
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
    
    public static void InterfaceDeGestion(PrintWriter out){
        imprimirEtiquetasIniciales(out,"Interfaz de Gestión");
        out.write("<form method=\"post\" action=\"ABM\">\n" +
"            <h1>Interface de gestión: </h1>               \n" +
"            <table>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Alojamiento</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Barrio</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Ciudad</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Categoria Restaurante</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Clintes</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Contactos</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Detalle Excursión</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Domicilio</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Empresa De Transporte</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Estado</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Eventos</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Excursiones</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Facturas</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Habitación</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Immagen</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Lugares de Interes</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Mapa</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Medio de Transporte</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Noticias</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Observaciones</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Paises</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Permisos</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Provincias</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Regimenes Alimentarios</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Sitios para comer</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Temporadas</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Tipos de Comida</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Tipos de Contacto</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Tipos de Contacto</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Tipos de Documento</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Tipos de Eventos</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Tipos de Factura</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Tipos de Habitación</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Tipos de Permiso</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"                <tr>\n" +
"                    <td>\n" +
"                        <p>Tipos de Venimiento</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                    <td>\n" +
"                        <p>Usuarios</p>\n" +
"                        <input type=\"submit\" value=\"Alta\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Modificación\" onclick=\"procesarSolicitud(this);\" />\n" +
"                        <input type=\"submit\" value=\"Baja\" onclick=\"procesarSolicitud(this);\" />\n" +
"                    </td>\n" +
"                </tr>\n" +
"            </table>\n" +
"            <br/>\n" +
"            <br/>\n" +
"            <input type=\"button\" value=\"Cerrar Sesion\" id=\"cerrarSesion\"/>\n" +
"            <input type=\"text\" name=\"valor\" style=\"display:none;\" id=\"bot\"/>\n" +
"            <input type=\"text\" name=\"boton\" style=\"display:none;\" id=\"boton\"/>\n" +
"        </form>\n" +
"        <script type=\"text/javascript\">\n" +
"            document.getElementById(\"cerrarSesion\").onclick = function(){\n" +
"                location.href = \"cerrarSesion\";\n" +
"            };\n" +
"            function procesarSolicitud(botonPresionado){\n" +
"                document.getElementById(\"bot\").value = botonPresionado.parentNode.childNodes[1].innerHTML;\n" +
"                document.getElementById(\"boton\").value = botonPresionado.value;\n" +
"            };\n" +
"        </script>");
        imprimirEtiquetasFinal(out);
    }
    
    public static void InterfaceDeGestionError(PrintWriter out,String mensaje){
        imprimirEtiquetasIniciales(out,"Privilegios Insuficientes");
        out.println("<h1>" + mensaje + "</h1>");
        imprimirEtiquetasFinal(out);
    }
    
    public static void cargaAlojamiento(PrintWriter out){
        imprimirEtiquetasIniciales(out,"ABM Alojamiento - Alta");
        out.write("<script src=\"js/buscar.js\"></script><form method=\"POST\" action=\"AltaAlojamiento\" enctype=\"multipart/form-data\" >\n" +
"            <table>\n" +
"                    <thead>\n" +
"                        <tr>\n" +
"                            <th>ABM Alojamiento - Alta</th>\n" +
"                        </tr>\n" +
"                    </thead>\n" +
"                    <tbody>\n" +
"                        <tr>\n" +
"                        <td><label for=\"nombreAlojamiento\">Nombre: </label></td>\n" +
"                        <td><input type=\"text\" name=\"nombreAlojamiento\" id=\"nombreAlojamiento\" value=\"\" /></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"descripcionAlojamiento\">Descripcion: </label></td>\n" +
"                        <td><textarea name=\"descripcionAlojamiento\" id=\"descripcionAlojamiento\" /></textarea></td>\n" +
"                    </tr> \n" +
"                    <tr>\n" +
"                        <td><label for=\"pririodadAlojamiento\">Prioridad: </label></td>\n" +
"                        <td><input type=\"number\" name=\"pririodadAlojamiento\" id=\"pririodadAlojamiento\" value=\"\" /></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"estadoAlojamiento\">Estado: </label></td>\n" +
"                        <td><select name=\"estadoAlojamiento\" id=\"estadoAlojamiento\">\n" +
"                                <option value=\"x0\"> --- </option>\n" +
"                            </select></td>                    \n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"clienteAlojamiento\">Id Cliente: </label></td>\n" +
"                        <td><select name=\"clienteAlojamiento\" id=\"clienteAlojamientoSel\">\n" +
"                                <option value=\"x0\"> --- </option>\n" +
"                            </select>\n" +
"                            <input type=\"text\" name=\"clienteAlojamientor\" id=\"clienteAlojamiento\" value=\"\" />\n" +
"                        </td>\n" +
"                    </tr>\n" +
"                    <tr id=\"imagen1\">                        \n" +
"                        <td><label for=\"imagen1\">Imagen: </label></td>\n" +
"                        <td><input type=\"file\" name=\"imagen1\" id=\"imagenAlojamiento1\" /></td>\n" +
"                        <td><input type=\"button\" name=\"subirAlojamiento\" id=\"subirAlojamiento\" value=\"Subir Otra Imagen\"/></td>\n" +
"                        <input style=\"display:none\" name=\"cantidadImagenes\" id=\"cantidadImagenes\" />\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"regimenAlimentarioAlojamiento\">Regimen Alimentario: </label></td>\n" +
"                        <td><select name=\"regimenAlimentarioAlojamiento\" id=\"regimenAlimentarioAlojamiento\">\n" +
"                                <option value=\"x0\"> --- </option>\n" +
"                            </select></td>                        \n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"temporadaAlojamiento\">Temporada: </label></td>\n" +
"                        <td><select name=\"temporadaAlojamiento\" id=\"temporadaAlojamiento\">\n" +
"                                <option value=\"x0\"> --- </option>\n" +
"                            </select></td>\n" +
"                    </tr>\n" +
"                    <tr><td><br /></td></tr>\n" +
"                    <tr><td><br /></td></tr>\n" +
"                    <tr><td><br /></td></tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"Pais\">Pais: </label></td>\n" +
"                        <td><select name=\"Pais\" id=\"Pais\">\n" +
"                                <option value=\"x0\"> --- </option>\n" +
"                            </select></td>\n" +
"                    <tr>\n" +
"                        <td><label for=\"Provincia\">Provincia: </label></td>\n" +
"                        <td><select name=\"Provincia\" id=\"Provincia\">\n" +
"                                <option value=\"x0\"> --- </option>\n" +
"                            </select></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"Ciudad\">Ciudad: </label></td>\n" +
"                        <td><select name=\"Ciudad\" id=\"Ciudad\">\n" +
"                                <option value=\"x0\"> --- </option>\n" +
"                            </select></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"Barrio\">Barrio: </label></td>\n" +
"                        <td><select name=\"Barrio\" id=\"Barrio\">\n" +
"                                <option value=\"x0\"> --- </option>\n" +
"                            </select></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"calleDomicilio\">Calle: </label></td>\n" +
"                        <td><input type=\"text\" name=\"calleDomicilio\" id=\"calleDomicilio\" /></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"nroDomicilio\">Número: </label></td>\n" +
"                        <td><input type=\"text\" name=\"nroDomicilio\" id=\"nroDomicilio\" value=\"\" /></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"nroPiso\">Piso: </label></td>\n" +
"                        <td><input type=\"text\" name=\"nroPiso\" id=\"nroPiso\" value=\"\" /></td>\n" +
"                    </tr>                    \n" +
"                    <tr>\n" +
"                        <td><label for=\"departamentoDomicilio\">Departamento: </label></td>\n" +
"                        <td><input type=\"text\" name=\"departamentoDomicilio\" id=\"departamentoDomicilio\" value=\"\" /></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"torreDomicilio\">Torre: </label></td>\n" +
"                        <td><input type=\"text\" name=\"torreDomicilio\" id=\"torreDomicilio\" value=\"\" /></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"manzanaDomicilio\">Manzana: </label></td>\n" +
"                        <td><input type=\"text\" name=\"manzanaDomicilio\" id=\"manzanaDomicilio\" value=\"\" /></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"loteDomicilio\">Lote: </label></td>\n" +
"                        <td><input type=\"text\" name=\"loteDomicilio\" id=\"loteDomicilio\" value=\"\" /></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"codigoPostalDomicilio\">Código Postal: </label></td>\n" +
"                        <td><input type=\"text\" name=\"codigoPostalDomicilio\" id=\"codigoPostalDomicilio\" value=\"\" /></td>\n" +
"                    </tr>\n" +
"                    </tbody>\n" +
"                </table>\n" +
"                <br />\n" +
"                <br />\n" +
"                <br />\n" +
"                <table>\n" +
"                    <thead>\n" +
"                        <tr>\n" +
"                            <th>ABM Alojamiento - Contactos</th>\n" +
"                        </tr>\n" +
"                    </thead>\n" +
"                    <tbody id=\"contactos\">\n" +
"                        <tr>\n" +
"                            <td><label for=\"tipoContacto1\">Tipo de Contacto: </label></td>\n" +
"                            <td><select name=\"tipoContacto1\" id=\"tipoContacto\">\n" +
"                                    <option value=\"x0\"> --- </option>\n" +
"                                </select></td>\n" +
"                            <td><input type=\"button\" name=\"+tipoContacto\" id=\"masContacto\" value=\"-\"/></td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td><label for=\"detalleContactos1\">Detalle: </label></td>\n" +
"                            <td><input type=\"text\" name=\"detalleContactos1\" id=\"detalleContactos\" value=\"\" /></td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td><input type=\"button\" value=\"Agregar Contacto\" name=\"envContacto\" id=\"envContacto\" />\n" +
"                                <input style=\"display:none\" id=\"cantidadContactos\" name=\"cantidadContactos\" /></td>\n" +
"                        </tr>       \n" +
"                    </tbody>\n" +
"                </table>\n" +
"            <input type=\"submit\" value=\"Enviar\" name=\"envDetalle\" />\n" +
"        </form>\n" +
"        <script>\n" +
"        // Guardo en variables los elementos que necesito del DOM\n" +
"        var pais = document.getElementById(\"Pais\");\n" +
"        var provincia = document.getElementById(\"Provincia\");\n" +
"        var ciudad = document.getElementById(\"Ciudad\");\n" +
"        var barrio = document.getElementById(\"Barrio\");\n" +
"        var idCliente = document.getElementById(\"clienteAlojamiento\");\n" +
"        var clienteSel = document.getElementById(\"clienteAlojamientoSel\");\n" +
"        var cantidadContactos = 1;\n" +
"        var cantidadImagenes = 0;\n" +
"        var camposImagen = 1;\n" +
"        var eliminarCotacto = document.getElementById(\"masContacto\");\n" +
"        var subirAlojamiento = document.getElementById(\"subirAlojamiento\"); \n" +
"        var archivo1 = document.getElementById(\"imagenAlojamiento1\");\n" +
"        document.getElementById(\"cantidadImagenes\").value = 0;\n" +
"        /* \n" +
"         * Manejo los eventos        \n" +
"        */\n" +
"        \n" +
"        \n" +
"        //Aumento el contacdor de imagenes\n" +
"        archivo1.onchange = function(){\n" +
"            if(this.files[0] == null){\n" +
"                cantidadImagenes--;\n" +
"            }else{\n" +
"                cantidadImagenes++;\n" +
"            }            \n" +
"            document.getElementById(\"cantidadImagenes\").value = cantidadImagenes;\n" +
"        };\n" +
"        \n" +
"        //Evento utilizado para saber si se cargo algun contacto\n" +
"        document.getElementById(\"tipoContacto\").onchange = function(){\n" +
"            if(document.getElementById(\"cantidadContactos\").value === \"\") \n" +
"                document.getElementById(\"cantidadContactos\").value = 1;\n" +
"        };\n" +
"        \n" +
"        \n" +
"        //Evento para agregar mas imagenes        \n" +
"        subirAlojamiento.onclick = function(){\n" +
"            camposImagen++;\n" +
"            var fila = document.createElement(\"tr\");\n" +
"            fila.setAttribute(\"id\",\"imagen\"+camposImagen);\n" +
"            var campoLabel = fila.insertCell(0);\n" +
"            var campoFile = fila.insertCell(1);\n" +
"            var campoBoton = fila.insertCell(2);\n" +
"            var label = document.createElement(\"Label\");\n" +
"            label.setAttribute(\"for\",\"imagen\"+camposImagen);\n" +
"            label.setAttribute(\"id\",\"labelImagenAlojamiento\"+camposImagen);\n" +
"            label.innerHTML = \"Imagen \"+camposImagen+\": \";\n" +
"            campoLabel.appendChild(label);\n" +
"            var input = document.createElement(\"Input\");\n" +
"            input.setAttribute(\"type\",\"file\");\n" +
"            input.setAttribute(\"name\",\"imagen\"+camposImagen);\n" +
"            input.setAttribute(\"id\",\"imagenAlojamiento\"+camposImagen);\n" +
"            input.onchange =  function(){\n" +
"                if(this.files[0] == null){\n" +
"                    cantidadImagenes--;\n" +
"                }else{\n" +
"                    cantidadImagenes++;\n" +
"                }            \n" +
"                document.getElementById(\"cantidadImagenes\").value = cantidadImagenes;\n" +
"            };\n" +
"            campoFile.appendChild(input);\n" +
"            var boton = document.createElement(\"Input\");\n" +
"            boton.setAttribute(\"type\",\"button\");\n" +
"            boton.setAttribute(\"name\",\"sacarImagen\"+camposImagen);\n" +
"            boton.setAttribute(\"id\",\"sacarImagen\"+camposImagen);\n" +
"            boton.setAttribute(\"value\",\"-\");\n" +
"            boton.onclick = function(){                \n" +
"                var borrar = parseInt(this.id[11]);\n" +
"                if(this.parentNode.parentNode.childNodes[1].childNodes[0].files[0] != null){\n" +
"                    cantidadImagenes--;\n" +
"                    document.getElementById(\"cantidadImagenes\").value = cantidadImagenes;\n" +
"                }\n" +
"                this.parentNode.parentNode.remove();                \n" +
"                for(var i = 1; i <= camposImagen;i++){\n" +
"                    if(i > borrar){\n" +
"                        var j = i - 1;\n" +
"                        var lab = document.getElementById(\"labelImagenAlojamiento\"+i);\n" +
"                        var fil = document.getElementById(\"imagenAlojamiento\"+i);           \n" +
"                        var bot = document.getElementById(\"sacarImagen\"+i);\n" +
"                        var fila = document.getElementById(\"imagen\"+i);\n" +
"                        lab.attributes[0] = \"imagen\"+j;\n" +
"                        lab.innerHTML = \"Imagen \"+j+\":\";\n" +
"                        lab.id = \"labelImagenAlojamiento\"+j;\n" +
"                        fil.id = \"imagenAlojamiento\"+j;\n" +
"                        fil.name = \"imagen\"+j;\n" +
"                        bot.id = \"sacarImagen\"+j;\n" +
"                        bot.name = \"sacarImagen\"+j;\n" +
"                        fila.id = \"imagen\"+j;\n" +
"                    }\n" +
"                    \n" +
"                }\n" +
"                camposImagen--;\n" +
"                \n" +
"            };\n" +
"            campoBoton.appendChild(boton);\n" +
"            var bus = camposImagen - 1;\n" +
"            insertAfter(document.getElementById(\"imagen\"+bus),fila);\n" +
"        };\n" +
"                \n" +
"        //Eliminar Contacto\n" +
"        eliminarCotacto.onclick = function(){\n" +
"            this.parentNode.parentNode.nextSibling.nextSibling.remove();\n" +
"            this.parentNode.parentNode.remove();\n" +
"            document.getElementById(\"cantidadContactos\").value = --cantidadContactos;\n" +
"        };\n" +
"        \n" +
"        // Agregar contacto\n" +
"        document.getElementById(\"envContacto\").onclick = function(){\n" +
"            var tabla = document.getElementById(\"contactos\");\n" +
"            var filaTipoContacto = tabla.insertRow(0);\n" +
"            var filaDetalle = tabla.insertRow(1);\n" +
"            tabla.insertRow(2).appendChild(document.createElement(\"Br\"));\n" +
"            var labelDetalle = filaDetalle.insertCell(0);\n" +
"            var inputDetalle = filaDetalle.insertCell(1);\n" +
"            var labelTipoContacto = filaTipoContacto.insertCell(0);\n" +
"            var selectTipoContacto = filaTipoContacto.insertCell(1);\n" +
"            var buttonTipoContacto = filaTipoContacto.insertCell(2);\n" +
"            var label = document.createElement(\"Label\");            \n" +
"            cantidadContactos++;\n" +
"            label.setAttribute(\"for\",\"tipoContacto\"+cantidadContactos);\n" +
"            label.innerHTML = \"Tipo de Contacto: \";\n" +
"            labelTipoContacto.appendChild(label);\n" +
"            var select = document.createElement(\"Select\");\n" +
"            var option = document.createElement(\"Option\");\n" +
"            select.setAttribute(\"name\",\"tipoContacto\"+cantidadContactos);\n" +
"            select.setAttribute(\"id\",\"tipoContacto\"+cantidadContactos);\n" +
"            option.setAttribute(\"value\",\"0\");\n" +
"            option.innerHTML = \"---\";\n" +
"            select.appendChild(option);\n" +
"            selectTipoContacto.appendChild(select);\n" +
"            buscarServlet(\"TipoContacto\",document.getElementById(\"tipoContacto\"+cantidadContactos));\n" +
"            var boton = document.createElement(\"Input\");\n" +
"            boton.setAttribute(\"type\",\"button\");\n" +
"            boton.setAttribute(\"name\",\"+tipoContacto\"+cantidadContactos);\n" +
"            boton.setAttribute(\"id\",\"+tipoContacto\"+cantidadContactos);\n" +
"            boton.setAttribute(\"value\",\"-\");\n" +
"            boton.onclick = function(){\n" +
"                this.parentNode.parentNode.nextSibling.remove();\n" +
"                this.parentNode.parentNode.nextSibling.remove();\n" +
"                this.parentNode.parentNode.remove();\n" +
"                document.getElementById(\"cantidadContactos\").value = --cantidadContactos;\n" +
"            };\n" +
"            buttonTipoContacto.appendChild(boton);\n" +
"            var label2 = document.createElement(\"Label\");\n" +
"            label2.setAttribute(\"for\",\"detalleContactos\"+cantidadContactos);\n" +
"            label2.innerHTML = \"Detalle: \";\n" +
"            labelDetalle.appendChild(label2);\n" +
"            var input = document.createElement(\"Input\");\n" +
"            input.setAttribute(\"type\",\"text\");\n" +
"            input.setAttribute(\"name\",\"detalleContactos\"+cantidadContactos);\n" +
"            input.setAttribute(\"type\",\"detalleContactos\"+cantidadContactos);\n" +
"            inputDetalle.appendChild(input);                \n" +
"            document.getElementById(\"cantidadContactos\").value = cantidadContactos;\n" +
"        };\n" +
"        \n" +
"        // Funcion de cambia automaticamente el cliente\n" +
"        idCliente.onchange = function(){\n" +
"            var index = 0;\n" +
"            for(var i = 0;i<clienteSel.length;i++){\n" +
"                if(clienteSel[i].value == idCliente.value){\n" +
"                    index = i;\n" +
"                    break;\n" +
"                }\n" +
"            }            \n" +
"            clienteSel[index].selected = true;\n" +
"        };\n" +
"        clienteSel.onchange = function(){\n" +
"            if(this.value != \"x0\")\n" +
"                idCliente.value = clienteSel[clienteSel.selectedIndex].value;\n" +
"            else\n" +
"                idCliente.value = \"\";\n" +
"        };\n" +
"        \n" +
"               \n" +
"        //Funcion de cambiar provincia cuando cambia el pais\n" +
"        pais.onchange = function(){            \n" +
"            provincia.options.length = 0;\n" +
"            agregarOpcion(provincia);\n" +
"            var res = pais[pais.selectedIndex].value;\n" +
"            buscarServlet(\"Provincia\",provincia,res);\n" +
"        };\n" +
"        \n" +
"        //Funcion de cambiar ciudad cuando cambia la provincia\n" +
"        provincia.onchange = function(){            \n" +
"            ciudad.options.length = 0;\n" +
"            agregarOpcion(ciudad);\n" +
"            var res = provincia[provincia.selectedIndex].value;\n" +
"            buscarServlet(\"Ciudad\",ciudad,res);\n" +
"        };\n" +
"        \n" +
"        //Funcion de cambiar el barrio cuando cambia la ciudad\n" +
"        ciudad.onchange = function(){            \n" +
"            barrio.options.length = 0;\n" +
"            agregarOpcion(barrio);\n" +
"            var res = ciudad[ciudad.selectedIndex].value;\n" +
"            buscarServlet(\"Barrio\",barrio,res);\n" +
"        };\n" +
"        \n" +
"        /*\n" +
"         * Buscar elementos en la base de datos\n" +
"         * y llenar los campos\n" +
"         */\n" +
"        buscarServlet(\"Estados\",document.getElementById(\"estadoAlojamiento\"));\n" +
"        buscarServlet(\"RegimenAlimentario\",document.getElementById(\"regimenAlimentarioAlojamiento\"));\n" +
"        buscarServlet(\"Temporadas\",document.getElementById(\"temporadaAlojamiento\"));        \n" +
"        buscarServlet(\"Pais\",pais);\n" +
"        buscarServlet(\"Clientes\",document.getElementById(\"clienteAlojamientoSel\"),null,true);        \n" +
"        buscarServlet(\"TipoContacto\",document.getElementById(\"tipoContacto\"));\n" +
"        \n" +
"        //Funcion usada para agregar una opcion ---\n" +
"        function agregarOpcion(sel){\n" +
"            var select = document.createElement(\"Select\");\n" +
"            var option = document.createElement(\"Option\");\n" +
"            option.setAttribute(\"value\",\"x0\");\n" +
"            option.innerHTML = \"---\";\n" +
"            sel.appendChild(option);\n" +
"        };\n" +
"    </script>");
        imprimirEtiquetasFinal(out);
    }
    
    public static void cargaBarrio(PrintWriter out){
        imprimirEtiquetasIniciales(out,"ABM Barrio - Alta");
        out.write("<script src=\"js/buscar.js\"></script>\n" +
"        <form method=\"POST\" action=\"AltaBarrio\">\n" +
"            <table>\n" +
"                <thead>\n" +
"                    <tr>\n" +
"                        <th>ABM Barrio - Alta </th>\n" +
"                    </tr>\n" +
"                </thead>\n" +
"                <tbody>\n" +
"                    <tr>\n" +
"                        <td><label for=\"nombreBarrio\">Nombre: </label></td>\n" +
"                        <td><input type=\"text\" name=\"nombreBarrio\" id=\"nombreBarrio\" value=\"\" /></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><label for=\"Ciudad\">Ciudad: </label></td>\n" +
"                        <td><select name=\"Ciudad\" id=\"Ciudad\">\n" +
"                                <option value=\"x0\">---</option>\n" +
"                            </select></td>\n" +
"                    </tr>   \n" +
"                    <tr>\n" +
"                        <td><label for=\"Observaciones\">Observacion: </label></td>\n" +
"                        <td><textarea name=\"Observaciones\" rows=\"4\" cols=\"20\">\n" +
"                            </textarea></td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td><input type=\"submit\" value=\"Enviar\" name=\"envProvincia\" /></td>\n" +
"                    </tr>       \n" +
"                </tbody>\n" +
"            </table>\n" +
"        </form>\n" +
"        <script>\n" +
"            buscarServlet(\"Ciudad\",document.getElementById(\"Ciudad\"));\n" +
"        </script>");
        imprimirEtiquetasFinal(out);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.sql.SQLException;
import turismo.conexion.Conexion;

/**
 *
 * @author matiascanodesarrollos
 */
public class Factura  implements InterfazDeBusqueda{
    private int id,cliente,estado,tipoFactura,tipoVencimiento;
    private String concepto,fecha,fechaVencimiento;
    private float precio;

    public Factura(int cliente, int estado, int tipoFactura, int tipoVencimiento, String concepto, String fechaVencimiento, float precio,String fecha) throws SQLException {
        this.cliente = cliente;
        this.estado = estado;
        this.tipoFactura = tipoFactura;
        this.tipoVencimiento = tipoVencimiento;
        this.concepto = concepto;
        this.fecha = fecha;
        this.fechaVencimiento = fechaVencimiento;
        this.precio = precio;
        Conexion con = new Conexion();
        con.getSql().execute("INSERT INTO Turismo.Factura (concepto,precio,Fecha,FechaVencimiento,IdCliente,IdEstado,IdTipoFactura,IdTipoVencimiento) values('" + concepto + "'," + precio + ",'" + fecha + "','" + fechaVencimiento + "'," + cliente + "," + estado + "," + tipoFactura + "," + tipoVencimiento + ")");
        con.cerrarConexion();
    }

    
    @Override
    public void borrarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toJSON() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarRegistroBD() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
}

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
public class MedioTransporte {
    private int id,estado,empresaTransporte;
    private String tipo,detalle;

    public MedioTransporte(int estado, int empresaTransporte, String tipo, String detalle) throws SQLException {
        this.estado = estado;
        this.empresaTransporte = empresaTransporte;
        this.tipo = tipo;
        this.detalle = detalle;
        Conexion con = new Conexion();
        con.getSql().execute("INSERT INTO Turismo.MedioTransporte (Detalle,TipoTrasporte,IdEmpresaTrasporte,IdEstado) values ('" + detalle + "','" + tipo + "'," + empresaTransporte + "," + estado + ")");
        con.cerrarConexion();
    }
    
    
}
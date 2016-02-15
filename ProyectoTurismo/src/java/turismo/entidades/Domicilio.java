/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.entidades;

import java.sql.ResultSet;
import java.sql.SQLException;
import turismo.conexion.Conexion;

/**
 *
 * @author matiascanodesarrollos
 */
public class Domicilio  implements InterfazDeBusqueda{
    private int id;
    private String calle;
    private String numeroCalle;
    private String nroPiso;
    private String dpto;
    private String nroTorre;
    private String nroManzana;
    private String nroLote;
    private String codPostal;
    private String descripcion;
    private Barrio barrio;
    private Mapa mapa;
    private Observacion observacion;

    public Domicilio(String calle, String numeroCalle, String nroPiso, String dpto, String nroTorre, String nroManzana, String nroLote, String codPostal, int barrio) throws SQLException {
        Conexion con = new Conexion();
        ResultSet rs = con.getSql().executeQuery("CALL Turismo.cargaDomicilioMinimo('" + calle + "','" + numeroCalle + "','" + nroPiso +"','" + dpto +"','" + nroTorre + "','" + nroManzana + "','" + nroLote + "','" + codPostal + "'," + barrio + ",1)");
        rs.next();
        this.id = rs.getInt("LAST_INSERT_ID()");
        con.cerrarConexion();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(String numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public String getNroPiso() {
        return nroPiso;
    }

    public void setNroPiso(String nroPiso) {
        this.nroPiso = nroPiso;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getNroTorre() {
        return nroTorre;
    }

    public void setNroTorre(String nroTorre) {
        this.nroTorre = nroTorre;
    }

    public String getNroManzana() {
        return nroManzana;
    }

    public void setNroManzana(String nroManzana) {
        this.nroManzana = nroManzana;
    }

    public String getNroLote() {
        return nroLote;
    }

    public void setNroLote(String nroLote) {
        this.nroLote = nroLote;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

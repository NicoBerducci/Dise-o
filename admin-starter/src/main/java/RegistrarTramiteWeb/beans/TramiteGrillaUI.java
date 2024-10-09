package RegistrarTramiteWeb.beans;

import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@SessionScoped
public class TramiteGrillaUI implements Serializable{

    private int DNI;
    private String username;
    private String nombreCliente;
    private String apellidoCliente;
    private String nombreCategoria;
    private String nombreTipoTramite;
    private int Precio;
    private int nroConsultor;
    private List<String> nombreDocumentacionList;
    private Timestamp fechaHoraLimiteDeEntregaDoc;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }
 
    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNombreTipoTramite() {
        return nombreTipoTramite;
    }

    public int getDNI() {
        return DNI;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public int getPrecio() {
        return Precio;
    }

    public int getNroConsultor() {
        return nroConsultor;
    }

    public List<String> getNombreDocumentacionList() {
        return nombreDocumentacionList;
    }

    public Timestamp getFechaHoraLimiteDeEntregaDoc() {
        return fechaHoraLimiteDeEntregaDoc;
    }
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setNombreTipoTramite(String nombreTipoTramite) {
        this.nombreTipoTramite = nombreTipoTramite;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public void setNroConsultor(int nroConsultor) {
        this.nroConsultor = nroConsultor;
    }

    public void setNombreDocumentacionList(List<String> nombreDocumentacionList) {
        this.nombreDocumentacionList = nombreDocumentacionList;
    }

    public void setFechaHoraLimiteDeEntregaDoc(Timestamp fechaHoraLimiteDeEntregaDoc) {
        this.fechaHoraLimiteDeEntregaDoc = fechaHoraLimiteDeEntregaDoc;
    }
    
    
}

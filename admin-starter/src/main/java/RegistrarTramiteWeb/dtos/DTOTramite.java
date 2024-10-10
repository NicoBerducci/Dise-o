package RegistrarTramiteWeb.dtos;

import java.sql.Timestamp;
import java.util.List;

public class DTOTramite {
    
    private int DNI;
    private String nombreCliente;
    private String nombreCategoria;
    private String nombreTipoTramite;
    private int Precio;
    private int nroConsultor;
    private List<String> nombreDocumentacionList;
    private Timestamp fechaHoraLimiteDeEntregaDoc;
 

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

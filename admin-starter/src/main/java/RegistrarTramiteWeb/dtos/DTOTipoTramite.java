package RegistrarTramiteWeb.dtos;

public class DTOTipoTramite {
    
    private String nombrett;
    private String descWebtt;
    private int maxDiasParaDocumentacion;

    
    public String getNombrett() {
        return nombrett;
    }

    public String getDescWebtt() {
        return descWebtt;
    }
        
    public void setNombrett(String nombrett) {
        this.nombrett = nombrett;
    }

    public void setDescWebtt(String descWebtt) {
        this.descWebtt = descWebtt;
    } 
    
    public int getMaxDiasParaDocumentacion() {
        return maxDiasParaDocumentacion;
    }

    public void setMaxDiasParaDocumentacion(int maxDiasParaDocumentacion) {
        this.maxDiasParaDocumentacion = maxDiasParaDocumentacion;
    }
    
}

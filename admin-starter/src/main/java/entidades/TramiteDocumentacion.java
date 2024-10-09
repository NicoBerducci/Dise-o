package entidades;

import java.sql.Timestamp;


public class TramiteDocumentacion extends Entidad{
    
    private Timestamp fechaHoraEntregaDoc;
    private TipoDocumentacion tipoDocumentacion;
    
    public TramiteDocumentacion(){
    }
    
    public Timestamp getfechaHoraEntregaDoc(){
        return fechaHoraEntregaDoc;
    }
    
    public void setfechaHoraEntregaDoc(Timestamp fechaHoraEntregaDoc){
        this.fechaHoraEntregaDoc = fechaHoraEntregaDoc;
    }
    
    public TipoDocumentacion gettipoDocumentacion(){
        return tipoDocumentacion;
    }
    
    public void settipoDocumentacion(TipoDocumentacion tipoDocumentacion){
        this.tipoDocumentacion = tipoDocumentacion;
    }
}

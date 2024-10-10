package entidades;

import java.util.Date;


public class TipoTramiteTipoDocumentacion extends Entidad{
    
    private int contadorTipoTramite;
    private Date fechaDesdeTipoTramiteTipoDocumentacion;
    private Date fechaHastaTipoTramiteTipoDocumentacion;
    private TipoDocumentacion tipoDocumentacion;
    
    public TipoTramiteTipoDocumentacion(){
    }
    
    public int getcontadorTipoTramite(){
        return contadorTipoTramite;
    }
    
    public void setcontadorTipoTramite(int contadorTipoTramite){
        this.contadorTipoTramite = contadorTipoTramite;
    }
    
    public Date getfechaDesdeTipoTramiteTipoDocumentacion(){
        return fechaDesdeTipoTramiteTipoDocumentacion;
    }
    
    public void setfechaDesdeTipoTramiteTipoDocumentacion(Date fechaDesdeTipoTramiteTipoDocumentacion){
        this.fechaDesdeTipoTramiteTipoDocumentacion = fechaDesdeTipoTramiteTipoDocumentacion;
    }
    
    public Date getfechaHastaTipoTramiteTipoDocumentacion(){
        return fechaHastaTipoTramiteTipoDocumentacion;
    }
    
    public void setfechaHastaTipoTramiteTipoDocumentacion(Date fechaHastaTipoTramiteTipoDocumentacion){
        this.fechaHastaTipoTramiteTipoDocumentacion = fechaHastaTipoTramiteTipoDocumentacion;
    }
    
    public TipoDocumentacion gettipoDocumentacion(){
        return tipoDocumentacion;
    }
    
    public void settipoDocumentacion(TipoDocumentacion tipoDocumentacion){
        this.tipoDocumentacion = tipoDocumentacion;
    }
}

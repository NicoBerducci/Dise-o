package entidades;

import java.util.Date;
import java.util.List;


public class ConfigTipoTramiteEstadoTramite extends Entidad {
    
    private int codConfigTipoTramiteEstadoTramite;
    private Date fechaBajaConfigTipoTramiteEstadoTramite;
    private Date fechaDesdeConfigTipoTramiteEstadoTramite;
    private Date fechaHastaConfigTipoTramiteEstadoTramite;
    private int nroVersion;
    private TipoTramite tipoTramite;
    private List<TipoTramiteEstadoTramite> tipoTramiteEstadoTramiteList;
    
    public ConfigTipoTramiteEstadoTramite(){
    }
    
    public int getcodConfigTipoTramiteEstadoTramite(){
        return codConfigTipoTramiteEstadoTramite;
    }
    public void setcodConfigTipoTramiteEstadoTramite(int codConfigTipoTramiteEstadoTramite){
        this.codConfigTipoTramiteEstadoTramite = codConfigTipoTramiteEstadoTramite;
    }
    
    public Date getfechaBajaConfigTipoTramiteEstadoTramite(){
        return fechaBajaConfigTipoTramiteEstadoTramite;
    }
    
    public void setfechaBajaConfigTipoTramiteEstadoTramite(Date fechaBajaConfigTipoTramiteEstadoTramite){
        this.fechaBajaConfigTipoTramiteEstadoTramite = fechaBajaConfigTipoTramiteEstadoTramite;
    }
    
    public Date getfechaDesdeConfigTipoTramiteEstadoTramite(){
        return fechaDesdeConfigTipoTramiteEstadoTramite;
    }
    
    public void setfechaDesdeConfigTipoTramiteEstadoTramite(Date fechaDesdeConfigTipoTramiteEstadoTramite){
        this.fechaDesdeConfigTipoTramiteEstadoTramite = fechaDesdeConfigTipoTramiteEstadoTramite;
    }
    
    public Date getfechaHastaConfigTipoTramiteEstadoTramite(){
        return fechaHastaConfigTipoTramiteEstadoTramite;
    }
    
    public void setfechaHastaConfigTipoTramiteEstadoTramite(Date fechaHastaConfigTipoTramiteEstadoTramite){
        this.fechaHastaConfigTipoTramiteEstadoTramite = fechaHastaConfigTipoTramiteEstadoTramite;
    }
    
    public int getnroVersion(){
        return nroVersion;
    }
    
    public void setnroVersion(int nroVersion){
        this.nroVersion = nroVersion;
    }
    
    public TipoTramite gettipoTramite(){
        return tipoTramite;
    }
    
    public void settipoTramite(TipoTramite tipoTramite){
        this.tipoTramite = tipoTramite;
    }
    
    public List<TipoTramiteEstadoTramite> gettipoTramiteEstadoTramiteList(){
        return tipoTramiteEstadoTramiteList;
    }
    
    public void settipoTramiteEstadoTramiteList(List<TipoTramiteEstadoTramite> tipoTramiteEstadoTramiteList){
        this.tipoTramiteEstadoTramiteList = tipoTramiteEstadoTramiteList;
    }
    
}


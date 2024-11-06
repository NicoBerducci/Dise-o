package entidades;

import java.util.List;

public class TipoTramiteEstadoTramite extends Entidad{
    
    private int contadorEtapaEstado;
    private EstadoTramite estadoTramiteOrigen;
    private List<EstadoTramite> estadoTramiteDestinoList;
    
    public TipoTramiteEstadoTramite(){
    }
    
    public int getcontadorEtapaEstado(){
        return contadorEtapaEstado;
    }
    
    public void setcontadorEtapaEstado(int contadorEtapaEstado){
        this.contadorEtapaEstado = contadorEtapaEstado;
    }
    
    public EstadoTramite getestadoTramiteOrigen(){
        return estadoTramiteOrigen;
    }
    
    public void setestadoTramiteOrigen(EstadoTramite estadoTramiteOrigen){
        this.estadoTramiteOrigen = estadoTramiteOrigen;
    }
    
    public List<EstadoTramite> getestadoTramiteDestinoList(){
        return estadoTramiteDestinoList;
    }
    
    public void setestadoTramiteDestinoList(List<EstadoTramite> estadoTramiteDestinoList){
        this.estadoTramiteDestinoList = estadoTramiteDestinoList;
    }
}

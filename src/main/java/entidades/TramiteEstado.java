package entidades;

import java.util.Date;

public class TramiteEstado extends Entidad {

    private int contadorEstado;
    private int etapa;
    private Date fechaBajaTramiteEstado;
    private Date fechaFinTramiteEstado;
    private Date fechaInicioTramiteEstado;
    private EstadoTramite estadoTramite;

    public TramiteEstado() {
    }

    public int getcontadorEstado() {
        return contadorEstado;
    }

    public void setcontadorEstado(int contadorEstado) {
        this.contadorEstado = contadorEstado;
    }

    public int getetapa() {
        return etapa;
    }

    public void setetapa(int etapa) {
        this.etapa = etapa;
    }
    
    public Date getfechaBajaTramiteEstado(){
        return fechaBajaTramiteEstado;
    }
    
    public void setfechaBajaTramiteEstado(Date fechaBajaTramiteEstado){
        this.fechaBajaTramiteEstado = fechaBajaTramiteEstado;
    }
    
    public Date getfechaFinTramiteEstado(){
        return fechaFinTramiteEstado;
    }
    
    public void setfechaFinTramiteEstado(Date fechaFinTramiteEstado){
        this.fechaFinTramiteEstado = fechaFinTramiteEstado;
    }
    
    public Date getfechaInicioTramiteEstado(){
        return fechaInicioTramiteEstado;
    }
    
    public void setfechaInicioTramiteEstado(Date fechaInicioTramiteEstado){
        this.fechaInicioTramiteEstado = fechaInicioTramiteEstado;
    }
    
    public EstadoTramite getestadoTramite(){
        return estadoTramite;
    }
    
    public void setestadoTramite(EstadoTramite estadoTramite){
        this.estadoTramite = estadoTramite;
    }
}

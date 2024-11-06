
package ListaPrecios.dtos;

import java.util.Date;


public class DTOConfigCostoTipoTramiteFiltro {
    private Date fechaHastaConfigCostoTipoTramite;
    private Date fechaDesdeConfigCostoTipoTramite;
     private int nroConfigCostoTipoTramite;
    
   public Date getfechaHastaConfigCostoTipoTramite(){
        return fechaHastaConfigCostoTipoTramite;
    }
    
    public void setfechaHastaConfigCostoTipoTramite(Date fechaBajaConfigCostoTipoTramite){
        this.fechaHastaConfigCostoTipoTramite = fechaBajaConfigCostoTipoTramite;
    }
    
    public Date getfechaDesdeConfigCostoTipoTramite(){
        return fechaDesdeConfigCostoTipoTramite;
    }
    
    public void setfechaDesdeConfigCostoTipoTramite(Date fechaDesdeConfigCostoTipoTramite){
        this.fechaDesdeConfigCostoTipoTramite = fechaDesdeConfigCostoTipoTramite;
    }
     public int getnroConfigCostoTipoTramite(){
        return nroConfigCostoTipoTramite;
    }
    
    public void setnroConfigCostoTipoTramite(int nroConfigCostoTipoTramite){
        this.nroConfigCostoTipoTramite = nroConfigCostoTipoTramite;
    }
}

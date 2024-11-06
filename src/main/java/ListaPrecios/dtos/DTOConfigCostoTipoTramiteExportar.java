
package ListaPrecios.dtos;

import java.util.Date;
import java.util.List;

public class DTOConfigCostoTipoTramiteExportar  {
    private Date fechaBajaConfigCostoTipoTramite;
    private Date fechaDesdeConfigCostoTipoTramite;
    private List<DTOCostoTipoTramiteExportar> DTOcostoTipoTramiteExportarLista;
    
  public Date getfechaBajaConfigCostoTipoTramite(){
        return fechaBajaConfigCostoTipoTramite;
    }
    
    public void setfechaBajaConfigCostoTipoTramite(Date fechaBajaConfigCostoTipoTramite){
        this.fechaBajaConfigCostoTipoTramite = fechaBajaConfigCostoTipoTramite;
    }
    
    public Date getfechaDesdeConfigCostoTipoTramite(){
        return fechaDesdeConfigCostoTipoTramite;
    }
    
    public void setfechaDesdeConfigCostoTipoTramite(Date fechaDesdeConfigCostoTipoTramite){
        this.fechaDesdeConfigCostoTipoTramite = fechaDesdeConfigCostoTipoTramite;
    }
    
     public List<DTOCostoTipoTramiteExportar> getDTOcostoTipoTramiteExportarLista(){
        return DTOcostoTipoTramiteExportarLista;
    }
    
    public void setDTOcostoTipoTramiteExportarLista(List<DTOCostoTipoTramiteExportar> DTOcostoTipoTramiteExportarLista){
        this.DTOcostoTipoTramiteExportarLista = DTOcostoTipoTramiteExportarLista;
    }
}


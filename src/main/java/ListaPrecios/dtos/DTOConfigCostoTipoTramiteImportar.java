
package ListaPrecios.dtos;

import java.util.Date;
import java.util.List;


public class DTOConfigCostoTipoTramiteImportar  {

    private Date fechaBajaConfigCostoTipoTramite;
    private Date fechaDesdeConfigCostoTipoTramite;
    private int nroConfigCostoTipoTramite;
    private Date fechaHastaConfigCostoTipoTramite;
    private List<DTOCostoTipoTramiteImportar> DTOcostoTipoTramiteImportarLista;
     
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
    
    public Date getfechaHastaConfigCostoTipoTramite(){
        return fechaHastaConfigCostoTipoTramite;
    }
    
    public void setfechaHastaConfigCostoTipoTramite(Date fechaHastaConfigCostoTipoTramite){
        this.fechaHastaConfigCostoTipoTramite = fechaHastaConfigCostoTipoTramite;
    }
    
    public int getnroConfigCostoTipoTramite(){
        return nroConfigCostoTipoTramite;
    }
    
    public void setnroConfigCostoTipoTramite(int nroConfigCostoTipoTramite){
        this.nroConfigCostoTipoTramite = nroConfigCostoTipoTramite;
    }
    public List<DTOCostoTipoTramiteImportar> getDTOcostoTipoTramiteImportarLista(){
        return DTOcostoTipoTramiteImportarLista;
    }
    
    public void setDTOcostoTipoTramiteImportarLista(List<DTOCostoTipoTramiteImportar> DTOcostoTipoTramiteImportarLista){
        this.DTOcostoTipoTramiteImportarLista = DTOcostoTipoTramiteImportarLista;
    }
}

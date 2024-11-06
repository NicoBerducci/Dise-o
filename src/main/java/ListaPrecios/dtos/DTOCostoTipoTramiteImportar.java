
package ListaPrecios.dtos;

import java.util.Date;



public class DTOCostoTipoTramiteImportar {

private int codTipoTramite;
private int ImporteCostoTipoTramite;
private Date fechaBajaConfigCostoTipoTramite;
private Date fechaDesdeConfigCostoTipoTramite;
private int nroConfigCostoTipoTramite;

  public Date getfechaBajaConfigCostoTipoTramite(){
        return fechaBajaConfigCostoTipoTramite;
    }
    
    public void setfechaBajaConfigCostoTipoTramite(Date fechaBajaConfigCostoTipoTramite){
        this.fechaBajaConfigCostoTipoTramite = fechaBajaConfigCostoTipoTramite;
    }
    
    public int getnroConfigCostoTipoTramite(){
        return nroConfigCostoTipoTramite;
    }
    
    public void setnroConfigCostoTipoTramite(int nroConfigCostoTipoTramite){
        this.nroConfigCostoTipoTramite = nroConfigCostoTipoTramite;
    }
    
    public Date getfechaDesdeConfigCostoTipoTramite(){
        return fechaDesdeConfigCostoTipoTramite;
    }
    
    public void setfechaDesdeConfigCostoTipoTramite(Date fechaDesdeConfigCostoTipoTramite){
        this.fechaDesdeConfigCostoTipoTramite = fechaDesdeConfigCostoTipoTramite;
    }   
    public int getcodTipoTramite() {
        return codTipoTramite;
    }
  
    public void setcodTipoTramite(int codTipoTramite) {
        this.codTipoTramite = codTipoTramite;
    }
    
     public int getImporteCostoTipoTramite() {
        return ImporteCostoTipoTramite;
    }

    public void setImporteCostoTipoTramite(int ImporteCostoTipoTramite) {
        this.ImporteCostoTipoTramite = ImporteCostoTipoTramite;
    }
}

package entidades;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ConfigCostoTipoTramite extends Entidad{
    
    private Date fechaBajaConfigCostoTipoTramite;
    private Date fechaDesdeConfigCostoTipoTramite;
    private Date fechaHastaConfigCostoTipoTramite;
    private int nroConfigCostoTipoTramite;
    private List<CostoTipoTramite> costoTipoTramiteList;
    
    public ConfigCostoTipoTramite(){
        this.costoTipoTramiteList = new ArrayList<>();
    }
    
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
    
    
    public List<CostoTipoTramite> getcostoTipoTramiteList(){
        return costoTipoTramiteList;
    }
    
    public void setcostoTipoTramiteList(List<CostoTipoTramite> costoTipoTramiteList){
        this.costoTipoTramiteList = costoTipoTramiteList;
    }

    public int getImporteCostoTipoTramite() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
 
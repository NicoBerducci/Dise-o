/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaPrecios.beans;

import entidades.CostoTipoTramite;
import java.util.Date;
import java.util.List;


public class ListaPreciosGrillaUI  {
    private Date fechaDesdeConfigCostoTipoTramite;
    private Date fechaHastaConfigCostoTipoTramite;
    private Date fechaBajaConfigCostoTipoTramite;
    private int nroConfigCostoTipoTramite;
    private List<CostoTipoTramite> costoTipoTramiteList;
    
    

    
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
    
    public Date getfechaBajaConfigCostoTipoTramite(){
        return fechaBajaConfigCostoTipoTramite;
    }
    
    public void setfechaBajaConfigCostoTipoTramite(Date fechaBajaConfigCostoTipoTramite){
        this.fechaBajaConfigCostoTipoTramite = fechaBajaConfigCostoTipoTramite;
    }
    
    public List<CostoTipoTramite> getcostoTipoTramiteList(){
        return costoTipoTramiteList;
    }
    
    public void setcostoTipoTramiteList(List<CostoTipoTramite> costoTipoTramiteList){
        this.costoTipoTramiteList = costoTipoTramiteList;
    }
    
}

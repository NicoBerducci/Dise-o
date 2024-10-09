package entidades;

import java.sql.Timestamp;


public class TipoDocumentacion extends Entidad{
    
    private int codTipoDocumentacion;
    private String descTipoDocumentacion;
    private Timestamp fechaHoraBajaTD;
    private String nombreTipoDocumentacion;
    
    public TipoDocumentacion(){
    }
    
    public int getcodTipoDocumentacion(){
        return codTipoDocumentacion;
    }
    
    public void setcodTipoDocumentacion(int codTipoDocumentacion){
        this.codTipoDocumentacion = codTipoDocumentacion;
    }
    
    public String getdescTipoDocumentacion(){
        return descTipoDocumentacion;
    }
    
    public void setdescTipoDocumentacion(String descTipoDocumentacion){
        this.descTipoDocumentacion = descTipoDocumentacion;
    }
    
    public Timestamp getfechaHoraBajaTD(){
        return fechaHoraBajaTD;
    }
    
    public void setfechaHoraBajaTD(Timestamp fechaHoraBajaTD){
        this.fechaHoraBajaTD = fechaHoraBajaTD;
    }
    
    public String getnombreTipoDocumentacion(){
        return nombreTipoDocumentacion;
    }
    
    public void setnombreTipoDocumentacion(String nombreTipoDocumentacion){
        this.nombreTipoDocumentacion = nombreTipoDocumentacion;
    }
}

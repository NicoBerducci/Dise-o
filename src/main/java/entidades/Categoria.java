package entidades;

import java.sql.Timestamp;
import java.util.Date;

public class Categoria extends Entidad{
    
    private int codCategoria;
    private String descWebCategoria;
    private String descCategoria;
    private Timestamp fechaHoraBajaCategoria;
    private String nombreCategoria;
    
    public Categoria(){
    }
    
    public int getcodCategoria(){
        return codCategoria;
    }
    
    public void setcodCategoria(int codCategoria){
        this.codCategoria = codCategoria;
    }
    
    public String getdescWebCategoria(){
        return descWebCategoria;
    }
    
    public void setdescWebCategoria(String descWebCategoria){
        this.descWebCategoria = descWebCategoria;
    }
    
    public String getdescCategoria(){
        return descCategoria;
    }
    
    public void setdescCategoria(String descCategoria){
        this.descCategoria = descCategoria;
    }
    
    public Timestamp getfechaHoraBajaCategoria(){
        return fechaHoraBajaCategoria;
    }
    
    public void setfechaHoraBajaCategoria(Timestamp fechaHoraBajaCategoria){
        this.fechaHoraBajaCategoria = fechaHoraBajaCategoria;
    }
    
    public String getnombreCategoria(){
        return nombreCategoria;
    }
    
    public void setnombreCategoria(String nombreCategoria){
        this.nombreCategoria = nombreCategoria;
    }
}

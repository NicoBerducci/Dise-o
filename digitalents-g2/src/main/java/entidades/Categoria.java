package entidades;

import java.sql.Timestamp;

public class Categoria extends Entidad{
    
    private int codCategoria;
    private String descWebCategoria;
    private String descCategoria;
    private Timestamp fechaHoraBajaCategoria;
    private String nombreCategoria;
    
    public Categoria(){
    }
    
    public int getCodCategoria(){
        return codCategoria;
    }
    
    public void setCodCategoria(int codCategoria){
        this.codCategoria = codCategoria;
    }
    
    public String getDescWebCategoria(){
        return descWebCategoria;
    }
    
    public void setDescWebCategoria(String descWebCategoria){
        this.descWebCategoria = descWebCategoria;
    }
    
    public String getDescCategoria(){
        return descCategoria;
    }
    
    public void setDescCategoria(String descCategoria){
        this.descCategoria = descCategoria;
    }
    
    public Timestamp getFechaHoraBajaCategoria(){
        return fechaHoraBajaCategoria;
    }
    
    public void setFechaHoraBajaCategoria(Timestamp fechaHoraBajaCategoria){
        this.fechaHoraBajaCategoria = fechaHoraBajaCategoria;
    }
    
    public String getNombreCategoria(){
        return nombreCategoria;
    }
    
    public void setNombreCategoria(String nombreCategoria){
        this.nombreCategoria = nombreCategoria;
    }
}

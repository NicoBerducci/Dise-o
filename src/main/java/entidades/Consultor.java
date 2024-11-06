package entidades;

import java.sql.Timestamp;


public class Consultor extends Entidad{
    
    private int cantMaximaTramites;
    private Timestamp fechaHoraBajaConsultor;
    private String nombreApellidoConsultor;
    private int nroLegajoConsultor;
    private Usuario usuario;
    
    public Consultor(){
    }
    
    public int getcantMaximaTramites(){
        return cantMaximaTramites;
    }
    
    public void setcantMaximaTramites(int cantMaximaTramites){
        this.cantMaximaTramites = cantMaximaTramites;
    }
    

    public Timestamp getfechaHoraBajaConsultor(){
        return fechaHoraBajaConsultor;
    }
    
    public void setfechaHoraBajaConsultor(Timestamp fechaHoraBajaConsultor){
        this.fechaHoraBajaConsultor = fechaHoraBajaConsultor;
    }
    
    public String getnombreApellidoConsultor(){
        return nombreApellidoConsultor;
    }
    
    public void setnombreApellidoConsultor(String nombreApellidoConsultor){
        this.nombreApellidoConsultor = nombreApellidoConsultor;
    }
    
    public int getnroLegajoConsultor(){
        return nroLegajoConsultor;
    }
    
    public void setnroLegajoConsultor(int nroLegajoConsultor){
        this.nroLegajoConsultor = nroLegajoConsultor;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
}

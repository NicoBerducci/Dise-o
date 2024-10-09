package entidades;

import java.sql.Timestamp;

public class Cliente extends Entidad{
    
    private String ApellidoCliente;
    private int DNICliente;
    private String emailCliente;
    private Timestamp fechaHoraBajaCliente;
    private String nombreCliente;
    private int nroCliente;
    private String Observaciones;
    private int telCliente;
    private Usuario usuario;
    
    public Cliente(){   
    }
    
    public String getApellidoCliente() {
        return ApellidoCliente;
    }
    
    public void setApellidoCliente(String ApellidoCliente){
        this.ApellidoCliente = ApellidoCliente;
    }
    
    public int getDNICliente() {
        return DNICliente;
    }
    
    public void setDNICliente(int DNICliente){
        this.DNICliente = DNICliente;
    }
    
    public String getemailCliente() {
        return emailCliente;
    }
    
    public void setemailCliente(String emailCliente){
        this.emailCliente = emailCliente;
    }
    
    public Timestamp getfechaHoraBajaCliente() {
        return fechaHoraBajaCliente;
    }
    
    public void setfechaHoraBajaCliente(Timestamp fechaHoraBajaCliente){
        this.fechaHoraBajaCliente = fechaHoraBajaCliente;
    }
    
    public String getnombreCliente() {
        return nombreCliente;
    }
    
    public void setnombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
    }
    
    public int getnroCliente() {
        return nroCliente;
    }
    
    public void setnroCliente (int nroCliente){
        this.nroCliente = nroCliente;
    }
    
    public String getObservaciones() {
        return Observaciones;
    }
    
    public void setObservaciones(String Observaciones){
        this.Observaciones = Observaciones;
    }
    
    public int gettelCliente() {
        return telCliente;
    }
    
    public void settelCliente(int telCliente){
        this.telCliente = telCliente;
    }
    
    public Usuario getusuario(){
        return usuario;
    }
    
    public void setusuario(Usuario usuario){
        this.usuario = usuario;
    }
}

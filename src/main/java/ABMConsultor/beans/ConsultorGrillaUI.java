 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ABMConsultor.beans;

import entidades.Usuario;
import java.sql.Timestamp;

public class ConsultorGrillaUI {
    private int cantMaximaTramites;
    private Timestamp fechaHoraBajaConsultor;
    private String nombreApellidoConsultor;
    private int nroLegajoConsultor;
    private String username;
    private Usuario usuario;
    
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
    
    public Usuario getusuario(){
        return usuario;
    }
    
    public void setusuario(Usuario usuario){
        this.usuario = usuario;
    }
      public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ABMConsultor.beans;

import ABMConsultor.dtos.DTOConsultor;
import ABMConsultor.dtos.DTOConsultorModificar;
import ABMConsultor.dtos.DTOConsultorModificarIn;
import ABMConsultor.ControladorABMConsultor;
import ABMConsultor.exceptions.ConsultorException;

import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.Timestamp;
import org.omnifaces.util.Messages;
import utils.BeansUtils;

@Named("uiabmConsultor")
@ViewScoped

public class UIABMConsultor implements Serializable {
    private ControladorABMConsultor controladorABMConsultor = new ControladorABMConsultor();
    private boolean insert;
    private int cantMaximaTramites;
    private Timestamp fechaHoraBajaConsultor;
    private String nombreApellidoConsultor;
    private int nroLegajoConsultor;
    private int codUsuario;
    private String password;
    private String username;

    public boolean isInsert() {
        return insert;
    }
    
    public void setInsert(boolean insert) {
        this.insert = insert;
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
    
    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public UIABMConsultor() {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    ExternalContext externalContext = facesContext.getExternalContext();
    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

    int nroLegajoConsultor = Integer.parseInt(request.getParameter("nroLegajoConsultor"));
    insert=true;
    if(nroLegajoConsultor > 0)
        {
            insert=false;
            DTOConsultorModificar dtoConsultorModificar = controladorABMConsultor.buscarConsultorAModificar(nroLegajoConsultor);
            setnombreApellidoConsultor(dtoConsultorModificar.getnombreApellidoConsultor());
            setnroLegajoConsultor(dtoConsultorModificar.getnroLegajoConsultor());
            setcantMaximaTramites(dtoConsultorModificar.getcantMaximaTramites());
            setCodUsuario(dtoConsultorModificar.getCodUsuario());
            setUsername(dtoConsultorModificar.getUsername());
            setPassword(dtoConsultorModificar.getPassword());
        }
 
}

public String agregarConsultor(){
        try {

        
            if(!insert)
            {

                DTOConsultorModificarIn dtoConsultorModificarIn = new DTOConsultorModificarIn();
                dtoConsultorModificarIn.setnombreApellidoConsultor(getnombreApellidoConsultor());
                dtoConsultorModificarIn.setnroLegajoConsultor(getnroLegajoConsultor());
                dtoConsultorModificarIn.setcantMaximaTramites(getcantMaximaTramites());
                dtoConsultorModificarIn.setCodUsuario(getCodUsuario());
                dtoConsultorModificarIn.setUsername(getUsername());
                dtoConsultorModificarIn.setPassword(getPassword());
                controladorABMConsultor.modificarConsultor(dtoConsultorModificarIn);
                return BeansUtils.redirectToPreviousPage();
            }
            else
            {
                DTOConsultor dtoConsultor = new DTOConsultor();
                dtoConsultor.setnombreApellidoConsultor(getnombreApellidoConsultor());
                dtoConsultor.setnroLegajoConsultor(getnroLegajoConsultor());
                dtoConsultor.setcantMaximaTramites(getcantMaximaTramites());
                dtoConsultor.setCodUsuario(getCodUsuario());
                dtoConsultor.setUsername(getUsername());
                dtoConsultor.setPassword(getPassword());
                controladorABMConsultor.agregarConsultor(dtoConsultor);

            }
            return BeansUtils.redirectToPreviousPage();
        }
        
        catch (ConsultorException e) {
                Messages.create(e.getMessage()).fatal().add();
                return "";
         }
    }
}


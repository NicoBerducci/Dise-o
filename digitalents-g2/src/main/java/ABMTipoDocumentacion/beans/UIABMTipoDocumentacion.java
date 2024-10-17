/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ABMTipoDocumentacion.beans;

import utils.BeansUtils;


import ABMTipoDocumentacion.dtos.ModificarTipoDocumentacionDTO;
import ABMTipoDocumentacion.dtos.ModificarTipoDocumentacionDTOIn;
import ABMTipoDocumentacion.dtos.NuevoTipoDocumentacionDTO;
import ABMTipoDocumentacion.ControladorABMTipoDocumentacion;
import ABMTipoDocumentacion.exceptions.TipoDocumentacionException;

import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.io.Serializable;
import org.omnifaces.util.Messages;


@Named("uiabmTipoDocumentacion")
@ViewScoped

public class UIABMTipoDocumentacion implements Serializable{

   private ControladorABMTipoDocumentacion controladorABMTipoDocumentacion = new ControladorABMTipoDocumentacion();
    private boolean insert;
    private String descTipoDocumentacion;
    private String nombreTipoDocumentacion;
    private int codTipoDocumentacion;
    
    public boolean isInsert() {
        return insert;
    }

    public void setInsert(boolean insert) {
        this.insert = insert;
    }


    public String getNombreTipoDocumentacion() {
        return nombreTipoDocumentacion;
    }

    public void setNombreTipoDocumentacion(String nombreTipoDocumentacion) {
        this.nombreTipoDocumentacion = nombreTipoDocumentacion;
    }

    public String getDescTipoDocumentacion() {
        return descTipoDocumentacion;
    }

    public void setDescTipoDocumentacion(String descTipoDocumentacion) {
        this.descTipoDocumentacion = descTipoDocumentacion;
    }

    public int getCodTipoDocumentacion() {
        return codTipoDocumentacion;
    }

    public void setCodTipoDocumentacion(int codTipoDocumentacion) {
        this.codTipoDocumentacion = codTipoDocumentacion;
    }

    public UIABMTipoDocumentacion() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        
        int codTipoDocumentacion = Integer.parseInt(request.getParameter("codTipoDocumentacion"));
        insert=true;
        if(codTipoDocumentacion > 0)
        {
            insert=false;
            ModificarTipoDocumentacionDTO modificarTipoDocumentacionDTO = controladorABMTipoDocumentacion.buscarTipoDocumentacionAModificar(codTipoDocumentacion);
            setNombreTipoDocumentacion(modificarTipoDocumentacionDTO.getNombreTipoDocumentacion());
            setCodTipoDocumentacion(modificarTipoDocumentacionDTO.getCodTipoDocumentacion());
            setDescTipoDocumentacion(modificarTipoDocumentacionDTO.getDescTipoDocumentacion());
        }
        
    }
    public String agregarTipoDocumentacion(){
        try {

        
            if(!insert)
            {

                ModificarTipoDocumentacionDTOIn modificarTipoDocumentacionDTOIn = new ModificarTipoDocumentacionDTOIn();
                modificarTipoDocumentacionDTOIn.setNombreTipoDocumentacion(getNombreTipoDocumentacion());
                modificarTipoDocumentacionDTOIn.setCodTipoDocumentacion(getCodTipoDocumentacion());
                modificarTipoDocumentacionDTOIn.setDescTipoDocumentacion(getDescTipoDocumentacion());
                controladorABMTipoDocumentacion.modificarTipoDocumentacion(modificarTipoDocumentacionDTOIn);
                return BeansUtils.redirectToPreviousPage();
            }
            else
            {
                NuevoTipoDocumentacionDTO nuevoTipoDocumentacionDTO = new NuevoTipoDocumentacionDTO();
                nuevoTipoDocumentacionDTO.setNombreTipoDocumentacion(getNombreTipoDocumentacion());
                nuevoTipoDocumentacionDTO.setCodTipoDocumentacion(getCodTipoDocumentacion());
                nuevoTipoDocumentacionDTO.setDescTipoDocumentacion(getDescTipoDocumentacion());
                controladorABMTipoDocumentacion.agregarTipoDocumentacion(nuevoTipoDocumentacionDTO);

            }
            return BeansUtils.redirectToPreviousPage();
        }
        
        catch (TipoDocumentacionException e) {
                Messages.create(e.getMessage()).fatal().add();
                return "";
         }
    }

}

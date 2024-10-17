/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ABMCategoria.beans;

import utils.BeansUtils;
import ABMCategoria.ControladorABMCategoria;
import ABMCategoria.dtos.ModificarCategoriaDTO;
import ABMCategoria.dtos.ModificarCategoriaDTOIn;
import ABMCategoria.dtos.NuevoCategoriaDTO;
import ABMCategoria.exceptions.CategoriaException;

import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.io.Serializable;
import org.omnifaces.util.Messages;


@Named("uiabmCategoria")
@ViewScoped

public class UIABMCategoria implements Serializable{

   private ControladorABMCategoria controladorABMCategoria = new ControladorABMCategoria();
    private boolean insert;
    private String descWebCategoria;
    private String descCategoria;
    private String nombreCategoria;
    private int codCategoria;
    
    public boolean isInsert() {
        return insert;
    }

    public void setInsert(boolean insert) {
        this.insert = insert;
    }


    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

    public String getDescWebCategoria() {
        return descWebCategoria;
    }

    public void setDescWebCategoria(String descWebCategoria) {
        this.descWebCategoria = descWebCategoria;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public UIABMCategoria() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        
        int codCategoria = Integer.parseInt(request.getParameter("codCategoria"));
        insert=true;
        if(codCategoria > 0)
        {
            insert=false;
            ModificarCategoriaDTO modificarCategoriaDTO = controladorABMCategoria.buscarCategoriaAModificar(codCategoria);
            setNombreCategoria(modificarCategoriaDTO.getNombreCategoria());
            setCodCategoria(modificarCategoriaDTO.getCodCategoria());
            setDescCategoria(modificarCategoriaDTO.getDescCategoria());
            setDescWebCategoria(modificarCategoriaDTO.getDescWebCategoria());
        }
        
    }
    public String agregarCategoria(){
        try {

        
            if(!insert)
            {

                ModificarCategoriaDTOIn modificarCategoriaDTOIn = new ModificarCategoriaDTOIn();
                modificarCategoriaDTOIn.setNombreCategoria(getNombreCategoria());
                modificarCategoriaDTOIn.setCodCategoria(getCodCategoria());
                modificarCategoriaDTOIn.setDescCategoria(getDescCategoria());
                modificarCategoriaDTOIn.setDescWebCategoria(getDescWebCategoria());
                controladorABMCategoria.modificarCategoria(modificarCategoriaDTOIn);
                return BeansUtils.redirectToPreviousPage();
            }
            else
            {
                NuevoCategoriaDTO nuevoCategoriaDTO = new NuevoCategoriaDTO();
                nuevoCategoriaDTO.setNombreCategoria(getNombreCategoria());
                nuevoCategoriaDTO.setCodCategoria(getCodCategoria());
                nuevoCategoriaDTO.setDescCategoria(getDescCategoria());
                nuevoCategoriaDTO.setDescWebCategoria(getDescWebCategoria());
                controladorABMCategoria.agregarCategoria(nuevoCategoriaDTO);

            }
            return BeansUtils.redirectToPreviousPage();
        }
        
        catch (CategoriaException e) {
                Messages.create(e.getMessage()).fatal().add();
                return "";
         }
    }

}

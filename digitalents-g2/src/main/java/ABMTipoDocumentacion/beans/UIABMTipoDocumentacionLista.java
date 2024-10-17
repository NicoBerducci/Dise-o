/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ABMTipoDocumentacion.beans;

import ABMTipoDocumentacion.dtos.TipoDocumentacionDTO;
import ABMTipoDocumentacion.ControladorABMTipoDocumentacion;
import ABMTipoDocumentacion.exceptions.TipoDocumentacionException;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.omnifaces.util.Messages;
import utils.BeansUtils;

@Named("uiabmTipoDocumentacionLista")
@ViewScoped
public class UIABMTipoDocumentacionLista implements Serializable {

    private ControladorABMTipoDocumentacion controladorABMTipoDocumentacion = new ControladorABMTipoDocumentacion();
    private int codigoFiltro=0;
    private String nombreFiltro="";

    public ControladorABMTipoDocumentacion getControladorABMTipoDocumentacion() {
        return controladorABMTipoDocumentacion;
    }

    public void setControladorABMTipoDocumentacion(ControladorABMTipoDocumentacion controladorABMTipoDocumentacion) {
        this.controladorABMTipoDocumentacion = controladorABMTipoDocumentacion;
    }

    public int getCodigoFiltro() {
        return codigoFiltro;
    }

    public void setCodigoFiltro(int codigoFiltro) {
        this.codigoFiltro = codigoFiltro;
    }

    public String getNombreFiltro() {
        return nombreFiltro;
    }

    public void setNombreFiltro(String descripcionFiltro) {
        this.nombreFiltro = descripcionFiltro;
    }
    public void filtrar()
    {

    }

    public List<TipoDocumentacionGrillaUI> buscarTipoDocumentacion(){
        System.out.println(codigoFiltro);
        System.out.println(nombreFiltro);
        List<TipoDocumentacionGrillaUI> tipoDocumentacionGrilla = new ArrayList<>();
        List<TipoDocumentacionDTO> tipoDocumentacionsDTO = controladorABMTipoDocumentacion.buscarTipoDocumentacion(codigoFiltro,nombreFiltro);
        for (TipoDocumentacionDTO tipoDocumentacionDTO : tipoDocumentacionsDTO) {
            TipoDocumentacionGrillaUI tipoDocumentacionGrillaUI = new TipoDocumentacionGrillaUI();
            tipoDocumentacionGrillaUI.setNombreTipoDocumentacion(tipoDocumentacionDTO.getNombreTipoDocumentacion());
            tipoDocumentacionGrillaUI.setDescTipoDocumentacion(tipoDocumentacionDTO.getDescTipoDocumentacion());
            tipoDocumentacionGrillaUI.setCodTipoDocumentacion(tipoDocumentacionDTO.getCodTipoDocumentacion());
            tipoDocumentacionGrillaUI.setFechaHoraBajaTD(tipoDocumentacionDTO.getFechaHoraBajaTD());
            tipoDocumentacionGrilla.add(tipoDocumentacionGrillaUI);
        }
        return tipoDocumentacionGrilla;
    }

    public String irAgregarTipoDocumentacion() {
        BeansUtils.guardarUrlAnterior();
        return "abmTipoDocumentacion?faces-redirect=true&codTipoDocumentacion=0"; // Usa '?faces-redirect=true' para hacer una redirección
    }

    
    public String irModificarTipoDocumentacion(int codTipoDocumentacion) {
        BeansUtils.guardarUrlAnterior();
        return "abmTipoDocumentacion?faces-redirect=true&codTipoDocumentacion=" + codTipoDocumentacion; // Usa '?faces-redirect=true' para hacer una redirección
    }

    public void darDeBajaTipoDocumentacion(int codTipoDocumentacion){
        try {
            controladorABMTipoDocumentacion.darDeBajaTipoDocumentacion(codTipoDocumentacion);
            Messages.create("Anulado").detail("Anulado").add();
                    
        } catch (TipoDocumentacionException e) {
            Messages.create("Error!").error().detail("AdminFaces Error message.").add();
        }
    }
    
}
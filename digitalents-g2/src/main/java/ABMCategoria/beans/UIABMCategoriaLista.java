/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ABMCategoria.beans;

import ABMCategoria.ControladorABMCategoria;
import ABMCategoria.dtos.CategoriaDTO;
import ABMCategoria.exceptions.CategoriaException;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.omnifaces.util.Messages;
import utils.BeansUtils;

@Named("uiabmCategoriaLista")
@ViewScoped
public class UIABMCategoriaLista implements Serializable {

    private ControladorABMCategoria controladorABMCategoria = new ControladorABMCategoria();
    private int codigoFiltro=0;
    private String nombreFiltro="";

    public ControladorABMCategoria getControladorABMCategoria() {
        return controladorABMCategoria;
    }

    public void setControladorABMCategoria(ControladorABMCategoria controladorABMCategoria) {
        this.controladorABMCategoria = controladorABMCategoria;
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

    public List<CategoriaGrillaUI> buscarCategorias(){
        System.out.println(codigoFiltro);
        System.out.println(nombreFiltro);
        List<CategoriaGrillaUI> categoriasGrilla = new ArrayList<>();
        List<CategoriaDTO> categoriasDTO = controladorABMCategoria.buscarCategorias(codigoFiltro,nombreFiltro);
        for (CategoriaDTO categoriaDTO : categoriasDTO) {
            CategoriaGrillaUI categoriaGrillaUI = new CategoriaGrillaUI();
            categoriaGrillaUI.setNombreCategoria(categoriaDTO.getNombreCategoria());
            categoriaGrillaUI.setDescCategoria(categoriaDTO.getDescCategoria());
            categoriaGrillaUI.setDescWebCategoria(categoriaDTO.getDescWebCategoria());
            categoriaGrillaUI.setCodCategoria(categoriaDTO.getCodCategoria());
            categoriaGrillaUI.setFechaHoraBajaCategoria(categoriaDTO.getFechaHoraBajaCategoria());
            categoriasGrilla.add(categoriaGrillaUI);
        }
        return categoriasGrilla;
    }

    public String irAgregarCategoria() {
        BeansUtils.guardarUrlAnterior();
        return "abmCategoria?faces-redirect=true&codCategoria=0"; // Usa '?faces-redirect=true' para hacer una redirección
    }

    
    public String irModificarCategoria(int codCategoria) {
        BeansUtils.guardarUrlAnterior();
        return "abmCategoria?faces-redirect=true&codCategoria=" + codCategoria; // Usa '?faces-redirect=true' para hacer una redirección
    }

    public void darDeBajaCategoria(int codCategoria){
        try {
            controladorABMCategoria.darDeBajaCategoria(codCategoria);
            Messages.create("Anulado").detail("Anulado").add();;
                    
        } catch (CategoriaException e) {
            Messages.create("Error!").error().detail("AdminFaces Error message.").add();
        }
    }
    
}
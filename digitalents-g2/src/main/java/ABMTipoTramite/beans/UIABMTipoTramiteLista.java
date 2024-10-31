package ABMTipoTramite.beans;

import ABMTipoTramite.ControladorABMTipoTramite;
import ABMTipoTramite.dtos.TipoTramiteDTO;
import ABMTipoTramite.exceptions.TipoTramiteException;
import entidades.TipoDocumentacion;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.omnifaces.util.Messages;
import utils.BeansUtils;

@Named("uiabmTipoTramiteLista")
@ViewScoped
public class UIABMTipoTramiteLista implements Serializable {

    private ControladorABMTipoTramite controladorABMTipoTramite = new ControladorABMTipoTramite();
    private int codTipoTramiteFiltro = 0;
    private String nombreTipoTramiteFiltro = "";
    private List<TipoTramiteUI> listaFiltrada = new ArrayList<>(); // Variable para almacenar la lista filtrada
    private List<TipoDocumentacion> tipoDocumentacionList;

    public ControladorABMTipoTramite getControladorABMTipoTramite() {
        return controladorABMTipoTramite;
    }

    public void setControladorABMTipoTramite(ControladorABMTipoTramite controladorABMTipoTramite) {
        this.controladorABMTipoTramite = controladorABMTipoTramite;
    }

    public int getCodTipoTramiteFiltro() {
        return codTipoTramiteFiltro;
    }

    public void setCodTipoTramiteFiltro(int codTipoTramiteFiltro) {
        this.codTipoTramiteFiltro = codTipoTramiteFiltro;
    }

    public String getNombreTipoTramiteFiltro() {
        return nombreTipoTramiteFiltro;
    }

    public void setNombreTipoTramiteFiltro(String nombreTipoTramiteFiltro) {
        this.nombreTipoTramiteFiltro = nombreTipoTramiteFiltro;
    }

    public List<TipoTramiteUI> getListaFiltrada() {
        if (listaFiltrada.isEmpty()) {
            listaFiltrada = buscarTipoTramite();
        }
        return listaFiltrada;
    }

    public void setListaFiltrada(List<TipoTramiteUI> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public List<TipoDocumentacion> getTipoDocumentacionList() {
        return tipoDocumentacionList;
    }

    public void setTipoDocumentacionList(List<TipoDocumentacion> tipoDocumentacionList) {
        this.tipoDocumentacionList = tipoDocumentacionList;
    }

    // Método para filtrar la lista
    public void filtrar() {
        listaFiltrada = buscarTipoTramite(); // Actualiza la lista filtrada
    }

    public List<TipoTramiteUI> buscarTipoTramite() {
        System.out.println(codTipoTramiteFiltro);
        System.out.println(nombreTipoTramiteFiltro);
        List<TipoTramiteUI> tipoTramite = new ArrayList<>();
        List<TipoTramiteDTO> tipoTramitesDTO = controladorABMTipoTramite.buscarTipoTramites(codTipoTramiteFiltro, nombreTipoTramiteFiltro);
        for (TipoTramiteDTO tipoTramiteDTO : tipoTramitesDTO) {
            TipoTramiteUI tipoTramiteUI = new TipoTramiteUI();
            tipoTramiteUI.setCodTipoTramite(tipoTramiteDTO.getCodTipoTramite());
            tipoTramiteUI.setDescTipoTramite(tipoTramiteDTO.getDescTipoTramite());
            tipoTramiteUI.setDescWebTipoTramite(tipoTramiteDTO.getDescWebTipoTramite());
            tipoTramiteUI.setFechaHoraBajaTipoTramite(tipoTramiteDTO.getFechaHoraBajaTipoTramite());
            tipoTramiteUI.setMaxDiasParaDocumentacion(tipoTramiteDTO.getMaxDiasParaDocumentacion());
            tipoTramiteUI.setNombreTipoTramite(tipoTramiteDTO.getNombreTipoTramite());
            tipoTramiteUI.setCategoria(tipoTramiteDTO.getCategoria());
            tipoTramiteUI.setTipoDocumentacionList(tipoTramiteDTO.getTipoDocumentacionList()); // Para agregar un TD al TT
            tipoTramite.add(tipoTramiteUI);
        }
        return tipoTramite;
    }

    public String irAgregarTipoTramite() {
        BeansUtils.guardarUrlAnterior();
        return "abmTipoTramite?faces-redirect=true&codTipoTramite=0"; // Redirección con faces-redirect
    }

    public String irModificarTipoTramite(int codTipoTramite) {
        BeansUtils.guardarUrlAnterior();
        return "abmTipoTramite?faces-redirect=true&codTipoTramite=" + codTipoTramite;
    }

    public void darDeBajaTipoTramite(int codTipoTramite) {
        try {
            controladorABMTipoTramite.darDeBajaTipoTramite(codTipoTramite);
            Messages.create("Tipo de trámite dado de Baja").detail("Tipo de trámite dado de Baja").add();

        } catch (TipoTramiteException e) {
            Messages.create("Error!").error().detail("Error al dar de baja el tipo de trámite.").add();
        }
    }
}

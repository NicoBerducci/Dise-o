package ABMTipoTramite.beans;

import ABMCategoria.dtos.CategoriaDTO;
import ABMTipoTramite.ControladorABMTipoTramite;
import ABMTipoTramite.dtos.ModificarTipoTramiteDTO;
import ABMTipoTramite.dtos.ModificarTipoTramiteDTOIn;
import ABMTipoTramite.dtos.NuevoTipoTramiteDTO;
import ABMTipoTramite.exceptions.TipoTramiteException;
import entidades.Categoria;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.Timestamp;
import org.omnifaces.util.Messages;
import utils.BeansUtils;

@Named("uiabmTipoTramite")
@ViewScoped
public class UIABMTipoTramite implements Serializable {

    private ControladorABMTipoTramite controladorABMTipoTramite = new ControladorABMTipoTramite();
    private int codTipoTramite;
    private String descTipoTramite;
    private String descWebTipoTramite;
    private Timestamp fechaHoraBajaTipoTramite;
    private int maxDiasParaDocumentacion;
    private String nombreTipoTramite;
    private boolean insert;
    private String categoriaCod; // Almacena el código o nombre de la categoría
    private Categoria categoria; // Objeto Categoria seleccionado

    public ControladorABMTipoTramite getControladorABMTipoTramite() {
        return controladorABMTipoTramite;
    }

    public void setControladorABMTipoTramite(ControladorABMTipoTramite controladorABMTipoTramite) {
        this.controladorABMTipoTramite = controladorABMTipoTramite;
    }

    public int getCodTipoTramite() {
        return codTipoTramite;
    }

    public void setCodTipoTramite(int codTipoTramite) {
        this.codTipoTramite = codTipoTramite;
    }

    public String getDescTipoTramite() {
        return descTipoTramite;
    }

    public void setDescTipoTramite(String descTipoTramite) {
        this.descTipoTramite = descTipoTramite;
    }

    public String getDescWebTipoTramite() {
        return descWebTipoTramite;
    }

    public void setDescWebTipoTramite(String descWebTipoTramite) {
        this.descWebTipoTramite = descWebTipoTramite;
    }

    public Timestamp getFechaHoraBajaTipoTramite() {
        return fechaHoraBajaTipoTramite;
    }

    public void setFechaHoraBajaTipoTramite(Timestamp fechaHoraBajaTipoTramite) {
        this.fechaHoraBajaTipoTramite = fechaHoraBajaTipoTramite;
    }

    public int getMaxDiasParaDocumentacion() {
        return maxDiasParaDocumentacion;
    }

    public void setMaxDiasParaDocumentacion(int maxDiasParaDocumentacion) {
        this.maxDiasParaDocumentacion = maxDiasParaDocumentacion;
    }

    public String getNombreTipoTramite() {
        return nombreTipoTramite;
    }

    public void setNombreTipoTramite(String nombreTipoTramite) {
        this.nombreTipoTramite = nombreTipoTramite;
    }

    public boolean isInsert() {
        return insert;
    }

    public void setInsert(boolean insert) {
        this.insert = insert;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getCategoriaCod() {
        return categoriaCod;
    }

    public void setCategoriaCod(String categoriaCod) {
        this.categoriaCod = categoriaCod;
    }

    public UIABMTipoTramite() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

        int codTipoTramite = Integer.parseInt(request.getParameter("codTipoTramite"));
        insert = true;
        if (codTipoTramite > 0) {
            insert = false;
            ModificarTipoTramiteDTO modificarTipoTramiteDTO = controladorABMTipoTramite.buscarTipoTramiteAModificar(codTipoTramite);
            setCodTipoTramite(modificarTipoTramiteDTO.getCodTipoTramite());
            setNombreTipoTramite(modificarTipoTramiteDTO.getNombreTipoTramite());
            setDescTipoTramite(modificarTipoTramiteDTO.getDescTipoTramite());
            setDescWebTipoTramite(modificarTipoTramiteDTO.getDescWebTipoTramite());
            setMaxDiasParaDocumentacion(modificarTipoTramiteDTO.getMaxDiasParaDocumentacion());
            setCategoriaCod(modificarTipoTramiteDTO.getCategoriaCod());
            setCategoria(modificarTipoTramiteDTO.getCategoria());
        }
    }

    public String agregarTipoTramite() {
        try {
            if (categoriaCod == null || categoriaCod.isEmpty()) {
                Messages.create("Debe ingresar un código de categoría.").fatal().add();
                return "";
            }

            Categoria categoriaoid = buscarCategoriaPorOID(categoriaCod);

            if (categoriaoid == null) {
                Messages.create("Categoría no encontrada.").fatal().add();
                return "";
            }

            if (!insert) {
                ModificarTipoTramiteDTOIn modificarTipoTramiteDTOIn = new ModificarTipoTramiteDTOIn();
                modificarTipoTramiteDTOIn.setCodTipoTramite(getCodTipoTramite());
                modificarTipoTramiteDTOIn.setDescTipoTramite(getDescTipoTramite());
                modificarTipoTramiteDTOIn.setDescWebTipoTramite(getDescWebTipoTramite());
                modificarTipoTramiteDTOIn.setMaxDiasParaDocumentacion(getMaxDiasParaDocumentacion());
                modificarTipoTramiteDTOIn.setNombreTipoTramite(getNombreTipoTramite());
                modificarTipoTramiteDTOIn.setCategoria(categoriaoid);
                modificarTipoTramiteDTOIn.setCategoriaCod(getCategoriaCod());
                controladorABMTipoTramite.modificarTipoTramite(modificarTipoTramiteDTOIn);
                return BeansUtils.redirectToPreviousPage();
            } else {
                NuevoTipoTramiteDTO nuevoTipoTramiteDTO = new NuevoTipoTramiteDTO();
                nuevoTipoTramiteDTO.setCodTipoTramite(getCodTipoTramite());
                nuevoTipoTramiteDTO.setDescTipoTramite(getDescTipoTramite());
                nuevoTipoTramiteDTO.setDescWebTipoTramite(getDescWebTipoTramite());
                nuevoTipoTramiteDTO.setMaxDiasParaDocumentacion(getMaxDiasParaDocumentacion());
                nuevoTipoTramiteDTO.setNombreTipoTramite(getNombreTipoTramite());
                nuevoTipoTramiteDTO.setCategoria(categoriaoid);
                controladorABMTipoTramite.agregarTipoTramite(nuevoTipoTramiteDTO);
            }
            return BeansUtils.redirectToPreviousPage();
        } catch (TipoTramiteException e) {
            Messages.create(e.getMessage()).fatal().add();
            return "";
        }
    }

    private Categoria buscarCategoriaPorOID(String categoriaCod) throws TipoTramiteException {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        Categoria categoria = categoriaDTO.buscarCategoriaPorCodigo(categoriaCod);
        if (categoria == null) {
            throw new TipoTramiteException("La categoría con el código especificado no existe.");
        }
        return categoria;
    }

}

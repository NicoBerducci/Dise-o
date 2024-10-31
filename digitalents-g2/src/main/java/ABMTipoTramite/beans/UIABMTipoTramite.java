package ABMTipoTramite.beans;

import ABMCategoria.dtos.CategoriaDTO;
import ABMTipoDocumentacion.exceptions.TipoDocumentacionException;
import ABMTipoTramite.ControladorABMTipoTramite;
import ABMTipoTramite.dtos.ModificarTipoTramiteDTO;
import ABMTipoTramite.dtos.ModificarTipoTramiteDTOIn;
import ABMTipoTramite.dtos.NuevoTipoTramiteDTO;
import ABMTipoTramite.exceptions.TipoTramiteException;
import entidades.Categoria;
import entidades.TipoDocumentacion;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.omnifaces.util.Messages;
import utils.BeansUtils;
import utils.DTOCriterio;
import utils.FachadaPersistencia;

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
    private List<TipoDocumentacion> tipoDocumentacionList; // Para agregar un TipoDoc al TipoTramite
    private int codTipoDocumentacion; // Para el selectOneMenu
    private List<TipoDocumentacion> selectedTipoDocumentacion; // Para el manejo de la tabla de seleccione con el boxcheck

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

    public List<TipoDocumentacion> getTipoDocumentacionList() {
        return tipoDocumentacionList;
    }

    public void setTipoDocumentacionList(List<TipoDocumentacion> tipoDocumentacionList) {
        this.tipoDocumentacionList = tipoDocumentacionList;
    }

    public int getCodTipoDocumentacion() {
        return codTipoDocumentacion;
    }

    public void setCodTipoDocumentacion(int codTipoDocumentacion) {
        this.codTipoDocumentacion = codTipoDocumentacion;
    }

    public List<TipoDocumentacion> getSelectedTipoDocumentacion() {
        return selectedTipoDocumentacion;
    }

    public void setSelectedTipoDocumentacion(List<TipoDocumentacion> selectedTipoDocumentacion) {
        this.selectedTipoDocumentacion = selectedTipoDocumentacion;
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
//            setTipoDocumentacionList(modificarTipoTramiteDTO.getTipoDocumentacionList()); // Para agregar un TipoDoc al TipoTramite
            // Aquí se deben cargar los tipos de documentación disponibles
            setTipoDocumentacionList(obtenerTipoDocumentacionDisponible());
        } else {
            tipoDocumentacionList = obtenerTipoDocumentacionDisponible();
        }
    }

    public String agregarTipoTramite() throws TipoDocumentacionException {
        // Para depurar
        System.out.println("Valor recibido de codTipoTramite: " + this.codTipoTramite);
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

            // Validar la lista de TipoDocumentacion
            if (tipoDocumentacionList == null || tipoDocumentacionList.isEmpty()) {
                Messages.create("Debe seleccionar al menos un tipo de documentación.").fatal().add();
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
                modificarTipoTramiteDTOIn.setTipoDocumentacionList(selectedTipoDocumentacion); // Agregar la lista de TipoDocumentacion
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
                nuevoTipoTramiteDTO.setTipoDocumentacionList(selectedTipoDocumentacion); // Agregar la lista de TipoDocumentacion
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

    public List<TipoDocumentacion> obtenerTipoDocumentacionPorCodTipoTramite(int codTipoTramite) {
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();
        dto.setAtributo("codTipoTramite");
        dto.setOperacion("=");
        dto.setValor(codTipoTramite);
        criterioList.add(dto);

        // Obtiene la lista genérica y luego la filtra
        List<?> resultado = FachadaPersistencia.getInstance().buscar("TipoDocumentacion", criterioList);

        // Convierte el resultado a List<TipoDocumentacion>
        List<TipoDocumentacion> tipoDocumentacionList = new ArrayList<>();
        for (Object obj : resultado) {
            TipoDocumentacion tipo = (TipoDocumentacion) obj;
            if (obj instanceof TipoDocumentacion) {
                tipoDocumentacionList.add((TipoDocumentacion) obj);
            }
        }

        return tipoDocumentacionList;
    }

    public List<TipoDocumentacion> obtenerTipoDocumentacionDisponible() {
        List<DTOCriterio> criterioList = new ArrayList<>();

        // Obtiene la lista genérica sin filtros
        List<?> resultado = FachadaPersistencia.getInstance().buscar("TipoDocumentacion", criterioList);

        // Convierte el resultado a List<TipoDocumentacion>
        List<TipoDocumentacion> tipoDocumentacionList = new ArrayList<>();
        for (Object obj : resultado) {
            if (obj instanceof TipoDocumentacion) {
                tipoDocumentacionList.add((TipoDocumentacion) obj);
            }
        }

        return tipoDocumentacionList;
    }
}

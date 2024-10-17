package ABMTipoTramite.dtos;

import entidades.Categoria;
import entidades.TipoDocumentacion;
import entidades.TipoTramiteTipoDocumentacion;
import java.sql.Timestamp;
import java.util.List;


public class TipoTramiteDTO {

    private int codTipoTramite;
    private String descTipoTramite;
    private String descWebTipoTramite;
    private Timestamp fechaHoraBajaTipoTramite;
    private int maxDiasParaDocumentacion;
    private String nombreTipoTramite;
    private Categoria categoria;
    private List<TipoTramiteTipoDocumentacion> tipoTramiteTipoDocumentacionList;
    private List<TipoDocumentacion> tipoDocumentacionList;
    private String categoriaCod;

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<TipoTramiteTipoDocumentacion> getTipoTramiteTipoDocumentacionList() {
        return tipoTramiteTipoDocumentacionList;
    }

    public void setTipoTramiteTipoDocumentacionList(List<TipoTramiteTipoDocumentacion> tipoTramiteTipoDocumentacionList) {
        this.tipoTramiteTipoDocumentacionList = tipoTramiteTipoDocumentacionList;
    }

    public List<TipoDocumentacion> getTipoDocumentacionList() {
        return tipoDocumentacionList;
    }

    public void setTipoDocumentacionList(List<TipoDocumentacion> tipoDocumentacionList) {
        this.tipoDocumentacionList = tipoDocumentacionList;
    }

    public String getCategoriaCod() {
        return categoriaCod;
    }

    public void setCategoriaCod(String categoriaCod) {
        this.categoriaCod = categoriaCod;
    }
}

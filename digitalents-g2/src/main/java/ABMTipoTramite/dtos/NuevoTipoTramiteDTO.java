package ABMTipoTramite.dtos;

import entidades.Categoria;
import entidades.TipoDocumentacion;
import entidades.TipoTramiteTipoDocumentacion;
import java.sql.Timestamp;
import java.util.List;


public class NuevoTipoTramiteDTO {
    private int codTipoTramite;
    private String descTipoTramite;
    private String descWebTipoTramite;
    private int maxDiasParaDocumentacion;
    private String nombreTipoTramite;
    private Categoria categoria;
    private List<Integer> tipoTramiteTipoDocumentacionList;
    private List<TipoDocumentacion> tipoDocumentacionList;

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

    public List<TipoDocumentacion> getTipoDocumentacionList() {
        return tipoDocumentacionList;
    }

    public void setTipoDocumentacionList(List<TipoDocumentacion> tipoDocumentacionList) {
        this.tipoDocumentacionList = tipoDocumentacionList;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Integer> getTipoTramiteTipoDocumentacionList() {
        return tipoTramiteTipoDocumentacionList;
    }

    public void setTipoTramiteTipoDocumentacionList(List<Integer> tipoTramiteTipoDocumentacionList) {
        this.tipoTramiteTipoDocumentacionList = tipoTramiteTipoDocumentacionList;
    }
    
}

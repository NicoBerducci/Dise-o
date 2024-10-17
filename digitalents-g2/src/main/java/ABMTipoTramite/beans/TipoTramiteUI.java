package ABMTipoTramite.beans;

import entidades.Categoria;
import java.sql.Timestamp;


public class TipoTramiteUI {
    private int codTipoTramite;
    private String descTipoTramite;
    private String descWebTipoTramite;
    private Timestamp fechaHoraBajaTipoTramite;
    private int maxDiasParaDocumentacion;
    private String nombreTipoTramite;
    private Categoria categoria;

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
}

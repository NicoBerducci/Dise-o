package entidades;

import java.sql.Timestamp;
import java.util.List;

public class TipoTramite extends Entidad {

    private int codTipoTramite;
    private String descTipoTramite;
    private String descWebTipoTramite;
    private Timestamp fechaHoraBajaTipoTramite;
    private int maxDiasParaDocumentacion;
    private String nombreTipoTramite;
    private Categoria categoria;
    private List<TipoTramiteTipoDocumentacion> tipoTramiteTipoDocumentacionList;
    private List<TipoDocumentacion> tipoDocumentacionList;

    public TipoTramite() {
    }

    public int getcodTipoTramite() {
        return codTipoTramite;
    }

    public void setcodTipoTramite(int codTipoTramite) {
        this.codTipoTramite = codTipoTramite;
    }

    public String getdescTipoTramite() {
        return descTipoTramite;
    }

    public void setdescTipoTramite(String descTipoTramite) {
        this.descTipoTramite = descTipoTramite;
    }

    public String getdescWebTipoTramite() {
        return descWebTipoTramite;
    }

    public void setdescWebTipoTramite(String descWebTipoTramite) {
        this.descWebTipoTramite = descWebTipoTramite;
    }

    public Timestamp getfechaHoraBajaTipoTramite() {
        return fechaHoraBajaTipoTramite;
    }

    public void setfechaHoraBajaTipoTramite(Timestamp fechaHoraBajaTipoTramite) {
        this.fechaHoraBajaTipoTramite = fechaHoraBajaTipoTramite;
    }

    public int getmaxDiasParaDocumentacion() {
        return maxDiasParaDocumentacion;
    }
   
    public void setmaxDiasParaDocumentacion(int maxDiasParaDocumentacion){
        this.maxDiasParaDocumentacion = maxDiasParaDocumentacion;
    }

    public String getnombreTipoTramite(){
        return nombreTipoTramite;
    }
    
    public void setnombreTipoTramite(String nombreTipoTramite){
        this.nombreTipoTramite = nombreTipoTramite;
    }
    
    public Categoria getcategoria(){
        return categoria;
    }
    
    public void setcategoria(Categoria categoria){
        this.categoria = categoria;
    }
    
    public List<TipoTramiteTipoDocumentacion> gettipoTramiteTipoDocumentacionList(){
        return tipoTramiteTipoDocumentacionList;
    }
    
    public void settipoTramiteTipoDocumentacionList(List<TipoTramiteTipoDocumentacion> tipoTramiteTipoDocumentacionList){
        this.tipoTramiteTipoDocumentacionList = tipoTramiteTipoDocumentacionList;
    }

    public List<TipoDocumentacion> gettipoDocumentacionList(){
        return tipoDocumentacionList;
    }
    
    public void settipoDocumentacionList(List<TipoDocumentacion> tipoDocumentacionList){
        this.tipoDocumentacionList = tipoDocumentacionList;
    }
}

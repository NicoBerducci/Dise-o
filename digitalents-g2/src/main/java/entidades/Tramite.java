package entidades;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Tramite extends Entidad {

    private String discriminadorTramite;
    private Date fechaAnulacion;
    private Date fechaEntregaDocumentacion;
    private Timestamp fechaHoraFinTramiteReal;
    private Timestamp fechaHoraInicioTramiteReal;
    private Timestamp fechaHoraLimiteDeEntregaDoc;
    private Timestamp fechaHoraRegistroTramite;
    private int nroTramite;
    private String observaciones;
    private int tramiteCosto;
    private Cliente cliente;
    private Consultor consultor;
    private EstadoTramite estadoTramite;
    private List<TramiteEstado> tramiteEstadoList;//va el many to one, en esta clase, del tramite
    private TipoTramite tipoTramite;
    private List<TramiteDocumentacion> tramiteDocumentacionList;
    
    
    public Tramite() {
    }

    public String getDiscriminadorTramite() {
        return discriminadorTramite;
    }

    public void setDiscriminadorTramite(String discriminadorTramite) {
        this.discriminadorTramite = discriminadorTramite;
    }

    public Date getFechaAnulacion() {
        return fechaAnulacion;
    }

    public void setFechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public Date getFechaEntregaDocumentacion() {
        return fechaEntregaDocumentacion;
    }

    public void setFechaEntregaDocumentacion(Date fechaEntregaDocumentacion) {
        this.fechaEntregaDocumentacion = fechaEntregaDocumentacion;
    }

    public Timestamp getFechaHoraFinTramiteReal() {
        return fechaHoraFinTramiteReal;
    }

    public void setFechaHoraFinTramiteReal(Timestamp fechaHoraFinTramiteReal) {
        this.fechaHoraFinTramiteReal = fechaHoraFinTramiteReal;
    }

    public Timestamp getFechaHoraInicioTramiteReal() {
        return fechaHoraInicioTramiteReal;
    }

    public void setFechaHoraInicioTramiteReal(Timestamp fechaHoraInicioTramiteReal) {
        this.fechaHoraInicioTramiteReal = fechaHoraInicioTramiteReal;
    }
    
    public Timestamp getFechaHoraLimiteDeEntregaDoc(){
        return fechaHoraLimiteDeEntregaDoc;
    }
    
    public void setFechaHoraLimiteDeEntregaDoc(Timestamp fechaHoraLimiteDeEntregaDoc){
        this.fechaHoraLimiteDeEntregaDoc = fechaHoraLimiteDeEntregaDoc;
    }
    
    public Timestamp getFechaHoraRegistroTramite(){
        return fechaHoraRegistroTramite;
    }
    
    public void setFechaHoraRegistroTramite(Timestamp fechaHoraRegistroTramite){
        this.fechaHoraRegistroTramite = fechaHoraRegistroTramite;
    }
    
    public int getNroTramite(){
        return nroTramite;
    }
    
    public void setNroTramite(int nroTramite){
        this.nroTramite = nroTramite;
    }
    
    public String getObservaciones(){
        return observaciones;
    }
    
    public void setObservaciones(String observaciones){
        this.observaciones = observaciones;
    }
    
    public int getTramiteCosto(){
        return tramiteCosto;
    }
    
    public void setTramiteCosto(int tramiteCosto){
        this.tramiteCosto = tramiteCosto;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public Consultor getConsultor(){
        return consultor;
    }
    
    public void setConsultor(Consultor consultor){
        this.consultor = consultor;
    }
    
    public EstadoTramite getEstadoTramite(){
        return estadoTramite;
    }
    
    public void setEstadoTramite(EstadoTramite estadoTramite){
        this.estadoTramite = estadoTramite;
    }
    
    public List<TramiteEstado> getTramiteEstadoList(){
        return tramiteEstadoList;
    }
    
    public void setTramiteEstadoList(List<TramiteEstado> tramiteEstadoList){
        this.tramiteEstadoList = tramiteEstadoList;
    }
    
    public TipoTramite getTipoTramite(){
        return tipoTramite;
    }
    
    public void setTipoTramite(TipoTramite tipoTramite){
        this.tipoTramite = tipoTramite;
    }
    
    public List<TramiteDocumentacion> getTramiteDocumentacionList(){
        return tramiteDocumentacionList;
    }
    
    public void setTramiteDocumentacionList(List<TramiteDocumentacion> tramiteDocumentacionList){
        this.tramiteDocumentacionList = tramiteDocumentacionList;
    }
    
}

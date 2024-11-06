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
    private String Observaciones;
    private int TramiteCosto;
    private Cliente cliente;
    private Consultor consultor;
    private EstadoTramite estadoTramite;
    private List<TramiteEstado> tramiteEstadoList;
    private TipoTramite tipoTramite;
    private List<TramiteDocumentacion> tramiteDocumentacionList;
    
    
    public Tramite() {
    }

    public String getdiscriminadorTramite() {
        return discriminadorTramite;
    }

    public void setdiscriminadorTramite(String discriminadorTramite) {
        this.discriminadorTramite = discriminadorTramite;
    }

    public Date getfechaAnulacion() {
        return fechaAnulacion;
    }

    public void setfechaAnulacion(Date fechaAnulacion) {
        this.fechaAnulacion = fechaAnulacion;
    }

    public Date getfechaEntregaDocumentacion() {
        return fechaEntregaDocumentacion;
    }

    public void setfechaEntregaDocumentacion(Date fechaEntregaDocumentacion) {
        this.fechaEntregaDocumentacion = fechaEntregaDocumentacion;
    }

    public Timestamp getfechaHoraFinTramiteReal() {
        return fechaHoraFinTramiteReal;
    }

    public void setfechaHoraFinTramiteReal(Timestamp fechaHoraFinTramiteReal) {
        this.fechaHoraFinTramiteReal = fechaHoraFinTramiteReal;
    }

    public Timestamp getfechaHoraInicioTramiteReal() {
        return fechaHoraInicioTramiteReal;
    }

    public void setfechaHoraInicioTramiteReal(Timestamp fechaHoraInicioTramiteReal) {
        this.fechaHoraInicioTramiteReal = fechaHoraInicioTramiteReal;
    }
    
    public Timestamp getfechaHoraLimiteDeEntregaDoc(){
        return fechaHoraLimiteDeEntregaDoc;
    }
    
    public void setfechaHoraLimiteDeEntregaDoc(Timestamp fechaHoraLimiteDeEntregaDoc){
        this.fechaHoraLimiteDeEntregaDoc = fechaHoraLimiteDeEntregaDoc;
    }
    
    public Timestamp getfechaHoraRegistroTramite(){
        return fechaHoraRegistroTramite;
    }
    
    public void setfechaHoraRegistroTramite(Timestamp fechaHoraRegistroTramite){
        this.fechaHoraRegistroTramite = fechaHoraRegistroTramite;
    }
    
    public int getnroTramite(){
        return nroTramite;
    }
    
    public void setnroTramite(int nroTramite){
        this.nroTramite = nroTramite;
    }
    
    public String getObservaciones(){
        return Observaciones;
    }
    
    public void setObservaciones(String Observaciones){
        this.Observaciones = Observaciones;
    }
    
    public int getTramiteCosto(){
        return TramiteCosto;
    }
    
    public void setTramiteCosto(int TramiteCosto){
        this.TramiteCosto = TramiteCosto;
    }
    
    public Cliente getcliente(){
        return cliente;
    }
    
    public void setcliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public Consultor getconsultor(){
        return consultor;
    }
    
    public void setconsultor(Consultor consultor){
        this.consultor = consultor;
    }
    
    public EstadoTramite getestadoTramite(){
        return estadoTramite;
    }
    
    public void setestadoTramite(EstadoTramite estadoTramite){
        this.estadoTramite = estadoTramite;
    }
    
    public List<TramiteEstado> gettramiteEstadoList(){
        return tramiteEstadoList;
    }
    
    public void settramiteEstadoList(List<TramiteEstado> tramiteEstadoList){
        this.tramiteEstadoList = tramiteEstadoList;
    }
    
    public TipoTramite gettipoTramite(){
        return tipoTramite;
    }
    
    public void settipoTramite(TipoTramite tipoTramite){
        this.tipoTramite = tipoTramite;
    }
    
    public List<TramiteDocumentacion> gettramiteDocumentacionList(){
        return tramiteDocumentacionList;
    }
    
    public void settramiteDocumentacionList(List<TramiteDocumentacion> tramiteDocumentacionList){
        this.tramiteDocumentacionList = tramiteDocumentacionList;
    }
    
}

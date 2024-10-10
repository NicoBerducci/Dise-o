package RegistrarTramiteWeb.beans;

import RegistrarTramiteWeb.ControladorRegistrarTramiteWeb;
import RegistrarTramiteWeb.dtos.DTOCategoria;
import RegistrarTramiteWeb.dtos.DTOTipoTramite;
import RegistrarTramiteWeb.dtos.DTOCliente;
import RegistrarTramiteWeb.dtos.DTOTramite;
import RegistrarTramiteWeb.dtos.DTOTramiteList;
import entidades.Cliente;
import entidades.Consultor;
import entidades.EstadoTramite;
import entidades.TipoDocumentacion;
import entidades.TipoTramite;
import entidades.TipoTramiteTipoDocumentacion;
import entidades.Tramite;
import entidades.TramiteDocumentacion;
import entidades.TramiteEstado;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import utils.FachadaPersistencia;

@Named("uiregistrarTramiteWeb")
@SessionScoped
public class UIRegistrarTramiteWeb implements Serializable{
    
    private ControladorRegistrarTramiteWeb controladorRegistrarTramiteWeb = new ControladorRegistrarTramiteWeb();

    public ControladorRegistrarTramiteWeb getControladorRegistrarTramiteWeb() {
        return controladorRegistrarTramiteWeb;
    }

    public void setControladorRegistrarTramiteWeb(ControladorRegistrarTramiteWeb controladorRegistrarTramiteWeb) {
        this.controladorRegistrarTramiteWeb = controladorRegistrarTramiteWeb;
    }
            
    public List<CategoriasGrillaUI> buscarCategorias(){
        List<CategoriasGrillaUI> tramitesGrilla = new ArrayList<>();
        List<DTOCategoria> categoriasDTO = controladorRegistrarTramiteWeb.buscarCategorias();
                 
        for (DTOCategoria categoriaDTO : categoriasDTO) {
            CategoriasGrillaUI categoriaGrillaUI = new CategoriasGrillaUI();
            categoriaGrillaUI.setNombrecat(categoriaDTO.getNombrecat());
            categoriaGrillaUI.setDescWebcat(categoriaDTO.getDescWebcat());
            tramitesGrilla.add(categoriaGrillaUI);
        }
        return tramitesGrilla;
    }
    
    public List<TipoTramitesGrillaUI> buscarTipoTramites(String nombreCategoria){
        List<TipoTramitesGrillaUI> tipotramitesGrilla = new ArrayList<>();
        List<DTOTipoTramite> tipoTramitesDTO = controladorRegistrarTramiteWeb.buscarTipoTramites(nombreCategoria);
                
        for (DTOTipoTramite tipoTramiteDTO : tipoTramitesDTO) {
            TipoTramitesGrillaUI tipotramiteGrillaUI = new TipoTramitesGrillaUI();
            tipotramiteGrillaUI.setNombrett(tipoTramiteDTO.getNombrett());
            tipotramiteGrillaUI.setDescWebtt(tipoTramiteDTO.getDescWebtt());
            tipotramiteGrillaUI.setMaxDiasParaDocumentacion(tipoTramiteDTO.getMaxDiasParaDocumentacion());
            tipotramitesGrilla.add(tipotramiteGrillaUI);
        }
        return tipotramitesGrilla;
    }
    
    private final TramiteGrillaUI tramiteGrillaUI = new TramiteGrillaUI();
    
    public void setNombreCategoriaSeleccionada(String nombrecat){
        tramiteGrillaUI.setNombreCategoria(nombrecat);                      
    }
    
    public String  getNombreCategoriaSeleccionada(){
        String nombrecat = tramiteGrillaUI.getNombreCategoria();
        return nombrecat;
    }
    
    public void setNombreTipoTramiteSeleccionado(String nombrett){
        tramiteGrillaUI.setNombreTipoTramite(nombrett);
    }

    public String  getNombreTipoTramiteSeleccionado(){
        String nombrett = tramiteGrillaUI.getNombreTipoTramite();
        return nombrett;
    }
        
    public void buscarCliente(String username){
        List<DTOCliente> clientesDTO = controladorRegistrarTramiteWeb.buscarCliente(username);
                
        for (DTOCliente clienteDTO : clientesDTO) {
            if(clientesDTO.size()== 1){
                tramiteGrillaUI.setUsername(username);
                tramiteGrillaUI.setNombreCliente(clienteDTO.getNombreCliente());
                tramiteGrillaUI.setApellidoCliente(clienteDTO.getApellidoCliente());
                tramiteGrillaUI.setDNI(clienteDTO.getDNICliente());
            } else{
                System.out.println("Se está devolviendo más de un cliente para este usuario.");    
            }
        }
    }
    
    public String getNombreApellidoCLiente(String username){
        buscarCliente(username);
        String NombreApellido = tramiteGrillaUI.getNombreCliente()+ " " + tramiteGrillaUI.getApellidoCliente();
        return NombreApellido;
    }
    
    public int getDNICliente(String username) {
        buscarCliente(username);
        return tramiteGrillaUI.getDNI();
    }
    
    public String setFechaHoraLimiteDeEntregaDoc(){
        int maxDiasParaDocumentacion = buscarMaxDiasParaDocumentacion();
        Timestamp timestampActual = new Timestamp(System.currentTimeMillis());

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestampActual.getTime());
        calendar.add(Calendar.DAY_OF_MONTH, maxDiasParaDocumentacion);
        
        Timestamp nuevoTimestamp = new Timestamp(calendar.getTimeInMillis());
        // Formato deseado: "yyyy-MM-dd HH:mm:ss"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String fechaHoraFormateada = sdf.format(nuevoTimestamp);
        return fechaHoraFormateada;
    }
    
    public int buscarMaxDiasParaDocumentacion() {
        String nombrettMDPD = getNombreTipoTramiteSeleccionado();
        List<DTOTipoTramite> tipoTramitesDTO = controladorRegistrarTramiteWeb.buscarMaxDiasParaDocumentacion(nombrettMDPD);

        for (DTOTipoTramite tipoTramiteDTO : tipoTramitesDTO) {
                return tipoTramiteDTO.getMaxDiasParaDocumentacion(); 
        }
        return 0; 
    }

    public int generarNumeroTramiteNuevo() {
        List<DTOTramiteList> listaTramitesDTO = controladorRegistrarTramiteWeb.generarNumeroTramiteNuevo();
        int maxNroTramite = Integer.MIN_VALUE;

        for (DTOTramiteList listaTramiteDTO : listaTramitesDTO) {
            int nroTramite = listaTramiteDTO.getNroTramite();
            if (nroTramite > maxNroTramite) {
                maxNroTramite = nroTramite;
            }
        }
        // Devuelve el valor más grande más uno
        int nuevoNroTramite = (maxNroTramite != Integer.MIN_VALUE) ? maxNroTramite + 1 : 0; // Retorna 0 si la lista está vacía
        tramiteGrillaUI.setNumeroTramite(nuevoNroTramite);

        return nuevoNroTramite;
    }
    
    public int buscarPrecioTramite(){
        String nombrettBPT = getNombreTipoTramiteSeleccionado();
        List<DTOTramite> tramitesDTO = controladorRegistrarTramiteWeb.buscarPrecioTramite(nombrettBPT);
        int precio = 0;        
        for (DTOTramite tramiteDTO : tramitesDTO) {
            tramiteGrillaUI.setPrecio(tramiteDTO.getPrecio());
            precio = tramiteDTO.getPrecio();
        }
        return precio;
    }
    
    public int determinarConsultorATramite() {   
        int legajoConsultor = controladorRegistrarTramiteWeb.determinarConsultorATramite();
        tramiteGrillaUI.setNroConsultor(legajoConsultor);
        return legajoConsultor; 
    }
    
    public List<String> obtenerListaDocumentacionTT(){
        String nombreTipoTramite = tramiteGrillaUI.getNombreTipoTramite();
        System.out.println("Tipo de trámite: " + nombreTipoTramite);
        List<DTOTramite> tramitesDTO = controladorRegistrarTramiteWeb.obtenerListaDocumentacionTT(nombreTipoTramite);
        
        // Usar Streams para recolectar nombres de documentación
        List<String> listaNombreDocumentacion = tramitesDTO.stream()
            .flatMap(tramiteDTO -> tramiteDTO.getNombreDocumentacionList().stream())
            .collect(Collectors.toList());
        
        tramiteGrillaUI.setNombreDocumentacionList(listaNombreDocumentacion);  
        return listaNombreDocumentacion;
    }
    
    public String obtenerDocumentacionComoCadena() {
        List<String> nombresDocumentacion = obtenerListaDocumentacionTT();
        if (nombresDocumentacion.isEmpty()) {
            return "No hay documentación disponible.";
        }
        return nombresDocumentacion.stream().map(String::trim).collect(Collectors.joining(", "));
    }
    
    
    public void crearTramite(){ 
        
        FachadaPersistencia.getInstance().iniciarTransaccion();

        String nombreTipoTramite = tramiteGrillaUI.getNombreTipoTramite();
        TipoTramite tipotramite1 = controladorRegistrarTramiteWeb.obtenerTipoTramite(nombreTipoTramite);
        List objetoList2 = tipotramite1.gettipoTramiteTipoDocumentacionList();
        List <TipoDocumentacion> listaTipoDocumentacion = new ArrayList<>();
                for(Object y : objetoList2){
                    TipoTramiteTipoDocumentacion tttt = (TipoTramiteTipoDocumentacion) y;
                    Date fechaDesde = tttt.getfechaDesdeTipoTramiteTipoDocumentacion();
                    Date fechaHasta = tttt.getfechaHastaTipoTramiteTipoDocumentacion();
                    Date fechaActual = new Date();
                    
                    System.out.println("Fecha Actual: " + fechaActual + ", Desde: " + fechaDesde + ", Hasta: " + fechaHasta);

                    if(fechaActual.compareTo(fechaDesde) >= 0 && fechaActual.compareTo(fechaHasta) <= 0){
                        TipoDocumentacion td = tttt.gettipoDocumentacion();
                        listaTipoDocumentacion.add(td);
                    }
                }
                
        //Creacion de TramiteDocumentacion vacio para cada tipoDocumentacion del tipoTramite del tramite actual      
        List<TramiteDocumentacion> listaDocumentacionTramite = new ArrayList<>();
        for (TipoDocumentacion td : listaTipoDocumentacion) {
            TramiteDocumentacion documentacionTramite = new TramiteDocumentacion();
            documentacionTramite.setfechaHoraEntregaDoc(null);
            documentacionTramite.settipoDocumentacion(td);

            listaDocumentacionTramite.add(documentacionTramite);
        }     
        int nroLegajoConsultor = tramiteGrillaUI.getNroConsultor();
        Consultor consultor1 = controladorRegistrarTramiteWeb.obtenerConsultor(nroLegajoConsultor);
        int DNICli = tramiteGrillaUI.getDNI();
        Cliente cliente1 = controladorRegistrarTramiteWeb.obtenerCliente(DNICli);
        
        EstadoTramite estadoTramite1 = controladorRegistrarTramiteWeb.obtenerEstadoTramite();
        
        TramiteEstado tramiteEstado1 = new TramiteEstado();
        tramiteEstado1.setcontadorEstado(1);
        tramiteEstado1.setetapa(1);
        tramiteEstado1.setfechaInicioTramiteEstado(new Date());
        tramiteEstado1.setestadoTramite(estadoTramite1);
        
        List <TramiteEstado> listaTramiteEstado = new ArrayList<>();
        listaTramiteEstado.add(tramiteEstado1);
        
        Tramite tramite = new Tramite();
        tramite.setfechaHoraRegistroTramite(new Timestamp(System.currentTimeMillis()));
        tramite.setfechaHoraLimiteDeEntregaDoc(tramiteGrillaUI.getFechaHoraLimiteDeEntregaDoc());
        tramite.setTramiteCosto(tramiteGrillaUI.getPrecio());
        tramite.setnroTramite(tramiteGrillaUI.getNumeroTramite());
        tramite.settramiteDocumentacionList(listaDocumentacionTramite);
        tramite.settipoTramite(tipotramite1);
        tramite.setconsultor(consultor1);
        tramite.setcliente(cliente1);
        tramite.settramiteEstadoList(listaTramiteEstado);
        tramite.setestadoTramite(estadoTramite1);
        
        FachadaPersistencia.getInstance().guardar(tramite);
        
        FachadaPersistencia.getInstance().finalizarTransaccion();
    }
    
}

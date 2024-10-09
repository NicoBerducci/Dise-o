package RegistrarTramiteWeb.beans;

import RegistrarTramiteWeb.ControladorRegistrarTramiteWeb;
import RegistrarTramiteWeb.dtos.DTOCategoria;
import RegistrarTramiteWeb.dtos.DTOTipoTramite;
import RegistrarTramiteWeb.dtos.DTOCliente;
import RegistrarTramiteWeb.dtos.DTOTramite;
import RegistrarTramiteWeb.dtos.DTOTramiteList;
import entidades.Tramite;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

    public int generarNumeroTramiteNuevo(){
        List<DTOTramiteList> listaTramitesDTO = controladorRegistrarTramiteWeb.generarNumeroTramiteNuevo();
        int maxNroTramite = Integer.MIN_VALUE;
        
        for (DTOTramiteList listaTramiteDTO : listaTramitesDTO){
            int nroTramite = listaTramiteDTO.getNroTramite();
            if(nroTramite > maxNroTramite){
                maxNroTramite = nroTramite + 1;
            }            
            return maxNroTramite;
        }
        return 0;
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
    
    
    public void crearTramite(){
        FachadaPersistencia.getInstance().iniciarTransaccion();
        
        Tramite tramite = new Tramite();
        tramite.setfechaHoraRegistroTramite(new Timestamp(System.currentTimeMillis()));
        tramite.setfechaEntregaDocumentacion(tramiteGrillaUI.getFechaHoraLimiteDeEntregaDoc());
        tramite.setTramiteCosto(tramiteGrillaUI.getPrecio());
        tramite.setnroTramite(generarNumeroTramiteNuevo());
        
        FachadaPersistencia.getInstance().guardar(tramite);
        
        FachadaPersistencia.getInstance().finalizarTransaccion();
    }
    
}

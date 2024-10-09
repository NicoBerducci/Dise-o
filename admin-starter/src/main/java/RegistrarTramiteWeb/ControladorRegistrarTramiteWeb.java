package RegistrarTramiteWeb;

import RegistrarTramiteWeb.dtos.DTOCategoria;
import RegistrarTramiteWeb.dtos.DTOTipoTramite;
import RegistrarTramiteWeb.dtos.DTOTramite;
import RegistrarTramiteWeb.dtos.DTOCliente;
import RegistrarTramiteWeb.dtos.DTOTramiteList;
import java.util.List;

public class ControladorRegistrarTramiteWeb {
    
    private ExpertoRegistrarTramiteWeb expertoRegistrarTramiteWeb = new ExpertoRegistrarTramiteWeb();
    public List<DTOCategoria> buscarCategorias(){
        return expertoRegistrarTramiteWeb.buscarCategorias();
    }
    
    public List<DTOTipoTramite> buscarTipoTramites(String nombreCategoria){
        return expertoRegistrarTramiteWeb.buscarTipoTramites(nombreCategoria);
    }
    
    public List<DTOCliente> buscarCliente(String username){
        return expertoRegistrarTramiteWeb.buscarCliente(username);
    }
        
    public List<DTOTipoTramite> buscarMaxDiasParaDocumentacion(String nombrettMDPD){
        return expertoRegistrarTramiteWeb.buscarMaxDiasParaDocumentacion(nombrettMDPD);

    }
    
    public List<DTOTramiteList> generarNumeroTramiteNuevo(){
        return expertoRegistrarTramiteWeb.generarNumeroTramiteNuevo();
    }
    
    public List<DTOTramite> buscarPrecioTramite(String nombrettBPT){
        return expertoRegistrarTramiteWeb.buscarPrecioTramite(nombrettBPT);
    }
}

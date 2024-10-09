package RegistrarTramiteWeb;

import RegistrarTramiteWeb.dtos.DTOCategoria;
import RegistrarTramiteWeb.dtos.DTOTipoTramite;
import RegistrarTramiteWeb.dtos.DTOTramite;
import RegistrarTramiteWeb.dtos.DTOCliente;
import RegistrarTramiteWeb.dtos.DTOTramiteList;
import entidades.Categoria;
import entidades.Cliente;
import entidades.ConfigCostoTipoTramite;
import entidades.CostoTipoTramite;
import entidades.TipoTramite;
import entidades.Tramite;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import utils.DTOCriterio;
import utils.FachadaPersistencia;

public class ExpertoRegistrarTramiteWeb {
    
    
    public List<DTOCategoria> buscarCategorias(){
        
        List<DTOCriterio> lCriterio=new ArrayList<DTOCriterio>();
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("fechaHoraBajaCategoria");
            unCriterio.setOperacion("=");
            unCriterio.setValor(null);
            lCriterio.add(unCriterio);
            
        List objetoList = FachadaPersistencia.getInstance().buscar("Categoria", lCriterio);
        List<DTOCategoria> categoriasResultado = new ArrayList<>();
        for (Object x : objetoList) {
            Categoria categoria = (Categoria) x;
            DTOCategoria categoriaDTO = new DTOCategoria();
            categoriaDTO.setNombrecat(categoria.getnombreCategoria());
            categoriaDTO.setDescWebcat(categoria.getdescWebCategoria());
            categoriasResultado.add(categoriaDTO);
        }
        return categoriasResultado;
    }
    
    public List<DTOTipoTramite> buscarTipoTramites(String nombreCategoria){
        
        List<DTOCriterio> lCriterio=new ArrayList<DTOCriterio>();
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("fechaHoraBajaTipoTramite");
            unCriterio.setOperacion("=");
            unCriterio.setValor(null);
            lCriterio.add(unCriterio);
            
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoTramite", lCriterio);
        List<DTOTipoTramite> tipoTramitesResultado = new ArrayList<>();
        for (Object x : objetoList) {
            TipoTramite tipoTramite = (TipoTramite) x;
            String cat = tipoTramite.getcategoria().getnombreCategoria();
            DTOTipoTramite tipoTramiteDTO = new DTOTipoTramite();
            if(cat.equals(nombreCategoria)){
            tipoTramiteDTO.setNombrett(tipoTramite.getnombreTipoTramite());
            tipoTramiteDTO.setDescWebtt(tipoTramite.getdescWebTipoTramite());
            tipoTramiteDTO.setMaxDiasParaDocumentacion(tipoTramite.getmaxDiasParaDocumentacion());
            tipoTramitesResultado.add(tipoTramiteDTO);
            }
        }
        return tipoTramitesResultado;
    }
    
    public List<DTOCliente> buscarCliente(String username){
        List<DTOCriterio> lCriterio=new ArrayList<DTOCriterio>();
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("fechaHoraBajaCliente");
            unCriterio.setOperacion("=");
            unCriterio.setValor(null);
            lCriterio.add(unCriterio);
            
        List objetoList = FachadaPersistencia.getInstance().buscar("Cliente", lCriterio);
        List<DTOCliente> clientesResultado = new ArrayList<>();
        for (Object x : objetoList) {
            Cliente cliente = (Cliente) x;
            DTOCliente clienteDTO = new DTOCliente();
            String usern = cliente.getusuario().getusername();
            if(usern.equals(username)){
                clienteDTO.setNombreCliente(cliente.getnombreCliente());
                clienteDTO.setApellidoCliente(cliente.getApellidoCliente());
                clienteDTO.setDNICliente(cliente.getDNICliente());
                clientesResultado.add(clienteDTO);
            }
        }
        return clientesResultado;        
    }
    
    public List<DTOTipoTramite> buscarMaxDiasParaDocumentacion(String nombrettMDPD){
        List<DTOCriterio> lCriterio=new ArrayList<DTOCriterio>();
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("nombreTipoTramite");
            unCriterio.setOperacion("=");
            unCriterio.setValor(nombrettMDPD);
            lCriterio.add(unCriterio);
            
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoTramite", lCriterio);
        List<DTOTipoTramite> maxDiasResultado = new ArrayList<>();
        for (Object x : objetoList) {
            TipoTramite tipoTramite = (TipoTramite) x;
            Date fechabaj  = tipoTramite.getfechaHoraBajaTipoTramite();
            DTOTipoTramite tipoTramiteDTO = new DTOTipoTramite();
            if(fechabaj == null){
            tipoTramiteDTO.setMaxDiasParaDocumentacion(tipoTramite.getmaxDiasParaDocumentacion());
            maxDiasResultado.add(tipoTramiteDTO);
            }
        }
        return maxDiasResultado;        
    }
    
    public List<DTOTramiteList> generarNumeroTramiteNuevo(){
         List<DTOCriterio> lCriterio=new ArrayList<DTOCriterio>();
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("fechaHoraRegistroTramite");
            unCriterio.setOperacion("!=");
            unCriterio.setValor(null);
            lCriterio.add(unCriterio);
            
        List objetoList = FachadaPersistencia.getInstance().buscar("Tramite", lCriterio);
        List<DTOTramiteList> numeroTramiteNuevo = new ArrayList<>();
        for (Object x : objetoList) {
            Tramite tramite = (Tramite) x;
            DTOTramiteList tramiteListDTO = new DTOTramiteList();
            tramiteListDTO.setNroTramite(tramite.getnroTramite());
            numeroTramiteNuevo.add(tramiteListDTO);
        }
        return numeroTramiteNuevo;  
     }
    
    public List<DTOTramite> buscarPrecioTramite(String nombrettBPT){
        List<DTOCriterio> lCriterio=new ArrayList<DTOCriterio>();
        DTOCriterio unCriterio=new DTOCriterio();
        unCriterio.setAtributo("fechaBajaConfigCostoTipoTramite");
        unCriterio.setOperacion("=");
        unCriterio.setValor(null);
        lCriterio.add(unCriterio);
            
        List objetoList = FachadaPersistencia.getInstance().buscar("ConfigCostoTipoTramite", lCriterio);
        List<DTOTramite> precioTramite = new ArrayList<>();
        for (Object x : objetoList) {
            ConfigCostoTipoTramite configc = (ConfigCostoTipoTramite) x;
            Date fdesde = configc.getfechaDesdeConfigCostoTipoTramite();
            Date fhasta = configc.getfechaHastaConfigCostoTipoTramite();
            Date feactual = new Date();
            if(feactual.compareTo(fdesde) >= 0 && feactual.compareTo(fhasta) <= 0){
                List objetoList2 = configc.getcostoTipoTramiteList();
                for(Object y : objetoList2){
                CostoTipoTramite costo = (CostoTipoTramite) y;
                String nombrett = costo.gettipoTramite().getnombreTipoTramite();
                    if(nombrett.equals(nombrettBPT)){
                        DTOTramite tramiteDTO = new DTOTramite();
                        tramiteDTO.setPrecio(costo.getimporteCostoTipoTramite());
                        precioTramite.add(tramiteDTO);
                    }
                } 
            }
        }
        return precioTramite;
    }
     
}

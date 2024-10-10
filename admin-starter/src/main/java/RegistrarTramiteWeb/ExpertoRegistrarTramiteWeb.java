package RegistrarTramiteWeb;

import RegistrarTramiteWeb.dtos.DTOCategoria;
import RegistrarTramiteWeb.dtos.DTOTipoTramite;
import RegistrarTramiteWeb.dtos.DTOTramite;
import RegistrarTramiteWeb.dtos.DTOCliente;
import RegistrarTramiteWeb.dtos.DTOTramiteList;
import entidades.Categoria;
import entidades.Cliente;
import entidades.ConfigCostoTipoTramite;
import entidades.Consultor;
import entidades.CostoTipoTramite;
import entidades.EstadoTramite;
import entidades.TipoDocumentacion;
import entidades.TipoTramite;
import entidades.TipoTramiteTipoDocumentacion;
import entidades.Tramite;
import java.sql.Timestamp;
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
    
    public int determinarConsultorATramite() {
   
        List<DTOCriterio> lCriterio = new ArrayList<DTOCriterio>();
        DTOCriterio unCriterio = new DTOCriterio();
        unCriterio.setAtributo("fechaHoraBajaConsultor");
        unCriterio.setOperacion("=");
        unCriterio.setValor(null); 
        lCriterio.add(unCriterio);

        List objetoList = FachadaPersistencia.getInstance().buscar("Consultor", lCriterio);
        List<Consultor> consultoresDisponibles = new ArrayList<>();

        Consultor consultorSeleccionado = null;
        int minTramites = Integer.MAX_VALUE;
        for (Object x : objetoList){
            Consultor consultores = (Consultor) x;
            consultoresDisponibles.add(consultores);    
                for(Consultor consultor : consultoresDisponibles){
                    int tramitesAsignados = contarTramitesAsignados(consultor);
                    if (tramitesAsignados < minTramites) {
                        minTramites = tramitesAsignados;
                        consultorSeleccionado = consultor;
                    }
                }
            }
        return (consultorSeleccionado != null) ? consultorSeleccionado.getnroLegajoConsultor() : -1;
   }
    
   public int contarTramitesAsignados(Consultor consultor) {
        List<DTOCriterio> lCriterio = new ArrayList<DTOCriterio>();
        DTOCriterio unCriterio = new DTOCriterio();

        unCriterio.setAtributo("consultor"); 
        unCriterio.setOperacion("="); 
        unCriterio.setValor(consultor); 
        lCriterio.add(unCriterio);
        List objetoList = FachadaPersistencia.getInstance().buscar("Tramite", lCriterio);
        // Devuelve el tamaño de la lista como el número de trámites asignados
        return objetoList.size(); 
    }

   
    public List<DTOTramite> obtenerListaDocumentacionTT(String nombreTipoTramite){
        List<DTOCriterio> lCriterio=new ArrayList<DTOCriterio>();
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("nombreTipoTramite");
            unCriterio.setOperacion("=");
            unCriterio.setValor(nombreTipoTramite);
            lCriterio.add(unCriterio);
            
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoTramite", lCriterio);
        List<DTOTramite> documentacionesResultado = new ArrayList<>();

        for (Object x : objetoList) {
            TipoTramite tipoTramite = (TipoTramite) x;
            DTOTramite tramiteDTO = new DTOTramite();
            Date fechabaj  = tipoTramite.getfechaHoraBajaTipoTramite();
            System.out.println("TipoTramite: " + tipoTramite.getnombreTipoTramite()+ ", Fecha de baja: " + fechabaj);

            if(fechabaj == null){
                List<TipoTramiteTipoDocumentacion> objetoList2 = tipoTramite.gettipoTramiteTipoDocumentacionList();
                List <String> listaNombreDocumentacion = new ArrayList<>();

                for(Object y : objetoList2){
                    TipoTramiteTipoDocumentacion tttt = (TipoTramiteTipoDocumentacion) y;
                    Date fechaDesde = tttt.getfechaDesdeTipoTramiteTipoDocumentacion();
                    Date fechaHasta = tttt.getfechaHastaTipoTramiteTipoDocumentacion();
                    Date fechaActual = new Date();
                    
                    System.out.println("Fecha Actual: " + fechaActual + ", Desde: " + fechaDesde + ", Hasta: " + fechaHasta);

                    if(fechaActual.compareTo(fechaDesde) >= 0 && fechaActual.compareTo(fechaHasta) <= 0){
                        TipoDocumentacion td = tttt.gettipoDocumentacion();
                        String nombreDocumentacion = td.getnombreTipoDocumentacion();
                        listaNombreDocumentacion.add(nombreDocumentacion);
                        
                        System.out.println("Documentación añadida: " + nombreDocumentacion);

                    }
                }
                tramiteDTO.setNombreDocumentacionList(listaNombreDocumentacion);
                documentacionesResultado.add(tramiteDTO);
            }
        }
        return documentacionesResultado; 
    }
    
    public TipoTramite obtenerTipoTramite(String nombreTipoTramite){
        List<DTOCriterio> lCriterio=new ArrayList<DTOCriterio>();
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("nombreTipoTramite");
            unCriterio.setOperacion("=");
            unCriterio.setValor(nombreTipoTramite);
            lCriterio.add(unCriterio);
            
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoTramite", lCriterio);
        TipoTramite tipoTramiteResultado = new TipoTramite();

        
        for (Object x : objetoList) {
            TipoTramite tipoTramite = (TipoTramite) x;
            Date fechabaj  = tipoTramite.getfechaHoraBajaTipoTramite();
            if(fechabaj == null){
                tipoTramiteResultado = tipoTramite;
            }
        }
        return tipoTramiteResultado;
    }
    
    public Consultor obtenerConsultor(int nroLegajoConsultor){
        List<DTOCriterio> lCriterio=new ArrayList<DTOCriterio>();
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("nroLegajoConsultor");
            unCriterio.setOperacion("=");
            unCriterio.setValor(nroLegajoConsultor);
            lCriterio.add(unCriterio);
            
        List objetoList = FachadaPersistencia.getInstance().buscar("Consultor", lCriterio);
        Consultor consultorResultado = new Consultor();

        
        for (Object x : objetoList) {
            Consultor consultor = (Consultor) x;
            Date fechabaj  = consultor.getfechaHoraBajaConsultor();
            if(fechabaj == null){
                consultorResultado = consultor;
            }
        }
        return consultorResultado;
    }
    
        public Cliente obtenerCliente(int DNICli){
        List<DTOCriterio> lCriterio=new ArrayList<DTOCriterio>();
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("DNICliente");
            unCriterio.setOperacion("=");
            unCriterio.setValor(DNICli);
            lCriterio.add(unCriterio);
            
        List objetoList = FachadaPersistencia.getInstance().buscar("Cliente", lCriterio);
        Cliente clienteResultado = new Cliente();

        
        for (Object x : objetoList) {
            Cliente cliente = (Cliente) x;
            Date fechabaj  = cliente.getfechaHoraBajaCliente();
            if(fechabaj == null){
                clienteResultado = cliente;
            }
        }
        return clienteResultado;
    }
        
        public EstadoTramite obtenerEstadoTramite(){
        List<DTOCriterio> lCriterio=new ArrayList<DTOCriterio>();
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("nombreEstadoTramite");
            unCriterio.setOperacion("=");
            unCriterio.setValor("Ingresado");
            lCriterio.add(unCriterio);
            
        List objetoList = FachadaPersistencia.getInstance().buscar("EstadoTramite", lCriterio);
        EstadoTramite estadoTramiteResultado = new EstadoTramite();

        
        for (Object x : objetoList) {
            EstadoTramite estadoTramite = (EstadoTramite) x;
            Date fechabaj  = estadoTramite.getfechaBajaEstadoTramite();
            if(fechabaj == null){
                estadoTramiteResultado = estadoTramite;
            }
        }
        return estadoTramiteResultado;
    }
        
}

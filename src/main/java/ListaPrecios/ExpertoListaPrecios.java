package ListaPrecios;

import ListaPrecios.dtos.DTOConfigCostoTipoTramiteFiltro;
import ListaPrecios.dtos.DTOCostoTipoTramiteExportar;
import ListaPrecios.dtos.DTOCostoTipoTramiteImportar;
import ListaPrecios.exceptions.ListaPreciosException;
import entidades.ConfigCostoTipoTramite;
import entidades.CostoTipoTramite;
import java.util.Date;
import utils.DTOCriterio;
import utils.FachadaPersistencia;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import entidades.TipoTramite;
import ListaPrecios.dtos.DTOConfigCostoTipoTramiteImportar;
import java.util.HashSet;  
import java.util.Set;      
import java.util.List;     
import java.util.ArrayList; 
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ExpertoListaPrecios {




 public List<DTOConfigCostoTipoTramiteFiltro> buscarListas(Date fechaHastaConfigCostoTipoTramite) {
    List<DTOCriterio> lCriterio = new ArrayList<>();

    // Solo añade el criterio si la fecha es válida
    if (fechaHastaConfigCostoTipoTramite != null) {
        DTOCriterio unCriterio = new DTOCriterio();
        unCriterio.setAtributo("fechaHastaConfigCostoTipoTramite");
        unCriterio.setOperacion(">=");  // Operación para filtrar por menor o igual
        unCriterio.setValor(fechaHastaConfigCostoTipoTramite);
        lCriterio.add(unCriterio);
    }

    // Agrega un criterio para filtrar por fechaBajaConfigCostoTipoTramite
    DTOCriterio criterioFechaBaja = new DTOCriterio();
    criterioFechaBaja.setAtributo("fechaBajaConfigCostoTipoTramite");
    criterioFechaBaja.setOperacion("=");
    criterioFechaBaja.setValor(null); // Esto filtrará los objetos con fechaBajaConfigCostoTipoTramite null
    lCriterio.add(criterioFechaBaja);

    // Realiza la búsqueda en la base de datos utilizando los criterios
    List<Object> objetoList = FachadaPersistencia.getInstance().buscar("ConfigCostoTipoTramite", lCriterio);
    System.out.println("Cantidad de objetos encontrados: " + objetoList.size());

    // Lista para almacenar los DTOs filtrados
    List<DTOConfigCostoTipoTramiteFiltro> CostosFiltrados = new ArrayList<>();
    
    // Convertir los objetos encontrados en DTOs
    for (Object x : objetoList) {
        ConfigCostoTipoTramite configCostoTipoTramite = (ConfigCostoTipoTramite) x;
        DTOConfigCostoTipoTramiteFiltro dtoConfigCostoTipoTramiteFiltro = new DTOConfigCostoTipoTramiteFiltro();
        
        dtoConfigCostoTipoTramiteFiltro.setfechaHastaConfigCostoTipoTramite(configCostoTipoTramite.getfechaHastaConfigCostoTipoTramite());
        dtoConfigCostoTipoTramiteFiltro.setfechaDesdeConfigCostoTipoTramite(configCostoTipoTramite.getfechaDesdeConfigCostoTipoTramite());
        dtoConfigCostoTipoTramiteFiltro.setnroConfigCostoTipoTramite(configCostoTipoTramite.getnroConfigCostoTipoTramite());
        
        // Agregar el DTO a la lista filtrada
        CostosFiltrados.add(dtoConfigCostoTipoTramiteFiltro);
    }

    return CostosFiltrados;
}
    public List<DTOCostoTipoTramiteExportar> buscarCostosTipoTramite(int nroConfigCostoTipoTramite) {
    List<DTOCriterio> lCriterio = new ArrayList<>();
   if (nroConfigCostoTipoTramite != 0) {
        DTOCriterio unCriterio = new DTOCriterio();
        unCriterio.setAtributo("nroConfigCostoTipoTramite");
        unCriterio.setOperacion("=");
        unCriterio.setValor(nroConfigCostoTipoTramite);
        lCriterio.add(unCriterio);
    }

    List objetoList = FachadaPersistencia.getInstance().buscar("ConfigCostoTipoTramite", lCriterio);
    System.out.println("Cantidad de objetos encontrados: " + objetoList.size());

    List<DTOCostoTipoTramiteExportar> costosTipoTramite = new ArrayList<>();
    for (Object x : objetoList) {
        ConfigCostoTipoTramite config = (ConfigCostoTipoTramite) x;

        // Iterate through costoTipoTramiteList and populate DTOCostoTipoTramiteImportar
        for (CostoTipoTramite costo : config.getcostoTipoTramiteList()) {
            DTOCostoTipoTramiteExportar dto = new DTOCostoTipoTramiteExportar();
            if (costo.gettipoTramite() != null) {
                dto.setcodTipoTramite(costo.gettipoTramite().getcodTipoTramite());
            }
            dto.setImporteCostoTipoTramite(costo.getimporteCostoTipoTramite());
            costosTipoTramite.add(dto);
        }
    }

    return costosTipoTramite;
}
    
    
public void guardarConfiguracion(DTOConfigCostoTipoTramiteImportar dtoConfig, List<DTOCostoTipoTramiteImportar> dtoCostos) throws ListaPreciosException {
    Transaction transaction = null;
    Session session = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        // Paso 1: Recolectar y validar los códigos de tipo de trámite del archivo Excel
        Set<Integer> tiposTramiteEnExcel = new HashSet<>();
        for (DTOCostoTipoTramiteImportar dtoCosto : dtoCostos) {
            int codigoTramite = dtoCosto.getcodTipoTramite();
            if (codigoTramite <= 0) {
                throw new ListaPreciosException("El código de tipo de trámite es inválido: " + codigoTramite + ". Verifique el archivo Excel.");
            }
            tiposTramiteEnExcel.add(codigoTramite);
        }

        // Paso 2: Consultar en la base de datos para obtener solo los tipos de trámite activos
        List<DTOCriterio> criterioList = new ArrayList<>();
        
        // Criterio para buscar los códigos de tipo de trámite
        DTOCriterio criterioCodigo = new DTOCriterio();
        criterioCodigo.setAtributo("codTipoTramite");
        criterioCodigo.setOperacion("in");
        criterioCodigo.setValor(new ArrayList<>(tiposTramiteEnExcel));
        criterioList.add(criterioCodigo);
        
        // Criterio para buscar trámites activos (no dados de baja)
        DTOCriterio criterioActivo = new DTOCriterio();
        criterioActivo.setAtributo("fechaHoraBajaTipoTramite");
        criterioActivo.setOperacion("is null");
        criterioList.add(criterioActivo);

        List<?> lTipoTramite = FachadaPersistencia.getInstance().buscar("TipoTramite", criterioList);

        // Paso 3: Verificar la existencia de todos los tipos de trámite requeridos
        Set<Integer> tiposTramiteRequeridos = new HashSet<>();
        for (Object tipoTramiteObj : lTipoTramite) {
            TipoTramite tipoTramite = (TipoTramite) tipoTramiteObj;
            tiposTramiteRequeridos.add(tipoTramite.getcodTipoTramite());
        }

        List<Integer> tiposTramiteFaltantes = new ArrayList<>();
        for (Integer codigoTramite : tiposTramiteEnExcel) {
            if (!tiposTramiteRequeridos.contains(codigoTramite)) {
                tiposTramiteFaltantes.add(codigoTramite);
            }
        }

        if (!tiposTramiteFaltantes.isEmpty()) {
            throw new ListaPreciosException("Los siguientes tipos de trámite están faltantes o dados de baja: " + tiposTramiteFaltantes);
        }

        // Paso 4: Obtener los costos anteriores de los tipos de trámite
        List<DTOCriterio> criterioCostosList = new ArrayList<>();
        DTOCriterio criterioCostos = new DTOCriterio();
        criterioCostos.setAtributo("tipoTramite.codTipoTramite");
        criterioCostos.setOperacion("in");
        criterioCostos.setValor(new ArrayList<>(tiposTramiteEnExcel));
        criterioCostosList.add(criterioCostos);
        List<?> listaCostos = FachadaPersistencia.getInstance().buscar("CostoTipoTramite", criterioCostosList);

        Map<Integer, CostoTipoTramite> costosAnteriores = new HashMap<>();
        for (Object obj : listaCostos) {
            CostoTipoTramite costo = (CostoTipoTramite) obj;
            costosAnteriores.put(costo.gettipoTramite().getcodTipoTramite(), costo);
        }

        // Crear y persistir la nueva configuración
        ConfigCostoTipoTramite config = new ConfigCostoTipoTramite();
        config.setfechaBajaConfigCostoTipoTramite(dtoConfig.getfechaBajaConfigCostoTipoTramite());
        config.setfechaDesdeConfigCostoTipoTramite(dtoConfig.getfechaDesdeConfigCostoTipoTramite());
        config.setfechaHastaConfigCostoTipoTramite(dtoConfig.getfechaHastaConfigCostoTipoTramite());
        config.setnroConfigCostoTipoTramite(dtoConfig.getnroConfigCostoTipoTramite());

        session.save(config);  // Guardar configuración

        // Paso 5: Procesar y guardar cada costo de tipo de trámite
        for (DTOCostoTipoTramiteImportar dtoCosto : dtoCostos) {
            int codigoTramite = dtoCosto.getcodTipoTramite();

            TipoTramite tipoTramite = null;
            for (Object tipoTramiteObj : lTipoTramite) {
                TipoTramite t = (TipoTramite) tipoTramiteObj;
                if (t.getcodTipoTramite() == codigoTramite) {
                    tipoTramite = t;
                    break;
                }
            }

            if (dtoCosto.getImporteCostoTipoTramite() <= 0) {
                CostoTipoTramite costoAnterior = costosAnteriores.get(codigoTramite);
                if (costoAnterior != null) {
                    dtoCosto.setImporteCostoTipoTramite(costoAnterior.getimporteCostoTipoTramite());
                } else {
                    throw new ListaPreciosException("Falta el costo para el tipo de trámite con el código: " + codigoTramite);
                }
            }

            CostoTipoTramite costoTipoTramite = new CostoTipoTramite();
            costoTipoTramite.setimporteCostoTipoTramite(dtoCosto.getImporteCostoTipoTramite());
            costoTipoTramite.settipoTramite(tipoTramite);
            costoTipoTramite.setconfigCostoTipoTramite(config);
            config.getcostoTipoTramiteList().add(costoTipoTramite);

            session.save(costoTipoTramite);
        }

        // Paso 6: Ajustar las fechas de configuraciones superpuestas
        List<DTOCriterio> criteriosFechas = new ArrayList<>();
        DTOCriterio criterioFechaDesde = new DTOCriterio();
        criterioFechaDesde.setAtributo("fechaDesdeConfigCostoTipoTramite");
        criterioFechaDesde.setOperacion("<=");
        criterioFechaDesde.setValor(config.getfechaHastaConfigCostoTipoTramite());
        criteriosFechas.add(criterioFechaDesde);

        DTOCriterio criterioFechaHasta = new DTOCriterio();
        criterioFechaHasta.setAtributo("fechaHastaConfigCostoTipoTramite");
        criterioFechaHasta.setOperacion(">=");
        criterioFechaHasta.setValor(config.getfechaDesdeConfigCostoTipoTramite());
        criteriosFechas.add(criterioFechaHasta);

        List<?> configuracionesSuperpuestas = FachadaPersistencia.getInstance().buscar("ConfigCostoTipoTramite", criteriosFechas);

        for (Object obj : configuracionesSuperpuestas) {
            ConfigCostoTipoTramite configSuperpuesta = (ConfigCostoTipoTramite) obj;

            // Caso 1: Nueva configuración comienza antes y termina dentro de la configuración superpuesta
            if (config.getfechaDesdeConfigCostoTipoTramite().before(configSuperpuesta.getfechaDesdeConfigCostoTipoTramite()) &&
                config.getfechaHastaConfigCostoTipoTramite().before(configSuperpuesta.getfechaHastaConfigCostoTipoTramite())) {
                configSuperpuesta.setfechaDesdeConfigCostoTipoTramite(config.getfechaHastaConfigCostoTipoTramite());
            }
            // Caso 2: Nueva configuración comienza dentro y termina después de la configuración superpuesta
            else if (config.getfechaDesdeConfigCostoTipoTramite().after(configSuperpuesta.getfechaDesdeConfigCostoTipoTramite()) &&
                     config.getfechaHastaConfigCostoTipoTramite().after(configSuperpuesta.getfechaHastaConfigCostoTipoTramite())) {
                configSuperpuesta.setfechaHastaConfigCostoTipoTramite(config.getfechaDesdeConfigCostoTipoTramite());
            }
            // Caso 3: Nueva configuración cubre completamente la configuración superpuesta
            else if (config.getfechaDesdeConfigCostoTipoTramite().before(configSuperpuesta.getfechaDesdeConfigCostoTipoTramite()) &&
                     config.getfechaHastaConfigCostoTipoTramite().after(configSuperpuesta.getfechaHastaConfigCostoTipoTramite())) {
                configSuperpuesta.setfechaDesdeConfigCostoTipoTramite(config.getfechaHastaConfigCostoTipoTramite());
                configSuperpuesta.setfechaHastaConfigCostoTipoTramite(config.getfechaDesdeConfigCostoTipoTramite());
            }

            session.merge(configSuperpuesta);  // Actualizar configuración superpuesta
        }


        transaction.commit();  // Confirmar transacción
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();  // Deshacer cambios en caso de error
        }
        throw new ListaPreciosException("Error al guardar la configuración de precios: " + e.getMessage(), e);
    } finally {
        if (session != null) {
            session.close();  // Cerrar sesión de Hibernate
        }
    }
}







public void darDeBajaConfig(int nroConfigCostoTipoTramite) throws ListaPreciosException {
    FachadaPersistencia.getInstance().iniciarTransaccion();

    List<DTOCriterio> criterioList = new ArrayList<>();
    DTOCriterio dto = new DTOCriterio();

    dto.setAtributo("nroConfigCostoTipoTramite");
    dto.setOperacion("=");
    dto.setValor(nroConfigCostoTipoTramite);

    criterioList.add(dto);

    ConfigCostoTipoTramite configCostoTipoTramiteEncontrado = (ConfigCostoTipoTramite) FachadaPersistencia.getInstance()
        .buscar("ConfigCostoTipoTramite", criterioList)
        .get(0);

    Date currentDate = new Date();

    if (currentDate.after(configCostoTipoTramiteEncontrado.getfechaDesdeConfigCostoTipoTramite()) &&
        (configCostoTipoTramiteEncontrado.getfechaHastaConfigCostoTipoTramite() == null ||
         currentDate.before(configCostoTipoTramiteEncontrado.getfechaHastaConfigCostoTipoTramite()))) {

        throw new ListaPreciosException("No se puede dar de baja la configuración porque está vigente.");
    }

    configCostoTipoTramiteEncontrado.setfechaBajaConfigCostoTipoTramite(new java.sql.Date(System.currentTimeMillis()));

    List<DTOCriterio> nextCriterioList = new ArrayList<>();
    DTOCriterio nextDto = new DTOCriterio();
    nextDto.setAtributo("nroConfigCostoTipoTramite");
    nextDto.setOperacion(">");
    nextDto.setValor(nroConfigCostoTipoTramite);

    nextCriterioList.add(nextDto);

    List<Object> proxsConfigs = FachadaPersistencia.getInstance().buscar("ConfigCostoTipoTramite", nextCriterioList);

    if (!proxsConfigs.isEmpty()) {
        ConfigCostoTipoTramite proxConfig = (ConfigCostoTipoTramite) proxsConfigs.get(0);

      
        proxConfig.setfechaDesdeConfigCostoTipoTramite(configCostoTipoTramiteEncontrado.getfechaDesdeConfigCostoTipoTramite());

        FachadaPersistencia.getInstance().guardar(proxConfig);
    }

    
    FachadaPersistencia.getInstance().guardar(configCostoTipoTramiteEncontrado);
    FachadaPersistencia.getInstance().finalizarTransaccion();
}

}


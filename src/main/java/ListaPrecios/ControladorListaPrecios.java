package ListaPrecios;

import ListaPrecios.dtos.DTOConfigCostoTipoTramiteFiltro;
import ListaPrecios.dtos.DTOCostoTipoTramiteImportar;
import ListaPrecios.dtos.DTOConfigCostoTipoTramiteImportar;
import ListaPrecios.dtos.DTOCostoTipoTramiteExportar;
import ListaPrecios.exceptions.ListaPreciosException;
import java.util.Date;
import java.util.List;

public class ControladorListaPrecios {
    private ExpertoListaPrecios expertoListaPrecios = new ExpertoListaPrecios();

    public List<DTOConfigCostoTipoTramiteFiltro> buscarListas(Date fechaHastaConfigCostoTipoTramite) {
    return expertoListaPrecios.buscarListas(fechaHastaConfigCostoTipoTramite);
    }
    
    public List<DTOCostoTipoTramiteExportar> buscarCostosTipoTramite(int nroConfigCostoTipoTramite) {
        return expertoListaPrecios.buscarCostosTipoTramite(nroConfigCostoTipoTramite);
    }
    
    public void guardarConfiguracion(DTOConfigCostoTipoTramiteImportar config, List<DTOCostoTipoTramiteImportar> costos) throws ListaPreciosException {
        try {
         expertoListaPrecios.guardarConfiguracion(config, costos);
    } catch (Exception e) {
        throw new ListaPreciosException("Error al guardar la configuración: " + e.getMessage());
    }
    }
    
    public void darDeBajaConfig(int nroConfigCostoTipoTramite) throws ListaPreciosException {
        expertoListaPrecios.darDeBajaConfig(nroConfigCostoTipoTramite);
    }    
}


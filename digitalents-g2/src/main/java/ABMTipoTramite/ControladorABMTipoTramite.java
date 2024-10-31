package ABMTipoTramite;

import ABMTipoTramite.dtos.ModificarTipoTramiteDTO;
import ABMTipoTramite.dtos.ModificarTipoTramiteDTOIn;
import ABMTipoTramite.dtos.NuevoTipoTramiteDTO;
import ABMTipoTramite.dtos.TipoTramiteDTO;
import ABMTipoTramite.exceptions.TipoTramiteException;
import java.util.List;

public class ControladorABMTipoTramite {
    private final ExpertoABMTipoTramite expertoABMTipoTramite = new ExpertoABMTipoTramite();
    
    public List<TipoTramiteDTO> buscarTipoTramites(int codTipoTramite, String nombreTipoTramite){
        return expertoABMTipoTramite.buscarTipoTramites(codTipoTramite,nombreTipoTramite);
    }

    public void agregarTipoTramite(NuevoTipoTramiteDTO nuevoTipoTramiteDTO) throws TipoTramiteException{
        expertoABMTipoTramite.agregarTipoTramite(nuevoTipoTramiteDTO);
    }

    public void modificarTipoTramite(ModificarTipoTramiteDTOIn modificarTipoTramiteDTOIn){
        expertoABMTipoTramite.modificarTipoTramite(modificarTipoTramiteDTOIn);
    }

    public ModificarTipoTramiteDTO buscarTipoTramiteAModificar(int codTipoTramite){
        return expertoABMTipoTramite.buscarTipoTramiteAModificar(codTipoTramite);
    }

    public void darDeBajaTipoTramite(int codTipoTramite) throws TipoTramiteException {
        expertoABMTipoTramite.darDeBajaTipoTramite(codTipoTramite);
    }
}

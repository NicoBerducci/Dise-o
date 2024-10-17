/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ABMTipoDocumentacion;

import ABMTipoDocumentacion.dtos.TipoDocumentacionDTO;
import ABMTipoDocumentacion.dtos.ModificarTipoDocumentacionDTO;
import ABMTipoDocumentacion.dtos.ModificarTipoDocumentacionDTOIn;
import ABMTipoDocumentacion.dtos.NuevoTipoDocumentacionDTO;
import ABMTipoDocumentacion.exceptions.TipoDocumentacionException;

import java.util.List;

public class ControladorABMTipoDocumentacion {
    private final ExpertoABMTipoDocumentacion expertoABMTipoDocumentacion = new ExpertoABMTipoDocumentacion();
    
    public List<TipoDocumentacionDTO> buscarTipoDocumentacion(int codTipoDocumentacion, String nombreTipoDocumentacion){
        return expertoABMTipoDocumentacion.buscarTipoDocumentacion(codTipoDocumentacion,nombreTipoDocumentacion);
    }

    public void agregarTipoDocumentacion(NuevoTipoDocumentacionDTO nuevoTipoDocumentacionDTO) throws TipoDocumentacionException{
        expertoABMTipoDocumentacion.agregarTipoDocumentacion(nuevoTipoDocumentacionDTO);
    }

    public void modificarTipoDocumentacion(ModificarTipoDocumentacionDTOIn modificarTipoDocumentacionDTOIn){
        expertoABMTipoDocumentacion.modificarTipoDocumentacion(modificarTipoDocumentacionDTOIn);
    }

    public ModificarTipoDocumentacionDTO buscarTipoDocumentacionAModificar(int codTipoDocumentacion){
        return expertoABMTipoDocumentacion.buscarTipoDocumentacionAModificar(codTipoDocumentacion);
    }

    public void darDeBajaTipoDocumentacion(int codTipoDocumentacion) throws TipoDocumentacionException {
        expertoABMTipoDocumentacion.darDeBajaTipoDocumentacion(codTipoDocumentacion);
    }
    
}
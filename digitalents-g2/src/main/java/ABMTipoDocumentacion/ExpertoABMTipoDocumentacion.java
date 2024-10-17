/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ABMTipoDocumentacion;

import ABMTipoDocumentacion.dtos.TipoDocumentacionDTO;
import ABMTipoDocumentacion.dtos.ModificarTipoDocumentacionDTO;
import ABMTipoDocumentacion.dtos.ModificarTipoDocumentacionDTOIn;
import ABMTipoDocumentacion.dtos.NuevoTipoDocumentacionDTO;
import entidades.TipoDocumentacion;
import ABMTipoDocumentacion.exceptions.TipoDocumentacionException;
import utils.DTOCriterio;
import utils.FachadaPersistencia;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ExpertoABMTipoDocumentacion {
    public List<TipoDocumentacionDTO> buscarTipoDocumentacion(int codTipoDocumentacion,String nombreTipoDocumentacion){
        List<DTOCriterio> lCriterio=new ArrayList<DTOCriterio>();
        if(codTipoDocumentacion>0)
        {
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("codTipoDocumentacion");
            unCriterio.setOperacion("=");
            unCriterio.setValor(codTipoDocumentacion);
            lCriterio.add(unCriterio);
        }
        if(nombreTipoDocumentacion.trim().length()>0)
        {
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("nombreTipoDocumentacion");
            unCriterio.setOperacion("like");
            unCriterio.setValor(nombreTipoDocumentacion);
            lCriterio.add(unCriterio);
        }
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoDocumentacion", lCriterio);
        List<TipoDocumentacionDTO> tipoDocumentacionsResultado = new ArrayList<>();
        for (Object x : objetoList) {
            TipoDocumentacion tipoDocumentacion = (TipoDocumentacion) x;
            TipoDocumentacionDTO tipoDocumentacionDTO = new TipoDocumentacionDTO();
            tipoDocumentacionDTO.setCodTipoDocumentacion(tipoDocumentacion.getcodTipoDocumentacion());
            tipoDocumentacionDTO.setNombreTipoDocumentacion(tipoDocumentacion.getnombreTipoDocumentacion());
            tipoDocumentacionDTO.setFechaHoraBajaTD(tipoDocumentacion.getfechaHoraBajaTD());
            tipoDocumentacionDTO.setDescTipoDocumentacion(tipoDocumentacion.getdescTipoDocumentacion());
            tipoDocumentacionsResultado.add(tipoDocumentacionDTO);
        }
        return tipoDocumentacionsResultado;
    }

    public void agregarTipoDocumentacion(NuevoTipoDocumentacionDTO nuevoTipoDocumentacionDTO) throws TipoDocumentacionException{
        FachadaPersistencia.getInstance().iniciarTransaccion();
        

        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();

        dto.setAtributo("codTipoDocumentacion");
        dto.setOperacion("=");
        dto.setValor(nuevoTipoDocumentacionDTO.getCodTipoDocumentacion());

        criterioList.add(dto);
        List lTipoDocumentacion=FachadaPersistencia.getInstance().buscar("TipoDocumentacion", criterioList);

        if(lTipoDocumentacion.size()> 0)
        {
                throw new TipoDocumentacionException("El CodTipoDocumentacion de TipoDocumentacion ya existe");
        }
        else
        {
        TipoDocumentacion tipoDocumentacion = new TipoDocumentacion();
            tipoDocumentacion.setcodTipoDocumentacion(nuevoTipoDocumentacionDTO.getCodTipoDocumentacion());
            tipoDocumentacion.setnombreTipoDocumentacion(nuevoTipoDocumentacionDTO.getNombreTipoDocumentacion());
            tipoDocumentacion.setdescTipoDocumentacion(nuevoTipoDocumentacionDTO.getDescTipoDocumentacion());

        FachadaPersistencia.getInstance().guardar(tipoDocumentacion);
        FachadaPersistencia.getInstance().finalizarTransaccion();
        }
    }

    public ModificarTipoDocumentacionDTO buscarTipoDocumentacionAModificar(int codTipoDocumentacion){
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();

        dto.setAtributo("codTipoDocumentacion");
        dto.setOperacion("=");
        dto.setValor(codTipoDocumentacion);

        criterioList.add(dto);

        TipoDocumentacion tipoDocumentacionEncontrado = (TipoDocumentacion) FachadaPersistencia.getInstance().buscar("TipoDocumentacion", criterioList).get(0);

        ModificarTipoDocumentacionDTO modificarTipoDocumentacionDTO = new ModificarTipoDocumentacionDTO();
        modificarTipoDocumentacionDTO.setCodTipoDocumentacion(tipoDocumentacionEncontrado.getcodTipoDocumentacion());
        modificarTipoDocumentacionDTO.setNombreTipoDocumentacion(tipoDocumentacionEncontrado.getnombreTipoDocumentacion());
        modificarTipoDocumentacionDTO.setDescTipoDocumentacion(tipoDocumentacionEncontrado.getdescTipoDocumentacion());
        return modificarTipoDocumentacionDTO;
    }

    public void modificarTipoDocumentacion(ModificarTipoDocumentacionDTOIn modificarTipoDocumentacionDTOIn){
        FachadaPersistencia.getInstance().iniciarTransaccion();

        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();

        dto.setAtributo("codTipoDocumentacion");
        dto.setOperacion("=");
        dto.setValor(modificarTipoDocumentacionDTOIn.getCodTipoDocumentacion());

        criterioList.add(dto);

        TipoDocumentacion tipoDocumentacionEncontrado = (TipoDocumentacion) FachadaPersistencia.getInstance().buscar("TipoDocumentacion", criterioList).get(0);


        tipoDocumentacionEncontrado.setcodTipoDocumentacion(modificarTipoDocumentacionDTOIn.getCodTipoDocumentacion());
        tipoDocumentacionEncontrado.setnombreTipoDocumentacion(modificarTipoDocumentacionDTOIn.getNombreTipoDocumentacion());
        tipoDocumentacionEncontrado.setdescTipoDocumentacion(modificarTipoDocumentacionDTOIn.getDescTipoDocumentacion());

        FachadaPersistencia.getInstance().guardar(tipoDocumentacionEncontrado);
        FachadaPersistencia.getInstance().finalizarTransaccion();
    }

    public void darDeBajaTipoDocumentacion(int codTipoDocumentacion) throws TipoDocumentacionException {
        FachadaPersistencia.getInstance().iniciarTransaccion();

        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();

        dto.setAtributo("codTipoDocumentacion");
        dto.setOperacion("=");
        dto.setValor(codTipoDocumentacion);

        criterioList.add(dto);

        TipoDocumentacion tipoDocumentacionEncontrado = (TipoDocumentacion) FachadaPersistencia.getInstance().buscar("TipoDocumentacion", criterioList).get(0);

        criterioList.clear();
        dto = new DTOCriterio();

        dto.setAtributo("tipoDocumentacion");
        dto.setOperacion("=");
        dto.setValor(tipoDocumentacionEncontrado);

        criterioList.add(dto);

        DTOCriterio dto2 = new DTOCriterio();


        dto2.setAtributo("fechaHoraFinTramiteReal");
        dto2.setOperacion("=");
        dto2.setValor(null);

        criterioList.add(dto2);
        
        /*Buscar Tramite*/


        tipoDocumentacionEncontrado.setfechaHoraBajaTD(new Timestamp(System.currentTimeMillis()));

        FachadaPersistencia.getInstance().guardar(tipoDocumentacionEncontrado);
        FachadaPersistencia.getInstance().finalizarTransaccion();
    }
}
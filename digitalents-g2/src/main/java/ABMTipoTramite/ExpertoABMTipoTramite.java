package ABMTipoTramite;

import ABMTipoTramite.dtos.ModificarTipoTramiteDTO;
import ABMTipoTramite.dtos.ModificarTipoTramiteDTOIn;
import ABMTipoTramite.dtos.NuevoTipoTramiteDTO;
import ABMTipoTramite.dtos.TipoTramiteDTO;
import ABMTipoTramite.exceptions.TipoTramiteException;
import entidades.TipoDocumentacion;
import entidades.TipoTramite;
import entidades.Tramite;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import utils.DTOCriterio;
import utils.FachadaPersistencia;
import utils.HibernateUtil;

public class ExpertoABMTipoTramite {

    public List<TipoTramiteDTO> buscarTipoTramites(int codTipoTramite, String nombreTipoTramite) {
        List<DTOCriterio> lCriterio = new ArrayList<DTOCriterio>();
        if (codTipoTramite > 0) {
            DTOCriterio unCriterio = new DTOCriterio();
            unCriterio.setAtributo("codTipoTramite");
            unCriterio.setOperacion("=");
            unCriterio.setValor(codTipoTramite);
            lCriterio.add(unCriterio);
        }
        if (nombreTipoTramite.trim().length() > 0) {
            DTOCriterio unCriterio = new DTOCriterio();
            unCriterio.setAtributo("nombreTipoTramite");
            unCriterio.setOperacion("like");
            unCriterio.setValor(nombreTipoTramite);
            lCriterio.add(unCriterio);
        }
        List objetoList = FachadaPersistencia.getInstance().buscar("TipoTramite", lCriterio);
        List<TipoTramiteDTO> tipoTramitesResultado = new ArrayList<>();
        for (Object x : objetoList) {
            TipoTramite tipoTramite = (TipoTramite) x;
            TipoTramiteDTO tipoTramiteDTO = new TipoTramiteDTO();
            tipoTramiteDTO.setCodTipoTramite(tipoTramite.getCodTipoTramite());
            tipoTramiteDTO.setNombreTipoTramite(tipoTramite.getNombreTipoTramite());
            tipoTramiteDTO.setDescTipoTramite(tipoTramite.getDescTipoTramite());
            tipoTramiteDTO.setDescWebTipoTramite(tipoTramite.getDescWebTipoTramite());
            tipoTramiteDTO.setFechaHoraBajaTipoTramite(tipoTramite.getFechaHoraBajaTipoTramite());
            tipoTramiteDTO.setMaxDiasParaDocumentacion(tipoTramite.getMaxDiasParaDocumentacion());
            tipoTramiteDTO.setCategoria(tipoTramite.getCategoria());
            tipoTramiteDTO.setCategoriaCod(tipoTramite.getCategoriaCod()); // Probar
            tipoTramiteDTO.setTipoDocumentacionList(tipoTramite.getTipoDocumentacionList()); // Para agregar un TipoDoc al TipoTramite
            tipoTramitesResultado.add(tipoTramiteDTO);
        }
        return tipoTramitesResultado;
    }

    public void agregarTipoTramite(NuevoTipoTramiteDTO nuevoTipoTramiteDTO) throws TipoTramiteException {
        // Para depurar
        System.out.println("Intentando agregar TipoTramite con cod: " + nuevoTipoTramiteDTO.getCodTipoTramite());

        FachadaPersistencia.getInstance().iniciarTransaccion();

        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();

        dto.setAtributo("codTipoTramite");
        dto.setOperacion("=");
        dto.setValor(nuevoTipoTramiteDTO.getCodTipoTramite());

        criterioList.add(dto);

        List lTipoTramite = FachadaPersistencia.getInstance().buscar("TipoTramite", criterioList);

        criterioList.clear();

        if (lTipoTramite.size() > 0) {
            System.out.println("Aca me quedo");
            throw new TipoTramiteException("El cod del Tipo Tramite ya existe");
        } else {
            TipoTramite tipoTramite = new TipoTramite();
            tipoTramite.setTipoDocumentacionList(nuevoTipoTramiteDTO.getTipoDocumentacionList()); // Para agregar un TipoDoc al TipoTramite
            tipoTramite.setCategoria(nuevoTipoTramiteDTO.getCategoria());
            tipoTramite.setCodTipoTramite(nuevoTipoTramiteDTO.getCodTipoTramite());
            tipoTramite.setDescTipoTramite(nuevoTipoTramiteDTO.getDescTipoTramite());
            tipoTramite.setDescWebTipoTramite(nuevoTipoTramiteDTO.getDescWebTipoTramite());
            tipoTramite.setMaxDiasParaDocumentacion(nuevoTipoTramiteDTO.getMaxDiasParaDocumentacion());
            tipoTramite.setNombreTipoTramite(nuevoTipoTramiteDTO.getNombreTipoTramite());

            FachadaPersistencia.getInstance().guardar(tipoTramite);
            FachadaPersistencia.getInstance().finalizarTransaccion();
        }
    }

    public ModificarTipoTramiteDTO buscarTipoTramiteAModificar(int codTipoTramite) {
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();

        dto.setAtributo("codTipoTramite");
        dto.setOperacion("=");
        dto.setValor(codTipoTramite);

        criterioList.add(dto);

        TipoTramite tipoTramiteEncontrado = (TipoTramite) FachadaPersistencia.getInstance().buscar("TipoTramite", criterioList).get(0);

        ModificarTipoTramiteDTO modificarTipoTramiteDTO = new ModificarTipoTramiteDTO();
        modificarTipoTramiteDTO.setCodTipoTramite(tipoTramiteEncontrado.getCodTipoTramite());
        modificarTipoTramiteDTO.setDescTipoTramite(tipoTramiteEncontrado.getDescTipoTramite());
        modificarTipoTramiteDTO.setDescWebTipoTramite(tipoTramiteEncontrado.getDescWebTipoTramite());
        modificarTipoTramiteDTO.setMaxDiasParaDocumentacion(tipoTramiteEncontrado.getMaxDiasParaDocumentacion());
        modificarTipoTramiteDTO.setNombreTipoTramite(tipoTramiteEncontrado.getNombreTipoTramite());
        modificarTipoTramiteDTO.setTipoDocumentacionList(tipoTramiteEncontrado.getTipoDocumentacionList());
        modificarTipoTramiteDTO.setCategoria(tipoTramiteEncontrado.getCategoria());
        modificarTipoTramiteDTO.setCategoriaCod(tipoTramiteEncontrado.getCategoriaCod());

        return modificarTipoTramiteDTO;
    }

    public void modificarTipoTramite(ModificarTipoTramiteDTOIn modificarTipoTramiteDTOIn) {
        FachadaPersistencia.getInstance().iniciarTransaccion();

        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();

        dto.setAtributo("codTipoTramite");
        dto.setOperacion("=");
        dto.setValor(modificarTipoTramiteDTOIn.getCodTipoTramite());

        criterioList.add(dto);

        TipoTramite tipoTramiteEncontrado = (TipoTramite) FachadaPersistencia.getInstance().buscar("TipoTramite", criterioList).get(0);

        tipoTramiteEncontrado.setCategoria(modificarTipoTramiteDTOIn.getCategoria());
        tipoTramiteEncontrado.setCategoriaCod(modificarTipoTramiteDTOIn.getCategoriaCod());
        tipoTramiteEncontrado.setCodTipoTramite(modificarTipoTramiteDTOIn.getCodTipoTramite());
        tipoTramiteEncontrado.setDescTipoTramite(modificarTipoTramiteDTOIn.getDescTipoTramite());
        tipoTramiteEncontrado.setDescWebTipoTramite(modificarTipoTramiteDTOIn.getDescWebTipoTramite());
        tipoTramiteEncontrado.setMaxDiasParaDocumentacion(modificarTipoTramiteDTOIn.getMaxDiasParaDocumentacion());
        tipoTramiteEncontrado.setNombreTipoTramite(modificarTipoTramiteDTOIn.getNombreTipoTramite());
        tipoTramiteEncontrado.setTipoDocumentacionList(new ArrayList<>(modificarTipoTramiteDTOIn.getTipoDocumentacionList())); // Para reemplazar la lista de TD anterior

        FachadaPersistencia.getInstance().guardar(tipoTramiteEncontrado);
        FachadaPersistencia.getInstance().finalizarTransaccion();
    }

    public void darDeBajaTipoTramite(int codTipoTramite) throws TipoTramiteException {
        try {
            FachadaPersistencia.getInstance().iniciarTransaccion();

            // Criterio para buscar TipoTramite por código
            List<DTOCriterio> criterioList = new ArrayList<>();
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("codTipoTramite");
            dto.setOperacion("=");
            dto.setValor(codTipoTramite);
            criterioList.add(dto);

            TipoTramite tipoTramiteEncontrado = (TipoTramite) FachadaPersistencia.getInstance().buscar("TipoTramite", criterioList).get(0);

            // Buscar trámites que tienen este TipoTramite
            List<DTOCriterio> criterioTramiteList = new ArrayList<>();
            DTOCriterio tramiteCriterio = new DTOCriterio();
            tramiteCriterio.setAtributo("tipoTramite");
            tramiteCriterio.setOperacion("=");
            tramiteCriterio.setValor(tipoTramiteEncontrado);
            criterioTramiteList.add(tramiteCriterio);

            List<Tramite> tramitesAsociados = (List<Tramite>) (List<?>) FachadaPersistencia.getInstance().buscar("Tramite", criterioTramiteList);

            // Verificar si alguno de los trámites asociados está en estado "Activo"
            for (Tramite tramite : tramitesAsociados) {
                if (tramite.getEstadoTramite() != null && "Activo".equalsIgnoreCase(tramite.getEstadoTramite().getnombreEstadoTramite())) {
                    throw new TipoTramiteException("No se puede dar de baja el TipoTramite porque está asociado a un trámite con estado 'Activo'.");
                }
            }

            tipoTramiteEncontrado.setFechaHoraBajaTipoTramite(new Timestamp(System.currentTimeMillis()));
            FachadaPersistencia.getInstance().guardar(tipoTramiteEncontrado);

            HibernateUtil.getSession().flush();
            FachadaPersistencia.getInstance().finalizarTransaccion();
        } catch (TipoTramiteException e) {
            FachadaPersistencia.getInstance().rollbackTransaccion();
            throw e;
        } catch (Exception e) {
            FachadaPersistencia.getInstance().rollbackTransaccion();
            throw new TipoTramiteException("Error al dar de baja TipoTramite: " + e.getMessage());
        }
    }

    public void saveSelection(int codTipoTramite, List<TipoDocumentacion> tipoDocumentacionList) throws TipoTramiteException {
        try {
            FachadaPersistencia.getInstance().iniciarTransaccion();

            // Criterio para buscar TipoTramite por código
            List<DTOCriterio> criterioList = new ArrayList<>();
            DTOCriterio dto = new DTOCriterio();
            dto.setAtributo("codTipoTramite");
            dto.setOperacion("=");
            dto.setValor(codTipoTramite);
            criterioList.add(dto);

            // Buscar el TipoTramite correspondiente
            TipoTramite tipoTramiteEncontrado = (TipoTramite) FachadaPersistencia.getInstance().buscar("TipoTramite", criterioList).get(0);

            // Actualizar la lista de TipoDocumentacion
            tipoTramiteEncontrado.setTipoDocumentacionList(new ArrayList<>(tipoDocumentacionList));

            // Guardar los cambios
            FachadaPersistencia.getInstance().guardar(tipoTramiteEncontrado);
            FachadaPersistencia.getInstance().finalizarTransaccion();
        } catch (Exception e) {
            FachadaPersistencia.getInstance().rollbackTransaccion();
            throw new TipoTramiteException("Error al guardar la selección de TipoDocumentacion: " + e.getMessage());
        }
    }
}

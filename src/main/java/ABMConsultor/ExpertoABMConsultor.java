
package ABMConsultor;

import ABMConsultor.dtos.DTOConsultor;
import ABMConsultor.dtos.DTOConsultorFiltrado;
import ABMConsultor.dtos.DTOConsultorModificar;
import ABMConsultor.dtos.DTOConsultorModificarIn;
import ABMConsultor.exceptions.ConsultorException;
import entidades.Consultor;
import entidades.Usuario;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;
import utils.DTOCriterio;
import utils.FachadaPersistencia;


public class ExpertoABMConsultor {
    public List<DTOConsultorFiltrado> buscarConsultores(int nroLegajoConsultor,String nombreApellidoConsultor){
        List<DTOCriterio> lCriterio=new ArrayList<DTOCriterio>();
        if(nroLegajoConsultor>0)
        {
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("nroLegajoConsultor");
            unCriterio.setOperacion("=");
            unCriterio.setValor(nroLegajoConsultor);
            lCriterio.add(unCriterio);
        }
        
        if(nombreApellidoConsultor.trim().length()>0)
        {
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("nombreApellidoConsultor");
            unCriterio.setOperacion("like");
            unCriterio.setValor(nombreApellidoConsultor);
            lCriterio.add(unCriterio);
        }
        List objetoList = FachadaPersistencia.getInstance().buscar("Consultor", lCriterio);
        List<DTOConsultorFiltrado> consultoresResultado = new ArrayList<>();
        for (Object x : objetoList) {
            Consultor consultor = (Consultor) x;
            DTOConsultorFiltrado dtoConsultorFiltrado = new DTOConsultorFiltrado();
            dtoConsultorFiltrado.setnroLegajoConsultor(consultor.getnroLegajoConsultor());
            dtoConsultorFiltrado.setnombreApellidoConsultor(consultor.getnombreApellidoConsultor());
            dtoConsultorFiltrado.setcantMaximaTramites(consultor.getcantMaximaTramites());
            dtoConsultorFiltrado.setUsuario(consultor.getUsuario());
            dtoConsultorFiltrado.setfechaHoraBajaConsultor(consultor.getfechaHoraBajaConsultor());
            consultoresResultado.add(dtoConsultorFiltrado);
        }
        return consultoresResultado;
    }
    
    
  public void agregarConsultor(DTOConsultor dtoConsultor) throws ConsultorException {
    FachadaPersistencia.getInstance().iniciarTransaccion();

    List<DTOCriterio> criterioList = new ArrayList<>();
    DTOCriterio dto = new DTOCriterio();

    dto.setAtributo("nroLegajoConsultor");
    dto.setOperacion("=");
    dto.setValor(dtoConsultor.getnroLegajoConsultor());
    criterioList.add(dto);

    List lConsultor = FachadaPersistencia.getInstance().buscar("Consultor", criterioList);

    criterioList.clear();

    DTOCriterio dto1 = new DTOCriterio();
    dto1.setAtributo("codUsuario");
    dto1.setOperacion("=");
    dto1.setValor(dtoConsultor.getCodUsuario());
    criterioList.add(dto1);

    List lUsuario = FachadaPersistencia.getInstance().buscar("Usuario", criterioList);

    if (lConsultor.size() > 0) {
        throw new ConsultorException("El nro de legajo ya existe");
    } 
    else if (lUsuario.size() > 0) {
        throw new ConsultorException("El codigo de Usuario ya existe");
    } 
    else {
        String cantMaximaTramitesStr = String.valueOf(dtoConsultor.getcantMaximaTramites());
        if (!cantMaximaTramitesStr.matches("^[1-9]\\d*$")) {
            throw new ConsultorException("El valor de cantMaximaTramites debe ser un número entero positivo.");
        }

        if (dtoConsultor.getCodUsuario() <= 0) {
            throw new ConsultorException("El codigo de Usuario debe ser un número entero positivo.");
        }

        Usuario usuario = new Usuario();
        usuario.setCodUsuario(dtoConsultor.getCodUsuario());
        usuario.setUsername(dtoConsultor.getUsername());
        usuario.setPassword(dtoConsultor.getPassword());

        FachadaPersistencia.getInstance().guardar(usuario);

        Consultor consultor = new Consultor();
        consultor.setnroLegajoConsultor(dtoConsultor.getnroLegajoConsultor());
        consultor.setnombreApellidoConsultor(dtoConsultor.getnombreApellidoConsultor());
        consultor.setcantMaximaTramites(dtoConsultor.getcantMaximaTramites());
        consultor.setUsuario(usuario);

        FachadaPersistencia.getInstance().guardar(consultor);

        FachadaPersistencia.getInstance().finalizarTransaccion();
    }
}


    
    
    public DTOConsultorModificar buscarConsultorAModificar(int nroLegajoConsultor){
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();

        dto.setAtributo("nroLegajoConsultor");
        dto.setOperacion("=");
        dto.setValor(nroLegajoConsultor);

        criterioList.add(dto);

        Consultor consultorEncontrado = (Consultor) FachadaPersistencia.getInstance().buscar("Consultor", criterioList).get(0);
        
        List<DTOCriterio> criterioList2 = new ArrayList<>();
        
        DTOCriterio dto1 = new DTOCriterio();

        dto1.setAtributo("Consultor");
        dto1.setOperacion("=");
        dto1.setValor(consultorEncontrado);
        
        Usuario usuarioEncontrado = (Usuario) FachadaPersistencia.getInstance().buscar("Usuario", criterioList2).get(0);
        
        DTOConsultorModificar dtoConsultorModificar = new DTOConsultorModificar();
        dtoConsultorModificar.setnombreApellidoConsultor(consultorEncontrado.getnombreApellidoConsultor());
        dtoConsultorModificar.setnroLegajoConsultor(consultorEncontrado.getnroLegajoConsultor());
        dtoConsultorModificar.setcantMaximaTramites(consultorEncontrado.getcantMaximaTramites());
        dtoConsultorModificar.setCodUsuario(usuarioEncontrado.getCodUsuario());
        dtoConsultorModificar.setUsername(usuarioEncontrado.getUsername());
        dtoConsultorModificar.setPassword(usuarioEncontrado.getPassword());
        
        return dtoConsultorModificar;
    }
    
 public void modificarConsultor(DTOConsultorModificarIn dtoConsultorModificarIn) throws ConsultorException {
    FachadaPersistencia.getInstance().iniciarTransaccion();

    List<DTOCriterio> criterioList = new ArrayList<>();
    DTOCriterio dto = new DTOCriterio();
    dto.setAtributo("nroLegajoConsultor");
    dto.setOperacion("=");
    dto.setValor(dtoConsultorModificarIn.getnroLegajoConsultor());
    criterioList.add(dto);

    Consultor consultorEncontrado = (Consultor) FachadaPersistencia.getInstance().buscar("Consultor", criterioList).get(0);

    List<DTOCriterio> criterioList1 = new ArrayList<>();
    DTOCriterio dto2 = new DTOCriterio();
    dto2.setAtributo("nombreApellidoConsultor");
    dto2.setOperacion("=");
    dto2.setValor(dtoConsultorModificarIn.getnombreApellidoConsultor());
    criterioList1.add(dto2);

    DTOCriterio dto3 = new DTOCriterio();
    dto3.setAtributo("nroLegajoConsultor");
    dto3.setOperacion("<>");
    dto3.setValor(dtoConsultorModificarIn.getnroLegajoConsultor());
    criterioList1.add(dto3);

    List<Object> consultornEncontrado = FachadaPersistencia.getInstance().buscar("Consultor", criterioList1);
    if (consultornEncontrado.size() > 0) {
        throw new ConsultorException("Ya existe un consultor con el mismo nombre y apellido");
    }

    List<DTOCriterio> criterioListTramites = new ArrayList<>();
    DTOCriterio dtoTramite = new DTOCriterio();
    dtoTramite.setAtributo("consultor");
    dtoTramite.setOperacion("=");
    dtoTramite.setValor(consultorEncontrado);
    criterioListTramites.add(dtoTramite);

    List<Object> tramitesAsignados = FachadaPersistencia.getInstance().buscar("Tramite", criterioListTramites);
    int cantidadTramitesAsignados = tramitesAsignados.size();
    String cantMaximaTramitesStr = String.valueOf(dtoConsultorModificarIn.getcantMaximaTramites());
    if (!cantMaximaTramitesStr.matches("^[1-9]\\d*$")) {
        throw new ConsultorException("El valor de cantMaximaTramites debe ser un número entero positivo.");
    }

    if (dtoConsultorModificarIn.getcantMaximaTramites() < cantidadTramitesAsignados) {
        throw new ConsultorException("El valor de cantMaximaTramites no puede ser inferior al número de Tramites asignados (" + cantidadTramitesAsignados + ")");
    }

    List<DTOCriterio> criterioList2 = new ArrayList<>();
    DTOCriterio dto1 = new DTOCriterio();
    dto1.setAtributo("Consultor");
    dto1.setOperacion("=");
    dto1.setValor(consultorEncontrado);
    criterioList2.add(dto1);
    Usuario usuarioEncontrado = (Usuario) FachadaPersistencia.getInstance().buscar("Usuario", criterioList2).get(0);
    consultorEncontrado.setnroLegajoConsultor(dtoConsultorModificarIn.getnroLegajoConsultor());
    consultorEncontrado.setnombreApellidoConsultor(dtoConsultorModificarIn.getnombreApellidoConsultor());
    consultorEncontrado.setcantMaximaTramites(dtoConsultorModificarIn.getcantMaximaTramites());
    usuarioEncontrado.setCodUsuario(dtoConsultorModificarIn.getCodUsuario());
    usuarioEncontrado.setUsername(dtoConsultorModificarIn.getUsername());
    usuarioEncontrado.setPassword(dtoConsultorModificarIn.getPassword());
    FachadaPersistencia.getInstance().guardar(consultorEncontrado);
    FachadaPersistencia.getInstance().finalizarTransaccion();
}


    
    public void darDeBajaConsultor(int nroLegajoConsultor) throws ConsultorException {
        FachadaPersistencia.getInstance().iniciarTransaccion();

        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();

        dto.setAtributo("nroLegajoConsultor");
        dto.setOperacion("=");
        dto.setValor(nroLegajoConsultor);

        criterioList.add(dto);

        Consultor consultorEncontrado = (Consultor) FachadaPersistencia.getInstance().buscar("Consultor", criterioList).get(0);

        criterioList.clear();
        dto = new DTOCriterio();

        dto.setAtributo("consultor");
        dto.setOperacion("=");
        dto.setValor(consultorEncontrado);

        criterioList.add(dto);

        DTOCriterio dto2 = new DTOCriterio();

        dto2.setAtributo("fechaHoraFinTramiteReal");
        dto2.setOperacion("=");
        dto2.setValor(null);

        criterioList.add(dto2);

        List objetoList = FachadaPersistencia.getInstance().buscar("Tramite", criterioList);

        if (objetoList.size() != 0) {
            throw new ConsultorException("Consultor no puede darse de baja por estar asignado en al menos un Tramite");
        }

        consultorEncontrado.setfechaHoraBajaConsultor(new Timestamp(System.currentTimeMillis()));

        FachadaPersistencia.getInstance().guardar(consultorEncontrado);
        FachadaPersistencia.getInstance().finalizarTransaccion();
    } 
}


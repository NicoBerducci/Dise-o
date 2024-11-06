
package ABMConsultor;

import ABMConsultor.dtos.DTOConsultor;
import ABMConsultor.dtos.DTOConsultorFiltrado;
import ABMConsultor.dtos.DTOConsultorModificar;
import ABMConsultor.dtos.DTOConsultorModificarIn;
import ABMConsultor.exceptions.ConsultorException;

import java.util.List;

public class ControladorABMConsultor {
    private ExpertoABMConsultor expertoABMConsultor = new ExpertoABMConsultor();
    public List<DTOConsultorFiltrado> buscarConsultores(int nroLegajoConsultor, String nombreApellidoConsultor){
        return expertoABMConsultor.buscarConsultores(nroLegajoConsultor,nombreApellidoConsultor);
    }

    public void agregarConsultor(DTOConsultor dtoConsultor) throws ConsultorException{
        expertoABMConsultor.agregarConsultor(dtoConsultor);
    }

    public void modificarConsultor(DTOConsultorModificarIn dtoConsultorModificarIn) throws ConsultorException{
        expertoABMConsultor.modificarConsultor(dtoConsultorModificarIn);
    }

    public DTOConsultorModificar buscarConsultorAModificar(int nroLegajoConsultor){
        return expertoABMConsultor.buscarConsultorAModificar(nroLegajoConsultor);
    }

    public void darDeBajaConsultor(int nroLegajoConsultor) throws ConsultorException {
        expertoABMConsultor.darDeBajaConsultor(nroLegajoConsultor);
    }
}

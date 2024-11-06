
package ABMConsultor.beans;

import ABMConsultor.dtos.DTOConsultorFiltrado;
import ABMConsultor.ControladorABMConsultor;
import ABMConsultor.exceptions.ConsultorException;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.omnifaces.util.Messages;
import utils.BeansUtils;

@Named("uiabmConsultorLista")
@ViewScoped

public class IUABMConsultorLista implements Serializable {
    
    private ControladorABMConsultor controladorABMConsultor = new ControladorABMConsultor();
    private int nroLegajoConsultorFiltro=0;
    private String nombreApellidoConsultorFiltro="";
    
    public ControladorABMConsultor getControladorABMConsultor() {
        return controladorABMConsultor;
    }

    public void setControladorABMConsultor(ControladorABMConsultor controladorABMConsultor) {
        this.controladorABMConsultor = controladorABMConsultor;
    }
     public int getnroLegajoConsultorFiltro() {
        return nroLegajoConsultorFiltro;
    }

    public void setnroLegajoConsultorFiltro(int nroLegajoConsultorFiltro) {
        this.nroLegajoConsultorFiltro = nroLegajoConsultorFiltro;
    }

    public String getnombreApellidoConsultorFiltro() {
        return nombreApellidoConsultorFiltro;
    }

    public void setnombreApellidoConsultorFiltro(String nombreApellidoConsultorFiltro) {
        this.nombreApellidoConsultorFiltro = nombreApellidoConsultorFiltro;
    }

    public void filtrar()
    {

    }
       public List<ConsultorGrillaUI> buscarConsultores(){
        System.out.println(nroLegajoConsultorFiltro);
        System.out.println(nombreApellidoConsultorFiltro);
        List<ConsultorGrillaUI> consultoresGrilla = new ArrayList<>();
        List<DTOConsultorFiltrado> dtoConsultoresFiltrados = controladorABMConsultor.buscarConsultores(nroLegajoConsultorFiltro,nombreApellidoConsultorFiltro);
        for (DTOConsultorFiltrado dtoConsultorFiltrado : dtoConsultoresFiltrados) {
            ConsultorGrillaUI consultorGrillaUI = new ConsultorGrillaUI();
            consultorGrillaUI.setnroLegajoConsultor(dtoConsultorFiltrado.getnroLegajoConsultor());
            consultorGrillaUI.setnombreApellidoConsultor(dtoConsultorFiltrado.getnombreApellidoConsultor());
            consultorGrillaUI.setcantMaximaTramites(dtoConsultorFiltrado.getcantMaximaTramites());
            consultorGrillaUI.setfechaHoraBajaConsultor(dtoConsultorFiltrado.getfechaHoraBajaConsultor());
            consultorGrillaUI.setUsername(dtoConsultorFiltrado.getUsuario().getUsername());
            consultoresGrilla.add(consultorGrillaUI);
        }
        return consultoresGrilla;
    }


    public String irAgregarConsultor() {
        BeansUtils.guardarUrlAnterior();
        return "abmConsultor?faces-redirect=true&nroLegajoConsultor=0"; // Usa '?faces-redirect=true' para hacer una redirección
    }

    
    public String irModificarConsultor(int nroLegajoConsultor) {
        BeansUtils.guardarUrlAnterior();
        return "abmConsultor?faces-redirect=true&nroLegajoConsultor=" + nroLegajoConsultor; // Usa '?faces-redirect=true' para hacer una redirección
    }

    public void darDeBajaConsultor(int nroLegajoConsultor){
        try {
            controladorABMConsultor.darDeBajaConsultor(nroLegajoConsultor);
            
                    
        } catch (ConsultorException e) {
            Messages.create("Error!").error().detail("Consultor no puede darse de baja por estar asignado en al menos un Tramite").add();
        }
    }      
}



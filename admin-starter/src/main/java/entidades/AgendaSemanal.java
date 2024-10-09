package entidades;

import java.util.Date;
import java.util.List;


public class AgendaSemanal extends Entidad{
    
    
    private Date añoAgendaSemanal;
    private Date fechaDesdeAgendaSemanal;
    private Date fechaHastaAgendaSemanal;
    private int nroSemanaAgendaSemanal;
    private List<Consultor> consultorList;
    
    public AgendaSemanal(){
    
}
    public Date getañoAgendaSemanal(){
        return añoAgendaSemanal;
}
    
    public void setañoAgendaSemanal(Date añoAgendaSemanal){
        this.añoAgendaSemanal = añoAgendaSemanal;
    }
    
    public Date getfechaDesdeAgendaSemanal(){
        return fechaDesdeAgendaSemanal;
    }
    
    public void setfechaDesdeAgendaSemanal(Date fechaDesdeAgendaSemanal){
        this.fechaDesdeAgendaSemanal = fechaDesdeAgendaSemanal;
    }
    
    public Date getfechaHastaAgendaSemanal(){
        return fechaHastaAgendaSemanal;
    }
    
    public void setfechaHastaAgendaSemanal(Date fechaHastaAgendaSemanal){
        this.fechaHastaAgendaSemanal = fechaHastaAgendaSemanal;
    }
    
    public int getnroSemanaAgendaSemanal(){
        return nroSemanaAgendaSemanal;
    }
    
    public void setnroSemanaAgendaSemanal(int nroSemanaAgendaSemanal){
        this.nroSemanaAgendaSemanal = nroSemanaAgendaSemanal;
    }
    
    public List<Consultor> getConsultorList(){
        return consultorList;
    }
    
    public void setConsultorList(List<Consultor> consultorList){
        this.consultorList = consultorList;
    }
    
}

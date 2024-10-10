package entidades;

import java.util.Date;

public class EstadoTramite extends Entidad {

    private int codEstadoTramite;
    private String nombreEstadoTramite;
    private String descripcionEstadoTramite;
    private Date fechaBajaEstadoTramite;

    public EstadoTramite() {
    }

    public int getcodEstadoTramite() {
        return codEstadoTramite;
    }

    public void setcodEstadoTramite(int codEstadoTramite) {
        this.codEstadoTramite = codEstadoTramite;
    }

    public String getnombreEstadoTramite() {
        return nombreEstadoTramite;
    }

    public void setnombreEstadoTramite(String nombreEstadoTramite) {
        this.nombreEstadoTramite = nombreEstadoTramite;
    }

    public String getdescripcionEstadoTramite() {
        return descripcionEstadoTramite;
    }

    public void setdescripcionEstadoTramite(String descripcionEstadoTramite) {
        this.descripcionEstadoTramite = descripcionEstadoTramite;
    }

    public Date getfechaBajaEstadoTramite() {
        return fechaBajaEstadoTramite;
    }

    public void setfechaBajaEstadoTramite(Date fechaBajaEstadoTramite) {
        this.fechaBajaEstadoTramite = fechaBajaEstadoTramite;
    }
}

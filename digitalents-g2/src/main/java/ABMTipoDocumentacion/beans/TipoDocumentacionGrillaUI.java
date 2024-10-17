/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ABMTipoDocumentacion.beans;

import java.sql.Timestamp;

public class TipoDocumentacionGrillaUI {
    
    private int codTipoDocumentacion;
    private String descTipoDocumentacion;
    private Timestamp fechaHoraBajaTD;
    private String nombreTipoDocumentacion;

    public int getCodTipoDocumentacion() {
        return codTipoDocumentacion;
    }

    public void setCodTipoDocumentacion(int codTipoDocumentacion) {
        this.codTipoDocumentacion = codTipoDocumentacion;
    }

    public String getDescTipoDocumentacion() {
        return descTipoDocumentacion;
    }

    public void setDescTipoDocumentacion(String descTipoDocumentacion) {
        this.descTipoDocumentacion = descTipoDocumentacion;
    }

    public Timestamp getFechaHoraBajaTD() {
        return fechaHoraBajaTD;
    }

    public void setFechaHoraBajaTD(Timestamp fechaHoraBajaTD) {
        this.fechaHoraBajaTD = fechaHoraBajaTD;
    }

    public String getNombreTipoDocumentacion() {
        return nombreTipoDocumentacion;
    }

    public void setNombreTipoDocumentacion(String nombreTipoDocumentacion) {
        this.nombreTipoDocumentacion = nombreTipoDocumentacion;
    }

}

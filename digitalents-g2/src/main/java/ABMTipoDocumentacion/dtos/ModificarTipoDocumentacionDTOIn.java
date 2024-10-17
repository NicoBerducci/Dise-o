/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ABMTipoDocumentacion.dtos;


public class ModificarTipoDocumentacionDTOIn {
    
    private int codTipoDocumentacion;
    private String descTipoDocumentacion;
    private String nombreTipoDocumentacion;


    public int getCodTipoDocumentacion() {
        return codTipoDocumentacion;
    }

    public void setCodTipoDocumentacion(int codTipoDocumentacion) {
        this.codTipoDocumentacion = codTipoDocumentacion;
    }

    public String getNombreTipoDocumentacion() {
        return nombreTipoDocumentacion;
    }

    public void setNombreTipoDocumentacion(String nombreTipoDocumentacion) {
        this.nombreTipoDocumentacion = nombreTipoDocumentacion;
    }

     public String getDescTipoDocumentacion() {
        return descTipoDocumentacion;
    }

    public void setDescTipoDocumentacion(String descTipoDocumentacion) {
        this.descTipoDocumentacion = descTipoDocumentacion;
    }

}

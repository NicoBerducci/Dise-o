/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ABMCategoria.beans;

import java.sql.Timestamp;

public class CategoriaGrillaUI {
    private int codCategoria;
    private String nombreCategoria;
    private String descCategoria;
    private String descWebCategoria;
    private Timestamp fechaHoraBajaCategoria;

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

     public String getdescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

     public String getDescWebCategoria() {
        return descWebCategoria;
    }

    public void setDescWebCategoria(String descWebCategoria) {
        this.descWebCategoria = descWebCategoria;
    }

    public Timestamp getFechaHoraBajaCategoria() {
        return fechaHoraBajaCategoria;
    }

    public void setFechaHoraBajaCategoria(Timestamp fechaHoraBajaCategoria) {
        this.fechaHoraBajaCategoria = fechaHoraBajaCategoria;
    }
}

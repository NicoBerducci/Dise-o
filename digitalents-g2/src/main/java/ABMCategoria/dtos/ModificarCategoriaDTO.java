/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ABMCategoria.dtos;

public class ModificarCategoriaDTO {
    private int codCategoria;
    private String nombreCategoria;
    private String descCategoria;
    private String descWebCategoria;



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

     public String getDescCategoria() {
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
}
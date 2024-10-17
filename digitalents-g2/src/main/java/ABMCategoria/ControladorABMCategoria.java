/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ABMCategoria;

import ABMCategoria.dtos.CategoriaDTO;
import ABMCategoria.dtos.ModificarCategoriaDTO;
import ABMCategoria.dtos.ModificarCategoriaDTOIn;
import ABMCategoria.dtos.NuevoCategoriaDTO;
import ABMCategoria.exceptions.CategoriaException;

import java.util.List;

public class ControladorABMCategoria {
    private ExpertoABMCategoria expertoABMCategoria = new ExpertoABMCategoria();
    public List<CategoriaDTO> buscarCategorias(int codCategoria, String nombreCategoria){
        return expertoABMCategoria.buscarCategorias(codCategoria,nombreCategoria);
    }

    public void agregarCategoria(NuevoCategoriaDTO nuevoCategoriaDTO) throws CategoriaException{
        expertoABMCategoria.agregarCategoria(nuevoCategoriaDTO);
    }

    public void modificarCategoria(ModificarCategoriaDTOIn modificarCategoriaDTOIn){
        expertoABMCategoria.modificarCategoria(modificarCategoriaDTOIn);
    }

    public ModificarCategoriaDTO buscarCategoriaAModificar(int codCategoria){
        return expertoABMCategoria.buscarCategoriaAModificar(codCategoria);
    }

    public void darDeBajaCategoria(int codCategoria) throws CategoriaException {
        expertoABMCategoria.darDeBajaCategoria(codCategoria);
    }
    
}
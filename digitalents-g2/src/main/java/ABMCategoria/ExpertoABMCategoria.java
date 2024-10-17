/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ABMCategoria;

import ABMCategoria.dtos.CategoriaDTO;
import ABMCategoria.dtos.ModificarCategoriaDTO;
import ABMCategoria.dtos.ModificarCategoriaDTOIn;
import ABMCategoria.dtos.NuevoCategoriaDTO;
import entidades.Categoria;
import ABMCategoria.exceptions.CategoriaException;
import utils.DTOCriterio;
import utils.FachadaPersistencia;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ExpertoABMCategoria {
    public List<CategoriaDTO> buscarCategorias(int codCategoria,String nombreCategoria){
        List<DTOCriterio> lCriterio=new ArrayList<DTOCriterio>();
        if(codCategoria>0)
        {
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("codCategoria");
            unCriterio.setOperacion("=");
            unCriterio.setValor(codCategoria);
            lCriterio.add(unCriterio);
        }
        if(nombreCategoria.trim().length()>0)
        {
            DTOCriterio unCriterio=new DTOCriterio();
            unCriterio.setAtributo("nombreCategoria");
            unCriterio.setOperacion("like");
            unCriterio.setValor(nombreCategoria);
            lCriterio.add(unCriterio);
        }
        List objetoList = FachadaPersistencia.getInstance().buscar("Categoria", lCriterio);
        List<CategoriaDTO> categoriasResultado = new ArrayList<>();
        for (Object x : objetoList) {
            Categoria categoria = (Categoria) x;
            CategoriaDTO categoriaDTO = new CategoriaDTO();
            categoriaDTO.setCodCategoria(categoria.getCodCategoria());
            categoriaDTO.setNombreCategoria(categoria.getNombreCategoria());
            categoriaDTO.setFechaHoraBajaCategoria(categoria.getFechaHoraBajaCategoria());
            categoriaDTO.setDescCategoria(categoria.getDescCategoria());
            categoriaDTO.setDescWebCategoria(categoria.getDescWebCategoria());
            categoriasResultado.add(categoriaDTO);
        }
        return categoriasResultado;
    }

    public void agregarCategoria(NuevoCategoriaDTO nuevoCategoriaDTO) throws CategoriaException{
        FachadaPersistencia.getInstance().iniciarTransaccion();
        

        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();

        dto.setAtributo("codCategoria");
        dto.setOperacion("=");
        dto.setValor(nuevoCategoriaDTO.getCodCategoria());

        criterioList.add(dto);
        List lCategoria=FachadaPersistencia.getInstance().buscar("Categoria", criterioList);

        if(lCategoria.size()> 0)
        {
                throw new CategoriaException("El CodCategoria de Categoria ya existe");
        }
        else
        {
        Categoria categoria = new Categoria();
            categoria.setCodCategoria(nuevoCategoriaDTO.getCodCategoria());
            categoria.setNombreCategoria(nuevoCategoriaDTO.getNombreCategoria());
            categoria.setDescCategoria(nuevoCategoriaDTO.getDescCategoria());
            categoria.setDescWebCategoria(nuevoCategoriaDTO.getDescWebCategoria());

        FachadaPersistencia.getInstance().guardar(categoria);
        FachadaPersistencia.getInstance().finalizarTransaccion();
        }
    }

    public ModificarCategoriaDTO buscarCategoriaAModificar(int codCategoria){
        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();

        dto.setAtributo("codCategoria");
        dto.setOperacion("=");
        dto.setValor(codCategoria);

        criterioList.add(dto);

        Categoria categoriaEncontrado = (Categoria) FachadaPersistencia.getInstance().buscar("Categoria", criterioList).get(0);

        ModificarCategoriaDTO modificarCategoriaDTO = new ModificarCategoriaDTO();
        modificarCategoriaDTO.setCodCategoria(categoriaEncontrado.getCodCategoria());
        modificarCategoriaDTO.setNombreCategoria(categoriaEncontrado.getNombreCategoria());
        modificarCategoriaDTO.setDescCategoria(categoriaEncontrado.getDescCategoria());
        modificarCategoriaDTO.setDescWebCategoria(categoriaEncontrado.getDescWebCategoria());
        return modificarCategoriaDTO;
    }

    public void modificarCategoria(ModificarCategoriaDTOIn modificarCategoriaDTOIn){
        FachadaPersistencia.getInstance().iniciarTransaccion();

        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();

        dto.setAtributo("codCategoria");
        dto.setOperacion("=");
        dto.setValor(modificarCategoriaDTOIn.getCodCategoria());

        criterioList.add(dto);

        Categoria categoriaEncontrado = (Categoria) FachadaPersistencia.getInstance().buscar("Categoria", criterioList).get(0);


        categoriaEncontrado.setCodCategoria(modificarCategoriaDTOIn.getCodCategoria());
        categoriaEncontrado.setNombreCategoria(modificarCategoriaDTOIn.getNombreCategoria());
        categoriaEncontrado.setDescCategoria(modificarCategoriaDTOIn.getDescCategoria());
        categoriaEncontrado.setDescWebCategoria(modificarCategoriaDTOIn.getDescWebCategoria());

        FachadaPersistencia.getInstance().guardar(categoriaEncontrado);
        FachadaPersistencia.getInstance().finalizarTransaccion();
    }

    public void darDeBajaCategoria(int codCategoria) throws CategoriaException {
        FachadaPersistencia.getInstance().iniciarTransaccion();

        List<DTOCriterio> criterioList = new ArrayList<>();
        DTOCriterio dto = new DTOCriterio();

        dto.setAtributo("codCategoria");
        dto.setOperacion("=");
        dto.setValor(codCategoria);

        criterioList.add(dto);

        Categoria categoriaEncontrado = (Categoria) FachadaPersistencia.getInstance().buscar("Categoria", criterioList).get(0);

        criterioList.clear();
        dto = new DTOCriterio();

        dto.setAtributo("categoria");
        dto.setOperacion("=");
        dto.setValor(categoriaEncontrado);

        criterioList.add(dto);

        DTOCriterio dto2 = new DTOCriterio();


        dto2.setAtributo("fechaHoraFinTramiteReal");
        dto2.setOperacion("=");
        dto2.setValor(null);

        criterioList.add(dto2);
        
        /*Buscar Tramite*/


        categoriaEncontrado.setFechaHoraBajaCategoria(new Timestamp(System.currentTimeMillis()));

        FachadaPersistencia.getInstance().guardar(categoriaEncontrado);
        FachadaPersistencia.getInstance().finalizarTransaccion();
    }
}
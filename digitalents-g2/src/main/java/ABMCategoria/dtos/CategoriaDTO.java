/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ABMCategoria.dtos;

import entidades.Categoria;
import java.sql.Timestamp;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author valen1234
 */
public class CategoriaDTO {

    private int codCategoria;
    private String descWebCategoria;
    private String descCategoria;
    private Timestamp fechaHoraBajaCategoria;
    private String nombreCategoria;

    public CategoriaDTO() {
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getDescWebCategoria() {
        return descWebCategoria;
    }

    public void setDescWebCategoria(String descWebCategoria) {
        this.descWebCategoria = descWebCategoria;
    }

    public String getDescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

    public Timestamp getFechaHoraBajaCategoria() {
        return fechaHoraBajaCategoria;
    }

    public void setFechaHoraBajaCategoria(Timestamp fechaHoraBajaCategoria) {
        this.fechaHoraBajaCategoria = fechaHoraBajaCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Categoria buscarCategoriaPorCodigo(String oid) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Categoria categoriaoid = null;
        try {
            session.beginTransaction();
            categoriaoid = (Categoria) session.get(Categoria.class, oid);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return categoriaoid;
    }

}

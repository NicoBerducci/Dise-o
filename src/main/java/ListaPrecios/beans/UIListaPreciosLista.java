/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaPrecios.beans;


import ListaPrecios.ControladorListaPrecios;
import ListaPrecios.dtos.DTOConfigCostoTipoTramiteFiltro;
import ListaPrecios.dtos.DTOCostoTipoTramiteExportar;
import ListaPrecios.dtos.DTOCostoTipoTramiteImportar;
import ListaPrecios.exceptions.ListaPreciosException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omnifaces.util.Messages;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;
import utils.BeansUtils;


@Named("uilistaPreciosLista")
@ViewScoped
public class UIListaPreciosLista implements Serializable{
    private UploadedFile file;
    private StreamedContent fileD;
    private List<DTOCostoTipoTramiteExportar> tramiteData = new ArrayList<>();
     private ControladorListaPrecios controladorListaPrecios = new ControladorListaPrecios();
     private Date fechaHastaConfigCostoTipoTramiteFiltro;
     private int nroConfigCostoTipoTramiteFiltro;
       public ControladorListaPrecios getControladorListaPrecios() {
        return controladorListaPrecios;
    }
           // Getters and Setters
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void setFileD(StreamedContent fileD) {
        this.fileD = fileD;
    }

    public List<DTOCostoTipoTramiteExportar> getTramiteData() {
        return tramiteData;
    }

    public void setTramiteData(List<DTOCostoTipoTramiteExportar> tramiteData) {
        this.tramiteData = tramiteData;
    }
    public void setControladorListaPrecios(ControladorListaPrecios controladorListaPrecios) {
        this.controladorListaPrecios = controladorListaPrecios;
    }
    public Date getfechaHastaConfigCostoTipoTramiteFiltro(){
        return fechaHastaConfigCostoTipoTramiteFiltro;
    }
    
    public void setnroConfigCostoTipoTramiteFiltro(int nroConfigCostoTipoTramiteFiltro){
        this.nroConfigCostoTipoTramiteFiltro = nroConfigCostoTipoTramiteFiltro;
    }
    
     public int getnroConfigCostoTipoTramiteFiltro(){
        return nroConfigCostoTipoTramiteFiltro;
    }
    
    public void setfechaHastaConfigCostoTipoTramiteFiltro(Date fechaHastaConfigCostoTipoTramiteFiltro){
        this.fechaHastaConfigCostoTipoTramiteFiltro = fechaHastaConfigCostoTipoTramiteFiltro;
    }
    
    public void setNroConfigCostoTipoTramiteFiltro(int nroConfigCostoTipoTramiteFiltro) {
    this.nroConfigCostoTipoTramiteFiltro = nroConfigCostoTipoTramiteFiltro;
    populateTramiteData();
    }
    
    public void filtrar()
    {

    }
    
    
    public List<ListaPreciosGrillaUI> buscarListas() {
    System.out.println(fechaHastaConfigCostoTipoTramiteFiltro);
    List<ListaPreciosGrillaUI> listasPrecioGrilla = new ArrayList<>();
    
    // Obtén la fecha del DTO
    Date fechaHasta = fechaHastaConfigCostoTipoTramiteFiltro; // Asegúrate de que esta variable sea del tipo Date
    
    List<DTOConfigCostoTipoTramiteFiltro> dtoConfigCostoTipoTramiteFiltrados = 
        controladorListaPrecios.buscarListas(fechaHasta);
    
    for (DTOConfigCostoTipoTramiteFiltro dtoConfigCostoTipoTramiteFiltrado : dtoConfigCostoTipoTramiteFiltrados) {
        ListaPreciosGrillaUI listaPreciosGrillaUI = new ListaPreciosGrillaUI();
        listaPreciosGrillaUI.setfechaHastaConfigCostoTipoTramite(dtoConfigCostoTipoTramiteFiltrado.getfechaHastaConfigCostoTipoTramite());
        listaPreciosGrillaUI.setfechaDesdeConfigCostoTipoTramite(dtoConfigCostoTipoTramiteFiltrado.getfechaDesdeConfigCostoTipoTramite());
        listaPreciosGrillaUI.setnroConfigCostoTipoTramite(dtoConfigCostoTipoTramiteFiltrado.getnroConfigCostoTipoTramite());
        listasPrecioGrilla.add(listaPreciosGrillaUI);
    }
    return listasPrecioGrilla;
    }
    
    public String irAgregarLista() {
    BeansUtils.guardarUrlAnterior();
    return "ListaPrecios?faces-redirect=true&nroConfigCostoTipoTramite=0"; // Usa '?faces-redirect=true' para hacer una redirección
    }

    
    public String irModificarLista(int nroConfigCostoTipoTramite) {
        BeansUtils.guardarUrlAnterior();
        return "ListaPrecios?faces-redirect=true&nroConfigCostoTipoTramite=" + nroConfigCostoTipoTramite; // Usa '?faces-redirect=true' para hacer una redirección
    }
    // This method prepares the data for export
    public void populateTramiteData() {
        tramiteData = controladorListaPrecios.buscarCostosTipoTramite(nroConfigCostoTipoTramiteFiltro);
    }
  
     // Method for exporting Excel
    public StreamedContent getFileD() {
        populateTramiteData(); // Populate the tramiteData before creating the Excel file

        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Tramites");

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("CodTipoTramite");
            headerRow.createCell(1).setCellValue("ImporteCostoTipoTramite");

            // Fill data rows
            int rowIndex = 1;
            for (DTOCostoTipoTramiteExportar tramite : tramiteData) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(tramite.getcodTipoTramite());
                row.createCell(1).setCellValue(tramite.getImporteCostoTipoTramite());
            }

            // Create a temporary file and write to it
            File tempFile = File.createTempFile("tramites_", ".xlsx");
            try (FileOutputStream outputStream = new FileOutputStream(tempFile)) {
                workbook.write(outputStream);
            }
            workbook.close();

            // Prepare the StreamedContent for download
            InputStream stream = new FileInputStream(tempFile);
            fileD = DefaultStreamedContent.builder()
                    .name("tramites.xlsx")
                    .contentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                    .stream(() -> stream)
                    .build();

        } catch (IOException ex) {
            Logger.getLogger(UIListaPreciosLista.class.getName()).log(Level.SEVERE, null, ex);
            Messages.create("Error generating the file: " + ex.getMessage()).error().add();
        }

        return fileD;
    }
    
    public void darDeBajaConfig(int nroConfigCostoTipoTramite){
        try {
            controladorListaPrecios.darDeBajaConfig(nroConfigCostoTipoTramite);
            
                    
        } catch (ListaPreciosException e) {
            Messages.create("Error!").error().detail("Esta lista de precios esta vigente.").add();
        }
    }
     
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaPrecios.beans;

import ListaPrecios.ControladorListaPrecios;
import ListaPrecios.dtos.DTOConfigCostoTipoTramiteExportar;
import ListaPrecios.dtos.DTOConfigCostoTipoTramiteImportar;
import ListaPrecios.exceptions.ListaPreciosException;
import entidades.TipoTramite;
import java.util.Date;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omnifaces.util.Messages;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import ListaPrecios.dtos.DTOCostoTipoTramiteImportar;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import utils.DTOCriterio;
import utils.FachadaPersistencia;


@Named("uiListaPrecios")
@ViewScoped

public class UIListaPrecios implements Serializable{
    
    private ControladorListaPrecios controladorListaPrecios = new ControladorListaPrecios();
        private boolean insert;
        private Date fechaDesdeConfigCostoTipoTramite;
        private Date fechaHastaConfigCostoTipoTramite;
        private int nroConfigCostoTipoTramite;
        private int importeCostoTipoTramite;
        private TipoTramite tipoTramite;  
        private UploadedFile archivoExcel;
        private List<DTOConfigCostoTipoTramiteExportar> configuraciones = new ArrayList<>();
        private UploadedFile file;
        private StreamedContent fileD;
        private List<DTOCostoTipoTramiteImportar> tramiteData = new ArrayList<>();

    public UIListaPrecios () {}
    
    public boolean isInsert() {
        return insert;
    }
    
    public void setInsert(boolean insert) {
        this.insert = insert;
    }
    
      public Date getfechaDesdeConfigCostoTipoTramite(){
        return fechaDesdeConfigCostoTipoTramite;
    }
    
    public void setfechaDesdeConfigCostoTipoTramite(Date fechaDesdeConfigCostoTipoTramite){
        this.fechaDesdeConfigCostoTipoTramite = fechaDesdeConfigCostoTipoTramite;
    }
    
    public Date getfechaHastaConfigCostoTipoTramite(){
        return fechaHastaConfigCostoTipoTramite;
    }
    
    public void setfechaHastaConfigCostoTipoTramite(Date fechaHastaConfigCostoTipoTramite){
        this.fechaHastaConfigCostoTipoTramite = fechaHastaConfigCostoTipoTramite;
    }
    
    public int getnroConfigCostoTipoTramite(){
        return nroConfigCostoTipoTramite;
    }
    
    public void setnroConfigCostoTipoTramite(int nroConfigCostoTipoTramite){
        this.nroConfigCostoTipoTramite = nroConfigCostoTipoTramite;
    }
    
     public int getimporteCostoTipoTramite(){
        return importeCostoTipoTramite;
    }
    
    public void setimporteCostoTipoTramite(int importeCostoTipoTramite){
        this.importeCostoTipoTramite = importeCostoTipoTramite;
    }
    
    public TipoTramite gettipoTramite(){
        return tipoTramite;
    }
    
    public void settipoTramite(TipoTramite tipoTramite){
        this.tipoTramite = tipoTramite;
    }
    
    public UploadedFile getArchivoExcel() {
        return archivoExcel;
    }

    public void setArchivoExcel(UploadedFile archivoExcel) {
        this.archivoExcel = archivoExcel;
    }
    
    // Método para manejar la importación del archivo Excel
   public StreamedContent getFileD() {
        try {
            Workbook libro = new XSSFWorkbook();
            final String nombreArchivo = "./tmp.xlsx";
            Sheet hoja = libro.createSheet("Tramites");

            // Create header row
            Row headerRow = hoja.createRow(0);
            headerRow.createCell(0).setCellValue("CodTipoTramite");
            headerRow.createCell(1).setCellValue("ImporteCostoTipoTramite");
            headerRow.createCell(2).setCellValue("NroConfigCostoTipoTramite");

            // Fill data rows
            int rowIndex = 1;
            for (DTOCostoTipoTramiteImportar tramite : tramiteData) {
                Row row = hoja.createRow(rowIndex++);
                row.createCell(0).setCellValue(tramite.getcodTipoTramite());
                row.createCell(1).setCellValue(tramite.getImporteCostoTipoTramite());
                row.createCell(2).setCellValue(tramite.getnroConfigCostoTipoTramite());
            }

            FileOutputStream outputStream = new FileOutputStream(nombreArchivo);
            libro.write(outputStream);
            libro.close();

            InputStream ie = new FileInputStream(nombreArchivo);
            fileD = DefaultStreamedContent.builder()
                    .name("archivo_tramites.xlsx")
                    .contentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                    .stream(() -> ie)
                    .build();

        } catch (IOException ex) {
            Logger.getLogger(UIListaPrecios.class.getName()).log(Level.SEVERE, null, ex);
            Messages.create(ex.getMessage()).error().add();
        }

        return fileD;
    }

// METODO IMPORTAR EXCEL
public void handleFileUpload(FileUploadEvent event) {
    try (InputStream inp = event.getFile().getInputStream()) {
        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(0);
        int iRow = 1; // Cambia a 0 si quieres leer desde la primera fila

        tramiteData.clear(); // Limpiar la lista antes de importar nuevos datos

        // Leer las filas del archivo Excel
        while (true) {
            Row row = sheet.getRow(iRow);
            if (row == null) break; // Salir si no hay más filas

            DTOCostoTipoTramiteImportar tramite = new DTOCostoTipoTramiteImportar();

            // Leer el código del trámite
            Cell codTipoTramiteCell = row.getCell(0);
            if (codTipoTramiteCell != null && codTipoTramiteCell.getCellType() == CellType.NUMERIC) {
                int codigo = (int) codTipoTramiteCell.getNumericCellValue();
                if (codigo <= 0) {
                    System.out.println("Error: Código de trámite no válido (menor o igual a 0) en la fila " + (iRow + 1));
                    FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: Código de trámite no válido en la fila " + (iRow + 1), null));
                    return; // Detener el proceso si el código es inválido
                } else {
                    tramite.setcodTipoTramite(codigo);
                }
            } else {
                System.out.println("Error: Código de trámite vacío o inválido en la fila " + (iRow + 1));
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: Código de trámite vacío o inválido en la fila " + (iRow + 1), null));
                return; // Detener el proceso si el código es inválido
            }

            // Leer el importe
            Cell importeCell = row.getCell(1);
            if (importeCell != null && importeCell.getCellType() == CellType.NUMERIC) {
                tramite.setImporteCostoTipoTramite((int) importeCell.getNumericCellValue());
            } else {
                tramite.setImporteCostoTipoTramite(0); // Valor por defecto si el importe es inválido
            }

            // Agregar el trámite a la lista sin importar si el importe es válido o no
            tramiteData.add(tramite); 

            iRow++;
        }

        // Comprobar si se han cargado trámites
        if (tramiteData.isEmpty()) {
            throw new ListaPreciosException("No se han cargado trámites válidos desde el archivo Excel.");
        }

        // Verificar si hay tipos de trámite faltantes o dados de baja en la base de datos
        verificarTramitesFaltantes();

    } catch (Exception ex) {
        Logger.getLogger(UIListaPrecios.class.getName()).log(Level.SEVERE, null, ex);
        Messages.create(ex.getMessage()).error().add();
    }
}

// Método para verificar trámites faltantes y dados de baja
private void verificarTramitesFaltantes() throws ListaPreciosException {
    // Obtener todos los tipos de trámite desde la base de datos
    List<?> lTipoTramite = FachadaPersistencia.getInstance().buscar("TipoTramite", new ArrayList<>());

    // Crear conjuntos para códigos de trámites activos y dados de baja
    Set<Integer> codigosTramitesActivos = new HashSet<>();
    Set<Integer> codigosTramitesDadosBaja = new HashSet<>();

    // Clasificar trámites en activos y dados de baja
    for (Object tipoTramiteObj : lTipoTramite) {
        TipoTramite tipoTramite = (TipoTramite) tipoTramiteObj;
        if (tipoTramite.getfechaHoraBajaTipoTramite() == null) {
            codigosTramitesActivos.add(tipoTramite.getcodTipoTramite()); // Agregar a activos
        } else {
            codigosTramitesDadosBaja.add(tipoTramite.getcodTipoTramite()); // Agregar a dados de baja
        }
    }

    // Crear un conjunto con los códigos de trámite importados
    Set<Integer> codigosImportados = tramiteData.stream()
            .map(DTOCostoTipoTramiteImportar::getcodTipoTramite)
            .collect(Collectors.toSet());

    // Verificar si algún trámite activo no fue importado
    for (Integer codigoActivo : codigosTramitesActivos) {
        if (!codigosImportados.contains(codigoActivo)) {
            throw new ListaPreciosException("Falta el tipo de trámite requerido con el código: " + codigoActivo);
        }
    }

    // Verificar si el archivo contiene trámites dados de baja
    for (Integer codigoImportado : codigosImportados) {
        if (codigosTramitesDadosBaja.contains(codigoImportado)) {
            throw new ListaPreciosException("El archivo contiene un tipo de trámite dado de baja con el código: " + codigoImportado);
        }
    }
}


// Método para confirmar la carga de datos y para confirmar Excel
public String confirmarCarga() {
    try {
        // Primero, verificar que se ha subido el archivo
        if (tramiteData.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se han cargado trámites desde el archivo Excel.", null));
            return null; // Permanecer en la misma página
        }
        
        // Verificar que el número de configuración no sea 0
        if (nroConfigCostoTipoTramite == 0) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "El número de configuración no puede ser 0.", null));
            return null; // Permanecer en la misma página
        }

        // Verificación de fechas válidas
        if (fechaDesdeConfigCostoTipoTramite == null || fechaHastaConfigCostoTipoTramite == null) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe completar ambas fechas.", null));
            return null; // Permanecer en la misma página
        }
        
         // Obtener la fecha actual
        Date fechaActual = new Date();

        // Verificación de que las fechas no sean anteriores a la fecha actual
        if (fechaDesdeConfigCostoTipoTramite.before(fechaActual) || fechaHastaConfigCostoTipoTramite.before(fechaActual)) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las fechas ingresadas no pueden ser anteriores a la fecha de hoy.", null));
            return null; // Permanecer en la misma página
        }
        
        // Verificación de que la fecha desde no sea mayor que la fecha hasta
        if (fechaDesdeConfigCostoTipoTramite.after(fechaHastaConfigCostoTipoTramite)) {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "La fecha desde no puede ser mayor que la fecha hasta.", null));
            return null; // Permanecer en la misma página
        }
        
        

        // Crear la configuración
        DTOConfigCostoTipoTramiteImportar config = new DTOConfigCostoTipoTramiteImportar();
        config.setfechaDesdeConfigCostoTipoTramite(fechaDesdeConfigCostoTipoTramite);
        config.setfechaHastaConfigCostoTipoTramite(fechaHastaConfigCostoTipoTramite);
        config.setnroConfigCostoTipoTramite(nroConfigCostoTipoTramite);

        // Llamar al método del controlador con ambos parámetros
        controladorListaPrecios.guardarConfiguracion(config, tramiteData);

        // Mensaje de éxito que se guarda en FlashScope para la redirección
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Configuración y trámites guardados exitosamente.", null));

        // Redirigir a la página anterior
        return "ListaPreciosLista?faces-redirect=true";
    } catch (ListaPreciosException e) {
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar la configuración: " + e.getMessage(), null));
        return null; // Permanecer en la misma página
    } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, 
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error inesperado: " + e.getMessage(), null));
        return null; // Permanecer en la misma página
    }
}


public boolean existeSuperposicionDeFechas(Date fechaDesde, Date fechaHasta) {
    List<DTOCriterio> criterioList = new ArrayList<>();

    // Criterio 1: Fecha desde de la configuración <= fechaHasta ingresada
    DTOCriterio criterioFechaDesde = new DTOCriterio();
    criterioFechaDesde.setAtributo("fechaDesdeConfigCostoTipoTramite");
    criterioFechaDesde.setOperacion("<=");
    criterioFechaDesde.setValor(fechaHasta);
    criterioList.add(criterioFechaDesde);

    // Criterio 2: Fecha hasta de la configuración >= fechaDesde ingresada
    DTOCriterio criterioFechaHasta = new DTOCriterio();
    criterioFechaHasta.setAtributo("fechaHastaConfigCostoTipoTramite");
    criterioFechaHasta.setOperacion(">=");
    criterioFechaHasta.setValor(fechaDesde);
    criterioList.add(criterioFechaHasta);

    // Criterio 3: Fecha de baja nula (solo configuraciones activas)
    DTOCriterio criterioFechaBaja = new DTOCriterio();
    criterioFechaBaja.setAtributo("fechaBajaConfigCostoTipoTramite");
    criterioFechaBaja.setOperacion("is null");
    criterioList.add(criterioFechaBaja);

    // Realizar la búsqueda con los criterios definidos
    List<Object> resultados = FachadaPersistencia.getInstance().buscar("ConfigCostoTipoTramite", criterioList);

    // Si se encuentran configuraciones que cumplen los criterios, existe superposición
    return !resultados.isEmpty();
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

    public List<DTOCostoTipoTramiteImportar> getTramiteData() {
        return tramiteData;
    }

    public void setTramiteData(List<DTOCostoTipoTramiteImportar> tramiteData) {
        this.tramiteData = tramiteData;
    }
}
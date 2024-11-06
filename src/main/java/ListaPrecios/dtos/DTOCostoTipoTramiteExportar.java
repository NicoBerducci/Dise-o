
package ListaPrecios.dtos;

import java.util.List;

public class DTOCostoTipoTramiteExportar  {
private int codDTOImportar;
private int codTipoTramite;
private int ImporteCostoTipoTramite;
private int nroConfigCostoTipoTramite;

 public int getcodTipoTramite() {
        return codTipoTramite;
    }

    public void setcodTipoTramite(int codTipoTramite) {
        this.codTipoTramite = codTipoTramite;
    }
    
     public int getcodDTOImportar() {
        return codDTOImportar;
    }

    public void setcodDTOImportar(int codDTOImportar) {
        this.codDTOImportar = codDTOImportar;
    }
     public int getImporteCostoTipoTramite() {
        return ImporteCostoTipoTramite;
    }

    public void setImporteCostoTipoTramite(int ImporteCostoTipoTramite) {
        this.ImporteCostoTipoTramite = ImporteCostoTipoTramite;
    }
}

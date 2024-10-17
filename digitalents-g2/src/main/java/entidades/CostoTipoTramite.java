package entidades;


public class CostoTipoTramite extends Entidad{
    
    private int importeCostoTipoTramite;
    private TipoTramite tipoTramite;
    
    public CostoTipoTramite(){
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
}

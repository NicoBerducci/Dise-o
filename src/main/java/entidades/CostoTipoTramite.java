package entidades;


public class CostoTipoTramite extends Entidad{
    
    private int importeCostoTipoTramite;
    private TipoTramite tipoTramite;
    private ConfigCostoTipoTramite configCostoTipoTramite;
    
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
    public ConfigCostoTipoTramite getconfigCostoTipoTramite() {
        return configCostoTipoTramite;
    }

    public void setconfigCostoTipoTramite(ConfigCostoTipoTramite configCostoTipoTramite) {
        this.configCostoTipoTramite = configCostoTipoTramite;
    }
}


package ABMConsultor.dtos;

public class DTOConsultorModificarIn {
    private int cantMaximaTramites;
    private String nombreApellidoConsultor;
    private int nroLegajoConsultor;
     private int CodUsuario;
    private String password;
    private String username;
    private int cantTramitesAsignados;
    
    
       public int getcantTramitesAsignados(){
        return cantTramitesAsignados;
    }
    
    public void setcantTramitesAsignados(int cantTramitesAsignados){
        this.cantTramitesAsignados = cantTramitesAsignados;
    }
    
    public int getcantMaximaTramites(){
        return cantMaximaTramites;
    }
    
    public void setcantMaximaTramites(int cantMaximaTramites){
        this.cantMaximaTramites = cantMaximaTramites;
    }
    
    public String getnombreApellidoConsultor(){
        return nombreApellidoConsultor;
    }
    
    public void setnombreApellidoConsultor(String nombreApellidoConsultor){
        this.nombreApellidoConsultor = nombreApellidoConsultor;
    }
    
    public int getnroLegajoConsultor(){
        return nroLegajoConsultor;
    }
    
    public void setnroLegajoConsultor(int nroLegajoConsultor){
        this.nroLegajoConsultor = nroLegajoConsultor;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    public int getCodUsuario(){
        return CodUsuario;
    }
    
    public void setCodUsuario(int CodUsuario){
        this.CodUsuario = CodUsuario;
    }
}

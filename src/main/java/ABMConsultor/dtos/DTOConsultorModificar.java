
package ABMConsultor.dtos;


public class DTOConsultorModificar {
    private int nroLegajoConsultor;
    private int cantMaximaTramites;
    private String nombreApellidoConsultor;
    private int codUsuario;
    private String password;
    private String username;
    
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
   public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }
}

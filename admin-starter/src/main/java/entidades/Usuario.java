package entidades;


public class Usuario extends Entidad{
    
    private int CodUsuario;
    private String password;
    private String username;
    
    public Usuario(){
    }
    
    public int getCodUsuario(){
        return CodUsuario;
    }
    
    public void setCodUsuario(int CodUsuario){
        this.CodUsuario = CodUsuario;
    }
    
    public String getpassword(){
        return password;
    }
    
    public void setpassword(String password){
        this.password = password;
    }
    
    public String getusername(){
        return username;
    }
    
    public void setusername(String username){
        this.username = username;
    }
}

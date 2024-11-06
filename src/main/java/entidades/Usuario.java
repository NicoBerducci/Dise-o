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
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
}

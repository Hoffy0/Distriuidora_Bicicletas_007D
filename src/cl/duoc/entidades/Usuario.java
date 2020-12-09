package cl.duoc.entidades;

/**
 *
 * @author max_m
 */
public class Usuario {
    //Variables
    private String usuario;
    private String password;
    private int privilegio;
    
    //Constructores

    public Usuario() {
    }

    public Usuario(String usuario, String password, int privilegio) {
        this.usuario = usuario;
        this.password = password;
        this.privilegio = privilegio;
    }
    
    //Getters&Setters

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    //////////////////////////////////////////////////////

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    //////////////////////////////////////////////////////

    public int getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(int privilegio) {
        this.privilegio = privilegio;
    }
    
    //////////////////////////////////////////////////////
    

    
}

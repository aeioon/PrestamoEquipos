package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;

public class ValidarLogin {
    
    private UsuarioDAO usuarioDao = new UsuarioDAO();
    private Usuario usuario = new Usuario();

    public ValidarLogin() {
    }
    
    public boolean verificarLogin(Usuario usuario){
        if(usuarioDao.leer(usuario)){
            this.usuario = usuario;
            System.out.println("Bienvenido");
            return true;
        }else{
            System.out.println("Datos incorrectos");
            return false;
        }
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
}

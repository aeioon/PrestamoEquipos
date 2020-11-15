package Control;

import DAO.EncargadoDAO;
import DAO.UsuarioDAO;
import Entidad.Encargado;
import Entidad.Usuario;

public class ValidarLogin {
    
    private UsuarioDAO usuarioDao = new UsuarioDAO();
    private EncargadoDAO encargadoDao = new EncargadoDAO();
    private Usuario usuario = new Usuario();

    public ValidarLogin() {
    }
    
    public boolean verificarUsuario(Usuario usuario){
        System.out.println("Usuario:" + usuario.getId());
        System.out.println("Contraseña:" + usuario.getContraseña());
        if(usuarioDao.validar(usuario)){
            this.usuario = usuario;
            System.out.println("Bienvenido");
            return true;
        }else{
            System.out.println("Datos incorrectos");
            return false;
        }
    }
    
    public boolean verificarAdministrador(Encargado encargado){
        System.out.println("Usuario:" + usuario.getId());
        System.out.println("Contraseña:" + usuario.getContraseña());
        if(encargadoDao.validar(encargado)){
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

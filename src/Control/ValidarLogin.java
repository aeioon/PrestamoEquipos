package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;

public class ValidarLogin {
    
    private UsuarioDAO usuarioDao = new UsuarioDAO();

    public ValidarLogin() {
    }
    
    public boolean verificarLogin(Usuario usuario){
        System.out.println("Usuario:" + usuario.getId());
        System.out.println("Contraseña:" + usuario.getConstraseña());
        if(usuarioDao.leer(usuario)){
            System.out.println("Datos correctos, Bienvenido");
            return true;
        }else{
            System.out.println("Datos incorrectos");
            return false;
        }
    }
}

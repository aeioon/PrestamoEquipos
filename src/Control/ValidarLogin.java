package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;

public class ValidarLogin {
    
    private UsuarioDAO usuarioDao = new UsuarioDAO();

    public ValidarLogin() {
    }
    
    public boolean verificarLogin(Usuario usuario){
        System.out.println("esta verificando");
        if(usuarioDao.leer(usuario)){
            System.out.println("Bienvenido");
            return true;
        }else{
            System.out.println("Datos incorrectos");
            return false;
        }
    }
}

package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;

public class ValidarLogin {

    private UsuarioDAO usuarioDao = new UsuarioDAO();
    private Usuario usuario = new Usuario();

    public ValidarLogin() {
    }

    public Usuario verificarUsuario(Usuario usuario) {
        usuario = usuarioDao.leer(usuario);
        if (usuario != null) {
            System.out.println("Bienvenido");
        } else {
            System.out.println("Datos incorrectos");
        }
        return usuario;
    }

}

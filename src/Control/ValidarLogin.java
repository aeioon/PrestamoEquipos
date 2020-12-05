package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;

public class ValidarLogin {

    private UsuarioDAO usuarioDao = new UsuarioDAO();
    private Usuario usuario = new Usuario();

    public ValidarLogin() {
    }

    public Usuario verificarUsuario(Usuario usuario) {
        Usuario usuarioLec = null;
        usuarioLec = usuarioDao.leer(usuario);
        if (usuarioLec != null) {
            System.out.println("Bienvenido");
            return usuarioLec;
        } else {
            System.out.println("Datos incorrectos");
            return usuarioLec;
        }
    }

 }

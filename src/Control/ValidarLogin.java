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

    public Encargado verificarAdministrador(Encargado encargado) {
        Encargado encargadoLec = null;
        encargadoLec = encargadoDao.leer(encargado);
        if (encargadoLec != null) {
            System.out.println("Bienvenido");
            return encargadoLec;
        } else {
            System.out.println("Datos incorrectos");
            
            return encargadoLec;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

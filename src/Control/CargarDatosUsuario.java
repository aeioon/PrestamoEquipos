package Control;

import DAO.SolicitudDAO;
import DAO.UsuarioDAO;
import Entidad.Programa;
import Entidad.Usuario;
import java.util.ArrayList;

public class CargarDatosUsuario {

    ArrayList<Programa> programs = new ArrayList<Programa>();
    SolicitudDAO solicitudDao = new SolicitudDAO();
    UsuarioDAO usuarioDao = new UsuarioDAO();
    private Usuario user = new Usuario();
    
    ArrayList<String[]> datosSolicitud = new ArrayList<>();

    private boolean activo = false;
    private boolean cargaSolicitud = false;
    private boolean cargarActividad = false;
    private boolean cargarUsuario = false;
    
    private CargarDatosUsuario() {

    }
    private static CargarDatosUsuario holder = new CargarDatosUsuario();

    public static CargarDatosUsuario getInstance() {
        return holder;
    }

    public void cargar(Usuario usuario) {
        cargaSolicitud = false;
        cargarActividad = false;
        cargarUsuario = false;
        new Thread(new Runnable() {
            @Override
            public void run() {
                cargarSolicitudes(usuario);
                System.out.println("Carga solicitud");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                cargarActivity(usuario);
                System.out.println("Carga actividad");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                cargarUsuario(usuario);
                System.out.println("Carga usuario");
            }
        }).start();
    }

    public void cargarUsuario(Usuario usuario) {
        user = usuarioDao.leer(usuario);
        cargarUsuario = true;
    }
    
    public void cargarSolicitudes(Usuario usuario) {
        datosSolicitud = solicitudDao.getInfo(usuario);
        cargaSolicitud = true;
    }

    public void cargarActivity(Usuario usuario) {
        if (solicitudDao.VerifyActivity(usuario)) {
            activo = true;
        } else {
            activo = false;
        }
        cargarActividad = true;
    }
    
    public void resetData() {
        activo = false;
        cargaSolicitud = false;
        cargarActividad = false;
    }

    public ArrayList<String[]> getDatosSolicitud() {
        return datosSolicitud;
    }

    public void setDatosSolicitud(ArrayList<String[]> datosSolicitud) {
        this.datosSolicitud = datosSolicitud;
    }

    public boolean isCargarUsuario() {
        return cargarUsuario;
    }

    public void setCargarUsuario(boolean cargarUsuario) {
        this.cargarUsuario = cargarUsuario;
    }
    
    public SolicitudDAO getSolicitudDao() {
        return solicitudDao;
    }

    public void setSolicitudDao(SolicitudDAO solicitudDao) {
        this.solicitudDao = solicitudDao;
    }

    public UsuarioDAO getUsuarioDao() {
        return usuarioDao;
    }

    public void setUsuarioDao(UsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isCargarActividad() {
        return cargarActividad;
    }

    public void setCargarActividad(boolean cargarActividad) {
        this.cargarActividad = cargarActividad;
    }

    public static CargarDatosUsuario getHolder() {
        return holder;
    }

    public static void setHolder(CargarDatosUsuario holder) {
        CargarDatosUsuario.holder = holder;
    }

    public boolean isCargaSolicitud() {
        return cargaSolicitud;
    }

    public void setCargaSolicitud(boolean cargaSolicitud) {
        this.cargaSolicitud = cargaSolicitud;
    }

    public ArrayList<Programa> getPrograms() {
        return programs;
    }

    public void setPrograms(ArrayList<Programa> programs) {
        this.programs = programs;
    }

}

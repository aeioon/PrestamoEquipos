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

    ArrayList<String[]> datosEquipos = new ArrayList<>();
    ArrayList<String[]> datosSolicitudes = new ArrayList<>();

    private boolean carga = false;
    private boolean activo = false;
    private boolean cargaEquipos = false;
    private boolean cargaSolicitudes = false;
    private boolean cargarActividad = false;
    private boolean cargarUsuario = false;

    private CargarDatosUsuario() {

    }
    private static CargarDatosUsuario holder = new CargarDatosUsuario();

    public static CargarDatosUsuario getInstance() {
        return holder;
    }

    public void cargar(Usuario usuario) {
        carga = true;
        cargaEquipos = false;
        cargarActividad = false;
        cargarUsuario = false;
        new Thread(new Runnable() {
            @Override
            public void run() {
                cargarEquipos(usuario);
                System.out.println("Carga equipos");
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
        new Thread(new Runnable() {
            @Override
            public void run() {
                cargarSolicitudes(usuario);
                System.out.println("Carga solicitudes");
            }
        }).start();
    }

    public ArrayList<String[]> getDatosSolicitudes() {
        return datosSolicitudes;
    }

    public void setDatosSolicitudes(ArrayList<String[]> datosSolicitudes) {
        this.datosSolicitudes = datosSolicitudes;
    }

    public boolean isCargaSolicitudes() {
        return cargaSolicitudes;
    }

    public void setCargaSolicitudes(boolean cargaSolicitudes) {
        this.cargaSolicitudes = cargaSolicitudes;
    }

    public boolean isCarga() {
        return carga;
    }

    public void setCarga(boolean carga) {
        this.carga = carga;
    }

    public void cargarUsuario(Usuario usuario) {
        user = usuarioDao.leer(usuario);
        cargarUsuario = true;
    }

    public void cargarEquipos(Usuario usuario) {
        datosEquipos = solicitudDao.getInfo(usuario);
        cargaEquipos = true;
    }
    
    public void cargarSolicitudes(Usuario usuario) {
        datosSolicitudes = solicitudDao.getInfoTotal(usuario);
        cargaSolicitudes = true;
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
        programs = new ArrayList<Programa>();
        user = new Usuario();
        datosEquipos = new ArrayList<>();
        activo = false;
        cargaEquipos = false;
        cargarActividad = false;
        cargaSolicitudes = false;
        cargarUsuario = false;
        carga = false;
    }

    public ArrayList<String[]> getDatosEquipos() {
        return datosEquipos;
    }

    public void setDatosEquipos(ArrayList<String[]> datosEquipos) {
        this.datosEquipos = datosEquipos;
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

    public boolean isCargaEquipos() {
        return cargaEquipos;
    }

    public void setCargaEquipos(boolean cargaEquipos) {
        this.cargaEquipos = cargaEquipos;
    }

    public ArrayList<Programa> getPrograms() {
        return programs;
    }

    public void setPrograms(ArrayList<Programa> programs) {
        this.programs = programs;
    }

}

package Control;

import DAO.SolicitudDAO;
import DAO.UsuarioDAO;
import Entidad.Usuario;

public class CargarDatos {

    SolicitudDAO solicitudDao = new SolicitudDAO();
    UsuarioDAO usuarioDao = new UsuarioDAO();
    private Usuario user = new Usuario();
    private boolean activo;
    private String infoIdSolicitud = "";
    private String infoIdEquipo = "";
    private String infoNombreEdificio = "";
    private String infoIdEdificio = "";
    private String infoCodigoSala = "";
    private boolean carga = false;
    private boolean cargaSolicitud = false;

    private CargarDatos() {

    }
    private static CargarDatos holder = new CargarDatos();

    public static CargarDatos getInstance() {
        return holder;
    }
    
    public void cargar(Usuario usuario) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                cargarSolicitud(usuario);
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
                System.out.println("Carga Usuario");
            }
        }).start();
    }
    
    public void resetData(){
        activo = false;
        carga = false;
        cargaSolicitud = false;
    }

   

    public void cargarUsuario(Usuario usuario) {
        user = usuarioDao.leer(usuario);
    }

    public void cargarSolicitud(Usuario usuario) {
        String[] datos = solicitudDao.getInfo(usuario);
        infoIdSolicitud = datos[0];
        infoIdEquipo = datos[1];
        infoNombreEdificio = datos[2];
        infoIdEdificio = datos[3];
        infoCodigoSala = datos[4];
        cargaSolicitud = true;
    }

    public void cargarActivity(Usuario usuario) {
        carga = true;
        if (!solicitudDao.VerifyInactivity(usuario)) {
            activo = true;
        } else {
            activo = false;
        }
    }

    public boolean isCarga() {
        return carga;
    }

    public void setCarga(boolean carga) {
        this.carga = carga;
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

    public String getInfoIdSolicitud() {
        return infoIdSolicitud;
    }

    public void setInfoIdSolicitud(String infoIdSolicitud) {
        this.infoIdSolicitud = infoIdSolicitud;
    }

    public String getInfoIdEquipo() {
        return infoIdEquipo;
    }

    public void setInfoIdEquipo(String infoIdEquipo) {
        this.infoIdEquipo = infoIdEquipo;
    }

    public String getInfoNombreEdificio() {
        return infoNombreEdificio;
    }

    public void setInfoNombreEdificio(String infoNombreEdificio) {
        this.infoNombreEdificio = infoNombreEdificio;
    }

    public String getInfoIdEdificio() {
        return infoIdEdificio;
    }

    public void setInfoIdEdificio(String infoIdEdificio) {
        this.infoIdEdificio = infoIdEdificio;
    }

    public String getInfoCodigoSala() {
        return infoCodigoSala;
    }

    public void setInfoCodigoSala(String infoCodigoSala) {
        this.infoCodigoSala = infoCodigoSala;
    }

    public static CargarDatos getHolder() {
        return holder;
    }

    public static void setHolder(CargarDatos holder) {
        CargarDatos.holder = holder;
    }
    
     public boolean isCargaSolicitud() {
        return cargaSolicitud;
    }

    public void setCargaSolicitud(boolean cargaSolicitud) {
        this.cargaSolicitud = cargaSolicitud;
    }
    
}

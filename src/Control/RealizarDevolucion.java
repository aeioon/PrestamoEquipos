package Control;

import DAO.ComputadorDAO;
import DAO.ProgramaDAO;
import DAO.SolicitudD;
import Entidad.Programa;
import Entidad.Usuario;
import java.util.ArrayList;

public class RealizarDevolucion {

    SolicitudD solicitudDao = new SolicitudD();
    ComputadorDAO computadroDao = new ComputadorDAO();
    String infoIdEquipo = "";
    String infoNombreEdificio = "";
    String infoIdEdificio = "";
    String infoCodigoSala = "";

    public RealizarDevolucion() {
    }

    public boolean makeReturn(Usuario usuario) {
        if (!solicitudDao.VerifyInactivity(usuario)) {
            infoIdEquipo = solicitudDao.getInfo(usuario)[0];
            if (solicitudDao.ChangeRequestStatus(usuario)) {
                computadroDao.freeComputer(Integer.parseInt(infoIdEquipo));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isInactivity(Usuario usuario) {
        if (!solicitudDao.VerifyInactivity(usuario)) {
            String[] datos = solicitudDao.getInfo(usuario);
            infoIdEquipo = datos[0];
            infoNombreEdificio = datos[1];
            infoIdEdificio = datos[2];
            infoCodigoSala = datos[3];
            return true;
        } else {
            return false;
        }
    }

    public String getInfoIdEquipo() {
        return infoIdEquipo;
    }

    public void setInfoIdEquipo(String infoIdEquipo) {
        this.infoIdEquipo = infoIdEquipo;
    }

    public String getInfoIdEdificio() {
        return infoIdEdificio;
    }

    public void setInfoIdEdificio(String infoIdEdificio) {
        this.infoIdEdificio = infoIdEdificio;
    }

    public String getInfoNombreEdificio() {
        return infoNombreEdificio;
    }

    public void setInfoNombreEdificio(String infoNombreEdificio) {
        this.infoNombreEdificio = infoNombreEdificio;
    }

    public String getInfoCodigoSala() {
        return infoCodigoSala;
    }

    public void setInfoCodigoSala(String infoCodigoSala) {
        this.infoCodigoSala = infoCodigoSala;
    }

}

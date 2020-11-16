package Control;

import DAO.EncargadoDAO;
import DAO.SolicitudDAO;
import Entidad.Encargado;
import java.util.ArrayList;

public class CargarDatosAdministrador {

    EncargadoDAO encargadoDao = new EncargadoDAO();
    private Encargado encargado = new Encargado();
    private boolean carga = true;
    
    private CargarDatosAdministrador() {

    }
    private static CargarDatosAdministrador holder = new CargarDatosAdministrador();

    public static CargarDatosAdministrador getInstance() {
        return holder;
    }

    public void cargar(Encargado encargado) {
        carga = true;
        this.encargado = encargadoDao.leer(encargado);
    }

    public void resetData() {
        encargado = new Encargado();
        carga = false;
    }

    public boolean isCarga() {
        return carga;
    }

    public void setCarga(boolean carga) {
        this.carga = carga;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }
   
    public static CargarDatosAdministrador getHolder() {
        return holder;
    }

    public static void setHolder(CargarDatosAdministrador holder) {
        CargarDatosAdministrador.holder = holder;
    }
}

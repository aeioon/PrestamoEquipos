package Entidad;

import java.time.LocalDateTime;
import java.util.Date;


public class Solicitud {
    private String id;
    private LocalDateTime fecha;
    private int idComputador;
    private String idUsuario;

    public Solicitud() {
    }

    public Solicitud(String id, LocalDateTime fecha, int idComputador, String usuario) {
        this.id = id;
        this.fecha = fecha;
        this.idComputador = idComputador;
        this.idUsuario = idUsuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(int idComputador) {
        this.idComputador = idComputador;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }  
    
}

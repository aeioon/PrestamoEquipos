package Entidad;

import java.time.LocalDateTime;
import java.util.Date;


public class Solicitud {
    private int id;
    private LocalDateTime fecha;
    private int idComputador;
    private String idUsuario;
    private int Estado;

    public Solicitud() {
    }

    public Solicitud(int id, LocalDateTime fecha, int idComputador, String usuario, int estado) {
        this.id = id;
        this.fecha = fecha;
        this.idComputador = idComputador;
        this.idUsuario = idUsuario;
        this.Estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
   
}

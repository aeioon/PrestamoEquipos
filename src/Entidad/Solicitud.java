package Entidad;

import java.time.LocalDateTime;
import java.util.Date;


public class Solicitud {
    private int id;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
     private Computador computador;
    private Usuario usuario;   

    public Solicitud() {
    }

    public Solicitud(int id, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, Computador computador, Usuario usuario) {
        this.id = id;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.computador = computador;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Computador getComputador() {
        return computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}

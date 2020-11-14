package Entidad;

import java.time.LocalDateTime;
import java.util.Date;


public class Solicitud {
    private int id;
    private LocalDateTime fecha;
     private Computador computador;
    private Usuario usuario;   

    public Solicitud() {
    }

    public Solicitud(int id, LocalDateTime fecha, Computador computador, Usuario usuario) {
        this.id = id;
        this.fecha = fecha;
        this.computador = computador;
        this.usuario = usuario;
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

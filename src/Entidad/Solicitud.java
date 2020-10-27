package Entidad;

import java.util.Date;


public class Solicitud {
    private String id;
    private Date date;
    private Computador computador;
    private Usuario usuario;

    public Solicitud() {
    }

    public Solicitud(String id, Date date, Computador computador, Usuario usuario) {
        this.id = id;
        this.date = date;
        this.computador = computador;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

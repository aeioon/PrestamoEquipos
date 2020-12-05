package Entidad;

public class Computador {
    private int id;
    private String sistemaOperativo;
    private String hardware;
    private boolean disponibilidad;
    private Sala sala;
    
    public Computador(int id, String sistemaOperativo, String hardware, boolean disponibilidad, Sala sala) {
        this.id = id;
        this.sistemaOperativo = sistemaOperativo;
        this.hardware = hardware;
        this.disponibilidad = disponibilidad;
        this.sala = sala;
    }

    public Computador() {
        this.id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }    
    
}

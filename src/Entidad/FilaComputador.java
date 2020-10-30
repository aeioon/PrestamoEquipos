package Entidad;

public class FilaComputador {
    
    private int id_Equipo;
    private int id_Edificio;
    private String nombre_Edificio;
    private int id_Sala;

    public FilaComputador(int id_Equipo, int id_Edificio, String nombre_Edificio, int id_Sala) {
        this.id_Equipo = id_Equipo;
        this.id_Edificio = id_Edificio;
        this.nombre_Edificio = nombre_Edificio;
        this.id_Sala = id_Sala;
    }

    public int getId_Equipo() {
        return id_Equipo;
    }

    public void setId_Equipo(int id_Equipo) {
        this.id_Equipo = id_Equipo;
    }

    public int getId_Edificio() {
        return id_Edificio;
    }

    public void setId_Edificio(int id_Edificio) {
        this.id_Edificio = id_Edificio;
    }

    public String getNombre_Edificio() {
        return nombre_Edificio;
    }

    public void setNombre_Edificio(String nombre_Edificio) {
        this.nombre_Edificio = nombre_Edificio;
    }

    public int getId_Sala() {
        return id_Sala;
    }

    public void setId_Sala(int id_Sala) {
        this.id_Sala = id_Sala;
    }

}


package Entidad;


public class Sala {
    private int id;
    private String nombre;
    private Edificio edificio;
    private Encargado encargado;

    public Sala() {
    }

    public Sala(int id, String nombre, Edificio edificio, Encargado encargado) {
        this.id = id;
        this.nombre = nombre;
        this.edificio = edificio;
        this.encargado = encargado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    } 
}

package Entidad;


public class Sala {
    private int id;
    private String nombre;
    private int idEdificio;
    private String idEncargado;

    public Sala() {
    }

    public Sala(int id, String nombre, int idEedificio, String idEncargado) {
        this.id = id;
        this.nombre = nombre;
        this.idEdificio = idEedificio;
        this.idEncargado = idEncargado;
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

    public int getIdEdificio() {
        return idEdificio;
    }

    public void setIdEdificio(int idEdificio) {
        this.idEdificio = idEdificio;
    }

    public String getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(String idEncargado) {
        this.idEncargado = idEncargado;
    }
    
    
    
}

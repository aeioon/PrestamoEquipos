package Entidad;

public class Programa {
    private int id;
    private String nombre;
    private String version;

    public Programa() {
    }

    public Programa(int id, String nombre, String version) {
        this.id = id;
        this.nombre = nombre;
        this.version = version;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }    
}

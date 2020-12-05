package Entidad;


public class Sala {
    private int id;
    private String codigo;
    private String nombre;
    private String tipo;
    private Edificio edificio;
    private Usuario encargado;

    public Sala() {
    }

    public Sala(int id, String codigo, String nombre, String tipo, Edificio edificio, Usuario encargado) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.edificio = edificio;
        this.encargado = encargado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public Usuario getEncargado() {
        return encargado;
    }

    public void setEncargado(Usuario encargado) {
        this.encargado = encargado;
    }

    
}

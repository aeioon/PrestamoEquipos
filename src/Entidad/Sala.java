package Entidad;


class Sala {
    private int id;
    private String nombre;
    private Edificio edifico;
    private Encargado encargado;

    public Sala() {
    }

    public Sala(int id, String nombre, Edificio edifico, Encargado encargado) {
        this.id = id;
        this.nombre = nombre;
        this.edifico = edifico;
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

    public Edificio getEdifico() {
        return edifico;
    }

    public void setEdifico(Edificio edifico) {
        this.edifico = edifico;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }
    
    
    
}

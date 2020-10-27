package Entidad;

class Encargado {
    private String id;
    private String contraseña;
    private String nombres;
    private String apellidos;

    public Encargado() {
    }

    public Encargado(String id, String contraseña, String nombres, String apellidos) {
        this.id = id;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    
    
}

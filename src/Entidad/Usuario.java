package Entidad;


public class Usuario {
    private String id;
    private String contraseña;
    private String nombres;
    private String apellidos;
    private String carrera;
    private String facultad;
    private int rol;
   

    public Usuario() {
    }

    public Usuario(String id, String contraseña, String nombres, String apellidos, String carrera, String facultad,int rol) {
        this.id = id;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.carrera = carrera;
        this.facultad = facultad;
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", constrase\u00f1a=" + contraseña + ", nombres=" + nombres + ", apellidos=" + apellidos + ", carrera=" + carrera + ", facultad=" + facultad + '}';
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

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
}

package Entidad;


public class Usuario {
    private String id;
    private String constraseña;
    private String nombres;
    private String apellidos;
    private String carrera;
    private String facultad;
   

    public Usuario() {
    }

    public Usuario(String id, String constraseña, String nombres, String apellidos, String carrera, String facultad) {
        this.id = id;
        this.constraseña = constraseña;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.carrera = carrera;
        this.facultad = facultad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConstraseña() {
        return constraseña;
    }

    public void setConstraseña(String constraseña) {
        this.constraseña = constraseña;
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
    
    
}

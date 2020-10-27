package Entidad;


public class Usuario {
    private String id;
    private String constraseña;
    private String nombres;
    private String apellidos;
    private boolean activo;

    public Usuario() {
    }

    public Usuario(String id, String constraseña, String nombres, String apellidos, boolean activo) {
        this.id = id;
        this.constraseña = constraseña;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.activo = activo;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}

package Entidad;

import java.util.Objects;

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
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Programa other = (Programa) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.version, other.version)) {
            return false;
        }
        return true;
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

    @Override
    public String toString() {
        return "Programa{" + "id=" + id + ", nombre=" + nombre + ", version=" + version + '}';
    }
    
    
    
}

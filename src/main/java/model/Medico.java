package model;

public class Medico {
    
    private Integer id;
    private String nombre;
    private String apellido;
    private String documento;
    private String correoElectronico;

    public Medico() {
    }

    public Medico(Integer id, String nombre, String apellido, String documento, String correoElectronico) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.correoElectronico = correoElectronico;
    }
        

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "medico{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento + ", correoElectronico=" + correoElectronico + '}';
    }
    
    
    
}
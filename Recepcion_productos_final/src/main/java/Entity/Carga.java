
package Entity;
public class Carga {
    private int id;
    private Categoria categoria;
    private String descripcion ;
    private String estado;

    public Carga(int id, Categoria categoria, String descripcion, String estado) {
        this.id = id;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.estado = estado;
    }
     public Carga(Categoria categoria, String descripcion, String estado) {
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}

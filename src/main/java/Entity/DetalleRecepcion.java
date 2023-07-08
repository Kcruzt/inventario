
package Entity;
public class DetalleRecepcion {
    private int id;
    private Recepcion recepcion;
    private Servicio servicio;
    private Carga carga;

    public DetalleRecepcion(int id, Recepcion recepcion, Servicio servicio, Carga carga) {
        this.id = id;
        this.recepcion = recepcion;
        this.servicio = servicio;
        this.carga = carga;
    }

    public DetalleRecepcion(Recepcion recepcion, Servicio servicio, Carga carga) {
        this.recepcion = recepcion;
        this.servicio = servicio;
        this.carga = carga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recepcion getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(Recepcion recepcion) {
        this.recepcion = recepcion;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Carga getCarga() {
        return carga;
    }

    public void setCarga(Carga carga) {
        this.carga = carga;
    }
    
    
}

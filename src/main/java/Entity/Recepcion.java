
package Entity;
public class Recepcion {
    private int id;
    private Cliente cliente;
    private Administrador administrador;
    private String tipoComprobante;
    private String fecha;
    private String estado;
    private String total;

    public Recepcion(int id, Cliente cliente, Administrador administrador, String tipoComprobante, String fecha, String estado, String total) {
        this.id = id;
        this.cliente = cliente;
        this.administrador = administrador;
        this.tipoComprobante = tipoComprobante;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
    }
    
    public Recepcion(Cliente cliente, Administrador administrador, String tipoComprobante, String estado, String total) {
    
        this.cliente = cliente;
        this.administrador = administrador;
        this.tipoComprobante = tipoComprobante;
        this.estado = estado;
        this.total = total;
    }

    public Recepcion(Cliente cliente, Administrador administrador, String tipoComprobante, String fecha, String estado, String total) {
        this.cliente = cliente;
        this.administrador = administrador;
        this.tipoComprobante = tipoComprobante;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
    }

    public Recepcion(Integer id, Cliente cliente, String tipoComprobante, String estado,String total) {
       this.id = id;
        this.cliente = cliente;
        this.tipoComprobante = tipoComprobante;
        this.fecha = fecha;
        this.estado = estado;
        this.total=total;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    
}

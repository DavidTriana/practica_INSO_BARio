package modelo.VO;

public class bebidasVO {
    
    public String idBebida;
    public String nombre;
    public double precio;
    public String getIdBebida() {
        return idBebida;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setIdBebida(String idBebida) {
        this.idBebida = idBebida;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "bebidasVO [idBebida=" + idBebida + ", nombre=" + nombre + ", precio=" + precio + "]";
    }

    
}

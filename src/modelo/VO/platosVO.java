package modelo.VO;

public class platosVO {

    public String idPlato;
    public String nombre;
    public double precio;

    public String getIdPlato() {
        return idPlato;
    }
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setIdPlato(String idPlato) {
        this.idPlato = idPlato;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(double precio2) {
        this.precio = precio2;
    }
    
    @Override
    public String toString() {
        return "platosVO [idPlato=" + idPlato + ", nombre=" + nombre + ", precio=" + precio + "]";
    }

}

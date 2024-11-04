package modelo.VO;


public class cocineroVO{
	
    public String nombre;
    public String idCocinero;
    
    public String getNombre() {
        return nombre;
    }
    public String getIdCocinero() {
        return idCocinero;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setIdCocinero(String idTrabajador) {
        this.idCocinero = idTrabajador;
    }
    @Override
    public String toString() {
        return "cocineroVO [nombre=" + nombre + ", idCocinero=" + idCocinero + "]";
    }

    
    
    
}
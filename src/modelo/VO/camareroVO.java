package modelo.VO;

public class camareroVO{
	
    public String idCamarero;
    public String nombre;

    public String getIdCamarero() {
        return idCamarero;
    }
    public String getNombre() {
        return nombre;
    }
    public void setIdCamarero(String idCamarero) {
        this.idCamarero = idCamarero;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "camareroVO [idCamarero=" + idCamarero + ", nombre=" + nombre + "]";
    }
    

}

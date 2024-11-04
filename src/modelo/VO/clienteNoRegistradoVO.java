package modelo.VO;


public class clienteNoRegistradoVO {
	
  public String nombreCliente;
  public String correoCliente;
  public String apellido;

  
  public String getNombreCliente() {
    return nombreCliente;
  }
  public String getCorreoCliente() {
    return correoCliente;
  }
  public String getApellidoCliente() {
    return apellido;
  }
 

  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }
  public void setCorreoCliente(String correoCliente) {
    this.correoCliente = correoCliente;
  }
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }
  @Override
  public String toString() {
    return "clienteNoRegistradoVO [nombreCliente=" + nombreCliente + ", correoCliente=" + correoCliente + ", apellido="
        + apellido + "]";
  }

  
}  

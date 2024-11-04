package modelo.VO;


public class clienteRegistradoVO {

	public String id;
  public String nombreCliente;
  public String apellidoCliente;
  public String email;
  private String contrasenia;
  public String cuentaBanco;
  public String pedidosAnteriores;
  

  public String getPedidosAnteriores() {
    return pedidosAnteriores;
  }
  public String getNombreCliente() {
    return nombreCliente;
  }
  public String getApellidoCliente() {
    return apellidoCliente;
  }
  public String getCorreoCliente() {
    return email;
  }
  public String getCuentaBanco() {
    return cuentaBanco;
  }
  public String getContrasenia() {
    return contrasenia;
  }
  public String getId() {
    return id;
  }
  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }
  public void setApellidoCliente(String apellidoCliente) {
    this.apellidoCliente = apellidoCliente;
  }
  public void setCorreoCliente(String correoCliente) {
    this.email = correoCliente;
  }
  public void setCuentaBanco(String cuentaBanco) {
    this.cuentaBanco = cuentaBanco;
  }
  public void setContrasenia(String contrasenia) {
    this.contrasenia = contrasenia;
  }
  public void setId(String id) {
    this.id = id;
  }
  public void setPedidosAnteriores(String pedidosAnteriores) {
    this.pedidosAnteriores = pedidosAnteriores;
  }
  @Override
  public String toString() {
    return "clienteRegistradoVO [id=" + id + ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente
        + ", email=" + email + ", cuentaBanco=" + cuentaBanco + ", contrasenia=" + contrasenia + ", pedidosAnteriores="
        + pedidosAnteriores + "]";
  }


}
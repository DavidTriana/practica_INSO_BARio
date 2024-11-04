package modelo.VO;

public class pagosVO{
  public String idPagos;
  public String idPedido;
  public double precio;
  public String numeroTarjeta;
  public String fecha;
  
  public String getIdPagos() {
    return idPagos;
  }
  public String getIdPedido() {
    return idPedido;
  }
  public double getPrecio() {
    return precio;
  }
  public String getNumeroTarjeta() {
    return numeroTarjeta;
  }
  public String getFecha() {
    return fecha;
  }
  public void setIdPagos(String idPagos) {
    this.idPagos = idPagos;
  }
  public void setIdPedido(String idPedido) {
    this.idPedido = idPedido;
  }
  public void setPrecio(double precio) {
    this.precio = precio;
  }
  public void setNumeroTarjeta(String numeroTarjeta) {
    this.numeroTarjeta = numeroTarjeta;
  }
  public void setFecha(String fecha) {
    this.fecha = fecha;
  }
  @Override
  public String toString() {
    return "pagosVO [idPagos=" + idPagos + ", idPedido=" + idPedido + ", precio=" + precio + ", numeroTarjeta="
        + numeroTarjeta + ", fecha=" + fecha + "]";
  }

  

}
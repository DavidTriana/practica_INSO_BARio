package modelo.VO;


public class menuVO{

  public String idMenu;
  public String fecha;
  public String idPlato;
  public String idBebida;
  public String idCocinero;
  public String Menus;


  public String getMenus() {
    return Menus;
  }
  public void setMenus(String menus) {
    Menus = menus;
  }
  
  public String getIdMenu() {
    return idMenu;
  }
  public String getFecha() {
    return fecha;
  }
  public String getIdPlato() {
    return idPlato;
  }
  public String getIdBebida() {
    return idBebida;
  }
  public String getIdCocinero() {
    return idCocinero;
  }
  public void setIdMenu(String idMenu) {
    this.idMenu = idMenu;
  }
  public void setFecha(String fecha) {
    this.fecha = fecha;
  }
  public void setIdPlato(String idPlato) {
    this.idPlato = idPlato;
  }
  public void setIdBebida(String idBebida) {
    this.idBebida = idBebida;
  }
  public void setIdCocinero(String idCocinero) {
    this.idCocinero = idCocinero;
  }
  @Override
  public String toString() {
    return "menuVO [idMenu=" + idMenu + ", fecha=" + fecha + ", idPlato=" + idPlato + ", idBebida=" + idBebida
        + ", idCocinero=" + idCocinero + "]";
  }



  




  
}
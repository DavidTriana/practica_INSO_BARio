package modelo.VO;

public class pedidosVO {

    public String idPedido;
    public double precio;
    public String fecha;
    public String hora;
    public boolean esCompletado;
    public boolean esPagado;
    public String idUsuario;
    public String email; 
    public String idCamarero;
    public String idMenu;
    public String menus;

    
    public String getMenus() {
        return menus;
    }
    public void setMenus(String menus) {
        this.menus = menus;
    }
    public boolean isEsCompletado() {
        return esCompletado;
    }
    public void setEsCompletado(boolean esCompletado) {
        this.esCompletado = esCompletado;
    }
    public String getIdPedido() {
        return idPedido;
    }
    public double getPrecio() {
        return precio;
    }
    public String getFecha() {
        return fecha;
    }
    public String getHora() {
        return hora;
    }
    public boolean isEsPagado() {
        return esPagado;
    }
    public String getIdUsuario() {
        return idUsuario;
    }
    public String getEmail() {
        return email;
    }
    public String getIdCamarero() {
        return idCamarero;
    }
    public String getIdMenu() {
        return idMenu;
    }
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public void setEsPagado(boolean esPagado) {
        this.esPagado = esPagado;
    }
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setIdCamarero(String idCamarero) {
        this.idCamarero = idCamarero;
    }
    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }
    @Override
    public String toString() {
        return "pedidosVO [idPedido=" + idPedido + ", precio=" + precio + ", fecha=" + fecha + ", hora=" + hora
                + ", esPagado=" + esPagado + ", idUsuario=" + idUsuario + ", email=" + email + ", idCamarero="
                + idCamarero + ", idMenu=" + idMenu + "]";
    }

    
  




  

}
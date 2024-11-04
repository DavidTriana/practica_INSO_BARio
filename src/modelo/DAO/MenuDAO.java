package modelo.DAO;

import java.sql.*;

import javax.swing.JOptionPane;

import modelo.VO.menuVO;

import modelo.conexion;

public class MenuDAO {


  public static menuVO getMenu(String idMenu) { /* Cambiar si hay mas atributos */
    
    conexion conex = new conexion();
    Connection con = conex.conectar();
    menuVO menu = new menuVO();

    boolean exist = false;
    try {

      String sqlQuery = "select * from Menu where idMenu= " + idMenu + " ";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);

      if (rs.next()) {
        exist = true;
        menu.setIdMenu(rs.getString(1));
        menu.setFecha(rs.getString(2));
        menu.setIdPlato(rs.getString(3));
        menu.setIdBebida(rs.getString(4));
        menu.setIdCocinero(rs.getString(5));


      }
    } catch (NumberFormatException | SQLException e) {

      System.out.println("Clase MenuDAO: " + e);

      if(!exist){
        System.out.println("No existe el elemento");
      }
    }

    return menu;
  }


  public static void setMenu(String idMenu, String fecha, String idPlato, String idBebida, String idCocinero){

    boolean repetido = false;

    conexion conex = new conexion();
    Connection con = conex.conectar();

    try {
      String sqlQuery = "SELECT count(*) FROM menu";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);
      rs.next();

      int numeroMenus = rs.getInt(1);

      for (int i = 1; i <= numeroMenus; i++) {

        if (getMenu(i + "").getIdMenu().equals(idMenu)) {
          repetido = true;
          throw new SQLException();
        }

      }

    } catch (NumberFormatException | SQLException e) {

      if (repetido) {
        JOptionPane.showMessageDialog(null, "El menu ya está en la base de datos o el id esta repetido." + e);
      }
    }


    PreparedStatement ps = null;

    try {
      ps = con.prepareStatement("INSERT INTO menu VALUES (?,?,?,?,?)");
      ps.setString(1, idMenu);
      ps.setString(2, fecha);
      ps.setString(3, idPlato);
      ps.setString(4, idBebida);
      ps.setString(5, idCocinero);
      ps.executeUpdate();

      JOptionPane.showMessageDialog(null, "Todo salio correctamente.");
      
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "Ha ocurrido un error." + e);
    }

    finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
      }
    }


  }


  public void removeMenu(String idMenu){


    conexion conex = new conexion();
    Connection con = conex.conectar();

    try {
      String sqlQuery = "DELETE FROM menu WHERE idMenu="+idMenu+" ";
      Statement st = con.createStatement();
      st.execute(sqlQuery);

    } catch (NumberFormatException | SQLException e) {

      System.out.println("Error removeMenu"+" "+e);
    }

  }

  public void updateFechaMenu(String fecha, String id){

    conexion conex = new conexion();
    Connection con = conex.conectar();
    int numeroPedidos=0;

    try {


      String sqlQuery = "UPDATE menu SET fecha= "+fecha+" WHERE idMenu="+id+" ";
      Statement st = con.createStatement();
      st.executeUpdate(sqlQuery);

      //actualizamos atributos del pedido

      getMenu(id).setFecha(fecha);

    } catch (NumberFormatException | SQLException e) {
      System.out.println("ERROR UPDATE fecha"+e);
    }



  }


  public int getNumMenus(){

    conexion conex = new conexion();
    Connection con = conex.conectar();
    int numeroPedidos=0;

    try {
      String sqlQuery = "SELECT count(*) FROM menu";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);
      rs.next();
      numeroPedidos = rs.getInt(1);

    } catch (NumberFormatException | SQLException e) {

      System.out.println("Error getNumMenus"+" "+e);
    }

    return numeroPedidos;
  }


  public String toStringConsumiciones(String idMenu){

    String consumiciones;

    BebidaDAO bebida=new BebidaDAO();
    PlatosDAO plato=new PlatosDAO();

    String cadenaBebida=bebida.getBebida(this.getMenu(idMenu).idBebida).getNombre();

    String cadenaPlato=plato.getPlato(this.getMenu(idMenu).idPlato).getNombre();

    return  ""+cadenaPlato+", "+cadenaBebida;

  }

  public double precioMenu(String idMenu){

    BebidaDAO bebida=new BebidaDAO();
    PlatosDAO plato=new PlatosDAO();

    double precioBebida=bebida.getBebida(this.getMenu(idMenu).idBebida).getPrecio();

    double precioPlato=plato.getPlato(this.getMenu(idMenu).idPlato).getPrecio();

    return precioBebida+precioPlato;

  }

  public static void main(String[] args) {
    
  }
}

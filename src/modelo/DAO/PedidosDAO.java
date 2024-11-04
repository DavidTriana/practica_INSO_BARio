package modelo.DAO;

import java.sql.*;
import modelo.VO.pedidosVO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

import modelo.conexion;

public class PedidosDAO {

  public static pedidosVO getPedidos(String idPedido) { 
    /*Cambiar por si los atributos son otro tipo*/
    conexion conex = new conexion();
    Connection con = conex.conectar();
    pedidosVO pedido = new pedidosVO();
    boolean exist = false;
    try {

      String sqlQuery = "select * from pedidos where idPedido= " + idPedido + " ";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);

      if (rs.next()) {
        exist = true;
        pedido.setIdPedido(rs.getString(1));
        pedido.setPrecio(Float.parseFloat(rs.getString(2))); /* Cambiar si se cambian el nombre de las columnas */
        pedido.setFecha(rs.getString(3));
        pedido.setHora((rs.getString(4)));
        pedido.setEsCompletado(rs.getBoolean(5));
        pedido.setEsPagado(rs.getBoolean(6));
        pedido.setIdUsuario(rs.getString(7));
        pedido.setEmail(rs.getString(8));
        pedido.setIdCamarero(rs.getString(9));
        pedido.setIdMenu(rs.getString(10));
        pedido.setMenus(rs.getString(11));

        /*
         * Pruebas de funcionamiento
         * System.out.println("Id del pedido: " + pedido.getIdPedido());
         * System.out.println("Precio del pedido: " + pedido.getPrecio());
         */
      }
    } catch (NumberFormatException | SQLException e) {
      System.out.println("Clase pedidosDAO: " + e);

      if(!exist){
        System.out.println("No existe el elemento");
      }
    }

    return pedido;
  }

    public boolean setPedido(String idPedido, Double precio, String fecha, String hora, boolean esCompletado, boolean esPagado,
   String idUsuarioReg, String email, 
   String idCamarero, String idMenu, String menus) {

    boolean aniadido = false;
    boolean repetido = false;

    conexion conex = new conexion();
    Connection con = conex.conectar();

    try {
      String sqlQuery = "SELECT count(*) FROM Pedidos";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);
      rs.next();

      int numeroPedidos = rs.getInt(1);

      for (int i = 1; i <= numeroPedidos; i++) {

        if (getPedidos(i + "").getIdPedido().equals(idPedido)) {
          repetido = true;
          throw new SQLException();
        }

      }

    } catch (NumberFormatException | SQLException e) {

      if (repetido) {
        JOptionPane.showMessageDialog(null, "El elemento ya está en la base de datos o el id esta repetido." + e);
      }
    }

    PreparedStatement ps = null;

    try {
      ps = con.prepareStatement("INSERT INTO Pedidos VALUES (?,?,?,?,?,?,?,?,?,?,?)");
      ps.setString(1, idPedido);
      ps.setDouble(2, precio);
      ps.setString(3, fecha);
      ps.setString(4, hora);
      ps.setBoolean(5, esCompletado);
      ps.setBoolean(6, esPagado);
      ps.setString(7, idUsuarioReg);
      ps.setString(8, email);
      ps.setString(9, idCamarero);
      ps.setString(10, idMenu);
      ps.setString(11, menus);


      ps.executeUpdate();

      JOptionPane.showMessageDialog(null, "Todo salio correctamente.");
      aniadido = true;
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

    return aniadido;
  }



  public int getNumPedidos(){

    conexion conex = new conexion();
    Connection con = conex.conectar();
    int numeroPedidos=0;

    try {
      String sqlQuery = "SELECT count(*) FROM pedidos";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);
      rs.next();
      numeroPedidos = rs.getInt(1);

    } catch (NumberFormatException | SQLException e) {
    }

    return numeroPedidos;
  }

  public void updateCompletadoPedido(boolean completado, String id){
    conexion conex = new conexion();
    Connection con = conex.conectar();
    int numeroPedidos=0;

    try {


      String sqlQuery = "UPDATE pedidos SET esCompletado= "+completado+" WHERE idPedido="+id+" ";
      Statement st = con.createStatement();
      st.executeUpdate(sqlQuery);

      //actualizamos atributos del pedido

      getPedidos(id).setEsCompletado(completado);
      System.out.println( getPedidos(id).isEsCompletado() +" comprobacion en el update");

    } catch (NumberFormatException | SQLException e) {
      System.out.println("ERROR UPDATE"+e);
    }


  }

  public void updateEntregadoPedido(String id){

    conexion conex = new conexion();
    Connection con = conex.conectar();
    int numeroPedidos=0;
    boolean aux = false;

    try {


      String sqlQuery = "UPDATE pedidos SET esPagado= "+aux+" WHERE idPedido="+id+" ";
      Statement st = con.createStatement();
      st.executeUpdate(sqlQuery);

      //actualizamos atributos del pedido

      getPedidos(id).setEsPagado(aux);

    } catch (NumberFormatException | SQLException e) {
      System.out.println("ERROR UPDATE"+e);
    }

  }

  public static void main(String[] args) {
  
  }

  
}

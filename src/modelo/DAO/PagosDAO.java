package modelo.DAO;

import java.sql.*;
import modelo.VO.pagosVO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

import modelo.conexion;

public class PagosDAO {

  public static pagosVO getPago(String idPagos) {
    conexion conex = new conexion();
    Connection con = conex.conectar();
    pagosVO pago = new pagosVO();
    boolean exist = false;
    try {

      String sqlQuery = "select * from Pagos where idPagos= " + idPagos + " ";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);

      if (rs.next()) {
        exist = true;
        pago.setIdPagos(rs.getString(1));
        pago.setIdPedido(rs.getString(2));
        pago.setPrecio(Float.parseFloat(rs.getString(3))); /* Cambiar si se cambian el nombre de las columnas */
        pago.setNumeroTarjeta(rs.getString(4));
        pago.setFecha(rs.getString(5));

        /*
         * Pruebas de funcionamiento
         * System.out.println("Id del pago: " + pago.getIdPago());
         * System.out.println("valor del pago: " + pago.getValor());
         */
      }
    } catch (NumberFormatException | SQLException e) {
      System.out.println("Clase PagosDAO: " + e);

      if (!exist) {
        System.out.println("No existe el elemento");
      }

    }

    return pago;
  }

  public static boolean setPagos(String idPagos, String idPedido,double precio, String numTarjeta, String fecha) {
    boolean aniadido = false;
    boolean repetido = false;

    conexion conex = new conexion();
    Connection con = conex.conectar();

    pagosVO pago = new pagosVO();
    pago.setIdPagos(idPagos);
    pago.setPrecio(precio);
    pago.setNumeroTarjeta(numTarjeta);
    pago.setFecha(fecha);

    try {
      String sqlQuery = "SELECT count(*) FROM Pagos";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);

      int numeroPagos = rs.getInt(1);

      for (int i = 1; i <= numeroPagos; i++) {

        if (getPago(i + "").getIdPagos() == idPagos) {

          repetido = true;
        }

      }

    } catch (NumberFormatException | SQLException e) {

      if (repetido) {
        System.out.println("El elemento ya está en la base de datos." + e);
      }
    }

    PreparedStatement ps = null;

    try {
      ps = con.prepareStatement("INSERT INTO Pagos VALUES (?,?,?,?,?)");
      ps.setString(1, idPagos);
      ps.setString(2, idPedido);
      ps.setDouble(3, precio);
      ps.setString(4, numTarjeta);
      ps.setString(5, fecha);
      ps.executeUpdate();

      JOptionPane.showMessageDialog(null, "Todo salio correctamente.");
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + e);
    }

    finally {
      try {
        if (con != null) {
          con.close();
        }
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se ha podido realizar la conexion");
      }
    }

    return aniadido;
  }

  public static void main(String[] args) {
    
  }
}

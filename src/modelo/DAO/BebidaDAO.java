package modelo.DAO;

import java.sql.*;
import modelo.VO.bebidasVO;

import modelo.conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class BebidaDAO{

  public static bebidasVO getBebida(String idBebida) {

    conexion conex = new conexion();
    Connection con = conex.conectar();
    bebidasVO bebida = new bebidasVO();

    boolean exist = false;

    try {

      String sqlQuery = "SELECT * FROM bebidas WHERE idBebida= " + idBebida + " ";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);

      if (rs.next()) {
        exist = true;
        bebida.setIdBebida(rs.getString(1));
        bebida.setNombre(rs.getString(2));
        bebida.setPrecio(Double.parseDouble(rs.getString(3)));

        // System.out.println(plato.toString());

      }

    } catch (NumberFormatException | SQLException e) {

      System.out.println("Clase BebidaDAO: " + e);

      if (!exist) {
        System.out.println("No existe el elemento");
      }
    }

    return bebida;
  }

  public static boolean setBebida(String idBebida, String nombre, double precio) {

    boolean aniadido = false; //quitar
    boolean repetido = false;

    conexion conex = new conexion();
    Connection con = conex.conectar();

    try {
      String sqlQuery = "SELECT count(*) FROM bebidas";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);
      rs.next();

      int numeroBebidas = rs.getInt(1);

      for (int i = 1; i <= numeroBebidas; i++) {

        if (getBebida(i + "").getNombre().equals(nombre) || getBebida(i + "").getIdBebida().equals(idBebida)) {
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
      ps = con.prepareStatement("INSERT INTO bebidas VALUES (?,?,?)");
      ps.setString(1, idBebida);
      ps.setString(2, nombre);
      ps.setDouble(3, precio);
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

  public int getNumBebidas(){

    conexion conex = new conexion();
    Connection con = conex.conectar();
    int numeroBebidas=0;

    try {
      String sqlQuery = "SELECT count(*) FROM bebidas";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);
      rs.next();
      numeroBebidas = rs.getInt(1);

    } catch (NumberFormatException | SQLException e) {

      System.out.println("Error getNumMenus"+" "+e);
    }

    return numeroBebidas;
  }

  public static void main(String[] args) {
    
  }
}

package modelo.DAO;

import java.sql.*;
import modelo.VO.platosVO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import modelo.conexion;

public class PlatosDAO {

  public static platosVO getPlato(String idPlato) {

    conexion conex = new conexion();
    Connection con = conex.conectar();
    platosVO plato = new platosVO();

    boolean exist = false;

    try {

      String sqlQuery = "SELECT * FROM platos WHERE idPlato= " + idPlato + " ";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);

      if (rs.next()) {
        exist = true;
        plato.setIdPlato(rs.getString(1));
        plato.setNombre(rs.getString(2));
        plato.setPrecio(Float.parseFloat(rs.getString(3)));

      }

    } catch (NumberFormatException | SQLException e) {

      System.out.println("Clase pedidosDAO: " + e);

      if (!exist) {
        System.out.println("No existe el elemento");
      }
    }

    return plato;
  }

  public static boolean setPlatos(String idPlato, String nombre, double precio) {
    boolean aniadido = false;
    boolean repetido = false;

    conexion conex = new conexion();
    Connection con = conex.conectar();

    platosVO plato = new platosVO();
    plato.setIdPlato(idPlato);
    plato.setNombre(nombre);
    plato.setPrecio(precio);

    try {
      String sqlQuery = "SELECT count(*) FROM Platos";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);

      int numeroPlatos = rs.getInt(1);

      for (int i = 1; i <= numeroPlatos; i++) {

        if (getPlato(i + "").getNombre() == nombre) {

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
      ps = con.prepareStatement("INSERT INTO Platos VALUES (?,?,?)");
      ps.setString(1, idPlato);
      ps.setString(2, nombre);
      ps.setDouble(3, precio);
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
        JOptionPane.showMessageDialog(null, "No se ha podido realizar la conexion");
      }
    }

    return aniadido;
  }


  public int getNumPlatos(){

    conexion conex = new conexion();
    Connection con = conex.conectar();
    int numeroPlatos=0;

    try {
      String sqlQuery = "SELECT count(*) FROM platos";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);
      rs.next();
      numeroPlatos = rs.getInt(1);

    } catch (NumberFormatException | SQLException e) {

      System.out.println("Error getNumPlatos"+" "+e);
    }

    return numeroPlatos;
  }

  public static void main(String[] args) {

  }
}

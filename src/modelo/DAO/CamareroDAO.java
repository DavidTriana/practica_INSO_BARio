package modelo.DAO;

import java.sql.*;
import modelo.VO.camareroVO;

import modelo.conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class CamareroDAO {

  public static camareroVO getCamarero(String idCamarero) {
    conexion conex = new conexion();
    Connection con = conex.conectar();
    camareroVO camarero = new camareroVO();
    boolean exist = false;
    try {

      String sqlQuery = "select * from camareros where idCamarero= " + idCamarero + " ";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);

      if (rs.next()) {
        exist = true;
        camarero.setIdCamarero(rs.getString(1));
        camarero.setNombre(rs.getString(2)); /* Cambiar si se cambian el nombre de las columnas */

        /*
         * Pruebas de funcionamiento
         * System.out.println("Id del camarero: " + camarero.getIdPlato());
         * System.out.println("Nombre del camarero: " + camarero.getNombre());
         */
      }
    } catch (NumberFormatException | SQLException e) {

      System.out.println("Clase CamareroDAO: " + e);

      if(!exist){
        System.out.println("No existe el elemento");
    }

    }

    return camarero;
  }

  public static boolean setCamarero(String idCamarero, String nombre) {

    boolean aniadido = false; //quitar
    boolean repetido = false;

    conexion conex = new conexion();
    Connection con = conex.conectar();

    try {
      String sqlQuery = "SELECT count(*) FROM camareros";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);
      rs.next();

      int numeroBebidas = rs.getInt(1);

      for (int i = 1; i <= numeroBebidas; i++) {

        if (getCamarero(i + "").getNombre().equals(nombre) || getCamarero(i + "").getIdCamarero().equals(idCamarero)) {
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
      ps = con.prepareStatement("INSERT INTO camareros VALUES (?,?)");
      ps.setString(1, idCamarero);
      ps.setString(2, nombre);
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

  public static void main(String[] args) {
    
  }
}

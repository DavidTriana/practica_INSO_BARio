package modelo.DAO;

import java.sql.*;

import javax.swing.JOptionPane;

import modelo.VO.cocineroVO;

import modelo.conexion;

public class CocineroDAO {

  public static cocineroVO getCocinero(String idCocinero) {
    conexion conex = new conexion();
    Connection con = conex.conectar();
    cocineroVO cocinero = new cocineroVO();
    boolean exist = false;
    try {

      String sqlQuery = "select * from Cocineros where idCocinero= " + idCocinero + " ";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);

      if (rs.next()) {
        exist = true;
        cocinero.setIdCocinero(rs.getString(1));
        cocinero.setNombre(rs.getString(2)); /* Cambiar si se cambian el nombre de las columnas */

        /*
         * Pruebas de funcionamiento
         * System.out.println("Id del cocinero: " + cocinero.getIdcocinero());
         * System.out.println("Nombre del cocinero: " + cocinero.getNombre());
         */
      }
    } catch (NumberFormatException | SQLException e) {

      System.out.println("Clase CocineroDAO: " + e);

      if(!exist){
        System.out.println("No existe el elemento");
      }

    }

    return cocinero;
  }

  public static void setCocinero(String idCocinero, String nombre){

    boolean repetido = false;

    conexion conex = new conexion();
    Connection con = conex.conectar();

    try {
      String sqlQuery = "SELECT count(*) FROM cocineros";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);
      rs.next();

      int numeroCocineros = rs.getInt(1);

      for (int i = 1; i <= numeroCocineros; i++) {

        if (getCocinero(i + "").getNombre().equals(nombre) || getCocinero(i + "").getIdCocinero().equals(idCocinero)) {
          repetido = true;
          throw new SQLException();
        }

      }

    } catch (NumberFormatException | SQLException e) {

      if (repetido) {
        JOptionPane.showMessageDialog(null, "El cocinero ya está en la base de datos o el id esta repetido." + e);
      }
    }


    PreparedStatement ps = null;

    try {
      ps = con.prepareStatement("INSERT INTO cocineros VALUES (?,?)");
      ps.setString(1, idCocinero);
      ps.setString(2, nombre);
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

  public static void main(String[] args) {
    
  }
}

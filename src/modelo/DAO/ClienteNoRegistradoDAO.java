package modelo.DAO;

import java.sql.*;
import modelo.VO.clienteNoRegistradoVO;

import modelo.conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

import java.util.LinkedList;
import javax.imageio.metadata.IIOMetadataFormatImpl;

public class ClienteNoRegistradoDAO {

    public static clienteNoRegistradoVO getClienteNoRegistrado(String correoCliente) {

        conexion conex = new conexion();
        Connection con = conex.conectar();
        clienteNoRegistradoVO cliente = new clienteNoRegistradoVO();
        boolean exist = false;

        try {
            String sqlQuery = "select * from mydb.usuariosnoregistrados where email='" + correoCliente + "' "; 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);
            if (rs.next()) {
                exist = true;
                cliente.setCorreoCliente(rs.getString("email"));
                cliente.setNombreCliente(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellidos")); /* cambiar si se cambian los nombres en la base de datos*/
              

            }
        } catch (NumberFormatException | SQLException e) {

                System.out.println("Clase ClienteNoRegistradoDAO error");

                if(!exist){
                    System.out.println("No existe el elemento");
                }
        }

        return cliente;
    }

    public static boolean setClienteNoRegistrado(String email, String nombre, String apellidos) {

    boolean aniadido = false; //quitar
    boolean repetido = false;

    conexion conex = new conexion();
    Connection con = conex.conectar();
  
    try {
      String sqlQuery = "SELECT count(*) FROM usuariosNoRegistrados";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);
      rs.next();

      int numeroClientesNoReg = rs.getInt(1);


      LinkedList<String> listaCorreos = new LinkedList<String>();
      
      Connection conAux = conex.conectar();
      String queryAux = "select email from mydb.usuariosnoregistrados"; 
      Statement stAux = conAux.createStatement();
      ResultSet rsAux = stAux.executeQuery(queryAux);
      

      for(int i=0; i<numeroClientesNoReg; i++){
        
        rsAux.next();

        listaCorreos.add(rsAux.getString(1));
        
      }     

      for (int i = 1; i <= numeroClientesNoReg; i++) {

        if (getClienteNoRegistrado(listaCorreos.get(i-1)).getCorreoCliente().equals(email)) {
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
      ps = con.prepareStatement("INSERT INTO usuariosNoRegistrados VALUES (?,?,?)");
      ps.setString(1, email);
      ps.setString(2, nombre);
      ps.setString(3, apellidos); 
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
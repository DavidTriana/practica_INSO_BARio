package modelo.DAO;

import java.sql.*;

import javax.swing.JOptionPane;

import modelo.conexion;
import modelo.VO.clienteRegistradoVO;

public class ClienteRegistradoDAO {

    public static clienteRegistradoVO getClienteRegistrado(String idUsuario) {

        conexion conex = new conexion();
        Connection con = conex.conectar();
        clienteRegistradoVO cliente = new clienteRegistradoVO();
        boolean exist = false;

        try {
            String sqlQuery = "select * from usuariosregistrados where idUsuario=" + idUsuario + " ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);
            if (rs.next()) {
                exist = true;
                cliente.setId(rs.getString("idUsuario"));
                cliente.setNombreCliente(rs.getString("nombre"));
                cliente.setApellidoCliente(rs.getString("apellidos")); /* cambiar si se cambian los nombres en la base de datos*/
                cliente.setCorreoCliente(rs.getString("email"));
                cliente.setContrasenia(rs.getString("contraseña"));
                cliente.setCuentaBanco(rs.getString("numeroTarjeta")); /*Cambiar si se cambian el nombre de las columnas*/
                cliente.setPedidosAnteriores(rs.getString("pedidosAnteriores"));

            }

        } catch (NumberFormatException | SQLException e) {

            System.out.println("Error ClienteRegistradoDAO"+e);

            if(!exist){
                System.out.println("No existe el elemento");
            }
        }

        return cliente;
    }

    public static clienteRegistradoVO getClienteRegistradoEmail(String email) {

      conexion conex = new conexion();
      Connection con = conex.conectar();
      clienteRegistradoVO cliente = new clienteRegistradoVO();
      boolean exist = false;

      try {
          String sqlQuery = "select * from usuariosregistrados where idUsuario=" + email + " ";
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(sqlQuery);
          if (rs.next()) {
              exist = true;
              cliente.setId(rs.getString("idUsuario"));
              cliente.setNombreCliente(rs.getString("nombre"));
              cliente.setApellidoCliente(rs.getString("apellidos")); /* cambiar si se cambian los nombres en la base de datos*/
              cliente.setCorreoCliente(rs.getString("email"));
              cliente.setContrasenia(rs.getString("contraseña"));
              cliente.setCuentaBanco(rs.getString("numeroTarjeta")); /*Cambiar si se cambian el nombre de las columnas*/
              cliente.setPedidosAnteriores(rs.getString("pedidosAnteriores"));

          }

      } catch (NumberFormatException | SQLException e) {

          System.out.println("Error ClienteRegistradoDAO"+e);

          if(!exist){
              System.out.println("No existe el elemento");
          }
      }

      return cliente;
  }

    public static void setClienteRegistrado(String id, String nombreCliente, String apellidoCliente, 
                                        String email, String cuentaBanco, String contrasenia, String pedidosAnteriores){
        
        boolean repetido = false;

        conexion conex = new conexion();
        Connection con = conex.conectar();

        try {
            String sqlQuery = "SELECT count(*) FROM usuariosregistrados";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlQuery);
            rs.next();
      
            int numeroBebidas = rs.getInt(1);
      
            for (int i = 1; i <= numeroBebidas; i++) {
      
              if (getClienteRegistrado(i + "").getCorreoCliente().equals(email) || getClienteRegistrado(i + "").getId().equals(id)) {
                repetido = true;
                throw new SQLException();
              }
      
            }
      
          } catch (NumberFormatException | SQLException e) {
      
            if (repetido) {
              JOptionPane.showMessageDialog(null, "El cliente ya está registrado en la base de datos." + e);
            }
          }

          PreparedStatement ps = null;

          try {
            ps = con.prepareStatement("INSERT INTO usuariosregistrados VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, id);
            ps.setString(2, nombreCliente);
            ps.setString(3, apellidoCliente);
            ps.setString(4, email);
            ps.setString(5, contrasenia);
            ps.setString(6, cuentaBanco);
            ps.setString(7, pedidosAnteriores);
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

    public int getNumClientesRegistrados(){

    conexion conex = new conexion();
    Connection con = conex.conectar();
    int numeroClientes=0;

    try {
      String sqlQuery = "SELECT count(*) FROM usuariosregistrados";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);
      rs.next();
      numeroClientes = rs.getInt(1);

    } catch (NumberFormatException | SQLException e) {

      System.out.println("Error getNumClientesRegistrados"+" "+e);
    }

    return numeroClientes;
  }
    
  public String getPedidosAnteriores(String idCliente){

    conexion conex = new conexion();
    Connection con = conex.conectar();
    String pedidosAnteriores="";

    try {
      String sqlQuery = "SELECT pedidosAnteriores(*) FROM usuariosregistrados WHERE idUsuario="+idCliente+" ";
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sqlQuery);
      rs.next();
      pedidosAnteriores = rs.getString(1);

    } catch (NumberFormatException | SQLException e) {

      System.out.println("Error getPedidosAnteriores"+" "+e);
    }

    return pedidosAnteriores;
  }
  
  public void setPedidosAnteriores(String idCliente, String nuevoPedido){

    conexion conex = new conexion();
    Connection con = conex.conectar();
    String pedidosAnteriores="";

    try {
      pedidosAnteriores = getPedidosAnteriores(idCliente);
      
      pedidosAnteriores = pedidosAnteriores + "|" + nuevoPedido;
      String sqlQuery = "UPDATE usuariosregistrados set pedidosanteriores=" +pedidosAnteriores+ " where idUsuario=" +idCliente;
      Statement st = con.createStatement();
      st.executeUpdate(sqlQuery);
      
    } catch (NumberFormatException | SQLException e) {

      System.out.println("Error setPedidosAnteriores"+" "+e);
    }

  }


    //podemos hacer que el set ponga los id automaticos

    public static void main(String[] args) {
        
        
    }

}
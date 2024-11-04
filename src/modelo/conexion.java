package modelo;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gueps
 */
public class conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = ""; // the database name
    private static final String USER = ""; // your mysql user
    private static final String PASSWORD = ""; //user's pass
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    Connection cx;
    
    public static void main(String[] args){
        try {
            Class.forName(DRIVER);

            try (Connection conexion = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
                if (!existDatabase(conexion)) {
                    System.out.println("La base de datos no existe.");
                    createDatabase(conexion);
                } 
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Connection conectar(){
        try{
            //Carga el controlador de MySQL
            Class.forName(DRIVER);
            cx = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("conectó bien");
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.out.println("Fallo al conectar a la BBDD");
        }
        return cx;
    }
    
    public void desconectar(){
         try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean existDatabase(Connection connection) throws SQLException{
        try(Statement stmt = connection.createStatement()){
            String queryExist = "SHOW DATABASES LIKE '" + DATABASE_NAME + "'";
            return stmt.executeQuery(queryExist).next();
        }
    }
    
    public static void createDatabase(Connection connection) throws SQLException{
     try(Statement stmt = connection.createStatement()){
         String queryCreateDB = "CREATE DATABASE " + DATABASE_NAME;
         stmt.executeUpdate(queryCreateDB);
         createBebidasTable(connection);
         createPlatosTable(connection);
         createPagosTable(connection);
         createMenuTable(connection);
         createCamarerosTable(connection);
         createCocinerosTable(connection);
         createClienteRegistradoTable(connection);
         createClienteNoRegistradoTable(connection);
         createPedidosTable(connection);
         System.out.println("Base de datos creada correctamente");
     }   
    }
    
    public static void createBebidasTable(Connection connection) throws SQLException{
        try(Statement stmt = connection.createStatement()) {
            String queryBebidas = 
                """
                CREATE TABLE `BariIODB`.`bebidas` (
                `idBebidas` INT NOT NULL,
                `Nombre` VARCHAR(45) NULL,
                `Precio` DOUBLE NULL,
                PRIMARY KEY (`idBebidas`));"""; 
            stmt.executeUpdate(queryBebidas);
            System.out.println("Tabla bebidas creadas");
        }
    }
    
    public static void createPlatosTable(Connection connection) throws SQLException{
        try(Statement stmt = connection.createStatement()) {
            String queryPlatos = 
                """
                CREATE TABLE `BariIODB`.`platos` (
                `idPlatos` INT NOT NULL,
                `Nombre` VARCHAR(45) NULL,
                `Precio` DOUBLE NULL,
                PRIMARY KEY (`idPlatos`));"""; 
            stmt.executeUpdate(queryPlatos);
             System.out.println("Tabla platos creadas");
        }
    }
    
    public static void createPagosTable(Connection connection) throws SQLException{
        try(Statement stmt = connection.createStatement()) {
            String queryPagos =
                """
                CREATE TABLE `BariIODB`.`pagos` (
                `idPagos` INT NOT NULL,
                `idPedido` VARCHAR(45) NULL,
                `Precio` DOUBLE NULL,
                `numTarjeta` VARCHAR(45) NULL,
                `fecha` VARCHAR(45) NULL,
                PRIMARY KEY (`idPagos`));"""; 
            stmt.executeUpdate(queryPagos);
             System.out.println("Tabla pagos creadas");
        }
    }
    
    public static void createMenuTable(Connection connection) throws SQLException{
        try(Statement stmt = connection.createStatement()) {
            String queryMenu = 
                    """
                    CREATE TABLE `BariIODB`.`menu` (
                    `idMenu` INT NOT NULL,
                    `fecha` VARCHAR(45) NULL,
                    `idPlato` VARCHAR(45) NULL,
                    `idBebida` VARCHAR(45) NULL,
                    `idCocinero` VARCHAR(45) NULL,
                    PRIMARY KEY (`idMenu`));"""; 
            stmt.executeUpdate(queryMenu);
             System.out.println("Tabla menu creadas");
        }
    }
    
    public static void createCamarerosTable(Connection connection) throws SQLException{
        try(Statement stmt = connection.createStatement()) {
            String queryCamarero =
                    """
                    CREATE TABLE `BariIODB`.`camarero` (
                    `idCamarero` INT NOT NULL,
                    `nombre` VARCHAR(45) NULL,
                    PRIMARY KEY (`idCamarero`));"""; 
            stmt.executeUpdate(queryCamarero);
             System.out.println("Tabla camarero creadas");
        }
    }
    
    public static void createCocinerosTable(Connection connection) throws SQLException{
        try(Statement stmt = connection.createStatement()) {
            String queryCocinero = """
                                   CREATE TABLE `BariIODB`.`cocinero` (
                                     `idcocinero` INT NOT NULL,
                                     `nombre` VARCHAR(45) NULL,
                                     PRIMARY KEY (`idcocinero`));"""; 
            stmt.executeUpdate(queryCocinero);
             System.out.println("Tabla Cocinero creadas");
        }
    }
    
    public static void createClienteRegistradoTable(Connection connection) throws SQLException{
        try(Statement stmt = connection.createStatement()) {
            String queryClienteReg = """
                                     CREATE TABLE `BariIODB`.`clientereg` (
                                       `idclienteReg` INT NOT NULL,
                                       `nombre` VARCHAR(45) NULL,
                                       `apellido` VARCHAR(45) NULL,
                                       `email` VARCHAR(45) NULL,
                                       `contrase\u00f1a` VARCHAR(45) NULL,
                                       `cuentaBanco` VARCHAR(45) NULL,
                                       `pedidosAnteriores` VARCHAR(45) NULL,
                                       PRIMARY KEY (`idclienteReg`));"""; 
            stmt.executeUpdate(queryClienteReg);
             System.out.println("Tabla Clientes registrados creadas");
        }
    }
    
    public static void createClienteNoRegistradoTable(Connection connection) throws SQLException{
        try(Statement stmt = connection.createStatement()) {
            String queryCLienteNoRegistrado = """
                                              CREATE TABLE `BariIODB`.`clientenoreg` (
                                                `email` INT NOT NULL,
                                                `nombre` VARCHAR(45) NULL,
                                                `apellido` VARCHAR(45) NULL,
                                                 PRIMARY KEY (`email`));"""; 
            stmt.executeUpdate(queryCLienteNoRegistrado);
             System.out.println("Tabla Clientes No Registrados creadas");
        }
    }
    
    public static void createPedidosTable(Connection connection) throws SQLException{
        try(Statement stmt = connection.createStatement()) {
            String queryPedidos = """
                                  CREATE TABLE `BariIODB`.`pedidos` (
                                    `idPedidos` INT NOT NULL,
                                    `Precio` DOUBLE NULL,
                                    `Fecha` VARCHAR(45) NULL,
                                    `Hora` VARCHAR(45) NULL,
                                    `esCompletado` TINYINT NULL,
                                    `esPagado` TINYINT NULL,
                                    `idCliente` VARCHAR(45) NULL,
                                    `email` VARCHAR(45) NULL,
                                    `idCamarero` VARCHAR(45) NULL,
                                    `idMenu` VARCHAR(45) NULL,
                                    PRIMARY KEY (`idPedidos`));"""; 
            stmt.executeUpdate(queryPedidos);
            System.out.println("Tabla Pedidos creadas");
        }
    }
    
}

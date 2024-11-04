package controlador;
import modelo.DAO.*;
import vista.*;





public class ControladorMaestro {

    static InterfazCliente ventanaCliente;


    static InterfazCamarero ventanaCamarero;

    static CamareroDAO camarero= new CamareroDAO();
    static ClienteNoRegistradoDAO clienteNoRegistrado = new ClienteNoRegistradoDAO();
    static ClienteRegistradoDAO clienteRegistrado = new ClienteRegistradoDAO();
    static CocineroDAO cocinero = new CocineroDAO();
    static MenuDAO menu = new MenuDAO();
    static PagosDAO pago = new PagosDAO();
    static PedidosDAO pedido = new PedidosDAO();
    static PlatosDAO platos = new PlatosDAO();
    static BebidaDAO bebida = new BebidaDAO();




    

    public static void main(String[] args) {

    
        /*-----------------------PRUEBA DE DATABASE-----------------------*/
        
        System.out.println(camarero.getCamarero("1").toString());
        System.out.println("\n");
        System.out.println(clienteNoRegistrado.getClienteNoRegistrado("juan@gmail.com").toString());
        System.out.println("\n");
        System.out.println(clienteRegistrado.getClienteRegistrado("1").toString());
        System.out.println("\n");
        System.out.println(cocinero.getCocinero("1").toString());
        System.out.println("\n");
        System.out.println(menu.getMenu("1").toString());
        System.out.println("\n");
        System.out.println(pago.getPago("1").toString());
        System.out.println("\n");
        System.out.println(pedido.getPedidos("1").toString());
        System.out.println("\n");
        System.out.println(platos.getPlato("1").toString());
        System.out.println("\n");
        System.out.println(bebida.getBebida("1").toString());
        
       

        /*
        InterfazPrimeraCliente primeraInterfaz = new InterfazPrimeraCliente();
        ControladorPrimeraCliente primerControlador = new ControladorPrimeraCliente(primeraInterfaz);
        primeraInterfaz.setControlador(primerControlador);
        */

        /*

    
        InterfazCocinero interfaz = new InterfazCocinero();
        ControladorCocinero controlador = new ControladorCocinero(interfaz);
        interfaz.setControlador(controlador);
        interfaz.setVisible(true);

        */

    
        /* 

        InterfazPrincipal interPrincipal = new InterfazPrincipal();
        ControladorPrincipal controladorInterPrincipal = new ControladorPrincipal(interPrincipal);
        interPrincipal.setControlador(controladorInterPrincipal);
        interPrincipal.setVisible(true);

        */

       
        InterfazPrincipal interPrincipal = new InterfazPrincipal();
        ControladorPrincipal controladorInterPrincipal = new ControladorPrincipal(interPrincipal);
        interPrincipal.setControlador(controladorInterPrincipal);
        interPrincipal.setVisible(true);
        
        
         /*
        InterfazCliente interPrincipal = new InterfazCliente();
        ControladorCliente controladorInterPrincipal = new ControladorCliente(interPrincipal);
        interPrincipal.setControlador(controladorInterPrincipal);
        interPrincipal.setVisible(true);
        */
        

        //falta cerrar interfaz al abrir la nueva



        
    }
    

    
}

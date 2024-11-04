package controlador;


import modelo.DAO.*;
import modelo.VO.*;
import vista.*;

import java.awt.*;  
import java.awt.event.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;  

public class ControladorCamarero implements ActionListener {

    private InterfazCamarero vista;
    public PedidosDAO pedidos = new PedidosDAO();
    public MenuDAO menus=new MenuDAO();
    public PlatosDAO platos=new PlatosDAO();
    public BebidaDAO bebidas=new BebidaDAO();

    private String pedidoSelecciconado="0";

    public ControladorCamarero (InterfazCamarero interfaz){ 

        this.vista = interfaz;
        
        initComponents();

        String[] fila={"", "", "", ""}; 
        //"ID", "Precio", "Fecha", "Consumiciones"

        DefaultTableModel model = (DefaultTableModel) vista.tablaPedidosCam.getModel(); 
            
        for(int i=1; i<pedidos.getNumPedidos()+1;i++){
            
            pedidosVO pedido=pedidos.getPedidos(i+"");

            fila[0]=pedido.getIdPedido(); 
            fila[1]=pedido.getPrecio()+"";
            fila[2]=pedido.getFecha();
            fila[3]="Menu "+pedido.getIdMenu();

            model.addRow(fila);

            // if escompletado= FALSE entonces esta coloreado en rojo
  
        }
          
    }

    public void actualizarTablaPedidos(){

        String[] fila={"", "", "", ""}; 
        //"ID", "Precio", "Fecha", "Consumiciones"

        DefaultTableModel model = (DefaultTableModel) vista.tablaPedidosCam.getModel(); 
            
        int numeroFilas = model.getRowCount();

        for(int i=1; i<numeroFilas+1; i++){

            model.removeRow(i);
        }

        for(int i=1; i<pedidos.getNumPedidos()+1;i++){
            
            pedidosVO pedido=pedidos.getPedidos(i+"");
            
            if (pedido.esPagado == true){
            
                            
            fila[0]=pedido.getIdPedido(); 
            fila[1]=pedido.getPrecio()+"";
            fila[2]=pedido.getFecha();
            fila[3]="Menu "+pedido.getIdMenu();

            model.addRow(fila);
                
            }
            // if escompletado= FALSE entonces esta coloreado en rojo
  
        }
    }

    //Evento de la tabla para comprobar estado del pedido - se activa cuando clicas sobre la tabla
    public void comprobadorCompletado(MouseEvent evt) {
 
        int seleccion = vista.tablaPedidosCam.rowAtPoint(evt.getPoint());

        String idPedido = String.valueOf(vista.tablaPedidosCam.getValueAt(seleccion, 0));

        System.out.println(idPedido+" id");
        
       

        pedidosVO pedido=pedidos.getPedidos(idPedido);

        
        System.out.println(pedido.isEsCompletado()+" completado");

        pedidoSelecciconado=idPedido; //para utilizar en el boton "completar pedido"

        if(!pedido.isEsCompletado()){
            //pedidos.setPedido(pedido.getIdPedido(), (double) pedido.getPrecio(), pedido.getFecha(), pedido.getHora(), true, pedido.isEsPagado(), pedido.getIdUsuario(), pedido.getEmail(), pedido.getIdCamarero(), pedido.getIdMenu());
            vista.jLabelEstadoPedido.setText("No completado");
        }else{
            vista.jLabelEstadoPedido.setText("Completado");
        }

 
    }

    public void actionPerformed(ActionEvent evento){



    }


    public void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO VOLVER A ELECCION DE PERSONAJE
        
        InterfazPrincipal interPrincipal = new InterfazPrincipal();
        ControladorPrincipal controladorInterPrincipal = new ControladorPrincipal(interPrincipal);
        interPrincipal.setControlador(controladorInterPrincipal);
        interPrincipal.setVisible(true);
        vista.setVisible(false);
    }                                           

    public void botonEntregadoActionPerformed(java.awt.event.ActionEvent evt) {   

        pedidos.updateEntregadoPedido(pedidoSelecciconado);
        this.actualizarTablaPedidos();
    }
    
    public void initComponents() {
    
        vista.botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });  
    }




}
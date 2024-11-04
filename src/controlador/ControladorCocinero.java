package controlador;


import modelo.DAO.*;
import modelo.VO.*;
import vista.*;

import java.awt.*;  
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;  

public class ControladorCocinero implements ActionListener {

    private InterfazCocinero vista;
    public PedidosDAO pedidos=new PedidosDAO();
    public MenuDAO menus=new MenuDAO();
    public PlatosDAO platos=new PlatosDAO();
    public BebidaDAO bebidas=new BebidaDAO();


    //private boolean comprobacionCompletado=false;
    private String pedidoSelecciconado="0";

    public ControladorCocinero (InterfazCocinero interfaz){ 

        this.vista = interfaz;
        initComponents();
        
        System.out.println("Pedidos que hay: "+ pedidos.getNumPedidos());

        String[] fila={"", "", "", ""}; 
        //"ID", "Precio", "Fecha", "Consumiciones"
        DefaultTableModel model = (DefaultTableModel) vista.tablaPedidosCocinero.getModel(); 

        for(int i=1; i<pedidos.getNumPedidos()+1;i++){
            
            pedidosVO pedido=pedidos.getPedidos(i+"");

            fila[0]=pedido.getIdPedido(); 
            fila[1]=pedido.getPrecio()+"";
            fila[2]=pedido.getFecha();
            fila[3]="Menu "+pedido.getMenus();

            model.addRow(fila);

            // if escompletado= FALSE entonces esta coloreado en rojo
  
        }

        
    }


    public void actionPerformed(ActionEvent evento){



    }
    
    
    
    //---------------METERLE METODO INIT COMMPONENTS A TODO ------------
    
    public void initComponents(){
        
        
      vista.botonEditaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditaMenuActionPerformed(evt);
            }
        });  
      

       vista.botonPedidoCompletadoCocinero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedidoCompletadoCocineroActionPerformed(evt);
            }
        });  
       

       vista.botonEliminarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarMenuActionPerformed(evt);
            }
        });
       
        vista.botonAñadirMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirMenu1ActionPerformed(evt);
            }
        });
        
        vista.botonAñadirMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirMenuActionPerformed(evt);
            }
        });

        vista.tablaPedidosCocinero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comprobadorCompletado(evt);
            }
         });
         vista.botonVolverPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverPedidosActionPerformed(evt);
            }
        });


        vista.botonVolverEdicionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverEdicionMenuActionPerformed(evt);
            }
        });
        
        
      
        
        
    }
    
    
    

    public void actualizarTablaMenus(){

        //metodo para mostrar en la tabla todos los menus que hay
        String[] fila={"", "", "", ""}; 
        //"ID menu", "platos", "bebidas", "precio"
        DefaultTableModel model = (DefaultTableModel) vista.tablaCocineroMenu.getModel(); 
        
        for(int i=1; i<menus.getNumMenus()+1;i++){
            
            menuVO menu=menus.getMenu(i+"");

            if(!menu.getFecha().equals("0")){

                platosVO plato =platos.getPlato(menu.getIdPlato());
                bebidasVO bebida = bebidas.getBebida(menu.getIdBebida());
    
                fila[0]=menu.getIdMenu(); 
                fila[1]= plato.getNombre();//buscar plato y hacerle toString
                fila[2]=bebida.getNombre();
                fila[3]=plato.getPrecio()+bebida.getPrecio()+" ";
    
                model.addRow(fila);

            }
        }
    }
    
    //------------------------------------------PANEL PEDIDOS------------------------------------------------

    public void botonEditaMenuActionPerformed(java.awt.event.ActionEvent evt) {

        
        this.vista.panelPedidoCocinero.setVisible(false);
        vista.setSize(949, 630);
        this.vista.panelEditarMenu.setVisible(true);

        //RELLENAR TABLA CON LOS MENUS EXISTENTES **menos las que tengan de fecha 0**

        actualizarTablaMenus();
  
        
  
    }//GEN-LAST:event_botonEditaMenuActionPerformed


    //Evento de la tabla para comprobar estado del pedido - se activa cuando clicas sobre la tabla
    public void comprobadorCompletado(MouseEvent evt) {//GEN-FIRST:event_botonVolverPedidosActionPerformed
 
        int seleccion = vista.tablaPedidosCocinero.rowAtPoint(evt.getPoint());

        String idPedido = String.valueOf(vista.tablaPedidosCocinero.getValueAt(seleccion, 0));

        System.out.println(idPedido+" id");
        
       

        pedidosVO pedido=pedidos.getPedidos(idPedido);

        
        System.out.println(pedido.isEsCompletado()+" completado");

        pedidoSelecciconado=idPedido; //para utilizar en el boton "completar pedido"

        if(!pedido.isEsCompletado()){
            vista.labelCompletado.setText("No completado");
        }else{
            vista.labelCompletado.setText("Completado");
        }

 
    }

    //Evento para cambiar pedido a completado
    public void botonPedidoCompletadoCocineroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedidoCompletadoCocineroActionPerformed

        pedidos.updateCompletadoPedido(true, pedidoSelecciconado);

        System.out.println(pedidos.getPedidos(pedidoSelecciconado).isEsCompletado()+ " botonActualizazr");

    }//GEN-LAST:event_botonPedidoCompletadoCocineroActionPerformed




    //----------------------------------------------FIN DE JPANEL PEDIDOS-------------------------------------------



    //------------------------------------------------PANEL EDITAR MENU----------------------------------------------
 
    private void botonVolverPedidosActionPerformed(java.awt.event.ActionEvent evt) {   
        

        InterfazPrincipal interPrincipal = new InterfazPrincipal();
        ControladorPrincipal controladorInterPrincipal = new ControladorPrincipal(interPrincipal);
        interPrincipal.setControlador(controladorInterPrincipal);
        interPrincipal.setVisible(true);
        vista.setVisible(false);
    } 
    
    public void botonVolverEdicionMenuActionPerformed(java.awt.event.ActionEvent evt) {
                
        this.vista.panelEditarMenu.setVisible(false);
        vista.setSize(900, 770);
        this.vista.panelPedidoCocinero.setVisible(true);

        //BORRAR CONTENIDO DE LA TABLA MENU
        DefaultTableModel model = (DefaultTableModel) vista.tablaCocineroMenu.getModel();

        model.getDataVector().removeAllElements();
        vista.tablaCocineroMenu.updateUI();

        

    }



    public void botonAñadirMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirBebidaActionPerformed
        
        //boton check para confirmar

        int numMenus=menus.getNumMenus();

        Calendar fechaActual = Calendar.getInstance();
        String cadenaFecha = String.format("%04d-%02d-%02d",
          fechaActual.get(Calendar.YEAR),
          fechaActual.get(Calendar.MONTH)+1,
          fechaActual.get(Calendar.DAY_OF_MONTH));

        //creamos el plato

        int numPlatos=platos.getNumPlatos();
        platos.setPlatos(numPlatos+1+"", vista.entradaNombrePlato.getText(), Double.parseDouble(vista.entradaprecioplato.getText()));

        //creamos la bebida

        int numBebidas=bebidas.getNumBebidas();
        bebidas.setBebida(numBebidas+1+"", vista.entradaNombreBebida.getText(), Double.parseDouble(vista.entradaPreciobebida.getText()));


        menus.setMenu((numMenus+1)+"",cadenaFecha , numPlatos+1+"", numBebidas+1+"", 1+"");

        //borrar anteriores elementos de la tabla
        DefaultTableModel model = (DefaultTableModel) vista.tablaCocineroMenu.getModel();

        model.getDataVector().removeAllElements();
        vista.tablaCocineroMenu.updateUI();


        //actualizar tabla de menu.
        actualizarTablaMenus();

        //cerrar pestaña y volver a menu

        this.vista.panelNuevoMenu.setVisible(false);  
        vista.setSize(949, 630);
        this.vista.panelEditarMenu.setVisible(true);
        

        //cerrar ventana y volver a editar menu y actualizar lista de menu
    }//GEN-LAST:event_botonAñadirBebidaActionPerformed

    public void botonEliminarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarMenuActionPerformed
        
        //eliminarmenu

        int seleccion = vista.tablaCocineroMenu.getSelectedRow();

        if(seleccion!=-1){
            String idMenu = String.valueOf(vista.tablaCocineroMenu.getValueAt(seleccion, 0));
            
            /* NO ELIMINAR DE LA BASE DE DATOS PORQUE SE NECESITA PARA PEDIDO
            
            //eliminar de la base de datos
            menus.removeMenu(idMenu);
            */

            menus.updateFechaMenu("0", idMenu);

            DefaultTableModel model = (DefaultTableModel) vista.tablaCocineroMenu.getModel();
            model.removeRow(seleccion);
        }

        




    }//GEN-LAST:event_botonEliminarMenuActionPerformed

    public void botonAñadirMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirMenu1ActionPerformed
        
        //abrir añadir menu

        this.vista.panelEditarMenu.setVisible(false);
        vista.setSize(375, 550);
        this.vista.panelNuevoMenu.setVisible(true);


    }//GEN-LAST:event_botonAñadirMenu1ActionPerformed

    public void entradaNombrePlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaNombrePlatoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entradaNombrePlatoActionPerformed
    

}
package controlador;

import modelo.DAO.*;
import modelo.VO.*;
import vista.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

public class ControladorCliente implements ActionListener {

    private InterfazCliente vista;
    public ClienteRegistradoDAO clienteReg = new ClienteRegistradoDAO();
    public ClienteNoRegistradoDAO clienteNoReg = new ClienteNoRegistradoDAO();
    public MenuDAO menu = new MenuDAO();

    public ArrayList<menuVO> listaCesta = new ArrayList<menuVO>();

    public String usuarioID;
    public String correoNoReg;
    public String correoReg;
    public double precioTotal;

    

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public ControladorCliente(InterfazCliente interfaz) {
        this.vista = interfaz;

        //iniciamos componentes

        vista.botonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarseActionPerformed(evt);
            }
        });

        vista.botonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarSesionActionPerformed(evt);
            }

        });

        vista.BotonNoRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNoRegistrarseActionPerformed(evt);
            }
        });

        vista.botonVolverInicS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverInicSActionPerformed(evt);
            }
        });

        vista.botonVolverReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverRegActionPerformed(evt);
            }
        });

        vista.botonVolverNoRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverNoRegisActionPerformed(evt);
            }
        });

        vista.botonInicS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInicSActionPerformed(evt);
            }
        });

        vista.botonRegReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegRegActionPerformed(evt);
            }
        });

        vista.botonEntrarNoRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEntrarNoRegisActionPerformed(evt);
            }
        });

        vista.botonVolverInterClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverInterClientActionPerformed(evt);
            }
        });

        vista.botonRealizarPedClienteReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRealizarPedClienteRegActionPerformed(evt);
            }
        });

        vista.botonRealizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRealizarPedidoActionPerformed(evt);
            }
        });

        vista.botonVolverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverMenuActionPerformed(evt);
            }
        });

        vista.botonAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadirActionPerformed(evt);
            }
        });
        vista.botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        vista.botonVerPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerPedidosActionPerformed(evt);
            }
        });
        vista.botonVolverPedidosAnteriores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverPedidosActionPerformed(evt);
            }
        });
        vista.botonRepetirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRepetirPedidoActionPerformed(evt);
            }
        });
        vista.botonVolverClienteReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverClienteRegActionPerformed(evt);
            }
        });

    }

    public void botonVolverClienteRegActionPerformed(java.awt.event.ActionEvent evt) {
        vista.panelPrincipalClienteReg.setVisible(false);
        vista.panelPrincipal.setVisible(true);
        
        this.correoReg = "";
    }

    public void botonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {

        vista.panelPrincipal.setVisible(false);         //Interfaz Registrase
        vista.panelRegistrarse.setVisible(true);

    }

    //fin
    public void botonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {
        vista.panelPrincipal.setVisible(false);
        vista.setSize(550, 550);
        vista.setLocationRelativeTo(null);
        vista.panelIniciarSesion.setVisible(true);      //Interfaz Iniciar Sesion
    }

    public void BotonNoRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {
        vista.panelPrincipal.setVisible(false);
        vista.panelNoRegistrarse.setVisible(true);      //Interfaz No Registrarse  
    }

    /*
     public void botonVolver2ActionPerformed(java.awt.event.ActionEvent evt) {                                             
    // TODO add your handling code here:
    }
     */
    public void botonVolverInicSActionPerformed(java.awt.event.ActionEvent evt) {
        vista.panelIniciarSesion.setVisible(false);
        vista.setSize(550, 550);                    //De Iniciar sesion a principal
        vista.setLocationRelativeTo(null);
        vista.panelPrincipal.setVisible(true);
        
        vista.emailField.setText("");
        vista.passwordField.setText("");
    }

    public void botonVolverRegActionPerformed(java.awt.event.ActionEvent evt) {
        vista.panelRegistrarse.setVisible(false);
        vista.setSize(550, 550);                  //De Registrarse a principal
        vista.setLocationRelativeTo(null);
        vista.panelPrincipal.setVisible(true);
        
        vista.nombreRegField.setText("");
        vista.ApellidoRegField.setText("");
        vista.emailRegField.setText("");
        vista.contraseniaRegField.setText("");
        vista.tarjetaField.setText("");
    }

    public void botonOkClienteNoRegActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void botonVolverNoRegisActionPerformed(java.awt.event.ActionEvent evt) {
        vista.panelNoRegistrarse.setVisible(false);
        vista.setSize(550, 550);                   //De NoRegistrarse a principal
        vista.setLocationRelativeTo(null);
        vista.panelPrincipal.setVisible(true);
                
        vista.nombreNoRegis.setText("");
        vista.apellidosNoregis.setText("");
        vista.emailNoRegis.setText("");
    }

    public void botonInicSActionPerformed(java.awt.event.ActionEvent evt) {             //Iniciar sesion en la app                                               

        //comprobar si el usuario metido existe 
        ClienteRegistradoDAO cliente = new ClienteRegistradoDAO();

        String email = vista.emailField.getText();
        String pass = new String(vista.passwordField.getPassword());
        boolean parar = false;

        for (int i = 1; i < cliente.getNumClientesRegistrados() + 1 && parar == false; i++) {

            if (cliente.getClienteRegistrado(i + "").getCorreoCliente().equals(email) && cliente.getClienteRegistrado(i + "").getContrasenia().equals(pass)) {

                //autenticacion exitosa
                parar = true;
                vista.panelIniciarSesion.setVisible(false);
                vista.setSize(550, 550);
                vista.panelPrincipalClienteReg.setVisible(true);
                this.usuarioID = i + "";
                correoReg = this.clienteReg.getClienteRegistradoEmail(this.usuarioID).getCorreoCliente();
                this.correoNoReg = "";
                
                
                vista.emailField.setText("");
                vista.passwordField.setText("");
              }

        }

        if (parar == false) {

            vista.emailField.setText("");
            vista.passwordField.setText("");
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");

        }

    }

    public void botonRealizarPedClienteRegActionPerformed(java.awt.event.ActionEvent evt) {

        //boton para acceder al panel de pedidos del cliente - se rellena la tabla de menus
        //no se añaden menus con fecha 0
        

        vista.panelPrincipalClienteReg.setVisible(false);

        vista.panelMenu.setVisible(true);
        
        
        String[] fila = {"", "", ""};

        DefaultTableModel model = (DefaultTableModel) vista.tablaMenu.getModel(); //FALTA COLOCAR JTABLE

        for (int j = 1; j < menu.getNumMenus() + 1; j++) {       //RELLENAR TABLA DE MENUS

            menuVO menus = menu.getMenu(j + "");

                fila = new String[]{"","",""};
            
                fila[2] = String.valueOf(menu.precioMenu(j + ""));
                fila[1] = menu.toStringConsumiciones(j + "");
                fila[0] = menus.getIdMenu();

                model.addRow(fila);


        }
        
    }

    public void botonAniadirActionPerformed(java.awt.event.ActionEvent evt) {

        //Añadir productos al panel de la cesta y a un array list para hacer el pedido
        int seleccion = vista.tablaMenu.getSelectedRow();

        if (seleccion != -1) {

            String idMenu = String.valueOf(vista.tablaMenu.getValueAt(seleccion, 0));
            menuVO menus = menu.getMenu(idMenu + "");

            BebidaDAO bebida = new BebidaDAO();
            PlatosDAO plato = new PlatosDAO();

            String nombrePlato = plato.getPlato(menus.getIdPlato()).getNombre();
            String nombreBebida = bebida.getBebida(menus.getIdBebida()).getNombre();

            String[] fila = {"", "", ""};

            DefaultTableModel model = (DefaultTableModel) vista.tablaCesta.getModel();

            double precio = menu.precioMenu(idMenu + "");

            fila[0] = nombrePlato;
            fila[1] = nombreBebida;
            fila[2] = String.valueOf(precio) + "€";

            model.addRow(fila);

            this.precioTotal = this.precioTotal + precio;
            vista.etiquetaPrecioTotal.setText("Total: " + String.valueOf(this.precioTotal));
            listaCesta.add(menus);

        }

    }

    public void botonVolverMenuActionPerformed(java.awt.event.ActionEvent evt) {

        vista.panelMenu.setVisible(false);

        //vacio la tabla de el menu y la de la cesta al darle al boton de volver. 
        DefaultTableModel model = (DefaultTableModel) vista.tablaMenu.getModel();

        model.getDataVector().removeAllElements();
        vista.tablaMenu.updateUI();

        DefaultTableModel model2 = (DefaultTableModel) vista.tablaCesta.getModel();

        model2.getDataVector().removeAllElements();
        vista.tablaCesta.updateUI();

        //vacio arraylist de cesta y limpio el campo total
        listaCesta.clear();

        this.precioTotal = 0;
        vista.etiquetaPrecioTotal.setText("Total: 0");

        vista.panelPrincipalClienteReg.setVisible(true);
        
        this.correoNoReg ="";
        this.correoReg ="";
    }

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {

        int seleccion = vista.tablaCesta.getSelectedRow();
        System.out.println("adfsadfsfadsasdfasdfasdfasdfasdfasd con un pofo de " + seleccion);

        if (seleccion != -1) {

            //String idMenu = String.valueOf(vista.tablaCesta.getValueAt(seleccion, 0));
            menuVO menus = listaCesta.get(seleccion);

            double precio = this.menu.precioMenu(menus.getIdMenu() + "");

            DefaultTableModel model = (DefaultTableModel) vista.tablaCesta.getModel();
            model.removeRow(seleccion);

            System.out.println("el eliminado es ->" + menus.getIdMenu());
            vista.panelMenu.setSize(12, 12);

            this.precioTotal = this.precioTotal - precio;
            vista.etiquetaPrecioTotal.setText("Total: " + this.precioTotal);

            listaCesta.remove(seleccion);

        }

    }

    public void botonRegRegActionPerformed(java.awt.event.ActionEvent evt) {            //Registrarse en la aplicacion

        int id;
        String nombre;
        String apellido;
        String email;
        String contrasena;
        String numTarjeta;
        String pedidosAnteriores;

        ClienteRegistradoDAO nuevoCliente = new ClienteRegistradoDAO();

        nombre = vista.nombreRegField.getText();
        apellido = vista.ApellidoRegField.getText();
        email = vista.emailRegField.getText();
        contrasena = new String(vista.contraseniaRegField.getPassword());
        numTarjeta = vista.tarjetaField.getText();
        pedidosAnteriores = "";
        id = nuevoCliente.getNumClientesRegistrados();


        if (nombre.equals("") || apellido.equals("") || email.equals("") || contrasena.equals("") ||numTarjeta.equals("")) {
 
            JOptionPane.showMessageDialog(vista.panelRegistrarse, "ALGUNO DE LOS CAMPOS ESTA VACIO");
        } else {
        
            if (comprobarContrasenia(contrasena)) {
                nuevoCliente.setClienteRegistrado(id + 1 + "", nombre, apellido, email, contrasena, numTarjeta, pedidosAnteriores);
                
                this.usuarioID = id+1+"";
                
                vista.panelRegistrarse.setVisible(false);

                // TODO ajustar dimension cuando se pueda ejecutar 
                vista.panelMenu.setVisible(true);

                vista.nombreRegField.setText("");
                vista.ApellidoRegField.setText("");
                vista.emailRegField.setText("");
                vista.contraseniaRegField.setText("");
                vista.tarjetaField.setText("");

                //RELLENAMOS LA TABLA DE LA INTERFAZ MENU USUARIO
                String[] fila = {"", ""};
                //"ID", "Precio", "Fecha", "Consumiciones"
                DefaultTableModel model = (DefaultTableModel) vista.tablaPedidosRecurrentes.getModel();

                for (int i = 1; i < menu.getNumMenus() + 1; i++) {

                    menuVO menus = menu.getMenu(i + "");

                    fila[0] = String.valueOf(menu.precioMenu(i + ""));
                    fila[1] = menu.toStringConsumiciones(i + "");

                    model.addRow(fila);

                    // if escompletado= FALSE entonces esta coloreado en rojo
                }
            } else {
                System.out.println("Contrasenia incorrecta");
            }
        }    

    }

    public boolean comprobarContrasenia(String contraseniaAux) {
        char clave;
        byte numContador = 0, letraMayusContador = 0, especialContador = 0;
        boolean estado = false;
        for (int i = 0; i < contraseniaAux.length(); i++) {
            clave = contraseniaAux.charAt(i);
            if (Character.isUpperCase(clave)) {
                letraMayusContador++;
            } else if (Character.isDigit(clave)) {
                numContador++;;
            } else if (clave >= 33 && clave <= 46 || clave == 64) {
                especialContador++;
            }

        }

        if (contraseniaAux.length() >= 5 && letraMayusContador >= 1 && numContador >= 1 && especialContador >= 1) {
            estado = true;
        } else {
            if (contraseniaAux.length() < 5) {
                JOptionPane.showMessageDialog(vista.panelRegistrarse, "LA CONTRASEÑA DEBE TENER MINIMO 5 CARACTERES");
            }
            if (letraMayusContador < 1) {
                JOptionPane.showMessageDialog(vista.panelRegistrarse, "LA CONTRASEÑA DEBE TENER MINIMO 1 letras mayus");
            }
            if (numContador < 1) {
                JOptionPane.showMessageDialog(vista.panelRegistrarse, "LA CONTRASEÑA DEBE TENER MINIMO 1 numeros");
            }
            if (especialContador < 1) {
                JOptionPane.showMessageDialog(vista.panelRegistrarse, "LA CONTRASEÑA DEBE TENER MINIMO 1 CARACTERES especiales");
            }
            estado = false;

        }

        /*
        System.out.println(letraMayusContador);
        System.out.println(numContador);
        System.out.println(especialContador);
         */
        return estado;
    }

    public void botonEntrarNoRegisActionPerformed(java.awt.event.ActionEvent evt) {   //Boton Entrar sin registrarse                                                                                 
        String nombre;
        String apellido;
        String email;

        ClienteNoRegistradoDAO nuevoCliente = new ClienteNoRegistradoDAO();

        
        
        nombre = vista.nombreNoRegis.getText();
        apellido = vista.apellidosNoregis.getText();
        email = vista.emailNoRegis.getText();
        
        if (nombre.equals("") || apellido.equals("") ||email.equals("")){
            
            JOptionPane.showMessageDialog(vista.panelNoRegistrarse, "ALGUNO DE LOS CAMPOS ESTA VACIO");
        } else {

            nuevoCliente.setClienteNoRegistrado(email, nombre, apellido);
        
            this.correoNoReg = email;
            this.correoReg = "";

            vista.panelPrincipalClienteReg.setVisible(false);
            vista.panelMenu.setVisible(true);

            vista.nombreNoRegis.setText("");
            vista.apellidosNoregis.setText("");
            vista.emailNoRegis.setText("");
        }

    }

    public void botonVolverInterClientActionPerformed(java.awt.event.ActionEvent evt) {
        InterfazPrincipal principal = new InterfazPrincipal();
        ControladorPrincipal controlador = new ControladorPrincipal(principal);
        principal.setControlador(controlador);

        vista.setVisible(false);
        principal.setVisible(true);
    }

    // --------------------------------- METODOS DE LA OTRA INTERFAZ QUE SI BORRAS DA ERROR, HABRA QUE VER COMO SE SOLUCIONA ----------------------------------------                                                
    public void botonVolverNoRegActionPerformed(java.awt.event.ActionEvent evt) {
        vista.panelNoRegistrarse.setVisible(false);
        vista.setSize(350, 450);
        vista.panelPrincipal.setVisible(true);
    }

    public void botonOkRegActionPerformed(java.awt.event.ActionEvent evt) {

        int id;
        String nombre;
        String apellido;
        String email;
        String contrasena;
        String numTarjeta;
        String pedidosAnteriores;

        ClienteRegistradoDAO nuevoCliente = new ClienteRegistradoDAO();

        nombre = vista.nombreRegField.getText();
        apellido = vista.ApellidoRegField.getText();
        email = vista.emailRegField.getText();
        contrasena = new String(vista.contraseniaRegField.getPassword());
        numTarjeta = vista.tarjetaField.getText();
        pedidosAnteriores = "";
        id = nuevoCliente.getNumClientesRegistrados();

        nuevoCliente.setClienteRegistrado(id + 1 + "", nombre, apellido, email, contrasena, numTarjeta, pedidosAnteriores);

        vista.panelRegistrarse.setVisible(false);

        // TODO ajustar dimension cuando se pueda ejecutar 
        vista.panelMenu.setVisible(true);

        //RELLENAMOS LA TABLA DE LA INTERFAZ MENU USUARIO
        String[] fila = {"", ""};
        //"ID", "Precio", "Fecha", "Consumiciones"
        DefaultTableModel model = (DefaultTableModel) vista.tablaPedidosRecurrentes.getModel();

        for (int i = 1; i < menu.getNumMenus() + 1; i++) {

            menuVO menus = menu.getMenu(i + "");

            fila[0] = String.valueOf(menu.precioMenu(i + ""));
            fila[1] = menu.toStringConsumiciones(i + "");

            model.addRow(fila);

            // if escompletado= FALSE entonces esta coloreado en rojo
        }
    }

    public void passwordFieldActionPerformed(ActionEvent evt) {
        System.out.println("pass");// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void botonRealizarPedidoActionPerformed(ActionEvent evt) {

        if (listaCesta.size() != 0) {

            PedidosDAO nuevoPedido = new PedidosDAO();

            Calendar fechaActual = Calendar.getInstance();
            String cadenaFecha = String.format("%04d-%02d-%02d",
                    fechaActual.get(Calendar.YEAR),
                    fechaActual.get(Calendar.MONTH) + 1,
                    fechaActual.get(Calendar.DAY_OF_MONTH));

            String cadenaHora = String.format("%02d-%02d",
                    fechaActual.get(Calendar.HOUR), fechaActual.get(Calendar.MINUTE));

            //obtengo lista de los menus de la cesta
            String listaMenus = "";

            for (int i = 0; i < listaCesta.size(); i++) {

                listaMenus = listaMenus + listaCesta.get(i).idMenu + ", ";
            }

            nuevoPedido.setPedido("" + (nuevoPedido.getNumPedidos() + 1), this.precioTotal, cadenaFecha, cadenaHora, false, true, usuarioID, "0", "1", "1", listaMenus);
            
            String cadenaNuevoPedido= ""+ (nuevoPedido.getNumPedidos() + 1) + "-" + this.precioTotal + "-" + cadenaFecha + "-" + cadenaHora + "-" + listaMenus;
            clienteReg.setPedidosAnteriores(this.usuarioID, cadenaNuevoPedido);
            
            JOptionPane.showMessageDialog(vista, "-------------BAR.IO-------------\n"
                    + "-------------TU PEDIDO-------------\n"
                    + "NÚMERO DE PEDIDO: " + nuevoPedido.getNumPedidos() + "\n"
                    + "FECHA: " + cadenaFecha + "\n"
                    + "HORA: " + cadenaHora + "\n"
                    + "TOTAL A PAGAR... " + this.precioTotal);

            String emailClienteReg = this.correoReg;
            String emailClienteNoReg = this.correoNoReg;

            //Parte del envio del correo
            String asunto = "Ticket de compra Bar.io";
            String remitente = ""; // email
            String clave = ""; // email's key
            String body = "<div>\n" +
                            "<div>\n" +
                                "<div>\n" +
                                    "<br>\n" +
                                "</div>\n" +
                                "<div style=\"text-align: center;\">\n" +
                                    "<u>\n" +
                                        "<b>Ticket de Compra</b>\n" +
                                    "</u>\n" +
                                "</div>\n" +
                                "<div style=\"text-align: left;\">\n" +
                                    "<u>\n" +
                                        "<b>Numero de pedido: </b>\n" + nuevoPedido.getNumPedidos() +
                                    "</u>\n" +
                                "</div>\n" +
                                "<div style=\"text-align: left;\">\n" +
                                    "<u>\n" +
                                        "<b>Fecha de compra: </b>\n" + cadenaFecha +
                                    "</u>\n" +
                                "</div>\n" +
                                "\n" +
                                "<div style=\"text-align: left;\">\n" +
                                    "<u>\n" +
                                        "<b>Hora :</b>\n" + cadenaHora +
                                    "</u>\n" +
                                "</div>\n" +
                                "\n" +
                                "<div style=\"text-align: left;\">\n" +
                                    "<u>\n" +
                                        "<b>Total a pagar: </b>\n" + this.precioTotal +
                                    "</u>\n" +
                                "</div>\n" +
                            "</div>\n" +
                            "\n" +
                        "</div>";

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.user", remitente);
            props.put("mail.smtp.clave", clave);

            Session session = Session.getDefaultInstance(props);
            MimeMessage mensaje = new MimeMessage(session);

            try {
                if (emailClienteReg.isEmpty()) {
                    mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(emailClienteNoReg));
                    mensaje.setSubject(asunto);
                    mensaje.setText(body, "utf-8", "html");
                    Transport transport = session.getTransport("smtp");
                    transport.connect("smtp.gmail.com", remitente, clave);
                    transport.sendMessage(mensaje, mensaje.getAllRecipients());
                    transport.close();
                    System.out.println("Correo enviado con exito");

                } else if (emailClienteNoReg.isEmpty()) {
                    mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(emailClienteReg));
                    mensaje.setSubject(asunto);
                    mensaje.setText(body, "utf-8", "html");
                    Transport transport = session.getTransport("smtp");
                    transport.connect("smtp.gmail.com", remitente, clave);
                    transport.sendMessage(mensaje, mensaje.getAllRecipients());
                    transport.close();
                    System.out.println("Correo enviado con exito");
                } else {
                    JOptionPane.showMessageDialog(vista, "Error");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
        
            JOptionPane.showMessageDialog(null, "La cesta esta vacia");
        }

    }

    public void botonOkNoRegActionPerformed(java.awt.event.ActionEvent evt) {
        String nombre;
        String apellido;
        String email;

        ClienteNoRegistradoDAO nuevoCliente = new ClienteNoRegistradoDAO();

        nombre = vista.nombreNoRegis.getText();
        apellido = vista.apellidosNoregis.getText();
        email = vista.emailNoRegis.getText();

        nuevoCliente.setClienteNoRegistrado(email, nombre, apellido);

        //----------------------------TODO abrir ventana nueva---------------------------------
        this.vista.setVisible(false);
        vista.panelMenu.setVisible(true);
    }

    //Registrarse en la app
    public void botonPagarActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Funciona");
    }

    public void botonSeleccionarPedClientRegActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Funciona");
    }

    public void botonSeleccionarClientNoRegActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Funciona");
    }

    public void botonVolverClienteNoRegActionPerformed(java.awt.event.ActionEvent evt) {
        vista.panelPrincipal.setVisible(false);
        vista.setSize(550, 550);
        vista.panelNoRegistrarse.setVisible(true);        
        vista.nombreNoRegis.setText("");
        vista.apellidosNoregis.setText("");
        vista.emailNoRegis.setText("");
    }

    public void emailClienteISActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void botonVolverInicSesActionPerformed(java.awt.event.ActionEvent evt) {
        vista.panelIniciarSesion.setVisible(false);
        vista.setSize(550, 550);
        vista.panelPrincipal.setVisible(true);
    }

    public void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {

        InterfazPrincipal principal = new InterfazPrincipal();
        ControladorPrincipal controlador = new ControladorPrincipal(principal);
        principal.setControlador(controlador);

        vista.setVisible(false);
        principal.setVisible(true);

    }

    public void botonVerPedidosActionPerformed(java.awt.event.ActionEvent evt) {

        vista.panelPedidosAnte.setVisible(true);
        vista.setSize(734, 689);
        vista.panelPrincipalClienteReg.setVisible(false);

        String cadenaPedidos = this.clienteReg.getPedidosAnteriores(this.usuarioID);
        //SE DIVIDE LA STRING DE LOS PEDIDOS ANTERIORES POR PEDIDOS
        String[] pedidos = cadenaPedidos.split("|");

        String[] fila;

        DefaultTableModel model = (DefaultTableModel) vista.tablaPedidosRecurrentes.getModel();

        for (int i = 0; i < pedidos.length; i++) {

            //SE DIVIDE LA STRING DEL PEDIDO EN COLUMNAS
            fila = pedidos[i].split("-");
            model.addRow(fila);
        }

    }

    public void botonVolverPedidosActionPerformed(java.awt.event.ActionEvent evt) {

        vista.panelPrincipalClienteReg.setVisible(true);
        vista.setSize(734, 689);
        vista.panelPedidosAnte.setVisible(false);

    }

    public void botonRepetirPedidoActionPerformed(java.awt.event.ActionEvent evt) {

        int seleccion = vista.tablaMenu.getSelectedRow();
        String idPedido = String.valueOf(vista.tablaPedidosRecurrentes.getValueAt(seleccion, 0));
        String precio = String.valueOf(vista.tablaPedidosRecurrentes.getValueAt(seleccion, 1));
        String listaMenus = String.valueOf(vista.tablaPedidosRecurrentes.getValueAt(seleccion, 4));

        PedidosDAO nuevoPedido = new PedidosDAO();

        Calendar fechaActual = Calendar.getInstance();
        String cadenaFecha = String.format("%04d-%02d-%02d",
                fechaActual.get(Calendar.YEAR),
                fechaActual.get(Calendar.MONTH) + 1,
                fechaActual.get(Calendar.DAY_OF_MONTH));

        String cadenaHora = String.format("%02d-%02d",
                fechaActual.get(Calendar.HOUR), fechaActual.get(Calendar.MINUTE));

        //EL PRECIO TIENE QUE ESTAR SOLO EN NUMERO
        nuevoPedido.setPedido("" + (nuevoPedido.getNumPedidos() + 1), Double.parseDouble(precio), cadenaFecha, cadenaHora, false, true, usuarioID, "0", "1", "1", listaMenus);
        
        JOptionPane.showMessageDialog(vista, "-------------BAR.IO-------------\n"
                    + "-------------TU PEDIDO-------------\n"
                    + "NÚMERO DE PEDIDO: " + nuevoPedido.getNumPedidos() + "\n"
                    + "FECHA: " + cadenaFecha + "\n"
                    + "HORA: " + cadenaHora + "\n"
                    + "TOTAL A PAGAR... " + this.precioTotal);

            String emailClienteReg = this.correoReg;
            String emailClienteNoReg = this.correoNoReg;

            //Parte del envio del correo
            String asunto = "Ticket de compra Bar.io";
            String remitente = ""; // email
            String clave = ""; // email's key
            String body = "<div>\n" +
                            "<div>\n" +
                                "<div>\n" +
                                    "<br>\n" +
                                "</div>\n" +
                                "<div style=\"text-align: center;\">\n" +
                                    "<u>\n" +
                                        "<b>Ticket de Compra</b>\n" +
                                    "</u>\n" +
                                "</div>\n" +
                                "<div style=\"text-align: left;\">\n" +
                                    "<u>\n" +
                                        "<b>Numero de pedido: </b>\n" + nuevoPedido.getNumPedidos() +
                                    "</u>\n" +
                                "</div>\n" +
                                "<div style=\"text-align: left;\">\n" +
                                    "<u>\n" +
                                        "<b>Fecha de compra: </b>\n" + cadenaFecha +
                                    "</u>\n" +
                                "</div>\n" +
                                "\n" +
                                "<div style=\"text-align: left;\">\n" +
                                    "<u>\n" +
                                        "<b>Hora :</b>\n" + cadenaHora +
                                    "</u>\n" +
                                "</div>\n" +
                                "\n" +
                                "<div style=\"text-align: left;\">\n" +
                                    "<u>\n" +
                                        "<b>Total a pagar: </b>\n" + this.precioTotal +
                                    "</u>\n" +
                                "</div>\n" +
                            "</div>\n" +
                            "\n" +
                        "</div>";

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.user", remitente);
            props.put("mail.smtp.clave", clave);

            Session session = Session.getDefaultInstance(props);
            MimeMessage mensaje = new MimeMessage(session);

            try {
                if (emailClienteNoReg.isEmpty()) {
                    mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(emailClienteReg));
                    mensaje.setSubject(asunto);
                    mensaje.setText(body, "utf-8", "html");
                    Transport transport = session.getTransport("smtp");
                    transport.connect("smtp.gmail.com", remitente, clave);
                    transport.sendMessage(mensaje, mensaje.getAllRecipients());
                    transport.close();
                    System.out.println("Correo enviado con exito");
                } else {
                    JOptionPane.showMessageDialog(vista, "Error");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        
    }

}

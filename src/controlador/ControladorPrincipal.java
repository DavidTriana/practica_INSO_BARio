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

public class ControladorPrincipal implements ActionListener {

    private InterfazPrincipal vista;
    public CamareroDAO camarero = new CamareroDAO();
    public CocineroDAO cocinero = new CocineroDAO();
    public ClienteNoRegistradoDAO clienteNoRegis = new ClienteNoRegistradoDAO();
    public ClienteRegistradoDAO bebidas = new ClienteRegistradoDAO();

    @Override
    public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	} 
    public ControladorPrincipal (InterfazPrincipal interfaz){ 

        this.vista = interfaz;
        this.initcomponents();
        
        
        
    }
    
    
    
    public void initcomponents(){
        
        vista.jButtonCocineroInter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCocineroInterActionPerformed(evt);
            }
        });  
        
        
        vista.jButtonCamareroInter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCamareroInterActionPerformed(evt);
            }
        });
        
        vista.jButtonUsuariosInter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuariosInterActionPerformed(evt);
            }
        }); 
        
        vista.jButtonexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonexitActionPerformed(evt);
            }
        });
        
 
        
        
        
    }


    //inicio

    public void jButtonCocineroInterActionPerformed(java.awt.event.ActionEvent evt) {    
        
        System.out.println("hola?");

        InterfazCocinero interCocinero = new InterfazCocinero();
        ControladorCocinero controlador = new ControladorCocinero(interCocinero);
        interCocinero.setControlador(controlador);
        interCocinero.setVisible(true); 
        //interCocinero.setSize(550, 550);

        vista.setVisible(false);

        vista = null;
       
    }                                                                                              

    public void jButtonCamareroInterActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        InterfazCamarero interCamarero = new InterfazCamarero();
        ControladorCamarero controlador = new ControladorCamarero(interCamarero);
        interCamarero.setControlador(controlador);
        interCamarero.setVisible(true);
        //interCamarero.setSize(550, 550);

        vista.setVisible(false);
        vista = null;
      
    } 

    public void jButtonUsuariosInterActionPerformed(java.awt.event.ActionEvent evt){

        InterfazCliente inter = new InterfazCliente();
        ControladorCliente controlador = new ControladorCliente(inter);
        inter.setControlador(controlador);
        inter.setVisible(true);
        inter.setSize(550, 550);
        vista.setVisible(false);

    }

    public void jButtonexitActionPerformed(java.awt.event.ActionEvent evt) { 


    
    }
    

    //cierre

	
    }


   

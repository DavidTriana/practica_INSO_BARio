/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.event.MouseListener;

import controlador.*;

/**
 *
 * @author gueps
 */
public class InterfazCamarero extends javax.swing.JFrame {


    public ControladorCamarero controlador;
    
    public InterfazCamarero() {
        initComponents();
    }

    public void setControlador(ControladorCamarero controlador) {

        this.controlador = controlador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabelCamarero = new javax.swing.JLabel();
        jLabelIcon = new javax.swing.JLabel();
        jLabelIconCamarero = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPedidosCam = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        botonEntregado = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonVolver = new javax.swing.JButton();
        jLabelEstadoPedido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(201, 40, 79));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(201, 40, 79));

        jPanel3.setBackground(new java.awt.Color(201, 40, 79));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 32));
        jPanel3.setMinimumSize(new java.awt.Dimension(100, 50));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabelCamarero.setBackground(new java.awt.Color(255, 227, 131));
        jLabelCamarero.setFont(new java.awt.Font("Wide Latin", 0, 24)); // NOI18N
        jLabelCamarero.setForeground(new java.awt.Color(255, 227, 131));
        jLabelCamarero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCamarero.setText("CAMARERO");
        jLabelCamarero.setAlignmentX(0.5F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 52;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(29, 74, 0, 0);
        jPanel3.add(jLabelCamarero, gridBagConstraints);

        //jLabelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoBario.png"))); // NOI18N
        jLabelIcon.setText("BAR.IO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -38;
        gridBagConstraints.ipady = -27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        jPanel3.add(jLabelIcon, gridBagConstraints);

        //jLabelIconCamarero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/camarero.png"))); // NOI18N
        jLabelIconCamarero.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = -39;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 113, 0, 24);
        jPanel3.add(jLabelIconCamarero, gridBagConstraints);

        tablaPedidosCam.setBackground(new java.awt.Color(255, 204, 204));
        tablaPedidosCam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Precio", "Fecha", "Hora", "Atendido por", "Estado"
            }
        ));
        jScrollPane2.setViewportView(tablaPedidosCam);

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        botonEntregado.setBackground(new java.awt.Color(255, 227, 131));
        botonEntregado.setForeground(new java.awt.Color(0, 0, 0));
        botonEntregado.setText("Entregado");
        botonEntregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEntregadoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(botonEntregado, gridBagConstraints);

        jLabel1.setText("FUNCIONES");
        jPanel2.add(jLabel1, new java.awt.GridBagConstraints());

        botonVolver.setBackground(new java.awt.Color(255, 227, 131));
        botonVolver.setForeground(new java.awt.Color(0, 0, 0));
        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        jPanel2.add(botonVolver, gridBagConstraints);

        jLabelEstadoPedido.setBackground(new java.awt.Color(255, 204, 204));
        jLabelEstadoPedido.setForeground(new java.awt.Color(255, 204, 204));
        jLabelEstadoPedido.setToolTipText("estadoPedidos");
        jLabelEstadoPedido.setText("estado pedidos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabelEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        /*interfazPrincipal interfaz = new interfazPrincipal();
        interfaz.setVisible(true);
        this.setVisible(false);*/
    }                                           

    private void botonEntregadoActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazCamarero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazCamarero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazCamarero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazCamarero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazCamarero().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton botonEntregado;
    public javax.swing.JButton botonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCamarero;
    public javax.swing.JLabel jLabelEstadoPedido;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabelIconCamarero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tablaPedidosCam;
    // End of variables declaration                   
}

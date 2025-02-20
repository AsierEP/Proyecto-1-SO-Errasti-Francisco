/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto.pkg1.so.errasti.francisco;

import EDD.Cola;
import Objects.Proceso;
import javax.swing.ButtonGroup;
/**
 *
 * @author Dell
 */
public class ProcessConfUI extends javax.swing.JFrame {
   
    
    static Cola colalistos = new Cola();
    private String tipot = "CPU Bound";
    private int numProcesadores;
    private int duracionCiclo;



    
    /**
     * Creates new form CreacionProceso
     */
    public ProcessConfUI() {
        initComponents();
        setSize(1500, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        
        ProcessModeButts = new ButtonGroup();
        ProcessModeButts.add(CPUBoundButt);
        ProcessModeButts.add(IOBoundButt);
        
        NameTF.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            NameTFMouseClicked(evt);
        }
    });
        CantInstTF.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            CantInstTFMouseClicked(evt);
        }
    });
        CantInstIOTF.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            CantInstIOTFMouseClicked(evt);
        }
    });
        
        PriorityTF.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            PriorityTFMouseClicked(evt);
        }
    });
        IOBoundButt.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            if (IOBoundButt.isSelected()) {
                Lab2.setVisible(true);
                Lab3.setVisible(true);
                CantInstIOTF.setVisible(true);
            } else {
                Lab2.setVisible(false);
                Lab3.setVisible(false);
                CantInstIOTF.setVisible(false);
            }
        }
    });
        
        Lab2.setVisible(false);
        Lab3.setVisible(false);
        CantInstIOTF.setVisible(false);
    }
    
        public ProcessConfUI(int cantcpu, int time) {
        initComponents();
        this.numProcesadores=cantcpu;
        this.duracionCiclo=time;
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    
    public void clear(){
        this.NameTF.setText("");
        this.PriorityTF.setText("");
        this.CantInstTF.setText("");
        this.CantInstIOTF.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProcessModeButts = new javax.swing.ButtonGroup();
        PCTittle = new javax.swing.JLabel();
        BackToSimButt = new javax.swing.JButton();
        Lab1 = new javax.swing.JLabel();
        NameLab = new javax.swing.JLabel();
        NameTF = new javax.swing.JTextField();
        CantInsLab = new javax.swing.JLabel();
        CPUBoundButt = new javax.swing.JRadioButton();
        IOBoundButt = new javax.swing.JRadioButton();
        CrearProcesoButt = new javax.swing.JButton();
        CantInstTF = new javax.swing.JTextField();
        Lab2 = new javax.swing.JLabel();
        Lab3 = new javax.swing.JLabel();
        CantInstIOTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        PriorityTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1500, 800));

        PCTittle.setText("Configuración de procesos");

        BackToSimButt.setText("Volver a simulación");
        BackToSimButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToSimButtActionPerformed(evt);
            }
        });

        Lab1.setText("Por favor llene todos los campos de la creación del proceso");

        NameLab.setText("Nombre:");

        NameTF.setForeground(new java.awt.Color(204, 204, 204));
        NameTF.setText("Ej: P1");
        NameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTFActionPerformed(evt);
            }
        });

        CantInsLab.setText("Cantidad de instrucciones:");

        CPUBoundButt.setText("CPU Bound");

        IOBoundButt.setText("I/O Bound");

        CrearProcesoButt.setText("Crear proceso");
        CrearProcesoButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearProcesoButtActionPerformed(evt);
            }
        });

        CantInstTF.setForeground(new java.awt.Color(204, 204, 204));
        CantInstTF.setText("Ej: 5");
        CantInstTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantInstTFActionPerformed(evt);
            }
        });

        Lab2.setText("Ya que el proceso es I/O Bound por favor indique el número");

        Lab3.setText("De ciclos en el que se realiza la excepción y en el que termina");

        CantInstIOTF.setForeground(new java.awt.Color(204, 204, 204));
        CantInstIOTF.setText("Ej: 3,5");

        jLabel1.setText("Prioridad:");

        PriorityTF.setForeground(new java.awt.Color(204, 204, 204));
        PriorityTF.setText("Ej: 2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BackToSimButt)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(PCTittle))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(Lab1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(CPUBoundButt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(IOBoundButt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(40, 40, 40))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(CantInsLab)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CantInstTF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(NameLab)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(NameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(Lab2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Lab3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(PriorityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(CrearProcesoButt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(CantInstIOTF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PCTittle)
                .addGap(10, 10, 10)
                .addComponent(Lab1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLab)
                    .addComponent(NameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CantInsLab)
                    .addComponent(CantInstTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CPUBoundButt)
                    .addComponent(IOBoundButt))
                .addGap(18, 18, 18)
                .addComponent(Lab2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lab3)
                .addGap(32, 32, 32)
                .addComponent(CantInstIOTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(PriorityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(CrearProcesoButt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addComponent(BackToSimButt)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackToSimButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToSimButtActionPerformed
        new MainUI(this.numProcesadores,this.duracionCiclo).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackToSimButtActionPerformed

    private void NameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTFActionPerformed

    private void CrearProcesoButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearProcesoButtActionPerformed
    String nombre = NameTF.getText();
    int numeroInstrucciones = Integer.parseInt(CantInstTF.getText());
    int prioridad = Integer.parseInt(PriorityTF.getText());
    String tipo = "";

    if (CPUBoundButt.isSelected()) {
        tipo = "CPU Bound";
        Proceso nuevoProceso = new Proceso(nombre, numeroInstrucciones, tipo, prioridad);
        colalistos.AddElement(nuevoProceso);
    } else if (IOBoundButt.isSelected()) {
        tipo = "I/O Bound";
        String[] excepcion = CantInstIOTF.getText().split(",");
        int inicioExcepcion = Integer.parseInt(excepcion[0].trim());
        int finExcepcion = Integer.parseInt(excepcion[1].trim());
        Proceso nuevoProceso = new Proceso(nombre, numeroInstrucciones, tipo, prioridad, inicioExcepcion, finExcepcion);
        colalistos.AddElement(nuevoProceso);
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Por favor seleccione el tipo de proceso (CPU Bound o I/O Bound)");
        return;
    }

    NameTF.setText("");
    CantInstTF.setText("");
    PriorityTF.setText("");
    CantInstIOTF.setText("");
    ProcessModeButts.clearSelection();
    javax.swing.JOptionPane.showMessageDialog(this, "Proceso creado y agregado a la cola con éxito.");
    }//GEN-LAST:event_CrearProcesoButtActionPerformed

    private void CantInstTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantInstTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantInstTFActionPerformed

    private void NameTFMouseClicked(java.awt.event.MouseEvent evt) {                                          
    NameTF.setText("");
    NameTF.setForeground(new java.awt.Color(0, 0, 0));
    }
    private void CantInstTFMouseClicked(java.awt.event.MouseEvent evt) {                                          
    CantInstTF.setText("");
    CantInstTF.setForeground(new java.awt.Color(0, 0, 0));
    }
    private void CantInstIOTFMouseClicked(java.awt.event.MouseEvent evt) {                                          
    CantInstIOTF.setText("");
    CantInstIOTF.setForeground(new java.awt.Color(0, 0, 0));
    }
    private void PriorityTFMouseClicked(java.awt.event.MouseEvent evt) {                                          
    PriorityTF.setText("");
    PriorityTF.setForeground(new java.awt.Color(0, 0, 0));
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
            java.util.logging.Logger.getLogger(ProcessConfUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProcessConfUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProcessConfUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProcessConfUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProcessConfUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToSimButt;
    private javax.swing.JRadioButton CPUBoundButt;
    private javax.swing.JLabel CantInsLab;
    private javax.swing.JTextField CantInstIOTF;
    private javax.swing.JTextField CantInstTF;
    private javax.swing.JButton CrearProcesoButt;
    private javax.swing.JRadioButton IOBoundButt;
    private javax.swing.JLabel Lab1;
    private javax.swing.JLabel Lab2;
    private javax.swing.JLabel Lab3;
    private javax.swing.JLabel NameLab;
    private javax.swing.JTextField NameTF;
    private javax.swing.JLabel PCTittle;
    private javax.swing.JTextField PriorityTF;
    private javax.swing.ButtonGroup ProcessModeButts;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

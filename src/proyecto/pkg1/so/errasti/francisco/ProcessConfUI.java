/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto.pkg1.so.errasti.francisco;

import EDD.Cola;
import Objects.Proceso;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
/**
 *
 * @author Dell
 */
public class ProcessConfUI extends javax.swing.JFrame {
   
    
    static Cola colalistos = new Cola();
    private String tipot = "CPU Bound";
    private int numProcesadores;
    private int duracionCiclo;
    private MainUI sim;
    private Proceso creado;



    
    /**
     * Creates new form CreacionProceso
     */
    public ProcessConfUI() {
        initComponents();
        setSize(520,600);
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
        InicioExcTF.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            CantInstIOTFMouseClicked(evt);
        }
    });
        
        PriorityTF.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            PriorityTFMouseClicked(evt);
        }
    });
        
        InicioExcTF.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            InicioExcTFMouseClicked(evt);
        }
    });
        
        FinExcTF.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            FinExcTFMouseClicked(evt);
        }
    });
        IOBoundButt.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            if (IOBoundButt.isSelected()) {
                Lab2.setVisible(true);
                Lab3.setVisible(true);
                InicioExcTF.setVisible(true);
            } else {
                Lab2.setVisible(false);
                Lab3.setVisible(false);
                InicioExcTF.setVisible(false);
            }
        }
    });
        
        Lab2.setVisible(false);
        Lab3.setVisible(false);
        InicioExcTF.setVisible(false);
    }
    
        public ProcessConfUI(MainUI si, int cantcpu, int time) {
        initComponents();
        this.numProcesadores=cantcpu;
        this.duracionCiclo=time;
        this.sim = si;
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
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
        
        PriorityTF.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            PriorityTFMouseClicked(evt);
        }
    });
        InicioExcTF.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            CantInstIOTFMouseClicked(evt);
        }
    });
        
        FinExcTF.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            FinExcTFMouseClicked(evt);
        }
    });
        IOBoundButt.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            if (IOBoundButt.isSelected()) {
                Lab2.setVisible(true);
                Lab3.setVisible(true);
                InicioExcTF.setVisible(true);
                IOBoundLab.setVisible(true);
                IOBoundLab2.setVisible(true);
                FinExcTF.setVisible(true);
            } else {
                Lab2.setVisible(false);
                Lab3.setVisible(false);
                InicioExcTF.setVisible(false);
                IOBoundLab.setVisible(false);
                IOBoundLab2.setVisible(false);
                FinExcTF.setVisible(false);
            }
        }
    });
        
        Lab2.setVisible(false);
        Lab3.setVisible(false);
        InicioExcTF.setVisible(false);
        IOBoundLab.setVisible(false);
        IOBoundLab2.setVisible(false);
        FinExcTF.setVisible(false);
    }
    
    
    public void clear(){
        this.NameTF.setText("");
        this.PriorityTF.setText("");
        this.CantInstTF.setText("");
        this.InicioExcTF.setText("");
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
        jPanel1 = new javax.swing.JPanel();
        BackToSimButt = new javax.swing.JButton();
        CrearProcesoButt = new javax.swing.JButton();
        PriorityTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        InicioExcTF = new javax.swing.JTextField();
        Lab3 = new javax.swing.JLabel();
        Lab2 = new javax.swing.JLabel();
        IOBoundButt = new javax.swing.JRadioButton();
        CPUBoundButt = new javax.swing.JRadioButton();
        CantInstTF = new javax.swing.JTextField();
        CantInsLab = new javax.swing.JLabel();
        NameTF = new javax.swing.JTextField();
        NameLab = new javax.swing.JLabel();
        Lab1 = new javax.swing.JLabel();
        PCTittle = new javax.swing.JLabel();
        IOBoundLab = new javax.swing.JLabel();
        IOBoundLab2 = new javax.swing.JLabel();
        FinExcTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 255));
        setSize(new java.awt.Dimension(1500, 800));

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        BackToSimButt.setBackground(new java.awt.Color(255, 255, 153));
        BackToSimButt.setText("Volver a simulación");
        BackToSimButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToSimButtActionPerformed(evt);
            }
        });

        CrearProcesoButt.setBackground(new java.awt.Color(153, 255, 102));
        CrearProcesoButt.setText("Crear proceso");
        CrearProcesoButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearProcesoButtActionPerformed(evt);
            }
        });

        PriorityTF.setForeground(new java.awt.Color(204, 204, 204));
        PriorityTF.setText("Ej: 2");

        jLabel1.setText("Prioridad:");

        InicioExcTF.setForeground(new java.awt.Color(204, 204, 204));
        InicioExcTF.setText("Ej: 3");

        Lab3.setText("De ciclos en el que se realiza la excepción y en el que termina");

        Lab2.setText("Ya que el proceso es I/O Bound por favor indique el número");

        IOBoundButt.setText("I/O Bound");

        CPUBoundButt.setText("CPU Bound");

        CantInstTF.setForeground(new java.awt.Color(204, 204, 204));
        CantInstTF.setText("Ej: 5");
        CantInstTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantInstTFActionPerformed(evt);
            }
        });

        CantInsLab.setText("Cantidad de instrucciones:");

        NameTF.setForeground(new java.awt.Color(204, 204, 204));
        NameTF.setText("Ej: P1");
        NameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTFActionPerformed(evt);
            }
        });

        NameLab.setText("Nombre:");

        Lab1.setText("Por favor llene todos los campos de la creación del proceso");

        PCTittle.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        PCTittle.setText("Configuración de procesos");

        IOBoundLab.setText("Inicio:");

        IOBoundLab2.setText("Finalizar:");

        FinExcTF.setForeground(new java.awt.Color(204, 204, 204));
        FinExcTF.setText("Ej: 4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lab3, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PriorityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Lab2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BackToSimButt))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CantInsLab)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CantInstTF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Lab1)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(CPUBoundButt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(IOBoundButt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(NameLab)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(NameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(PCTittle))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(CrearProcesoButt)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(IOBoundLab)
                .addGap(24, 24, 24)
                .addComponent(InicioExcTF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(IOBoundLab2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FinExcTF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PCTittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lab1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLab)
                    .addComponent(NameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CantInsLab)
                    .addComponent(CantInstTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CPUBoundButt)
                    .addComponent(IOBoundButt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lab2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lab3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InicioExcTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IOBoundLab)
                    .addComponent(IOBoundLab2)
                    .addComponent(FinExcTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(PriorityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addComponent(CrearProcesoButt)
                .addGap(83, 83, 83)
                .addComponent(BackToSimButt)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackToSimButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToSimButtActionPerformed
        if(!this.sim.empezoYa()){
            this.sim.iniciar();
            this.dispose();
        }else{
            this.dispose();
        }
    }//GEN-LAST:event_BackToSimButtActionPerformed

    private void NameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTFActionPerformed

    private void CrearProcesoButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearProcesoButtActionPerformed
String nombrel = NameTF.getText();
int inst = Integer.parseInt(this.CantInstTF.getText());
int prio = Integer.parseInt(this.PriorityTF.getText());
String tipot = "";
if (IOBoundButt.isSelected()) {
    tipot = "I/O Bound";
} else if (CPUBoundButt.isSelected()) {
    tipot = "CPU Bound";
} else {
    JOptionPane.showMessageDialog(this, "Seleccione un tipo de proceso (CPU Bound o I/O Bound).", "Error", JOptionPane.ERROR_MESSAGE);
    return;
}
Proceso creado = null;

if ("CPU Bound".equals(tipot)) {
    creado = new Proceso(nombrel, inst, "CPU Bound", prio);
    System.out.println("Se agregó CPU Bound.");
} else if ("I/O Bound".equals(tipot)) {
    try {
        int inicioExcepcion = Integer.parseInt(this.InicioExcTF.getText());
        int finExcepcion = Integer.parseInt(this.FinExcTF.getText());
        creado = new Proceso(nombrel, inst, "I/O Bound", prio, inicioExcepcion, finExcepcion);
        System.out.println("Se agregó I/O Bound.");
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos en 'Inicio Excepción' y 'Fin Excepción'.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
}
if (creado != null) {
    if (this.sim.empezoYa()) {
        this.sim.actualizarListos(creado);
        this.sim.informarCPUS();
    } else {
        colalistos.AddElement(creado);
    }
    JOptionPane.showMessageDialog(this, "Proceso creado y agregado a la cola con éxito.");
} else {
    JOptionPane.showMessageDialog(this, "No se pudo crear el proceso.", "Error", JOptionPane.ERROR_MESSAGE);
}

ProcessModeButts.clearSelection();
clear();
tipot = "CPU Bound";
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
    InicioExcTF.setText("");
    InicioExcTF.setForeground(new java.awt.Color(0, 0, 0));
    }
    private void PriorityTFMouseClicked(java.awt.event.MouseEvent evt) {                                          
    PriorityTF.setText("");
    PriorityTF.setForeground(new java.awt.Color(0, 0, 0));
    }
    private void InicioExcTFMouseClicked(java.awt.event.MouseEvent evt) {                                          
    InicioExcTF.setText("");
    InicioExcTF.setForeground(new java.awt.Color(0, 0, 0));
    }
    private void FinExcTFMouseClicked(java.awt.event.MouseEvent evt) {                                          
    FinExcTF.setText("");
    FinExcTF.setForeground(new java.awt.Color(0, 0, 0));
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
    private javax.swing.JTextField CantInstTF;
    private javax.swing.JButton CrearProcesoButt;
    private javax.swing.JTextField FinExcTF;
    private javax.swing.JRadioButton IOBoundButt;
    private javax.swing.JLabel IOBoundLab;
    private javax.swing.JLabel IOBoundLab2;
    private javax.swing.JTextField InicioExcTF;
    private javax.swing.JLabel Lab1;
    private javax.swing.JLabel Lab2;
    private javax.swing.JLabel Lab3;
    private javax.swing.JLabel NameLab;
    private javax.swing.JTextField NameTF;
    private javax.swing.JLabel PCTittle;
    private javax.swing.JTextField PriorityTF;
    private javax.swing.ButtonGroup ProcessModeButts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

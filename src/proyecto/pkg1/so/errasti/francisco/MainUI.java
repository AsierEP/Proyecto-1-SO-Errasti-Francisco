/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto.pkg1.so.errasti.francisco;

import EDD.Cola;
import Objects.Procesador;
import Objects.Proceso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Timer;
import proyecto.pkg1.so.errasti.francisco.LoadArchiveUI.*;
import static proyecto.pkg1.so.errasti.francisco.ProcessConfUI.colalistos;

/**
 *
 * @author Dell
 */
public class MainUI extends javax.swing.JFrame {
    
    private int ciclos;
    private Timer mTimer;
    private int increase;
    private String documento;
    private Proceso ProcesoAEjecutar;
    Cola colaR = colalistos;
    Procesador P1;
    Procesador P2;
    Procesador P3;    
    MainUI momento = this;

    /**
     * Creates new form MainUI
     */
    public MainUI(String documento) {
        this.documento = documento;
        initComponents();
        setSize(1500, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        
        this.P1TA.setEditable(false);
        this.P2TA.setEditable(false);
        this.P3TA.setEditable(false);
        this.ProcessReadyList.setEditable(false);
        this.ProcessBlockedList.setEditable(false);
        this.ProcessFinishedList.setEditable(false);

        PoliticasButts.add(FIFOPolButt);
        PoliticasButts.add(jRadioButton2);
        PoliticasButts.add(jRadioButton3);
        PoliticasButts.add(jRadioButton4);
        PoliticasButts.add(jRadioButton5);
        FIFOPolButt.setSelected(true);
        UpdateReady();
        
        increase = Integer.parseInt(documento.split(",")[0].trim());

                
        mTimer = new Timer(increase*1000, (ActionEvent e) -> {
            StartTimer();
        });
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                mTimer.start();
            }
        });
        
        
        //Ocultar labels invisibles:
        P1TA.setVisible(false);
        P2TA.setVisible(false);
        P3TA.setVisible(false);
        
            String[] partes = documento.split(",");
    int numero = Integer.parseInt(partes[1].trim());

    switch (numero) {
        case 0:
            break;
        case 1:
            Procesador1Lab.setText("[ENCENDIDO]");
            Procesador1Lab.setForeground(new java.awt.Color(0, 128, 0));
            
            P1TA.setVisible(true);
            
            break;
        case 2:
            Procesador1Lab.setText("[ENCENDIDO]");
            Procesador1Lab.setForeground(new java.awt.Color(0, 128, 0));
            Procesador2Lab.setText("[ENCENDIDO]");
            Procesador2Lab.setForeground(new java.awt.Color(0, 128, 0));
            
            P1TA.setVisible(true);
            P2TA.setVisible(true);
            
            break;
        case 3:
            Procesador1Lab.setText("[ENCENDIDO]");
            Procesador1Lab.setForeground(new java.awt.Color(0, 128, 0));
            Procesador2Lab.setText("[ENCENDIDO]");
            Procesador2Lab.setForeground(new java.awt.Color(0, 128, 0));
            Procesador3Lab.setText("[ENCENDIDO]");
            Procesador3Lab.setForeground(new java.awt.Color(0, 128, 0));

            P1TA.setVisible(true);
            P2TA.setVisible(true);
            P3TA.setVisible(true);
            
            break;
        default:
            System.out.println("Número no válido en documento: " + numero);
            break;
    }
    }
    
    private void StartTimer(){
        updateTime();
        updateLabel();
    }
    
    private void updateTime(){
        ciclos++;
    }
    
    private void updateLabel(){
        String cronometro = ciclos + " ciclos";
        TimerLab.setText(cronometro);
    }
    
    public void UpdateReady(){
        this.ProcessReadyList.setText(colaR.print());
    }
    
    public MainUI getMomento() {
        return momento;
    }
    
    public void UpdateTextAreas(String texto,int id) {
        if(id==1){
            javax.swing.SwingUtilities.invokeLater(() -> {
                P1TA.setText(texto);
            });
        }else if(id==2){
            javax.swing.SwingUtilities.invokeLater(() -> {
                P2TA.setText(texto);
            });
        }else{
            javax.swing.SwingUtilities.invokeLater(() -> {
                P3TA.setText(texto);
            });
        }
    }
    
    public void AsignarProcesoAEjecutar() {
    if (FIFOPolButt.isSelected()) {
        if (!colaR.IsEmpty()) {
            ProcesoAEjecutar = colaR.RemoveElement();
        } else {
            System.out.println("No hay procesos en la cola para asignar.");
            ProcesoAEjecutar = null;
        }
        } else {
        ProcesoAEjecutar = null;
        }
    }
    
    public void EjecutarFIFO() {
    if (ProcesoAEjecutar != null) {
        System.out.println("Ejecutando proceso: " + ProcesoAEjecutar.getNombre());
        // Aquí puedes agregar la lógica para ejecutar el proceso
        UpdateReady();
    } else {
        System.out.println("No hay ningún proceso asignado para ejecutar.");
    }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PoliticasButts = new javax.swing.ButtonGroup();
        TittleLab = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Procesador3Lab = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        P3TA = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        Procesador2Lab = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        P2TA = new javax.swing.JTextArea();
        ProcessReadyLab = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CiclosLab = new javax.swing.JLabel();
        TimerLab = new javax.swing.JLabel();
        NameP1Lab = new javax.swing.JLabel();
        NameP2Lab = new javax.swing.JLabel();
        NameP3Lab = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Procesador1Lab = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        P1TA = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ProcessReadyList = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        ProcessBlockedList = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        ProcessFinishedList = new javax.swing.JTextArea();
        FIFOPolButt = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1500, 800));

        TittleLab.setText("SIMULACIÓN DE PLANIFICACIÓN");

        jButton1.setText("Ventana de procesos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        Procesador3Lab.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Procesador3Lab.setForeground(new java.awt.Color(255, 0, 0));
        Procesador3Lab.setText("[APAGADO]");

        P3TA.setColumns(20);
        P3TA.setRows(5);
        jScrollPane6.setViewportView(P3TA);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(Procesador3Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Procesador3Lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        Procesador2Lab.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Procesador2Lab.setForeground(new java.awt.Color(255, 0, 0));
        Procesador2Lab.setText("[APAGADO]");

        P2TA.setColumns(20);
        P2TA.setRows(5);
        jScrollPane5.setViewportView(P2TA);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 92, Short.MAX_VALUE)
                .addComponent(Procesador2Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Procesador2Lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        ProcessReadyLab.setText("Procesos Listos:");

        jLabel1.setText("Procesos Bloqueados:");

        CiclosLab.setText("Ciclo actual:");

        TimerLab.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TimerLab.setText("0 ciclos");

        NameP1Lab.setText("Procesador 1");

        NameP2Lab.setText("Procesador 2");

        NameP3Lab.setText("Procesador 3");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        Procesador1Lab.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Procesador1Lab.setForeground(new java.awt.Color(255, 0, 0));
        Procesador1Lab.setText("[APAGADO]");

        P1TA.setColumns(20);
        P1TA.setRows(5);
        jScrollPane1.setViewportView(P1TA);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(Procesador1Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Procesador1Lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Procesos terminados");

        ProcessReadyList.setColumns(20);
        ProcessReadyList.setRows(5);
        jScrollPane4.setViewportView(ProcessReadyList);

        ProcessBlockedList.setColumns(20);
        ProcessBlockedList.setRows(5);
        jScrollPane7.setViewportView(ProcessBlockedList);

        ProcessFinishedList.setColumns(20);
        ProcessFinishedList.setRows(5);
        jScrollPane2.setViewportView(ProcessFinishedList);

        FIFOPolButt.setText("FIFO");

        jRadioButton2.setText("jRadioButton2");

        jRadioButton3.setText("jRadioButton3");

        jRadioButton4.setText("jRadioButton4");

        jRadioButton5.setText("jRadioButton5");

        jLabel3.setText("Politicas de planificación (Tomará efecto en el siguiente ciclo de instrucción)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(NameP3Lab)
                        .addGap(269, 269, 269)
                        .addComponent(ProcessReadyLab)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(78, 78, 78))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(FIFOPolButt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TittleLab)
                .addGap(601, 601, 601))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(NameP1Lab)
                .addGap(287, 287, 287)
                .addComponent(NameP2Lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CiclosLab)
                .addGap(26, 26, 26)
                .addComponent(TimerLab)
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(TittleLab)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameP1Lab)
                            .addComponent(NameP2Lab))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(57, 57, 57)
                                .addComponent(ProcessReadyLab)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(114, 114, 114)
                                .addComponent(jButton1)
                                .addGap(74, 74, 74))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(NameP3Lab)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CiclosLab)
                    .addComponent(TimerLab))
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FIFOPolButt)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ProcessConfUI pc = new ProcessConfUI(documento);
        pc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    LoadArchiveUI loadArchive = new LoadArchiveUI();
    String documento = loadArchive.getDocumento();
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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI(documento).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CiclosLab;
    private javax.swing.JRadioButton FIFOPolButt;
    private javax.swing.JLabel NameP1Lab;
    private javax.swing.JLabel NameP2Lab;
    private javax.swing.JLabel NameP3Lab;
    private javax.swing.JTextArea P1TA;
    private javax.swing.JTextArea P2TA;
    private javax.swing.JTextArea P3TA;
    private javax.swing.ButtonGroup PoliticasButts;
    private javax.swing.JLabel Procesador1Lab;
    private javax.swing.JLabel Procesador2Lab;
    private javax.swing.JLabel Procesador3Lab;
    private javax.swing.JTextArea ProcessBlockedList;
    private javax.swing.JTextArea ProcessFinishedList;
    private javax.swing.JLabel ProcessReadyLab;
    private javax.swing.JTextArea ProcessReadyList;
    private javax.swing.JLabel TimerLab;
    private javax.swing.JLabel TittleLab;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}

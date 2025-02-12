/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto.pkg1.so.errasti.francisco;

import EDD.Cola;
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
    Cola colaR = colalistos;

    /**
     * Creates new form MainUI
     */
    public MainUI(String documento) {
        this.documento = documento;
        initComponents();
        setSize(1500, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        
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
        EjecutandoP1Lab.setVisible(false);
        ProcessP1Lab.setVisible(false);
        OwnerP1Lab.setVisible(false);
        PCP1Lab.setVisible(false);
        InstrucP1Lab.setVisible(false);
        EjecutandoP2Lab.setVisible(false);
        ProcessP2Lab.setVisible(false);
        OwnerP2Lab.setVisible(false);
        PCP2Lab.setVisible(false);
        InstrucP2Lab.setVisible(false);
        EjecutandoP3Lab.setVisible(false);
        ProcessP3Lab.setVisible(false);
        OwnerP3Lab.setVisible(false);
        PCP3Lab.setVisible(false);
        InstrucP3Lab.setVisible(false);
        
            String[] partes = documento.split(",");
    int numero = Integer.parseInt(partes[1].trim());

    switch (numero) {
        case 0:
            break;
        case 1:
            Procesador1Lab.setText("[ENCENDIDO]");
            Procesador1Lab.setForeground(new java.awt.Color(0, 128, 0));

            EjecutandoP1Lab.setVisible(true);
            ProcessP1Lab.setVisible(true);
            OwnerP1Lab.setVisible(true);
            PCP1Lab.setVisible(true);
            InstrucP1Lab.setVisible(true);
            break;
        case 2:
            Procesador1Lab.setText("[ENCENDIDO]");
            Procesador1Lab.setForeground(new java.awt.Color(0, 128, 0));
            Procesador2Lab.setText("[ENCENDIDO]");
            Procesador2Lab.setForeground(new java.awt.Color(0, 128, 0));

            EjecutandoP1Lab.setVisible(true);
            ProcessP1Lab.setVisible(true);
            OwnerP1Lab.setVisible(true);
            PCP1Lab.setVisible(true);
            InstrucP1Lab.setVisible(true);

            EjecutandoP2Lab.setVisible(true);
            ProcessP2Lab.setVisible(true);
            OwnerP2Lab.setVisible(true);
            PCP2Lab.setVisible(true);
            InstrucP2Lab.setVisible(true);
            break;
        case 3:
            Procesador1Lab.setText("[ENCENDIDO]");
            Procesador1Lab.setForeground(new java.awt.Color(0, 128, 0));
            Procesador2Lab.setText("[ENCENDIDO]");
            Procesador2Lab.setForeground(new java.awt.Color(0, 128, 0));
            Procesador3Lab.setText("[ENCENDIDO]");
            Procesador3Lab.setForeground(new java.awt.Color(0, 128, 0));

            EjecutandoP1Lab.setVisible(true);
            ProcessP1Lab.setVisible(true);
            OwnerP1Lab.setVisible(true);
            PCP1Lab.setVisible(true);
            InstrucP1Lab.setVisible(true);

            EjecutandoP2Lab.setVisible(true);
            ProcessP2Lab.setVisible(true);
            OwnerP2Lab.setVisible(true);
            PCP2Lab.setVisible(true);
            InstrucP2Lab.setVisible(true);

            EjecutandoP3Lab.setVisible(true);
            ProcessP3Lab.setVisible(true);
            OwnerP3Lab.setVisible(true);
            PCP3Lab.setVisible(true);
            InstrucP3Lab.setVisible(true);
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
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConfiguracionButt = new javax.swing.JButton();
        TittleLab = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Procesador3Lab = new javax.swing.JLabel();
        EjecutandoP3Lab = new javax.swing.JLabel();
        ProcessP3Lab = new javax.swing.JLabel();
        OwnerP3Lab = new javax.swing.JLabel();
        PCP3Lab = new javax.swing.JLabel();
        InstrucP3Lab = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Procesador2Lab = new javax.swing.JLabel();
        EjecutandoP2Lab = new javax.swing.JLabel();
        ProcessP2Lab = new javax.swing.JLabel();
        OwnerP2Lab = new javax.swing.JLabel();
        PCP2Lab = new javax.swing.JLabel();
        InstrucP2Lab = new javax.swing.JLabel();
        ProcessReadyLab = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ProcessBlockedList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        CiclosLab = new javax.swing.JLabel();
        TimerLab = new javax.swing.JLabel();
        NameP1Lab = new javax.swing.JLabel();
        NameP2Lab = new javax.swing.JLabel();
        NameP3Lab = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        EjecutandoP1Lab = new javax.swing.JLabel();
        Procesador1Lab = new javax.swing.JLabel();
        ProcessP1Lab = new javax.swing.JLabel();
        OwnerP1Lab = new javax.swing.JLabel();
        PCP1Lab = new javax.swing.JLabel();
        InstrucP1Lab = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ProcessFinishedList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        ProcessReadyList = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1500, 800));

        ConfiguracionButt.setText("Configuración del programa");
        ConfiguracionButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfiguracionButtActionPerformed(evt);
            }
        });

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

        EjecutandoP3Lab.setText("Ejecutando:");

        ProcessP3Lab.setText("\"\"");

        OwnerP3Lab.setText("Programa de ");

        PCP3Lab.setText("PC:");

        InstrucP3Lab.setText("\"\"");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Procesador3Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(OwnerP3Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(EjecutandoP3Lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProcessP3Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PCP3Lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InstrucP3Lab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Procesador3Lab)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProcessP3Lab)
                    .addComponent(EjecutandoP3Lab))
                .addGap(18, 18, 18)
                .addComponent(OwnerP3Lab)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PCP3Lab)
                    .addComponent(InstrucP3Lab))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        Procesador2Lab.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Procesador2Lab.setForeground(new java.awt.Color(255, 0, 0));
        Procesador2Lab.setText("[APAGADO]");

        EjecutandoP2Lab.setText("Ejecutando:");

        ProcessP2Lab.setText("\"\"");

        OwnerP2Lab.setText("Programa de ");

        PCP2Lab.setText("PC:");

        InstrucP2Lab.setText("\"\"");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 36, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(Procesador2Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(PCP2Lab)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(InstrucP2Lab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(OwnerP2Lab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(EjecutandoP2Lab)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ProcessP2Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(Procesador2Lab)
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EjecutandoP2Lab)
                    .addComponent(ProcessP2Lab))
                .addGap(18, 18, 18)
                .addComponent(OwnerP2Lab)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PCP2Lab)
                    .addComponent(InstrucP2Lab))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ProcessReadyLab.setText("Procesos Listos:");

        jScrollPane2.setViewportView(ProcessBlockedList);

        jLabel1.setText("Procesos Bloqueados:");

        CiclosLab.setText("Ciclo actual:");

        TimerLab.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TimerLab.setText("0 ciclos");

        NameP1Lab.setText("Procesador 1");

        NameP2Lab.setText("Procesador 2");

        NameP3Lab.setText("Procesador 3");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        EjecutandoP1Lab.setText("Ejecutando:");

        Procesador1Lab.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Procesador1Lab.setForeground(new java.awt.Color(255, 0, 0));
        Procesador1Lab.setText("[APAGADO]");

        ProcessP1Lab.setText("\"\"");

        OwnerP1Lab.setText("Programa de ");

        PCP1Lab.setText("PC:");

        InstrucP1Lab.setText("\"\"");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Procesador1Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(OwnerP1Lab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(EjecutandoP1Lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProcessP1Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(PCP1Lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(InstrucP1Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Procesador1Lab)
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EjecutandoP1Lab)
                    .addComponent(ProcessP1Lab))
                .addGap(18, 18, 18)
                .addComponent(OwnerP1Lab)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PCP1Lab)
                    .addComponent(InstrucP1Lab))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jLabel2.setText("Procesos terminados");

        jScrollPane3.setViewportView(ProcessFinishedList);

        ProcessReadyList.setColumns(20);
        ProcessReadyList.setRows(5);
        jScrollPane4.setViewportView(ProcessReadyList);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ConfiguracionButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(jLabel1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(78, 78, 78))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                .addGap(41, 41, 41))
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
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(ConfiguracionButt)
                                        .addGap(32, 32, 32)
                                        .addComponent(jButton1)
                                        .addGap(164, 164, 164))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(101, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfiguracionButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiguracionButtActionPerformed
        SistemConfUI sc = new SistemConfUI(documento);
        sc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ConfiguracionButtActionPerformed

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
    private javax.swing.JButton ConfiguracionButt;
    private javax.swing.JLabel EjecutandoP1Lab;
    private javax.swing.JLabel EjecutandoP2Lab;
    private javax.swing.JLabel EjecutandoP3Lab;
    private javax.swing.JLabel InstrucP1Lab;
    private javax.swing.JLabel InstrucP2Lab;
    private javax.swing.JLabel InstrucP3Lab;
    private javax.swing.JLabel NameP1Lab;
    private javax.swing.JLabel NameP2Lab;
    private javax.swing.JLabel NameP3Lab;
    private javax.swing.JLabel OwnerP1Lab;
    private javax.swing.JLabel OwnerP2Lab;
    private javax.swing.JLabel OwnerP3Lab;
    private javax.swing.JLabel PCP1Lab;
    private javax.swing.JLabel PCP2Lab;
    private javax.swing.JLabel PCP3Lab;
    private javax.swing.JLabel Procesador1Lab;
    private javax.swing.JLabel Procesador2Lab;
    private javax.swing.JLabel Procesador3Lab;
    private javax.swing.JList<String> ProcessBlockedList;
    private javax.swing.JList<String> ProcessFinishedList;
    private javax.swing.JLabel ProcessP1Lab;
    private javax.swing.JLabel ProcessP2Lab;
    private javax.swing.JLabel ProcessP3Lab;
    private javax.swing.JLabel ProcessReadyLab;
    private javax.swing.JTextArea ProcessReadyList;
    private javax.swing.JLabel TimerLab;
    private javax.swing.JLabel TittleLab;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}

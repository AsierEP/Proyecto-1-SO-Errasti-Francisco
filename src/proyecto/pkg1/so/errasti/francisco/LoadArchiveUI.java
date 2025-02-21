/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto.pkg1.so.errasti.francisco;

import EDD.Cola;
import Objects.Simulacion;
import EDD.Semaforo;
import Objects.Proceso;
import java.io.BufferedReader;
import java.io.FileReader;
import com.google.gson.Gson;
import java.io.IOException;

/**
 *
 * @author Dell
 */
public class LoadArchiveUI extends javax.swing.JFrame {
    
    private ProcessConfUI creacion;
    /**
     * Creates new form LoadArchiveUI
     */
    public LoadArchiveUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.creacion=new ProcessConfUI();
    }
    
    public MainUI restablecerEstado(String rutaArchivo) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(rutaArchivo)) {
            Simulacion estado = gson.fromJson(reader, Simulacion.class);
            Semaforo s = estado.getSemaforo();
            Cola colaL = estado.getColaL();
            Cola colaT = estado.getColaT();
            Cola colaB = estado.getColaB();
            int cicloreloj = estado.getCicloReloj();
            int numcpu = estado.getNumProcesadores();
            String pl = estado.getPolitica();
            
            if(numcpu==2){
                MainUI sim = new MainUI(pl,cicloreloj, numcpu,colaL,colaB,colaT,estado.getPen1(),estado.getPen2(),s);
                return sim;
            }else{
                MainUI sim = new MainUI(pl,cicloreloj,numcpu,colaL,colaB,colaT,estado.getPen1(),estado.getPen2(),estado.getPen3(),s);
                return sim;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        SavedProcessButt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        StartProcessButt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel1.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        jLabel1.setText("Bienvenido a la simulación de planificación");

        jLabel2.setText("Hecho por Asier errasti y Jose Francisco");

        SavedProcessButt.setBackground(new java.awt.Color(153, 255, 204));
        SavedProcessButt.setText("Cargar procesos guardados");
        SavedProcessButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavedProcessButtActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccione una opción:");

        StartProcessButt.setBackground(new java.awt.Color(204, 255, 153));
        StartProcessButt.setText("Iniciar nuevos procesos");
        StartProcessButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartProcessButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(StartProcessButt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SavedProcessButt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))))
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(SavedProcessButt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(StartProcessButt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SavedProcessButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavedProcessButtActionPerformed
        MainUI sim = this.restablecerEstado("src/proyecto/pkg1/so/errasti/francisco/simulacion.json");
        sim.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_SavedProcessButtActionPerformed

    private void StartProcessButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartProcessButtActionPerformed
        NumCPUConfUI n = new NumCPUConfUI(this);
        n.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_StartProcessButtActionPerformed

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
            java.util.logging.Logger.getLogger(LoadArchiveUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadArchiveUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadArchiveUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadArchiveUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoadArchiveUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SavedProcessButt;
    private javax.swing.JButton StartProcessButt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

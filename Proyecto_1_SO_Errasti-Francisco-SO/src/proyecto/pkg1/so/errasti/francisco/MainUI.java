/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto.pkg1.so.errasti.francisco;

import EDD.Cola;
import static proyecto.pkg1.so.errasti.francisco.ProcessConfUI.colalistos;
import Objects.BIOS;
import Objects.Procesador;
import Objects.Proceso;
import Objects.Simulacion;
import EDD.Semaforo;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dell
 */
public final class MainUI extends javax.swing.JFrame {
    
    Cola colaL = colalistos;
    Cola colaT;
    Cola colaB;
    Semaforo s;
    int cicloreloj;
    Procesador P1;
    Procesador P2;
    Procesador P3;
    BIOS bios;
    int cantcpu;
    String politica;
    
    private MainUI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getPolitica() {
        return politica;
    }

    public void setPolitica(String politica) {
        this.politica = politica;
    }
    
    public int getCicloreloj() {
        return cicloreloj;
    }

    public void setCicloreloj(int cicloreloj) {
        this.cicloreloj = cicloreloj;
    }
    
    public void sumReloj(int i){
        this.CicloActualLab.setText("Ciclo Actual: "+i);
    }
    
    public MainUI(int i,int d) {
        initComponents();
        this.ProcessReadyList.setEditable(false);
        this.ProcessBlockedList.setEditable(false);
        this.ProcessFinishedList.setEditable(false);
        this.P1TA.setEditable(false);
        this.P2TA.setEditable(false);
        this.P3TA.setEditable(false);
        this.ProcessReadyList.setEditable(false);
        this.ProcessBlockedList.setEditable(false);
        this.ProcessFinishedList.setEditable(false);
        this.P3TA.setEditable(false);
        this.P3TA.setEditable(false);
        this.cantcpu=i;
        this.setCicloreloj(d);
        this.s= new Semaforo();
        actualizarListos();
        cargarProcesadores();
        this.colaT = new Cola();
        this.colaB = new Cola();
    }
    
    
        public MainUI(int d, int i,Cola colalistos, Cola colablocked, Cola colafinished,Proceso Pen1,Proceso Pen2, Semaforo s) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.s=s;
        this.setCicloreloj(d);
        this.bios= new BIOS(this);
        this.cantcpu=i;
        this.colaL=colalistos;
        this.colaT = colafinished;
        this.colaB = colablocked;
        actualizarListos();
        this.actualizarBloqueadosR();
        this.actualizarTerminadosR();
        P1 = new Procesador(1,colaL,s,this.getCicloreloj(),this);
        P2 = new Procesador(2,colaL,s,this.getCicloreloj(),this);
        P1.setProcesoActual(Pen1);
        P2.setProcesoActual(Pen2);
        bios.start();
        P1.start();
        P2.start();
    }
    
    public MainUI(int d, int i,Cola colalistos, Cola colablocked, Cola colafinished,Proceso Pen1,Proceso Pen2, Proceso Pen3, Semaforo s) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.s=s;
        this.setCicloreloj(d);
        this.bios= new BIOS(this);
        this.cantcpu=i;
        this.colaL=colalistos;
        this.colaT = colafinished;
        this.colaB = colablocked;
        actualizarListos();
        this.actualizarBloqueadosR();
        this.actualizarTerminadosR();
        P1 = new Procesador(1,colaL,s,4000,this);
        P2 = new Procesador(2,colaL,s,4000,this);
        P3 = new Procesador(3,colaL,s,4000,this);
        P1.setProcesoActual(Pen1);
        P2.setProcesoActual(Pen2);
        P3.setProcesoActual(Pen3);
        bios.start();
        P1.start();
        P2.start();
        P3.start();
    }
    MainUI instancia = this;

    public void setCantcpu(int ii){
        this.cantcpu=ii;
    }

    public void actualizarListos(){
        ProcessReadyList.setText(colaL.print());
    }
    
    public void addListos(Proceso p){
        colaL.AddElement(p);
        ProcessReadyList.setText(colaL.print());
        ProcessBlockedList.setText(colaB.print());
    }
    
    public void irInterrumpiendo(Proceso p){
        switch (p.getIdProcesador()) {
            case 1:
                P1.interrumpir();
                System.out.println("procesador 1 notificado salida");
                break;
            case 2:
                P2.interrumpir();
                System.out.println("procesador 2 notificado salida");
                break;
            case 3:
                P3.interrumpir();
                System.out.println("procesador 3 notificado salida");
                break;
            default:
                break;
        }
    }
    
    public synchronized void actualizarTerminados(Proceso t){
        Cola copia = this.colaT.copy();
        copia.AddElement(t);
        this.ProcessFinishedList.setText(copia.print());
        this.colaT=copia;
    }
    
    public void actualizarTerminadosR(){
        ProcessFinishedList.setText(colaT.print());
    }
    
    public void actualizarBloqueados(Proceso t){
        Cola copia = this.colaB.copy();
        copia.AddElement(t);
        this.ProcessBlockedList.setText(colaB.print());
        this.colaB=copia;
    }
    
    public void actualizarBloqueadosR(){
        ProcessBlockedList.setText(colaB.print());
    }
    
    public Cola getBloqueados(){
        return colaB;
    }
    
    
    public void actualizarCiclo(){
        if(this.cantcpu>=2){
        P1.setCicloReloj(cicloreloj);
        P2.setCicloReloj(cicloreloj);
        }
        if(this.cantcpu==3){
        P3.setCicloReloj(cicloreloj);
        }
    }
    
    private void cargarProcesadores(){
        System.out.println(cantcpu);
        if(this.cantcpu==3){
            P1 = new Procesador(1,colaL,s,this.getCicloreloj(),this);
            P1.start();
            P2 = new Procesador(2,colaL,s,this.getCicloreloj(),this);
            P2.start();
            P3 = new Procesador(3,colaL,s,this.getCicloreloj(),this);
            P3.start();
        }else if (this.cantcpu==2){
            P1 = new Procesador(1,colaL,s,this.getCicloreloj(),this);
            P1.start();
            P2 = new Procesador(2,colaL,s,this.getCicloreloj(),this);
            P2.start();
        }
        this.bios=new BIOS(this);
        bios.start();
    }
    
    public synchronized MainUI getInstancia() {
        return instancia;
    }
    
    public void actualizarTextoArea(String texto,int id) {
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
    
    public void detenerHilos() {
        if (P1 != null) P1.detener();
        if (P2 != null) P2.detener();
        if (P3 != null) P3.detener();
        if (bios != null) bios.detener();
    }
    
public void guardarEstado(String path) {
    detenerHilos();

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
        if (this.cantcpu == 3) {
            Proceso p1 = P1.getProcesoActual();
            Proceso p2 = P2.getProcesoActual();
            Proceso p3 = P3.getProcesoActual();

            writer.write("Estado de la Simulación:\n");
            writer.write("Semáforo: " + this.s + "\n");
            writer.write("Cola L: " + this.colaL + "\n");
            writer.write("Cola T: " + this.colaT + "\n");
            writer.write("Cola B: " + this.colaB + "\n");
            writer.write("Ciclo Reloj: " + this.cicloreloj + "\n");
            writer.write("Número de CPUs: " + this.cantcpu + "\n");
            writer.write("CPU1 Proceso Actual: " + (p1 != null ? p1.toString() : "null") + "\n");
            writer.write("CPU2 Proceso Actual: " + (p2 != null ? p2.toString() : "null") + "\n");
            writer.write("CPU3 Proceso Actual: " + (p3 != null ? p3.toString() : "null") + "\n");
        } else {
            Proceso p1 = P1.getProcesoActual();
            Proceso p2 = P2.getProcesoActual();

            writer.write("Estado de la Simulación:\n");
            writer.write("Semáforo: " + this.s + "\n");
            writer.write("Cola L: " + this.colaL + "\n");
            writer.write("Cola T: " + this.colaT + "\n");
            writer.write("Cola B: " + this.colaB + "\n");
            writer.write("Ciclo Reloj: " + this.cicloreloj + "\n");
            writer.write("Número de CPUs: " + this.cantcpu + "\n");
            writer.write("CPU1 Proceso Actual: " + (p1 != null ? p1.toString() : "null") + "\n");
            writer.write("CPU2 Proceso Actual: " + (p2 != null ? p2.toString() : "null") + "\n");
        }

        System.out.println("Estado de la simulación guardado en: " + path);
    } catch (IOException e) {
        e.printStackTrace();
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
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        NameP1Lab = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Procesador1Lab = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        P1TA = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        Procesador2Lab = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        P2TA = new javax.swing.JTextArea();
        ProcessReadyLab = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Procesador3Lab = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        P3TA = new javax.swing.JTextArea();
        NameP3Lab = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ProcessReadyList = new javax.swing.JTextArea();
        NameP2Lab = new javax.swing.JLabel();
        TittleLab = new javax.swing.JLabel();
        ToProcessButt = new javax.swing.JButton();
        ToCiclosButt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CicloActualLab = new javax.swing.JLabel();
        ToPoliticasButt = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ProcessFinishedList = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        ProcessBlockedList = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1500, 800));
        getContentPane().setLayout(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(3037, 387, 295, 36);

        jPanel5.setBackground(new java.awt.Color(0, 51, 102));

        NameP1Lab.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        NameP1Lab.setForeground(new java.awt.Color(255, 255, 255));
        NameP1Lab.setText("Procesador 1");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Procesador1Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Procesador1Lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Procesador2Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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

        ProcessReadyLab.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        ProcessReadyLab.setForeground(new java.awt.Color(255, 255, 255));
        ProcessReadyLab.setText("Procesos listos");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Procesador3Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Procesador3Lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        NameP3Lab.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        NameP3Lab.setForeground(new java.awt.Color(255, 255, 255));
        NameP3Lab.setText("Procesador 3");

        ProcessReadyList.setColumns(20);
        ProcessReadyList.setRows(5);
        ProcessReadyList.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane4.setViewportView(ProcessReadyList);

        NameP2Lab.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        NameP2Lab.setForeground(new java.awt.Color(255, 255, 255));
        NameP2Lab.setText("Procesador 2");

        TittleLab.setFont(new java.awt.Font("Snap ITC", 3, 18)); // NOI18N
        TittleLab.setForeground(new java.awt.Color(255, 255, 255));
        TittleLab.setText("SIMULACIÓN DE PLANIFICACIÓN");

        ToProcessButt.setBackground(new java.awt.Color(0, 255, 0));
        ToProcessButt.setText("Ventana de procesos");
        ToProcessButt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 51)));
        ToProcessButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToProcessButtActionPerformed(evt);
            }
        });

        ToCiclosButt.setBackground(new java.awt.Color(204, 204, 255));
        ToCiclosButt.setText("Modificación ciclos");
        ToCiclosButt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 0, 255)));
        ToCiclosButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToCiclosButtActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Modern No. 20", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Política de vaciado:");

        CicloActualLab.setFont(new java.awt.Font("Modern No. 20", 1, 14)); // NOI18N
        CicloActualLab.setForeground(new java.awt.Color(255, 255, 255));
        CicloActualLab.setText("Ciclo Actual:");

        ToPoliticasButt.setBackground(new java.awt.Color(255, 102, 51));
        ToPoliticasButt.setText("Políticas de vaciado");
        ToPoliticasButt.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 0)));
        ToPoliticasButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToPoliticasButtActionPerformed(evt);
            }
        });

        ProcessFinishedList.setColumns(20);
        ProcessFinishedList.setRows(5);
        ProcessFinishedList.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(ProcessFinishedList);

        jLabel2.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Procesos terminados");

        jLabel1.setFont(new java.awt.Font("Modern No. 20", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Procesos bloqueados");

        ProcessBlockedList.setColumns(20);
        ProcessBlockedList.setRows(5);
        ProcessBlockedList.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jScrollPane7.setViewportView(ProcessBlockedList);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(NameP1Lab)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(286, 286, 286)
                                .addComponent(TittleLab))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(179, 179, 179)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(CicloActualLab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                                    .addComponent(ToCiclosButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(ToPoliticasButt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(259, 259, 259)
                                        .addComponent(ProcessReadyLab)
                                        .addGap(184, 184, 184)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(105, 105, 105)
                                        .addComponent(ToProcessButt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addComponent(NameP2Lab)
                                .addGap(244, 244, 244)
                                .addComponent(jLabel1)
                                .addGap(148, 148, 148)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(NameP3Lab))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1272, Short.MAX_VALUE)))
                .addGap(44, 44, 44))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(TittleLab)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameP2Lab)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(NameP3Lab)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(ProcessReadyLab)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                                            .addComponent(jScrollPane7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(CicloActualLab)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(ToCiclosButt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ToProcessButt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ToPoliticasButt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(NameP1Lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(6, 6, 1644, 705);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ToProcessButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToProcessButtActionPerformed
        ProcessConfUI pc = new ProcessConfUI();
        pc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ToProcessButtActionPerformed

    private void ToCiclosButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToCiclosButtActionPerformed
        CiclosRelojConfUI cic = new CiclosRelojConfUI(this);
        cic.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ToCiclosButtActionPerformed

    private void ToPoliticasButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToPoliticasButtActionPerformed
        PoliticasConfUI pol = new PoliticasConfUI();
        pol.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ToPoliticasButtActionPerformed

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
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CicloActualLab;
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
    private javax.swing.JLabel TittleLab;
    private javax.swing.JButton ToCiclosButt;
    private javax.swing.JButton ToPoliticasButt;
    private javax.swing.JButton ToProcessButt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}

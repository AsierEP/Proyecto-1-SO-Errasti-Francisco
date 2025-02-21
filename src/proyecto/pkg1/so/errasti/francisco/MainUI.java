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
import Objects.Dispatcher;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.Color;


/**
 *
 * @author Dell
 */
public final class MainUI extends javax.swing.JFrame {
    
    Cola colaL = new Cola();
    Cola colaCopiaListos= new Cola();
    Cola colaT;
    Cola colaB;
    Semaforo s;
    int cicloreloj;
    Procesador P1;
    Procesador P2;
    Procesador P3;
    Dispatcher bios;
    int cantcpu;
    String politica;
    boolean Cambio = false;

    
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
    
    public MainUI(String plt, int i,int d) {
        initComponents();
        this.Cambio=false;
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setPolitica(plt);
        this.cantcpu=i;
        this.setCicloreloj(d);
        this.s= new Semaforo();
        this.textoListos(this.getColaL().print());
        this.ProcessReadyList.setEditable(false);
        this.ProcessBlockedList.setEditable(false);
        this.ProcessFinishedList.setEditable(false);
        this.P1TA.setEditable(false);
        this.P2TA.setEditable(false);
        this.P3TA.setEditable(false);
        this.colaL=colalistos;
        this.colaT = new Cola();
        this.colaB = new Cola();
        ActualizarLabels(i);
    }
    
    public boolean empezoYa(){
        return this.P1 != null;
    }
    
    public void iniciar(){
        actualizarListos();
        cargarProcesadores();
    }
    
    
        public MainUI(String plt, int d, int i,Cola colalistos, Cola colablocked, Cola colafinished,Proceso Pen1,Proceso Pen2, Semaforo s) {
        initComponents();
        this.Cambio=false;
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setPolitica(plt);
        this.s=s;
        this.setCicloreloj(d);
        this.bios= new Dispatcher(this);
        this.cantcpu=i;
        this.ProcessReadyList.setEditable(false);
        this.ProcessBlockedList.setEditable(false);
        this.ProcessFinishedList.setEditable(false);
        this.P1TA.setEditable(false);
        this.P2TA.setEditable(false);
        this.P3TA.setEditable(false);
        this.colaL=colalistos;
        this.colaT = colafinished;
        this.colaB = colablocked;
        actualizarListos();
        this.textoListos(this.getColaL().print());
        this.actualizarBloqueadosR();
        this.actualizarTerminadosR();
        P1 = new Procesador(1,s,this.getCicloreloj(),this);
        P2 = new Procesador(2,s,this.getCicloreloj(),this);
        P1.setProcesoActual(Pen1);
        P2.setProcesoActual(Pen2);
        bios.start();
        P1.start();
        P2.start();
        ActualizarLabels(i);
    }
    
    public MainUI(String plt, int d, int i,Cola colalistos, Cola colablocked, Cola colafinished,Proceso Pen1,Proceso Pen2, Proceso Pen3, Semaforo s) {
        initComponents();
        this.Cambio=false;
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setPolitica(plt);
        this.s=s;
        this.setCicloreloj(d);
        this.bios= new Dispatcher(this);
        this.cantcpu=i;
        this.ProcessReadyList.setEditable(false);
        this.ProcessBlockedList.setEditable(false);
        this.ProcessFinishedList.setEditable(false);
        this.P1TA.setEditable(false);
        this.P2TA.setEditable(false);
        this.P3TA.setEditable(false);
        this.colaL=colalistos;
        this.colaT = colafinished;
        this.colaB = colablocked;
        actualizarListos();
        this.textoListos(this.getColaL().print());
        this.actualizarBloqueadosR();
        this.actualizarTerminadosR();
        P1 = new Procesador(1,s,4000,this);
        P2 = new Procesador(2,s,4000,this);
        P3 = new Procesador(3,s,4000,this);
        P1.setProcesoActual(Pen1);
        P2.setProcesoActual(Pen2);
        P3.setProcesoActual(Pen3);
        bios.start();
        P1.start();
        P2.start();
        P3.start();
        ActualizarLabels(i);
    }
    MainUI instancia = this;

    public void setCantcpu(int ii){
        this.cantcpu=ii;
    }

    public synchronized void actualizarListos(){
        ProcessReadyList.setText(colaL.print());
    }
    
    public synchronized void actualizarListos(Cola L){
        ProcessReadyList.setText(L.print());
    }
    
    public Cola getColaL(){
        return this.colaL;   
    }
    
    public Cola getColaCopiaListos(){
        return this.colaCopiaListos;
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
    
    public synchronized void actualizarListos(Proceso tu){
        Cola copia = this.colaL.copy();
        copia.AddElement(tu);
        this.ProcessReadyList.setText(copia.print());
        this.colaL=copia;
    }
    
    public synchronized void aggRespaldo(Proceso ele){
        this.colaCopiaListos.AddElement(ele);
    }
    
    public void actualizarBloqueados(Proceso t){
        this.colaB.AddElement(t);
        this.ProcessBlockedList.setText(colaB.print());
    }
    
    public void actualizarBloqueadosR(){
        ProcessBlockedList.setText(colaB.print());
    }
    
    public synchronized void unirColas() {
        while (!colaCopiaListos.IsEmpty()) {
            Proceso proceso = colaCopiaListos.RemoveElement();
            colaL.AddElement(proceso);
        }
        System.out.println(colaL.print());
    }
    
    public synchronized void cambio(){
        this.Cambio=true;
    }
    
    public boolean hayCambioPend(){
        return this.Cambio==true;
    }
    
    public synchronized void Fincambio(){
        this.Cambio=false;
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
            P1 = new Procesador(1,s,this.getCicloreloj(),this);
            P1.start();
            P2 = new Procesador(2,s,this.getCicloreloj(),this);
            P2.start();
            P3 = new Procesador(3,s,this.getCicloreloj(),this);
            P3.start();
        }else if (this.cantcpu==2){
            P1 = new Procesador(1,s,this.getCicloreloj(),this);
            P1.start();
            P2 = new Procesador(2,s,this.getCicloreloj(),this);
            P2.start();
        }else if (this.cantcpu==1){
            P1 = new Procesador(1,s,this.getCicloreloj(),this);
            P1.start();
        }
        this.bios=new Dispatcher(this);
        bios.start();
    }
    
    public synchronized MainUI getInstancia() {
        return instancia;
    }
    
    public synchronized Cola getColaListos(){
        return this.colaL;
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
    
    public void textoListos(String t){
        this.ProcessReadyList.setText(t+this.colaCopiaListos.print());
    }
    
    public void unirColaListos(){
        if(!this.colaCopiaListos.IsEmpty()){
            while(!this.colaCopiaListos.IsEmpty()){
                Proceso ele = this.colaCopiaListos.RemoveElement();
                this.colaL.AddElement(ele);
            }
        }
    }
        
    public void aggListosppio(Proceso p){
        colaL.AddElementP(p);
        ProcessReadyList.setText(colaL.print());
    }
    
    public void guardarEstado(String rutaArchivo) {
        Simulacion estado = new Simulacion(this.cantcpu,this.cicloreloj);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(estado, writer);
            System.out.println("Estado de la simulación guardado en: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
        public void informarCPUS(){
        if(this.cantcpu==3){
            P1.seAgrego();
            P2.seAgrego();
            P3.seAgrego();
        }else if (this.cantcpu==2){
            P1.seAgrego();
            P2.seAgrego();
        }
    }
        
    public void ActualizarLabels(int i) {
    Color verde = new Color(0, 128, 0);
    switch (i) {
        case 1:
            Procesador1Lab.setText("[ENCENDIDO]");
            Procesador1Lab.setForeground(verde);
            break;
        case 2:
            Procesador1Lab.setText("[ENCENDIDO]");
            Procesador1Lab.setForeground(verde);
            Procesador2Lab.setText("[ENCENDIDO]");
            Procesador2Lab.setForeground(verde);
            break;
        case 3:
            Procesador1Lab.setText("[ENCENDIDO]");
            Procesador1Lab.setForeground(verde);
            Procesador2Lab.setText("[ENCENDIDO]");
            Procesador2Lab.setForeground(verde);
            Procesador3Lab.setText("[ENCENDIDO]");
            Procesador3Lab.setForeground(verde);
            break;
        default:
            break;
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
        jPanel5 = new javax.swing.JPanel();
        NameP1Lab = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Procesador1Lab = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        P1TA = new javax.swing.JTextArea();
        NameP3Lab = new javax.swing.JLabel();
        ProcessReadyLab = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Procesador3Lab = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        P3TA = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        ProcessReadyList = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        Procesador2Lab = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        P2TA = new javax.swing.JTextArea();
        NameP2Lab = new javax.swing.JLabel();
        TittleLab = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        ProcessBlockedList = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        CicloActualLab = new javax.swing.JLabel();
        ToCiclosButt = new javax.swing.JButton();
        PoliticaLab = new javax.swing.JLabel();
        ToPoliticasButt = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ProcessFinishedList = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        ToProcessButt = new javax.swing.JButton();
        EndButt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setSize(new java.awt.Dimension(1500, 800));

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));
        jPanel5.setForeground(new java.awt.Color(153, 153, 255));

        NameP1Lab.setText("Procesador 1");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Procesador1Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Procesador1Lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        NameP3Lab.setText("Procesador 3");

        ProcessReadyLab.setText("Procesos Listos:");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Procesador3Lab, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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

        ProcessReadyList.setColumns(20);
        ProcessReadyList.setRows(5);
        jScrollPane4.setViewportView(ProcessReadyList);

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

        NameP2Lab.setText("Procesador 2");

        TittleLab.setFont(new java.awt.Font("Californian FB", 1, 18)); // NOI18N
        TittleLab.setText("SIMULACIÓN DE PLANIFICACIÓN");

        ProcessBlockedList.setColumns(20);
        ProcessBlockedList.setRows(5);
        jScrollPane7.setViewportView(ProcessBlockedList);

        jLabel1.setText("Procesos Bloqueados:");

        CicloActualLab.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CicloActualLab.setText("Ciclo Actual:");

        ToCiclosButt.setBackground(new java.awt.Color(255, 204, 255));
        ToCiclosButt.setText("Modificación ciclos");
        ToCiclosButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToCiclosButtActionPerformed(evt);
            }
        });

        PoliticaLab.setText("Política de vaciado:");

        ToPoliticasButt.setBackground(new java.awt.Color(204, 255, 255));
        ToPoliticasButt.setText("Políticas de vaciado");
        ToPoliticasButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToPoliticasButtActionPerformed(evt);
            }
        });

        ProcessFinishedList.setColumns(20);
        ProcessFinishedList.setRows(5);
        jScrollPane2.setViewportView(ProcessFinishedList);

        jLabel2.setText("Procesos terminados");

        ToProcessButt.setBackground(new java.awt.Color(255, 204, 204));
        ToProcessButt.setText("Ventana de procesos");
        ToProcessButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToProcessButtActionPerformed(evt);
            }
        });

        EndButt.setBackground(new java.awt.Color(255, 153, 153));
        EndButt.setText("X");
        EndButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(NameP1Lab)))
                                .addGap(152, 152, 152)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(110, 110, 110)
                                        .addComponent(NameP2Lab))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(529, 529, 529)
                                .addComponent(ProcessReadyLab)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jLabel1))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ToPoliticasButt, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(CicloActualLab, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ToCiclosButt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(PoliticaLab, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(NameP3Lab)))
                        .addGap(152, 152, 152)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(ToProcessButt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TittleLab)
                .addGap(520, 520, 520)
                .addComponent(EndButt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(TittleLab))
                    .addComponent(EndButt))
                .addGap(53, 53, 53)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(NameP1Lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NameP3Lab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameP2Lab)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addComponent(ProcessReadyLab)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CicloActualLab)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ToCiclosButt)
                                .addGap(18, 18, 18)
                                .addComponent(PoliticaLab)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(ToPoliticasButt))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ToProcessButt)
                                        .addGap(35, 35, 35)))
                                .addGap(35, 35, 35))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ToProcessButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToProcessButtActionPerformed
        ProcessConfUI n = new ProcessConfUI(this,this.cantcpu,this.cicloreloj);
        n.setVisible(true);
    }//GEN-LAST:event_ToProcessButtActionPerformed

    private void ToCiclosButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToCiclosButtActionPerformed
        CiclosRelojConfUI cambio = new CiclosRelojConfUI(this);
        cambio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ToCiclosButtActionPerformed

    private void ToPoliticasButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToPoliticasButtActionPerformed
        PoliticasConfUI cpol = new PoliticasConfUI(this);
        cpol.setVisible(true);
    }//GEN-LAST:event_ToPoliticasButtActionPerformed

    private void EndButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndButtActionPerformed
        this.guardarEstado("test//simulacion.json");
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_EndButtActionPerformed

    
        
    public void PolLab(){
        this.PoliticaLab.setText("Política de vaciado: "+ politica);
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
    private javax.swing.JButton EndButt;
    private javax.swing.JLabel NameP1Lab;
    private javax.swing.JLabel NameP2Lab;
    private javax.swing.JLabel NameP3Lab;
    private javax.swing.JTextArea P1TA;
    private javax.swing.JTextArea P2TA;
    private javax.swing.JTextArea P3TA;
    private javax.swing.JLabel PoliticaLab;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}

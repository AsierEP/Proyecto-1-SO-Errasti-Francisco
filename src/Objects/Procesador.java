/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import EDD.Cola;
import EDD.Semaforo;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto.pkg1.so.errasti.francisco.MainUI;

/**
 *
 * @author Dell
 */
public class Procesador extends Thread {
    private int num; //num procesador
    private Proceso procesoActual;
    private Cola colaListos;
    private Semaforo semaforo;
    private boolean estado;
    private int ciclosprocesador;
    static int cicloReloj;
    private MainUI simulacion;
    private boolean hayinterrupcion = false;
    private boolean haynuevo = false;


    public Procesador(int id, Semaforo semaforo, int cicloReloj, MainUI simulacion) {
        this.num = id;
        this.colaListos = colaListos;
        this.semaforo = semaforo;
        this.estado = true;
        this.ciclosprocesador = 0;
        this.cicloReloj = cicloReloj; 
        this.simulacion = simulacion;
    }

    @Override
    public void run() {
        while (estado) {
            try {
                if(procesoActual==null){
                    semaforo.Swait();
                    if (!this.simulacion.getColaL().IsEmpty()) {
                        if("FCFS".equals(this.simulacion.getPolitica())||"RR".equals(this.simulacion.getPolitica())){
                            procesoActual = this.simulacion.getColaL().RemoveElement();
                            procesoActual.setEstado("Running");
                            this.simulacion.textoListos(this.simulacion.getColaL().print());
                        }else if("SPN".equals(this.simulacion.getPolitica())||"SRT".equals(this.simulacion.getPolitica())){
                            procesoActual = this.simulacion.getColaL().eliminarMasCorto();
                            procesoActual.setEstado("Running");
                            this.simulacion.textoListos(this.simulacion.getColaL().print());
                        }else if("HRRN".equals(this.simulacion.getPolitica())){
                            procesoActual = this.simulacion.getColaL().eliminarMayorTasaRespuesta();
                            procesoActual.setEstado("Running");
                            this.simulacion.textoListos(this.simulacion.getColaL().print());
                        }
                    }
                    semaforo.Ssignal();
                }
                if (procesoActual != null) {
                    ejecutarProceso(procesoActual);
                } else {
                    if (hayinterrupcion) 
                        manejarInterrupcion();
                    this.simulacion.getInstancia().actualizarTextoArea("Espera activa\nProcesador tomado por \nel Sistema Operativo...",this.num);
                    Thread.sleep(cicloReloj);
                    ciclosprocesador++;
                    if(this.simulacion.hayCambioPend())
                        this.gestionarCambio(procesoActual);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void ejecutarProceso(Proceso proceso) {
        if("RR".equals(this.simulacion.getPolitica())){
            int ciclosPasados = 0;
            if("CPU Bound".equals(proceso.getTipo())||proceso.IOComplete()){
                while (proceso.getInsfaltantes()> 0 && !this.simulacion.hayCambioPend()&&ciclosPasados <5) {
                    try {
                        if (hayinterrupcion) 
                            manejarInterrupcion();
                        this.simulacion.getInstancia().actualizarTextoArea("ID: "+ this.procesoActual.getId()+"\nSTATUS: "+this.procesoActual.getEstado()+"\nNombre: "+this.procesoActual.getNombre()+"\nPC: "+this.procesoActual.getPC()+", MAR: "+this.procesoActual.getMAR(),this.num);
                        Thread.sleep(cicloReloj);
                        proceso.setInsfaltantes(proceso.getInsfaltantes()-1);
                        ciclosprocesador++;
                        this.procesoActual.setPC(this.procesoActual.getPC()+1);
                        System.out.println("Procesador " + num + " ejecutó una instrucción. Instrucciones restantes: " + proceso.getInsfaltantes());
                        ciclosPasados++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(procesoActual.getInsfaltantes()==0){
                    System.out.println("Procesador " + num + " terminó el proceso: " + proceso.getNombre());
                    this.simulacion.getInstancia().actualizarTextoArea("Eligiendo proceso\nProcesador tomado por \nel Sistema Operativo...",this.num);
                    procesoActual.setEstado("Finished");
                    this.simulacion.actualizarTerminados(this.procesoActual);
                    procesoActual = null;
                    try {
                        Thread.sleep(cicloReloj);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(this.simulacion.hayCambioPend()){
                    this.gestionarCambio(procesoActual);
                }
                if(procesoActual!=null&&ciclosPasados==5&&procesoActual.getInsfaltantes()!=0){
                    this.simulacion.getInstancia().actualizarTextoArea("Exceso de quantum\nProcesador tomado por \nel Sistema Operativo...",this.num);
                    procesoActual.setEstado("Ready");
                    this.simulacion.addListos(proceso);
                    procesoActual=null;
                    try {
                        Thread.sleep(cicloReloj);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }else{
                if(!proceso.IOComplete()){
                    proceso.setIdProcesador(this.num);
                    while (proceso.NoHaSucedidoInterrupcion() && !this.simulacion.hayCambioPend()&&ciclosPasados <5) {
                        try {
                            this.simulacion.getInstancia().actualizarTextoArea("ID: "+ this.procesoActual.getId()+"\nSTATUS: "+this.procesoActual.getEstado()+"\nNombre: "+this.procesoActual.getNombre()+"\nPC: "+this.procesoActual.getPC()+", MAR: "+this.procesoActual.getMAR(),this.num);
                            Thread.sleep(cicloReloj);
                            proceso.setInsfaltantes(proceso.getInsfaltantes()-1);
                            ciclosprocesador++;
                            ciclosPasados++;
                            this.procesoActual.setPC(this.procesoActual.getPC()+1);
                            System.out.println("Procesador " + num + " ejecutó una instrucción. Instrucciones restantes: " + proceso.getInsfaltantes());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(procesoActual!=null&&ciclosPasados==5&&procesoActual.getInicioExcepcion()!=5){
                        this.simulacion.addListos(proceso);
                        this.simulacion.getInstancia().actualizarTextoArea("Exceso de quantum\nProcesador tomado por \nel Sistema Operativo...",this.num);
                        procesoActual.setEstado("Ready");
                        try {
                            Thread.sleep(cicloReloj);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        procesoActual=null;
                    }else{
                        this.simulacion.getInstancia().actualizarTextoArea("Enviando a bloqueados\nProcesador tomado por \nel Sistema Operativo...",this.num);
                        procesoActual.setEstado("Blocked");
                        this.simulacion.actualizarBloqueados(procesoActual);
                        procesoActual = null;
                        try {
                            Thread.sleep(cicloReloj);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(this.simulacion.hayCambioPend()){
                        this.gestionarCambio(procesoActual);
                    }
                }
            }
        }else if ("FCFS".equals(this.simulacion.getPolitica())||"SPN".equals(this.simulacion.getPolitica())||"HRRN".equals(this.simulacion.getPolitica())){
            if("CPU Bound".equals(proceso.getTipo())||proceso.IOComplete()){
                while (proceso.getInsfaltantes()> 0 && !this.simulacion.hayCambioPend()) {
                    try {
                        if (hayinterrupcion) 
                            manejarInterrupcion();
                        this.simulacion.getInstancia().actualizarTextoArea("ID: "+ this.procesoActual.getId()+"\nSTATUS: "+this.procesoActual.getEstado()+"\nNombre: "+this.procesoActual.getNombre()+"\nPC: "+this.procesoActual.getPC()+", MAR: "+this.procesoActual.getMAR(),this.num);
                        Thread.sleep(cicloReloj);
                        proceso.setInsfaltantes(proceso.getInsfaltantes()-1);
                        ciclosprocesador++;
                        this.procesoActual.setPC(this.procesoActual.getPC()+1);
                        System.out.println("Procesador " + num + " ejecutó una instrucción. Instrucciones restantes: " + proceso.getInsfaltantes());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(!this.simulacion.hayCambioPend()){
                    System.out.println("Procesador " + num + " terminó el proceso: " + proceso.getNombre());
                    this.simulacion.getInstancia().actualizarTextoArea("Eligiendo proceso\nProcesador tomado por \nel Sistema Operativo...",this.num);
                    procesoActual.setEstado("Finished");
                    this.simulacion.actualizarTerminados(procesoActual);
                    procesoActual = null;
                    try {
                    Thread.sleep(cicloReloj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
                if(this.simulacion.hayCambioPend()){
                        this.gestionarCambio(procesoActual);
                }
                
            }else{
                if(!proceso.IOComplete()){
                    proceso.setIdProcesador(this.num);
                    while (proceso.NoHaSucedidoInterrupcion() && !this.simulacion.hayCambioPend()) {
                        try {
                            if (hayinterrupcion) 
                                manejarInterrupcion();
                            this.simulacion.getInstancia().actualizarTextoArea("ID: "+ this.procesoActual.getId()+"\nSTATUS: "+this.procesoActual.getEstado()+"\nNombre: "+this.procesoActual.getNombre()+"\nPC: "+this.procesoActual.getPC()+", MAR: "+this.procesoActual.getMAR(),this.num);
                            Thread.sleep(cicloReloj);
                            proceso.setInsfaltantes(proceso.getInsfaltantes()-1);
                            ciclosprocesador++;
                            this.procesoActual.setPC(this.procesoActual.getPC()+1);
                            System.out.println("Procesador " + num + " ejecutó una instrucción. Instrucciones restantes: " + proceso.getInsfaltantes());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(!this.simulacion.hayCambioPend()){
                        this.simulacion.getInstancia().actualizarTextoArea("Enviando a bloqueados\nProcesador tomado por \nel Sistema Operativo...",this.num);
                        procesoActual.setEstado("Blocked");
                        this.simulacion.actualizarBloqueados(procesoActual);
                        procesoActual = null;
                        try {
                        Thread.sleep(cicloReloj);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    }
                    if(this.simulacion.hayCambioPend()){
                        this.gestionarCambio(procesoActual);
                    }
                    
                }
            }
        }else{
            if("CPU Bound".equals(proceso.getTipo())||proceso.IOComplete()){
                while (haynuevo==false&&proceso.getInsfaltantes()> 0 && !this.simulacion.hayCambioPend()) {
                    try {
                        if (hayinterrupcion) 
                            manejarInterrupcion();
                        this.simulacion.getInstancia().actualizarTextoArea("ID: "+ this.procesoActual.getId()+"\nSTATUS: "+this.procesoActual.getEstado()+"\nNombre: "+this.procesoActual.getNombre()+"\nPC: "+this.procesoActual.getPC()+", MAR: "+this.procesoActual.getMAR(),this.num);
                        Thread.sleep(cicloReloj);
                        proceso.setInsfaltantes(proceso.getInsfaltantes()-1);
                        ciclosprocesador++;
                        this.procesoActual.setPC(this.procesoActual.getPC()+1);
                        System.out.println("Procesador " + num + " ejecutó una instrucción. Instrucciones restantes: " + proceso.getInsfaltantes());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(!this.simulacion.hayCambioPend()&&haynuevo==false){
                    System.out.println("Procesador " + num + " terminó el proceso: " + proceso.getNombre());
                    this.simulacion.getInstancia().actualizarTextoArea("Eligiendo proceso\nProcesador tomado por \nel Sistema Operativo...",this.num);
                    procesoActual.setEstado("Finished");
                    this.simulacion.actualizarTerminados(procesoActual);
                    procesoActual = null;
                    try {
                    Thread.sleep(cicloReloj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
                if(this.simulacion.hayCambioPend()){
                        this.gestionarCambio(procesoActual);
                }
                if(haynuevo){
                                semaforo.Swait();
                                verificar();
                                semaforo.Ssignal();
                            }
                
            }else{ 
                if(!proceso.IOComplete()){
                    proceso.setIdProcesador(this.num);
                    while (false==haynuevo&&proceso.NoHaSucedidoInterrupcion() && !this.simulacion.hayCambioPend()) {
                        try {
                            if (hayinterrupcion) 
                                manejarInterrupcion();
                            this.simulacion.getInstancia().actualizarTextoArea("ID: "+ this.procesoActual.getId()+"\nSTATUS: "+this.procesoActual.getEstado()+"\nNombre: "+this.procesoActual.getNombre()+"\nPC: "+this.procesoActual.getPC()+", MAR: "+this.procesoActual.getMAR(),this.num);
                            Thread.sleep(cicloReloj);
                            proceso.setInsfaltantes(proceso.getInsfaltantes()-1);
                            ciclosprocesador++;
                            this.procesoActual.setPC(this.procesoActual.getPC()+1);
                            System.out.println("Procesador " + num + " ejecutó una instrucción. Instrucciones restantes: " + proceso.getInsfaltantes());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(!this.simulacion.hayCambioPend()&&haynuevo==false){
                        this.simulacion.getInstancia().actualizarTextoArea("Enviando a bloqueados\nProcesador tomado por \nel Sistema Operativo...",this.num);
                        procesoActual.setEstado("Blocked");
                        this.simulacion.actualizarBloqueados(procesoActual);
                        procesoActual = null;
                        try {
                        Thread.sleep(cicloReloj);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    }
                    if(this.simulacion.hayCambioPend()){
                        this.gestionarCambio(procesoActual);
                    }
                    if(haynuevo){
                                semaforo.Swait();
                                verificar();
                                semaforo.Ssignal();
                            }
                }
            }
        }
            
    }

        private void verificar(){
        if(this.simulacion.getColaL().getPlast().getNodo().getInsfaltantes()<procesoActual.getInsfaltantes()){
            Proceso aux = procesoActual;
            procesoActual = this.simulacion.getColaL().RemoveLast();
            this.simulacion.addListos(aux);
        }
        this.simulacion.getInstancia().actualizarTextoArea("SRT verifica\nInterrupción manejada por el S.O en el procesador " + num, this.num);
        try {
            Thread.sleep(cicloReloj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.haynuevo=false;
    }
        
    public void detener() {
        this.estado = false;
    }

    public int getCiclosprocesador() {
        return ciclosprocesador;
    }

    public boolean getEstado() {
        return estado;
    }
    
    public void seAgrego(){
        this.haynuevo=true;
    }
    

    public int getCicloReloj() {
        return cicloReloj;
    }
    
    private void manejarInterrupcion() {
        System.out.println("Procesador " + num + " manejando interrupción...");
        this.simulacion.getInstancia().actualizarTextoArea("Interrupción manejada por el S.O en el procesador " + num, this.num);
        try {
            Thread.sleep(cicloReloj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hayinterrupcion = false;
    }
    public void interrumpir(){
        this.hayinterrupcion=true;
    }
    
    public synchronized void setCicloReloj(int cicloReloj) {
        this.cicloReloj = cicloReloj;
        System.out.println("Procesador " + num + ": Ciclo de reloj actualizado a " + cicloReloj + " ms.");
    }

    public Proceso getProcesoActual() {
        return procesoActual;
    }

    public void setProcesoActual(Proceso procesoActual) {
        this.procesoActual = procesoActual;
    }
    
    public void gestionarCambio(Proceso proceso){
        try {
            if(procesoActual!=null){
            this.simulacion.getInstancia().actualizarTextoArea("Interrupción del SO\nCambio de política",this.num);
            procesoActual.setEstado("Ready");
            semaforo.Swait();
            this.simulacion.aggListosppio(proceso);
            procesoActual=null;
            semaforo.Ssignal();
            Thread.sleep(cicloReloj);
            this.simulacion.Fincambio();}
        } catch (InterruptedException ex) {
            Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

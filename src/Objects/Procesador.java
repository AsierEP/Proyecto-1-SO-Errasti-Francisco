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
                    if (!this.simulacion.getColaL().IsEmpty()||!this.simulacion.getColaCopiaListos().IsEmpty()) {
                        if("FCFS".equals(this.simulacion.getPolitica())){
                            if(this.simulacion.getColaL().IsEmpty()){
                                procesoActual = this.simulacion.getColaCopiaListos().RemoveElement();
                            }else{
                                procesoActual = this.simulacion.getColaL().RemoveElement();
                            }
                            procesoActual.setEstado("Running");
                            this.simulacion.textoListos(this.simulacion.getColaL().print());
                        }else if("RR".equals(this.simulacion.getPolitica())){

                        }
                    }
                    semaforo.Ssignal();
                }
                if (procesoActual != null) {
                    ejecutarProceso(procesoActual);
                } else {
                    Thread.sleep(cicloReloj);
                    ciclosprocesador++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
        private void ejecutarProceso(Proceso proceso) {
        if("FCFS".equals(this.simulacion.getPolitica())){
            if("CPU Bound".equals(proceso.getTipo())||proceso.IOComplete()){
                //System.out.println("Procesador " + id + " ejecutando proceso: " + proceso.getNombre());
                while (proceso.getInsfaltantes()> 0 && estado && !this.simulacion.hayCambioPend()) {
                    try {
                        if (hayinterrupcion) 
                            manejarInterrupcion();
                        this.simulacion.getInstancia().actualizarTextoArea("ID: "+ this.procesoActual.getId()+"\nSTATUS: "+this.procesoActual.getEstado()+"\nNombre: "+this.procesoActual.getNombre()+"\nPC: "+this.procesoActual.getPC()+", MAR: "+this.procesoActual.getMAR(),this.num);
                        Thread.sleep(cicloReloj); // Simular la ejecución de una instrucción (ajustado al ciclo de reloj)
                        proceso.setInsfaltantes(proceso.getInsfaltantes()-1);
                        ciclosprocesador++;
                        this.procesoActual.setPC(this.procesoActual.getPC()+1);
                        System.out.println("Procesador " + num + " ejecutó una instrucción. Instrucciones restantes: " + proceso.getInsfaltantes());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(estado&& procesoActual.getInsfaltantes()==0){
                    System.out.println("Procesador " + num + " terminó el proceso: " + proceso.getNombre());
                    this.simulacion.getInstancia().actualizarTextoArea("Procesador tomado por \nel Sistema Operativo...",this.num);
                    procesoActual.setEstado("Finished");
                    this.simulacion.actualizarTerminados(this.procesoActual);
                    procesoActual = null; // Liberar el procesador
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
                    while (proceso.NoHaSucedidoInterrupcion() && estado && !this.simulacion.hayCambioPend()) {
                        try {
                            this.simulacion.getInstancia().actualizarTextoArea("ID: "+ this.procesoActual.getId()+"\nSTATUS: "+this.procesoActual.getEstado()+"\nNombre: "+this.procesoActual.getNombre()+"\nPC: "+this.procesoActual.getPC()+", MAR: "+this.procesoActual.getMAR(),this.num);
                            Thread.sleep(cicloReloj); // Simular la ejecución de una instrucción (ajustado al ciclo de reloj)
                            proceso.setInsfaltantes(proceso.getInsfaltantes()-1);
                            ciclosprocesador++;
                            this.procesoActual.setPC(this.procesoActual.getPC()+1);
                            System.out.println("Procesador " + num + " ejecutó una instrucción. Instrucciones restantes: " + proceso.getInsfaltantes());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(estado&& procesoActual.getInsfaltantes()==0){
                    this.simulacion.getInstancia().actualizarTextoArea("Procesador tomado por \nel Sistema Operativo...",this.num);
                    procesoActual.setEstado("Blocked");
                    this.simulacion.actualizarBloqueados(procesoActual);
                    procesoActual = null; // Liberar el procesador
                    try { //este es para que salga la vaina de que el sistema operativo toma el procesador
                        Thread.sleep(cicloReloj); // Pausa de 500 ms para que el mensaje sea visible
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }}
                    if(this.simulacion.hayCambioPend()){
                        this.gestionarCambio(procesoActual);
                    }
                }
            }
        }else{
            
        }
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
    

    public int getCicloReloj() {
        return cicloReloj;
    }
    
    private void manejarInterrupcion() {
        System.out.println("Procesador " + num + " manejando interrupción...");
        this.simulacion.getInstancia().actualizarTextoArea("S.O. Interrupción manejada por el procesador " + num, this.num);

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
            this.simulacion.getInstancia().actualizarTextoArea("Interrupción del SO\nCambio de política",this.num);
            this.simulacion.aggRespaldo(proceso);
            procesoActual.setEstado("Ready");
            procesoActual=null;
            Thread.sleep(cicloReloj);
            this.simulacion.Fincambio();
        } catch (InterruptedException ex) {
            Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

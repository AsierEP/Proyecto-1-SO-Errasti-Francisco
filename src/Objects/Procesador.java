/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import EDD.Cola;
import EDD.Semaforo;
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


    public Procesador(int id, Cola colaListos, Semaforo semaforo, int cicloReloj,MainUI simulacion) {
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
                if (!colaListos.IsEmpty()) {
                    procesoActual = colaListos.RemoveElement();
                    procesoActual.setEstado("Running");
                    this.simulacion.actualizarListos();
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
        if("CPU Bound".equals(proceso.getTipo())||proceso.IOComplete()){
            System.out.println("Procesador " + num + " ejecutando proceso: " + proceso.getNombre());
            while (proceso.getInsfaltantes()> 0 && estado) {
                try {
                    if (hayinterrupcion) 
                        manejarInterrupcion();
                    this.simulacion.getInstancia().actualizarTextoArea("ID: "+ this.procesoActual.getId()+", STATUS: "+this.procesoActual.getEstado()+", Nombre: "+this.procesoActual.getNombre()+", PC: "+this.procesoActual.getPC()+", MAR: "+this.procesoActual.getMAR(),this.num);
                    Thread.sleep(cicloReloj);
                    proceso.setInsfaltantes(proceso.getInsfaltantes()-1);
                    ciclosprocesador++;
                    this.procesoActual.setPC(this.procesoActual.getPC()+1);
                    System.out.println("Procesador " + num + " ejecutó una instrucción. Instrucciones restantes: " + proceso.getInsfaltantes());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(estado){
                System.out.println("Procesador " + num + " terminó el proceso: " + proceso.getNombre());
                this.simulacion.getInstancia().actualizarTextoArea("Procesador tomado por \nel Sistema Operativo...",this.num);
                procesoActual.setEstado("Finished");
                this.simulacion.actualizarTerminados(this.procesoActual);
                procesoActual = null;
                try {
                    Thread.sleep(cicloReloj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            if(!proceso.IOComplete()){
                proceso.setIdProcesador(this.num);
                System.out.println("Procesador " + num + " ejecutando proceso: " + proceso.getNombre());
                while (proceso.NoHaSucedidoInterrupcion() && estado) {
                    try {
                        this.simulacion.getInstancia().actualizarTextoArea("ID: "+ this.procesoActual.getId()+", STATUS: "+this.procesoActual.getEstado()+", Nombre: "+this.procesoActual.getNombre()+", PC: "+this.procesoActual.getPC()+", MAR: "+this.procesoActual.getMAR(),this.num);
                        Thread.sleep(cicloReloj);
                        proceso.setInsfaltantes(proceso.getInsfaltantes()-1);
                        ciclosprocesador++;
                        this.procesoActual.setPC(this.procesoActual.getPC()+1);
                        System.out.println("Procesador " + num + " ejecutó una instrucción. Instrucciones restantes: " + proceso.getInsfaltantes());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(estado){
                this.simulacion.getInstancia().actualizarTextoArea("Procesador tomado por \nel Sistema Operativo...",this.num);
                procesoActual.setEstado("Blocked");
                this.simulacion.actualizarBloqueados(procesoActual);
                procesoActual = null;
                try {
                    Thread.sleep(cicloReloj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }}
            }
            
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
    
    
}

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
    private int ciclosEjecutados;
    private int cicloReloj;
    private MainUI simulacion;

    public Procesador(int id, Cola colaListos, Semaforo semaforo, int cicloReloj,MainUI simulacion) {
        this.num = id;
        this.colaListos = colaListos;
        this.semaforo = semaforo;
        this.estado = true;
        this.ciclosEjecutados = 0;
        this.cicloReloj = cicloReloj; 
        this.simulacion = simulacion;
    }

    @Override
    public void run() {
        while (estado) {
            try {
                semaforo.adquirir();
                if (!colaListos.IsEmpty()) {
                    procesoActual = colaListos.RemoveElement();
                    procesoActual.setEstado("Running");
                    this.simulacion.UpdateReady();
                }
                semaforo.liberar();

                if (procesoActual != null) {
                    ejecutarProceso(procesoActual);
                } else {
                    Thread.sleep(50);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void ejecutarProceso(Proceso proceso) {
        System.out.println("Procesador " + num + " ejecutando proceso: " + proceso.getNombre());
        while (proceso.getNumeroInstrucciones() > 0) {
            try {
                this.simulacion.getMomento().UpdateTextAreas("ID: "+ this.procesoActual.getId()+", STATUS: "+this.procesoActual.getEstado()+", Nombre: "+this.procesoActual.getNombre()+", PC: "+this.procesoActual.getPC()+", MAR: "+this.procesoActual.getMAR(),this.num);
                Thread.sleep(cicloReloj); // Simular la ejecución de una instrucción (ajustado al ciclo de reloj)
                proceso.setNumeroInstrucciones(proceso.getNumeroInstrucciones()-1);
                ciclosEjecutados++;
                this.procesoActual.setPC(this.procesoActual.getPC()+1);
                System.out.println("Procesador " + num + " ejecutó una instrucción. Instrucciones restantes: " + proceso.getNumeroInstrucciones());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Procesador " + num + " terminó el proceso: " + proceso.getNombre());
        this.simulacion.getMomento().UpdateTextAreas("S.O.",this.num);
        procesoActual = null; // Liberar el procesador
    }

    public void detener() {
        this.estado = false;
    }

    public int getCiclosEjecutados() {
        return ciclosEjecutados;
    }

    public boolean estaActivo() {
        return estado;
    }

    public int getCicloReloj() {
        return cicloReloj;
    }

    public synchronized void setCicloReloj(int cicloReloj) {
        this.cicloReloj = cicloReloj; // Permitir cambiar el ciclo de reloj dinámicamente
        System.out.println("Procesador " + num + ": Ciclo de reloj actualizado a " + cicloReloj + " ms.");
    }
}

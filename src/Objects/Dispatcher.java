/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import EDD.Cola;
import EDD.Node;
import proyecto.pkg1.so.errasti.francisco.MainUI;
import static Objects.Procesador.cicloReloj;
/**
 *
 * @author Dell
 */
public class Dispatcher extends Thread{
    private MainUI sim;
    private boolean activo; 
    private int ciclos=0;


    public Dispatcher(MainUI sim2) {
        this.sim=sim2;
        this.activo=true;
    }
    
    @Override
    public void run() {
        while (activo) {
            try {
                    checkListos();
                    checkIO();
                    Thread.sleep(cicloReloj);
                    ciclos++;
                    this.sim.sumReloj(ciclos);
                    System.out.println(ciclos);
                    
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void checkIO() {
        Cola colaB = sim.getBloqueados();
        Node actual = colaB.getpfirst();
        Node anterior = null;

        while (actual != null) {
            Proceso p = actual.getNodo();
            if(p.irInterrumpiendo()){
                    this.sim.irInterrumpiendo(p);
            }
            p.sumarCicloBloqueado();            

            if (p.finalizadaES()) {
                if (anterior == null) {
                    colaB.setpfirst(actual.getPnext());
                } else {
                    anterior.setPnext(actual.getPnext());
                }
                p.setEstado("Ready");
                this.sim.addListos(p);
                actual = actual.getPnext();
            } else {
                anterior = actual;
                actual = actual.getPnext();
            }
        }
    }
    
    private void checkListos(){
        Cola colaL = sim.getColaListos();
        Node actual = colaL.getpfirst();
        while(actual!=null){
            actual.getNodo().sumarEspera();
            actual=actual.getPnext();
        }
    }
    
    public void detener() {
        this.activo = false;
    }
    

    public Dispatcher(Runnable task) {
        super(task);
    }

    public Dispatcher(ThreadGroup group, Runnable task) {
        super(group, task);
    }

    public Dispatcher(String name) {
        super(name);
    }

    public Dispatcher(ThreadGroup group, String name) {
        super(group, name);
    }

    public Dispatcher(Runnable task, String name) {
        super(task, name);
    }

    public Dispatcher(ThreadGroup group, Runnable task, String name) {
        super(group, task, name);
    }

    public Dispatcher(ThreadGroup group, Runnable task, String name, long stackSize) {
        super(group, task, name, stackSize);
    }

    public Dispatcher(ThreadGroup group, Runnable task, String name, long stackSize, boolean inheritInheritableThreadLocals) {
        super(group, task, name, stackSize, inheritInheritableThreadLocals);
    }
}
    

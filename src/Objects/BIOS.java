/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import EDD.Cola;
import EDD.Node;
import static Objects.Procesador.cicloReloj;
import proyecto.pkg1.so.errasti.francisco.MainUI;

/**
 *
 * @author Dell
 */
public class BIOS extends Thread{
    private MainUI sim;
    private boolean activo; 
    private int ciclos = 0;


    public BIOS(MainUI sim2) {
        this.sim=sim2;
        this.activo=true;
    }
    
    @Override
    public void run() {
        while (activo) {
            try {
                    Thread.sleep(cicloReloj);
                    ciclos++;
                    System.out.println(ciclos);
                    checkIO();
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
            p.sumarCicloBloqueado();

            if (p.finalizadaES()) {
                
                if (anterior == null) {
                    colaB.setFrente(actual.getPnext());
                } else {
                    anterior.setPnext(actual.getPnext());
                }
                this.sim.addListos(p);
                actual = actual.getPnext();
            } else {
                anterior = actual;
                actual = actual.getPnext();
            }
        }
    }
    
    public void detener() {
        this.activo = false;
    }
    

    public BIOS(Runnable task) {
        super(task);
    }

    public BIOS(ThreadGroup group, Runnable task) {
        super(group, task);
    }

    public BIOS(String name) {
        super(name);
    }

    public BIOS(ThreadGroup group, String name) {
        super(group, name);
    }

    public BIOS(Runnable task, String name) {
        super(task, name);
    }

    public BIOS(ThreadGroup group, Runnable task, String name) {
        super(group, task, name);
    }

    public BIOS(ThreadGroup group, Runnable task, String name, long stackSize) {
        super(group, task, name, stackSize);
    }

    public BIOS(ThreadGroup group, Runnable task, String name, long stackSize, boolean inheritInheritableThreadLocals) {
        super(group, task, name, stackSize, inheritInheritableThreadLocals);
    }
    
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author Dell
 */
public class Semaforo {
    private int counter;
    
    public Semaforo(){
        this.counter = 1;
    }
    //S.Signal
    public synchronized void liberar() {
        counter++;
        notify();
    }
    //S.Wait()
    public synchronized void adquirir() {
        while (counter == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("interrupción mientras esperaba el semáforo.");
            }
        }
        counter--;
    }
}

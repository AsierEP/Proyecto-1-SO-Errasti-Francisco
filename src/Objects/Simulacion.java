/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import EDD.Cola;
import EDD.Semaforo;

/**
 *
 * @author Dell
 */
public class Simulacion {
    private Semaforo semaforo;
    private Cola colaL;
    private Cola colaT;
    private Cola colaB;
    private int cicloReloj;
    private int numProcesadores;
    private Proceso Pen1;
    private Proceso Pen2;
    private Proceso Pen3;
    private String politica;

    

    // Constructor2
    public Simulacion(String politca, Semaforo semaforo, Cola colaL, Cola colaT, Cola colaB, int cicloReloj,int n,Proceso c1,Proceso c2, Proceso c3) {
        this.semaforo = semaforo;
        this.colaL = colaL;
        this.colaT = colaT;
        this.colaB = colaB;
        this.cicloReloj = cicloReloj;
        this.numProcesadores=n;
        this.Pen1=c1;
        this.Pen2=c2;
        this.Pen3=c3;
        this.politica=politca;
    }
    
    public Simulacion(String politca,Semaforo semaforo, Cola colaL, Cola colaT, Cola colaB, int cicloReloj,int n,Proceso c1,Proceso c2) {
        this.semaforo = semaforo;
        this.colaL = colaL;
        this.colaT = colaT;
        this.colaB = colaB;
        this.cicloReloj = cicloReloj;
        this.numProcesadores=n;
        this.Pen1=c1;
        this.Pen2=c2;
        this.politica=politca;
    }

    public Semaforo getSemaforo() {
        return semaforo;
    }
    
    public String getPolitica(){
        return this.politica;
    }

    public void setSemaforo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    public Cola getColaL() {
        return colaL;
    }

    public void setColaL(Cola colaL) {
        this.colaL = colaL;
    }

    public Cola getColaT() {
        return colaT;
    }

    public void setColaT(Cola colaT) {
        this.colaT = colaT;
    }

    public Cola getColaB() {
        return colaB;
    }

    public void setColaB(Cola colaB) {
        this.colaB = colaB;
    }

    public int getCicloReloj() {
        return cicloReloj;
    }

    public void setCicloReloj(int cicloReloj) {
        this.cicloReloj = cicloReloj;
    }

    public int getNumProcesadores() {
        return numProcesadores;
    }

    public void setNumProcesadores(int numProcesadores) {
        this.numProcesadores = numProcesadores;
    }

    public Proceso getPen1() {
        return Pen1;
    }

    public void setPen1(Proceso en1) {
        this.Pen1 = en1;
    }

    public Proceso getPen2() {
        return Pen2;
    }

    public void setPen2(Proceso en2) {
        this.Pen2 = en2;
    }

    public Proceso getPen3() {
        return Pen3;
    }

    public void setPen3(Proceso en3) {
        this.Pen3 = en3;
    }  
}

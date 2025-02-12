/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Dell
 */
public class Proceso {
    private static int contadorID = 0;
    private int id;
    private String nombre;
    private int numeroInstrucciones;
    private int inicioExcepcion;
    private int terminarExcepcion;
    private String tipo;
    private int prioridad;
    private String estado;
    private int PC;
    private int MAR;
    
    //CPU Bound
    public Proceso(String nombre, int numeroInstrucciones, String tipo, int prioridad) {
        this.id = ++contadorID;
        this.nombre = nombre;
        this.numeroInstrucciones = numeroInstrucciones;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.estado = "Listo";
        this.PC = 1;
        this.MAR = PC -1;
    }
    
    //I/O Bound
    public Proceso(String nombre, int numeroInstrucciones, String tipo, int prioridad, int inicioExcepcion, int terminarExcepcion) {
        this.id = ++contadorID;
        this.nombre = nombre;
        this.numeroInstrucciones = numeroInstrucciones;
        this.inicioExcepcion= inicioExcepcion;
        this.terminarExcepcion= terminarExcepcion;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.estado = "Listo";
        this.PC = 1;
        this.MAR = PC -1;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getInicioExcepcion() {
        return inicioExcepcion;
    }

    public void setInicioExcepcion(int inicioExcepcion) {
        this.inicioExcepcion = inicioExcepcion;
    }

    public int getTerminarExcepcion() {
        return terminarExcepcion;
    }

    public void setTerminarExcepcion(int terminarExcepcion) {
        this.terminarExcepcion = terminarExcepcion;
    }
    

    public int getNumeroInstrucciones() {
        return numeroInstrucciones;
    }

    public void setNumeroInstrucciones(int numeroInstrucciones) {
        this.numeroInstrucciones = numeroInstrucciones;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPC() {
        return PC;
    }

    public void setPC(int PC) {
        this.PC = PC;
        this.MAR= PC-1;
    }

    public int getMAR() {
        return MAR;
    }

    public void setMAR(int MAR) {
        this.MAR = MAR;
    }
 
    public String print() {
        String fin = "ID: " + this.id + ", Status: " + this.estado + ", Nombre: " + this.nombre + ", PC: " + this.PC + ", MAR: " + this.MAR;
        return fin;
    }
}

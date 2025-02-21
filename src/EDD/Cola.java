/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

import Objects.Proceso;

/**
 *
 * @author Dell
 */
public class Cola {
    private Node pfirst;
    private Node plast;
    private int size;
    private String result="";


    public Cola() {
        this.pfirst = null;
        this.plast = null;
        this.size = 0;
        this.result="";
    }
    
    public boolean IsEmpty(){
        return pfirst == null;
    }
    
    public void AddElement(Proceso nodo){
        Node newnode = new Node(nodo);
        if (IsEmpty()) {
            pfirst = newnode;
            plast = newnode;
        } else {
            plast.setPnext(newnode);
            plast = newnode;
        }
        size++;        
    }
    
    public synchronized void AddElementP(Proceso el){
        Node nuevoNodo = new Node(el);
        if (IsEmpty()) {
            pfirst = nuevoNodo;
            plast = nuevoNodo;
        } else {
            nuevoNodo.setPnext(pfirst);
            pfirst = nuevoNodo;
        }
        size++;
    }
    
        public Proceso RemoveElement() {
        if (IsEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        Proceso elemento = pfirst.getNodo();
        pfirst = pfirst.getPnext();
        if (pfirst == null) {
            plast = null;
        }
        size--;
        return elemento;
    }
        
        public int GetSize(){
            return size;
        }
        
    public String print() {
        String resultado = "";
        Node actual = pfirst;
        while(actual!=null) {
                Proceso proceso = actual.getNodo();
                resultado += proceso.print()+"\n";
                actual = actual.getPnext();
        }
        return resultado;
    }
        
    public Node getpfirst(){
        return this.pfirst;
    }

    public void setpfirst(Node pfirst) {
        this.pfirst = pfirst;
    }

    public Node getPlast() {
        return plast;
    }

    public void setPlast(Node plast) {
        this.plast = plast;
    }
    
    public Cola copy(){
        Cola r = new Cola();
        Node actual = this.pfirst;
        while(actual!=null){
            r.AddElement(actual.getNodo());
            actual=actual.getPnext();
        }
        return r;
    }
    
}

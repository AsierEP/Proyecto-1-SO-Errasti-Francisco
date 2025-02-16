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

    public Cola() {
        this.pfirst = null;
        this.plast = null;
        this.size = 0;
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
        for (int i = 0; i < size; i++) {
            if (actual != null) {
                Proceso proceso = actual.getNodo();
                resultado += proceso.print()+"\n\n";
                actual = actual.getPnext();
            }
        }
        return resultado;
    }
        
    public Node getpfirst(){
        return this.pfirst;
    }

    public void setFrente(Node pfirst) {
        this.pfirst = pfirst;
    }
    
}

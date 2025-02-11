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
public class Node {
    private Proceso nodo;
    private Node pnext;

    public Node(Proceso nodo) {
        this.nodo = nodo;
        this.pnext = null;
    }

    public Proceso getNodo() {
        return nodo;
    }

    public void setNodo(Proceso nodo) {
        this.nodo = nodo;
    }

    public Node getPnext() {
        return pnext;
    }

    public void setPnext(Node pnext) {
        this.pnext = pnext;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkg1.so.errasti.francisco;
 
/**
 *
 * @author Dell
 */
public class Proyecto1SOErrastiFrancisco {

    public static void main(String[] args) {
        
        LoadArchiveUI loadArchiveUI = new LoadArchiveUI();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoadArchiveUI().setVisible(true);
            }
        });
    }
}
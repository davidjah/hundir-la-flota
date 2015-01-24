/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author David
 */
public class HundirLaFlota {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

}

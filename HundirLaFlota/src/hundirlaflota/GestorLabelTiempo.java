/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author David
 */
public class GestorLabelTiempo extends JLabel {

    public String crono;
    public GestorTiempo hilo;

    public GestorLabelTiempo(String crono) {
        this.crono = crono;
        this.setText(" Tiempo: 0" + crono);

        this.setFont(new Font("Algerian", 0, 50));
        this.setForeground(Color.RED);

    }

    public void Iniciar() {
        hilo = new GestorTiempo(this);
        hilo.start();
    }

    public String getCrono() {
        return crono;
    }

    public GestorTiempo getHilo() {
        return hilo;
    }

}

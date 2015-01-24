/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class GestorJugadores implements MouseListener {

    private final Interfaz interfaz;
    private JFrame jf;

    public GestorJugadores(Interfaz interfaz) {
        this.interfaz = interfaz;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getComponent().equals(interfaz.getJugador1())) {
            String jugador1 = JOptionPane.showInputDialog(jf, "introduce tu nombre", "JUGADOR 1", JOptionPane.INFORMATION_MESSAGE);
            interfaz.getJugador1().setText(jugador1);
        }

        if (me.getComponent().equals(interfaz.getJugador2())) {
            String jugador2 = JOptionPane.showInputDialog(jf, "introduce tu nombre", "JUGADOR 2", JOptionPane.INFORMATION_MESSAGE);
            interfaz.getJugador2().setText(jugador2);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}

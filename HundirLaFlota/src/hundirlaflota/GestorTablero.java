/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class GestorTablero implements MouseListener {

    private Interfaz interfaz;
    private ImageIcon tocado = new ImageIcon(getClass().getResource("/imagenes/xJ.png"));
    private ImageIcon agua = new ImageIcon(getClass().getResource("/imagenes/aguaJ.png"));

    public GestorTablero(Interfaz interfaz) {
        this.interfaz = interfaz;
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        for (int i = 0; i < interfaz.getB1().length; i++) {
            for (int j = 0; j < interfaz.getB1().length; j++) {
                if (me.getComponent().equals(interfaz.getB1()[i][j])) {

                    if (interfaz.getC1() == 5) {
                        ganador(interfaz.getJugador1().getText());
                        interfaz.setC1(0);
                    }

                    if (interfaz.getB2()[i][j].getIcon().equals(interfaz.getAgua())) {
                        interfaz.getAguToc().setText("AGUA!!");
                        interfaz.getAguToc().setForeground(Color.CYAN);
                        interfaz.getB2()[i][j].setIcon(agua);
                    } else if (interfaz.getB2()[i][j].getIcon().equals(interfaz.getBarco())) {
                        interfaz.getAguToc().setText("TOCADO!!");
                        interfaz.getAguToc().setForeground(Color.RED);
                        interfaz.getB2()[i][j].setIcon(tocado);
                        interfaz.setC1(interfaz.getC1() + 1);
                    }
                }
            }
        }

        for (int i = 0; i < interfaz.getB2().length; i++) {
            for (int j = 0; j < interfaz.getB2().length; j++) {
                if (me.getComponent().equals(interfaz.getB2()[i][j])) {

                    if (interfaz.getC2() == 5) {
                        ganador(interfaz.getJugador2().getText());
                        interfaz.setC2(0);
                    }

                    if (interfaz.getB1()[i][j].getIcon().equals(interfaz.getAgua())) {
                        interfaz.getAguToc().setText("¡¡AGUA!!");
                        interfaz.getAguToc().setForeground(Color.CYAN);
                        interfaz.getB1()[i][j].setIcon(agua);
                    } else {
                        interfaz.getAguToc().setText("¡¡TOCADO!!");
                        interfaz.getAguToc().setForeground(Color.RED);
                        interfaz.getB1()[i][j].setIcon(tocado);
                        interfaz.setC2(interfaz.getC2() + 1);
                    }
                }
            }
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

    public void ganador(String jugador) {
        interfaz.getGlt().getHilo().stop();

        JOptionPane.showMessageDialog(null, "GANADOR " + jugador);
        int resp = JOptionPane.showConfirmDialog(null, "¿desea jugar una nueva partida?");
        if (resp == 0) {
            interfaz.nuevaPartida();
        } else if (resp == 1) {
            System.exit(0);
        }
    }
}

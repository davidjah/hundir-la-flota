/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * @author David
 */
public class GestorBotones implements ActionListener {

    private Interfaz interfaz;

    public GestorBotones(Interfaz interfaz) {
        this.interfaz = interfaz;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {

            case "selección aleatoria del primer jugador":

                interfaz.getElecJu().setEnabled(false);

                String uno = interfaz.getJugador1().getText();
                String dos = interfaz.getJugador2().getText();

                String[] jugAle = new String[2];

                jugAle[0] = uno;
                jugAle[1] = dos;

                String aleatorio = jugAle[new Random().nextInt(jugAle.length)];

                interfaz.getElegido().setText(aleatorio + " - ");

                for (int i = 0; i < interfaz.getB1().length; i++) {
                    for (int j = 0; j < interfaz.getB1().length; j++) {
                        interfaz.getB1()[i][j].setEnabled(false);
                    }
                }

                for (int i = 0; i < interfaz.getB2().length; i++) {
                    for (int j = 0; j < interfaz.getB2().length; j++) {
                        interfaz.getB2()[i][j].setEnabled(false);
                    }
                }

//                if (aleatorio.equals(uno)) {
//                    for (int i = 0; i < interfaz.getB1().length; i++) {
//                        for (int j = 0; j < interfaz.getB1().length; j++) {
//                            interfaz.getB1()[i][j].setEnabled(true);
//                        }
//                    }
//
//                    for (int i = 0; i < interfaz.getB2().length; i++) {
//                        for (int j = 0; j < interfaz.getB2().length; j++) {
//                            interfaz.getB2()[i][j].setEnabled(false);
//                        }
//                    }
//                } else {
//                    for (int i = 0; i < interfaz.getB2().length; i++) {
//                        for (int j = 0; j < interfaz.getB2().length; j++) {
//                            interfaz.getB2()[i][j].setEnabled(true);
//                        }
//                    }
//
//                    for (int i = 0; i < interfaz.getB1().length; i++) {
//                        for (int j = 0; j < interfaz.getB1().length; j++) {
//                            interfaz.getB1()[i][j].setEnabled(false);
//                        }
//                    }
//                }
                break;

            case "← cargar barcos":

                interfaz.getGlt().getHilo().stop();
                interfaz.getGlt().Iniciar();

                for (int i = 0; i < interfaz.getB1().length; i++) {
                    for (int j = 0; j < interfaz.getB1().length; j++) {
                        interfaz.getB1()[i][j].setIcon(interfaz.getAgua());
                    }
                }

                for (int x = 0; x < 1; x++) {
                    interfaz.situarBarco1_1();
                    interfaz.situarBarco1_2();
                    interfaz.situarBarco1_3();
                }
                break;

            case "cargar barcos →":

                interfaz.getGlt().getHilo().stop();
                interfaz.getGlt().Iniciar();

                for (int i = 0; i < interfaz.getB2().length; i++) {
                    for (int j = 0; j < interfaz.getB2().length; j++) {
                        interfaz.getB2()[i][j].setIcon(interfaz.getAgua());
                    }
                }

                for (int x = 0; x < 1; x++) {
                    interfaz.situarBarco2_1();
                    interfaz.situarBarco2_2();
                    interfaz.situarBarco2_3();
                }
                break;
        }
    }

}

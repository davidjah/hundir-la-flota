/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author David
 */
public class GestorMenu implements ActionListener {

    private Interfaz interfaz;
    private JDialog jdAcerca;
    private JLabel lblAcerca1;
    private JLabel lblAcerca2;
    private JLabel lblAcerca3;

    public GestorMenu(Interfaz interfaz) {
        this.interfaz = interfaz;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {

            case "Nueva Partida":

                interfaz.nuevaPartida();

                break;

            case "Guardar Partida":
                //serializacion
                break;

            case "Cargar Partida":
                //serializacion
                break;

            case "Salir del Juego":
                System.exit(0);
                break;

            case "A cerca de...":
                jdAcerca = new JDialog();
                jdAcerca.setTitle("Acerca de...");
                jdAcerca.setLayout(new GridLayout(3, 1));
                lblAcerca1 = new JLabel("Nombre: David Herrero Sánchez");
                lblAcerca2 = new JLabel("Profesión: Alumno de 2º de Desarrollo de Aplicaciones Multiplataforma");
                lblAcerca3 = new JLabel("Lugar: Salamanca");
                lblAcerca1.setForeground(Color.GRAY);
                lblAcerca2.setForeground(Color.GRAY);
                lblAcerca3.setForeground(Color.GRAY);
                jdAcerca.add(lblAcerca1);
                jdAcerca.add(lblAcerca2);
                jdAcerca.add(lblAcerca3);
                jdAcerca.getContentPane().setBackground(Color.GREEN);
                jdAcerca.setBounds(10, 10, 10, 10);
                jdAcerca.setSize(425, 150);
                jdAcerca.setVisible(true);
                break;

            case "Estadisticas":
                //mostrar estadisticasdesde un fichero
                break;

        }

    }

}

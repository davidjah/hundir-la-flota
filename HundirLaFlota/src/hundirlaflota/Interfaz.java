/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author David
 */
public class Interfaz extends JFrame {

    private JMenuBar mb;
    private JMenu archivo;
    private JMenu ayuda;
    private JMenuItem nuevoJuego;
    private JMenuItem guardar;
    private JMenuItem cargar;
    private JMenuItem salir;
    private JMenuItem aCerca;
    private JMenuItem estadisticas;
    private KeyStroke ks1;
    private KeyStroke ks2;
    private KeyStroke ks3;
    private KeyStroke ks4;
    private JLabel titulo;
    private JLabel jugador1;
    private JLabel jugador2;
    private JLabel turno;
    private JLabel elegido;
    private JLabel aguToc;
    private JPanel panelSup;
    private JPanel panelSupS;
    private JPanel panelSupI;
    private JPanel panelSupI1;
    private JPanel panelSupI2;
    private JPanel panelSupI3;
    private JPanel panelSupI4;
    private JPanel panelSupI5;
    private JPanel panelMed;
    private JPanel panelInfTot;
    private JPanel panelInf1;
    private JPanel panelInf2;
    private JPanel panelIzda;
    private JPanel panelIzdaI;
    private JPanel panelMedio;
    private JPanel panelDcha;
    private JPanel panelDchaD;
    private JPanel pJug1;
    private JPanel pJug2;
    private JButton[][] b1;
    private JButton[][] b2;
    private JButton elecJu;
    private JButton casillas1;
    private JButton casillas2;
    private GestorLabelTiempo glt;
    private ImageIcon agua;
    private ImageIcon barco;
    private ArrayList<Coordenada> coordenadasOcupadas = new ArrayList<>();
    private boolean yaOcupada = false;
    private int c1 = 0;
    private int c2 = 0;

    public Interfaz() {

        setLayout(new GridLayout(3, 1));

        //MENU
        mb = new JMenuBar();
        setJMenuBar(mb);
        archivo = new JMenu("Archivo");
        ayuda = new JMenu("Ayuda");

        ks1 = KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.SHIFT_MASK);// creo los 3 shortcut
        ks2 = KeyStroke.getKeyStroke(KeyEvent.VK_G, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
        ks3 = KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
        ks4 = KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());

        nuevoJuego = new JMenuItem("Nueva Partida");
        nuevoJuego.setAccelerator(ks1);
        nuevoJuego.addActionListener(new GestorMenu(this));

        guardar = new JMenuItem("Guardar Partida");
        guardar.setAccelerator(ks2);
        guardar.addActionListener(new GestorMenu(this));

        cargar = new JMenuItem("Cargar Partida");
        cargar.setAccelerator(ks3);
        cargar.addActionListener(new GestorMenu(this));

        salir = new JMenuItem("Salir del Juego");
        salir.setAccelerator(ks4);
        salir.addActionListener(new GestorMenu(this));

        aCerca = new JMenuItem("A cerca de...");
        aCerca.addActionListener(new GestorMenu(this));

        estadisticas = new JMenuItem("Estadisticas");
        estadisticas.addActionListener(new GestorMenu(this));

        archivo.add(nuevoJuego);
        archivo.add(guardar);
        archivo.add(cargar);
        archivo.add(salir);

        ayuda.add(aCerca);
        ayuda.add(estadisticas);

        mb.add(archivo);
        mb.add(ayuda);

        //CREACION DE LAS LABEL
        titulo = new JLabel("BATALLA NAVAL");
        titulo.setFont(new Font("Algerian", 0, 80));
        titulo.setForeground(Color.GREEN);

        jugador1 = new JLabel("JUGADOR 1");
        jugador1.setFont(new Font("Algerian", 0, 56));
        jugador1.addMouseListener(new GestorJugadores(this));
        jugador1.setForeground(Color.GREEN);

        jugador2 = new JLabel("JUGADOR 2");
        jugador2.setFont(new Font("Algerian", 0, 56));
        jugador2.addMouseListener(new GestorJugadores(this));
        jugador2.setForeground(Color.GREEN);

        glt = new GestorLabelTiempo("");                                              //label que muestra el tiempo   
        glt.Iniciar();

        turno = new JLabel("TURNO: ");
        turno.setFont(new Font("Algerian", 0, 50));
        turno.setForeground(Color.GREEN);

        elegido = new JLabel("" + " - ");
        elegido.setFont(new Font("Algerian", 0, 50));
        elegido.setForeground(Color.GREEN);

        aguToc = new JLabel("");
        aguToc.setFont(new Font("Algerian", 0, 50));

        //CREACION CASILLAS
        b1 = new JButton[8][8];
        b2 = new JButton[8][8];

        //BOTONES DE ACCION
        elecJu = new JButton("selección aleatoria del primer jugador");
        elecJu.addActionListener(new GestorBotones(this));
        casillas1 = new JButton("← cargar barcos");
        casillas1.addActionListener(new GestorBotones(this));
        casillas2 = new JButton("cargar barcos →");
        casillas2.addActionListener(new GestorBotones(this));

        //PANELES
        panelSup = new JPanel();
        panelSup.setLayout(new GridLayout(2, 1));
        panelSup.setBackground(Color.DARK_GRAY);

        panelSupS = new JPanel();
        panelSupS.setLayout(new FlowLayout());
        panelSupS.setBackground(Color.DARK_GRAY);

        panelSupI = new JPanel();
        panelSupI.setLayout(new GridLayout(1, 5));
        panelSupI.setBackground(Color.DARK_GRAY);

        panelSupI1 = new JPanel();
        panelSupI1.setBackground(Color.DARK_GRAY);

        panelSupI2 = new JPanel();
        panelSupI2.setLayout(new BorderLayout());
        panelSupI2.setBackground(Color.DARK_GRAY);

        panelSupI3 = new JPanel();
        panelSupI3.setBackground(Color.DARK_GRAY);

        panelSupI4 = new JPanel();
        panelSupI4.setLayout(new BorderLayout());
        panelSupI4.setBackground(Color.DARK_GRAY);

        panelSupI5 = new JPanel();
        panelSupI5.setBackground(Color.DARK_GRAY);

        panelMed = new JPanel();
        panelMed.setLayout(new GridLayout(1, 3));
        panelMed.setBackground(Color.DARK_GRAY);

        panelInfTot = new JPanel();
        panelInfTot.setLayout(new GridLayout(2, 1));
        panelInfTot.setBackground(Color.DARK_GRAY);

        panelIzdaI = new JPanel();
        panelIzdaI.setBackground(Color.DARK_GRAY);

        panelIzda = new JPanel();
        panelIzda.setLayout(new BorderLayout());
        panelIzda.setBackground(Color.DARK_GRAY);

        panelMedio = new JPanel();
        panelMedio.setBackground(Color.DARK_GRAY);

        panelDcha = new JPanel();
        panelDcha.setLayout(new BorderLayout());
        panelDcha.setBackground(Color.DARK_GRAY);

        panelDchaD = new JPanel();
        panelDchaD.setBackground(Color.DARK_GRAY);

        pJug1 = new JPanel();
        pJug1.setLayout(new GridLayout(8, 8));

        pJug2 = new JPanel();
        pJug2.setLayout(new GridLayout(8, 8));

        panelInf1 = new JPanel();
        panelInf1.setLayout(new FlowLayout());
        panelInf1.setBackground(Color.DARK_GRAY);

        panelInf2 = new JPanel();
        panelInf2.setLayout(new FlowLayout());
        panelInf2.setBackground(Color.DARK_GRAY);

        add(panelSup);
        add(panelMed);
        add(panelInfTot);

        panelSup.add(panelSupS);

        panelSupS.add(titulo);

        panelSup.add(panelSupI);

        panelSupI.add(panelSupI1);
        panelSupI.add(panelSupI2);
        panelSupI.add(panelSupI3);
        panelSupI.add(panelSupI4);
        panelSupI.add(panelSupI5);

        panelSupI2.add(jugador1, "South");
        panelSupI4.add(jugador2, "South");

        panelMedio.add(elecJu, "Center");
        panelMedio.add(casillas1, "Center");
        panelMedio.add(casillas2, "Center");

        panelMed.add(panelIzdaI);
        panelMed.add(panelIzda);
        panelMed.add(panelMedio);
        panelMed.add(panelDcha);
        panelMed.add(panelDchaD);

        panelIzda.add(pJug1);

        panelDcha.add(pJug2);

        panelInf1.add(turno);
        panelInf1.add(elegido);
        panelInf1.add(glt);

        panelInf2.add(aguToc);

        panelInfTot.add(panelInf1);
        panelInfTot.add(panelInf2);

        //funcionalidades
        agua = new ImageIcon(getClass().getResource("/imagenes/agua.jpg"));
        barco = new ImageIcon(getClass().getResource("/imagenes/barco.jpg"));

        for (int j = 0; j < b1.length; j++) {
            for (int i = 0; i < b1.length; i++) {
                b1[i][j] = new JButton();
                pJug1.add(b1[i][j]);
                b1[i][j].setIcon(agua);
                b1[i][j].addMouseListener(new GestorTablero(this));
            }
        }

        for (int j = 0; j < b2.length; j++) {
            for (int i = 0; i < b2.length; i++) {
                b2[i][j] = new JButton();
                pJug2.add(b2[i][j]);
                b2[i][j].setIcon(agua);
                b2[i][j].addMouseListener(new GestorTablero(this));
            }
        }

        for (int x = 0; x < 1; x++) {
            situarBarco1_1();
            situarBarco1_2();
            situarBarco1_3();
            situarBarco2_1();
            situarBarco2_2();
            situarBarco2_3();
        }

//        if(c1==6){
//            System.out.println("ganaste 1");
//        }
//        
//        if(c2==6){
//            System.out.println("ganaste 2");
//        }
        setSize(1500, 950);
        setResizable(false);
        setVisible(true);
    }

    public void situarBarco1_1() {
        Coordenada c;
        do {
            c = new Coordenada(new Random().nextInt(8), new Random().nextInt(8));
            for (Coordenada coord : coordenadasOcupadas) {
                if (coord == c) {
                    yaOcupada = true;
                    break;
                }
            }
        } while (yaOcupada);

        coordenadasOcupadas.add(c);

        b1[c.getX()][c.getY()].setIcon(barco);
    }

    public void situarBarco1_2() {
        Coordenada c;
        do {
            c = new Coordenada(new Random().nextInt(8), new Random().nextInt(8));
            for (Coordenada coord : coordenadasOcupadas) {
                if (coord == c) {
                    yaOcupada = true;
                    break;
                }
            }
        } while (yaOcupada);

        coordenadasOcupadas.add(c);

        b1[c.getX()][c.getY()].setIcon(barco);

        if (c.getX() == 0) {
            b1[c.getX() + 1][c.getY()].setIcon(barco);
        } else if (c.getX() == 7) {
            b1[c.getX() - 1][c.getY()].setIcon(barco);
        } else if (c.getY() == 0) {
            b1[c.getX()][c.getY() + 1].setIcon(barco);
        } else if (c.getY() == 7) {
            b1[c.getX()][c.getY() - 1].setIcon(barco);
        } else {
            b1[c.getX() + 1][c.getY()].setIcon(barco);
        }
    }

    public void situarBarco1_3() {
        Coordenada c;
        do {
            c = new Coordenada(new Random().nextInt(8), new Random().nextInt(8));
            for (Coordenada coord : coordenadasOcupadas) {
                if (coord == c) {
                    yaOcupada = true;
                    break;
                }
            }
        } while (yaOcupada);

        coordenadasOcupadas.add(c);

        b1[c.getX()][c.getY()].setIcon(barco);

        if (c.getX() == 0) {
            b1[c.getX() + 1][c.getY()].setIcon(barco);
            b1[c.getX() + 2][c.getY()].setIcon(barco);
        } else if (c.getX() == 7) {
            b1[c.getX() - 1][c.getY()].setIcon(barco);
            b1[c.getX() - 2][c.getY()].setIcon(barco);
        } else if (c.getY() == 0) {
            b1[c.getX()][c.getY() + 1].setIcon(barco);
            b1[c.getX()][c.getY() + 2].setIcon(barco);
        } else if (c.getY() == 7) {
            b1[c.getX()][c.getY() - 1].setIcon(barco);
            b1[c.getX()][c.getY() - 2].setIcon(barco);
        } else if (c.getX() == 1) {
            b1[c.getX() + 1][c.getY()].setIcon(barco);
            b1[c.getX() - 1][c.getY()].setIcon(barco);
        } else if (c.getX() == 6) {
            b1[c.getX() - 1][c.getY()].setIcon(barco);
            b1[c.getX() + 1][c.getY()].setIcon(barco);
        } else if (c.getY() == 1) {
            b1[c.getX()][c.getY() + 1].setIcon(barco);
            b1[c.getX()][c.getY() - 1].setIcon(barco);
        } else if (c.getY() == 6) {
            b1[c.getX()][c.getY() - 1].setIcon(barco);
            b1[c.getX()][c.getY() + 1].setIcon(barco);
        } else {
            b1[c.getX() + 1][c.getY()].setIcon(barco);
            b1[c.getX() + 2][c.getY()].setIcon(barco);
        }
    }

    public void situarBarco2_1() {
        Coordenada c;
        do {
            c = new Coordenada(new Random().nextInt(8), new Random().nextInt(8));
            for (Coordenada coord : coordenadasOcupadas) {
                if (coord == c) {
                    yaOcupada = true;
                    break;
                }
            }
        } while (yaOcupada);

        coordenadasOcupadas.add(c);

        b2[c.getX()][c.getY()].setIcon(barco);
    }

    public void situarBarco2_2() {
        Coordenada c;
        do {
            c = new Coordenada(new Random().nextInt(8), new Random().nextInt(8));
            for (Coordenada coord : coordenadasOcupadas) {
                if (coord == c) {
                    yaOcupada = true;
                    break;
                }
            }
        } while (yaOcupada);

        coordenadasOcupadas.add(c);

        b2[c.getX()][c.getY()].setIcon(barco);

        if (c.getX() == 0) {
            b2[c.getX() + 1][c.getY()].setIcon(barco);
        } else if (c.getX() == 7) {
            b2[c.getX() - 1][c.getY()].setIcon(barco);
        } else if (c.getY() == 0) {
            b2[c.getX()][c.getY() + 1].setIcon(barco);
        } else if (c.getY() == 7) {
            b2[c.getX()][c.getY() - 1].setIcon(barco);
        } else {
            b2[c.getX() + 1][c.getY()].setIcon(barco);
        }
    }

    public void situarBarco2_3() {
        Coordenada c;
        do {
            c = new Coordenada(new Random().nextInt(8), new Random().nextInt(8));
            for (Coordenada coord : coordenadasOcupadas) {
                if (coord == c) {
                    yaOcupada = true;
                    break;
                }
            }
        } while (yaOcupada);

        coordenadasOcupadas.add(c);

        b2[c.getX()][c.getY()].setIcon(barco);

        if (c.getX() == 0) {
            b2[c.getX() + 1][c.getY()].setIcon(barco);
            b2[c.getX() + 2][c.getY()].setIcon(barco);
        } else if (c.getX() == 7) {
            b2[c.getX() - 1][c.getY()].setIcon(barco);
            b2[c.getX() - 2][c.getY()].setIcon(barco);
        } else if (c.getY() == 0) {
            b2[c.getX()][c.getY() + 1].setIcon(barco);
            b2[c.getX()][c.getY() + 2].setIcon(barco);
        } else if (c.getY() == 7) {
            b2[c.getX()][c.getY() - 1].setIcon(barco);
            b2[c.getX()][c.getY() - 2].setIcon(barco);
        } else if (c.getX() == 1) {
            b2[c.getX() + 1][c.getY()].setIcon(barco);
            b2[c.getX() - 1][c.getY()].setIcon(barco);
        } else if (c.getX() == 6) {
            b2[c.getX() - 1][c.getY()].setIcon(barco);
            b2[c.getX() + 1][c.getY()].setIcon(barco);
        } else if (c.getY() == 1) {
            b2[c.getX()][c.getY() + 1].setIcon(barco);
            b2[c.getX()][c.getY() - 1].setIcon(barco);
        } else if (c.getY() == 6) {
            b2[c.getX()][c.getY() - 1].setIcon(barco);
            b2[c.getX()][c.getY() + 1].setIcon(barco);
        } else {
            b2[c.getX() + 1][c.getY()].setIcon(barco);
            b2[c.getX() + 2][c.getY()].setIcon(barco);
        }
    }

    public void nuevaPartida() {
        elecJu.setEnabled(true);

        aguToc.setText("");

        elegido.setText("");
        jugador1.setText("JUGADOR 1");
        jugador2.setText("JUGADOR 2");

        getGlt().getHilo().stop();
        getGlt().Iniciar();

        for (int i = 0; i < b1.length; i++) {
            for (int j = 0; j < b1.length; j++) {
                b1[i][j].setIcon(agua);
                b1[i][j].setEnabled(true);
            }
        }

        for (int i = 0; i < b2.length; i++) {
            for (int j = 0; j < b2.length; j++) {
                b2[i][j].setIcon(agua);
                b2[i][j].setEnabled(true);
            }
        }

        for (int x = 0; x < 1; x++) {
            situarBarco1_1();
            situarBarco1_2();
            situarBarco1_3();
            situarBarco2_1();
            situarBarco2_2();
            situarBarco2_3();
        }
    }

    public JLabel getJugador1() {
        return jugador1;
    }

    public JLabel getJugador2() {
        return jugador2;
    }

    public GestorLabelTiempo getGlt() {
        return glt;
    }

    public JButton[][] getB1() {
        return b1;
    }

    public JButton[][] getB2() {
        return b2;
    }

    public ImageIcon getAgua() {
        return agua;
    }

    public JLabel getElegido() {
        return elegido;
    }

    public JButton getElecJu() {
        return elecJu;
    }

    public JLabel getAguToc() {
        return aguToc;
    }

    public ImageIcon getBarco() {
        return barco;
    }

    public int getC1() {
        return c1;
    }

    public int getC2() {
        return c2;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public void setC2(int c2) {
        this.c2 = c2;
    }

}

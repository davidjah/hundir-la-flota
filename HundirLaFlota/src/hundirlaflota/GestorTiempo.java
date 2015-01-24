/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

/**
 *
 * @author David
 */
public class GestorTiempo extends Thread {

    private GestorLabelTiempo crono;
    int contador = 0;//en sg
    long tIni, tFin, difTiempos;//en nsg
    long resto = 0;

    public GestorTiempo(GestorLabelTiempo crono) {
        this.crono = crono;
    }

    @Override
    public void run() {
        tIni = System.nanoTime();

        for (int i = 0; i < 1000000; i++) {
            do {
                tFin = System.nanoTime();
                difTiempos = tFin - tIni + resto;
                if (difTiempos >= 1000000000) {
                    contador++;
                    crono.setText("Tiempo: " + contador);
                    resto = difTiempos - 1000000000;
                }
            } while ((difTiempos < 1000000000));
            tIni = tFin;
        }
    }
}

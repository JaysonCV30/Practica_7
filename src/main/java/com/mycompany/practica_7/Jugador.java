package com.mycompany.practica_7;

import java.util.ArrayList;

public class Jugador {

    private ArrayList<Movible> manoDelJugador;
    private int puntaje = 0;

    public Jugador() {
        manoDelJugador = new ArrayList();
    }

    public void recibirMano(ArrayList<Movible> manoJugador) {
        manoDelJugador = manoJugador;
    }

    public Movible tomarFicha(int indice) {
        return manoDelJugador.remove(indice);
    }

    public boolean fichaIsVolteada(int indice) {
        return true;
    }

    public void ingresarFichaMano(Movible ficha) {
        manoDelJugador.add(ficha);
    }

    public ArrayList<Movible> getMano() {
        return manoDelJugador;
    }

    public int getPuntajeJugador() {
        return puntaje;
    }

    public void calcularPuntaje(int puntosFichaAcutal) {
        puntaje += puntosFichaAcutal;
    }

    public int calcularPuntosDMano() {
        return 0;
    }

    public int getNumeroDFichas() {
        return manoDelJugador.size();
    }

    public void imprimirMano() {
        int count = 1;
        for (Movible elemento : manoDelJugador) {
            System.out.println("indice:" + count + "\n" + elemento);
            count++;
        }
    }

    public void esconderMano() {
    }

    public boolean verificarManoVacia() {
        // System.out.println("El numero de fichas en la mano es:"+mano.size() + " " + mano.isEmpty());
        return manoDelJugador.isEmpty();
    }
}

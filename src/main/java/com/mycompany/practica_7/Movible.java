package com.mycompany.practica_7;

public interface Movible {

    public void rotateRight();
    public void rotateLeft();
    public int contarPuntos();
    public int getNumeroDLados();
    public int getLadoA();
    public int getLadoB();
    public int getLadoC();
    public char validarLado(int caraActual, int caso);
    public int getPosicion();
}

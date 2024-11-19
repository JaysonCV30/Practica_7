package com.mycompany.practica_7;

public class FichaLogica implements Movible {

    protected int ladoA;
    protected int ladoB;
    protected boolean orientacion;
    protected int posicion;

    public FichaLogica(int ladoA, int ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        orientacion = true;
        posicion = 1;
    }

    public int getLadoA() {
        return ladoA;
    }

    public void setLadoA(int ladoA) {
        this.ladoA = ladoA;
    }

    public int getLadoB() {
        return ladoB;
    }

    public int getLadoC() {
        return -1;
    }

    @Override
    public char validarLado(int caraActual, int caso) {
        char resultado = 'n';
        if (ladoA == caraActual) {
            resultado = 'a';
        } else if (ladoB == caraActual) {
            resultado = 'b';
        }
        return resultado;
    }

    public void setLadoB(int ladoB) {
        this.ladoB = ladoB;
    }

    public boolean getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(boolean orientacion) {
        this.orientacion = orientacion;
    }

    @Override
    public String toString() {
        if (orientacion == true) {
            return "     " + ladoA + "\n    ---" + "\n     " + ladoB;
        } else {
            return "  " + "   \n" + "    ";
        }
    }

    public void voltearFicha() {
        orientacion = !orientacion;
    }

    @Override
    public int getPosicion() {
        return posicion;
    }

    @Override
    public void rotateRight() {
        posicion = 1;
        int aux = ladoB;
        ladoB = ladoA;
        ladoA = aux;
    }

    public int getNumeroDLados() {
        return 2;
    }

    @Override
    public void rotateLeft() {
        posicion = 2;
        int aux = ladoA;
        ladoA = ladoB;
        ladoB = aux;
    }

    @Override
    public int contarPuntos() {
        int puntosDLaFicha = ladoA + ladoB;
        return puntosDLaFicha;
    }
}
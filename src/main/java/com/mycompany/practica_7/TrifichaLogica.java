package com.mycompany.practica_7;

public class TrifichaLogica extends FichaLogica implements Movible {

    private int ladoC;

    public TrifichaLogica(int ladoA, int ladoB, int ladoC) {
        super(ladoA, ladoB);
        this.ladoC = ladoC;
        orientacion = true;
        posicion = 0;
    }

    public int getLadoC() {
        return ladoC;
    }

    public void setLadoC(int ladoC) {
        this.ladoC = ladoC;
    }

    @Override
    public int getLadoA() {
        return ladoA;
    }

    @Override
    public void setLadoA(int ladoA) {
        this.ladoA = ladoA;
    }

    @Override
    public int getLadoB() {
        return ladoB;
    }

    @Override
    public void setLadoB(int ladoB) {
        this.ladoB = ladoB;
    }

    @Override
    public boolean getOrientacion() {
        return orientacion;
    }

    @Override
    public void setOrientacion(boolean orientacion) {
        this.orientacion = orientacion;
    }

    @Override
    public int getPosicion() {
        return posicion;
    }

    @Override
    public void voltearFicha() {
        orientacion = !orientacion;
    }

    @Override
    public char validarLado(int caraActual, int caso) {
        char resultado = 'n';

        // Caso 1: Verificar si alguno de los lados coincide
        if (caso == 1) {
            if (ladoA == caraActual) {
                resultado = 'a';
            } else if (ladoB == caraActual) {
                resultado = 'b';
            } else if (ladoC == caraActual) {
                resultado = 'c';
            }
        } 
        else if (caso == 2) {
            // Verificar los tres lados: A, B y C
            if (ladoA == caraActual) {
                resultado = 'a';
            } else if (ladoC == caraActual) {
                resultado = 'c';
            } else if (ladoB == caraActual) {
                resultado = 'b';
            }
        } 
        else if (caso == 3) {
            if (ladoA == caraActual && (ladoA == ladoB || ladoA == ladoC)) {
                resultado = 'a';
            } else if (ladoC == caraActual && (ladoC == ladoA || ladoC == ladoB)) {
                resultado = 'b';
            } else if (ladoB == caraActual && (ladoB == ladoA || ladoB == ladoC)) {
                resultado = 'c';
            }
        } else if (caso == 4) {
            // Verificar los tres lados: A, B y C
            if (ladoB == caraActual) {
                resultado = 'b';
            } else if (ladoA == caraActual) {
                resultado = 'a';
            }
        }

        return resultado;
    }

    @Override
    public void rotateRight() {
        if (posicion == 1) {
            posicion = 0;
        } else {
            posicion++;
            int aux = ladoA;
            ladoA = ladoB;
            ladoB = ladoC;
            ladoC = aux;
        }
    }

    @Override
    public void rotateLeft() {
        if (posicion > 0) {
            posicion--;
            int aux = ladoA;
            ladoA = ladoC;
            ladoC = ladoB;
            ladoB = aux;
        } else {
            posicion = 1;
        }
    }

    @Override
    public String toString() {
        if (orientacion == true) {
            if (posicion == 0) {
                StringBuilder cadena = new StringBuilder();
                cadena.append("     ").append(ladoA).append("\n");
                cadena.append("   " + ladoB).append("   ").append(ladoC).append("\n");
                return cadena.toString();
            } else {
                StringBuilder cadena = new StringBuilder();
                cadena.append("   " + ladoA).append("   ").append(ladoC).append("\n");
                cadena.append("     ").append(ladoB).append("\n");
                return cadena.toString();
            }
        } else {
            StringBuilder cadena = new StringBuilder();
            cadena.append("   ").append(" | | ").append("\n");
            cadena.append(" | |").append("  ").append(" | | ").append("\n");
            return cadena.toString();
        }
    }

    @Override
    public int contarPuntos() {
        int puntosDLaTrificha = ladoA + ladoB + ladoC;
        return puntosDLaTrificha;
    }

    @Override
    public int getNumeroDLados() {
        return 3;
    }
}
package com.mycompany.practica_7;

import java.util.ArrayList;
import java.util.Scanner;

public class CurlysMultiPieceMino {

    private ArrayList<Jugador> jugadores;
    private int turno;
    private Pozo elPozo;
    private ArrayList<Movible> fichasJugadas;
    private int caraActual1;
    private int caraActual2;
    private boolean fichaGirada = false;
    private boolean movimientosDisponibles = true;

    public boolean comprobarMovimientosDisponibles() {
        boolean resultado = false;
        int res;
        for (Jugador jugador : jugadores) {
            for (Movible ficha : jugador.getMano()) {
                res = validarSiguienteFicha(ficha);
                if (res != -1) {
                    resultado = true;
                    break;
                }
            }
            if(resultado) break;
        }
        if (resultado == true) {
            System.out.println("Todavia hay movimientos disponibles");
        } else {
            System.out.println("Ya no hay movimientos disponibles");
        }
        return resultado;
    }

    public CurlysMultiPieceMino() {
        jugadores = new ArrayList();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        elPozo = new Pozo();
        fichasJugadas = new ArrayList();
        caraActual1 = -1;
        caraActual2 = -1;
    }

    public boolean comprobarTridomino(Movible ficha1) {
        boolean resultado = false;
        if (caraActual1 != -1 && caraActual2 != -1) {
            if (ficha1.getNumeroDLados() == 3) {
                resultado = true;
            }
        } else if (caraActual1 != -1 && caraActual2 == -1) {
            resultado = true;
        }
        return resultado;
    }

    public void colocarFichaInicial(Movible ficha1) {
        if (caraActual1 == -1 && caraActual2 == -1) {
            if (ficha1.getNumeroDLados() == 2) {
                caraActual1 = ficha1.getLadoB();
            } else {
                caraActual1 = ficha1.getLadoB();
                caraActual2 = ficha1.getLadoC();
            }
        }
    }

    public boolean comprobarGiroCorrecto(Movible ficha1) {
//System.out.println("Estoy comprobando el giro correcto");
        boolean resultado = false;
        if (caraActual1 != -1 && caraActual2 != -1) {
            if (ficha1.getLadoA() == caraActual1 && ficha1.getLadoC() == caraActual2 && ficha1.
                    getPosicion() != 0) {
                resultado = true;
            } else {
            }
        } else if (caraActual1 != -1 && caraActual2 == -1) {
            if (ficha1.getNumeroDLados() == 2) {
                if (ficha1.getLadoA() == caraActual1) {
                    resultado = true;
                } else {
                }
            } else if (ficha1.getNumeroDLados() == 3) {
                if ((ficha1.getLadoA() == caraActual1) && ficha1.getPosicion() != 1) {
                    resultado = true;
                } else {
                }
            }
        }
        return resultado;
    }

    public void actualizarCarasAct(Movible ficha1) {
        if (ficha1.getPosicion() == 0) {
            caraActual1 = ficha1.getLadoB();
            caraActual2 = ficha1.getLadoC();
        } else {
            caraActual1 = ficha1.getLadoB();
            caraActual2 = -1;
        }
    }

    public int validarSiguienteFicha(Movible fichaValidar) {
        int resultado = -1;
        if (caraActual2 == -1) {
            char tipoDLado1 = fichaValidar.validarLado(caraActual1, 1);
            if (tipoDLado1 == 'n') {
                resultado = -1;
            } else {
                resultado = 1;
            }
        } else {
            if (caraActual1 != caraActual2) {
                char tipoDLado1 = fichaValidar.validarLado(caraActual1, 2);
                char tipoDLado2 = fichaValidar.validarLado(caraActual2, 2);
                if (tipoDLado1 == 'n' || tipoDLado2 == 'n') {
                    resultado = -1;
                } else {
                    resultado = 2;
                }
            } else {
                char tipoDLado1 = fichaValidar.validarLado(caraActual1, 3);
                if (tipoDLado1 == 'n') {
                    resultado = -1;
                } else {
                    resultado = 1;
                }
            }
        }
        return resultado;
    }

    public int validarInicioDelJuego(Movible ficha1, Movible ficha2) {
        if (ficha1.contarPuntos() > ficha2.contarPuntos()) {
            return 1;
        } else {
            return 2;
        }
    }

    public void imprimirFichasJugadas() {
        for (Movible elemento : fichasJugadas) {
            System.out.println(elemento);
        }
        System.out.println("-------------");
    }

    public void cambiarTurno() {
        if (turno == 0) {
            turno = 1;
            fichaGirada = false;
        } else {
            if (turno == 1) {
                turno = 0;
                fichaGirada = false;
            }
        }
    }

    public void determinarGanador() {
        if (jugadores.get(0).getPuntajeJugador() > jugadores.get(1).getPuntajeJugador()) {
            System.out.println("El ganador es el jugador 1 " + "Con un puntaje de " + jugadores.get(0).getPuntajeJugador());
        } else {
            System.out.println("El ganador es el jugador 2 " + "Con un puntaje de " + jugadores.get(1).getPuntajeJugador());
        }
    }

    public int verificarManoVacia() {
        int isVacia = 0;
        if (jugadores.get(0).getMano().isEmpty()) {
            isVacia = 1;
        }
        if (jugadores.get(1).getMano().isEmpty()) {
            isVacia = 2;
        }
        return isVacia;
    }

    public boolean verificarPozoVacio() {
        boolean isVacio = false;
        if (elPozo.getPozo().isEmpty()) {
            isVacio = true;
        }
        return isVacio;
    }

    public void girarFichaCiclo(Movible fichaSeleccionada, String giroA) {
        switch (giroA) {
            case "Derecha":
                System.out.println(fichaSeleccionada);
                fichaSeleccionada.rotateRight();
                System.out.println(fichaSeleccionada);
                break;
            case "Izquierda":
                System.out.println(fichaSeleccionada);
                fichaSeleccionada.rotateLeft();
                System.out.println(fichaSeleccionada);
                break;
            case "No":
                System.out.println("No se girara la ficha");
                fichaGirada = comprobarGiroCorrecto(fichaSeleccionada);
                if (!fichaGirada) {
                    System.out.println(
                            "La ficha no encaja en el tablero, siga girando hasta que encaje, por favor");
                } else {
                    fichasJugadas.add(fichaSeleccionada);
                    jugadores.get(turno).calcularPuntaje(fichaSeleccionada.contarPuntos());
                    actualizarCarasAct(fichaSeleccionada);
                }
                break;
            default:
                System.out.println("Opción no válida. Por favor, ingresa 'Derecha', 'Izquierda' o 'No'.");
        }
    }

    public boolean juegoTerminado(){
        return verificarManoVacia() != 0 && verificarPozoVacio() && !comprobarMovimientosDisponibles();
    }
    
    public void jugar() {
        int validacionFichaSeleccionada = -1;
        int indiceFichaDLaMano = 0;
        int indiceFichaDLaMano2 = 0;
        Scanner scanner = new Scanner(System.in);
        elPozo.llenarPozo(6);
        elPozo.mezclarTodasLasFichas();
        jugadores.get(0).recibirMano(elPozo.repartirMano());
        jugadores.get(1).recibirMano(elPozo.repartirMano());
        System.out.println("La mano del jugador 1 es:");
        jugadores.get(0).imprimirMano();
        do {
            System.out.println("Selecciona una ficha para comprobar quien inicia el juego:");
            indiceFichaDLaMano = scanner.nextInt();
        } while (indiceFichaDLaMano <= 0 || indiceFichaDLaMano > jugadores.get(0).getNumeroDFichas());
        Movible fichaSeleccionada = jugadores.get(0).tomarFicha(indiceFichaDLaMano - 1);
        System.out.println(fichaSeleccionada.toString());
        System.out.println("La mano del jugador 2 es:");
        jugadores.get(1).imprimirMano();
        do {
            System.out.println("Selecciona una ficha para comprobar quien inicia el juego:");
            indiceFichaDLaMano2 = scanner.nextInt();
        } while (indiceFichaDLaMano2 <= 0 || indiceFichaDLaMano2 > jugadores.get(1).getNumeroDFichas());
        Movible fichaSeleccionada2 = jugadores.get(1).tomarFicha(indiceFichaDLaMano2 - 1);
        System.out.println(fichaSeleccionada2.toString());
        int primerJugador = validarInicioDelJuego(fichaSeleccionada, fichaSeleccionada2);
        if (primerJugador == 1) {
            System.out.println("El jugador 1 comenzara la partida");
            fichasJugadas.add(fichaSeleccionada);
            colocarFichaInicial(fichaSeleccionada);
            turno = 1;
            jugadores.get(turno).ingresarFichaMano(fichaSeleccionada2);
        } else {
            System.out.println("El jugador 2 comenzara la partida");
            fichasJugadas.add(fichaSeleccionada2);
            colocarFichaInicial(fichaSeleccionada2);
            turno = 0;
            jugadores.get(turno).ingresarFichaMano(fichaSeleccionada);
        }
        imprimirFichasJugadas();
        //Aqui inicia el juego 
        while (!juegoTerminado()){
            int fichaAJugar = 0;
            System.out.println("El jugador que sigue es el :" + (turno + 1));
            System.out.println("Las fichas que restan del pozo son: " + elPozo.getSize());
            System.out.println("Las caras disponibles son: " + caraActual1 + " " + caraActual2);
            jugadores.get(turno).imprimirMano();
            do {
                System.out.println("Ingresa la ficha que quieres jugar");
                fichaAJugar = scanner.nextInt();
                scanner.nextLine();
            } while (fichaAJugar <= 0 || fichaAJugar > jugadores.get(turno).getNumeroDFichas());
            fichaSeleccionada = jugadores.get(turno).tomarFicha(fichaAJugar - 1);
            System.out.println(fichaSeleccionada);
            boolean validacionTrinomino = comprobarTridomino(fichaSeleccionada);
            if (!validacionTrinomino) {
                System.out.println(
                        "Solo se aceptan fichas tridomino para el tablero actual");
                validacionFichaSeleccionada = -1;
            } else {
                validacionFichaSeleccionada = validarSiguienteFicha(fichaSeleccionada);
            }
            if (validacionFichaSeleccionada == -1) {
                System.out.println("El jugador que sigue es el: " + (turno + 1));
                System.out.println("Las fichas que restan del pozo son: " + elPozo.getSize());
                System.out.println("Las caras disponibles son: " + caraActual1 + " " + caraActual2);
                System.out.println("Elegiste una ficha que no se puede jugar, se te dieron dos fichas del pozo");
                jugadores.get(turno).ingresarFichaMano(fichaSeleccionada);
                jugadores.get(turno).ingresarFichaMano(elPozo.repartirFicha());
                jugadores.get(turno).ingresarFichaMano(elPozo.repartirFicha());
                imprimirFichasJugadas();
                System.out.println("Las caras disponibles son: " + caraActual1 + " " + caraActual2);
                jugadores.get(turno).imprimirMano();
                do {
                    System.out.println("Ingresa nuevamente la ficha que quieres jugar");
                    fichaAJugar = scanner.nextInt();
                    scanner.nextLine();
                } while (fichaAJugar < 0 || fichaAJugar > jugadores.get(turno).getNumeroDFichas());
                fichaSeleccionada = jugadores.get(turno).tomarFicha(fichaAJugar - 1);
                System.out.println(fichaSeleccionada);
                validacionTrinomino = comprobarTridomino(fichaSeleccionada);
                if (!validacionTrinomino) {
                    System.out.println("Solo se aceptan fichas tridomino para el tablero actual");
                    validacionFichaSeleccionada = -1;
                } else {
                    validacionFichaSeleccionada = validarSiguienteFicha(fichaSeleccionada);
                }
                if (validacionFichaSeleccionada == -1) {
                    jugadores.get(turno).ingresarFichaMano(fichaSeleccionada);
                    System.out.println("Ingreso una ficha Invalida nuevamente,se pasara turno");
                } else {
                    while (!fichaGirada) {
                        System.out.println("Quieres girar la ficha(Derecha) / (Izquierda) / (No) ");
                        String op = scanner.nextLine();
                        girarFichaCiclo(fichaSeleccionada, op);
                    }
                }
            } else {
                while (!fichaGirada) {
                    System.out.println("Quieres girar la ficha(Derecha) / (Izquierda) / (No) ");
                    String op = scanner.nextLine();
                    switch (op) {
                        case "Derecha":
                            System.out.println(fichaSeleccionada);
                            fichaSeleccionada.rotateRight();
                            System.out.println(fichaSeleccionada);
                            break;
                        case "Izquierda":
                            System.out.println(fichaSeleccionada);
                            fichaSeleccionada.rotateLeft();
                            System.out.println(fichaSeleccionada);
                            break;
                        case "No":
                            System.out.println("No se girara la ficha");
                            fichaGirada = comprobarGiroCorrecto(fichaSeleccionada);
                            if (!fichaGirada) {
                                System.out.println(
                                        "La ficha no encaja en el tablero, siga girando hasta que encaje, por favor");
                            } else {
                                fichasJugadas.add(fichaSeleccionada);
                                jugadores.get(turno).calcularPuntaje(fichaSeleccionada.contarPuntos());
                                actualizarCarasAct(fichaSeleccionada);
                            }
                            break;
                        default:
                            System.out.println("Opción no válida. Por favor, ingresa 'Derecha', 'Izquierda'o 'No'.");
                    }
                }
            }
            System.out.println("El puntaje del jugador" + ((turno) + 1) + " :"
                    + jugadores.get(turno).getPuntajeJugador());
            cambiarTurno();
            if (elPozo.getPozo().isEmpty()) {
                movimientosDisponibles = comprobarMovimientosDisponibles();
            }
            imprimirFichasJugadas();
        }
        determinarGanador();
    }
}

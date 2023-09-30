import java.util.Random;

public class TableroTicTacToe {
    private char[][] tablero;

    public TableroTicTacToe() {
        // Inicializamos el tablero con espacios en blanco
        tablero = new char[3][3];
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                tablero[fila][columna] = ' ';
            }
        }
    }

    public void mostrarTablero() {
        System.out.println("  0 1 2");
        for (int fila = 0; fila < 3; fila++) {
            System.out.print(fila + " ");
            for (int columna = 0; columna < 3; columna++) {
                System.out.print(tablero[fila][columna]);
                if (columna < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (fila < 2) {
                System.out.println("  -----");
            }
        }
    }
    
    public void colocarElemento(int fila, int columna, char elemento) {
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ') {
            tablero[fila][columna] = elemento;
        } else {
            System.out.println("Movimiento inválido. Introduce una fila y columna válidas.");
        }
    }
    
    public void realizarJugadaEstrategica(char elemento) {
        // Implementa aquí tu estrategia para seleccionar la posición estratégica
        // Este es solo un ejemplo simple que elige una posición aleatoria disponible.

        Random rand = new Random();
        int fila, columna;

        do {
            fila = rand.nextInt(3);
            columna = rand.nextInt(3);
        } while (tablero[fila][columna] != ' ');

        tablero[fila][columna] = elemento;
    }
    
    public String evaluarEstadoTablero() {
    // Comprobar si hay un ganador en filas, columnas o diagonales
    for (int i = 0; i < 3; i++) {
        if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
            if (tablero[i][0] == 'X') {
                return "Gana X";
            } else if (tablero[i][0] == 'O') {
                return "Gana O";
            }
        }
        if (tablero[0][i] == tablero[1][i] && tablero[1][i] == tablero[2][i]) {
            if (tablero[0][i] == 'X') {
                return "Gana X";
            } else if (tablero[0][i] == 'O') {
                return "Gana O";
            }
        }
    }

    // Comprobar si hay un ganador en diagonales
    if ((tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) ||
        (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0])) {
        if (tablero[1][1] == 'X') {
            return "Gana X";
        } else if (tablero[1][1] == 'O') {
            return "Gana O";
        }
    }

    // Comprobar si hay posiciones vacías
    for (int fila = 0; fila < 3; fila++) {
        for (int columna = 0; columna < 3; columna++) {
            if (tablero[fila][columna] == ' ') {
                return "El juego continúa";
            }
        }
    }

    // Si no hay ganador y no quedan posiciones vacías, es un empate
    return "Juego sin ganadores";
}

    // Métodos adicionales para realizar movimientos, comprobar victoria, etc.
    public static void main(String args[]) {
      TableroTicTacToe tablero = new TableroTicTacToe();
      
      tablero.realizarJugadaEstrategica('X');
      tablero.realizarJugadaEstrategica('O');
      tablero.realizarJugadaEstrategica('X');
      tablero.realizarJugadaEstrategica('O');
      tablero.realizarJugadaEstrategica('X');
      tablero.realizarJugadaEstrategica('O');
      tablero.realizarJugadaEstrategica('X');
      tablero.realizarJugadaEstrategica('O');
      tablero.mostrarTablero();
       System.out.println("Estadotablero = " + tablero. evaluarEstadoTablero());
    }
}


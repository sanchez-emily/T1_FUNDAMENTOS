// ITESS-TICS 2026
// Periodo Agosto-Sptiembre
// Estructura y Organización de Datos
// Tema 1. Fundamentos de Estructura de datos
// 1.3 Estructura lineal y no lineal
// 1.4 Estructura estática y dinámica

// Compilar: javac ScoreBoardApp.java
// Test: java ScoreBoardApp < caso1.txt

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// declarar datos
class GameEntry {
    private String name; 
    private int score;

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }

    @Override
    public String toString() {
        return name + ": " + score;
    }
}

// hacer la score board
class ScoreBoard {
    private final int MAX_SIZE = 5; 
    private GameEntry[] scores;
    private int numEntries; 

    public ScoreBoard() {
        scores = new GameEntry[MAX_SIZE];
        numEntries = 0; 
    }

    // evalua que hacer en cada posible caso
    public void insert(GameEntry entry) {
        int newScore = entry.getScore();

        // si está vacía
        if (numEntries == 0) {
            scores[0] = entry;
            numEntries++;
            return;
        }

        // si está llena
        if (numEntries == MAX_SIZE) {
            int ultimoScore = scores[MAX_SIZE - 1].getScore();
            if (newScore <= ultimoScore) {
                return; // Nodo: Nada (Se ignora)
            }
        }

        // comparar con el puntaje más bajo que haya (X >= Y)
        int ultimoActual = scores[numEntries - 1].getScore();
        
        if (numEntries < MAX_SIZE && newScore <= ultimoActual) {
            // SÍ -> Se añade al final del bloque ocupado
            scores[numEntries] = entry;
            numEntries++;
        } else {
            // NO -> Hace Shift con los menores
            int i = numEntries - 1;
            
            while (i >= 0 && scores[i].getScore() < newScore) {
                if (i + 1 < MAX_SIZE) {
                    scores[i + 1] = scores[i]; // Desplazamiento a la derecha
                }
                i--;
            }
            
            scores[i + 1] = entry; // Insert en lugar que se liberó
            
            if (numEntries < MAX_SIZE) {
                numEntries++;
            }
        }
    }

    public void showScore() {
        System.out.println("\nScoreBoard");
        for (int i = 0; i < numEntries; i++) {
            System.out.println(i + " -> " + scores[i]);
        }
    }
}

// clase pricipal, solo puede haber una public class
public class ScoreBoardApp {

    public static void main(String[] args) {
        
        FastReader reader = new FastReader();
        ScoreBoard scoreBoard = new ScoreBoard();

        
        while (true) {
            String nombre = reader.next();
            
            if (nombre == null || nombre.isEmpty()) {
                break;
            }
            
            int puntaje = reader.nextInt();
            System.out.println("Procesando: " + nombre + " con " + puntaje);
            
            GameEntry nuevaEntrada = new GameEntry(nombre, puntaje);
            scoreBoard.insert(nuevaEntrada);
        }

        // Imprimir el resultado 
        scoreBoard.showScore();
    }

    // Fast reader
    static class FastReader {
        BufferedReader b;
        StringTokenizer s; 

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    String line = b.readLine();
                    if (line == null) return null; 
                    s = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
            return s.nextToken();
        }

        int nextInt() { 
            return Integer.parseInt(next()); 
        }

        char nextChar() {
            return next().charAt(0);
        }
    }
}

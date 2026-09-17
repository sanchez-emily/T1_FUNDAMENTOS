import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Ejercicio 2 (7.9). Lee una matriz entera t de 2 filas por 3 columnas,
 * la muestra en forma tabular, indica su menor valor y suma la columna 2.
 *
 * Entrada: seis enteros, por filas.
 */
public class Ejercicio2_Matriz23 {
    private final FastReader reader = new FastReader();
    private final int[][] t = new int[2][3];

    static class FastReader {
        private final BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokens;

        String next() throws IOException {
            while (tokens == null || !tokens.hasMoreTokens()) {
                String line = buffer.readLine();
                if (line == null) {
                    return null;
                }
                tokens = new StringTokenizer(line);
            }
            return tokens.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    private void leerDatos() throws IOException {
        for (int fila = 0; fila < t.length; fila++) {
            for (int columna = 0; columna < t[fila].length; columna++) {
                t[fila][columna] = reader.nextInt();
            }
        }
    }

    private void resolver() {
        int menor = t[0][0];
        int sumaTerceraColumna = 0;

        System.out.println("     C0   C1   C2");
        for (int fila = 0; fila < t.length; fila++) {
            System.out.printf("F%d ", fila);
            for (int columna = 0; columna < t[fila].length; columna++) {
                System.out.printf("%4d ", t[fila][columna]);
                if (t[fila][columna] < menor) {
                    menor = t[fila][columna];
                }
            }
            sumaTerceraColumna += t[fila][2];
            System.out.println();
        }

        System.out.println("Menor valor: " + menor);
        System.out.println("Suma de la tercera columna: " + sumaTerceraColumna);
    }

    public static void main(String[] args) throws IOException {
        Ejercicio2_Matriz23 programa = new Ejercicio2_Matriz23();
        programa.leerDatos();
        programa.resolver();
    }
}

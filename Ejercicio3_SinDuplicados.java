import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Ejercicio 3 (7.12). Lee cinco enteros entre 10 y 100 y conserva solo
 * los valores no repetidos. Al terminar cada lectura muestra los unicos.
 */
public class Ejercicio3_SinDuplicados {
    private final FastReader reader = new FastReader();
    private final int[] unicos = new int[5];
    private int cantidadUnicos;

    static class FastReader {
        private final BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokens;

        String next() throws IOException {
            while (tokens == null || !tokens.hasMoreTokens()) {
                String line = buffer.readLine();
                if (line == null) return null;
                tokens = new StringTokenizer(line);
            }
            return tokens.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    private boolean yaExiste(int valor) {
        for (int i = 0; i < cantidadUnicos; i++) {
            if (unicos[i] == valor) return true;
        }
        return false;
    }

    private void imprimirUnicos() {
        System.out.print("Valores unicos: ");
        for (int i = 0; i < cantidadUnicos; i++) System.out.print(unicos[i] + " ");
        System.out.println();
    }

    private void leerYResolver() throws IOException {
        for (int lectura = 0; lectura < 5; lectura++) {
            int valor = reader.nextInt();
            if (valor < 10 || valor > 100) {
                throw new IllegalArgumentException("Cada valor debe estar entre 10 y 100.");
            }
            if (!yaExiste(valor)) unicos[cantidadUnicos++] = valor;
            imprimirUnicos();
        }
    }

    public static void main(String[] args) throws IOException {
        new Ejercicio3_SinDuplicados().leerYResolver();
    }
}

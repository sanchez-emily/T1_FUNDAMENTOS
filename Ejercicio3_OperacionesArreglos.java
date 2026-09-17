import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Ejercicio 3 (7.11). Demuestra las operaciones pedidas en arreglos.
 * Entrada: 15 enteros para bono y 5 enteros para mejoresPuntuaciones.
 */
public class Ejercicio3_OperacionesArreglos {
    private final FastReader reader = new FastReader();
    private final int[] cuentas = new int[10];
    private final int[] bono = new int[15];
    private final int[] mejoresPuntuaciones = new int[5];

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

    private void leerDatos() throws IOException {
        for (int i = 0; i < bono.length; i++) bono[i] = reader.nextInt();
        for (int i = 0; i < mejoresPuntuaciones.length; i++) mejoresPuntuaciones[i] = reader.nextInt();
    }

    private void resolver() {
        // a) cuentas ya inicia con diez ceros; se expresa explicitamente para la consigna.
        for (int i = 0; i < cuentas.length; i++) cuentas[i] = 0;

        // b) Incrementar cada bono.
        for (int i = 0; i < bono.length; i++) bono[i]++;

        // c) Imprimir las cinco puntuaciones en columnas.
        System.out.println("Mejores puntuaciones:");
        for (int puntuacion : mejoresPuntuaciones) System.out.printf("%d%n", puntuacion);

        System.out.print("Bonos incrementados: ");
        for (int valor : bono) System.out.print(valor + " ");
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Ejercicio3_OperacionesArreglos programa = new Ejercicio3_OperacionesArreglos();
        programa.leerDatos();
        programa.resolver();
    }
}

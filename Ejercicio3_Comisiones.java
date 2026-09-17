import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Ejercicio 3 (7.10). Clasifica el salario semanal de vendedores.
 * Entrada: N y despues N ventas semanales (una por vendedor).
 */
public class Ejercicio3_Comisiones {
    private final FastReader reader = new FastReader();
    private final int[] rangos = new int[9];

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
        int vendedores = reader.nextInt();
        for (int i = 0; i < vendedores; i++) {
            int ventas = reader.nextInt();
            int salario = 200 + (int) (ventas * 0.09); // truncado a entero
            int indice = salario >= 1000 ? 8 : (salario - 200) / 100;
            rangos[indice]++;
        }
    }

    private void resolver() {
        System.out.println("Rango salarial   Vendedores");
        for (int i = 0; i < rangos.length; i++) {
            String rango = i == 8 ? "$1000 o mas" : String.format("$%d-%d", 200 + i * 100, 299 + i * 100);
            System.out.printf("%-16s %d%n", rango, rangos[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        Ejercicio3_Comisiones programa = new Ejercicio3_Comisiones();
        programa.leerDatos();
        programa.resolver();
    }
}

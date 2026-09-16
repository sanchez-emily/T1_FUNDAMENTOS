    import java.util.Random;

public class SimulacionDados {

    // Atributos
    private static final int TOTAL_TIROS = 36000000;
    private static final int[] frecuencias = new int[13]; // Índices del 2 al 12
    private static final Random valoresAleatorios = new Random();

    public static void main(String[] args) {
        simularTiros();
        mostrarTabla();
    }

    // Simulación de lanzamientos 

    private static void simularTiros() {
        for (int tiro = 0; tiro < TOTAL_TIROS; tiro++) {
            // El nextInt(6) genera de 0 a 5, se suma 1 para que dé de 1 a 6
            int dado1 = 1 + valoresAleatorios.nextInt(6); 
            int dado2 = 1 + valoresAleatorios.nextInt(6); 
            int suma = dado1 + dado2;
            
            // Se pasa el resultado al arreglo
            frecuencias[suma]++;
        }
    }

    // Imprimir la tabla
    
    private static void mostrarTabla() {
        System.out.printf("%-10s %-15s%n", "Suma", "Frecuencia");
        System.out.println("--------------------------");
        
        for (int suma = 2; suma <= 12; suma++) {
            System.out.printf("%-10d %-15d%n", suma, frecuencias[suma]);
        }
    }
}



public class Ejercicio1 {
    public static void main(String[] args) {
  
        int[] f = new int[10];
        int[] g = new int[5];
        double[] c = new double[100];
        int[] a = new int[11];
        int[] b = new int[34];
        double[] w = new double[99];


        // a)
        System.out.println(f[5]);

        // b)
        for (int i = 0; i < g.length; i++) {
            g[i] = 8;
        }

        // c)
        double total = 0.0;
        for (int i = 0; i < c.length; i++) {
            total += c[i];
        }

        // d)
        System.arraycopy(a, 0, b, 0, 11);

        // e)
        double menor = w[0];
        double mayor = w[0];

        for (int i = 1; i < w.length; i++) {
            if (w[i] < menor) {
                menor = w[i];
            }
            if (w[i] > mayor) {
                mayor = w[i];
            }
        }

        System.out.println("Menor: " + menor);
        System.out.println("Mayor: " + mayor);
    }
}

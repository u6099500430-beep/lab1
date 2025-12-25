public class LabTask {
    public static void main(String[] args) {
        long[] w = createWArray();
        double[] x = createXArray();
        double[][] l = new double[w.length][x.length];

        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < x.length; j++) {
                l[i][j] = calculateElement(w[i], x[j]);
            }
        }
        printMatrix(l);
    }

    public static double calculateElement(long wi, double x) {
        if (wi == 8) {
            double lnPart = Math.log(Math.abs(x));
            double a = Math.pow(0.25 / (lnPart + 1), 3);
            double b = Math.pow(Math.cbrt(x) * (0.5 + x), 2) + 1;
            double denom = Math.pow(x * (1 - x), 2);
            double exponent = b / denom;
            return Math.pow(a, exponent);
        }
        else if (wi == 5 || wi == 6 || wi == 7 || wi == 12 || wi == 15) {
            return Math.tan(Math.asin(Math.cos((x))));

        } else {
            double inner = Math.sin(Math.cos(x));
            double pow = Math.sin(inner) * Math.sin(inner);
            double value = 0.2 * Math.exp(pow);
            return Math.asin(value);
        }
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%.5f ", val);
            }
            System.out.println();
        }
    }

    public static long[] createWArray() {
        long[] w = new long[11];
        for (int i = 0; i < w.length; i++) {
            w[i] = 15 - i;
        }
        return w;
    }

    public static double[] createXArray() {
        double[] x = new double[17];
        for (int j = 0; j < x.length; j++) {
            x[j] = -9.0 + Math.random() * 13.0;
        }
        return x;
    }
}
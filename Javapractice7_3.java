import java.util.Scanner;

public class Javapractice7_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        double[][] a = new double[n][n];

        System.out.println("Введите элементы матрицы 5x5:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextDouble();

        double det = 1;
        for (int i = 0; i < n; i++) {
            if (a[i][i] == 0) {
                int k = i + 1;
                while (k < n && a[k][i] == 0) k++;
                if (k == n) {
                    det = 0;
                    break;
                }
                for (int j = 0; j < n; j++) {
                    double t = a[i][j];
                    a[i][j] = a[k][j];
                    a[k][j] = t;
                }
                det = -det;
            }

            det *= a[i][i];
            for (int k = i + 1; k < n; k++) {
                double c = a[k][i] / a[i][i];
                for (int j = i; j < n; j++) {
                    a[k][j] -= c * a[i][j];
                }
            }
        }

        System.out.println("Определитель = " + det);
        sc.close();
    }
}

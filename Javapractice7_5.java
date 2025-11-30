import java.util.Scanner;

public class Javapractice7_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите размер матрицы: ");
        int n = sc.nextInt();

        double[][] a = new double[n][n];
        double[][] t = new double[n][n];

        System.out.println("Введите элементы квадратной матрицы:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextDouble();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                t[j][i] = a[i][j];

        System.out.println("Транспонированная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(t[i][j] + " ");
            System.out.println();
        }

        sc.close();
    }
}

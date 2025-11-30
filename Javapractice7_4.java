import java.util.Scanner;

public class Javapractice7_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите размер матрицы: ");
        int n = sc.nextInt();

        double[][] a = new double[n][n];

        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextDouble();

        System.out.print("Введите номер строки: ");
        int r = sc.nextInt();
        System.out.print("Введите номер столбца: ");
        int c = sc.nextInt();

        double[][] m = new double[n - 1][n - 1];
        int x = 0, y;

        for (int i = 0; i < n; i++) {
            if (i == r) continue;
            y = 0;
            for (int j = 0; j < n; j++) {
                if (j == c) continue;
                m[x][y] = a[i][j];
                y++;
            }
            x++;
        }

        System.out.println("Минор:");
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++)
                System.out.print(m[i][j] + " ");
            System.out.println();
        }

        sc.close();
    }
}

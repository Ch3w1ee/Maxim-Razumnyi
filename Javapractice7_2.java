import java.util.Scanner;

public class Javapractice7_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество строк: ");
        int n = sc.nextInt();
        System.out.print("Введите количество столбцов: ");
        int m = sc.nextInt();

        double[][] a = new double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = Math.random() * 10;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i % 2 != 0 || j % 2 != 0) {
                    a[i][j] = Math.sqrt(a[i][j]);
                }
            }
        }

        System.out.println("Результат:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) System.out.print(a[i][j] + " ");
            System.out.println();
        }

        sc.close();
    }
}

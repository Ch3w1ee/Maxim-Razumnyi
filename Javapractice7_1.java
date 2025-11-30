import java.util.Scanner;

public class Javapractice7_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите высоту пирамиды: ");
        int n = sc.nextInt();

        int[][] a = new int[n][];
        int value = 1;

        for (int i = 0; i < n; i++) {
            a[i] = new int[i + 1];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = value;
                value++;
            }
        }

        System.out.println("Обычный вывод:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < a[i].length; j++) System.out.print(a[i][j] + " ");
            System.out.println();
        }

        System.out.println("Обратный вывод:");
        for (int i = n - 1; i >= 0; i--) {
            for (int j = a[i].length - 1; j >= 0; j--) System.out.print(a[i][j] + " ");
            System.out.println();
        }

        sc.close();
    }
}


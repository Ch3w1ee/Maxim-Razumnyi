import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Javapractice6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Выберите задачу (1-5), 0 – выход");

        while (true) {
            int c = sc.nextInt();
            if (c == 0) break;

            if (c == 1) {
                System.out.println("Введите размер массива:");
                int n = sc.nextInt();
                int[] a = new int[n];
                int even = 0, odd = 0;
                for (int i = 0; i < n; i++) {
                    a[i] = r.nextInt(100) - 50;
                    if (a[i] % 2 == 0) even++; else odd++;
                }
                for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
                System.out.println("\nЧетных: " + even + " Нечетных: " + odd);
            }

            else if (c == 2) {
                System.out.println("Введите количество углов:");
                int n = sc.nextInt();
                double[] x = new double[n];
                double s = 0;

                System.out.println("Введите углы многоугольника:");
                for (int i = 0; i < n; i++) {
                    x[i] = sc.nextDouble();
                    s += x[i];
                }

                double need = 180 * (n - 2);
                if (Math.abs(s - need) < 1e-6) System.out.println("Многоугольник возможен");
                else System.out.println("Многоугольник невозможен");
            }

            else if (c == 3) {
                System.out.println("Введите размер массива:");
                int n = sc.nextInt();
                int[] a = new int[n];

                System.out.println("Введите элементы массива:");
                for (int i = 0; i < n; i++) a[i] = sc.nextInt();

                System.out.println("Введите значение, которое нужно найти:");
                int f = sc.nextInt();

                System.out.println("Введите новое значение для замены:");
                int rep = sc.nextInt();

                for (int i = 0; i < n; i++) {
                    if (a[i] == f) { a[i] = rep; break; }
                }

                System.out.println("Массив после замены:");
                for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
                System.out.println();
            }

            else if (c == 4) {
                System.out.println("Таблица синусов от 0 до 90 градусов:");
                int k = 0;
                for (int d = 0; d <= 90; d++) {
                    double s = Math.sin(Math.toRadians(d));
                    System.out.printf("%3d°: %.5f\t", d, s);
                    k++;
                    if (k % 10 == 0) System.out.println();
                }
                System.out.println();
            }

            else if (c == 5) {
                System.out.println("Введите размер массива:");
                int n = sc.nextInt();
                int[] a = new int[n];

                System.out.println("Введите элементы массива:");
                for (int i = 0; i < n; i++) a[i] = sc.nextInt();

                System.out.println("Выберите порядок проверки: 1 – по возрастанию, 2 – по убыванию:");
                int mode = sc.nextInt();

                boolean ok = true;
                if (mode == 1) {
                    for (int i = 1; i < n; i++) if (a[i] < a[i - 1]) ok = false;
                } else {
                    for (int i = 1; i < n; i++) if (a[i] > a[i - 1]) ok = false;
                }

                if (ok) System.out.println("Да");
                else System.out.println("Нет");
            }
        }

        sc.close();
    }
}

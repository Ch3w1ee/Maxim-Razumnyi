import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите начало диапазона: ");
        int start = sc.nextInt();

        System.out.print("Введите конец диапазона: ");
        int end = sc.nextInt();

        System.out.print("Введите число для проверки кратности: ");
        int divisor = sc.nextInt();

        System.out.println("Результат:");
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) continue;
            if (i % divisor == 0) continue;
            System.out.print(i + " ");
        }

        sc.close();
    }
}

import java.util.Scanner;

public class task2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите a: ");
        double a = sc.nextDouble();

        System.out.print("Введите b: ");
        double b = sc.nextDouble();

        System.out.print("Введите x: ");
        double x = sc.nextDouble();

        double f;

        if (x >= 0 && x < 2) {
            f = Math.sin(x);
        } else if (x == 2) {
            f = 2 * Math.exp(a * x);
        } else if (x > 2 && x <= 8) {
            f = 1.0 / (b * x + a);
        } else {
            f = Double.NaN;
        }

        System.out.println("f(x) = " + f);
    }
}

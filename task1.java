import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите три стороны треугольника: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("Треугольник существует.");
            
            if (a == b && b == c) {
                System.out.println("Треугольник равносторонний.");
            } else if (a == b || b == c || a == c) {
                System.out.println("Треугольник равнобедренный.");
            } else {
                System.out.println("Треугольник разносторонний.");
            }
        } else {
            System.out.println("Треугольник с такими сторонами не существует.");
        }

        sc.close();
    }
}
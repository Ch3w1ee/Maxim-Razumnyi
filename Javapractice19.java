import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Javapractice19 {

    public static void bubbleSort(int[] arr, boolean ascending) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (ascending) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                } else {
                    if (arr[j] < arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }

            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введiть розмiр масиву: ");
        int size = scanner.nextInt();

        System.out.print("Мiнiмальне значення: ");
        int min = scanner.nextInt();

        System.out.print("Максимальне значення: ");
        int max = scanner.nextInt();

        System.out.print("Оберiть тип сортування (1 - за зростанням, 2 - за спаданням): ");
        int choice = scanner.nextInt();

        boolean ascending = (choice == 1);

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }

        System.out.println("\nМасив до сортування:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        LocalTime start = LocalTime.now();

        bubbleSort(array, ascending);

        LocalTime end = LocalTime.now();

        Duration duration = Duration.between(start, end);

        System.out.println("\n\nМасив пiсля сортування:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("\n\nБуло вiдсортовано " + size + " елементiв за "
                + duration.toMillis() + " мс (" 
                + duration.toNanos() + " нс).");

        scanner.close();
    }
}
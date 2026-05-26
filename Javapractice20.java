import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Javapractice20 {

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

    public static void insertionSort(int[] arr, boolean ascending) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            if (ascending) {

                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }

            } else {

                while (j >= 0 && arr[j] < key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
            }

            arr[j + 1] = key;
        }
    }

    public static void selectionSort(int[] arr, boolean ascending) {

        for (int i = 0; i < arr.length - 1; i++) {

            int index = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (ascending) {

                    if (arr[j] < arr[index]) {
                        index = j;
                    }

                } else {

                    if (arr[j] > arr[index]) {
                        index = j;
                    }
                }
            }

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
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

        int[] bubbleArray = new int[size];
        int[] insertionArray = new int[size];
        int[] selectionArray = new int[size];

        for (int i = 0; i < size; i++) {
            bubbleArray[i] = array[i];
            insertionArray[i] = array[i];
            selectionArray[i] = array[i];
        }

        System.out.println("\nПочатковий масив:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        LocalTime start1 = LocalTime.now();
        bubbleSort(bubbleArray, ascending);
        LocalTime end1 = LocalTime.now();

        Duration duration1 = Duration.between(start1, end1);

        System.out.println("\n\nБульбашкове сортування:");

        for (int i = 0; i < bubbleArray.length; i++) {
            System.out.print(bubbleArray[i] + " ");
        }

        System.out.println("\nЧас: " + duration1.toMillis() +
                " мс (" + duration1.toNanos() + " нс)");

        LocalTime start2 = LocalTime.now();
        insertionSort(insertionArray, ascending);
        LocalTime end2 = LocalTime.now();

        Duration duration2 = Duration.between(start2, end2);

        System.out.println("\nСортування вставками:");

        for (int i = 0; i < insertionArray.length; i++) {
            System.out.print(insertionArray[i] + " ");
        }

        System.out.println("\nЧас: " + duration2.toMillis() +
                " мс (" + duration2.toNanos() + " нс)");

        LocalTime start3 = LocalTime.now();
        selectionSort(selectionArray, ascending);
        LocalTime end3 = LocalTime.now();

        Duration duration3 = Duration.between(start3, end3);

        System.out.println("\nСортування вибором:");

        for (int i = 0; i < selectionArray.length; i++) {
            System.out.print(selectionArray[i] + " ");
        }

        System.out.println("\nЧас: " + duration3.toMillis() +
                " мс (" + duration3.toNanos() + " нс)");

        scanner.close();
    }
}
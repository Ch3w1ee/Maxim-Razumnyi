import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

public class Javapractice22 {

    public static void mergeSort(int[] arr, int left, int right, boolean ascending) {

        if (left < right) {

            int middle = (left + right) / 2;

            mergeSort(arr, left, middle, ascending);
            mergeSort(arr, middle + 1, right, ascending);

            int[] temp = new int[arr.length];

            int i = left;
            int j = middle + 1;
            int k = left;

            while (i <= middle && j <= right) {

                if (ascending) {

                    if (arr[i] <= arr[j]) {
                        temp[k] = arr[i];
                        i++;
                    } else {
                        temp[k] = arr[j];
                        j++;
                    }

                } else {

                    if (arr[i] >= arr[j]) {
                        temp[k] = arr[i];
                        i++;
                    } else {
                        temp[k] = arr[j];
                        j++;
                    }
                }

                k++;
            }

            while (i <= middle) {
                temp[k] = arr[i];
                i++;
                k++;
            }

            while (j <= right) {
                temp[k] = arr[j];
                j++;
                k++;
            }

            for (i = left; i <= right; i++) {
                arr[i] = temp[i];
            }
        }
    }

    public static void countingSort(int[] arr, boolean ascending, int min, int max) {

        int[] count = new int[max - min + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        int index = 0;

        if (ascending) {

            for (int i = 0; i < count.length; i++) {

                while (count[i] > 0) {
                    arr[index] = i + min;
                    index++;
                    count[i]--;
                }
            }

        } else {

            for (int i = count.length - 1; i >= 0; i--) {

                while (count[i] > 0) {
                    arr[index] = i + min;
                    index++;
                    count[i]--;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int left, int right, boolean ascending) {

        int i = left;
        int j = right;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {

            if (ascending) {

                while (arr[i] < pivot) {
                    i++;
                }

                while (arr[j] > pivot) {
                    j--;
                }

            } else {

                while (arr[i] > pivot) {
                    i++;
                }

                while (arr[j] < pivot) {
                    j--;
                }
            }

            if (i <= j) {

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        if (left < j) {
            quickSort(arr, left, j, ascending);
        }

        if (i < right) {
            quickSort(arr, i, right, ascending);
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

        int[] mergeArray = new int[size];
        int[] countingArray = new int[size];
        int[] quickArray = new int[size];

        for (int i = 0; i < size; i++) {
            mergeArray[i] = array[i];
            countingArray[i] = array[i];
            quickArray[i] = array[i];
        }

        System.out.println("\nПочатковий масив:");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        LocalTime start1 = LocalTime.now();
        mergeSort(mergeArray, 0, mergeArray.length - 1, ascending);
        LocalTime end1 = LocalTime.now();

        Duration duration1 = Duration.between(start1, end1);

        System.out.println("\n\nСортування злиттям:");

        for (int i = 0; i < mergeArray.length; i++) {
            System.out.print(mergeArray[i] + " ");
        }

        System.out.println("\nЧас: " + duration1.toMillis()
                + " мс (" + duration1.toNanos() + " нс)");

        LocalTime start2 = LocalTime.now();
        countingSort(countingArray, ascending, min, max);
        LocalTime end2 = LocalTime.now();

        Duration duration2 = Duration.between(start2, end2);

        System.out.println("\n\nСортування пiдрахунком:");

        for (int i = 0; i < countingArray.length; i++) {
            System.out.print(countingArray[i] + " ");
        }

        System.out.println("\nЧас: " + duration2.toMillis()
                + " мс (" + duration2.toNanos() + " нс)");

        LocalTime start3 = LocalTime.now();
        quickSort(quickArray, 0, quickArray.length - 1, ascending);
        LocalTime end3 = LocalTime.now();

        Duration duration3 = Duration.between(start3, end3);

        System.out.println("\n\nШвидке сортування:");

        for (int i = 0; i < quickArray.length; i++) {
            System.out.print(quickArray[i] + " ");
        }

        System.out.println("\nЧас: " + duration3.toMillis()
                + " мс (" + duration3.toNanos() + " нс)");

        scanner.close();
    }
}
import java.util.Scanner;

class ArrayList {

    int[] data;
    int size;

    public ArrayList() {
        data = new int[5];
        size = 0;
    }

    public void add(int value) {

        if (size >= data.length) {

            int[] newData = new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }

            data = newData;
        }

        data[size] = value;
        size++;
    }

    public void addByIndex(int index, int value) {

        if (index < 0 || index > size) {
            System.out.println("Помилка: неправильний iндекс.");
            return;
        }

        if (size >= data.length) {

            int[] newData = new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }

            data = newData;
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        size++;
    }

    public void removeByIndex(int index) {

        if (index < 0 || index >= size) {
            System.out.println("Помилка: неправильний iндекс.");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
    }

    public int get(int index) {

        if (index < 0 || index >= size) {
            System.out.println("Помилка: неправильний iндекс.");
            return -1;
        }

        return data[index];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public void printList() {

        if (size == 0) {
            System.out.println("Перелiк масивiв порожнiй.");
            return;
        }

        System.out.print("Елементи: ");

        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println();
    }
}

public class Javapractice18 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList list = new ArrayList();

        while (true) {

            System.out.println("\n1 - Додати в кiнець");
            System.out.println("2 - Додати за iндексом");
            System.out.println("3 - Видалити за iндексом");
            System.out.println("4 - Отримати елемент");
            System.out.println("5 - Кiлькiсть елементiв");
            System.out.println("6 - Розмiр буфера");
            System.out.println("7 - Вивести перелiк");
            System.out.println("0 - Вихiд");

            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Введiть число: ");
                int value = sc.nextInt();

                list.add(value);

            } else if (choice == 2) {

                System.out.print("Введiть iндекс: ");
                int index = sc.nextInt();

                System.out.print("Введiть число: ");
                int value = sc.nextInt();

                list.addByIndex(index, value);

            } else if (choice == 3) {

                System.out.print("Введiть iндекс: ");
                int index = sc.nextInt();

                list.removeByIndex(index);

            } else if (choice == 4) {

                System.out.print("Введiть iндекс: ");
                int index = sc.nextInt();

                System.out.println("Елемент: " + list.get(index));

            } else if (choice == 5) {

                System.out.println("Кiлькiсть елементiв: " + list.getSize());

            } else if (choice == 6) {

                System.out.println("Розмiр буфера: " + list.getCapacity());

            } else if (choice == 7) {

                list.printList();

            } else if (choice == 0) {

                System.out.println("Програма завершена.");
                break;

            } else {

                System.out.println("Неправильна команда.");
            }
        }

        sc.close();
    }
}
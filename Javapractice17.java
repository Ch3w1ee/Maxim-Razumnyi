import java.util.Scanner;

class List {
    int[] elements;
    int count;

    public List() {
        elements = new int[5];
        count = 0;
    }

    public void addToEnd(int value) {
        if (count == elements.length) {
            int[] temp = new int[elements.length * 2];

            for (int i = 0; i < elements.length; i++) {
                temp[i] = elements[i];
            }

            elements = temp;
        }

        elements[count] = value;
        count++;
    }

    public void addByIndex(int index, int value) {
        if (index < 0 || index > count) {
            System.out.println("Неправильний індекс");
            return;
        }

        if (count == elements.length) {
            int[] temp = new int[elements.length * 2];

            for (int i = 0; i < elements.length; i++) {
                temp[i] = elements[i];
            }

            elements = temp;
        }

        for (int i = count; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = value;
        count++;
    }

    public void removeByIndex(int index) {
        if (index < 0 || index >= count) {
            System.out.println("Неправильний індекс");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            elements[i] = elements[i + 1];
        }

        count--;
    }

    public int getElement(int index) {
        if (index < 0 || index >= count) {
            System.out.println("Неправильний індекс");
            return -1;
        }

        return elements[index];
    }

    public int getSize() {
        return count;
    }

    public int getBufferSize() {
        return elements.length;
    }

    public void showList() {
        if (count == 0) {
            System.out.println("Список порожній");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.print(elements[i] + " ");
        }

        System.out.println();
    }
}

public class Javapractice17 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List list = new List();

        while (true) {

            System.out.println("\n1 - Додати в кінець");
            System.out.println("2 - Додати за індексом");
            System.out.println("3 - Видалити за індексом");
            System.out.println("4 - Отримати елемент");
            System.out.println("5 - Кількість елементів");
            System.out.println("6 - Розмір буфера");
            System.out.println("7 - Вивести список");
            System.out.println("0 - Вихід");

            int choice = sc.nextInt();

            if (choice == 1) {

                int value = sc.nextInt();
                list.addToEnd(value);

            } else if (choice == 2) {

                int index = sc.nextInt();
                int value = sc.nextInt();

                list.addByIndex(index, value);

            } else if (choice == 3) {

                int index = sc.nextInt();
                list.removeByIndex(index);

            } else if (choice == 4) {

                int index = sc.nextInt();
                System.out.println(list.getElement(index));

            } else if (choice == 5) {

                System.out.println(list.getSize());

            } else if (choice == 6) {

                System.out.println(list.getBufferSize());

            } else if (choice == 7) {

                list.showList();

            } else if (choice == 0) {

                break;
            }
        }

        sc.close();
    }
}
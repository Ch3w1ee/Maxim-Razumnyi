import java.util.Scanner;

public class Javapractice14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int MAX = 50;

        String[] dates = new String[MAX];
        String[] texts = new String[MAX];

        int count = 0;

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1 - Додати запис");
            System.out.println("2 - Видалити запис за датою");
            System.out.println("3 - Переглянути всi записи");
            System.out.println("0 - Вийти");

            int choice = sc.nextInt();
            sc.nextLine(); // очистка буфера

            if (choice == 1) {
                if (count >= MAX) {
                    System.out.println("Щоденник заповнений!");
                    continue;
                }

                System.out.print("Введiть дату (наприклад 2026-03-23): ");
                String date = sc.nextLine();

                System.out.println("Введiть текст запису:");
                String text = sc.nextLine();

                dates[count] = date;
                texts[count] = text;
                count++;

                System.out.println("Запис додано!");

            } else if (choice == 2) {
                System.out.print("Введiть дату для видалення: ");
                String dateToDelete = sc.nextLine();

                boolean found = false;

                for (int i = 0; i < count; i++) {
                    if (dates[i].equals(dateToDelete)) {
                        // сдвиг массива
                        for (int j = i; j < count - 1; j++) {
                            dates[j] = dates[j + 1];
                            texts[j] = texts[j + 1];
                        }
                        count--;
                        found = true;
                        System.out.println("Запис видалено!");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Запис не знайдено!");
                }

            } else if (choice == 3) {
                if (count == 0) {
                    System.out.println("Щоденник порожнiй.");
                } else {
                    for (int i = 0; i < count; i++) {
                        System.out.println("\nДата: " + dates[i]);
                        System.out.println("Текст: " + texts[i]);
                    }
                }

            } else if (choice == 0) {
                System.out.println("Вихiд...");
                break;

            } else {
                System.out.println("Некоректний вибiр!");
            }
        }

        sc.close();
    }
}